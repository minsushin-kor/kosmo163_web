<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Community Detail Page</h1>
	
	<div>
	<h4>글 번호 : ${dto.num}</h4>
	</div>
	
	<div>
	<h4>글 제목 : ${dto.title}</h4>
	</div>
	
	<div>
		<h4>작성자 : ${dto.name}</h4>
	
	</div>
		<h4>작성 시간 : ${dto.createTime}</h4>
	
	<div>
	
	</div>
		<h4>메모 내용 : ${dto.contents}</h4>
	
	<div>
		<h4>중요도 : ★ X ${dto.star}</h4>
	
	</div>
	<a href="./update?num=${dto.num}"><button>수정</button></a>

	<form action="./delete" method="get">
		<input type="hidden" name="num"  value="${dto.num}">
		<button>삭제</button>
	</form>
</body>
</html>