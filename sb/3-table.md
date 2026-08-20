-- ============================================
-- 채용공고
-- ============================================

CREATE TABLE recruit (
    rec_id                 NUMBER(10)      NOT NULL,
    com_id                 NUMBER(10)      NOT NULL,
    emp_id                 NUMBER(10)      NOT NULL,
    rec_title              VARCHAR2(200)   NOT NULL,
    rec_department         VARCHAR2(100),
    rec_position           VARCHAR2(100),
    rec_headcount          NUMBER,
    rec_employment_type    VARCHAR2(50),
    rec_description        CLOB,
    rec_start_date         DATE,
    rec_end_date           DATE,
    rec_status             VARCHAR2(20)    DEFAULT 'OPEN' NOT NULL,
    created_at             DATE            DEFAULT SYSDATE NOT NULL,
    updated_at             DATE            DEFAULT SYSDATE NOT NULL,

    CONSTRAINT pk_recruit PRIMARY KEY (rec_id),
    CONSTRAINT fk_recruit_com FOREIGN KEY (com_id) REFERENCES company(com_id),
    CONSTRAINT fk_recruit_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    CONSTRAINT ck_recruit_status CHECK (rec_status IN ('OPEN', 'CLOSED', 'CANCELLED'))
);

CREATE SEQUENCE seq_recruit START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_recruit_pk
BEFORE INSERT ON recruit
FOR EACH ROW
BEGIN
    IF :NEW.rec_id IS NULL THEN
        :NEW.rec_id := seq_recruit.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_recruit_bu
BEFORE UPDATE ON recruit
FOR EACH ROW
BEGIN
    :NEW.updated_at := SYSDATE;
END;
/


-- ============================================
-- 지원자 등록/관리
-- ============================================

CREATE TABLE applicant (
    apct_id         NUMBER(10)      NOT NULL,
    com_id          NUMBER(10)      NOT NULL,
    rec_id          NUMBER(10)      NOT NULL,
    apct_name       VARCHAR2(50)    NOT NULL,
    apct_email      VARCHAR2(100)   NOT NULL,
    apct_phone      VARCHAR2(20)    NOT NULL,
    apct_status     VARCHAR2(20)    DEFAULT 'RECEIVED' NOT NULL,
    apct_date       DATE            DEFAULT SYSDATE,
    created_at      DATE            DEFAULT SYSDATE NOT NULL,
    updated_at      DATE            DEFAULT SYSDATE NOT NULL,

    CONSTRAINT pk_applicant PRIMARY KEY (apct_id),
    CONSTRAINT fk_applicant_com FOREIGN KEY (com_id) REFERENCES company(com_id),
    CONSTRAINT fk_applicant_recruit FOREIGN KEY (rec_id) REFERENCES recruit(rec_id),
    CONSTRAINT ck_applicant_status
        CHECK (
            apct_status IN (
                'RECEIVED',
                'SCREENING',
                'INTERVIEW',
                'HIRED',
                'REJECTED'
            )
        )
);

CREATE SEQUENCE seq_applicant START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_applicant_pk
BEFORE INSERT ON applicant
FOR EACH ROW
BEGIN
    IF :NEW.apct_id IS NULL THEN
        :NEW.apct_id := seq_applicant.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_applicant_bu
BEFORE UPDATE ON applicant
FOR EACH ROW
BEGIN
    :NEW.updated_at := SYSDATE;
END;
/

CREATE INDEX fk_applicant_recruit_idx ON applicant(rec_id);
CREATE INDEX idx_applicant_status ON applicant(apct_status);
CREATE INDEX idx_recruit_com_id ON recruit(com_id);


-- ============================================
-- 이력서
-- ============================================

CREATE TABLE resume (
    rsm_id              NUMBER(10)      NOT NULL,
    apct_id             NUMBER(10)      NOT NULL,
    rsm_file_name       VARCHAR2(200),
    rsm_file_url        VARCHAR2(500),
    rsm_extracted_text  CLOB,
    rsm_ai_summary      CLOB,
    rsm_fit_score       NUMBER,
    rsm_status          VARCHAR2(20)    DEFAULT 'PENDING' NOT NULL,
    rsm_uploaded_at     DATE            DEFAULT SYSDATE NOT NULL,
    rsm_analyzed_at     DATE,

    CONSTRAINT pk_resume PRIMARY KEY (rsm_id),
    CONSTRAINT fk_resume_applicant FOREIGN KEY (apct_id) REFERENCES applicant(apct_id),
    CONSTRAINT ck_resume_status CHECK (rsm_status IN ('PENDING', 'COMPLETED', 'FAILED'))
);

CREATE SEQUENCE seq_resume START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_resume_pk
BEFORE INSERT ON resume
FOR EACH ROW
BEGIN
    IF :NEW.rsm_id IS NULL THEN
        :NEW.rsm_id := seq_resume.NEXTVAL;
    END IF;
END;
/


-- ============================================
-- 이력서 청크 + 임베딩
-- ============================================

