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

<!-- button style -->
<link rel="stylesheet" href="css/button.css">


<!-- <script src="js/noticeAjaxFetch.js"></script> -->
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
			</a> <span class="stext-109 cl4"> 이벤트 </span>
		</div>
		<div class="p-l-30 p-b-100">
			<br>
			<h2 class="mb-5">이벤트</h2>
			<div class="table-responsive">
				<table class="table custom-table" id="dataTable">
					<thead>
						<tr>
							<th scope="col" style="text-align: center"><label
								for="title">글번호</label></th>
							<th scope="col" style="text-align: center"><label
								for="title">제목</label></th>
							<th scope="col" style="text-align: center"><label
								for="writer">작성자</label></th>
							<th scope="col" style="text-align: center"><label for="date">작성일</label></th>
							<th scope="col" style="text-align: center"><label for="hit">조회수</label></th>

						</tr>
					</thead>
					<tbody>
						<c:if test="${empty notice }">
							<tr style="cursor: pointer;">
								<td colspan="6" align="center">게시글이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<c:if test="${not empty notice }">
								<c:forEach items="${notice }" var="n">
									<tr onclick="noticeSelect('${n.noticeNum}')"
										style="cursor: pointer;">
										<!-- 										<th scope="row"><label class="control control--checkbox"> -->
										<!-- 												<input type="checkbox" /> -->
										<!-- 												<div class="control__indicator"></div> -->
										<!-- 										</label></th> -->
										<td align="center">${n.noticeNum }</td>
										<td align="center">${n.noticeTitle }</td>
										<td align="center">${n.noticeWriter }</td>
										<td align="center">${n.noticeDate }</td>
										<td align="center">${n.noticeHit }</td>
									</tr>

								</c:forEach>
							</c:if>

						</tr>



					</tbody>
				</table>

			</div>
			<div>
				<form id="frm" action="noticeSelect.do" method="post">
					<%-- 					<c:if test="${memberRole eq 'ADMIN' }"> --%>
					<!-- 						<input type="button" value="글작성" -->
					<!-- 							onclick="location.href='noticeInsertForm.do'" -->
					<!-- 							style="cursor: pointer"> -->
					<%-- 					</c:if> --%>
					<c:if test="${memberRole eq 'ADMIN' }">
						<button type="button"
							onclick="location.href='noticeInsertForm.do'"
							class="gradient-btn" style="cursor: pointer;">글작성</button>

					</c:if>
					<input type="hidden" id="noticeNum" name="noticeNum">
				</form>
			</div>

		</div>

	</div>
	<script type="text/javascript">
		//선택한 글 상세보기
		function noticeSelect(noticeNum) {
			document.getElementById("noticeNum").value = noticeNum;
			frm.submit();
		}
	</script>


	<script src="js/notice/jquery-3.3.1.min.js"></script>
	<script src="js/notice/popper.min.js"></script>
	<script src="js/notice/bootstrap.min.js"></script>
	<script src="js/notice/main.js"></script>
</body>
</html>