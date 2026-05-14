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


--1. 테이블 준비
mysql> desc userinfo;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)



[연습문제]
[001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int(11)     | YES  |     | NULL    |       |
| cname  | varchar(20) | YES  |     | NULL    |       |
| cprice | int(11)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

create table alter_coffee(
    cno int(11),
    cname varchar(20),
    cprice int(11)
);

연습문제1) cno, cname,cprice필드를 ( not null )으로 수정
alter table alter_coffee modify cno not null;
alter table alter_coffee modify cname varchar(100) not null;
alter table alter_coffee modify cprice int not null;

연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가
alter table alter_coffee add cgift char(10);

연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기
alter table alter_coffee change cgift ccounpon varchar(10);

연습문제4) 쿠폰필드 ccoupon삭제
alter table alter_coffee drop ccounpon;

연습문제5) cno를 cprice뒤로이동
alter table alter_coffee modify cno int not null after cprice;
* alter table alter_coffee change cno cno int null after cprice;

연습문제6) cno를 맨위로
alter table alter_coffee modify cno int first;
* alter table alter_coffee change cno cno int not null first;

연습문제7) cno를 primary key 추가
alter table alter_coffee modify cno int(11) not null primary key;
*alter table alter_coffee change cno cno int(11) nor null primary key;
*alter table alter_coffee add primary key(cno);
*key삭제 : alter table alter_coffee drop primary key;

연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기
alter table alter_coffee rename alter_coffee2;

연습문제9) 다음과 같이 최종본으로 테이블만들기

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

alter table alter_coffee2 modify con int not null auto_increment primary key first;