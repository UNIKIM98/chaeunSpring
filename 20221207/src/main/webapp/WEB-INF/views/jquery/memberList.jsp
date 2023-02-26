<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style>
@font-face {
	font-family: 'KoddiUDOnGothic-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/KoddiUDOnGothic-Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: KoddiUDOnGothic-Regular;
}
</style>

<div align="center">
	<br>
	<div>
		<h1>🥳회원가입</h1>
	</div>
	<div>
		<form id="frm" action="memberJoin.do" onsubmit="return formCheck()"
			method="post">
			<div>
				<table border="1" class="table">

					<tr>
						<th width="150">아이디</th>
						<td width="300"><input type="text" id="memberId"
							name="memberId" required="required" value="user"
							title="[필수] 아이디를 입력하세요.">&nbsp;
							<button type="button" onclick="idChk()" id="btnId" value="No">중복체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td><input type="text" id="memberName" name="memberName"
							required="required" value="홍길동" title="[필수] 이름을 입력하세요"></td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td><input type="password" id="memberPassword"
							name="memberPassword" required="required" value="1234"
							title="[필수] 비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<th width="150">패스워드확인</th>
						<td><input type="password" id="passwordChk"
							required="required" value="1234" title="[필수] 비밀번호를 한 번 더 입력하세요"></td>
					</tr>
					<tr>
						<th width="150">나이</th>
						<td><input type="text" id="memberAge" name="memberAge"
							value="20" title="나이를 입력하세요"></td>
					</tr>
					<tr>
						<th width="150">주소</th>
						<td><input type="text" id="memberAddress"
							name="memberAddress" value="대구 중구" title="주소를 입력하세요"></td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td><input type="tel" id="memberTel" name="memberTel"
							value="010 0000 0000" title="주소를 입력하세요"></td>
					</tr>
				</table>
			</div>
			<br> <input type="submit" value="회원가입">&nbsp;&nbsp; <input
				type="reset" value="취소">&nbsp;&nbsp; <input type="button"
				onclick="location.htref='main.do'" value="홈가기">
		</form>
	</div>
	<br> <br>
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>연락처</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody id="memberList">

		</tbody>
	</table>
</div>
<div id="dialog" title="기본창">
	<p></p>
