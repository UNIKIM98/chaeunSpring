<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3>공지목록</h3>
		</div>
		<div>
			<form id="frm" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100"><select name="key" id="key">
									<option value="all">전체</option>
									<option value="title">제목</option>
									<option value="subject">내용</option>
									<option value="date">날짜</option>
									<option value="writer">작성자</option>
							</select></th>
							<td width="250"><input type="text" name="val" id="val">&nbsp;
								<input type="button" value="검색" onclick="searchListJson()"></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<br>
		<table border="1" style="text-align: center" id="list-table">
		
			<thead>
				<tr>
					<td width="100">순번</td>
					<td width="250">제목</td>
					<td width="150">작성자</td>
					<td width="150">작성일자</td>
					<td width="100">조회수</td>
					<td width="100">첨부파일</td>
				</tr>
			</thead>
			<tbody id="notice-list">
				<c:forEach items="${notices}" var="n">
					<tr onmouseover="this.style.background='lightyellow';"
						onmouseleave="this.style.background='#FFFFFF';"
						onclick="noticeSel('${n.noticeId}')">
						<td>${n.noticeId}</td>
						<td>${n.noticeTitle}</td>
						<td>${n.noticeWriter}</td>
						<td>${n.noticeDate}</td>
						<td>${n.noticeHit}</td>
						<td><c:if test="${not empty n.noticeFile}">🙆‍♀️
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${memberAuthor eq 'ADMIN' }">
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
		</div>
	</c:if>
	<div>
		<form id="hiddenFrm" action="noticeSelect.do" method="post">
			<input type="hidden" name="noticeId" id="noticeId">
		</form>
	</div>

	<script type="text/javascript">
		//👻게시글 상세보기 호출
		function noticeSel(n) {
			document.getElementById('noticeId').value = n;
			hiddenFrm.submit();
		}

// 		//👻post 방식
// 		function searchList() {
// 			let url = 'AjaxSearchList.do';
// 			let key = document.getElementById('key').value;
// 			let val = document.getElementById('val').value;

// 			let payload = 'key=' + key + '&val=' + val
// 			console.log(payload)

// 			fetch(url, {
// 					method: "POST",
// 					headers: {
// 						"Content-Type": "application/x-www-form-urlencoded"
// 					},
// 					body: payload
// 				})
// 				.then((result) => result.json())
// 				.then((result) => {
// 					htmlConvert(result);
// 				})
// 				.catch(err => console.log(err))
// 		}

// 		function htmlConvert(result) {
// 			console.log(result);
// 		}

// 		👻 get 방식
		function searchListJson() {
			let url = 'AjaxSearchJson.do';
			let key = document.getElementById('key').value;
			let val = document.getElementById('val').value;

			let payload = {
				'key' : key,
				'val' : val
			};
			console.log(payload)

			fetch(url, {
				method : 'POST',
				headers:{'content-Type': 'application/json'},
				body:JSON.stringify(payload)
			})
				.then(result => result.json())
				.then((data) => 
				{
					console.log(data)
					htmlConvert(data)}
				)
				.catch(err => console.log(err))
		}
		
		function createHTMLString(data){  //html 변환 코드 css, event Listner를 활용하면 깔끔하게 정리됨
			if(data.noticeFile == null) //첨부파일 존재유무 확인
				data.noticeFile = ""  //존재하지 않으면 공백
			else 
				data.noticeFile = "🙆‍♀️‍"
		
			let str = "<tr onmouseover=this.style.background='#fcecae';"
				str += " onmouseleave=this.style.background='#FFFFFF';"  //앞 쪽 공백 주의
				str += " onclick=";  //앞 쪽 공백 주의
				str += "noticeSel('"+ data.noticeId +"')" +">";
				str += "<td align=center>" + data.noticeId + "</td>";
				str += "<td>" + data.noticeTitle + "</td>";
				str += "<td align=center>" + data.noticeWriter + "</td>";
				str += "<td align=center>" + data.noticeDate + "</td>";
				str += "<td align=center>" + data.noticeHit + "</td>";
				str += "<td align=center>" + data.noticeFile + "</td></tr>";
			return str;
		}
		
		function htmlConvert(datas) {//json을 html로 변환해서 화면에 뿌림
			document.querySelector('#notice-list').remove();  //리스트의 <tbody> 삭제
			const container = document.createElement('tbody'); //<tbody> 태그 생성
			container.id = 'notice-list';  //tbody id값 부여
			container.innerHTML = datas.map(data => createHTMLString(data)).join("");  //Html 변환
			document.querySelector('#list-table').appendChild(container);  //원하는 위치에 추가
		}
	</script>
</body>

</html>