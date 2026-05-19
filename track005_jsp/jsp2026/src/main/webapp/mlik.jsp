<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <div class="alert bg-danger text-white p-5">
 <h1>MILK ORDER Project</h1>
  <p>MVC1 - preparedStatement Ex</p>
 </div>
<!-- table table-striped table-bordered table-hover -->
   <div class="container card my-5 text-white">
      <h2 class="card-header bg-danger">Milk Menu</h2>
      
      <table class="table table-striped table-bordered table-hover">
      <caption>우유메뉴</caption>
      <thead class="table-dark">
      <tr>
      	<th scope="col">NO</th>
      	<th scope="col">NAME</th>
      	<th scope="col">PRICE</th>
      </tr>
      </thead>
      <tbody>
      <%@page import="java.sql.*" %>
      <%
      try{
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    	  PreparedStatement pstmt = null; ResultSet rset=null;
    	  pstmt = conn.prepareStatement("select*from milk order by mprice asc");
    	  rset = pstmt.executeQuery();
    	  while(rset.next()){  
    		  out.println("<tr><td>"+rset.getInt("mno")+"</td><td>"+rset.getString("mname")+"</td><td>"
    		  +rset.getInt("mprice")+ "</td></tr>");
    	   }
    	  if(rset!=null){rset.close();}
    	  if(pstmt!=null){pstmt.close();}
    	  if(conn!=null){conn.close();}
      //1.드라이버연동
      //2.JDBC 연동
      //3.PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기
      // 가격이 낮은순으로
      //4.JDBC 끊기
      }catch(Exception e){e.printStackTrace();}
      %>
      
      </tbody>
      </table>
   </div>
   <div class="container card my-5 bg-dark text-white p-3">
   <h3>MILK ORDER</h3>
         <table class="table table-striped table-bordered table-hover">
      <thead>
      <tr>
      	<th scope="col">NO</th>
      	<th scope="col">NAME</th>
      	<th scope="col">NUM</th>
      	<th scope="col">주문날짜</th>
      </tr>
      </thead>
      <tbody>
      <%
      try{
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn=DriverManager.getConnection("", "root", "1234");
    	  
      }catch(Exception e){e.printStackTrace();}
      
      %>
      </tbody>
     </table>
     </div>
   <div class="container card my-5 bg-dark text-white">
   <h3>MILK 주문하러가기</h3>
   <div>
   <h4 class="bg-danger">주문하기</h4>
   </div>
   <div>
   <h4 class="bg-danger">주문수정</h4>
   </div>
   <div>
   <h4 class="bg-danger">주문삭제</h4>
   </div>
   </div>
   
</body>
</html>