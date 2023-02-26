<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>

<style>
@font-face {
	font-family: 'KoddiUDOnGothic-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/KoddiUDOnGothic-Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: KoddiUDOnGothic-Regular;
}

.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: lightblue;
	color: white;
	border: 1px solid lightblue;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<div align="center">
	<h3>공지사항🤸‍♂️</h3>
</div>

<!-- 입력칸 -->
<div align="center">
	<form id="frm" action="noticeInsert.do" method="post"
		enctype="multipart/form-data">
		<div>
			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<td width="200"><input type="text" id="noticeWriter"
						name="noticeWriter" value="${name}" readonly="readonly"></td>
					<th width="150">작성일자</th>
					<td width="200"><input type="date" id="noticeDate"
						name="noticeDate" required="required"></td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="3"><input type="text" size="78" id="noticeTitle"
						name="noticeTitle" required="required"></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="3"><textarea rows="10" cols="75"
							id="noticeSubject" name="noticeSubject"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><input type="file" id="nfile" name="nfile">
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<input type="submit" value="등록">&nbsp;&nbsp; <input
				type="reset" value="취소">
		</div>
	</form>
</div>




<div>
	show: <select id="perPage">
		<option value="5">5</option>
		<option value="10" selected>10</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>

</div>
<div>
	search: <select id="searchCondition">
		<option value="title" selected>제목</option>
		<option value="writer">작성자</option>
	</select> <input type="text" id="keyword">
	<button id="searchBtn">검색</button>

</div>
<table id="example" class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>글제목</th>
			<th>첨부파일</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="list">
	</tbody>
</table>

<!--pageDTO 그리는 부분-->
<div class="center">
	<div class="pagination"></div>
</div>
<script src = "js/noticePaging.js">
	
</script>