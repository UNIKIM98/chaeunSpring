<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<!-- Header desktop -->
	<div class="container-menu-desktop">


		<div class="wrap-menu-desktop">
			<nav class="limiter-menu-desktop container">

				<!-- Logo desktop -->
				<a href="main.do" class="logo"> <img
					src="images/icons/LOGO4.png" alt="IMG-LOGO">
				</a>

				<!-- Menu desktop -->
				<div class="menu-desktop">
					<ul class="main-menu flex-r-m">

						<li><a href="prodListAjax.do">Lecture List</a></li>

						<li><a href="notice.do">Event</a></li>

						<li><a href="qnaMain.do">FAQ</a></li>
						<c:if test="${memberRole eq 'USER' }">
							<li><a href="myProductList.do">My Class</a></li>
						</c:if>
						<c:if test="${memberRole eq 'ADMIN' }">
							<li><a href="adminMemberList.do">ADMIN Page</a>
								<ul class="sub-menu">
									<c:if test="${memberRole eq 'ADMIN' }">
										<li><a href="adminProductList.do">강의관리</a></li>
									</c:if>
									<c:if test="${memberRole eq 'ADMIN' }">
										<li><a href="adminMemberList.do">회원관리</a></li>
									</c:if>
									<c:if test="${memberRole eq 'ADMIN' }">
										<li><a href="adminNoticeList.do">이벤트관리</a></li>
									</c:if>
									<c:if test="${memberRole eq 'ADMIN' }">
										<li><a href="adminQnaList.do">FAQ관리</a></li>
									</c:if>

								</ul></li>
						</c:if>
						<li class="active-menu"><a class="category" href=""> <img
								src="images/icons/icon-mypage.png" width="20" height="20"
								class="menu-icon">
						</a>
							<ul class="sub-menu">
								<c:if test="${empty memberId }">
									<li><a href="memberJoinForm.do">회원가입</a></li>
								</c:if>
								<c:if test="${empty memberId }">
									<li><a href="memberLoginForm.do">로그인</a></li>
								</c:if>
								<c:if test="${not empty memberId }">
									<li><a href="memberEditForm.do">마이페이지</a></li>
								</c:if>
								<c:if test="${not empty memberId }">
									<c:if test="${memberRole eq 'USER' }">
										<li><a href="ordersHistory.do">주문내역</a></li>
									</c:if>
								</c:if>
								<c:if test="${not empty memberId }">
									<li><a href="memberLogout.do">로그아웃</a></li>
								</c:if>
							</ul></li>

					</ul>
				</div>

				<!-- Icon header -->
				<div class="wrap-icon-header flex-w">

					<c:if test="${memberRole eq 'USER' }">
						<!-- 장바구니 -->
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 m-r-500"
							data-notify="">
							<a href="cartMain.do" class="cl2 hov-cl1 trans-04"><i
								class="zmdi zmdi-shopping-cart"></i></a>

						</div>
					</c:if>
				</div>
			</nav>
		</div>
	</div>
</header>