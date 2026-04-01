<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/temp/nav.jsp"></c:import>
		
		<section class="py-5">
			<div class="container px-5 mb-5">
				<div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">부서관리 홈페이지</span></h1>
                </div>
                
                <div class="row gx-5 justify-content-center">
                	<div class="row gx-5 justify-content-center">
					<div>
						<table class="table table-striped-columns">
							<thead>
								<tr>
									<th>부서번호</th>
									<th>부서명</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="d">
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
					
					<a href="./create" class="btn btn-primary">부서등록</a>
				</div>
                
                </div>        
			</div>
		</section>		
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>