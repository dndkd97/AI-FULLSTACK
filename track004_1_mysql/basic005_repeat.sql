-- STEP1) 
-- 1.  데이터베이스 언어 - 다음과 같은형식으로 빈칸 채우기
-- DDL(  정의어   )  CREATE , DROP , ALTER
-- DML(  조작어   )  INSERT , SELECT , DELETE , UPDATE  
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
use mbasic;
show tables;
create table userinfo_ex select*from userinfo;
alter table userinfo_ex modify no int not null primary key auto_increment;
desc userinfo_ex;
select*from userinfo_ex;

-- Q2. userinfo_re1 에  다음과 같이 데이터 추가 
-- mysql> select * from userinfo_re1;
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
insert into userinfo_ex(no,name,age)values(5,'fifth',50);
insert into userinfo_ex(no,name,age)values(6,'six',66);

-- Q3. userinfo_re1 에 데이터 수정
-- mysql> select * from userinfo_re1;
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

update userinfo_ex set age=55 where no=5;
update userinfo_ex set name='sixth' where no=6;

-- Q4. userinfo_re1 에 데이터 삭제
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 | 
-- +----+--------+-----+

delete from userinfo_ex where no=5;
delete from userinfo_ex where no=6;