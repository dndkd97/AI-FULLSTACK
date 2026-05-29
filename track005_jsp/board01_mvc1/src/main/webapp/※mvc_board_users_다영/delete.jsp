<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp" %>
<%int bno = Integer.parseInt(request.getParameter("bno")); %>

   <div class="container card my-5">
      <h3 class="card-header bg-danger my-1">글 삭제</h3>
      <form action="delete_action.jsp" method="post" onsubmit="return check()">
      <input type="hidden" name="bno" value="<%=bno%>">
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
   	if(bpass.value.trim()==""){ alert("비밀번호 빈칸입니다"); bpass.focus(); return false; }return true;
   	
   }
   </script>
   
  
<%@include file="inc/footer.jsp" %>