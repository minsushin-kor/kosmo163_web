<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>새로운 글 작성</h4>
	
	<form action="./create" method="post">
		<div>
			<label>제목</label>
			<!-- DTO의 setter의 이름과 동일하게 -->
			<input type="text" placeholder="제목" name="title">
		</div>
		<div>
			<label>작성자</label>
			<input type="text" name="name" placeholder="홍길동">
		</div>
		
		<div>
			<label>메모 내용</label>
			<input type="text" name="contents">
		</div>
		
		<div>
			<label>중요도</label>
			<input type="text" name="star">
		</div>
		
		<input type="submit" value="create">		
	
	</form>
</body>
</html>