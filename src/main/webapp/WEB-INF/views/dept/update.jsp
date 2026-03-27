<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 정보 수정</h1>
	
	<form action="/dept/update" method="post">
	<div> 
		<input type="hidden" value = "${dto.departmentId}" name="departmentId">
	</div>
	
	<div> 
		<label for="ch">부서명</label>
		<!-- input의 name parameter을 정할 때에는 DTO의 setter의 이름과 동일하게 설정 -->
		<input type="text" value = "${dto.departmentName}" name="departmentName">
	</div>
	<div>
		<label>관리자 코드</label>
		<input type="text" value = "${dto.managerId}" name="managerId">
	</div>		
	<div>
		<label>지역 코드</label>
		<input type="text" value = "${dto.locationId}" name="locationId">
	</div>
		
		<!-- 버튼의 역할을 type에 적어주면 된다. 적지 않을 경우 기본은 submit -->
		<button type="submit">button</button>
		<input type="submit" value = "create">
		<input type="button" value = "등록">
		<input type="reset" value = "reset">
		
	</form>
	
</body>
</html>