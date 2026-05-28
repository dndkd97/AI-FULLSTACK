<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-3 p-3">
	   <table class="table table-striped my-3">
		   <tbody>
			   <tr> <th scope="row">닉네임</th> <td><%=request.getParameter("nickname") %></td> </tr>
			   <tr> <th scope="row">이메일</th> <td><%=request.getParameter("email") %></td> </tr>
			   <tr> <th scope="row">휴대폰</th> <td><%=request.getParameter("mobile") %></td> </tr>
		   </tbody>
	   </table>
   </div>
</body>
</html>