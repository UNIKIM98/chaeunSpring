<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<style>
@font-face {
    font-family: 'KoddiUDOnGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/KoddiUDOnGothic-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
	* {
		font-family: KoddiUDOnGothic-Regular;
	}
</style>

<!-- Product section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="row gx-4 gx-lg-5 align-items-center">
			<div class="col-md-6">
				<img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg"
					alt="..." />
			</div>
			<div class="col-md-6">
				<div class="small mb-1">SKU: BST-498</div>
				<h1 class="display-5 fw-bolder">Shop item template</h1>
				<div class="fs-5 mb-5">
					<span class="text-decoration-line-through">$45.00</span> <span>$40.00</span>
				</div>
				<p class="lead">Lorem ipsum dolor sit amet consectetur
					adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi
					consequatur obcaecati excepturi alias magni, accusamus eius
					blanditiis delectus ipsam minima ea iste laborum vero?</p>
				<div class="d-flex">
					<input class="form-control text-center me-3" id="inputQuantity" type="num" value="1"
						style="max-width: 3rem" />
					<button class="btn btn-outline-dark flex-shrink-0" type="button">
						<i class="bi-cart-fill me-1"></i> Add to cart
					</button>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- Related items section-->
<section class="py-5 bg-light">
	<div class="container px-4 px-lg-5 mt-5">
		<h2 class="fw-bolder mb-4">Popular products</h2>
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
			id="relatedProducts">
			<div class="col mb-5" id="target">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<a href="productInfo.do?productCode="> <img class="card-img-top"
								src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." /></a>
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Popular Item</h5>
								<!-- Product reviews-->
								<div class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span>5000원</span>
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
	</div>
</section>

<script>
	let productCode = "${productCode }";
	console.log(productCode)
	$.ajax({
		url: 'productDetail.do?productCode=' + "${productCode }",
		method: 'post',
		dataType: 'json',
		success: function (result) {
			console.log(result);
			let target1 = $('.col-md-6').eq(0)
			target1.find('img').attr('src', 'images/' + result.image);

			let target2 = $('.col-md-6').eq(1)
			target2.find('h1').text(result.productName);
			target2.find('.small').text(result.productCode);
			target2.find('span').eq(0).text('￦' + result.price);
			target2.find('span').eq(1).text('￦' + result.salePrice);
			target2.find('.lead').text(result.productDesc);
		},
		error: function (error) {
			console.log(error)
		}
	})

	$.ajax({
		url: 'relatedProducts.do',
		method: 'post',
		dataType: 'json',
		success: function (result) {

			$(result.likeList).each(function (idx, item) {
				let template = $('#target').clone();
				template.css('display', 'inline')
				template.find('img').attr('src', 'images/' + item.image);
				template.find('h5').text(item.productName);
				template.find('span').text('￦' + item.productPrice);
				template.find('a').attr('href', 'productInfo.do?productCode=' + item.productCode);

				template.find('div.d-flex div').remove();
				let target = template.find('div.d-flex');
				//교수님 별점
				for (let i = 0; i < 5; i++) {
					if (i < Math.floor(item.likeIt)) { //소수점 버림
						target.append($('<div />').addClass('bi-star-fill'));
					} else if (i < item.likeIt) {
						target.append($('<div />').addClass('bi-star-half'));
					} else {
						target.append($('<div />').addClass('bi-star'));
					}
				}
				$('#relatedProducts').append(template);
			})
			$('#target').css('display', 'none');

		},
		error: function (err) {
			console.log(err);
		}
	})
</script>