<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h3>회원목록</h3>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
					<th>수정</th>
				</tr>
				<c:forEach items="${lists }" var="m">
					<tr>
						<td>${m.memberId }</td>
						<td>${m.memberName }</td>
						<td>${m.memberAge }</td>
						<td>${m.memberAddress }</td>
						<td><input type="button" value="수정"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>