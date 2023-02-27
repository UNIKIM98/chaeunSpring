<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/button.css">
<script src="//cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
<script src="ckeditor/ckeditor.js"></script>

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
			</a> <a href="notice.do" class="stext-109 cl8 hov-cl1 trans-04">이벤트<i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> 이벤트 수정 </span>
		</div>
		<div class="row">
			<div class="col-8">
				<br> <br>
				<form action="noticeUpdate.do" method="post"
					enctype="multipart/form-data" onsubmit="return datack()">
					<h2>이벤트 수정</h2>
					<br> <label style="display: block; font-size: mdium;">제목
						<input type="text" class="form-control" id="noticeTitle"
						name="noticeTitle" width="800px" required="required"
						value="${notice.noticeTitle }">
					</label> <br> <label style="display: inline-block;; font-size: midum;">작성자
						<input type="text" class="form-control" id="noticeWriter"
						name="noticeWriter" width="800px" value="${notice.noticeWriter }"
						readonly="readonly">
					</label> <label style="display: inline-block;; font-size: mdium;">작성일
						<input type="text" class="form-control" id="noticeDate"
						name="noticeDate" width="800px" value="${notice.noticeDate }"
						readonly="readonly">
					</label> <br> <br> <label
						style="display: inline-block;; font-size: mdium;">내용</label>
					&nbsp;&nbsp;
					<textarea id="content" name="content">${notice.noticeSubject }</textarea>
					<br>
					<div>
						<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
						<input type="hidden" name="noticeHit" value="${notice.noticeHit }">
						<button type="submit" class="gradient-btn"
							style="float: right;">수정</button>&nbsp;&nbsp;
						<button type="button" class="gradient-btn"
							style="float: right;" onclick="location.href='notice.do'">취소</button>
						<br> <br>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		window.onload = function() {
			CKEDITOR
					.replace(
							'content',
							{
								height : 400,
								filebrowserUploadUrl : '${pageContext.request.contextPath}/fileupload.do'
							});
			date = new Date();
			year = date.getFullYear();
			month = date.getMonth() + 1;
			day = date.getDate();
			document.getElementById("noticeDate").value = year + "/" + month
					+ "/" + day;

		}
	</script>


	<script type="text/javascript">
		window.onload = function() {
			CKEDITOR
					.replace(
							'content',
							{
								height : 500,
								filebrowserUploadUrl : '${pageContext.request.contextPath}/fileupload.do'
							});
		}

		function datack() {
			let id = document.getElementById('content').value;

			if (CKEDITOR.instances.content.getData() == "") {
				console.log(id);
				alert("글 내용을 입력해주세요.");

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