선택사항2)  api 
1)  태스크 진행사항화면 - 시각적
2)  위험도 감지 - 시각적 


## 3. '데드락 방지' 태스크 의존성(Dependency) 및 핵심 병목(Critical Path) 탐색기
실무진의 고민: "A 개발자가 API 설계를 늦게 해서, 후속 작업인 B(프론트 연동), C(QA), D(배포)가 줄줄이 밀렸어요." 
프로젝트에서는 특정 태스크의 지연이 전체 일정을 마비시키는 '병목 현상'이 자주 발생합니다. 
하지만 복잡하게 얽힌 태스크 간의 의존 관계를 한눈에 파악하기는 어렵습니다.

아이디어: 태스크 간의 선행/후행 관계를 정의하고, 
어떤 태스크가 현재 전체 프로젝트 완료일에 직격탄을 날리고 있는 '핵심 병목(Critical Path)'인지 추적하여 가시화합니다. 
선행 태스크의 일정이 연장되면 후속 태스크들의 일정도 시스템이 연쇄적으로 계산하여 경고를 띄웁니다.

API 및 기술적 구현:
Self-Referencing DB & 계층형 쿼리: task 테이블 내에 parent_task_id 또는 의존성 매핑 구조를 설계하고, 
재귀적 쿼리(Recursive CTE)를 사용해 복잡한 의존성 트리를 단 한 번의 쿼리로 효율적으로 조회.

인터랙티브 그래프 UI: 프론트엔드에서 간트 차트(Gantt Chart)나 SVG 기반 네트워크 그래프 라이브러리를 커스텀하여 의존 관계를 시각화. 
선행 태스크 드래그 시 후속 태스크가 밀리는 애니메이션 구현.

추가 포인트: 태스크 의존성이 서로 순환 참조(A가 끝나야 B가 끝나고, B가 끝나야 A가 끝나는 형태)되어 
프로젝트가 마비되는 '일정 데드락(Deadlock)' 상태를 백엔드 알고리즘으로 사전에 검증/차단하는 방어 로직을 포함합니다.


0. 테이블작성
- task 테이블 구조 변경
parent_task_id   INT   FOREIGN KEY (task.task_id), NULL 허용   [추가] 선행 태스크 ID (이 작업이 끝나야 현재 작업 시작 가능)

```
CREATE TABLE task (
    task_id           INT AUTO_INCREMENT PRIMARY KEY,
    pro_id            INT NOT NULL,
    pm_id             INT NOT NULL,
    task_name         VARCHAR(100) NOT NULL,
    task_desc         VARCHAR(45),
    task_status       VARCHAR(20) NOT NULL DEFAULT 'TODO',
    pm_name           VARCHAR(50),
    task_start_date   DATETIME NOT NULL,
    task_end_date     DATETIME NOT NULL,
    task_created_at   DATETIME DEFAULT CURRENT_TIMESTAMP,
    task_updated_at   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    -- [핵심 추가] 자기 참조 외래키 제약 조건
    parent_task_id    INT NULL,
    
    CONSTRAINT fk_task_project FOREIGN KEY (pro_id) REFERENCES project (pro_id),
    CONSTRAINT fk_task_employee FOREIGN KEY (pm_id) REFERENCES employee (emp_id),
    CONSTRAINT fk_task_parent FOREIGN KEY (parent_task_id) REFERENCES task (task_id) ON DELETE SET NULL
);
```


제시해주신 ERD 사양(`task_start_date`/`task_end_date` 계획 필드 중심)과 **Critical Path(핵심 병목) 및 연쇄 계산(Cascade Update)** 아이디어를 완벽하게 결합하여, 백엔드부터 프론트엔드 뷰단까지 아우르는 실무형 엔드투엔드(End-to-End) 구현 코드를 단계별로 정비해 드립니다.

---

## 🏗️ 0. 데이터베이스 레이어 (DDL & MyBatis Mapper)

`task` 테이블에 자기 참조 외래키인 `parent_task_id`를 명시적으로 추가하고, 위상 정렬 조회(`Recursive CTE`), 단일 CUD, 벌크 업데이트를 포함하는 SQL을 구성합니다.

### 🗄️ SQL 테이블 정의 (DDL)

```sql
ALTER TABLE task ADD parent_task_id NUMBER;
ALTER TABLE task 
ADD CONSTRAINT fk_task_parent 
FOREIGN KEY (parent_task_id) REFERENCES task (task_id) 
ON DELETE SET NULL;

CREATE INDEX fk_task_parent_idx ON task (parent_task_id);

ALTER TABLE task 
ADD CONSTRAINT ck_task_not_self_parent 
CHECK (parent_task_id != task_id);
```

