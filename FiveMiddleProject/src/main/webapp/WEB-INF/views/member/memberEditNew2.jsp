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

			<form id="frm" action="memberUpdateNoajax.do"
				onsubmit="return formCheck()" method="post">
				<div class="form_txtInput">
					<h2 class="sub_tit_txt">회원정보수정</h2>
					<p class="exTxt">회원정보 조회, 수정 페이지입니다.</p>

					<div class="join_form">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>

								<tr class="email">
									<th class="noAfter"><span>이메일(아이디)</span></th>
									<td>${member.memberId }</td>
								</tr>
								<tr>
									<th class="noAfter"><span>이름</span></th>
									<td>${member.memberName }</td>
								</tr>

								<tr>
									<th><span>닉네임 변경</span></th>
									<td><input type="text" class="nickname" id="newNickname"
										name="newNickname" value="${member.memberNickname }"
										placeholder="변경할 닉네임을 입력하세요." required>&nbsp;&nbsp;&nbsp;

										<button class="btn_confirm nick" type="button"
											onclick="nickChk()" id="btnNick" value="No">닉네임 중복확인</button></td>
											
										
								</tr>

								<tr id="info__pw">
									<th class="noAfter"><span>비밀번호</span></th>
									<td><input type="password" id="newPassword"
										name="newPassword" placeholder="비밀번호를 입력해주세요.">
										<div class="error-msg"></div></td>
								</tr>

								<tr>
									<th class="noAfter"><span>비밀번호 확인</span></th>
									<td><input type="password" id="passwordChk"
										name="passwordChk" placeholder="비밀번호를 한 번 더 입력해주세요."></td>
								</tr>

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
								
								<tr style="margin-top:100px">
								<th class="noAfter"><span>회원 탈퇴</span></th>
								<td>
								<button type="button" style="border: 1px"
									onclick="location.href='memberDeleteForm.do'" id="btnDel">회원 탈퇴</button></td>
								</tr>

							</tbody>
						</table>
						<div class="exform_txt">
							<span>표시는 필수 입력 사항입니다.</span>
						</div>
					</div>
					<!-- join_form E  -->

					<div class="btn_wrap">
						<input type="hidden" id="memberId" name="memberId"
							value="${member.memberId }"> <input type="hidden"
							id="memberNickname" name="memberNickname"
							value="${member.memberNickname }"> <input type="hidden"
							id="memberPassword" name="memberPassword"
							value="${member.memberPassword }">
						<button class="btn_confirm email" type="submit" id="btnEdit">수정</button>
						&nbsp;&nbsp;
						<button class="btn_confirm email" type="reset">취소</button>&nbsp;&nbsp;
<!-- 						<button class="btn_confirm email" type="reset">회원 탈퇴</button>&nbsp;&nbsp; -->
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
			

			if(document.getElementById("newNickname").value == document.getElementById("memberNickname").value){
				if (pwCheck() == true) {
					return true;
				}
					
			} else {
				
				
// 				let nick = document.getElementById("newNickname").value;
// 				let url = 'AjaxMemberNickCheck.do?nick=' + nick;
// 				fetch(url)
// 					.then((response) => response.text())
// 					.then((data) => );


				if(nickCheck() == true){
					return false;
				}else{
					if (pwCheck() == true) {
						return true;
					}
				
				}
			}
			
			
			
		}
		
		
// 		function nickChk3(str) {
// 			let nick = document.getElementById("newNickname").value;
// 			let memNick = document.getElementById("memberNickname").value;
			
// 			console.log(str)


			// if (str == '1') {}
				
// 		}
		
		
		
		
		// 닉네임 중복체크창 사용유무
		function nickCheck() {

	let checkNick = document.getElementById("btnNick").value;

	if (checkNick == "No") {
		alert("닉네임 중복체크를 하세요.");
		return true;
	}

}
		
		
		// 비밀번호 유효성 체크
		function pwCheck() {
			let password1 = document.getElementById("newPassword").value;
			let password2 = document.getElementById("passwordChk").value;
			
			if (password1 != "") {
				if (password1 != password2) {
					alert("패스워드가 일치하지 않습니다.");
					document.getElementById("newPassword").value = "";
					document.getElementById("passwordChk").value = "";
					document.getElementById("newPassword").focus();
					return false;
				}
				return true;
			}
		}

		


		//닉네임 중복체크 Ajax	
		function nickChk() {
			let nick = document.getElementById("newNickname").value;
			let url = 'AjaxMemberNickCheck.do?nick=' + nick;
			fetch(url)
				.then((response) => response.text())
				.then((data) => nickChk2(data));
		}

		function nickChk2(str) {
			let nick = document.getElementById("newNickname").value;
			let memNick = document.getElementById("memberNickname").value;
			
			if (str == '1') {
				alert("사용할 수 있는 닉네임입니다.");
				document.getElementById("btnNick").value = 'Yes';
				document.getElementById("btnNick").disabled = true; //버튼 비활성화
				document.getElementById("newNickname").setAttribute('readonly', 'readonly');
				
			} else if(nick == memNick){
				alert("현재 닉네임과 동일합니다.")
				document.getElementById("btnNick").value = 'Yes';
			 } else {
				alert("이미 사용중인 닉네임입니다.");
				document.getElementById("newNickname").value = "";
				document.getElementById("memberNickname").focus();
			}
		}
		
	</script>


</body>
<script>
	//비밀번호

	//에러 메세지 객체
	const errMsg = {
		
		pw: "8~20자의 영문, 숫자, 특수문자를 포함한 비밀번호를 입력해주세요",

	}

	// pwVal: 패스워드, pwReVal: 패스워드 재입력, isPwValid: 패스워드 유효 여부
	let pwVal = "",
		pwReVal = "",
		isPwValid = false
	const pwInputEl = document.querySelector('#info__pw input')
	console.log(pwInputEl.value + "pwInputEl")
	const pwErrorMsgEl = document.querySelector('#info__pw .error-msg')
	pwInputEl.addEventListener('change', () => {
		const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
		pwVal = pwInputEl.value
		
		if (pwRegExp.test(pwVal)) { // 정규식 조건 만족 O
			isPwValid = true
			pwErrorMsgEl.textContent = ""
		} else { // 정규식 조건 만족 X
			isPwValid = false
			pwInputEl.value = ""
			pwErrorMsgEl.textContent = errMsg.pw;
			console.log(errMsg.pw)
		}
		checkPwValid()
		console.log(pwVal, pwReVal, isPwValid, account)


	})
</script>

</html>