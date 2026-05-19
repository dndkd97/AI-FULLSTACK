- day036

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql
Q1. 나이가 많은 순으로 출력
 select * from select_userinfo order by age desc; -- 내림차순 (높은순으로)
 select * from select_userinfo order by age asc; -- 오름차순 (낮은순으로)
Q2. 나이가 많은 순으로 2명 출력
 select * from select_userinfo order by age desc limit 2;
 select * from select_userinfo order by age desc limit 0,2; -- 어디서부터 , 몇개 (최신부터, 2개) 66,55
 select * from select_userinfo order by age desc limit 1,2; -- 어디서부터 , 몇개 (최신부터, 2개) 55,44

---

### jsp

1. jdbc - Java Database Connectivity
  - java와 db연결해 sql 실행해주는 표준api
2. mysql, oracle,,, 다양한 dbms와 연결
3. 사용방법
 https://dev.mysql.com/downloads/
      
 [src]-[main]-[webapp]-[WEB-INF]-[lib] -  mysql-connector-j-8.4.0.jar
      
4. JDBC 사용방법
    1) Class.forName() 드라이버 로딩
    :Class.forName("com.mysql.cj.jdbc.Driver");
    2) DriverManager Connection 활성화
    3) Connection DB연동
    :Connection conn=	DriverManager.getConnection
    ("jdbc:mysql://localhost:3306/mbasic",//url db명  
        "root", //id 
        "1234");//pass 
    4) Statemenet, PreparedStatement sql 구문실행
    :PreparedStatement pstmt = conn.prepareStatement("insert into userinfo (name , age) values(?,?)");  
        pstmt.setString(1,"길동"); //? 순서,값
        pstmt.setInt   (2,11); //? 순서,값
       int result = pstmt.executeUpdate(); // insert,update,delete, 실행한 줄 수
    5) jdbc 연동끊기
    :if(conn!=null){  conn.close(); }

---

######  복습문제 확인 및 깃허브


복습문제1) 
1. 다음과 같이 테이블을 작성하는 코드를 적으시오.
-- mysql> desc userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)
:create table userinfo();

2. 마지막에 5, five, 50을  insert하는 코드를 작성하시오.
: insert into userinfo (no,name,age) values(5,'five',50);
3. no가 5인 데이터의 5, five, 55로  수정하는 코드를 작성하시오.   
: update userinfo set age=55 where no=5;
4. no가 5인 데이터를 삭제하는 코드를 작성하시오. 
: delete from userinfo where no=5;
5. 다음과 같이 나이를 오름차순으로 정렬하는 코드를 작성하시오.
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+
: select*from userinfo_re1 order by age asc;

복습문제2)  
1.  jdbc 연동을 하려고한다.   드라이버로딩시 사용되는 코드는?
:Class.forName("com.mysql.cj.jdbc.Driver");
2.  DriverManager를 이용해서 url, root, pass를 이용해서 Connection을 만들려고할때 사용되는 코드는?
:Connection conn = DeriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
3.  PreparedStatement를 이용해서 sql을 실행하려고할때  insert, update, delete 에서 사용되는 코드는?
:executeQuery
4.  PreparedStatement를 이용해서 sql을 실행하려고할때  select   에서 사용되는 코드는?
:executeUpdate
5.  jdbc의 주의사항은? 항상  (     )를 해야한다.
:close