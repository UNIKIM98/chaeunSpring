<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- dataPaging 하기 위한 css -->
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">

<!-- 아래꺼를 쓰기 위한 제이쿼리 -->
<script src="js/jquery-3.6.3.min.js"></script>
<!-- dataPaging 하기 위한 js -->
<script src="//cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>


<h3>Notice Paging</h3>

<table id="example" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
	</tfoot>
</table>


<script>
	$(document).ready(function() {
		$('#example').DataTable({
			ajax : 'noticeListPaging.do', // webapp이 제일 상위폴더임! data 폴더 안에 있는 arrays.txt 파일을 뿌려주겠다 (배열 형태의 데이터가 넘어와야 함)

		});
	});
</script>