</div>
<script>
	//input 가이드
	$(function () {
		var tooltips = $("[title]").tooltip({
			position: {
				// 				my: "left top",
				// 				at: "right+5 top-5",
				collision: "none"
			}
		});
	});

	//변경 ajax
	function updateMemberAjax(e) { //온클릭 이벤트에서 전달되는 함수이므로 매개값으로 e 주기
		let tr = $(e.currentTarget).parent().parent();

		console.log(tr)
		let memberId = tr.children().eq(0).text();
		let memberAddress = tr.children().eq(3).children().eq(0).val();
		let memberTel = tr.children().eq(4).children().eq(0).val();


		$.ajax({
			url: 'updateMemberAjax.do',
			method: 'post',
			data: {
				memberId: memberId,
				memberAddress: memberAddress,
				memberTel: memberTel
			},
			dataType: 'json',
			success: function (result) {
				console.log(result);
				$('#' + result.data.memberId).replaceWith(makeRow(result.data));
			},
			error: function (err) {
				console.log(err)
			}
		})
	}


	//화면수정 tr 제공
	function modMemberFnc(e) {
		// let memberId = $(e.currentTarget).parent().parent().children().eq(0).text();
		let memberId = $(e.currentTarget).parent().parent().attr('id');

		$.ajax({
			url: 'memberGetAjax.do?memberId=' + memberId,
			method: 'post', //지정 안 하면 디폴트 == get
			dataType: 'json',
			success: function (result) {
				console.log(result);
				if (result != null) {
					let ntr = $('<tr />').append(
						$('<td />').text(result.memberId),
						$('<td />').text(result.memberName),
						$('<td />').text(result.memberAge),
						$('<td />').append($('<input />').attr('type', 'text').val(result.memberAddress)),
						$('<td />').append($('<input />').attr('type', 'text').val(result.memberTel)),
						$('<td />').append($('<button />').text('삭제').on('click', delMemberFnc).attr(
							'disabled', 'disabled')),
						$('<td />').append($('<button />').text('변경').on('click', updateMemberAjax)));
					$(ntr).attr('id', result.memberId);

					$('#' + memberId).replaceWith(ntr);
				}
			},
			error: function (err) {
				console.log(err);
			}
		})

	}

	//이벤트는 기본적으로 e(event)가 매개값으로 넘어감!
	function delMemberFnc(e) {
		//currentTarget는 자스 객체이므로 제이쿼리 객체로 바꿔주기 위해 $ 사용
		// id = $(e.currentTarget).parent().parent().children().eq(0).text();
		let memberId = $(e.currentTarget).parent().parent().attr('id');
		$.ajax({
			url: 'memberDelAjax.do',
			method: 'post',
			dataType: 'json',
			data: {
				memberId: memberId
			},
			success: function (result) {
				console.log(result)
				if (result.retCode == 'Success') {
					$('#' + memberId).remove();
				} else {
					alert('처리 중 에러 발생')
				}
			},
			error: function (err) {
				console.log(err)
			}
		})
	}

	function makeRow(obj = {}) {
		let tr = $('<tr />').append(
			$('<td />').text(obj.memberId),
			$('<td />').text(obj.memberName),
			$('<td />').text(obj.memberAge),
			$('<td />').text(obj.memberAddress),
			$('<td />').text(obj.memberTel),
			$('<td />').append($('<button />').text('삭제').on('click', delMemberFnc)),
			$('<td />').append($('<button />').text('수정').on('click', modMemberFnc)));

		tr.attr('id', obj.memberId);

		return tr;
	}
	//▶ 화면 로딩되면 목록 출력
	$.ajax({
		url: 'memberListAjax.do',
		dataType: 'json',
		method: 'get', //조회만 하면 되므로 post 아니고 get 사용
		data: {

		},
		success: function (data) {
			console.log(data);
			$(data).each(function (index, item) {
				if (item.memberAge > 0) {
					$('#memberList').append(makeRow(item));
				}
			})
		},
		error: function (err) {
			console.log(err)
		}
	})

	//▶ 아이디 중복 체크
	function idChk() {
		let searchId = $('#memberId').val();
		console.log(searchId)
		$.ajax({
			url: 'AjaxMemberIdCheck.do',
			method: 'post', //대소문자 상관없음
			data: {
				id: searchId
			}, //'id=' + searchId,
			success: function (result) {
				console.log(result)
				if (result == 0) {
					// alert('이미 존재하는 아이디입니다.')
					$("#dialog p").text('이미 존재하는 아이디입니다.')
					$("#dialog").dialog();

					$('#memberId').val('');
				} else {
					// alert('사용 가능한 아이디입니다.')
					$("#dialog p").text('사용가능한 아이디입니다.')
					$("#dialog").dialog();

				}
			},
			error: function (error) {
				console.log(error)
			}
		});
	}

	//▶ submit 이벤트
	function formCheck() {
		//패스워드 일치하는지 확인
		let pass1 = $('#memberPassword').val();
		let pass2 = $('#passwordChk').val();

		if (pass1 != pass2) {
			alert('비밀번호가 일치하지 않습니다.');
			return false; //그냥 return만 하면 함수 종료되지만 null값이 전달되기 때문에 페이지가 넘어감
		}

		let params = $('#frm').serialize();
		console.log(params);
		//return true 하면 페이지 이동하기 때문에 아작스 호출로 변경
		$.ajax({
			url: 'memberAddAjax.do',
			method: 'post',
			data: params,
			dataType: 'json',
			success: function (result) {
				console.log(result);
				if (result.retCode == 'Success') {
					$('#memberList').append(makeRow(result.data));
				}
				//↓ 결과값을 JSON 타입으로 파싱해주기 : 위에서 dataType : 'json' 지정해주면 안 적어도 됨!
				// JSON.parse(result);
				//▶ 자동 업데이트
			},
			error: function (error) {
				console.log(error)
			}
		})
		return false;
	}
</script>