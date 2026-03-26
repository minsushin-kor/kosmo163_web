<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 부서 등록 페이지 </h3>
	
	<form action="/dept/create" method="post">
	<div> 
		<label for="ch">부서명</label>
		<!-- input의 name parameter을 정할 때에는 DTO의 setter의 이름과 동일하게 설정 -->
		<input type="text" name="departmentName">
	</div>
	<div>
		<label>관리자 코드</label>
		<input type="text" name="managerId">
	</div>		
	<div>
		<label>지역 코드</label>
		<input type="text" name="locationId">
	</div>
		
		<!-- 버튼의 역할을 type에 적어주면 된다. 적지 않을 경우 기본은 submit -->
		<button type="submit">button</button>
		<input type="submit" value = "create">
		<input type="button" value = "등록">
		<input type="reset" value = "reset">
		
	</form>
</body>
</html>