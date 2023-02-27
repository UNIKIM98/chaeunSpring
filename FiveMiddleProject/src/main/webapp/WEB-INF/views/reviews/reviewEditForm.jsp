<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="tab-pane" id="reviews" role="tabpanel">
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6 m-lr-auto">
				<div class="p-b-30 m-lr-15-sm">

					<!-- Add review -->
					<form id="frm" action="reviewUpdate.do" method="post"
						class="w-full">
						<h5 class="mtext-108 cl2 p-b-7">Review update</h5>

						<p class="stext-102 cl6">Your email address will not be
							published. Required fields are marked *</p>


						<div class="row p-b-25">
							<div class="col-12 p-b-5">
								<label class="stext-102 cl3" for="review">Your review</label>
								<textarea class="size-110 bor8 stext-102 cl2 p-lr-20 p-tb-10"
									id="reviewSubject" name="reviewSubject">${review.reviewSubject } </textarea>
							</div>

							<div class="col-sm-6 p-b-5">
								<label class="stext-102 cl3" for="name">Name</label> <input
									class="size-111 bor8 stext-102 cl2 p-lr-20" id="reviewWriter"
									type="text" name="reviewWriter" value="${review.reviewWriter }">
							</div>
						</div>

						<div>
							<input type="hidden" name="reviewNum" value="${review.reviewNum }">
							<input type="hidden" name="productNum" value="${review.productNum }">
							
							<input type="submit" value="수정" onclick="location.href='reviewUpdate.do?reviewNum=${review.reviewNum }'">
							<input type="button" value="목록" onclick="location.href='reviewList.do'">
							
						</div>
					</form>



				</div>
			</div>
		</div>
	</div>


</body>
</html>