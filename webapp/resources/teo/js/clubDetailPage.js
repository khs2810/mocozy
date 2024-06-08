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
    const pick = $('.club_picked')
    pick.empty();
    if (res === 'YYY') {
        pick.append('<i class="fa-solid fa-heart" style="color: red;"></i>');
        
    } else {
        pick.append('<i class="fa-regular fa-heart" style="color: red;"></i>');
    }
    $('.club_picked > i').on("click", function(ev){
        clickedPicked(ev)
    })
}

function clickedPicked(ev){
    
    const cno = ev.target.closest('.club_picked').dataset.cno;
    const uno = ev.target.closest('.club_picked').dataset.uno;
    if (uno){
        const data = {
            clubNo : cno,
            userNo : uno
        }
        updateAjaxPicked(data, function(res){
            drawPickedHeart(res);
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

function deleteClub(cno){
    const conf = confirm("정말 클럽을 삭제하시겠습니까?");
    if (conf) {
    	console.log(cno);
    } else {
    	alert("클럽 삭제를 취소했습니다.")
    }
}

function joinClub(cno){
    const isTrue = $('#join_club_btn').val() ? true : false;
    if (isTrue) {
        location.href='confirm.cl?cno=' + cno;
    } else {
        alert("로그인 후 이용가능한 기능입니다.")
    }
    
}

function showMoreMembers() {
    let members = document.querySelectorAll('#hidden_club_members')
    for (let i = 0; i < members.length; i++) {
        members[i].style.display = 'flex';
    }
    document.querySelector('.club_more_member').style.display = 'none';
}


        
function modalMap(address) {
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

        // 지도를 생성합니다    
        var map = new kakao.maps.Map(mapContainer, mapOption); 

        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();

        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(address, function(result, status) {
            // 정상적으로 검색이 완료됐으면 
            if (status === kakao.maps.services.Status.OK) {
                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                // 결과값으로 받은 위치를 마커로 표시합니다
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });
                map.setCenter(coords);
            } 
        })
    setTimeout(function(){ map.relayout(); }, 100);  
}

function finishClub(cno){

    const type = $('#join_club_btn').val();

    if (type === '소셜링'){
        if (confirm('정말 소셜링을 종료하시겠습니까?')) {
            location.href='finishSocial.me=' + cno;
        } else {
            alert("클럽 종료 취소")
        }
    } else {
        if (confirm('정말 챌린지를 종료하시겠습니까?')) {
            //챌린지 취소 주소로 변경
            location.href='' + cno; 
        } else {
            alert("클럽 종료 취소")
        }
    }

    
    
}