<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<img alt="img" src="resources/upload/dt3.gif" width="400"> <br>
		<c:if test="${not empty memberId }"><p>${memberId }님, 안녕하세요 :D</p></c:if>
		<c:if test="${empty memberId }"><p>로그인이 필요합니다 :)</p></c:if>
		<a href="noticeList.do"
			style="font-size: x-large; text-align: center;">🚗🌳</a>
	</div>
</body>
</html>