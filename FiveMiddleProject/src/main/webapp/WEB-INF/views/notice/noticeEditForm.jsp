<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
<div align="center">
	<div><h2>공지사항 수정</h2></div>
	<br>
	<div align="center">
		<form id="frm" action="noticeUpdate.do" method="post" enctype="multipart/form-data" onsubmit="return datack()">
		<div>
			<table border="1">
				<tr>
					<th width="100">작성자</th>
					<td width="200">
						${notice.noticeWriter }
					</td>
					<th width="150">작성일자</th>
					<td width="200">
						<input type="text" id="noticeDate" name="noticeDate" value="${notice.noticeDate }">
					</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="3">
						<input type="text" size="77" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }">
					</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="3">
						<textarea rows="10" cols="79" id="noticeSubject" name="noticeSubject">${notice.noticeSubject }</textarea>
					</td>
				</tr>
			</table>
		</div><br>
		<div>
			<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
			<input type="hidden" name="noticeHit" value="${notice.noticeHit }">
			<input type="hidden" name="noticeWriter" value="${notice.noticeWriter }">
			<input type="submit" value="수정">&nbsp;&nbsp;
			<input type="button" value="취소" onclick="location.href='notice.do'">
		</div>
		</form>
	</div>
</div>


<script type="text/javascript">
		window.onload = function() {
			CKEDITOR.replace('content', {
				height : 500,
				filebrowserUploadUrl: '${pageContext.request.contextPath}/fileupload.do'
			});
		}
		
		function datack() {
			let id = document.getElementById('content').value;

			if (CKEDITOR.instances.content.getData() == "") {
				console.log(id);
				alert("강의 내용을 입력해주세요");

				return false;
			} else {
				console.log(id);
				frm.submit();
				return true;
			}

		}
	</script>

</body>
</html>