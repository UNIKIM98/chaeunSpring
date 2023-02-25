/**
 * memberAjax.js
 */

// 회원정보수정 페이지 출력
// function EditForm() {
//     fetch('memberEditForm.do')
//     .then((result) => result.json())
//     .then((data) => {
//         console.log(data)
//     })
//     .catch(err => console.log(err))
// }



console.log("10")

console.log(document.querySelector('#btnEdit'))


// '바로 실행되는 코드들(init에 다 넣어놨음)은 html 페이지가 다 실행된 후에 실행하세요' 라는 이벤트를 넣어줘야 함!
// 함수는 호출됐을때 실행되니까 관계없음
//document.addEventListener('DOMContentLoaded', function() { // 데이터 수정
// document.querySelector('form[id=memberFrm]').addEventListener('submit', updateMember);

// document.querySelector('#btnEdit').addEventListener('submit', updateMember(event));
// document.getElementById('editInfo').setAttribute('submit', updateMember);

//});




function updateMember() {
	// e.preventDefault();
	console.log(2211212324343)

	console.log(document.querySelector('#newPassword').value)
	// console.log(pwInputEl.value)
	// console.log(pwInputEl2.value)

	if (document.querySelector('#newNickname').value == "") {
		alert("닉네임을 입력해주세요.")
		return;
	}
	if (document.querySelector('#newPassword').value != "") {
		// pwInputEl2.setAttribute('required', 'required')

		// const pwInputEl = document.querySelector('#memberPassword')
		// const pwInputEl2 = document.querySelector('#passwordChk')
		// console.log(pwInputEl)

		//   var p1 = document.getElementById('memberPassword').value;
		//   var p2 = document.getElementById('passwordChk').value;

		//   console.log(p1)
		//   console.log(p2)


		//   if( p1 != p2 ) {
		//     alert("비밀번호가 일치 하지 않습니다");
		//     // document.getElementById('memberPassword').replaceWith;
		//     // document.getElementById('passwordChk').replaceWith;

		//     pwInputEl.value = ""
		//     pwInputEl2.value = ""

		//     return false;

		//   }
		//   if(p1.length < 8 || p1.length > 12){
		//     alert("비밀번호를 8~12자 사이로 입력하세요");
		//     pwInputEl.value = ""
		//     pwInputEl2.value = ""
		//     return false;
		// }



		// pwVal: 패스워드, pwReVal: 패스워드 재입력, isPwValid: 패스워드 유효 여부
		// let pwVal = "",
		// 	pwReVal = "",
		// 	isPwValid = false
		// const pwInputEl = document.querySelector('#info__pw input')
		// console.log(pwInputEl.value + "pwInputEl")
		// const pwErrorMsgEl = document.querySelector('#info__pw .error-msg')
		// pwInputEl.addEventListener('change', () => {
		// 	const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
		// 	pwVal = pwInputEl.value
		// 	if (pwRegExp.test(pwVal)) { // 정규식 조건 만족 O
		// 		isPwValid = true
		// 		pwErrorMsgEl.textContent = ""
		// 	} else { // 정규식 조건 만족 X
		// 		isPwValid = false
		// 		pwErrorMsgEl.textContent = errMsg.pw;
		// 		console.log(errMsg.pw)
		// 	}


		// 	// 없어도 되나??????????????????
		// 	checkPwValid()
		// 	console.log(pwVal, pwReVal, isPwValid, account)


		// })

		// if(document.getElementById("newNickname").value == document.getElementById("memberNickname").value){
		// 	if(nickCheck() == true){
		// 		return;
		// 	}else{
		// 	if(pwCheck() == true){

		// 		updateInfo()
		// 	}

		// 	}

		// }
		// 	if(nickCheck() == true){
		// 		return;
		// 	}else{
		// 	if(pwCheck() == true){

		// 		updateInfo()
		// 	}

		// 	}


		if (document.getElementById("newNickname").value == document.getElementById("memberNickname").value) {
			if (pwCheck() == true) {
				updateInfo()
			}
		} else {
			if (nickCheck() == true) {
				return;
			} else {
				if (pwCheck() == true) {
					updateInfo()
				}

			}
		}




		// nickCheck()




	} else {

		if (document.getElementById("newNickname").value == document.getElementById("memberNickname").value) {
			updateNoPw()
		} else {
			if (nickCheck() == true) {
				return;
			} else {

				updateNoPw()
			}
		}


	}


}






