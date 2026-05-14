- day033

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql - table

1. RDBMS (Relational Data Management System)
- 관계형 데이터베이스
- 테이블의 관계
- 속성(필드)

2. 테이블 만들기(집안의 방, 가방안의 분류표)
DDL(정의:create,alter,drop), DML(조작:), DCL(제어:)
-----------------------------------------------
CREATE TABLE table(명)(
    필드1 자료형 옵션,
    필드2 자료형 옵션
);
-----------------------------------------------
자료형 :
    1. 숫자 : int ( 정수, 1,2,3) , double(실수, 1.23)
    2. 문자 : char (고정, 남/여) , varchar(가변, abc, abcd, abcde)
    3. 날짜 : date, datetime
옵션 :
    필수입력 - not null
    숫자자동증가 - auto_increment
    기본키 - primary key

### mysql - alter

1.데이터베이스 언어
- DDL : CREATE , ALTER(#) , DROP → CAD

1) alter 문법
help alter
help alter table;

ALTER TABLE 테이블명
    ADD        추가컬럼명 자료형 옵션 [FIRST | AFTER col_name]
    DROP       삭제필드명
    CHANGE     이전필드명 새로운필드명
    MODIFY     수정필드명 자료형 옵션
    RENAME     새로운테이블이름

#1) 필드추가
 alter table userinfo add uno int;
 alter table userinfo add uno2 int first; -- 맨앞에
 alter table userinfo add email varchar(100) after name; -- name 뒤에

#2) 필드삭제
 alter table userinfo drop uno;
 alter table userinfo drop uno2; -- uno2 삭제

#3-1) 필드수정(CHANGE) - 필드명, 자료형 옵션 수정
 > alter table userinfo change oldname newname 자료형 옵션
 alter table userinfo change email email2 varchar(50); 
 alter table userinfo change email2 email; ※ email2를 email로 바꾸기

#3-2) 필드수정(MODIFY) - 자료형 옵션 수정 ( add,drop,change|modify )
alter table userinfo modify email varchar(100) not null;

alter table userinfo drop email;

#4) 테이블명 수정 ( add,drop,change|modify )
alter table userinfo rename users;

### jsp
1. web
- 클라이언트 ↔ 서버
- WS vs WAS 
  1. WS(WEB Server) : 정적콘텐츠 ( html,css,js ) 웹브라우저제공
    예) Apache

  2. WAS(WEB application Server) : 동적콘텐츠
    브라우저와 DBMS 사이에서 동작하는 미들웨어
    예) Apache + Tomcat
  3. Tomcat
>> Http request( 요청) > Catalina(해결사) > Context > Servlet > response

3-1) http request(요청)
3-2) Coyte 가  해결사찾기: http요청을 처리할 웹어플리케이션(context) 
                                   web.xml 파일내용을 참고해서 요청전달.
3-3) Catalina (Servlet) : 해결사   
3-4) Jasper (Jsp Engine) :  java+html 페이지 요청처리 응답(response)


### 복습문제

1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP 
-- DML(   )    ________, ________, ________ , ________ 
-- DCL(   )     ________, ________


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로 
-- 4. 이메일 필드 삭제(drop)   