<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header2.jsp"%>

<form action="Pass" method="post" onsubmit="return check()">
	<div class="container card my-3">
	<h3>비밀번호 찾기</h3>
	
		<div class="my-3">
			<label for="mobile" class="form=label">휴대폰번호</label>
			<input type="text" class="form-control" id="mobile" name="mobile"/>
		</div>
		
		<div class="my-3">
			<label for="email" class="form=label">이메일</label>
			<input type="text" class="form-control" id="email" name="email"/>
		</div>
		
		<div class="text-end my-3">
		<button type="reset" class="btn btn-danger">취소</button>
		<button type="submit" title="아이디찾기" class="btn btn-primary">찾기</button>
		</div>
	
	</div>
</form>
<script>
function check(){
	let mobile = document.getElementById("mobile");
	let email = document.getElementById("email");

	if(mobile.value.trim()==""){alert("휴대폰번호 빈칸입니다"); mobile.focus(); return false;}
	if(email.value.trim()==""){alert("이메일 빈칸입니다"); email.focus(); return false;}return true;
		
	}
</script>	
<%@ include file="inc/footer.jsp"%>