<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file = "inc/header.jsp" %>
<%
int bno=Integer.parseInt(request.getParameter("bno"));
String bname="";
String bpass="";
String btitle="";
String bcontent="";
int bhit=0;
try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
	
	PreparedStatement pstmt2 = null;
    pstmt2 = conn.prepareStatement( "update mvcboard1 set bhit = bhit + 1 where bno=?" );
    pstmt2.setInt(1, bno);  pstmt2.executeUpdate();
	
	pstmt = conn.prepareStatement("select*from mvcboard1 where bno=?");

	pstmt.setInt(1,bno);
	ResultSet rset=null;
	rset = pstmt.executeQuery();
	while(rset.next()){
		       bname=rset.getString("bname");
				bpass=rset.getString("bpass");
				btitle=rset.getString("btitle");
				bcontent=rset.getString("bcontent");
				bhit=rset.getInt("bhit");
	}

	
	
}catch(Exception e){e.printStackTrace();}

%>
   <div class="container card my-5">
      <h3 class="card-header my-1 bg-secondary">글 상세보기</h3>
<form action="" method="post" onsubmit="return check()">

<div class="my-3">
<label >조회수</label>
<input type="text" class="form-control" value=<%=bhit %> id="bname" name="bname" readonly/>
</div>
      
       <div class="my-3">
       <label for="bname">이름</label>
       <input type="text" class="form-control" value=<%=bname %> id="bname" name="bname" readonly/>
       </div>

             <div class="my-3">
       <label for="btitle">제목</label>
       <input type="text" class="form-control" value=<%=btitle %> id="btitle" name="btitle" readonly/>
       </div>
        <div class="my-3">
       <label for="bcontent">내용</label>
       <input type="text" class="form-control" value=<%=bcontent %> id="bcontent" name="bcontent" readonly/>
       </div>
       
       <div class="my-3 text-end">
       <a href="edit.jsp?bno=<%=bno%>" class="btn btn-primary" title="글수정">수정</a>
       <a href="delete.jsp?bno=<%=bno %>" class="btn btn-danger" title="글삭제">삭제</a>
       <a href="list.jsp" class="btn btn-primary" title="글목록">목록</a>
       </div>
       
         </form>
   </div>
<%@ include file = "inc/footer.jsp"%>