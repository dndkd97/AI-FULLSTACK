<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%
int bno=Integer.parseInt(request.getParameter("bno"));
String bpass = request.getParameter("bpass");
String btitle = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent");

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	pstmt = conn.prepareStatement
	("update mvcboard1 set btitle=?, bcontent=? where bno=? and bpass=?");
	
			
	pstmt.setString(1,btitle);
	pstmt.setString(2,bcontent);
	pstmt.setInt(3,bno);
	pstmt.setString(4,bpass);
	
	int result =pstmt.executeUpdate();
	if(result>0){out.println("<script>alert('수정 성공했습니다');location.href='detail.jsp?bno="+bno+"';</script>");}
	else{out.println("<script>alert('수정 실패했습니다.');location.href='edit.jsp';</script>");}
	
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
}catch(Exception e){e.printStackTrace();}
%>