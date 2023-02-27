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
			</a> <a href="adminProductList.do" class="stext-109 cl8 hov-cl1 trans-04">강의관리<i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> 강의등록 </span>
		</div>
		<div class="row">
			<div class="col-8">
				<br> <br>
				<form action="adminProductCkedit.do" id="frm" method="post"
					enctype="multipart/form-data" onsubmit="return datack()">
					<h4>강의등록</h4>
					<br> <label style="display: block; font-size: large;">강의명
						<input type="text" class="form-control" id="productName"
						name="productName" width="800px" placeholder="강의명을 입력하세요." required="required">
					</label> <label style="display: block; font-size: large;">강의 한줄 설명
						<input type="text" class="form-control" id="productExplain"
						name="productExplain" width="800px"
						placeholder="강의 한 줄 설명을 입력하세요." required="required">
					</label> <label style="display: inline-block;; font-size: large;">강사명
						<input type="text" class="form-control" id="productTrainer"
						name="productTrainer" width="800px" placeholder="강사명을 입력하세요." required="required">
					</label> <label style="display: inline-block;; font-size: large;">수강
						기간 <input type="text" class="form-control" id="productDate"
						name="productDate" width="800px" placeholder="수강기간을 입력하세요." required="required">
					</label> <label style="display: inline-block;; font-size: large;">강의
						가격 <input type="text" class="form-control" id="productPrice"
						name="productPrice" width="800px" placeholder="강의 가격을 입력하세요." required="required">
					</label><br> <label style="display: block; font-size: large;">강의
						url <input type="text" class="form-control" id="productYoutubeurl"
						name="productYoutubeurl" width="800px"
						placeholder="강의 url을 입력하세요.">
					</label> <label style="display: inline-block;; font-size: large;">강의
						내용</label> &nbsp;&nbsp;
					<textarea id="content" name="content"></textarea>

					<label style="display: inline-block;; font-size: large;">썸네일
						사진 <input type="file" class="form-control" id="nfile" name="nfile"
						width="800px">
					</label> <br> <br>
					<button type="submit" class="btn btn-primary" style="float: right;">등록</button>
					<br> <br>
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
								height : 500,
								filebrowserUploadUrl : '${pageContext.request.contextPath}/fileupload.do'
							});
		}

		function datack() {
			let id = document.getElementById('content').value;

			if (CKEDITOR.instances.content.getData() == "") {
				alert("강의 내용을 입력해주세요");

				return false;
			} else {
				frm.submit();
				return true;
			}

		}
	</script>

</body>
</html>