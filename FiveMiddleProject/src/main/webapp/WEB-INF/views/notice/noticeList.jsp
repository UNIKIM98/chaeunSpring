<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>

<link rel="stylesheet" href="css/admin/adminProductList.css">

<!-- <script src="js/noticeAjaxFetch.js"></script> -->
<title>Table #9</title>
</head>
<body>

	<section class="notice">
		<br> <br> <br>
		<div class="page-title">

			<div class="container">
				<h3>공지사항</h3>
			</div>
		</div>
		<!-- board list area -->
		<div id="board-list">
			<div class="container">
				<form action="">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-writer">작성자</th>
								<th scope="col" class="th-date">작성일</th>
								<th scope="col" class="th-hit">조회수</th>

							</tr>
						</thead>
						<tbody>
							<c:if test="${empty notice }">
								<tr>
									<td colspan="5" align="center">게시글이 없습니다.</td>
								</tr>
							</c:if>
							<c:if test="${not empty notice }">
								<c:forEach items="${notice }" var="n">
									<tr class="tr" id="${n.noticeNum }"
										onmouseover="this.style.background='#fcecae'"
										onmouseleave="this.style.background='#FFFFFF'"
										onclick="noticeSelect('${n.noticeNum}')"
										style="cursor: pointer">
										<td align="center">${n.noticeNum }</td>
										<td align="center">${n.noticeTitle }</td>
										<td align="center">${n.noticeWriter }</td>
										<td align="center">${n.noticeDate }</td>
										<td align="center">${n.noticeHit }</td>
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
					</table>
				</form>
			</div>
			<br>


			<div align="center">
				<form id="frm" action="noticeSelect.do" method="post">
					<c:if test="${memberRole eq 'ADMIN' }">
						<input type="button" value="글작성"
							onclick="location.href='noticeInsertForm.do'"
							style="cursor: pointer">
					</c:if>
					<input type="hidden" id="noticeNum" name="noticeNum">
				</form>
			</div>

			<div>
				<!-- 				<form id="frm" action="noticeSelect.do" method="post"> -->

				<!-- 						<input type="button" value="글작성" -->
				<!-- 							onclick="location.href='noticeInsertForm.do'" -->
				<!-- 							> -->

				<!-- 					<input type="hidden" id="noticeNum" name="noticeNum"> -->
				<!-- 				</form> -->
			</div>

		</div>


	</section>
	<script type="text/javascript">
		//선택한 글 상세보기
		function noticeSelect(noticeNum) {
			document.getElementById("noticeNum").value = noticeNum;
			frm.submit();
		}
	</script>


	<!-- 	<script src="js/notice/jquery-3.3.1.min.js"></script> -->
	<!-- 	<script src="js/notice/popper.min.js"></script> -->
	<!-- 	<script src="js/notice/bootstrap.min.js"></script> -->
	<!-- 	<script src="js/notice/main.js"></script> -->
</body>
</html>