$(document).ready(function(){
    $('#notice_search_btn').click(function(){
        const keywordType = $('#keyword_type').val();
        const keyword = $('#search_keyword').val();
        
        data = {
            keywordType : keywordType,
            keyword : keyword
        }
        ajaxSearchNotice(data, function(res){
            if (res === "NNN") {
                drawNoticeEmpty();
            } else {
                drawNoticeList(res.list);
                drawNoticePi(res.pi, data);
            }
        });
    })

    const searchButton = document.getElementById("notice_search_btn");
    const searchInput = document.getElementById("search_keyword");

    searchInput.addEventListener("keyup", function(event) {
        if (event.keyCode === 13) {
        event.preventDefault();
        searchButton.click();
        }
    });
})

function ajaxSearchNotice(data, callback){
    $.ajax({
        url: 'search.no',
        data : data,
        success: function(res){
            callback(res);
        },
        error: function(){
            console.log("댓글요청 ajax 실패")
        }
    })
}

function drawNoticeList(data) {
    let str = "";
    for(let n of data) {
        str += `<tr>\n` 
               + `<td>${n.noticeNo}</td>\n`
               + `<td class="notice_title" ><p onclick="location.href = 'detail.no?nno=${n.noticeNo}'">[${n.noticeType}] ${n.noticeTitle} (${n.replys})</p></td>`
               + `<td>${n.count}</td>`
               + `<td>${n.nickname}</td>`
               + `<td>${n.modifyDate}</td>`
               + `</tr>`;
    }
    document.querySelector('#notice_list_table>tbody').innerHTML = str;
}

function drawNoticePi(pData, keyData) {
    const keyDataStr = JSON.stringify(keyData);
    let str = "";
    if (pData.currentPage != 1) {
        str += `<button class="page_btn" onclick='ajaxSearchNoticeKey(`
        str += keyDataStr 
        str += `, `
        str += pData.currentPage - 1
        str += `)'><i class="fa-solid fa-angle-left"></i></button>`;
    }
    
    for (let p = pData.startPage; p <= pData.endPage; p++){
        if (p == pData.currentPage) {
            str += `<div class="notice_cpage">${p}</div>\n`;
        } else {
            str += `<button class="page_btn" onclick='ajaxSearchNoticeKey(${keyDataStr}, ${p})'>${p}</button>\n`;
        }
    }
    if (pData.currentPage != pData.maxPage) {
        str += `<button class="page_btn" onclick='ajaxSearchNoticeKey(`
        str += keyDataStr 
        str += `, `
        str += pData.currentPage + 1
        str += `)'><i class="fa-solid fa-angle-right"></i></button>`;
    }
    document.querySelector('.paging_bar').innerHTML = str;
}

function ajaxSearchNoticeKey(keyData, cpage){
    const data = {
        keywordType : keyData.keywordType,
        keyword : keyData.keyword,
        cpage : cpage
    }
    $.ajax({
        url: 'search.no',
        data : data,
        success: function(res){
            drawNoticeList(res.list);
            drawNoticePi(res.pi, data);
        },
        error: function(){
            console.log("댓글요청 ajax 실패")
        }
    })
}

function drawNoticeEmpty() {
    const str = `<tr>` 
                + `<td class="notice_title" colspan="5"><p>조건에 맞는 데이터가 없습니다.</p></td>`
                + `</tr>`;
    document.querySelector('#notice_list_table>tbody').innerHTML = str;
    document.querySelector('.paging_bar').innerHTML = "";
}