CREATE TABLE resume_chunk (
    chunk_id         NUMBER(10)      NOT NULL,
    rsm_id           NUMBER(10)      NOT NULL,
    chunk_order      NUMBER          NOT NULL,
    chunk_text       CLOB            NOT NULL,
    chunk_embedding  CLOB            NOT NULL,

    CONSTRAINT pk_resume_chunk PRIMARY KEY (chunk_id),
    CONSTRAINT fk_chunk_resume FOREIGN KEY (rsm_id) REFERENCES resume(rsm_id)
);

CREATE SEQUENCE seq_resume_chunk START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_resume_chunk_pk
BEFORE INSERT ON resume_chunk
FOR EACH ROW
BEGIN
    IF :NEW.chunk_id IS NULL THEN
        :NEW.chunk_id := seq_resume_chunk.NEXTVAL;
    END IF;
END;
/

CREATE INDEX fk_chunk_resume_idx ON resume_chunk(rsm_id);

//////////// 주석 버전 ////////////
-- ============================================
-- 채용공고
-- ============================================

CREATE TABLE recruit (
    rec_id                 NUMBER(10)      NOT NULL,                      -- PK, 시퀀스 자동 채번
    com_id                 NUMBER(10)      NOT NULL,                      -- 회사 FK
    emp_id                 NUMBER(10)      NOT NULL,                      -- 담당자(직원) FK
    rec_title              VARCHAR2(200)   NOT NULL,                      -- 공고 제목
    rec_department         VARCHAR2(100)   NOT NULL,                      -- 모집 부서
    rec_position           VARCHAR2(100)   NOT NULL,                      -- 모집 직무
    rec_headcount          NUMBER          NOT NULL,                      -- 모집 인원
    rec_employment_type    VARCHAR2(50)    NOT NULL,                      -- 고용 형태
    rec_description        CLOB,                                          -- 공고 상세 내용
    rec_start_date         DATE            NOT NULL,                      -- 접수 시작일
    rec_end_date           DATE,                                          -- 접수 마감일
    rec_status             VARCHAR2(20)    DEFAULT 'OPEN' NOT NULL,       -- OPEN/CLOSED/CANCELLED
    created_at             DATE            DEFAULT SYSDATE NOT NULL,
    updated_at             DATE            DEFAULT SYSDATE NOT NULL,

    CONSTRAINT pk_recruit PRIMARY KEY (rec_id),
    CONSTRAINT fk_recruit_com FOREIGN KEY (com_id) REFERENCES company(com_id),
    CONSTRAINT fk_recruit_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    CONSTRAINT ck_recruit_status CHECK (rec_status IN ('OPEN', 'CLOSED', 'CANCELLED'))
);

-- recruit 시퀀스
CREATE SEQUENCE seq_recruit START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_recruit_pk
BEFORE INSERT ON recruit
FOR EACH ROW
BEGIN
    IF :NEW.rec_id IS NULL THEN
        :NEW.rec_id := seq_recruit.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_recruit_bu
BEFORE UPDATE ON recruit
FOR EACH ROW
BEGIN
    :NEW.updated_at := SYSDATE;
END;
/

-- ============================================
-- 지원자
-- ============================================

CREATE TABLE applicant (
    apct_id         NUMBER(10)      NOT NULL,                        -- PK, 시퀀스 자동 채번
    com_id          NUMBER(10)      NOT NULL,                        -- 회사 FK
    rec_id          NUMBER(10)      NOT NULL,                        -- 지원한 채용공고 FK
    apct_name       VARCHAR2(50)    NOT NULL,                        -- 지원자 이름
    apct_email      VARCHAR2(100)   NOT NULL,                        -- 이메일
    apct_phone      VARCHAR2(20)    NOT NULL,                        -- 연락처
    apct_status     VARCHAR2(20)    DEFAULT 'RECEIVED' NOT NULL,     -- 전형 상태
    apct_date       DATE            DEFAULT SYSDATE,                 -- 지원일
    created_at      DATE            DEFAULT SYSDATE NOT NULL,
    updated_at      DATE            DEFAULT SYSDATE NOT NULL,

    CONSTRAINT pk_applicant PRIMARY KEY (apct_id),                                          -- PK 제약
    CONSTRAINT fk_applicant_com FOREIGN KEY (com_id) REFERENCES company(com_id),             -- 회사 FK 제약
    CONSTRAINT fk_applicant_recruit FOREIGN KEY (rec_id) REFERENCES recruit(rec_id),         -- 채용공고 FK 제약
    CONSTRAINT ck_applicant_status                                                           -- 전형 상태값 제한
        CHECK (
            apct_status IN (
                'RECEIVED',   -- 접수
                'SCREENING',  -- 서류심사
                'INTERVIEW',  -- 면접
                'HIRED',      -- 합격
                'REJECTED'    -- 불합격
            )
        )
);

-- applicant 채번용 시퀀스
CREATE SEQUENCE seq_applicant START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_applicant_pk
BEFORE INSERT ON applicant
FOR EACH ROW
BEGIN
    IF :NEW.apct_id IS NULL THEN
        :NEW.apct_id := seq_applicant.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_applicant_bu
