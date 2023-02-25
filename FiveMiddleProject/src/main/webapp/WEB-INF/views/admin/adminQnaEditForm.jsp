<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
			</a> <a href="adminQnaList.do" class="stext-109 cl8 hov-cl1 trans-04">FAQ<i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> FAQ 수정 </span>
		</div>
		<div class="row">
			<div class="col-8">
				<br> <br>
				<form action="qnaUpdate.do" method="post"
					enctype="multipart/form-data" onsubmit="return datack()">
					<h4>FAQ 수정</h4>
					<br> <label style="display: block; font-size: large">제목
						<input type="text" class="form-control" id="qnaTitle"
						name="qnaTitle" width="800px" required="required"
						value="${QNAList.qnaTitle }">
					</label> <br> <label style="display: inline-block; font-size: large">작성자
						<input type="text" class="form-control" id="qnaWriter"
						name="qnaWriter" width="800px" value="${memberName }"
						readonly="readonly">
					</label> &nbsp;&nbsp; <label
						style="display: inline-block; font-size: large">작성일 <input
						type="text" class="form-control" id="qnaDate" name="qnaDate"
						width="800px" readonly="readonly">
					</label> <br> <br> <label
						style="display: inline-block; font-size: large">내용</label>
					&nbsp;&nbsp;
					<textarea id="content" name="content">${QNAList.qnaSubject }</textarea>
					<br> <br>
					<button type="submit" class="btn btn-primary" style="float: right">수정</button>
					<br> <br> <input type="hidden" id="qnaNum" name="qnaNum"
						value="${QNAList.qnaNum }">
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
			document.getElementById("qnaDate").value = year + "/" + month + "/"
					+ day;

		}
	</script>


	<script type="text/javascript">
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