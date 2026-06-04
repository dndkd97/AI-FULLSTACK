day046

 - Todo : spring

---

-STEP1 dataSource - ■SimpleDriverDataSource : setter
-STEP2 mybatis 
	 ■1.SqlSessionFactoryBean : 스프링에서 SqlSession 객체들을 생성 및 관리
	 
	  private Resource configLocation;      - 설정파일
	  private Resource[] mapperLocations;	- mapper.xml (sql)
	  private DataSource dataSource;		- db연동
  
	 ■2.SqlSessionTemplate    : sql 구문처리(insert,update,delete,select)
-3.Mapper : MapperFactoryBean

---------------------
#4.   DB  + Mybatis
---------------------
1. DataSource
+ SimpleDrdiverDataSource   - 가장단순한버젼

2. mybatis
- sql을 별도로 파일분리해서 관리
- orm (object relational mapping) 프레임워크

3. 설정내용
root-context.xml   환경정보설정
db.propertis       db정보설정
SqlSessionFacotryBean  : SqlSession 생성 및 관리
SqlSession           :  sql 실행 , 트랜잭션
mapper.xml


-----------------------------
#5.   MVC
-----------------------------
▶STEP1. MVC
>> 서로 영향없이 쉽게 고칠수 있는 애플리케이션을 만들수 있음.
- MODEL   데이터 ( dto, dao, service )
- VIEW      화면   ( html, css, js/jquery)
- Controller 비지니스로직

▶STEP2. MVC1  vs  MVC2
1. MVC1 -   Controller 의 역할 jsp 담당
2. MVC2 -   Controller 의 역할 servlet 담당

▶STEP3. SPRING MVC
--------FrontController
            /list.do              BList           /board/list.jsp
[클라이언트] → [FrontController]  → 세부Controller → View
                              → 세부Controller → View
                              → 세부Controller → View
1. FrontController  공통작업수행
2. 세부Controller  View에 최종결과 생성
   
--------SPRING MVC
[클라이언트] 
↓  ① /list.do
               [FrontController] 
               <<DispatcherServlet>>  ② Handler Mapping   @Controller
                           ↓ 위임      
                        ★③세부Controller   
                        ← ④ 
               ⑥↑↓ ⑤   
                View
① 클라이언트 요청  ( 코요테/ web.xml 
         - spring관련: root-context.xml,servlet-context.xml )
② DispatcherServlet - Handler Mapping을 사용해서 처리할 Controller확인
③ 세부Controller  클라이언트 요청처리 ( service - 비지니스로직 )
④ 요청결과와 View정보를 DispatcherServlet에게 줌
⑤ DispatcherServlet는 ViewResolver로 부터 응답결과를 생성할 View객체 생성
⑥ View 응답생성 - response




[실습]
1)view.zip 다운로드
2)servlet-context.xml 확인 - /view/ 폴더 안에 압축풀기
   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
   <property name="prefix" value="/view/"></property>
   <property name="suffix" value=".jsp"></property>
   </bean>
3)com.the703.controller
- BoardController
 ■RequestMapping경로       ■해당 view 설정
/board/list.do            /view/board/list.jsp 
/board/write.do           /view/board/write.jsp    (글쓰기폼)
/board/detail.do          /view/board/detailjsp    (상세보기)
/board/edit.do            /view/board/edit.jsp     (수정하기폼)
/board/delete.do          /view/board/delete.jsp   (삭제하기폼)