BEFORE UPDATE ON applicant
FOR EACH ROW
BEGIN
    :NEW.updated_at := SYSDATE;
END;
/

CREATE INDEX fk_applicant_recruit_idx ON applicant(rec_id);   -- 공고별 지원자 조회용 인덱스
CREATE INDEX idx_applicant_status ON applicant(apct_status);  -- 상태별 지원자 조회용 인덱스
CREATE INDEX idx_recruit_com_id ON recruit(com_id);           -- 회사별 공고 조회용 인덱스

-- ============================================
-- 이력서
-- ============================================

CREATE TABLE resume (
    rsm_id              NUMBER(10)      NOT NULL,                     -- PK, 시퀀스 자동 채번
    apct_id             NUMBER(10)      NOT NULL,                     -- 지원자 FK
    rsm_file_name       VARCHAR2(200),                                -- 업로드 원본 파일명
    rsm_file_url        VARCHAR2(500),                                -- 업로드 파일 경로/URL
    rsm_extracted_text  CLOB,                                         -- 파일에서 추출한 전체 텍스트
    rsm_ai_summary      CLOB,                                         -- AI가 생성한 이력서 요약
    rsm_fit_score       NUMBER,                                       -- AI가 매긴 적합도 점수
    rsm_status          VARCHAR2(20)    DEFAULT 'PENDING' NOT NULL,   -- 분석 처리 상태
    rsm_uploaded_at     DATE            DEFAULT SYSDATE NOT NULL,     -- 업로드 시각
    rsm_analyzed_at     DATE,                                         -- 분석 완료 시각

    CONSTRAINT pk_resume PRIMARY KEY (rsm_id),                                              -- PK 제약
    CONSTRAINT fk_resume_applicant FOREIGN KEY (apct_id) REFERENCES applicant(apct_id),      -- 지원자 FK 제약
    CONSTRAINT ck_resume_status                                                              -- 분석 상태값 제한
        CHECK (
            rsm_status IN (
                'PENDING',    -- 분석 대기/진행중
                'COMPLETED',  -- 분석 완료
                'FAILED'      -- 분석 실패
            )
        )
);

-- resume 시퀀스
CREATE SEQUENCE seq_resume START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_resume_pk
BEFORE INSERT ON resume
FOR EACH ROW
BEGIN
    IF :NEW.rsm_id IS NULL THEN
        :NEW.rsm_id := seq_resume.NEXTVAL;
    END IF;
END;
/

-- ============================================
-- 이력서 청크 + 임베딩
-- ============================================
-- 청크(chunk)     : 이력서 원문을 검색 가능한 단위로 잘게 쪼갠 조각
-- 임베딩(embedding): 각 청크 텍스트를 AI 임베딩 모델(text-embedding-3-small)로
--                    변환한 벡터값. 코사인 유사도 계산은 Java(애플리케이션) 레이어에서 처리
-- ============================================

CREATE TABLE resume_chunk (
    chunk_id         NUMBER(10)      NOT NULL,     -- PK, 시퀀스 자동 채번
    rsm_id           NUMBER(10)      NOT NULL,      -- 원본 이력서 FK
    chunk_order      NUMBER          NOT NULL,      -- 청크 순서 (원문 재구성/맥락 참고용)
    chunk_text       CLOB            NOT NULL,      -- 청크 원문 텍스트
    chunk_embedding  CLOB            NOT NULL,      -- 임베딩 벡터 (JSON 문자열로 저장, VECTOR 타입 미지원으로 CLOB 사용)

    CONSTRAINT pk_resume_chunk PRIMARY KEY (chunk_id),                                       -- PK 제약
    CONSTRAINT fk_chunk_resume FOREIGN KEY (rsm_id) REFERENCES resume(rsm_id)                 -- 원본 이력서 FK 제약
);

-- resume_chunk 채번용 시퀀스
CREATE SEQUENCE seq_resume_chunk START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER trg_resume_chunk_pk
BEFORE INSERT ON resume_chunk
FOR EACH ROW
BEGIN
    IF :NEW.chunk_id IS NULL THEN
        :NEW.chunk_id := seq_resume_chunk.NEXTVAL;
    END IF;
END;
/

CREATE INDEX fk_chunk_resume_idx ON resume_chunk(rsm_id);   -- 이력서별 청크 목록 조회용 인덱스


*********
ALTER TABLE applicant MODIFY (apct_email VARCHAR2(100) NOT NULL);
ALTER TABLE applicant MODIFY (apct_phone VARCHAR2(20) NOT NULL);

ALTER TABLE recruit MODIFY (rec_department VARCHAR2(100) NOT NULL);
ALTER TABLE recruit MODIFY (rec_position VARCHAR2(100) NOT NULL);
ALTER TABLE recruit MODIFY (rec_headcount NUMBER NOT NULL);
ALTER TABLE recruit MODIFY (rec_employment_type VARCHAR2(50) NOT NULL);
ALTER TABLE recruit MODIFY (rec_start_date DATE NOT NULL);
**********