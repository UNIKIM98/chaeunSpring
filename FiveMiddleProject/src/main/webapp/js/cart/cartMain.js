/**getElementById
 * 
 */
console.log("1");
let totalCal = Number(0);

//▶ dom 실행시 바로 실행

//▶ JAVA 연결 : LIST 데이터 가져오기
fetch('ajaxCartList.do')
	.then((result) => result.json())
	.then(function (dataList) {
		//▶ 리스트 출력
		makeTbd(dataList);

		// //▶ 체크삭제
		delAll();

		//▶ 결제칸에 표시
		checkPlus();

		//▶ 모두 체크
		checkAll();

		//▶ 개별삭제
		deleteOne();

		//▶ 전체결제
		document.getElementById('goToOrder').addEventListener('click', goToOrder)

		//▶ 단건결제
		document.querySelectorAll('#oneOrderBtn').forEach((btn) => {
			btn.addEventListener('click', function () {
				// console.log(this);
				// console.log(this.parentElement.parentElement.parentElement.id);
				let cartNum = this.parentElement.parentElement.parentElement.id;
				let form = document.getElementById('oneOrderForm' + cartNum);
				let input = document.createElement('input');
				input.type = "hidden";
				input.id = "cartNum";
				input.name = "cartNum";
				input.value = cartNum;
				form.append(input);
			})
		})
		// })
	})

//▶ tbody만들기
function makeTbd(dataList = []) {
	let tbd = document.querySelector('.table-shopping-cart tbody');
	// console.log(dataList);
	if (dataList.length == 0) {
		let tr = document.createElement('tr');
		tr.className = 'table_row';
		let td = document.createElement('td');
		td.innerText = '장바구니가 비었습니다.'
		td.setAttribute('style', 'text-align:center');
		td.setAttribute('colspan', 5);
		tr.append(td);
		tbd.append(tr);
	} else {
		for (const data of dataList) {
			tbd.append(makeTr(data));
		}
	}
}

//▶ tbody에 붙일 tr(상품 하나하나) 만들기
function makeTr(data) {
	//▷ tr만들기
	let tr = document.createElement('tr');
	tr.className = 'table_row';
	tr.setAttribute('id', data.cartNum);

	for (let i = 1; i < 6; i++) {
		//1. 체크박스
		let td = document.createElement('td');
		if (i == 1) {
			td.className = 'column-1';
			let label = document.createElement('label');
			label.id = data.productName;

			let ckDiv = document.createElement('div');
			ckDiv.setAttribute('align', 'left');
			let input = document.createElement('input');
			input.type = 'checkbox';
			input.id = data.productPrice;
			ckDiv.append(input);
			label.append(ckDiv);

			td.append(label);
			tr.append(td);
		}

		// 2. 썸네일
		else if (i == 2) {
			td.className = 'column-2';
			let div = document.createElement('div');
			div.className = 'how-itemcart1';

			// let detailForm = document.createElement('form');
			// form.id = 'detailForm';
			// form.action = 'productSelect.do'
			// form.method = 'post';

			// let detailInput = document.createElement('input');
			// detailInput.type = 'hidden';
			// detailInput.id = 'productNum';
			// detailInput.value = data.productNum;
			// //어펜드하기!!!!!!!!!!!!


			let img = document.createElement('img');
			img.setAttribute('style', 'width:100px');

			//↓🍓 지은언니랑 상의하기! 썸네일
			// console.log(data.productThumbnailUrl.substring(73));
			// img.src = data.productThumbnailUrl;
			img.src = 'attech/' + data.productThumbnailUrl;

			img.alt = 'IMG';
			div.append(img);
			td.append(div);
			tr.append(td);
		}

		//3. 상품제목
		else if (i == 3) {
			td.className = 'column-3';
			td.innerText = data.productName;

			tr.append(td);

		}

		//4. 가격
		else if (i == 4) {
			td.className = 'column-4';

			td.innerText = data.productPrice + '원';
			tr.append(td);
		}

		//5. 버튼
		else if (i == 5) {
			//5-1) 삭제
			td.className = 'column-5';
			let delBtn = document.createElement('button');
			delBtn.innerText = '삭제';
			delBtn.id = 'delBtn';

			let br = document.createElement('br');

			//5-2) 결제
			let oneOrderForm = document.createElement('form');
			oneOrderForm.id = 'oneOrderForm' + data.cartNum;
			oneOrderForm.action = "cartToOrder.do";
			oneOrderForm.method = "post"

			let oneOrderBtn = document.createElement('button');
			oneOrderBtn.innerText = '바로결제';
			oneOrderBtn.id = 'oneOrderBtn';

			oneOrderForm.append(oneOrderBtn);

			td.append(oneOrderForm, br, delBtn);
			tr.append(td);

			return tr;
		}
	}
}


//▶ 장바구니 선택 삭제 메소드
function delAll() {

	document.getElementById('deleteAll').addEventListener('click', function () {
		let cks = document.querySelectorAll('tbody input[type="checkbox"]');
		for (let ck in cks) {
			if (cks[ck].checked == true) {
				let cartNum = cks[ck].parentElement.parentElement.parentElement.parentElement.getAttribute('id');
				// console.log(cartNum + "delAll()")
				deleteOrder(cks[ck]);
				getTotal(totalCal);
				delFetch(cartNum);
			}
		}
	})
}

