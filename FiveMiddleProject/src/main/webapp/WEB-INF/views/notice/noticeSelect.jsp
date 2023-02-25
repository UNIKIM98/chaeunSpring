<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/admin/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/admin/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/admin/style.css">

<!-- button style -->
<link rel="stylesheet" href="css/button.css">
<title>공지사항 상세보기</title>
</head>
<body>

	<div class="container">
	<br><br><br><br>

		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="main.do" class="stext-109 cl8 hov-cl1 trans-04">Home<i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <a href="notice.do" class="stext-109 cl8 hov-cl1 trans-04"> 이벤트 <i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4">${notice.noticeTitle } </span>

	</div>
	<br>
		<div class="row">
		
		<h2 class="mb-5">이벤트</h2>
		<br><br><br>
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
<!-- 						<th colspan="3" style="background-color: #eeeeee; text-align: center;"></th>						 -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">제목</td>
						<td colspan="2">${notice.noticeTitle }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${notice.noticeWriter }</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">${notice.noticeDate }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;">${notice.noticeSubject }</td>
					</tr>
				</tbody>
			</table>
			<div>
		<form id="frm" method="post">
			
				<button type="button" onclick="location.href='notice.do'"
				class="gradient-btn" style="cursor: pointer;">목록으로</button>&nbsp;&nbsp;
			<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
			<c:if test="${memberRole eq 'USER' }">
			<br><br><br>
			</c:if>
			<c:if test="${memberRole eq 'ADMIN' }">
				<button type="button" onclick="noticeEdit('E')" class="gradient-btn" 
				style="cursor: pointer;">글 수정</button>&nbsp;&nbsp;
				<button type="button" onclick="noticeEdit('D')" class="gradient-btn" 
				style="cursor: pointer;">글 삭제</button>&nbsp;&nbsp;<br><br><br>
			</c:if>
		</form>
	</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
	<script type="text/javascript">
	function noticeEdit(str) {
		if(str == 'E') {
			frm.action="noticeEditForm.do";
		}else {
			let yn = confirm("작성글을 삭제하시겠습니까?");
			if(yn) {
				frm.action="noticeDelete.do";
			}else {
				return false;
			}
		}
		frm.submit();
	}
</script>
</body>
</html>