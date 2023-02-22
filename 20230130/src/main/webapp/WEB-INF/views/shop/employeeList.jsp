<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
</head>

<body>
	<h3>직원정보 리스트</h3>
	<table border="1">
		<thead style="text-align: center;">
			<tr>
				<th width="100">소속부서</th>
				<th width="100">아이디</th>
				<th width="100">이름</th>
				<th width="100">직급</th>
				<th width="150">입사일</th>
				<th width="150">퇴사일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees }" var="E">
				<tr>
					<td class="dep">${E.empDepartment }</td>
					<td>${E.shEmpId }</td>
					<td>${E.empName }</td>
					<td>${E.empPosition}</td>
					<td>${E.empHireDate }</td>
					<td>${E.empEndDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$(".dep").each(function() {
				var rows = $(".dep:contains('" + $(this).text() + "')");
				if (rows.length > 1) {
					rows.eq(0).attr("rowspan", rows.length);
					rows.not(":eq(0)").remove()
				}
			})
		})
	</script>
</body>

</html>