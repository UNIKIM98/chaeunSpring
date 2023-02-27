/**
 * 
 */
//삭제 Ajax
function delAjaxFnc(){
    // console.log(this)
    console.log("연결완")
// let tr = document.getElementsByClassName('tr');
// console.log(tr)
// let td = tr.firstChild;
// console.log(td)
// let productNum = tr.setAttribute('id', 'list_'+ tr.firstChild.innerText);
let productNum =document.getElementById()
console.log(productNum)


fetch('ajaxAdminProductDelete.do',{
    method: 'post',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: 'productNum=' + productNum
})
.then(result => result.json())
.then(result => {
    console.log(result)
})
}

