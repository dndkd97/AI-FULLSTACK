<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <div class="alert bg-danger text-white p-5">
 <h1>MILK ORDER Project</h1>
  <p>MVC1 - preparedStatement Ex</p>
 </div>
<!-- table table-striped table-bordered table-hover -->
   <div class="container card my-5 p-3 text-white">
      <h2 class="card-header bg-danger">Milk Menu</h2>
      
      <table class="table table-striped table-bordered table-hover">
      <caption>우유메뉴</caption>
      <thead class="table-dark">
      <tr>
      	<th scope="col">NO</th>
      	<th scope="col">NAME</th>
      	<th scope="col">PRICE</th>
      </tr>
      </thead>
      <tbody>
      <%@page import="java.sql.*" %>
      <%
      try{
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    	  PreparedStatement pstmt = null; ResultSet rset=null;
    	  pstmt = conn.prepareStatement("select*from milk order by mprice asc");
    	  rset = pstmt.executeQuery();
    	  while(rset.next()){  
    		  out.println("<tr><td>"+rset.getInt("mno")+"</td><td>"+rset.getString("mname")+"</td><td>"
    		  +rset.getInt("mprice")+ "</td></tr>");
    	   }
    	  if(rset!=null){rset.close();}
    	  if(pstmt!=null){pstmt.close();}
    	  if(conn!=null){conn.close();}
      //1.드라이버연동
      //2.JDBC 연동
      //3.PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기
      // 가격이 낮은순으로
      //4.JDBC 끊기
      }catch(Exception e){e.printStackTrace();}
      %>
      
      </tbody>
      </table>
   </div>
   <div class="container card my-5 bg-dark text-white p-3">
   <h3>MILK ORDER</h3>
         <table class="table table-striped table-bordered table-hover">
      <thead>
      <tr>
      	<th scope="col">NO</th>
      	<th scope="col">NAME</th>
      	<th scope="col">NUM</th>
      	<th scope="col">주문날짜</th>
      </tr>
      </thead>
      <tbody>
      <%
      try{
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    	  PreparedStatement pstmt = null; ResultSet rset = null;
    	  pstmt = conn.prepareStatement("select*from milk_order order by ono asc");
    	  rset=pstmt.executeQuery(); // 표 executeQuery(select) 
    	                             //   executeUpdate(insert,update,delete)
    	  while(rset.next()){
    		  out.println("<tr><td>"+rset.getInt("ono")+"</td><td>"+rset.getString("oname")+"</td><td>"+
    	                 rset.getInt("onum")+"</td><td>"+rset.getString("odate")+"</td></tr>");
    	  }
    	  if(rset!=null){rset.close();}
    	  if(pstmt!=null){pstmt.close();}
    	  if(conn!=null){conn.close();}
      }catch(Exception e){e.printStackTrace();} 
      %>
      </tbody>
     </table>
     </div>

   <div class="container card my-5 p-3 bg-dark text-white">
   <h3 class="card-header my-3">MILK 주문,수정,삭제</h3>
