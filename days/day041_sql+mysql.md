day041

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql

-- >> JOIN
-- 1. join
--    - 두개 이상의 테이블들을 연결 또는 결합하여 데이터를 출력
--    - 테이블간의 연결고리( pk, fk )로 관계를 맺고 데이터를 출력

-- 2. 종류
--    - inner join : 양쪽테이블 모두 일치하는 데이터
--    - outer join : 특정테이블을 기준으로 데이터를 검색

ex)
-- >>> (1) = join
select a.no , a.name, a.age ,b.ban
from join_userinfo a, join_userban b
where a.no = b.no;
-- >>> (2) join  on
select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b
on a.no=b.no;
-- >>> (3) join  using
select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b
using(no);
-- >>> (4) natural join
select no , name,age,ban
from join_userinfo natural join join_userban;

---

### jsp

1. 세션 - 서버측에 저장되는 정보
1. 로그인에 성공시 - session.setAttribute() 서버측에 사용자 정보 저장
2. 로그인에 성공시 - session.getAtrribute() 서버측의 정보를 header
3. 로그아웃시     - session.invalidator()  서버측의 정보를 삭제


---

### 복습문제

-- --------------------------------------------------------
-- --------------------------------------------------------
-- 복습문제1) 
-- +--------+------------+-------+-------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME | SAL  |
-- +--------+------------+-------+-------+------+
-- |     20 | RESEARCH   |  7566 | JONES | 2975 |
-- |     30 | SALES      |  7698 | BLAKE | 2850 |
-- |     10 | ACCOUNTING |  7782 | CLARK | 2450 |
-- |     20 | RESEARCH   |  7788 | SCOTT | 3000 |
-- |     10 | ACCOUNTING |  7839 | KING  | 5000 |
-- |     20 | RESEARCH   |  7902 | FORD  | 3000 |
-- +--------+------------+-------+-------+------+
-- 6 rows in set (0.00 sec)

-- -- emp ,DEPT 테이블에서  급여가 2000  초과인 사원들의 부서 정보, 사원정보를 다음과 같이   조회하시오.
-- join 4가지 방법을 이용해서 조회하시오.

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e, dept d
where   d.deptno = e.deptno   and  sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d  on d.deptno = e.deptno   
where   sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d   using(deptno)   
where   sal > 2000;

select  DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  natural join  dept d  
where   sal > 2000;


-- 복습문제2) 
-- -- emp ,DEPT 테이블에서  각 부서별 평균급여, 최대급여, 최소급여, 사원수를  다음과 같이   조회하시오.
-- -- = 등가조인을 이용하시오.
-- join 4가지 방법을 이용해서 조회하시오.
-- +--------+------------+-----------+---------+---------+-----+
-- | DEPTNO | DNAME      | AVG_SAL   | MAX_SAL | MIN_SAL | CNT |
-- +--------+------------+-----------+---------+---------+-----+
-- |     10 | ACCOUNTING | 2916.6667 |    5000 |    1300 |   3 |
-- |     20 | RESEARCH   | 2175.0000 |    3000 |     800 |   5 |
-- |     30 | SALES      | 1566.6667 |    2850 |     950 |   6 |
-- +--------+------------+-----------+---------+---------+-----+
-- 3 rows in set (0.00 sec)
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e , DEPT  d
where     e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   on  e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   using(deptno)
group by  d.DEPTNO , DNAME
order by  d.deptno asc; 

select    DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e  natural join DEPT  d  
group by  DEPTNO , DNAME
order by  deptno asc; 


-- 복습문제3) 
-- -- emp ,DEPT 테이블에서 모든부서정보와 사원정보를 다음과 같이 부서번호, 사원이름 순으로    조회하시오.
-- -- left , right join을 이용하시오.
-- +--------+------------+-------+--------+-----------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME  | JOB       | SAL  |
-- +--------+------------+-------+--------+-----------+------+
-- |     10 | ACCOUNTING |  7782 | CLARK  | MANAGER   | 2450 |
-- |     10 | ACCOUNTING |  7839 | KING   | PRESIDENT | 5000 |
-- |     10 | ACCOUNTING |  7934 | MILLER | CLERK     | 1300 |
-- |     20 | RESEARCH   |  7876 | ADAMS  | CLERK     | 1100 |
-- |     20 | RESEARCH   |  7902 | FORD   | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7566 | JONES  | MANAGER   | 2975 |
-- |     20 | RESEARCH   |  7788 | SCOTT  | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7369 | SMITH  | CLERK     |  800 |
-- |     30 | SALES      |  7499 | ALLEN  | SALESMAN  | 1600 |
-- |     30 | SALES      |  7698 | BLAKE  | MANAGER   | 2850 |
-- |     30 | SALES      |  7900 | JAMES  | CLERK     |  950 |
-- |     30 | SALES      |  7654 | MARTIN | SALESMAN  | 1250 |
-- |     30 | SALES      |  7844 | TURNER | SALESMAN  | 1500 |
-- |     30 | SALES      |  7521 | WARD   | SALESMAN  | 1250 |
-- |     40 | OPERATIONS |  NULL | NULL   | NULL      | NULL |
-- +--------+------------+-------+--------+-----------+------+
-- 15 rows in set (0.00 sec)


select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      dept d  left join emp  e    on   d.deptno = e.deptno
order  by  d.deptno, ename;

select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      emp  e     right join  dept d    on   d.deptno = e.deptno
order  by  d.deptno, ename;

-- --------------------------------------------------------
-- --------------------------------------------------------