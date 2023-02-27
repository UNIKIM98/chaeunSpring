<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 짜집기 장바구니 -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="css/cart/style.css"> -->

<br>
<br>
<br>
<br>

<!-- 홈페이지 > 쇼핑카트 -->
<div class="container">
	<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
		<a href="main.do" class="stext-109 cl8 hov-cl1 trans-04">Home<i
			class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
		</a> <span class="stext-109 cl4"> 장바구니 </span>
	</div>
</div>
<br>

<div>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
				<div class="m-l-25 m-r--38 m-lr-0-xl">
					<div class="wrap-table-shopping-cart">
						<table class="table-shopping-cart">
							<thead>
								<tr class="table_head">
									<th class="column-1"><div align="left">
											<input type="checkbox" id="checkAll">
										</div></th>
									<th class="column-2"></th>
									<th class="column-2">Prodcut</th>
									<th class="column-3">Price</th>
									<th class="column-2">Select</th>
								</tr>
							</thead>
							<tbody>
							</tbody>

						</table>

					</div>
					<br>
					<div align="left">
						<button id='deleteAll'
							class="flex-c-m stext-101 cl0 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">선택삭제</button>
					</div>
				</div>
			</div>

			<!-- 주문화면으로 넘어가는 구간-->
			<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
				<div
					class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
					<h4 class="mtext-109 cl2 p-b-30">Order</h4>

					<div class="flex-w flex-t bor12 p-t-15 p-b-30">
						<div class="size-209 w-full-ssm">
							<span class="stext-110 cl2">강좌명</span>
						</div>

						<div class="size-208 p-r-18 p-r-0-sm w-full-ssm">
							<p class="stext-111 cl6 p-t-2">상품금액</p>
						</div>
					</div>

					<div class="flex-w flex-t p-t-27 p-b-33">
						<div class="size-209">
							<span class="mtext-101 cl2"> Total: </span>
						</div>

						<div class="size-208 p-t-1">
							<span class="mtext-110 cl2" id='totalPrice'>0</span>
						</div>
					</div>
					<form id="toOrder" action="cartToOrder.do" method="post">
						<!-- 						<a href="orderList.do"> -->
						<button
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
							id="goToOrder">Proceed to Checkout</button>
						<!-- 						</a> -->
					</form>

				</div>
			</div>
		</div>
	</div>


</div>


<!-- --------------------짜집기 JS------------------------------- -->
<script src="js/cart/jquery.min.js"></script>
<script src="js/cart/popper.js"></script>
<script src="js/cart/bootstrap.min.js"></script>
<script src="js/cart/main.js"></script>
<script src="js/cart/cartMain.js"></script>
