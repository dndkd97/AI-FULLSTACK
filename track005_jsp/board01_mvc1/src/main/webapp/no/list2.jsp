<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head >
<meta charset="UTF-8">
<title>MVC1-BORAD</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/board01_mvc1/src/main/webapp/css/board.css" rel="stylesheet">
<link href="/board01_mvc1/css/board.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <!--header-->
    <header>
        <div class="p-5 bg-info-subtle text-white text-center myvisual">
         <div class="text-black">
        <h1>First Template</h1>
        <p>MVC1 JSP PROJECT</p>
         </div>
        </div>
    <nav class="navbar navbar-expand-sm navbar-dark bg-danger-subtle">
        <h2 class="myhidden">주메뉴</h2>
    <div class="container-fluid">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/list2.jsp">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav ms-auto">
      
      
     <%  if(session.getAttribute("email") == null){%>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Login</a>
        </li>
        <% } else{%>
        
                <li class="nav-item">
          <a class="nav-link" href="logout1.jsp">Logout</a>
        </li>
<%} %>
        <li class="nav-item">
          <a class="nav-link" href="join.jsp">Join</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="mypage.jsp">Mypage</a>
        </li>
                <li class="nav-item">
          <a class="nav-link" href="id.jsp">아이디찾기</a>
        </li>
                <li class="nav-item">
          <a class="nav-link" href="pass.jsp">비밀번호찾기</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</header>
<!-- header  -->
<!-- header  -->
<!-- header  -->

 <%  if(session.getAttribute("email")!= null){%>
<div class="container card my-5 p-3 bg-info-subtle">반갑습니다[  <%= session.getAttribute("email") %> ]님 </div>

<% } %>