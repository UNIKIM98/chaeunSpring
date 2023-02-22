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
	<h3>[객체중심설계] 고객 리스트</h3>
	<c:forEach items="${customers }" var="c">
	${c.shCustomerName }, ${c.shopMember.shPassword}
</c:forEach>

</body>
</html>