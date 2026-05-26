<%@page import="java.net.InetAddress"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String nickname = request.getParameter("nickname");
String bpass = request.getParameter("bpass");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	
	pstmt=conn.prepareStatement("insert into users(nickname,bpass,email,mobile,bip) values(?,?,?,?,?)");
	pstmt.setString(1,nickname);
	pstmt.setString(2,bpass);
	pstmt.setString(3,email);
	pstmt.setString(4,mobile);
	pstmt.setString(5,InetAddress.getLocalHost().getHostAddress());
			
	int result = pstmt.executeUpdate();
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
	if(result>0){out.println("<script>alert('회원가입성공');location.href='join.jsp';</script>");}
	else {out.println("<script>alert('회원가입실패'); history.go(-1);</script>");}
	
}catch(Exception e){e.printStackTrace();}

%>