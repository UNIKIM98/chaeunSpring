/**
 * 
 */
console.log('999')
fetch('ajaxQnaList.do')
    .then((result) => result.json())
    .then(function (resultList) {
        makeFAQ(resultList);
    })
    .catch(err => console.log(err))

function makeFAQ(resultList = []) {
    //최상위div
    let accordionDiv = document.getElementById('accordion');

    for (const list of resultList) {
        accordionDiv.append(makeContent(list));
        console.log(list);
    }


}

function makeContent(list) {
    //return할 div
    let cardDiv = document.createElement('div');
    cardDiv.className = 'card';

    //header div
    let cardHeaderDiv = document.createElement('div');
    cardHeaderDiv.className = 'card-header';

    //제목div
    let headerA = document.createElement('a');
    headerA.innerHTML = list.qnaTitle;
    headerA.className = "card-link";
    headerA.setAttribute('data-toggle', 'collapse');
    headerA.href = '#' + list.qnaNum;
    console.log(headerA);

    //▶ append 1
    cardHeaderDiv.append(headerA);

    //body div
    let cardBodyDiv = document.createElement('div');
    cardBodyDiv.className = 'collapse';
    cardBodyDiv.id = list.qnaNum;
    cardBodyDiv.setAttribute('data-parent', '#accordion')

    // 내용div
    let contentDiv = document.createElement('div');
    contentDiv.className = 'card-body';
    contentDiv.innerHTML = list.qnaSubject;

    //▶ append 2
    cardBodyDiv.append(contentDiv);

    //▶ append 3
    cardDiv.append(cardHeaderDiv, cardBodyDiv);
    return cardDiv;
}