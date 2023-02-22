<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
	font-family: 'NanumSquareNeo-Variable';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'NanumSquareNeo-Variable';
}
</style>
</head>

<body>
	<div align="center">
		<div>
			<h3>게시글상세</h3>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<td width="200">${notice.noticeWriter }</td>

					<th width="150">작성일자</th>
					<td width="200">${notice.noticeDate }</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="4">${notice.noticeTitle }</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="3" height="300">${notice.noticeSubject }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<c:if test="${empty notice.noticeFile }">
						<td colspan="3" style="color: lightgrey;">${file }</td>
					</c:if>

					<c:if test="${not empty notice.noticeFile }">
						<td colspan="2">첨부파일명 : ${notice.noticeFile }</td>
						<td><img src="resources/upload/${file }" width="200"
							height="200"></td>
					</c:if>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<form id="frm" method="post">
				<c:if test="${memberId eq notice.noticeWriter }">
					<button type="button" onclick="noticeEdit('E')">수정하기</button>
					<button type="button" onclick="noticeEdit('D')">삭제하기</button>
				</c:if>
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
				<input type="button" value="뒤로가기"
					onclick="location.href='noticeList.do'">
			</form>
		</div>
		<!-- 		<div> -->
		<!-- 			<form action="noticeList.do"> -->
		<!-- 				<input type="submit" value="뒤로가기"> -->
		<!-- 			</form> -->
		<!-- 		</div> -->
	</div>

	<script type="text/javascript">
		function noticeEdit(str) {
			if (str == 'E') {
				frm.action = "noticeEdit.do";
			} else {
				let yn = confirm("정말로 삭제하시겠습니까?");
				if (yn) {
					frm.action = "noticeDelete.do"
				} else {
					return false;
				}
			}

			frm.submit();

		}
	</script>

</body>

</html>