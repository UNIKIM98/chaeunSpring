<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>CKEditor 5 – Classic editor</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-10">
				<h1>Classic editor</h1>
				<input type="text" class="form-control" placeholder="제목을 입력하세요.">

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

	<div class="row justify-content-md-center">
		<button type="submit" class="btn btn-outline-secondary"
			style="width: 20%; font-weight: bold">등 록</button>
	</div>
</body>
</html>