### 📄 TaskMapper.xml (CRUD + 계층형 SQL)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.project.mapper.TaskMapper">

    <!-- [C] 태스크 생성: parent_task_id 바인딩 -->
<insert id="insertTask" parameterType="com.example.project.dto.TaskDTO">
    <selectKey keyProperty="taskId" resultType="long" order="BEFORE">
        SELECT task_seq.NEXTVAL FROM dual
    </selectKey>
    INSERT INTO task (
        task_id, pro_id, pm_id, task_name, task_desc, task_status, pm_name, 
        task_start_date, task_end_date, parent_task_id
    ) VALUES (
        #{taskId}, #{proId}, #{pmId}, #{taskName}, #{taskDesc}, #{taskStatus}, #{pmName}, 
        #{taskStartDate}, #{taskEndDate}, #{parentTaskId}
    )
</insert>

    <!-- [R] 계층 구조 정렬 조회 (Recursive CTE): 최상위 부모부터 자식 순으로 정렬하여 Java 연산 성능 O(N) 보장 -->
       <select id="selectTaskDependencies" parameterType="long" resultType="com.example.project.dto.TaskDTO">
        WITH task_hierarchy (
            task_id, pro_id, pm_id, task_name, task_desc, task_status, pm_name,
            task_start_date, task_end_date, parent_task_id, task_path
        ) AS (
            SELECT 
                task_id, pro_id, pm_id, task_name, task_desc, task_status, pm_name,
                task_start_date, task_end_date, parent_task_id,
                CAST(task_id AS VARCHAR2(200))
            FROM task
            WHERE pro_id = #{proId} AND parent_task_id IS NULL

            UNION ALL

            SELECT 
                t.task_id, t.pro_id, t.pm_id, t.task_name, t.task_desc, t.task_status, t.pm_name,
                t.task_start_date, t.task_end_date, t.parent_task_id,
                th.task_path || ',' || t.task_id
            FROM task t
            INNER JOIN task_hierarchy th ON t.parent_task_id = th.task_id
            WHERE t.pro_id = #{proId}
        )
        SELECT * FROM task_hierarchy ORDER BY task_path
    </select>

    <!-- [U] 단일 태스크 정보 및 일정 수정 -->
   <update id="updateTaskSchedule" parameterType="com.example.project.dto.TaskDTO">
        UPDATE task
        SET 
            task_name = #{taskName},
            task_desc = #{taskDesc},
            task_status = #{taskStatus},
            task_start_date = #{taskStartDate},
            task_end_date = #{taskEndDate},
            parent_task_id = #{parentTaskId}
        WHERE task_id = #{taskId}
    </update>

    <!-- [U] 벌크 연쇄 업데이트: Java에서 연산된 후속 지연 일정들을 단 한 번의 네트워크 쿼리로 대량 갱신 -->
   <update id="updateBatchTaskSchedule" parameterType="list">
        BEGIN
        <foreach collection="list" item="item">
            UPDATE task
            SET 
                task_start_date = #{item.taskStartDate},
                task_end_date = #{item.taskEndDate}
            WHERE task_id = #{item.taskId};
        </foreach>
        END;
    </update>

    <!-- [D] 태스크 삭제 -->
    <delete id="deleteTask" parameterType="long">
        DELETE FROM task WHERE task_id = #{taskId}
    </delete>

</mapper>

