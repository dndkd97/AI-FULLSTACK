<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header2.jsp"%>

<form action="login_action.jsp" method="post" onsubmit="return check()">
	<div class="container card my-3">
	<h3>로그인</h3>
	
		<div class="my-3">
		<label for="email" class="form-label">이메일</label>
		<input type="text" class="form-control" id="email" name="email"/>
		</div>

		<div class="my-3">
		<label for="bpass" class="form-label">비밀번호</label>
		<input type="password" class="form-control" id="bpass" name="bpass"/>
		</div>
		
		<div class="my-3 text-end">
		<button type="reset" class="btn btn-danger">취소</button>
		<button type="submit" title="로그인" class="btn btn-primary">로그인</button>
		</div>
	</div>
</form>
<script>
function check(){
let email = document.getElementById("email");
let bpass = document.getElementById("bpass");

if(email.value.trim()==""){alert("이메일 빈칸입니다"); email.focus(); return false;}
if(bpass.value.trim()==""){alert("비밀번호 빈칸입니다"); bpass.focus(); return false;}return true;
	
}

</script>
<%@ include file="inc/footer.jsp"%>