<div id="accordion">

  <div class="card">
    <div class="card-header bg-secondary">
      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
        주문하기
      </a>
    </div>
    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
      <div class="card-body">
	       <form action="jsp012_insert.jsp" method="post" onsubmit="return order()">
		       <div class="my-3">
			       <label for="oname" class="form-lael">주문할 우유 이름</label>
			       <input type="text" class="form-control" id="oname" name="oname" />
		       </div>
		       <div class="my-3">
		           <label for="onum"  class="form-label">주문할 우유 갯수</label>
		           <input type="text" class="form-control" id="onum" name="onum" />
		       </div>
		       <div class="my-3"> 
		           <button  type="submit"  class="btn btn-warning" >  주문하기 </button>
		       </div>
	       </form>
	       <script>
	       function order(){
	    	   let oname = document.getElementById("oname");
	    	   let onum = document.getElementById("onum");
	    	   
	    	   if(oname.value===""){
	    		   alert("이름 빈칸입니다");
	    		   oname.focus();
	    		   return false;}
	    	   if(onum.value===""){
	    		   alert("갯수 빈칸입니다");
	    		   onum.focus();
	    		   return false;
	    	   }return true;
	    	   
	       }
	       </script>
	       
	       
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header bg-secondary">
      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
        주문수정
      </a>
    </div>
    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
      <div class="card-body">
        	       <form action="jsp012_update.jsp" method="post" onsubmit="return order1()">
        	   <div class="my-3">
			       <label for="ono" class="form-lael">주문수정할 우유 번호</label>
			       <input type="text" class="form-control" id="ono1" name="ono" />
		       </div>
		       <div class="my-3">
			       <label for="oname" class="form-lael">주문수정할 우유 이름</label>
			       <input type="text" class="form-control" id="oname1" name="oname" />
		       </div>
		       <div class="my-3">
		           <label for="onum"  class="form-label">주문수정할 우유 갯수</label>
		           <input type="text" class="form-control" id="onum1" name="onum" />
		       </div>
		       <div class="my-3"> 
		           <button  type="submit"  class="btn btn-warning" >  수정하기 </button>
		       </div>
	       </form>
	       <script>
	       function order1(){
	    	   let oname = document.getElementById("oname1");
	    	   let onum = document.getElementById("onum1");
	    	   let ono =document.getElementById("ono1");
	    	   
	    	   if(ono.value===""){
	    		   alert("번호 빈칸입니다");
	    		   ono.focus();
	    		   return false;}
	    	   if(oname.value===""){
	    		   alert("이름 빈칸입니다");
	    		   oname.focus();
	    		   return false;}
	    	   if(onum.value===""){
	    		   alert("갯수 빈칸입니다");
	    		   onum.focus();
	    		   return false;
	    	   }return true;
	    	   
	       }
	       </script>
      </div>
    </div>
  </div>

  <div class="card">
    <div class="card-header bg-secondary">
      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
        주문삭제
      </a>
    </div>
    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
      <div class="card-body">
         <form action="jsp012_delete.jsp" method="post" onsubmit="return order2()">
        	   <div class="my-3">
			       <label for="ono" class="form-lael">주문삭제할 우유 번호</label>
			       <input type="text" class="form-control" id="ono2" name="ono" />
		       </div>
		     
		       <div class="my-3"> 
		           <button  type="submit"  class="btn btn-warning" >  삭제하기 </button>
		       </div>
	       </form>
	       <script>
	       function order2(){

	    	   let ono =document.getElementById("ono2");
	    	   
	    	   if(ono.value===""){
	    		   alert("번호 빈칸입니다");
	    		   ono.focus();
	    		   return false;}
	    	    return true;
	    	   
	       }
	       </script>
      </div>
    </div>
  </div>
<div class="card">
    <div class="card-header bg-secondary">
      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseFour">
        milk 검색
      </a>
    </div>
    <div id="collapseFour" class="collapse" data-bs-parent="#accordion">
      <div class="card-body">
         <form action="jsp012_search.jsp" method="post" onsubmit="return order3()">
        	   <div class="my-3">
			       <label for="mno" class="form-lael">우유 번호</label>
			       <input type="text" class="form-control" id="mno3" name="mno" />
		       </div>
		     
		       <div class="my-3"> 
		           <button  type="submit"  class="btn btn-warning" > milk 검색 </button>
		       </div>
	       </form>
	       <script>
	       function order3(){

	    	   let mno =document.getElementById("mno3");
	    	   
	    	   if(mno.value===""){
	    		   alert("번호 빈칸입니다");
	    		   ono.focus();
	    		   return false;}
	    	    return true;
	    	   
	       }
	       </script>
      </div>
    </div>
  </div>
</div>

</div>
<div>
<h4></h4>
</div>
</body>
</html>