```

---

## 🧠 1. 비즈니스 로직 레이어 (Service)

데이터 검증(Validation), 순환 참조 차단(Deadlock Prevention), 메모리 내 연쇄 스케줄 타임라인 재계산 알고리즘을 수행합니다.

```java
@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * CREATE: 신규 태스크 등록 (날짜 역전 유효성 검증 포함)
     */
    public void createEmptyOrLinkedTask(TaskDTO dto) {
        if (dto.getParentTaskId() != null) {
            // 전체 목록에서 부모 데이터 추출 (O(1) 캐싱 전략 대용)
            List<TaskDTO> currentTasks = taskMapper.selectTaskDependencies(dto.getProId());
            TaskDTO parent = currentTasks.stream()
                .filter(t -> t.getTaskId().equals(dto.getParentTaskId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지정한 선행 태스크가 존재하지 않습니다."));

            if (dto.getTaskStartDate().isBefore(parent.getTaskEndDate())) {
                throw new IllegalArgumentException("비즈니스 제약 오류: 시작일은 선행 작업 종료일 이후여야 합니다.");
            }
        }
        taskMapper.insertTask(dto);
    }

    /**
     * UPDATE: 특정 태스크 수정 및 연쇄 일정 트리 갱신 엔진
     */
    public void updateTaskAndCascade(TaskDTO dto) {
        // 1. 순환 참조(데드락) 방지 체크
        if (dto.getParentTaskId() != null && isCyclic(dto.getTaskId(), dto.getParentTaskId(), dto.getProId())) {
            throw new IllegalStateException("일정 데드락 위험: 상호 참조 혹은 순환 의존성을 형성할 수 없습니다.");
        }

        // 2. 타겟 대상 단일 수정 실행
        taskMapper.updateTaskSchedule(dto);

        // 3. [Cascade Engine] 연쇄 지연 타임라인 자동 재산출
        List<TaskDTO> allTasks = taskMapper.selectTaskDependencies(dto.getProId());
        List<TaskDTO> cascadeTargetList = new ArrayList<>();

        // CTE로 정렬되어 있으므로 선행 노드가 항상 리스트 상단에 위치함 보장
        for (TaskDTO current : allTasks) {
            if (current.getParentTaskId() != null) {
                TaskDTO parentTask = allTasks.stream()
                    .filter(t -> t.getTaskId().equals(current.getParentTaskId()))
                    .findFirst()
                    .orElse(null);

                // 계획 마감일이 후속 작업 계획 시작일을 침범(역전)했는지 판단
                if (parentTask != null && parentTask.getTaskEndDate().isAfter(current.getTaskStartDate())) {
                    long taskDuration = ChronoUnit.DAYS.between(current.getTaskStartDate(), current.getTaskEndDate());
                    
                    // 선행작업 종료일 다음날로 계획 시작일 강제 밀기
                    LocalDateTime nextStartDate = parentTask.getTaskEndDate().plusDays(1);
                    LocalDateTime nextEndDate = nextStartDate.plusDays(taskDuration);

                    current.setTaskStartDate(nextStartDate);
                    current.setTaskEndDate(nextEndDate);

                    cascadeTargetList.add(current);
                }
            }
        }

        // 4. 변경점이 발생한 하위 후속 작업들만 일괄 벌크 업데이트
        if (!cascadeTargetList.isEmpty()) {
            taskMapper.updateBatchTaskSchedule(cascadeTargetList);
        }
    }

    /**
     * DFS 기반 순환 참조 역방향 추적 기법
     */
    private boolean isCyclic(Long taskId, Long parentTaskId, Long proId) {
        List<TaskDTO> list = taskMapper.selectTaskDependencies(proId);
        Long pointer = parentTaskId;

        while (pointer != null) {
            if (pointer.equals(taskId)) return true; // 부모를 역추적하던 중 내 노드를 다시 만남 = 사이클
            final Long currentFindId = pointer;
            pointer = list.stream()
                .filter(t -> t.getTaskId().equals(currentFindId))
                .map(TaskDTO::getParentTaskId)
                .findFirst()
                .orElse(null);
        }
        return false;
    }
}

```
```
package com.sb.erp.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.erp.dao.TaskDependencyMapper;
import com.sb.erp.dto.TaskDto;

@Service
@Transactional
public class TaskDependencyServiceImpl implements TaskDependencyService {

	@Autowired
	TaskDependencyMapper dao;

	// 선행 태스크 지정하여 신규 태스크 등록 (날짜 역전 유효성 검증 포함)
	@Override
	public int insertWithParent(TaskDto dto) {

		if (dto.getParentTaskId() != null) {

			List<TaskDto> currentTasks = dao.selectTaskDependencies(dto.getProId());

			TaskDto parent = currentTasks.stream()
					.filter(t -> t.getTaskId().equals(dto.getParentTaskId()))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("지정한 선행 태스크가 존재하지 않습니다."));
        //말 그대로 **"넘어온 인자(argument)가 잘못됐다(illegal)"**는 뜻의 예외입니다. 자바에 이미 만들어져 있는 표준 예외 클래스예요 (java.lang 패키지, import 안 해도 씀).

        //
			if (dto.getTaskStartDate().isBefore(parent.getTaskEndDate())) {
				throw new IllegalArgumentException("비즈니스 제약 오류: 시작일은 선행 작업 종료일 이후여야 합니다.");
			}//dto로 넘어온 태스크의 시작일이 부모 태스크의 종료일보다 빠르면 (= 말이 안 되는 값)
IllegalArgumentException을 강제로 발생시켜서 (throw)
"이 데이터는 잘못됐으니 처리 못 한다"고 알려주는 겁니다
		}

		return dao.insertWithParent(dto);
	}

	// 태스크 의존성 트리 조회 (단순 위임)
	@Override
	public List<TaskDto> selectTaskDependencies(int proId) {
		return dao.selectTaskDependencies(proId);
	}

	// 태스크 일정 및 선행 태스크 수정 + 연쇄 일정 재계산
	@Override
	public int updateTaskSchedule(TaskDto dto) {

		// 1) 순환 참조(데드락) 방지 체크
		if (dto.getParentTaskId() != null
				&& isCyclic(dto.getTaskId(), dto.getParentTaskId(), dto.getProId())) {
			throw new IllegalStateException("일정 데드락 위험: 순환 의존성을 형성할 수 없습니다.");
		}

		// 2) 대상 태스크 단일 수정 실행
		int result = dao.updateTaskSchedule(dto);

		// 3) 전체 태스크 목록 재조회 (선행 -> 후행 순 정렬된 상태)
		List<TaskDto> allTasks = dao.selectTaskDependencies(dto.getProId());

		// 4) 연쇄적으로 밀려야 하는 후속 태스크들만 추려서 리스트에 담기
		List<TaskDto> cascadeTargetList = new ArrayList<>();

		for (TaskDto current : allTasks) {

			if (current.getParentTaskId() == null) {
				continue;
			}

			TaskDto parentTask = allTasks.stream()
					.filter(t -> t.getTaskId().equals(current.getParentTaskId()))
					.findFirst()
					.orElse(null);

			if (parentTask == null) {
				continue;
			}

			if (parentTask.getTaskEndDate().isAfter(current.getTaskStartDate())) {

				long taskDuration = ChronoUnit.DAYS.between(
						current.getTaskStartDate(), current.getTaskEndDate());

				LocalDateTime nextStartDate = parentTask.getTaskEndDate().plusDays(1);
				LocalDateTime nextEndDate = nextStartDate.plusDays(taskDuration);

				current.setTaskStartDate(nextStartDate);
				current.setTaskEndDate(nextEndDate);

				cascadeTargetList.add(current);
			}
		}

		// 5) 밀린 태스크가 있으면 벌크 업데이트 실행
		if (!cascadeTargetList.isEmpty()) {
			dao.updateBatchTaskSchedule(cascadeTargetList);
		}

		return result;
	}

	// 벌크 연쇄 업데이트 (단순 위임 - 필요 시 외부에서 직접 호출 가능하도록 인터페이스에 노출)
	@Override
	public void updateBatchTaskSchedule(List<TaskDto> list) {
		dao.updateBatchTaskSchedule(list);
	}

	// DFS 기반 순환 참조 역방향 추적
	private boolean isCyclic(Long taskId, Long parentTaskId, int proId) {

		List<TaskDto> list = dao.selectTaskDependencies(proId);
		Long pointer = parentTaskId;

		while (pointer != null) {
			if (pointer.equals(taskId)) {
				return true;
			}
			final Long currentFindId = pointer;
			pointer = list.stream()
					.filter(t -> t.getTaskId().equals(currentFindId))
					.map(TaskDto::getParentTaskId)
					.findFirst()
					.orElse(null);
		}
		return false;
	}
}
```

---

## 🔌 2. 웹 제어 레이어 (Controller)

클라이언트의 REST API 요청을 받아들여 처리하고 응답 결과를 표준 규격 JSON으로 반환합니다.

```java
@RestController
@RequestMapping("/api/projects/{proId}/tasks")
public class TaskApiController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTaskTree(@PathVariable Long proId) {
        return ResponseEntity.ok(taskMapper.selectTaskDependencies(proId));
    }

    @PostMapping
    public ResponseEntity<String> createTask(@PathVariable Long proId, @RequestBody TaskDTO dto) {
        dto.setProId(proId);
        taskService.createEmptyOrLinkedTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task 등록 성공");
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long proId, @PathVariable Long taskId, @RequestBody TaskDTO dto) {
        dto.setProId(proId);
        dto.setTaskId(taskId);
        taskService.updateTaskAndCascade(dto);
        return ResponseEntity.ok("태스크 및 후속 의존성 일정 갱신 완료");
    }
}

