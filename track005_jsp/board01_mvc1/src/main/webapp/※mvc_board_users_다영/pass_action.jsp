<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<% 

request.setCharacterEncoding("UTF-8");
String mobile = request.getParameter("mobile");
String email = request.getParameter("email");
String bpass= "";
try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= null; PreparedStatement pstmt=null; ResultSet rset=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root", "1234");
	pstmt = conn.prepareStatement("select bpass from users where mobile=? and email=?");
	pstmt.setString(1, mobile);
	pstmt.setString(2, email);
	
	rset = pstmt.executeQuery();
	if(rset.next())
	//{ out.print("해당 고객님의 이메일은 ["+rset.getString("email")+"] 입니다."); }
	{out.println("<script>alert('비밀번호: ["+rset.getString("bpass")+"] 입니다'); history.go(-1);</script>");}
	else{out.println("<script>alert('비밀번호찾기 오류'); history.go(-1);</script>");}
	
	if(rset!=null){rset.close();}
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	
}catch(Exception e){e.printStackTrace();}

%>