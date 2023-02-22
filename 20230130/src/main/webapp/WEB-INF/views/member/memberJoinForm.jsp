<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
	font-family: 'NanumSquareNeo-Variable';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'NanumSquareNeo-Variable';
}
</style>
</head>

<body>
	<div align="center">
		<div>
			<h3>회원가입</h3>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" onsubmit="return fromCheck()"
				method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="300"><input type="text" id="memberId"
								name="memberId" required="required">&nbsp;
								<button type="button" onclick="idChk()" id="btnId" value="NO">중복체크</button>
							</td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td width="300"><input type="text" id="memberName"
								name="memberName" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="300"><input type="password" id="memberPassword"
								name="memberPassword" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드확인</th>
							<td width="300"><input type="password" id="passwordChk"
								required="required"></td>
						</tr>
						<tr>
							<th width="150">나이</th>
							<td width="300"><input type="text" id="memberAge"
								name="memberAge"></td>
						</tr>
						<tr>
							<th width="150">주소</th>
							<td width="300"><input type="text" id="memberAddress"
								name="memberAddress"></td>
						</tr>
						<tr>
							<th width="150">전화번호</th>
							<td width="300"><input type="tel" id="memberTel"
								name="memberTel"></td>
						</tr>
					</table>
				</div>
				<br> <input type="submit" value="회원가입">&nbsp;&nbsp; <input
					type="reset" value="취소">&nbsp;&nbsp; <input type="button"
					onclick="location.href='home.do'" value="홈가기">&nbsp;&nbsp;
					
			</form>
		</div>
	</div>

	<script type="text/javascript">
		//✅ 폼 제출(회원가입) 직전 id/pw체크
		function fromCheck() { 
			let pass1 = document.getElementById("memberPassword").value;
			let pass2 = document.getElementById("passwordChk").value;
			let checkId = document.getElementById("btnId").value;

			if (checkId == "NO") {
				alert("아이디 중복체크를 하세요")
				return false;
			}
			if (pass1 != pass2) {
				alert("패스워드가 일치하지 않습니다.");
				document.getElementById("memberPassword").value = "";
				document.getElementById("passwordChk").value = "";
				document.getElementById("memberPassword").focus();

				return false;
			}if(document.getElementById("memberTel").value=""){
				
			}
		}

		//✅ id체크 ajax
		function idChk() { //아이디중복체크 > 아이작스로 비교
			let memberId = document.getElementById("memberId").value;
			let url = 'AjaxMemberIdCheck.do?memberId=' + memberId;

			//Ajax : get방식으로 아이디를 실어서 보내겠다.
			fetch(url).then((response) => response.text()).then((data) => idCheck(data));
		}

		//✅ id체크
		function idCheck(str) {
			if (str == '1') {
				alert("사용 가능한 아이디입니다.")
				document.getElementById("btnId").value = 'Yes';
				document.getElementById("btnId").disabled = true;

			} else {
				alert("이미 사용하는 아이디입니다.\n다시 입력하세요.")
				document.getElementById("memberId").value = "";
				document.getElementById("memberId").focus();
				return false;
			}
		}
	</script>

</body>

</html>