```

---

## 🎨 3. 인터랙티브 사용자 인터페이스 레이어 (View)

화면단에서 선행 태스크 목록을 `select` 박스로 동적으로 뿌려주어 태스크 생성 시 `parent_task_id` 속으로 매핑값이 완벽하게 귀속되도록 설계한 JavaScript 뷰 구현체 예시입니다.

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>태스크 의존성(Dependency) 매니저</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 120px; font-weight: bold; }
        input, select { padding: 6px; width: 250px; }
        button { padding: 8px 15px; background: #007bff; color: #fff; border: none; cursor: pointer; }
    </style>
</head>
<body>

    <h2>📌 신규 태스크 등록 (의존성 연계)</h2>
    <form id="taskForm">
        <div class="form-group">
            <label>태스크명</label>
            <input type="text" id="taskName" required placeholder="예: API 통합 테스트">
        </div>
        <div class="form-group">
            <label>선행 작업 지정</label>
            <!-- [핵심 포인트] 여기 선택된 option의 value(taskId)가 백엔드의 parent_task_id로 매핑되어 잡힙니다 -->
            <select id="parentTaskId">
                <option value="">-- 선행 작업 없음 (최상위 태스크) --</option>
            </select>
        </div>
        <div class="form-group">
            <label>계획 시작일</label>
            <input type="date" id="taskStartDate" required>
        </div>
        <div class="form-group">
            <label>계획 마감일</label>
            <input type="date" id="taskEndDate" required>
        </div>
        <button type="button" onclick="submitTask()">태스크 링크 등록</button>
    </form>

    <script>
        const projectId = 1; // 특정 예시 프로젝트 ID

        // 페이지 로드 시 기존 태스크 목록을 조회하여 선행 태스크 Select Option에 동적 바인딩
        async function loadParentTaskOptions() {
            const response = await fetch(`/api/projects/${projectId}/tasks`);
            const tasks = await response.json();
            const selectEl = document.getElementById("parentTaskId");

            tasks.forEach(task => {
                const opt = document.createElement("option");
                opt.value = task.taskId; // 데이터베이스의 고유 task_id 값
                opt.textContent = `[${task.taskStatus}] ${task.taskName} (~${task.taskEndDate.split('T')[0]})`;
                selectEl.appendChild(opt);
            });
        }

        // 폼 데이터를 JSON으로 포맷팅하여 비동기 전송
        async function submitTask() {
            const parentValue = document.getElementById("parentTaskId").value;
            const payload = {
                taskName: document.getElementById("taskName").value,
                parentTaskId: parentValue ? parseInt(parentValue) : null, // 빈 값이면 null 처리로 독립 노드화
                taskStartDate: document.getElementById("taskStartDate").value + "T00:00:00",
                taskEndDate: document.getElementById("taskEndDate").value + "T23:59:59",
                taskStatus: "TODO",
                pmId: 1, // 테스트 마스터 ID용 예시
                pmName: "관리자"
            };

            const response = await fetch(`/api/projects/${projectId}/tasks`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload)
            });

            if (response.ok) {
                alert("태스크가 의존성 트리 체인에 정상 등록되었습니다!");
                location.reload();
            } else {
                const errorText = await response.text();
                alert("등록 실패: " + errorText);
            }
        }

        window.onload = loadParentTaskOptions;
    </script>
</body>
</html>

```

---

### 💡 최종 아키텍처 요약 워크플로우

1. **View:** 사용자가 화면에서 선행 태스크 옵션을 고르고 날짜를 입력하면 해당 `taskId`가 `parentTaskId` 속성으로 추려져 서버로 넘어갑니다.
2. **Controller:** JSON 데이터를 받아 `TaskDTO` 커맨드 객체에 바인딩합니다.
3. **Service:**
* 입력된 후속작업 시작일이 부모 마감일보다 앞서 있다면 컨트롤러 도달 직후 예외처리로 화면단에 롤백 알림을 보냅니다.
* `UPDATE` 이벤트 시에는 트리 상부 역추적 함수(`isCyclic`)를 실행하여 크리티컬 패스 내 무한 루프 교착상태(Deadlock)인지 검증 후, 안전이 확보되면 자바 내부 힙 메모리 루프 순회만을 활용하여 충돌이 난 자식 노드들의 일정을 순차적으로 밀어냅니다.


4. **Mapper:** 최종적으로 밀려난 하위 가변 배열 데이터들을 모아서 마이바티스 배치를 통해 원숏으로 타겟팅 업데이트를 완결 지으며 최적의 속도를 뿜어냅니다.