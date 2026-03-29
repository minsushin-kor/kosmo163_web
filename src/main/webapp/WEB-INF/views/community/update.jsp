<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메모 수정</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		<input type="hidden" name="createTime" value="${dto.createTime}">
		<div>
			<label>제목</label>
			<!-- DTO의 setter의 이름과 동일하게 -->
			<input type="text" value="${dto.title}" placeholder="제목" name="title">
		</div>
		<div>
			<label>작성자</label>
			<input type="text" name="name" value="${dto.name}" placeholder="작성자">
		</div>
		
		<div>
			<label>내용</label>
			<input type="text" name="contents" value="${dto.contents}" placeholder="내용">
		</div>
		
		<div>
			<label>중요도</label>
			<input type="text" name="star" value="${dto.star}" placeholder="숫자만 입력하세요">
		</div>
		
		<input type="submit" value="수정">
	
	</form>
</body>
</html>