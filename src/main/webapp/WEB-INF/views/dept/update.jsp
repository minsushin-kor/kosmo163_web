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
						<span class="text-gradient d-inline">부서 정보 수정</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-6">
						<form action="/dept/update" method="post"
							class="card p-4 shadow-sm">
							<input type="hidden" value="${dto.departmentId}"
								name="departmentId">

							<div class="form-floating mb-3">
								<input class="form-control" id="deptName" type="text"
									value="${dto.departmentName}" name="departmentName"
									placeholder="부서명"> <label for="deptName">부서명</label>
							</div>

							<div class="form-floating mb-3">
								<input class="form-control" id="managerId" type="text"
									value="${dto.managerId}" name="managerId" placeholder="관리자 코드">
								<label for="managerId">관리자 코드</label>
							</div>

							<div class="form-floating mb-3">
								<input class="form-control" id="locationId" type="text"
									value="${dto.locationId}" name="locationId" placeholder="지역 코드">
								<label for="locationId">지역 코드</label>
							</div>

							<div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
								<button class="btn btn-primary btn-lg px-4" type="submit">수정완료</button>
								<button class="btn btn-outline-secondary btn-lg px-4"
									type="reset">초기화</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>