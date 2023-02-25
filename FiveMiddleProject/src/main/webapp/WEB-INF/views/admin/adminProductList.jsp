<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/admin/adminProductList.css">
<script src="js/admin/ajaxAdminProductDelete.js"></script>
<body>

	<section class="notice">
		<br> <br> <br>
		<div class="page-title" >
		
			<div class="container" align="center">
				<h3>강의 관리</h3>
			</div>
		</div>
		<!-- board list area -->
		<div id="board-list" >
			<div class="container">
			<form action="">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">강의 번호</th>
							<th scope="col" class="th-name">강의 이름</th>
							<th scope="col" class="th-trainer">강사명</th>
							<th scope="col" class="th-Price">가격</th>
							<th scope="col" class="th-bnt">수정</th>
							<th scope="col" class="th-bnt">삭제</th>
							<th scope="col" class="th-bnt">선택 삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty list }">
							<tr>
								<td colspan="5" align="center">게시글이 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${not empty list }">
							<c:forEach items="${list }" var="list">
								<tr class="tr" id="${list.productNum }">
									<td align="center" >${list.productNum }</td>
									<td align="center">${list.productName }</td>
									<td align="center">${list.productTrainer }</td>
									<td align="center">${list.productPrice }</td>
									<td align="center"><button class=btn_confirm type="button" onclick="location.href='adminProductUpdateForm.do?productNum=${list.productNum}'">수정</td>
									<td align="center"><button class="btn_confirm" type="button" onclick="location.href='ajaxAdminProductDelete.do?productNum=${list.productNum}'">삭제</td>
									<td align="center"><input type="checkbox">
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>
				</form>
			</div><br>
			<div align="center">
				<form id="frm" action="">
					<c:if test="${not empty memberId }">
						<input class="btn_submit" type="button" value="등록"
							onclick="location.href='adminProductInsertForm.do'">
					</c:if>
					<input type="hidden" id="memberId" name="memberId">
				</form>
			</div>
		</div>

	</section>
	<script type="text/javascript">
	</script>
</body>
</html>