<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>고객정보리스트</h3>
	<table border="1">
		<thead style="text-align: center;">
			<tr>
				<th width="100">아이디</th>
				<th width="100">비밀번호</th>
				<th width="100">구분</th>
				<th width="100">이름</th>
				<th width="200">전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers }" var="C">
				<tr>
					<td>${C.SH_ID }</td>
					<td>${C.SH_PASSWORD }</td>
					<td>${C.SH_GUBUN }</td>
					<td>${C.SH_CUSTOMER_NAME}</td>
					<td>${C.SH_CUSTOMER_TEL }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<a href="shopList.do">🦝상점리스트🌳</a>
	<br>
	<a href="getCustomerList.do">객체 형태로 고객리스트 불러오기</a>
	<br>
	<a href="setMemberJoinForm.do">쇼핑몰회원가입</a>
</body>
</html>