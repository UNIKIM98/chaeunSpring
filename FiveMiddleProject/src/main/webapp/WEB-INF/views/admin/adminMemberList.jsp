<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/admin/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/admin/bootstrap.min.css">
<!-- Style -->
<link rel="stylesheet" href="css/admin/style.css">
<!-- ▼ 채은추가 -->
<script src="js/admin/adminMemberAjax.js"></script>

<title>Table #9</title>

<style type="text/css">
.modal_wrap {
	width: 1000px;
	height: 500px;
	margin: 0;
	padding: 20px;
	position: fixed;
	top: 60%;
	left: 50%;
	background: #E8F5FF;
	transform: translate(-50%, -50%);
	margin: 0;
	border-radius: 10px;
}
</style>
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
			</a> <span class="stext-109 cl4"> 회원관리 </span>
		</div>
		<div class="p-l-30 p-b-100">
			<br>
			<div class="page-title">

				<div align="center">
					<h2 class="mb-5">회원 관리</h2>
				</div>
			</div>

			<div class="table-responsive">
				<div>
					<button id="delBtn">선택삭제</button>
				</div>

				<table class="table custom-table" id="dataTable">
					<thead>
						<tr>
							<th scope="col"><input type="checkbox" class="js-check-all" />
							</th>
							<th scope="col">아이디</th>
							<th scope="col">이름</th>
							<th scope="col">닉네임</th>
							<th scope="col">성별</th>
							<th scope="col">생년월일</th>
							<th scope="col">전화번호</th>
							<th scope="col">수강강좌</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<div class="modal_wrap" style="display: none;">
		<div class="container">
			<!-- 모달 내용1111 -->
			<div class="modal-title">
				<div class="container">
					<h5>수강중인강좌</h5>
				</div>
			</div>

			<div class="table-responsive">

				<table class="table custom-table" id="trueTable">
					<thead>
						<tr>
							<th scope="col" style="width: 200px">강좌명</th>
							<th scope="col" style="width: 200px">수강기간</th>
						</tr>
					</thead>
					<tbody id="trueClass">
					</tbody>
				</table>
			</div>
			<br> <br>
			<!-- 모달 내용1111 -->
			<div class="modal-title">
				<div class="container">
					<h5>수강종료강좌</h5>
				</div>
			</div>

			<div class="table-responsive">

				<table class="table custom-table" id="falseTable">
					<thead>
						<tr>
							<th scope="col" style="width: 200px">강좌명</th>
							<th scope="col" style="width: 200px">수강기간</th>
						</tr>
					</thead>
					<tbody id="falseClass">
					</tbody>
				</table>
				<button class="modal_close">x</button>
			</div>
		</div>
	</div>
	<!-- ============================================================ -->
	<script src="js/admin/jquery-3.3.1.min.js"></script>
	<script src="js/admin/popper.min.js"></script>
	<script src="js/admin/bootstrap.min.js"></script>
	<script src="js/admin/main.js"></script>
	<script type="text/javascript">
		window.onload = function() {

			function offClick() {
				document.querySelector('.modal_wrap').style.display = 'none';
			}

			document.querySelector('.modal_close').addEventListener('click',
					offClick);
		};
	</script>
</body>
</html>