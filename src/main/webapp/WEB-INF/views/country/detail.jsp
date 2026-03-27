<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Country Detail List</h1>
	<h4>${dto.countryId} </h4>
	<h4>${dto.countryName} </h4>
	<h4>${dto.regionId} </h4>
	
	<a href="/country/delete?countryId=${dto.countryId}">삭제</a>

	<form action="./delete" method="get">
		<input type="hidden" name="countryId" value ="${dto.countryId}">
		<button>DELETE</button>
	</form>
</body>
</html>