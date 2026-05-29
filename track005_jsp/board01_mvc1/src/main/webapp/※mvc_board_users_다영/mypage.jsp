<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String email = (String)session.getAttribute("email");

String nickname ="";
String mobile ="";
String udate = "";
String bip ="";


try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	ResultSet rset = null;
	
	pstmt=conn.prepareStatement("select * from users where email=?");
	
	pstmt.setString(1, email);
	rset = pstmt.executeQuery();
	if(rset.next()){
		nickname=rset.getString("nickname");
		mobile=rset.getString("mobile");
		udate=rset.getString("udate");
		bip=rset.getString("bip");
	}
	
	if(rset!=null){rset.close();}
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
}catch(Exception e){e.printStackTrace();}

%>
<div class="container card my-3">
<h3>마이페이지</h3>
<table class="table table-striped my-3">
<tbody >

<tr><th scope="row">닉네임</th></hr> <td><%=nickname %> </td></tr>
<tr><th scope="row">이메일</th> <td><%=email %> </td></tr>
<tr><th scope="row">휴대폰</th> <td><%=mobile %> </td></tr>
<tr><th scope="row">가입일</th> <td><%=udate %> </td></tr>
<tr><th scope="row">가입IP</th> <td><%=bip %> </td></tr>

</tbody>
</table>

</div>




<%@ include file="inc/footer.jsp"%>