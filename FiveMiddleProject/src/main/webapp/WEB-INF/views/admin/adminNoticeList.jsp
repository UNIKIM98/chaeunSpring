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
			</a> <span class="stext-109 cl4"> 이벤트관리 </span>
		</div>
		<div class="p-l-30 p-b-100">
			<br>
			<div align="center">
				<h2 class="mb-5">이벤트 관리</h2>
			</div>

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
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">수정</label></th>
							<th scope="col" style="text-align: center" class="th-bnt"><label
								for="hit">삭제</label></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty notice }">
							<tr>
								<td colspan="7" align="center">게시글이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<c:if test="${not empty notice }">
								<c:forEach items="${notice }" var="n">
									<tr class="tr" id="${n.noticeNum }">
										<td align="center">${n.noticeNum }</td>
										<td align="center" style="cursor: pointer;"
											onclick="noticeSelect('${n.noticeNum }')"
											id="${n.noticeNum }">
										<form id="fr" action="noticeSelect.do" method="post">
												<input type="hidden" id="noticeNum" name="noticeNum"
													value="${n.noticeNum }">
											</form>
											${n.noticeTitle }</td>
										<td align="center">${n.noticeWriter }</td>
										<td align="center">${n.noticeDate }</td>
										<td align="center">${n.noticeHit }</td>
										<td align="center"><button class=btn_confirm
												type="button"
												onclick="location.href='noticeEditForm.do?noticeNum=${n.noticeNum}'">수정</button></td>
										<td align="center"><button class="btn_confirm"
												type="button"
												onclick="location.href='adminNoticeDelete.do?noticeNum=${n.noticeNum}'">삭제</button></td>

									</tr>

								</c:forEach>
							</c:if>
						</tr>
					</tbody>
				</table>

			</div>
			<div>
				<form id="frm" action="" method="post">
				<input type="button" class="gradient-btn" value="이벤트 등록"
						onclick="location.href='noticeInsertForm.do'" style="cursor: pointer">
				<input type="hidden" id="noticeNum" name="noticeNum">
				</form>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
		//선택한 글 상세보기
		function noticeSelect(noticeNum) {
			console.log(document.getElementById("noticeNum"))
			document.getElementById("noticeNum").value = noticeNum;
			document.getElementById("fr").submit();
		}
	</script>
	

	<!-- ===================================================================== -->
	<script src="js/notice/jquery-3.3.1.min.js"></script>
	<script src="js/notice/popper.min.js"></script>
	<script src="js/notice/bootstrap.min.js"></script>
	<script src="js/notice/main.js"></script>
</body>
</html>