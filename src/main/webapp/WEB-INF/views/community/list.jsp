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
	<h1> 목록 리스트 </h1>
	<div>
		<table>
			<thead>
        		<tr>
            		<th>글 번호</th><th>글 제목</th>
        		</tr>
    		</thead>

    		<tbody>
         		<c:forEach items="${list}" var="d">
         			<tr>
             		<td>${d.num}</td>
             		<td>${d.title}</td>
         			</tr>   
				</c:forEach>
    		</tbody>
		</table>
	</div>
	<div>
		<button>새글 등록</button>
	</div>
</body>
</html>