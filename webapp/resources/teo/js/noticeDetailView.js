

function confirmDelete(data) {
    const result = confirm("정말 공지사항을 삭제 하시겠습니까?");
    const url = "delete.no?nno=" + data;
    if (result) {
        location.href = url;
    }
}




// function insertNoticeReply(cno, uno) {
//     const replyContent = document.querySelector('textarea[name="reply_content"]');
//     console.log(replyContent);
    
//     if (!uno){
//         alert("로그인 후 이용가능한 기능입니다.")
//     } else {
//         const data = {
//             clubNo: cno,
//             userNo: uno
//         }
//         console.log(data)
//         ajaxInsertReply(data)
//     }
// }

// function ajaxInsertReply(data) {
//     $.ajax({
//         url : 'insertReply.no',
//         data : data,
//         success : function(res) {
//             console.log(res)
            
//         },
//         error : function (){
//             alert("ajax 실패");
//         }
//     })
// }

$(document).ready(function(){
    $('#enroll_notice_reply').click(function(ev){
        const content = document.querySelector('#reply_content').value;
        const btn = ev.target;
        
        if (!btn.dataset.uno){
            alert("로그인 후 이용가능한 기능입니다.")
        } else {
            const data = {
                noticeNo : btn.dataset.nno,
                userNo : btn.dataset.uno,
                replyContent : content
            }
            ajaxInsertReply(data)
        }
    }) 
})

function ajaxInsertReply(data) {
    $.ajax({
        url : 'insertReply.no',
        data : data,
        success : function(res) {
            drawReplyList(res.rlist, res.rsize);            
        },
        error : function (){
            alert("ajax 실패");
        }
    })
}

function drawReplyList(data, size) {
    
    document.querySelector('#notice_review_size_h').innerHTML = "댓글(" + size + ")";

    let str = "";
    if (data.length == 0){
        str = `<tr>\n
               <td colspan="4" align="center">\n
                     등록된 댓글이 없습니다.\n
               </td>\n
               </tr>\n`
    } else {
        for (const nr of data){
            str += `<tr>\n
                        <td style="padding-left: 5px; width: 105px">${nr.nickname}</td> \n
                        <td style="width: 75%; padding-left: 14px;">${nr.replyContent}</td>\n
                        <td>${nr.modifyDate}</td>\n
                        <td>X</td>\n
                    </tr>`
        }
    }
    document.querySelector('#review_table').innerHTML = str;
}
