/**
 * noticeAjaxFetch.js
 */



document.addEventListener('DOMContentLoaded', function() {
	//✅ 등록 버튼에 이벤트 달기 (form에 submit이벤트가 발생하면 js에서 처리할 수 있게 하고싶음! 그러려면 submit의 기존 기능을 차단해줘야함(함수 안에서 차단하면 됨))
	document.querySelector('form[name=noticeInsertFrm]').addEventListener('submit', InsertNotice);
})


// 공지 리스트 출력
fetch('noticeList.do')
.then((result) => result.json())
.then((result => {
	console.log(result)

    const noticeList = document.getElementById('show');

    showList(result, noticeList);
}))
.catch(function(err) { 
	console.log(err);
}) 


// 화면에 보여줄 항목들
const showFields = {
    noticeNum: "번호",
    noticeTitle: "제목",
    noticeWriter: "작성자",
    noticeDate: "작성일자",
    noticeHit: "조회수"
}


// 버튼, 체크박스 추가할때 사용
const addColumn = {
	col1: ['button', '삭제'],
	col2: ['button', '수정'],
	col3: ['input', 'checkbox']
}


// 공지글 리스트 화면에 출력하기
function showList(aryData, noticeList) {
    
	console.log(aryData)
    // let fields = showFields;

    for(const data of aryData) {
        let tr = makeTr(data);
        
        noticeList.append(tr)

        console.log(tr)
    }
}



// tr 만드는 함수
function makeTr(data) {
    let tr = document.createElement('tr');
    
    // 하나의 tr에 정보를 가진 td들을 반복문으로 붙여주기
    for(const field in showFields) {
        let td = document.createElement('td');
        td.innerText = data[field];
        tr.append(td);
    }
    console.log(tr)


    tr.setAttribute('id', 'notice_' + tr.firstChild.innerText)

    return tr; // 만든 tr 함수를 호출한 영역으로 돌려주기
}



// 공지사항 등록 함수
// 아니 이거............. ajax 쓰면 안되는거같음.......미친!!!!!!
function InsertNotice(e) {
    e.preventDefault();
    
    console.log('submit');

    let writer = document.getElementById('noticeWriter').value;
    let title = document.getElementById('noticeTitle').value;
    let subject = document.getElementById('noticeSubject').p.innerText;

    if(!title) { // title에 값이 없으면
		alert('값을 입력해주세요')
		return;
	}

    fetch('noticeInsert.do', {
        method: 'post',
        body: formData
    })
    .then(result => result.json())
    .then(result => {
        let tr = makeTr(result);
        document.query
    })
    
}




// Date객체에 yyyymmdd라는 메소드 추가
Date.prototype.yyyymmdd = function() {
    let y = this.getFullYear();
    let m = this.getMonth() + 1; // 월은 0부터 시작함!
    let d = this.getDate();
    // (m 앞에 0을 붙이는데).뒤에서 두자리만 가져오겠다 <- 3월이면 03이지만, 11월이면 011이 될 거니까 뒤에서 두개만 가져와서 11이 되도록 해주는것!
    let ymd = y + '-' + ('0'+m).slice(-2) + '-' + ('0'+d).slice(-2);
    return ymd;
}

let today = new Date(); // 공지사항의 날짜를 오늘 날짜로 지정