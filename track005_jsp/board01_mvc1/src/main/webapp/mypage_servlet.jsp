<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="inc/header2.jsp"%>

<div class="container card my-3">
<h3>마이페이지</h3>
<table class="table table-striped my-3">
<tbody >

<tr><th scope="row">닉네임</th><td>${nickname}</td></tr>
<tr><th scope="row">이메일</th><td>${email}</td></tr>
<tr><th scope="row">휴대폰</th><td>${mobile}</td></tr>
<tr><th scope="row">가입일</th><td>${udate}</td></tr>
<tr><th scope="row">가입IP</th><td>${bip}</td></tr>

</tbody>
</table>

</div>

<%@ include file="inc/footer.jsp"%>