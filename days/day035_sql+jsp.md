day035

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql
-- ■ 1. 전체데이터 검색
-- select * from 테이블명
select*from userinfo;
desc userinfo;

-- ■ 2. 필드검색
-- select  필드1, 필드2  from 테이블명;
select no,name from userinfo;
select no,age from userinfo;

-- ■ 3. 중복빼기 distinct
-- select   distinct 필드1 from 테이블명;
select * from userinfo;
insert into userinfo (name,age) values('first','11');
insert into userinfo (name,age) values('first','11');
select name from userinfo;

select distinct name from userinfo; -- 중복빼기
-- select no , distinct name from userinfo; -- error
select distinct no , name from userinfo;

-- ■ 4. 별명 as
-- select  필드1 `별명1`    , 필드2     `별명2`  from 테이블명;
-- select  필드1 as `별명1` , 필드2  as `별명2`  from 테이블명;

select no `번호` , name `이름` , age `나이` from userinfo;
select no as`번호` , name as`이름` , age as`나이` from userinfo;

select no ,       age*100/0.9           from userinfo;
select no `번호` , age*100/0.9 `나이값계산` from userinfo;

-- ■ 5. 비교연산자
-- select  필드1, 필드2 ,,, from 테이블명  where 컬럼명 비교연산자 조건;
select*from userinfo where name='second';
select*from userinfo where name!='second';
select*from userinfo where name<>'second'; -- 권장사항
-- select*from userinfo where name^='second'; -- != == ^= / 옛날버전
select*from userinfo where age<33;
select*from userinfo where age<=33;
select*from userinfo where age>33;
select*from userinfo where age>=33;

--    where   비교연산자
--    컬럼 =   조건  : 같다
--    컬럼 <> 조건  : 다르다
--    컬럼 != 조건  : 다르다
--    컬럼 <  조건  : 작다
--    컬럼 <=  조건  : 작거나 같다
--    컬럼 >  조건    : 크다
--    컬럼 >=  조건  : 크거나 같다


-- ■ SQL  SELECT(6) 논리연산자
-- [ SELECT  [필드명] FROM  [테이블이름] WHERE 컬럼명 비교연산자 조건 (AND 또는 OR) 컬럼명 비교연산자 조건  ] 
select*from userinfo where age>=22 and age<=33;

-- ■ SQL  SELECT(7) 범위로 추출(BETWEEN연산자)
-- [ SELECT  [필드명] FROM  [테이블이름] WHERE 컬럼명 BETWEEN 시작값 AND 끝값  ] 
select*from userinfo where age between 22 and 33; -- 22와 33 포함?  O
select*from userinfo where age>=22        and age<=33;

-- ■ SQL  SELECT(8) 일치하는 레코드추출(IN연산자)
--  [ SELECT  [필드명] FROM  [테이블이름] WHERE 컬럼명 IN(값1, 값2, 값3,,,)  ] 
select*from userinfo where age in(22,44);

-- ■ SQL  SELECT(9) 일치하는 레코드추출(OR연산자)
--  [ SELECT  [필드명] FROM  [테이블이름] WHERE 컬럼명 IN(값1, 값2, 값3,,,)  ] 
select*from userinfo where age=22 or age=33;

-- ■ SQL  SELECT(10) 추출조건으로 NULL지정
-- NULL과 같다는 것을 확인하고 싶을때 (=연산자 사용못함)
-- [ SELECT  [필드명] FROM  [테이블이름] WHERE 컬럼명 IS NULL]
-- SELECT * FROM select_userinfo   WHERE age is null ;
desc userinfo;
alter table userinfo modify age int null; -- 빈칸허용(공간은 있지만 데이터가 X)
insert into userinfo (name) values('abc');
insert into userinfo (name) values('bbb');
select*from userinfo;
select*from userinfo where age = null; -- 값
select*from userinfo where age is null; -- 상태

-- ■ SQL  SELECT(11) 문자열 필터링(LIKE문)
-- a% (a로 시작하는 문자열), %b (b로 끝나는 문자열), %a% (a가 포함된 문자열), _a% (2번째 글자가 a인 문자열)
-- ename >= 'C' (첫문자가 C와 같거나 뒤쪽인 사원) C,D,E,F,,,, 

SELECT * FROM userinfo where name     ='a%'; -- a로 시작하는 문자열 똑같은애들
SELECT * FROM userinfo where name like 'a%'; -- a로 시작하는 문자열 
select * from userinfo where name like '%b'; -- b로 끝나는 문자열
select * from userinfo where name like '%b%'; -- b가 포함된 문자열
select * from userinfo where name like '_i%'; -- 두번째 문자가 i인 문자열


-- ■ SQL  SELECT(12)  NOT (반대)
-- 컬럼명 NOT IN (값 ,값,...)
-- 컬럼명 NOT between 최소 AND 최대
-- 컬럼명 NOT LIKE '검색문자열'
--  
--  
# 22~33살 사이
select*from userinfo where age>=22 and age<=33; -- 22~33살 사이
select*from userinfo where age between 22 and 33; -- 22~33살 사이
select*from userinfo where age not between 22 and 33; -- 22~33살 사이가 아닌 

### jsp

 <div class="container card my-5">
      <h3 class="card-header">JSP 기본속성 001. 주석</h3>
      <div class="alert alert-waring">코드 설명글</div>
      <!--  html 주석 -->
      <%-- jsp 주석 --%>
      <% //java 주석 %>
   </div>
   <div class="container card my-3">
   <h3>002.페이지지시자</h3>
   <%@page import="java.util.ArrayList" %>

   <h3>003.스크립트립</h3>
      <div class="alert alert-warning">자바코드 - ctrl + space bar</div>
   <%
	  ArrayList<String> list = new ArrayList<>();
	  list.add("one"); list.add("two"); list.add("three");
	  out.print(list);
   %>
   
   <h3>004.표현식</h3>
   <%=list %>
   
   <h3>005.선언</h3>
   <%! public String company(){return "the703";} %>
   <p>copyright &copy; <%=company() %> all rights reserved.</p>
   
   </div>

   ### 복습문제

    다음의 결과가나오게 조회하시오.
-- emp 테이블에서
-- 추가수당(comm) 이 없고
-- 상급자(mgr)은 존재하며
-- 직책(JOB) 'MANAGER', 'CLERK' 중에서
-- 사원이름(ename)의 두번째 글자가 L이아닌
-- 사원데이터를  조회하시오