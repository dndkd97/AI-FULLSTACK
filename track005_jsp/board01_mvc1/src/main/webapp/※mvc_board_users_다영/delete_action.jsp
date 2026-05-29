<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
 <%
 request.setCharacterEncoding("UTF-8");
   int bno =Integer.parseInt(request.getParameter("bno"));
   String bpass = request.getParameter("bpass");


   try{
		Connection conn = null; PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig", "root", "1234");
		pstmt = conn.prepareStatement("delete from mvcboard1 where bno=? and bpass=?");

		pstmt.setInt(1,bno);
		pstmt.setString(2,bpass);
		int result = pstmt.executeUpdate();
		
		if(result>0){out.println("<script>alert('글 삭제 완료'); location.href='list.jsp'; </script>");}
		else {out.println("<script>alert('글 삭제 실패'); history.go(-1); </script>");}
		
		if(pstmt!=null){pstmt.close();}
		if(conn!=null){conn.close();}
		
	}catch(Exception e){e.printStackTrace();}
   %>