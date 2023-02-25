<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/admin/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/admin/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/admin/style.css">
<link rel="stylesheet" href="css/button.css">

<title>Table #9</title>
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
			</a> <span class="stext-109 cl4"> FAQ관리 </span>
		</div>
		<div class="p-l-30 p-b-100">
			<br>
			<div align="center">
				<h2 class="mb-5">FAQ 관리</h2>
			</div>

			<div class="table-responsive">
				<table class="table custom-table" id="dataTable">
					<thead>
						<tr>
							<th scope="col" style="text-align: center"><label
								for="title"></label></th>
							<th scope="col" style="text-align: center"><label
								for="title">제목</label></th>
							<th scope="col" style="text-align: center"><label
								for="writer">작성자</label></th>
							<th scope="col" style="text-align: center"><label for="date">작성일</label></th>
							<th scope="col" style="text-align: center"><label for="hit">조회수</label></th>
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">수정</label></th>
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">삭제</label></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty QNAList }">
							<tr>
								<td colspan="6" align="center">게시글이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<c:if test="${not empty QNAList }">
								<c:forEach items="${QNAList }" var="qna">
									<tr class="tr" id="${qna.qnaNum }">
										<td align="center">${qna.qnaNum }</td>
										<td align="center">${qna.qnaTitle }</td>
										<td align="center">${qna.qnaWriter }</td>
										<td align="center">${qna.qnaDate }</td>
										<td align="center">${qna.qnaHit }</td>
										<td align="center"><button class=btn_confirm
												type="button"
												onclick="location.href='qnaEditForm.do?qnaNum=${qna.qnaNum}'">수정</button></td>
										<td align="center"><button class="btn_confirm"
												type="button"
												onclick="location.href='qnaDelete.do?qnaNum=${qna.qnaNum}'">삭제</button></td>

									</tr>

								</c:forEach>
							</c:if>
						</tr>
					</tbody>
				</table>

			</div>
			<div>
				<form id="frm" action="qnaSelect.do" method="post">
					<input type="button" value="FAQ등록" class="gradient-btn"
						onclick="location.href='qnaInsertForm.do'" style="cursor: pointer">
					<input type="hidden" id="qnaNum" name="qnaNum">
				</form>
			</div>
		</div>
	</div>

	<!-- ===================================================================== -->
	<script src="js/notice/jquery-3.3.1.min.js"></script>
	<script src="js/notice/popper.min.js"></script>
	<script src="js/notice/bootstrap.min.js"></script>
	<script src="js/notice/main.js"></script>
</body>
</html>