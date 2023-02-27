<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
<br><br><br><br>
	<!-- 주문내역 -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
		<div class="bread-crumb flex-w p-l-125 p-r-50 p-t-30 p-lr-0-lg">
			<a href="main.do" class="stext-109 cl8 hov-cl1 trans-04"> Home <i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> 주문내역 </span>
		</div>
		<br>
			<div class="row">
				<div class="col-lg-10 col-xl-10 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
							<div class="wrap-table-shopping-cart">
								<table class="table-shopping-cart">
									<tr class="table_head">
										<th class="column-1">강의</th>
										<th class="column-2"></th>
										<th class="column-3">수강마감일자</th>
										<th class="column-3">수강가능상태</th>
										<th class="column-5">주문날짜</th>
									</tr>

						<c:forEach items="${lists }" var="l">
									<tr class="table_row">
						
										<td class="column-1">
											<div class="how-itemcart1">
												<img src="attech/${l.productThumbnailUrl }" alt="IMG">
											</div>
										</td>
										<td class="column-2">${l.productName }</td>
										<td class="column-3">${l.ordersDeadline }</td>
										<td class="column-3">${l.ordersStatus }</td>
										<td class="column-5">${l.ordersDate }</td>
									</tr>
						</c:forEach>
								</table>
							</div>

					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>