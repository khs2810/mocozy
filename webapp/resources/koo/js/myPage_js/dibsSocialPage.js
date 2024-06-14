function init(data) {
    getAjaxPicked(data, function(res){
        drawPickedHeart(res);
    })
}
// 찜 목록 Ajax 처리.
function getAjaxPicked(data, callback) {
    $.ajax({
        url : 'getPicked.cl',
        data : data,
        type : JSON,
        success : function(res) {
            callback(res);
        },
        error : function (){
            alert("찜 목록 ajax 실패");
        }
    })
}
// 찜 하트 색칠하기.
function drawPickedHeart(res) {
    const pick = $('#club_picked')
    pick.empty();
    if (res === 'YYY') {
        pick.append('<i class="fa-solid fa-heart" style="color: red; display: flex; justify-content: flex-end;"></i>');
        
    } else {
        pick.append('<i class="fa-regular fa-heart" style="color: red; display: flex; justify-content: flex-end;"></i>');
    }
}

function clickedPicked(cno, uno){
    console.log('1')
    console.log(cno)
    console.log(uno)

    if (uno){
        const data = {
            clubNo : cno,
            userNo : uno
        }
        updateAjaxPicked(data, function(res){
            drawPickedHeart(res);
            console.log(res)
        });
    } else {
        alert("로그인 후 이용가능한 기능입니다.")
    }
    
}

function updateAjaxPicked(data, callback) {
    $.ajax({
        url : 'updatePicked.cl',
        data : data,
        success : function(res) {
            callback(res);
        },
        error : function (){
            alert("ajax 실패");
        }
    })
}

