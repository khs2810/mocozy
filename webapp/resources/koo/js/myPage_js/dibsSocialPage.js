function init(data) {
    getAjaxPicked(data, function(res){
        drawPickedHeart(res);
    })
}
    
function getAjaxPicked(data, callback) {
    $.ajax({
        url : 'getPicked.cl',
        data : data,
        success : function(res) {
            callback(res);
        },
        error : function (){
            alert("ajax 실패");
        }
    })
}

function drawPickedHeart(res) {
    pick.empty();
    if (res === 'YYY') {
        pick.append('<i class="fa-solid fa-heart" style="color: red; display: flex; justify-content: flex-end;"></i>');
        
    } else {
        pick.append('<i class="fa-regular fa-heart" style="color: red; display: flex; justify-content: flex-end;"></i>');
    }
    // $('.club_picked > i').on("click", function(ev){
    //     clickedPicked(ev)
    // })
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