// 수정처리 하는 곳
function updateInfo() {
	// 수정 버튼 눌렀을 때 비밀번호, 닉네임 찾아오기
	let memberId = document.getElementById('memberId').value;
	let password = document.getElementById('newPassword').value;
	let nickname = document.getElementById('newNickname').value;
	// let passwordCheck = document.getElementById('passwordChk').value;



	fetch('memberUpdate.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'memberId=' + memberId + '&memberPassword=' + password + '&memberNickname=' + nickname
		})
		.then(result => result.json())
		.then(result => {
			console.log(result)
			document.getElementById("newPassword").value = "";
			document.getElementById("passwordChk").value = "";
			document.getElementById("newPassword").focus();
			alert("회원정보가 수정되었습니다.")



			// document.getElementById('memberPassword').replaceWith(result.memberPassword);
			// document.getElementById('memberNickname').value(result.memberNickname);

			// document.getElementById('editInfo').addEventListener('submit', updateMember);

		})
		.catch(err => console.log(err))








	// // 🔥🔥🔥
	// // 수정 돌릴때 DB에 있는 닉네임이랑 중복인지 다시 체크하는 부분
	// nickChkAgain()


	// if(nickChkAgain() == 'Yes'){

	// 	// 닉네임 재 체크 if문 뺀다면 fetch~catch()여기까지 싹 긁어서 밖으로 빼야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// 	fetch('memberUpdate.do', {
	// 		method: 'post',
	// 		headers: {
	// 			'Content-Type': 'application/x-www-form-urlencoded'
	// 		},
	// 		body: 'memberId=' + memberId + '&memberPassword=' + password + '&memberNickname=' + nickname
	// 	})
	// 		.then(result => result.json())
	// 		.then(result => {
	// 			console.log(result)
	// 			document.getElementById("newPassword").value = "";
	// 			document.getElementById("passwordChk").value = "";
	// 			document.getElementById("newPassword").focus();
	// 			alert("회원정보가 수정되었습니다.")



	// 			// document.getElementById('memberPassword').replaceWith(result.memberPassword);
	// 			// document.getElementById('memberNickname').value(result.memberNickname);

	// 			// document.getElementById('editInfo').addEventListener('submit', updateMember);

	// 		})
	// 		.catch(err => console.log(err))

	// }else {

	// 	return;

	// }


	// // 여기까지 중복 다시 체크하는 부분........................................
	// // 🔥🔥🔥


}




// 비밀번호 없을때 수정처리 하는 곳
function updateNoPw() {
	// 수정 버튼 눌렀을 때
	let memberId = document.getElementById('memberId').value;
	let nickname = document.getElementById('newNickname').value;

	fetch('memberUpdateNotPw.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'memberId=' + memberId + '&memberNickname=' + nickname
		})
		.then(result => result.json())
		.then(result => {
			console.log(result)
			alert("회원정보가 수정되었습니다.")

			// document.getElementById('memberPassword').replaceWith(result.memberPassword);
			// document.getElementById('memberNickname').value(result.memberNickname);

			// document.getElementById('editInfo').addEventListener('submit', updateMember);

		})
		.catch(err => console.log(err))
}






//닉네임 중복체크 Ajax	
function nickChk() {

	let nick = document.getElementById("newNickname").value;
	console.log(nick)
	let url = 'AjaxMemberNickCheck.do?nick=' + nick;
	fetch(url)
		.then((response) => response.text())
		.then((data) => nickChk2(data));


}

function nickChk2(str) {
	let nick = document.getElementById("newNickname").value;
	let memNick = document.getElementById("memberNickname").value;
	// String id = session.getAttribute("id");

	if (str == '1') {
		alert("사용할 수 있는 닉네임입니다.");
		document.getElementById("btnNick").value = 'Yes';
		// document.getElementById("btnNick").disabled = true; //버튼 비활성화
	} else if (nick == memNick) {
		alert("현재 닉네임과 동일합니다.")
		document.getElementById("btnNick").value = 'Yes';
	} else {
		alert("이미 사용중인 닉네임입니다.");
		document.getElementById("newNickname").value = "";
		document.getElementById("memberNickname").focus();

	}

}




// 🔥🔥🔥 닉네임 2차 중복체크 Ajax	
function nickChkAgain() {

	let nick = document.getElementById("newNickname").value;
	console.log(nick)
	let url = 'AjaxMemberNickCheck.do?nick=' + nick;
	fetch(url)
		.then((response) => response.text())
		.then((data) => nickChkAgain2(data));

}

function nickChkAgain2(str) {
	let nick = document.getElementById("newNickname").value;
	let memNick = document.getElementById("memberNickname").value;

	if (str == '1') {
		return 'Yes';
	} else if (nick == memNick) {
		return 'Yes';
	} else {
		alert("이미 사용중인 닉네임입니다.");
		document.getElementById("newNickname").value = "";
		document.getElementById("memberNickname").focus();

	}

}







// 닉네임 중복체크 했는지 확인
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

	if (password1 != password2) {
		alert("패스워드가 일치하지 않습니다.");
		document.getElementById("newPassword").value = "";
		document.getElementById("passwordChk").value = "";
		document.getElementById("newPassword").focus();
		return;
	}
	return true;

}




//에러 메세지 객체
const errMsg = {
	id: {
		invalid: "010형식으로 입력해주세요",
		success: "사용 가능한 아이디입니다",
		fail: "사용할 수 없는 아이디입니다"
	},
	pw: "8~20자의 영문, 숫자, 특수문자를 포함한 비밀번호를 입력해주세요",

}





let nick = document.getElementById("newNickname").value;
let url = 'AjaxMemberNickCheck.do?nick=' + nick;
fetch(url)
	.then((response) => response.text())
	.then((data) => nickChk3(data));


	function nickChk2(str) {
		let nick = document.getElementById("newNickname").value;
		let memNick = document.getElementById("memberNickname").value;
		
		console.log(str)


		// if (str == '1') {}
			
	}