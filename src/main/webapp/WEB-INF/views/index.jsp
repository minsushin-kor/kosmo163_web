<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html 주석 -->
	<h1>Index Page SMS</h1>
	<div>
		<a href="/comm/list"> 목록 리스트 관리 </a>
	</div>
	
	<div>
		<a href="/member/join">회원 가입</a>
	</div>
	
	<div>
		<c:if test="${empty dto}">
		<a href="/member/login">로그인</a>
		</c:if>
	</div>
	
	<div>
		<c:if test="${not empty dto}">
		<a href="/member/logout">로그아웃</a>
		<a href="">My page</a>
		</c:if>
	</div>
	
</body>
</html>