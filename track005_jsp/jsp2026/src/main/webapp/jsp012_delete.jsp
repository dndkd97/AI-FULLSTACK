<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

int ono = Integer.parseInt(request.getParameter("ono"));
try{
	Connection conn = null; PreparedStatement pstmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	pstmt = conn.prepareStatement("delete from milk_order where ono=?");

	pstmt.setInt(1,ono);
	int result = pstmt.executeUpdate();
	
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
	if(result>0){out.println("<script>alert('주문 삭제 완료'); location.href='jsp012_milks.jsp'; </script>");}
	else {out.println("<script>alert('주문 삭제 실패'); location.href='jsp012_milks.jsp'; </script>");}
	
	
}catch(Exception e){e.printStackTrace();}
%>
