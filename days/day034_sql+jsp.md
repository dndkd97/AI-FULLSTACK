day034

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql

- insert
※- 테이블구조를 만들때 no, name, age 순으로 만들었으므로
  - 삽입시에도 그 순서 그대로 입력해야합니다.
  - 순서가 바뀌면 오류가 납니다.
  - 필드가 많아지면 데이터 삽입하기가 힘들어집니다.
ex)insert into emp (empno,ename,job,mgr,hiredate,sal,comm,dept) values (7369 ,'SMITH' , 'CLERK' , 7902, '80-12-17',  800 , NULL ,   20);

- update
ex)update userinfo set age=10, name ='fff' where no=1;

- userinfo 테이블복사해서 delete_userinfo 테이블 만들기
ex)create table userinfo2 select *from userinfo;
alter table userinfo2 modify no int not null auto_increment primary key; -- no에 auto_increment primary 추가

- delete
ex)delete from userinfo2 where age=11;

### 복습문제
-- STEP1) 
-- 1.  데이터베이스 언어 - 다음과 같은형식으로 빈칸 채우기
-- DDL(  정의어   )  CREATE , ALTER ,  DROP
-- DML(  조작어   )  INSERT , DELETE , UPDATE , SELECT
-- DCL(  제어어   )  GRANT , REVOKE


-- STEP2) 
-- Q1. userinfo 테이블을 복사해서 userinfo_ex 테이블을 만드시오.

-- mysql> desc userinfo_ex;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+
:use mbasic; -- datebase 선택
show tables; -- 테이블들 확인
create table userinfo_ex select*from userinfo; -- 테이블 만들기(구조+데이터)
alter table userinfo_ex modify no int not null primary key auto_increment; -- 숫자 자동증가+기분키
desc userinfo_ex; -- 테이블 구조 확인
select*from userinfo_ex; -- 전체 데이터 검색

-- Q2. userinfo_ex 에  다음과 같이 데이터 추가 
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth    |  50 |
-- |  6 | six   |  66 |
-- +----+--------+-----+
:insert into userinfo_ex(no,name,age)values(5,'fifth',50);
insert into userinfo_ex(no,name,age)values(6,'six',66);

-- Q3. userinfo_ex 에 데이터 수정
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth    |  55 |   ← age 55로 수정
-- |  6 | six   |  66 |       ← name sixth로 수정
-- +----+--------+-----+
:update userinfo_ex set age=55 where no=5;
update userinfo_ex set name='sixth' where no=6;


-- Q4. userinfo_ex 에 데이터 삭제
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 | 
-- +----+--------+-----+
:delete from userinfo_ex where no=5;
delete from userinfo_ex where no=6;