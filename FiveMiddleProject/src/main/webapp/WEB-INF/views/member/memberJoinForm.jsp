<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/member/memberJoinForm.css">

	<title>Insert title here</title>
</head>

<body>
	<br>
	<br>
	<br>
	<div class="wrap wd668">
		<div class="container">

			<form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
				<div class="form_txtInput">
					<h2 class="sub_tit_txt">회원가입</h2>
					<p class="exTxt">회원가입시 중복확인을 반드시 진행하셔야 합니다.</p>

					<div class="join_form">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>

								<tr class="email">
									<th><span>이메일(아이디)</span></th>
									<td>
										<input type="text" class="email" placeholder="이메일" id="memberId2" name="memberId2" required="required"> 
											
										<input type="hidden" class="email" placeholder="이메일" id="memberId" name="memberId" required="required"> 
										
										<span class="mar10">@  </span> 
										
										<input type="text" class="email email2" id="domain-txt" placeholder="">&nbsp;&nbsp;
										
										<select class="email email2" id="domain-list">
											<option value="type">직접 입력</option>
											<option value="naver.com">naver.com</option>
											<option value="kakao.com">kakao.com</option>
											<option value="google.com">google.com</option>
											<option value="hanmail.net">hanmail.net</option>
											<option value="nate.com">nate.com</option>
										</select> <br>
										<button class="btn_confirm email" onclick="idChk()" id="btnId"
											value="No">이메일 중복확인</button></td>
								</tr>
								<tr>
									<th><span>이름</span></th>
									<td><input type="text" placeholder="이름을 입력해주세요." id="memberName" name="memberName"
											required="required"></td>
								</tr>

								<tr>
									<th><span>닉네임</span></th>
									<td><input type="text" class="nickname" id="memberNickname" name="memberNickname"
											placeholder="닉네임을 입력해주세요." required="required">&nbsp;&nbsp;&nbsp;

										<button class="btn_confirm nick" onclick="nickChk()" id="btnNick" value="No">닉네임
											중복확인</button></td>
								</tr>

								<tr id="info__pw">
									<th><span>비밀번호</span></th>
									<td><input type="password" id="memberPassword" name="memberPassword"
											required="required" placeholder="영문,숫자,특수문자 포함 8자리 이상 입력해주세요.">
											<div class="error-msg"></div>
									</td>
								</tr>
								
								<tr>
									<th><span>비밀번호 확인</span></th>
									<td><input type="password" id="passwordChk" required="required"
											placeholder="비밀번호를 한 번 더 입력해주세요."></td>
								</tr>

								<tr>
									<th class="noAfter"><span>휴대폰 번호</span></th>
									<td><input type="text" id="memberPhone" name="memberPhone"
											placeholder="'-' 제외 휴대폰 번호를 입력해주세요."></td>
								</tr>

								<tr>
									<th class="noAfter"><span>생년월일</span></th>
									<td><input type="date" id="memberBirth" name="memberBirth" placeholder=""></td>
								</tr>
								<tr>
									<th class="noAfter"><span>성별</span></th>
									<td><select class="email email2" id="memberGender" name="memberGender">
										<option value="">선택 안함</option>
										<option value="여">여</option>
										<option value="남">남</option>
										</select>
											</td>
								</tr>
								<tr>
							</tbody>
						</table>
						<div class="exform_txt">
							<span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.</span>
						</div>
					</div>
					<!-- join_form E  -->

					<div class="agree_wrap">
						<div class="checkbox_wrap">
							<input type="checkbox" id="news_letter" name="news_letter" class="agree_chk"> <label
								for="news_letter">[선택]뉴스레터
								수신동의</label>
						</div>
						<div class="checkbox_wrap mar27">
							<input type="checkbox" id="marketing" name="marketing" class="agree_chk"> <label
								for="marketing">[선택]마케팅
								목적 개인정보 수집 및 이용에 대한 동의</label>
							<ul class="explan_txt">
								<li><span class="red_txt">항목 : 성별, 생년월일</span></li>
								<li>고객님께서는 위의 개인정보 및 회원정보 수정 등을 통해 추가로 수집하는 개인정보에<br /> 대해
									동의하지 않거나 개인정보를 기재하지 않음으로써 거부하실 수 있습니다.<br /> 다만 이때 회원 대상 서비스가
									제한될 수 있습니다.
								</li>
							</ul>
						</div>
					</div>
					<div class="btn_wrap">
						<button class="btn_confirm email" type="submit">회원가입</button>
						&nbsp;&nbsp;
						<button class="btn_confirm email" type="reset">취소</button>
						&nbsp;&nbsp;
						<button class="btn_confirm email" type="button" onclick="location.href='main.do'">메인으로</button>
					</div>
				</div>
			</form>
			<!-- form_txtInput E -->
		</div>
		<!-- content E-->
	</div>
	<!-- container E -->
	<script type="text/javascript">
		//이메일 드롭다운
		// 도메인 직접 입력 or domain option 선택
		const domainListEl = document.querySelector('#domain-list')
		const domainInputEl = document.querySelector('#domain-txt')
		// select 옵션 변경 시
		domainListEl.addEventListener('change', (event) => {
			// option에 있는 도메인 선택 시
			if (event.target.value !== "type") {
				// 선택한 도메인을 input에 입력하고 disabled
				domainInputEl.value = event.target.value
				domainInputEl.disabled = true
			} else { // 직접 입력 시
				// input 내용 초기화 & 입력 가능하도록 변경
				domainInputEl.value = ""
				domainInputEl.disabled = false
			}
		})


		function formCheck() { //아이디 중복체크 및 패스워드 동일성 확인
			let password1 = document.getElementById("memberPassword").value;
			let password2 = document.getElementById("passwordChk").value;
			let checkId = document.getElementById("btnId").value;
			let checkNick = document.getElementById("btnNick").value;

			if (checkId == "No") {
				alert("아이디 중복체크를 하세요.");
				return false;
			}

			if (checkNick == "No") {
				alert("닉네임 중복체크를 하세요.");
				return false;
			}

			if (password1 != password2) {
				alert("패스워드가 일치하지 않습니다.");
				document.getElementById("memberPassword").value = "";
				document.getElementById("passwordChk").value = "";
				document.getElementById("memberPassword").focus();
				return false;
			}

			return true;
		}

		//아이디 중복체크 Ajax
		function idChk() {
			let id = document.getElementById("memberId2").value;
			let domain = document.getElementById("domain-txt").value;
			let domainId = id + "@" + domain;
			document.getElementById("memberId").value = domainId;

			console.log(domainId)
			let url = 'AjaxMemberIdCheck.do?domainId=' + domainId;
			fetch(url)
				.then((response) => response.text())
				.then((data) => idCheck(data));

		}

		function idCheck(str) {
			if (str == '1') {
				alert("사용할 수 있는 아이디입니다.");
				document.getElementById("btnId").value = 'Yes';
				document.getElementById("btnId").disabled = true; //버튼 비활성화

			} else {
				alert("이미 사용하는 아이디입니다.");
				document.getElementById("memberId").value = "";
				document.getElementById("memberId").focus();
			}
		}

		//닉네임 중복체크 Ajax	
		function nickChk() {
			let nick = document.getElementById("memberNickname").value;
			let url = 'AjaxMemberNickCheck.do?nick=' + nick;
			fetch(url)
				.then((response) => response.text())
				.then((data) => nickChk2(data));
		}

		function nickChk2(str) {
			if (str == '1') {
				alert("사용할 수 있는 닉네임입니다.");
				document.getElementById("btnNick").value = 'Yes';
				document.getElementById("btnNick").disabled = true; //버튼 비활성화
				document.getElementById("memberNickname").setAttribute('readonly', 'readonly');
			} else {
				alert("이미 사용하는 닉네임입니다.");
				document.getElementById("memberNickname").value = "";
				document.getElementById("memberNickname").focus();
			}
		}
		
	</script>


</body>
<script>
	//비밀번호

	//에러 메세지 객체
	const errMsg = {
		id: {
			invalid: "010형식으로 입력해주세요",
			success: "사용 가능한 아이디입니다",
			fail: "사용할 수 없는 아이디입니다"
		},
		pw: "  8~20자의 영문, 숫자, 특수문자를 포함한 비밀번호를 입력해주세요",

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