console.log("10");




// ✅ [실행]===============================================================================
let amount = $('#perPage').val();
ajaxCall(1, amount);

//📌 선택목록 변경
$('#perPage').on('change', function () {
	ajaxCall(1, $(this).val())
})

//📌 검색버튼
$('#searchBtn').on('click', function () {
	let searchCondition = $('#searchCondition').val();
	let keyword = $('#keyword').val();
	ajaxCall(1, $('#perPage').val(), searchCondition, keyword)
})

//📌 form submit event
$('#frm').on('submit', function (e) {
	e.preventDefault();

	let frm = document.getElementById('frm');
	//FormData 자체가 멀티파트 업로드 포함함

	let fData = new FormData(frm);
	for (let val of fData.entries()) {
		console.log(val)
	}

	$.ajax({
		url: 'noticeInsertAjax.do',
		method: 'post',
		data: fData,
		dataType: 'json',

		//↓2개 : 멀티파트 사용 시 필요
		processData: false,
		contentType: false,

		success: function (result) {
			console.log(result);
			if (result.retCode == 'Success') {
				ajaxCall(1, $('#perPage').val(), null, null)
			} else {
				alert('[공지등록실패] 오류가 발생하였습니다.');
			}
		},
		error: function (error) {
			console.log(error);
		}
	})
})


// ✅ [메소드 선언]========================================================================

//📌 tr 메소드
function makeTr(obj = {}) {
	let tr = $('<tr />').append(
		$('<td />').text(obj.noticeId),
		$('<td />').text(obj.noticeWriter),
		$('<td />').text(obj.noticeDate),
		$('<td />').text(obj.noticeTitle),
		$('<td />').text(obj.noticeFile),
		$('<td />').text(obj.noticeHit),
		$('<td />').append(
			$('<button />').text('삭제')
			.attr('noticeId', obj.noticeId)
			.on('click', delBtnFnc)),
	)
	return tr;
}

//📌 삭제 메소드
function delBtnFnc(e) {
	e.preventDefault();
	let target = e.currentTarget
	let noticeId = e.currentTarget.getAttribute('noticeId')
	$.ajax({
		url: 'noticeDeleteAjax.do?noticeId=' + noticeId,
		dataType: 'json',
		success: function (result) {
			console.log(result);
			if (result.retCode == "Success") {
				ajaxCall(localStorage.getItem('currentPage'),
					localStorage.getItem('perPage'),
					localStorage.getItem('searchCondition'),
					localStorage.getItem('keyword'))

			} else {
				alert('[삭제 실패] 삭제 중 에러가 발생하였습니다.')
				return;
			}
		},
		error: function (error) {
			console.log(error);
		}
	})
}

// 📌 페이지 이동 메소드(이벤트)
function pageChangeFnc(e) {
	// console.log(e);
	e.preventDefault(); //aTag의 href 기능 차단
	// console.log(e.currentTarget.innerText)

	let page = e.currentTarget.getAttribute('page');
	let amount = e.currentTarget.getAttribute('amount');
	let searchCondition = e.currentTarget.getAttribute('searchCondition');
	let keyword = e.currentTarget.getAttribute('keyword');

	ajaxCall(page, amount, searchCondition, keyword);

}

//📌 아작스 관련 메소드
function ajaxCall(page, amount, searchCondition, keyword) {
	// console.log(page, amount, searchCondition, keyword)
	//📍1) tbody 
	$.ajax({
		url: 'noticePagingAjax.do?page=' + page +
			'&amount=' + amount +
			'&searchCondition=' + searchCondition +
			'&keyword=' + keyword,

		dataType: 'json',

		success: function (data) {
			// console.log(data);
			$('#list tr').remove();

			for (let i = 0; i < data.length; i++) {
				$('#list').append(makeTr(data[i]));
			}

			if ($('#list tr').length == 0) {
				ajaxCall(localStorage.getItem('currentPage') - 1, amount, searchCondition, keyword);
			}
		},
		error: function (err) {
			console.log(err)
		}
	})

	//📍2) pageDTO 생성
	$.ajax({
		url: 'noticePageDTO.do?page=' + page +
			'&amount=' + amount +
			'&searchCondition=' + searchCondition +
			'&keyword=' + keyword,

		dataType: 'json',
		success: function (result) {
			// console.log(result);
			//화면 클리어
			$('.pagination a').remove();

			let start = result.startPage;
			let end = result.endPage;
			let curr = result.currPage;

			// 이전페이지
			if (result.prev) {
				//처음
				$('.pagination').append($('<a href=""/>')
					.text('처음')
					.attr('page', 1)
					.attr('amount', amount)
					.attr('searchCondition', searchCondition)
					.attr('keyword', keyword)

					.on('click', pageChangeFnc))
				$('.pagination').append($('<a href=""/>')
					.html('&laquo;')
					.attr('page', start - 1)
					.attr('amount', amount)
					.attr('searchCondition', searchCondition)
					.attr('keyword', keyword)

					.on('click', pageChangeFnc))
			}

			//start ~ end 페이지들
			for (let p = start; p <= end; p++) {
				let aTag = $('<a href="noticePagingAjax.do"/>')
					.text(p)
					.attr('page', p)
					.attr('amount', amount)
					.attr('searchCondition', searchCondition)
					.attr('keyword', keyword)
				aTag.on('click', pageChangeFnc)

				if (p == curr) {
					aTag.addClass('active');
					localStorage.setItem('currentPage', curr);
					localStorage.setItem('searchCondition', $('#searchCondition').val());
					localStorage.setItem('keyword', $('#keyword').val());
					localStorage.setItem('perPage', $('#perPage').val());

					//localStorage : 현재 페이지에서 가지고 있는 정보
				}
				$('.pagination')
					.append(aTag);
			}

			//이후페이지
			if (result.next) {
				$('.pagination').append($('<a href=""/>')
					.html('&raquo;')
					.attr('page', end + 1)
					.attr('amount', amount)
					.attr('searchCondition', searchCondition)
					.attr('keyword', keyword)
					.on('click', pageChangeFnc))

				//마지막
				$('.pagination').append($('<a href=""/>')
					.text('마지막')
					.attr('page', Math.ceil(result.total / amount))
					.attr('amount', amount)
					.attr('searchCondition', searchCondition)
					.attr('keyword', keyword)
					.on('click', pageChangeFnc))
			}
		},
		error: function (err) {
			console.log(err)
		}
	})
}