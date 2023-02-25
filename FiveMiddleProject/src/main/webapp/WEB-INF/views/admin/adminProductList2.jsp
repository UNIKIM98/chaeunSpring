<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" s>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/admin/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/admin/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/admin/style.css">

<!-- button style -->
<link rel="stylesheet" href="css/button.css">

<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="main.do" class="stext-109 cl8 hov-cl1 trans-04">Home<i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> 강의관리 </span>
		</div>
		<div class="p-l-30 p-b-100">
			<br>
			<div align="center">
				<h2 class="mb-5">강의관리</h2>
			</div>
			<div class="table-responsive">
				<table class="table custom-table" id="dataTable">
					<thead>
						<tr>
							<th scope="col" style="text-align: center" class="th-num"><label
								for="title">강의 번호</label></th>

							<th scope="col" style="text-align: center" class="th-num"><label
								for="title">강의사진</label></th>

							<th scope="col" style="text-align: center" class="th-name"><label
								for="title">강의 이름</label></th>
							<th scope="col" style="text-align: center" class="th-trainer"><label
								for="writer">강사명</label></th>
							<th scope="col" style="text-align: center" class="th-Price"><label
								for="date">가격</label></th>
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">수정</label></th>
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">삭제</label></th>

						</tr>
					</thead>
					<tbody>
						<c:if test="${empty list }">
							<tr>
								<td colspan="7" align="center">등록된 강의가 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<c:if test="${not empty list }">
								<c:forEach items="${list }" var="list">
									<tr class="tr" id="${list.productNum }">
										<td align="center">${list.productNum }</td>
										<td align="center" style="cursor: pointer;"
											onclick="productSelect('${list.productNum }')"
											id="${list.productNum }">
											<form id="frm" action="productSelect.do" method="post">
												<input type="hidden" id="productNum" name="productNum"
													value="${list.productNum }">
											</form> <img src="attech/${list.productThumbnailUrl }" width="130px"
											height="130px" alt="IMG">
										</td>
										<td align="center">${list.productName }</td>
										<td align="center">${list.productTrainer }</td>
										<td align="center">${list.productPrice }</td>
										<td align="center"><button class=btn_confirm
												type="button"
												onclick="location.href='adminProductUpdateForm.do?productNum=${list.productNum}'">수정</button></td>
										<td align="center"><button class="btn_confirm"
												type="button"
												onclick="location.href='ajaxAdminProductDelete.do?productNum=${list.productNum}'">삭제</button></td>
									</tr>
								</c:forEach>
							</c:if>
						</tr>
					</tbody>
				</table>

			</div>
			<div>
				<form id="frm" action="" method="post">
					<c:if test="${not empty memberId }">
						<input type="button" value="강의 등록" class="gradient-btn"
							onclick="location.href='adminProductInsertForm.do'">
					</c:if>
					<input type="hidden" id="memberId" name="memberId">
				</form>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		//선택한 글 상세보기
		function productSelect(productNum) {
			console.log(productNum)
			console.log(document.getElementById("productNum"))
			document.getElementById("productNum").value = productNum;
			document.getElementById("frm").submit();
		}
	</script>

	<script src="js/notice/jquery-3.3.1.min.js"></script>
	<script src="js/notice/popper.min.js"></script>
	<script src="js/notice/bootstrap.min.js"></script>
	<script src="js/notice/main.js"></script>
</body>
</html>