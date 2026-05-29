<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
String email = request.getParameter("email");
String bpass = request.getParameter("bpass");


try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig", "root", "1234");
	pstmt= conn.prepareStatement("select*from users where email=? and bpass=?");
	
	pstmt.setString(1, email);
	pstmt.setString(2, bpass);
	
	rset =pstmt.executeQuery();
	
	if(rset.next()){ session.setAttribute("email", email); 
	session.setMaxInactiveInterval(60 * 60);
	response.sendRedirect("list.jsp");
	out.println("<script>alert('로그인성공'); location.href='mypage.jsp';</script>");}
	else{out.println("<script>alert('로그인실패'); history.go(-1);</script>");}
	
	if(rset!=null){rset.close();}
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
}catch(Exception e){e.printStackTrace();}


%>