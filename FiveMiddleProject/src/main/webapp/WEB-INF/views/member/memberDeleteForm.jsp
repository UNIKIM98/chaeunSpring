<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/member/memberJoinForm.css">

<title>회원정보수정</title>
</head>

<body>
	<br>
	<br>
	<br>
	<div class="wrap wd668">
		<div class="container">

			<form id="frm" action="memberDelete.do"
				onsubmit="return formCheck()" method="post">
				<div class="form_txtInput">
					<h2 class="sub_tit_txt">회원탈퇴</h2>
					<p class="exTxt">비밀번호 입력 후 회원 탈퇴 버튼을 누르세요.</p>
					

					<div class="join_form">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>

								<tr id="info__pw">
									<th class="noAfter"><span>비밀번호</span></th>
									<td><input type="password" id="newPassword"
										name="newPassword" placeholder="비밀번호를 입력해주세요." required>
								</tr>

							</tbody>
						</table>
						
					</div>
					<br>
					<!-- join_form E  -->

					<div class="btn_wrap">
						<input type="hidden" id="memberId" name="memberId" value="${member.memberId }"> 
						<input type="hidden" id="memberPassword" name="memberPassword" value="${member.memberPassword }">
						<button class="btn_confirm email" type="submit" id="btnDelete">회원
							탈퇴</button>
					</div>
				</div>
			</form>
			<!-- form_txtInput E -->
		</div>
		<!-- content E-->
	</div>
	<!-- container E -->
	<script type="text/javascript">

		function formCheck() { //아이디 중복체크 및 패스워드 동일성 확인

			if(document.getElementById("newPassword").value == document.getElementById("memberPassword").value){
				frm.submit;
			} else {
				alert("비밀번호가 맞지 않습니다. 다시 확인하세요.");
				document.getElementById("newPassword").value = "";
				document.getElementById("newPassword").focus();
				return false;
			}
			
		}
		
		
	</script>


</body>
<script>
	//비밀번호

	// pwVal: 패스워드, pwReVal: 패스워드 재입력, isPwValid: 패스워드 유효 여부
	let pwVal = "",
		pwReVal = "",
		isPwValid = false
	const pwInputEl = document.querySelector('#info__pw input')
	console.log(pwInputEl.value + "pwInputEl")
	const pwErrorMsgEl = document.querySelector('#info__pw .error-msg')
	pwInputEl.addEventListener('change', () => {
		const pwRegExp = /^(?=.*[A-Za-z])$/
		pwVal = pwInputEl.value
		
		if (pwRegExp.test(pwVal)) { // 정규식 조건 만족 O
			isPwValid = true
		} else { // 정규식 조건 만족 X
			isPwValid = false
			pwErrorMsgEl.textContent = errMsg.pw;
			console.log(errMsg.pw)
		}
		checkPwValid()
		console.log(pwVal, pwReVal, isPwValid, account)


	})
	
	
</script>

</html>