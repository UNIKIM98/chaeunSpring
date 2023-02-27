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
	<div class="tab-pane" id="reviews" role="tabpanel">
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6 m-lr-auto">
				<div class="p-b-30 m-lr-15-sm">
					<!-- Review -->
					<c:forEach items="${reviews }" var="r">
						<div class="flex-w flex-t p-b-68">
							<div class="wrap-pic-s size-109 bor0 of-hidden m-r-18 m-t-6">
								<img src="images/avatar-01.jpg" alt="AVATAR">
							</div>

							<div class="size-207">
								<div class="flex-w flex-sb-m p-b-17">
									<span class="mtext-107 cl2 p-r-20"> ${r.reviewWriter } </span>
									<span class="fs-18 cl11"> <i class="zmdi zmdi-star"></i>
										<i class="zmdi zmdi-star"></i> <i class="zmdi zmdi-star"></i>
										<i class="zmdi zmdi-star"></i> <i class="zmdi zmdi-star-half"></i>
									</span>
								</div>
								<p class="stext-102 cl6">${r.reviewSubject }</p>
							</div>
							<div>
								<form id="frm" method="post">

									<button type="button" onclick="noticeEdit('E')">글수정</button>
									<button type="button" onclick="noticeEdit('D')">글삭제</button>

									<input type="hidden" name="noticeId"
										value="${notice.noticeId }">
								</form>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function noticeEdit(str) {
			if (str == 'E') {
				frm.action = "reviewEditForm.do";
			} else {
				let yn = confirm("작성글을 삭제하겠습니가?");
				if (yn) {
					frm.action = "reviewDelete.do";
				} else {
					return false;
				}
			}

			frm.submit();
		}
	</script>
</body>
</html>