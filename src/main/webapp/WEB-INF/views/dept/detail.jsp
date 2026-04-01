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
						<span class="text-gradient d-inline">부서 상세 정보</span>
					</h1>
				</div>

				<div class="row justify-content-center">
					<div class="col-lg-6">
						<div class="card shadow-sm border-0">
							<div class="card-body p-4">

								<div
									class="d-flex justify-content-between align-items-center mb-3 pb-2 border-bottom">
									<span class="fw-bold text-secondary">부서 아이디</span> <span
										class="fs-5 fw-bold">${dto.departmentId}</span>
								</div>

								<div
									class="d-flex justify-content-between align-items-center mb-3 pb-2 border-bottom">
									<span class="fw-bold text-secondary">부서명</span> <span
										class="fs-5 text-primary fw-bolder">${dto.departmentName}</span>
								</div>

								<div
									class="d-flex justify-content-between align-items-center mb-3 pb-2 border-bottom">
									<span class="fw-bold text-secondary">매니저 아이디</span> <span
										class="fs-5 text-dark"> <c:out value="${dto.managerId}"
											default="미지정" />
									</span>
								</div>

								<div
									class="d-flex justify-content-between align-items-center mb-4 pb-2 border-bottom">
									<span class="fw-bold text-secondary">지역 코드</span> <span
										class="fs-5">${dto.locationId}</span>
								</div>

								<div class="d-flex justify-content-center gap-2 mt-4">
									<a href="./list" class="btn btn-outline-secondary px-4">목록으로</a>
									<a href="./update?departmentId=${dto.departmentId}"
										class="btn btn-warning px-4 text-white">수정하기</a>
									<form action="./delete" method="post" class="d-inline"
										onsubmit="return confirm('정말 삭제하시겠습니까?');">
										<input type="hidden" name="departmentId"
											value="${dto.departmentId}">
										<button type="submit" class="btn btn-danger px-4">삭제하기</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
		</section>
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>