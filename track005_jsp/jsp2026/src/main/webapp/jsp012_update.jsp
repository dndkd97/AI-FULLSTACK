<%@page import="java.sql.*"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String oname = request.getParameter("oname");
int onum = Integer.parseInt(request.getParameter("onum"));
int ono = Integer.parseInt(request.getParameter("ono"));
try{
	Connection conn = null; PreparedStatement pstmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	pstmt = conn.prepareStatement("update milk_order set oname=?, onum=?, oip=? where ono=?");
	
	pstmt.setString(1, oname);
	pstmt.setInt(2,onum);
	pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
	pstmt.setInt(4,ono);
	int result = pstmt.executeUpdate();
	
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
	if(result>0){out.println("<script>alert('주문 수정 완료'); location.href='jsp012_milks.jsp'; </script>");}
	else {out.println("<script>alert('주문 수정 실패'); location.href='jsp012_milks.jsp'; </script>");}
	
	
}catch(Exception e){e.printStackTrace();}
%>

