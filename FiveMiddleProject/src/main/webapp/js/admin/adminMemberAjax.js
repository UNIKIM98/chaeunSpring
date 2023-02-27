/**
 * 
 */

console.log("2");

const showFields = {
	memberId: "아이디",
	memberName: "이름",
	memberNickname: "닉네임",
	memberGender: "성별",
	memberBirth: "생년월일",
	memberPhone: "전화번호"
};

//▼ JAVA연결 : List 데이터 가져오기
fetch('ajaxAdminMemberList.do')
	.then((result) => result.json())
	.then(function (dataList) {
		// console.log(data);

		//▼ 리스트 출력
		makeTable(dataList);

		//▼ 선택삭제
		document.getElementById('delBtn').addEventListener('click', delMembers);

		//▼ 수강강좌 출력
		orderList();

		//아코디언
		// addListBtn();
	})
	.catch(error => console.log(error))

//▼ 리스트 출력 메소드
function makeTable(dataList = []) {
	let tbl = document.getElementById('dataTable');
	let tbd = document.createElement('tbody');

	for (const data of dataList) {
		tbd.append(makeTr(data));
	}
	tbl.append(tbd);

}

//▼ tbody > tr 만들기
function makeTr(data) {
	
	let tr = document.createElement('tr');
	let th = document.querySelector('#dataTable thead th');
	console.log(data);

	for (let i = 1; i < 6; i++) {
		if (i == 1) {
			let newTh = document.createElement('th');
			newTh = th.cloneNode(true);
			tr.setAttribute('id', data.memberId);
			// tr.className = 'collapsible';
			tr.append(newTh);
			// console.log(newTh)
		}
		// console.log(data.i);
		for (let j in data) {
			if (j != 'memberPassword' && j != 'memberRole') {
				let td = document.createElement('td');
				td.innerText = data[j];

				tr.append(td);
			}
		}
		tr.append(addListBtn(data));
		// console.log(tr.id);
		return tr;
	}
}

//▼ 회원삭제
function delMembers() {
	let checkeds = document.querySelectorAll('#dataTable tbody input[type="checkbox"]:checked');
	console.log(checkeds);
	for (let ck in checkeds) {
		console.log(ck);
		console.log(checkeds[ck]);

			let memberId = checkeds[ck].parentNode.parentNode.getAttribute('id');
			console.log(memberId);
			removeFetch(memberId);

	}
}
//▼ 회원삭제 처리(자바연결)
function removeFetch(memberId) {
	console.log("리무브패치까지 왔음")
	fetch('ajaxAdminDel.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'memberId=' + memberId
		})
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'Success') {
				document.getElementById(result.memberId).remove();
				alert('회원 삭제가 정상적으로 처리되었습니다.')
			} else if (result.retCode == 'Fail') {
				alert('[삭제 실패] 처리 중 오류가 발생하였습니다.')
			}
		})
		.catch(error => console.log(error))
}

// // collapse 이벤트 넣기(아코디언) (버튼 붙이기 + 아코디언)
// function addListBtn() {
//     let td = document.createElement('td');
//     let listBtn = document.createElement('button');
//     listBtn.setAttribute('data-toggle', 'collapse');
//     listBtn.setAttribute('href', '#classP');
//     listBtn.innerText = '수강강좌';

//     let classDiv = document.createElement('div');
//     classDiv.className = 'collapse';
//     classDiv.id = 'classP';
//     let classP = document.createElement('p');
//     classP.innerText = '아 코 디 언 되 길 바 라 .';

//     classDiv.append(classP);


//     td.append(listBtn, classDiv);
//     return td;
// }

// 수강강좌 버튼 붙이기(버튼만!)
function addListBtn(data) {
	let td = document.createElement('td');
	let listBtn = document.createElement('button');
	listBtn.id = 'listBtn';
	listBtn.innerText = '수강강좌';
	//  console.log(data);
	// listBtn.addEventListener('click', orderList(data));
	td.append(listBtn);
	return td;
}

function orderList() {
	let listBtns = document.querySelectorAll('#listBtn');
	listBtns.forEach(btn => {
		btn.addEventListener('click', function () {
			let memberId = this.parentElement.parentElement.getAttribute('id');

			fetch('ajaxOrdersSelectList.do', {
					method: 'post',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: 'memberId=' + memberId
				})
				.then((result) => result.json())
				.then(function (resultList) {
					// ▶ 모달 출력 function
					deleteModalTr();
					//수강중인 강좌
					makeTrueModal(resultList);
					//수강종료된 강좌
					makeFalseModal(resultList);

					onClick();
				})
				.catch(error => console.log(error))
		})
	})
}

function deleteModalTr() {
	let trs = document.querySelectorAll('.modal_wrap tbody tr')
	console.log(trs);
	trs.forEach(tr => {
		tr.remove();
	})
}

function makeTrueModal(resultList = []) {
	let modalTbl = document.getElementById('trueTable')
	let modalTbd = document.getElementById('trueClass');
	for (const result of resultList) {
		modalTbd.append(makeTrueModalTr(result));
	}
}

function makeTrueModalTr(result) {

	let tr = document.createElement('tr');
	if (result.ordersStatus == 'YES') {
		let td1 = document.createElement('td');
		td1.innerText = result.productName;
		tr.append(td1);

		let td2 = document.createElement('td');
		td2.innerText = result.productDate + '일'
		tr.append(td2);
	}
	return tr;
}

function makeFalseModal(resultList = []) {
	let modalTbl = document.getElementById('falseTable');
	let modalTbd = document.getElementById('falseClass');
	for (const result of resultList) {
		modalTbd.append(makeFalseModalTr(result));
	}
}

function makeFalseModalTr(result) {
	let tr = document.createElement('tr');

	if (result.ordersStatus == 'NO') {
		let td1 = document.createElement('td');
		td1.innerText = result.productName;
		tr.append(td1);

		let td2 = document.createElement('td');
		td2.innerText = result.productDate + '일'
		tr.append(td2);
	}
	return tr;
}

function onClick() {
	document.querySelector('.modal_wrap').style.display = 'block';
}