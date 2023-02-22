<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h3>공지사항</h3>
		</div>
		<div align="center">
			<form id="frm" action="noticeInsert.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="200"><input type="text" id="noticeWriter"
								name="noticeWriter" value="${memberId }" readonly="readonly"></td>

							<th width="150">작성일자</th>
							<td width="200"><input type="date" id="noticeDate"
								name="noticeDate" required="required"></td>
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="4"><input type="text" id="noticeTitle"
								name="noticeTitle" required="required"></td>
						</tr>
						<tr>
							<th>내 용</th>
							<td colspan="3"><textarea rows="10" cols="80"
									id="noticeSubject" name="noticeSubject"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3"><input type="file" id="file" name="file"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="hidden" value="0" name="noticeId">
				</div>
				<div>
					<input type="submit" value="등록">&nbsp;&nbsp; <input
						type="reset" value="취소">
				</div>
			</form>
		</div>

	</div>
</body>
</html>