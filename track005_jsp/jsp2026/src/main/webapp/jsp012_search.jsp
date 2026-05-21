<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container card my-5 p-3">
   <h3 class="card-header">WEBSTANDARD + TABLE</h3>
<%
		int mno = Integer.parseInt(request.getParameter("mno"));
		Connection conn = null; PreparedStatement pstmt = null;
		ResultSet result = null;
		try{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic",  "root",  "1234"  );
		   pstmt = conn.prepareStatement("select * from milk where mno=?");
		   pstmt.setInt(1, mno);
		   result = pstmt.executeQuery();
		%>
		<table class="table table-striped table-bordered table-hover">
		   <thead>
		      <tr>
		         <th scope="col">MNO</th>
		         <th scope="col">MNAME</th>
		         <th scope="col">MPRICE</th>
		      </tr>
		   </thead>
		   <tbody>
		<% while(result.next()){ %>
		      <tr>
		         <td><%= result.getInt("mno") %></td>
		         <td><%= result.getString("mname") %></td>
		         <td><%= result.getInt("mprice") %></td>
		      </tr>
		   </tbody>
		</table>
		<%
		}
		  if(result != null){ result.close(); }
		   if(pstmt != null){ pstmt.close(); }
		   if(conn != null){ conn.close(); }
   }catch(Exception e){ out.println(e); }
		%>
		<p>  <a href="javascript:history.go(-1)" class="btn btn-danger">  뒤로가기  </a>  </p>
</div>
</body>
</html>