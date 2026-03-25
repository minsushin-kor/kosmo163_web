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
	<h4>나라 리스트</h4>
	<div>
		<table>
			<thead>
				<tr>
					<th>나라아이디</th>
					<th>나라이름</th>
					<th>지역번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var ="d">
				<tr>
					<td><a href="/country/detail?countryId=${d.countryId}">${d.countryId}</a></td>
					<td>${d.countryName}</td>
					<td>${d.regionId}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>