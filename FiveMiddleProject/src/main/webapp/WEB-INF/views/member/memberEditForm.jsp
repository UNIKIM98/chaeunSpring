<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/member/memberJoinForm.css">
<script src="js/memberAjax.js"></script>
<title>회원정보수정</title>
</head>
<body>
	<br>
	<br>
	<div class="wrap wd668">
		<div class="container">
			<div class="form_txtInput">
				<h2 class="sub_tit_txt">회원정보수정</h2>
				<p class="exTxt">회원정보 조회, 수정 페이지입니다.</p>
				<div class="join_form">
					<form id="memberFrm" action="" method="post">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>
								<tr>
									<th class="noAfter"><span>아이디(이메일)</span></th>
									<td>${member.memberId }</td>
								</tr>
								<tr>
									<th class="noAfter"><span>이름</span></th>
									<td>${member.memberName }</td>

								</tr>
								<tr>
									<th class="noAfter"><span>닉네임</span></th>
									<td><input type="text" id="memberNickname" name="memberNickname" value="${member.memberNickname }" required="required">
<!-- 										<button class="btn_confirm nick" onclick="nickChk()" id="btnNick" value="No">닉네임 -->
<!-- 											중복확인</button></td> -->
								</tr>
								<tr>
									<th class="noAfter"><span>비밀번호 변경</span></th>
									<td><input type="password" id="memberPassword" name="memberPassword"
										placeholder="변경하실 비밀번호를 입력해주세요.">
<!-- 										<div class="error-msg"></div> -->
										</td>
										
								</tr>
<%-- 								<c:if test="not empty"> --%>
								<tr>
									<th class="noAfter"><span>비밀번호 확인</span></th>
									<td><input type="password" id="memberPasswordCheck" name="memberPasswordCheck"
										placeholder="변경하실 비밀번호를 한 번 더 입력해주세요."></td>
								</tr>
<%-- 								</c:if> --%>
								
								
								<tr>
									<th class="noAfter"><span>휴대폰 번호</span></th>
									<td>${member.memberPhone}</td>
								</tr>
								<tr>
									<th class="noAfter"><span>생년월일</span></th>
									<td>${member.memberBirth}</td>
								</tr>
								<tr>
									<th class="noAfter"><span>성별</span></th>
									<td>${member.memberGender}</td>
								</tr>

							</tbody>
						</table>
<!-- 						<div class="exform_txt"> -->
<!-- 							<span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.</span> -->
<!-- 						</div> -->
						<div class="btn_wrap">
							<input type="hidden" id="memberId" name="memberId" value="${member.memberId }">
							<!-- <a href="javascript:;">수정</a> -->
							<input type="submit" id="editInfo" name="editInfo" value="수정">
						</div>
					</form>
				</div>

			</div>
			<!-- form_txtInput E -->
		</div>
		<!-- content E-->
	</div>
	<!-- container E -->
	<script>
	console.log("10");
	</script>
</body>
</html>