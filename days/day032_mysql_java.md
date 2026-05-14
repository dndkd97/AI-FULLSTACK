day032

 - Todo1 : MYSQL
 - Todo2 : JAVA

---

### MYSQL

1) WEB BASIC - HTML + CSS + JS (화면단)
2) JAVA (프로그래밍)
3) MYSQL/ORACLE (DB)
4) JSP (HTML+JAVA)

1. MYSQL 셋팅
2. database 만들기

[실습]
1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제

:   create database test;
    create database mbasic;
    create database db703;
    show databases; 
    drop database db703;

---

### JAVA
Q. ArrayList와 LinkedList 차이점을 설명
ArrayList  : 배열기반으로 동작, 검색속도 빠름, 삽입/삭제 느림
LinkedList : 노드기반으로 연결구조, 검색속도 느림, 삽입/삭제 빠름 

ArrayList : 비동기화 → 단일스레드환경에서 빠름
Vector    : 동기화  → 멀티스레드환경에서 안전, 성능은 떨어짐.


#### Network
1. Network
- 통신기술들이 그물망처럼 연결된 통신을 이용해서 컴퓨터 자원을 공유
2. Client vs Server
- Client ( 서비스 사용 )
- Server ( 서비스 제공 )
3. IP주소 (컴퓨터주소)
예) 192.168.0.1 (건물)
80( http웹 ) , 443( https 웹자물쇠 ) , 22( ssh 보안원격호스트 ) , 25( smtp 메일 )

127.0.0.1 : 8080
localhost : 8080
4. InetAddress
- ip 주소를 다루는 클래스

#### chat

1. Http 통신   - 단방향 (client 요청이 있을때, server 응답하고 연결 종료)
2. Socket 통신 - 양방향 (특정포트를 통해 실시간으로 정보 주고받음 - tcp/udp)
3. 소켓통신흐름
   1) 서버소켓 (as 센터), 포트바인딩(문열기)
   2) 클라이언트 연결 요청, 수락
   3) 클라이언트 소켓(socket) ↔ 상담사(socket) ( InputStream > 프로그램 기준 > OutputStream )

- Chat001_Server.class, Char001_Client.class




---
<mysql>
* 숙제(5/13) - 집에서 mysql 설치 / 팀장이 모아서 제출
<java>
* 숙제(5/18) -Bank(자바 마무리) 가장 자신있는 버전
      -Bank 내용 바꾸기
* 옵션 - 파일입출력 / 채팅창 / lambda 식표현법으로

---

### 복습문제
1.   MySQL은 ________ 관리 시스템(DBMS)이다.
:데이터베이스
2.  (#1 ________)는 수집된 사실이나 값을 의미하고 (#2 ________)는 의미를 제공하는 데이터를 의미한다.
:데이터,정보
3. 대표적인 데이터베이스 종류에는 ________, ________, ________ 등이 있다.
:oracle,mysql.mssql
4.  RDBMS는 ________ Database Management System의 약자이다.
:Relational
5. RDBMS의 구성요소는   ________, ________, ________ 
:개체,관계,속성
6. 데이터베이스 언어
DDL(  정의어   )  CREATE, ALTER, DROP 
DML(   )    ________, ________, ________ , ________ 
DCL(   )     ________, ________
:조작어 : Insert , select , update, delete
제어어 : grant , revoke
7. 데이터베이스  mbasic, 를 생성하는 SQL 명령어를 작성하시오.
:create database mbasic
8.  생성된 데이터베이스 목록을 확인하는 SQL 명령어를 작성하시오.
:show databases
9. 데이터베이스 db703을 삭제하는 SQL 명령어를 작성하시오.
:drop database db703