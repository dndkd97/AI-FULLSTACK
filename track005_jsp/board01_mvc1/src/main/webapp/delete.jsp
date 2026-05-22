<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp" %>

   <div class="container card my-5">
      <h3 class="card-header bg-danger my-1">글 삭제</h3>
      <form action="#" method="post" onsubmit="return check()">
       <div class="my-3">
       <label for="bpass">비밀번호</label>
       <input type="text" class="form-control" id="bpass" name="bpass">
       </div>
            <div class="my-3 text-end">
        <button type="submit" title="입력" class="btn btn-primary">입력</button>
        <button type="reset" class="btn btn-danger">취소</button>
        <a href="javascript:history.go(-1)" class="btn btn-primary">목록보기</a>
     </div>
       </form>
   </div>
   <script>
   function check(){
   	let bpass = document.getElementById("bpass");
   	if(bpass.value.trim()==""){ alert("비밀번호 빈칸입니다"); bpass.focus(); return false; }
   	
   }
   </script>
   
   <%
   String bno=request.getParameter("bno");
   String bpass = request.getParameter("bpass");

   if(request.getMethod().equals("POST")){
   try{
		Connection conn = null; PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig", "root", "1234");
		pstmt = conn.prepareStatement("delete from mvcboard1 where bno=? and bpass=?");

		pstmt.setString(1,bno);
		pstmt.setString(2,bpass);
		int result = pstmt.executeUpdate();
		
		if(pstmt!=null){pstmt.close();}
		if(conn!=null){conn.close();}
		
		if(result>0){out.println("<script>alert('글 삭제 완료'); location.href='list.jsp'; </script>");}
		else {out.println("<script>alert('글 삭제 실패'); location.href='list.jsp'; </script>");}
		
		
	}catch(Exception e){e.printStackTrace();}}
   %>
<%@include file="inc/footer.jsp" %>