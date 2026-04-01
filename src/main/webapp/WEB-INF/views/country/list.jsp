<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
					<h1 class="display-5 fw-bolder mb-0">
						<span class="text-gradient d-inline">국가관리 홈페이지</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
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
								<c:forEach items="${list}" var="d">
									<tr>
										<td><a href="/country/detail?countryId=${d.countryId}">${d.countryId}</a></td>
										<td>${d.countryName}</td>
										<td>${d.regionId}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</section>
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>