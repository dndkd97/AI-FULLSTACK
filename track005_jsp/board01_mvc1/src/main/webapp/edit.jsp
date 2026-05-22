<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header.jsp" %>

<%
String bno=request.getParameter("bno");
String bname="";
String bpass="";
String btitle="";
String bcontent="";

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	pstmt = conn.prepareStatement("select*from mvcboard1 where bno=?");
	pstmt.setString(1,bno);
	ResultSet rset=null;
	rset = pstmt.executeQuery();
	while(rset.next()){
		       bname=rset.getString("bname");
				bpass=rset.getString("bpass");
				btitle=rset.getString("btitle");
				bcontent=rset.getString("bcontent");
	}
	
}catch(Exception e){e.printStackTrace();}

%>
 <form action="edit_action.jsp" method="get" onsubmit="return check()">
 <input type="hidden" name="bno" value="<%=bno%>">
   <div class="container card my-5">
      <h3 class="card-header bg-info-subtle my-1">글 수정</h3>
       <div class="my-3">
       <label for="bname">이름</label>
       <input type="text" class="form-control" value="<%=bname %>" id="bname" name="bname" readonly />
       </div>
             <div class="my-3">
       <label for="bpass">비밀번호</label>
       <input type="text" class="form-control" value="<%=bpass %>" id="bpass" name="bpass" readonly/>
       </div>
             <div class="my-3">
       <label for="btitle">제목</label>
       <input type="text" class="form-control" value="<%=btitle %>" id="btitle" name="btitle"/>
       </div>
        <div class="my-3">
       <label for="bcontent">내용</label>
       <input type="text" class="form-control p-5" value="<%=bcontent %>" id="bcontent" name="bcontent"/>
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
<%@include file="inc/footer.jsp" %>