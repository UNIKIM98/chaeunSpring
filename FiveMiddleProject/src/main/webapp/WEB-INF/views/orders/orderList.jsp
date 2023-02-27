<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.image {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}
</style>
</head>
<body>

	<br>
	<br>
	<br>
	<br>

	<!-- Shoping Cart -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="main.do" class="stext-109 cl8 hov-cl1 trans-04"> Home <i
				class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a><a href="cartMain.do" class="stext-109 cl8 hov-cl1 trans-04">
				장바구니 <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <span class="stext-109 cl4"> 결제 </span>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
				<div class="m-l-25 m-r--38 m-lr-0-xl">
					<div class="wrap-table-shopping-cart">
						<table class="table-shopping-cart">
							<tr class="table_head">
								<th class="column-1"></th>
								<th class="column-2">강좌명</th>
								<th class="column-3">Total</th>
							</tr>
							<c:forEach items="${CartList }" var="c">
								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="attech/${c.productThumbnailUrl }" alt="IMG"
												class="image" style="width: 100px">

										</div>
									</td>
									<td class="column-2">${c.productName }</td>
									<td class="column-3">${c.productPrice }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>

			<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
				<div
					class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
					<h4 class="mtext-109 cl2 p-b-30">Cart Total</h4>

					<div class="flex-w flex-t p-t-27 p-b-33">
						<div class="size-208">
							<span class="mtext-101 cl2"> Total: </span>
						</div>

						<div class="size-209 p-t-1">
							<span class="mtext-110 cl2"> 300000원 </span>
						</div>
					</div>

					<form id="frm" method="post" action="orderListInsert.do">
						<c:forEach items="${CartList }" var="c">
							<input type="hidden" name="productNum" value=${c.productNum }>
							<input type="hidden" name="cartNum" value=${c.cartNum }>
						</c:forEach>
						<button type="submit"
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
							결제하기</button>
					</form>

					<br> <a href='kakaopay.do'>

						<button
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
							카카오결제하기</button>
					</a>

				</div>
			</div>
		</div>
	</div>

	<script>
		
	</script>
	<!--<script>
function Orders(str) {
			let yn = confirm("결제하시겠습니까?");
			if(yn) {
				frm.action="ordersListInsert.do";
			}else{
				return false;
			}
		frm.submit();
		}

</script>  -->


</body>
</html>