//▶ 장바구니 삭제 fetch문
function delFetch(cartNum) {
	fetch('ajaxCartDelete.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'cartNum=' + cartNum
		})
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'Success') {
				if (document.getElementById(result.cartNum) != null) {
					document.getElementById(result.cartNum).remove();
				}
			} else if (result.retCode == 'Fail') {
				alert('[삭제 실패] 처리 중 오류가 발생하였습니다.')
			}
		})
		.catch(error => console.log(error))
}

//▶ 장바구니 체크시 결제칸 추가
function checkPlus() {
	let cks = document.querySelectorAll('tbody input[type="checkbox"]');
	for (let ck of cks) {
		ck.addEventListener('click', function () {
				let grandDiv = document.getElementsByClassName('flex-w flex-t bor12 p-t-15 p-b-30')[0];
				// console.log(grandDiv);
				if (ck.checked == true) {
					let nameParentDiv = document.getElementsByClassName('size-209 w-full-ssm')[0].cloneNode();
					let nameSpan = document.createElement('span');
					nameSpan.className = 'stext-110 cl2';
					nameSpan.innerText = ck.parentElement.parentElement.id;

					nameParentDiv.id = ck.parentElement.parentElement.parentElement.parentElement.id + '_1';
					nameParentDiv.append(nameSpan);

					let priceParentDiv = document.getElementsByClassName('size-208 p-r-18 p-r-0-sm w-full-ssm')[0].cloneNode();
					let priceSpan = document.createElement('span');
					priceSpan.className = 'stext-111 cl6 p-t-2';
					priceSpan.innerText = ck.id;

					priceParentDiv.id = ck.parentElement.parentElement.parentElement.parentElement.id + '_2';
					priceParentDiv.append(priceSpan);

					grandDiv.append(nameParentDiv, priceParentDiv);

					totalCal += Number(ck.id);
				} else if (ck.checked == false && document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_1') != null) {
					document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_1').remove();
					document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_2').remove();
					totalCal -= Number(ck.id);
					document.getElementById('checkAll').checked = false;

				}

				getTotal(totalCal);

			}

		);
	}
}

function addOrder(ck) {
	if (document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_1') == null) {
		let grandDiv = document.getElementsByClassName('flex-w flex-t bor12 p-t-15 p-b-30')[0];
		// console.log(grandDiv);
		let nameParentDiv = document.getElementsByClassName('size-209 w-full-ssm')[0].cloneNode();
		let nameSpan = document.createElement('span');
		nameSpan.className = 'stext-110 cl2';
		nameSpan.innerText = ck.parentElement.parentElement.id;

		nameParentDiv.id = ck.parentElement.parentElement.parentElement.parentElement.id + '_1';
		// console.log(nameParentDiv);
		nameParentDiv.append(nameSpan);

		let priceParentDiv = document.getElementsByClassName('size-208 p-r-18 p-r-0-sm w-full-ssm')[0].cloneNode();
		let priceSpan = document.createElement('span');
		priceSpan.className = 'stext-111 cl6 p-t-2';
		priceSpan.innerText = ck.id;

		priceParentDiv.id = ck.parentElement.parentElement.parentElement.parentElement.id + '_2';
		priceParentDiv.append(priceSpan);

		grandDiv.append(nameParentDiv, priceParentDiv);
		totalCal += Number(ck.id);
	}
}

function deleteOrder(ck) {
	// console.log(document.getElementById(ck.parentElement.parentElement.parentElement.id + '_1') + "흑흑")
	if (document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_1') != null) {
		document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_1').remove();
		document.getElementById(ck.parentElement.parentElement.parentElement.parentElement.id + '_2').remove();
		totalCal -= Number(ck.id);
	}
}

//▶ 모두 선택
function checkAll() {
	let headCk = document.getElementById('checkAll');

	headCk.addEventListener('click', function () {
		let cks = document.querySelectorAll('tbody input[type="checkbox"]');
		cks.forEach((ck) => {
			ck.checked = headCk.checked;
			if (ck.checked == true) {
				addOrder(ck);
			} else if (ck.checked == false) {
				// console.log(ck);
				deleteOrder(ck);
				headCk.checked = false;
			}
		})

		getTotal(totalCal);
	})

}


//▶ 합계구하기
function getTotal(totalCal) {

	let total = document.getElementById('totalPrice');
	total.innerText = totalCal;
}


//▶ 개별삭제
function deleteOne() {
	document.querySelectorAll('#delBtn').forEach(btn => {
		btn.addEventListener('click', function () {
			let cartNum = btn.parentElement.parentElement.id;
			// console.log(cartNum);
			delFetch(cartNum);
		})
	})
}

//▶ 체크결제버튼
function goToOrder() {
	let carts = document.querySelectorAll('tbody input[type="checkbox"]:checked')
	let form = document.querySelector('#toOrder');

	for (let cart of carts) {

		let cartNum = cart.parentElement.parentElement.parentElement.parentElement.id;
		let input = document.createElement('input');
		input.type = "hidden";
		input.id = "cartNum";
		input.name = "cartNum";
		input.value = cartNum;
		form.append(input);
	}
}