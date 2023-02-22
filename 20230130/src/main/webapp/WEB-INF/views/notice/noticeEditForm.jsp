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
			<h3>공지글 수정</h3>
		</div>
		<div align="center">
			<form id="frm" action="noticeUpdate.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="200">${editNotice.noticeWriter }</td>

							<th width="150">작성일자</th>
							<td width="200"><input type="date" id="noticeDate"
								name="noticeDate" required="required"
								value="${editNotice.noticeDate }"></td>
						</tr>
						<tr>
							<th>제 목</th>
							<td colspan="4"><input type="text" id="noticeTitle"
								name="noticeTitle" required="required"
								value="${editNotice.noticeTitle }"></td>
						</tr>
						<tr>
							<th>내 용</th>
							<td colspan="3"><textarea rows="10" cols="80"
									id="noticeSubject" name="noticeSubject">${editNotice.noticeSubject }</textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">${editNotice.noticeFile }<input type="file" id="file" name="file"></td>
						</tr>

					</table>
				</div>
				<br>
				<div>
					<input type="hidden" name="noticeId" id="noticeId"
						value="${editNotice.noticeId }"> 
						<input type="hidden" name="noticeWriter" id="noticeWriter" value="${editNotice.noticeWriter }"> 
						<input type="hidden" name="noticeHit" id="noticeHit" value="${editNotice.noticeHit }">
					<input type="submit" value="수정하기">&nbsp;&nbsp;
				</div>
			</form>
		</div>
		<div style="display: inline">
			<form action="noticeSelect.do" method="post">
				<input type="hidden" value="${editNotice.noticeId }" name="noticeId"
					id="noticeId"> <input type="submit" value="취소">
			</form>
		</div>

	</div>
	<script type="text/javascript">
	window.onload = function(){
		let message = "${message}"
		if(message != ""){
			alert(message);
		}
	}
	
	function update(){
		//위에 폼 input 타입을 submit에서 button으로 바꾸고(화면을 벗어나지 않게)
		//json 객체이므로 @RequestBody로 받아야함
		//data set
		//fetch(url, {	
		//}).then(response => alert(response.text()));
	}
	</script>
</body>
</html>