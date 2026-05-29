<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp" %>


 <form action="write_action.jsp" method="post" onsubmit="return check()">
   <div class="container card my-5">
      <h3 class="card-header bg-warning my-1">글 등록</h3>
       <div class="my-3">
       <label for="bname" class="form-label">이름</label>
       <input type="text" class="form-control" id="bname" name="bname" />
       </div>
             <div class="my-3">
       <label for="bpass">비밀번호</label>
       <input type="text" class="form-control" id="bpass" name="bpass" />
       </div>
             <div class="my-3">
       <label for="btitle">제목</label>
       <input type="text" class="form-control" id="btitle" name="btitle"/>
       </div>
        <div class="my-3">
       <label for="bcontent">내용</label>
       <input type="text" class="form-control p-5" id="bcontent" name="bcontent"/>
       </div>

     <div class="my-3 text-end">
     
        <button type="submit" title="입력" class="btn btn-primary">입력</button>
        <button type="reset" class="btn btn-danger">취소</button>
        <a href="list.jsp" class="btn btn-primary">목록보기</a>
     </div>
   </div>
    </form>
    <script>
    function check(){
    	let bname = document.getElementById("bname");
    	let bpass = document.getElementById("bpass");
    	let btitle = document.getElementById("btitle");
    	let bcontent = document.getElementById("bcontent");
    	
    	if(bname.value.trim()==""){ alert("이름 빈칸입니다"); bname.focus(); return false; }
    	if(bpass.value.trim()==""){ alert("비밀번호 빈칸입니다"); bpass.focus(); return false; }
    	if(btitle.value.trim()==""){ alert("제목 빈칸입니다"); btitle.focus(); return false; }
    	if(bcontent.value.trim()==""){ alert("내용 빈칸입니다"); bcontent.focus(); return false; }return true;
    	
    }
    
    </script>
<%@ include file="inc/footer.jsp"%>