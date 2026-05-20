<%@page import="java.sql.*"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
       <%
       //1. utf-8 설정
       request.setCharacterEncoding("UTF-8");
       //2. request.getParameter() 이용해서 데이터받기
       String oname = request.getParameter("oname");
       int onum = Integer.parseInt(request.getParameter("onum"));
       out.println(oname+"/"+onum);
       //3. insert 구문처리
       try{
    	   Connection conn= null; PreparedStatement pstmt = null;
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    	   pstmt= conn.prepareStatement("insert into milk_order(oname,onum,oip) values(?,?,?)");
    	   pstmt.setString(1,oname);
    	   pstmt.setInt(2,onum);
    	   pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
    	   int result = pstmt.executeUpdate();
    	   
    	   if(pstmt!=null){pstmt.close();}
    	   if(conn!= null){conn.close();}
       //3-1. Class.forName
       //3-2. jdb연동 DrvierManager.getConnection
       //3-3. insert executeUpdate
       //3-4. close
       if(result>0){out.println("<script>alert('우유주문 성공했습니다.'); location.href='jsp012_milks.jsp';</script>");}
       else{out.println("<script>alert('관리자에게 문의해주세요!'); location.href='jsp012_milks.jsp';</script>");}
       
       }catch(Exception e){e.printStackTrace();}
       //4. jsp012_milks.jsp로 돌아가기
       
       %>
