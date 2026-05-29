<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%@ include file="inc/header2.jsp"%>

<form action="JoinAction" method="post" onsubmit="return check()">
	<div class="container card my-3">
	<h3>회원가입</h3>
	
		<div class="my-3">
		<label for="nickname" class="form-label">닉네임</label>
		<input type="text" class="form-control" id="nickname" name="nickname"/>
		</div>
		
		<div class="my-3">
		<label for="bpass" class="form-label">비밀번호</label>
		<input type="password" class="form-control" id="bpass" name="bpass"/>
		</div>
		
		<div class="my-3">
		<label for="email" class="form-label">이메일</label>
		<input type="text" class="form-control" id="email" name="email"/>
		</div>
		
		<div class="my-3">
		<label for="mobile" class="form-label">휴대폰</label>
		<input type="text" class="form-control" id="mobile" name="mobile"/>
		</div>
		
		<div class="my-3 text-end">
		<button type="reset" class="btn btn-danger">취소</button>
		<button type="submit" title="가입하기" class="btn btn-primary">가입하기</button>
		</div>
	</div>
</form>

<script>
function check(){
	let nickname = document.getElementById("nickname");
	let bpass = document.getElementById("bpass");
	let email = document.getElementById("email");
	let mobile = document.getElementById("mobile");
	
	if(nickname.value.trim()==""){alert("닉네임 빈칸입니다"); nickname.focus(); return false;}
	if(bpass.value.trim()==""){alert("비밀번호 빈칸입니다"); bpass.focus(); return false;}
	if(email.value.trim()==""){alert("이메일 빈칸입니다"); email.focus(); return false;}
	//if(email.value.includes("@"))
	if(mobile.value.trim()==""){alert("휴대폰 빈칸입니다"); mobile.focus(); return false;}return true;
}
</script>


<%@ include file="inc/footer.jsp"%>