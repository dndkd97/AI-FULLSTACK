<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%

request.setCharacterEncoding("UTF-8");
String bname = request.getParameter("bname");
String bpass = request.getParameter("bpass");
String btitle = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent");


try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	pstmt = conn.prepareStatement
	("insert into mvcboard1(btitle,bcontent,bname,bpass,bip) values(?,?,?,?,?)");
			
	pstmt.setString(1,btitle);
	pstmt.setString(2,bcontent);
	pstmt.setString(3,bname);
	pstmt.setString(4,bpass);
	pstmt.setString(5,InetAddress.getLocalHost().getHostAddress());
	
	int result =pstmt.executeUpdate();
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	if(result>0){out.println("<script>alert('입력 성공했습니다');location.href='list.jsp';</script>");}
	else{out.println("<script>alert('관리자에게 문의바랍니다.');location.href='list.jsp';</script>");}
	
}catch(Exception e){e.printStackTrace();}

%>