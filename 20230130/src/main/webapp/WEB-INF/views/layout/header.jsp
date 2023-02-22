<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/menu.css">
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
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="home.do">Home</a></li>
			<li><a class="menuLink" href="noticeList.do">Notice</a></li>
			<c:if test="${empty memberId }">
				<li><a class="menuLink" href="memberJoinForm.do">Join</a></li>
			</c:if>
			<li><a class="menuLink" href="customerList.do">Shopping</a></li>
			<c:if test="${memberAuthor eq 'ADMIN'}">
				<li><a class="menuLink" href="memberListSelect.do">Member</a></li>
			</c:if>
			<c:if test="${empty memberId }">
				<li><a class="menuLink" href="memberLoginForm.do">Login</a></li>
			</c:if>
			<c:if test="${not empty memberId }">
				<li><a class="menuLink" href="memberLogout.do">Logout</a></li>
			</c:if>
			<li><a class="menuLink" href="employeeList.do">Employee</a></li>

		</ul>
	</nav>
</body>
</html>