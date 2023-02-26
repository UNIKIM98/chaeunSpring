<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- slick(슬라이드) css -->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="css/slick-theme.css" />
<!-- slick(슬라이드) js -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


<style>
	@font-face {
		font-family: 'KoddiUDOnGothic-Regular';
		src:
			url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/KoddiUDOnGothic-Regular.woff') format('woff');
		font-weight: normal;
		font-style: normal;
	}

	* {
		font-family: KoddiUDOnGothic-Regular;
	}
</style>
<!-- Header-->
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<div class="all-images">
			</div>
		</div>
	</div>
</header>

<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="parentDiv">
			<div class="col mb-5" id="targetDiv">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale
					</div>
					<!-- Product image-->
					<a href="productInfo.do?productCode="> <img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." /></a>
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Special Item</h5>
							<!-- Product reviews-->
							<div class="d-flex justify-content-center small text-warning mb-2">
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-half"></div>
							</div>
							<!-- Product price-->
							<span class="text-muted text-decoration-line-through">$20.00</span>
							<span>$18.00</span>
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- <script src="js/jquery-3.6.3.min.js"></script> -->
<script>
	$.ajax({
		url: 'productList.do',
		method: 'post',
		dataType: 'json',
		success: function (result) {
			console.log(result);
			$(result)
				.each(
					function (idx, item) {
						//.all-images 하위에 <div><img src="" item=""></div> 만들어주기
						$('.all-images').append(
							$('<div><img style="width:400px ; height:400px ;"src="images/' + item.image +
								'" item="' + item.productCode + '"></div>')
						)

						let template = $('div.col.mb-5:nth-child(1)')
							.clone();
						template.find('h5').text(item.productName); //find() : 하위요소 찾는 것
						template.find('img').attr('src',
							'images/' + item.image);
						template.find('span').eq(0).text(
							'￦' + item.productPrice);
						template.find('span').eq(1).text(
							'￦' + item.salePrice);
						template.find('a').attr(
							'href',
							'productInfo.do?productCode=' +
							item.productCode);

						/*
						▶ :nth-child(n) > n번째 자식 요소 찾기
						▶ :nth-of-type(n) > 
						 */

						template.find('div.d-flex div').remove();
						let target = template.find('div.d-flex');
						//교수님 별점
						for (let i = 0; i < 5; i++) {
							if (i < Math.floor(item.likeIt)) { //소수점 버림
								target.append($('<div />').addClass(
									'bi-star-fill'));
							} else if (i < item.likeIt) {
								target.append($('<div />').addClass(
									'bi-star-half'));
							} else {
								target.append($('<div />').addClass(
									'bi-star'));
							}
						}

						$('div.row').append(template);
					})
			//첫번째꺼는 display : none 해주면 됨!
			$('div.col.mb-5:nth-child(1)').css('display', 'none');

			//slick all
			$('.all-images').slick({
				autoplay: true,
				autoplaySpeed: 2000,
				centerMode: true,
				centerPadding: '60px',
				slidesToShow: 3,
				responsive: [{
					breakpoint: 768,
					settings: {
						arrows: false,
						centerMode: true,
						centerPadding: '40px',
						slidesToShow: 3
					}
				}, {
					breakpoint: 480,
					settings: {
						arrows: false,
						centerMode: true,
						centerPadding: '40px',
						slidesToShow: 1
					}
				}]
			});
		},
		error: function (error) {
			console.log(error);
		}
	})
	
	$('.all-images').on('click', function (event, slick, direction) {
		let item = event.target.getAttribute('item');
		if (item) {
			$(location).attr('href', 'productInfo.do?productCode=' + item);
		}
	})
</script>
<!-- <Bootstrap core JS-->
<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
<!--  Core theme JS-->

<!-- <script src="js/scripts.js"></script> -->