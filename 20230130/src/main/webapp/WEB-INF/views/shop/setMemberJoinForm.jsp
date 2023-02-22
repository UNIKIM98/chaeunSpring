<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<div>
			<h1>쇼핑몰 회원가입</h1>
		</div>
		<div>
			<form id="frm" onsubmit="return formSubmit()" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
								<button type="button" id="idCheck" value="no" onclick="idcheck()">중복체크</button></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="shPassword" name="shPassword" required></td>
						</tr>
						<tr>
							<th>패스워드 확인</th>
							<td><input type="password" id="shPasswordCheck" name="shPasswordCheck" required="required">
							</td>
						</tr>
						<tr>
							<th>구분</th>
							<td><input type="radio" id="shGubun" name="shGubun" value="C" onchange="showDiv('C')"
									checked="checked">고객 <input type="radio" id="shGubun" name="shGubun" value="U"
									onchange="showDiv('U')">상점주 <input type="radio" id="shGubun" name="shGubun"
									value="E" onchange="showDiv('E')">직원
							</td>
						</tr>
					</table>
					<div id="customer" style="display: block;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shCustomerName" name="shcustomerName"></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><input type="tel" id="shCustomerTel" name="shcustomerTel"></td>
							</tr>
						</table>
					</div>
					<div id="user" style="display: none;">
						<table>
							<tr>
								<th>대표이름</th>
								<td><input type="text" id="shUserName" name="shUserName"></td>
							</tr>
							<tr>
								<th>상호명</th>
								<td><input type="text" id="shUserShopname" name="shUserShopname"></td>
							</tr>
						</table>
					</div>

					<!-- ▶ 시험문제========================================================= -->
					<div id="employee" style="display: none;">
						<p style="font-size: small; color: grey;">※ 부서는 '마케팅', '관리'만
							입력할 수 있습니다.</p>
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="empName" name="empName"></td>
							</tr>
							<tr>
								<th>부서</th>
								<td><input type="tel" id="empDepartment" name="empDepartment" required></td>
							</tr>
							<tr>
								<th>직급</th>
								<td>
									<select name="empPosition" id="empPosition" required>
										<option value="">::선택::</option>
										<option value="팀장">팀장</option>
										<option value="팀원">팀원</option>
									</select>
								</td>

							</tr>
							<tr>
								<th>입사일</th>
								<td><input type="date" id="empHireDate" name="empHireDate" required></td>
							</tr>
							<tr>
								<th>퇴사일</th>
								<td><input type="date" id="empEndDate" name="empEndDate" required></td>
							</tr>
						</table>
					</div>
				</div>
				<br> <input type="submit" value="등록">&nbsp;&nbsp; <input type="reset" value="취소">
			</form>
		</div>
	</div>
	<script>
		function showDiv(option) {
			if (option == 'C') {
				document.getElementById('customer').setAttribute('style', 'display:block')
				document.getElementById('user').setAttribute('style', 'display:none')
				document.getElementById('employee').setAttribute('style', 'display:none')
			} else if (option == 'U') {
				document.getElementById('customer').setAttribute('style', 'display:none')
				document.getElementById('user').setAttribute('style', 'display:block')
				document.getElementById('employee').setAttribute('style', 'display:none')
			} else if (option == 'E') {
				document.getElementById('customer').setAttribute('style', 'display:none')
				document.getElementById('user').setAttribute('style', 'display:none')
				document.getElementById('employee').setAttribute('style', 'display:block')
			}
		}

		function idcheck() {
			let id = document.getElementById("shId").value;
			fetch("ajaxShopIdCheck.do?id=" + id)
				.then(response => response.text())
				.then(data => idCheckResult(data));
		}

		function idCheckResult(data) {
			if (data == "true") {
				alert("이미 사용하는 아이디 입니다.");
			} else if (data == "false") {
				alert("사용가능한 아이디 입니다.");
				document.getElementById("idCheck").value = "yes";
			}
		}

		function formSubmit() {
			let option = document.querySelector('#shGubun:checked').value;
			if (frm.idCheck.value == 'no') {
				alert("아이디 중복체크를 해주세요");
				return false;
			} else if (frm.shPassword.value != frm.shPasswordCheck.value) {
				alert("패스워드를 확인해주세요.");
				return false;
			}

			if (option == 'C') {
				if (frm.shCustomerName.value == "") {
					alert("사용자 이름을 입력하세요");
					frm.shCustomerName.forcus();
					return false;
				} else if (frm.shCustomerTel.value == "") {
					alert("사용자 전화번호를 입력하세요");
					frm.shCustomerTel.forcus();
					return false;
				}
				frm.action = "shopCustomerJoin.do";
			} else if (option == 'U') {
				if (frm.shUserName.value == "") {
					alert("대표자 이름을 입력하세요");
					frm.shUserName.forcus();
					return false;
				} else if (frm.shUserShopname.value == "") {
					alert("상호명을 입력하세요");
					frm.shUserShopname.forcus();
					return false;
				}
				frm.action = "shopUserJoin.do";

				// ▶ 시험문제=========================================================
			} else {
				let department = frm.empDepartment.value
				if (frm.empName.value == "") {
					alert("이름을 입력하세요");
					return false;
				} else if (frm.empDepartment.value == "") {
					alert("부서를 입력하세요");
					return false;
				} else if (department != "마케팅" && department !="관리") {
					alert("부서는 '마케팅', '관리'만 입력할 수 있습니다.");
					return false;
				} else if (frm.empHireDate.value == "") {
					alert("입사일을 입력해주세요.");
					return false;
				} else if (frm.empEndDate.value == "") {
					alert("퇴사일을 입력해주세요.");
					return false;
				}
				frm.action = "shopEmployeeJoin.do";
			}

			return true;
		}
	</script>
</body>

</html>