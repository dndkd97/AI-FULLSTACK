<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp"%>


<form action="id_action.jsp" method="post" onsubmit="return check()">
	<div class="container card my-3">
	<h3>이메일 찾기</h3>
	
		<div class="my-3">
			<label for="mobile" class="form=label">휴대폰번호</label>
			<input type="text" class="form-control" id="mobile" name="mobile"/>
		</div>
		
		<div class="my-3">
			<label for="nickname" class="form=label">닉네임</label>
			<input type="text" class="form-control" id="nickname" name="nickname"/>
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
	let nickname = document.getElementById("nickname");

	if(mobile.value.trim()==""){alert("휴대폰번호 빈칸입니다"); mobile.focus(); return false;}
	if(nickname.value.trim()==""){alert("닉네임 빈칸입니다"); nickname.focus(); return false;}return true;
		
	}
</script>
<%@ include file="inc/footer.jsp"%>