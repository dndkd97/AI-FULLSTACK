<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header2.jsp" %>
    <!--content-->
    <section class="container my-5">
        <h3>MultiBoard</h3>
     <table class="table table-striped table-bordered table-hover table-white">
        <caption> BOARD 목록</caption>
      <thead>
      <tr>
        <th scope="col">NO</th>
        <th scope="col" >TITLE</th>
        <th scope="col">WRITER</th>
        <th scope="col">DATE</th>
        <th scope="col">HIT</th>
      </tr>
      </thead>
      <tbody>
      <%
      request.setCharacterEncoding("UTF-8");
      try{
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig", "root", "1234");
    	  PreparedStatement pstmt= null; ResultSet rset = null;

    	  pstmt = conn.prepareStatement("select b.* , (select count(*) from mvcboard1)`cnt` "+" from mvcboard1 b order by bno desc" , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
 
    	  rset=pstmt.executeQuery(); //표
    	  int no =-1;
    	  if(rset.next()){no=rset.getInt("cnt"); //칸 
    	  				  rset.beforeFirst(); //다시 처음부터 표기
    	  }
    	  
    	  while(rset.next()){
    		  out.println("<tr><td>"+ no-- +"</td><td>"
    	  +"<a href='detail.jsp?bno="+rset.getInt("bno")+"'>"+rset.getString("btitle")
    		  +"</a></td><td>"+rset.getString("bname")+"</td><td>"+rset.getString("bdate")
    		  +"</td><td>"+rset.getString("bhit")+"</td></tr>"  ); }
    	  if(rset!=null){rset.close();}
    	  if(pstmt!=null){pstmt.close();}
    	  if(conn!=null){conn.close();}
      }catch(Exception e){e.printStackTrace();}
      %>
      </tbody>
     </table>
     <form action="write.jsp" method="get" onsubmit="return check()">
     <div class="text-end">
        <button type="submit" class="btn btn-primary"> 글쓰기 </button>
     </div>
     </form>
    </section>
<%@ include file="inc/footer.jsp" %>