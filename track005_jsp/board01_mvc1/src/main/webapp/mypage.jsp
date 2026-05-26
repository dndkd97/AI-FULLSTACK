<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%@ include file="inc/header2.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:dbdbig","root","1234");
	ResultSet rset = null;
	
			
	
	
}catch(Exception e){e.printStackTrace();}

%>
<div>
<caption>마이페이지</caption>
<table class="table table-striped">
<tbody>

<tr><th scope="row">닉네임</th> <td> </td></tr>
<tr><th scope="row">이메일</th> <td> </td></tr>
<tr><th scope="row">휴대폰</th> <td> </td></tr>
<tr><th scope="row">가입일</th> <td> </td></tr>
<tr><th scope="row">가입IP</th> <td> </td></tr>

</tbody>
</table>

</div>




<%@ include file="inc/footer.jsp"%>