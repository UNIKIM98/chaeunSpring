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
<h3>상점 리스트</h3>
	<div style="text-align: center;">
		<table border="1">
			<thead>
				<tr>
					<th width="100">아이디</th>
					<th width="100">점주명</th>
					<th width="100">점포명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shops }" var="s">
					<tr>
						<td>${s.shUserId }</td>
						<td>${s.shUserName }</td>
						<td>${s.shUserShopName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>