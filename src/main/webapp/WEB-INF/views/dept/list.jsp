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
	<h4>부서 리스트</h4>
	<div>
		<table>
			<thead> 
				<tr>
					<th>부서번호</th>	
					<th>부서명</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach items="${list}" var ="d">
					<tr>
						<!-- 
						getter 의 이름 : getter 메서드에서 get을 빼고 ()뺀 형식에서 나온 결과물의 첫 글자를 소문자로 바꿔야한다.
						예시 : getName() =>> name
			 			-->
						<td>${d.departmentId}</td>
						<td><a href="/dept/detail?departmentId=${d.departmentId}">${d.departmentName}</a></td>
					</tr> 
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
