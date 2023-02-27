<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/review/reviewListForm.css">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- add review 리뷰!!- -->
	<div class="tab-pane" id="reviews" role="tabpanel">
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6 m-lr-auto">
				<div class="p-b-30 m-lr-15-sm">
					<!-- Add review -->
					
					<form id="frm" action="reviewInsert.do" method="post"
						class="w-full">						
						
						<div class="row p-b-25">
							<div class="col-12 p-b-5">
								<label class="stext-102 cl3" for="review">Your review</label>
								<textarea class="size-110 bor8 stext-102 cl2 p-lr-20 p-tb-10"
									id="reviewSubject" name="reviewSubject"></textarea>
							</div>

							<div class="col-sm-6 p-b-5">
								<label class="stext-102 cl3" for="name">ID</label> 
								<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="reviewWriter"
									type="text" name="reviewWriter" value= "${memberId}" readonly="readonly">
							</div>
							<!--<div class="col-sm-6 p-b-5">
									<label class="stext-102 cl3" for="reviewNum" >게시글번호</label>
									<input class="size-111 bor8 stext-102 cl2 p-lr-20"
									id="reviewNum" type="text" name="reviewNum">
									
								</div>  -->
						</div>
							
					<c:if test="${not empty memberId }">
						<button
							class="flex-c-m stext-101 cl0 size-112 bg7 bor11 hov-btn3 p-lr-15 trans-04 m-b-10">Submit</button>
						<input type="hidden" id="reviewNum" name="reviewNum">
							</c:if>
					<!-- </form> -->

					
					
					
					
					<!-- Review -->

					<c:forEach items="${reviews }" var="r">
						<div class="flex-w flex-t p-b-68">
							<div class="wrap-pic-s size-109 bor0 of-hidden m-r-18 m-t-6">
								<img src="images/avatar-01.jpg" alt="AVATAR">
							</div>
							<p class="stext-102 cl6" >${r.reviewNum }</p>
							<div class="size-207">
								<div class="flex-w flex-sb-m p-b-17">
								<p class="stext-102 cl6">${r.reviewDate }</p>
								</div>
								<div class="flex-w flex-sb-m p-b-17">
								<p class="stext-102 cl6">${r.reviewWriter }</p>
								</div>
								<p class="stext-102 cl6">${r.reviewSubject }</p>
							</div>
							<br> <br> <br>
							<c:if test="${memberId eq r.reviewWriter }">
							
							<div>
									<button type="button" onclick="location.href='reviewDelete.do?reviewNum=${r.reviewNum }'">삭제</button>
									<button type="button" onclick="location.href='reviewEditForm.do?reviewNum=${r.reviewNum }'">수정</button>
							</div>
							</c:if>
						</div>
					</c:forEach>
					<br>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>