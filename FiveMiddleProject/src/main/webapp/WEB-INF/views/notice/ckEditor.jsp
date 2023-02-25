<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<script src="js/noticeAjaxFetch.js"></script>
<title>CKEditor 5 – Classic editor</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
</head>
<body>
<br><br><br><br><br><br><br><br>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<h2>공지사항 등록</h2><br>
				
				<input type="text" id="noticeTitle" name="noticeTitle" class="form-control" placeholder="제목을 입력하세요.">
				

				<div id="editor">
				
					<p>This is some sample content.</p>
				</div>

				<div class="row justify-content-md-center"></div>
				<div class="custom-file">
					&nbsp;<input type="file" class="form-control-file"
						id="exampleFormControlFile1">

				</div>
			</div>
		</div>

		<script>
    ClassicEditor
      .create( document.querySelector( '#editor' ) )
      .catch( error => {
        console.error( error );
      } );
  </script>


	</div>
	<form name="noticeInsertFrm" method="post">
	<div class="row justify-content-md-center">
		<button type="submit" class="btn btn-outline-secondary"
			style="width: 20%; font-weight: bold">등 록</button>
	</div>
	<input type="hidden" id="noticeWriter" name="noticeWriter" value="${member.memberName}">
	</form>
</body>
</html>