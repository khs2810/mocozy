// 스크롤 이벤트 감지
let urlParams = new URLSearchParams(window.location.search);
let cpage = 2;
let key = urlParams.get('key');

window.onscroll = function() {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        // 페이지의 끝에 도달하면 AJAX 요청을 보냅니다.
        cateViewAjax();
    }
};

function drawClublist(list){    
    for(let club of list) {
        const div = document.createElement("div");
        div.className = "contentcard";
        let str = "";
        str = `
        <div class="socialing">
            <a class="cardlink" href="detail.cl?cno=${club.clubNo}">
                <img class="img" src="${club.thumbnailImg}" />
                <div class="info">
                    <div class="subject">
                        <div class="tag">${club.clubType}</div>
                        <div class="tagone">${club.categoryName1}</div>
                        <div class="tagtwo">${club.categoryName2}</div>
                    </div>
                    <div class="infotitle">${club.clubTitle}</div>
                    <div class="describe">
                        <svg class="image" xmlns="http://www.w3.org/2000/svg" width="10" height="10" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
                        </svg>
                        ${club.address} · ${club.eventDate}
                    </div>
                    <div class="participant">`;
            if(club.profileImg && club.profileImg.length > 0){
                        str += `<img class="people" src="${club.profileImg[0]}" />`;
                    }
                        str += `<div class="profileimglist">`;
            if(club.profileImg && club.profileImg.length >= 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }
                }

            if(club.profileImg && club.profileImg.length > 1 && club.profileImg.length < 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }  
                }
            str += `</div>
                        <div class="socialmember">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
								<path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
								<path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
							</svg>
							<div class="count">${formatDate(club.createDate)}</div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>`;
        document.querySelector(".display").appendChild(div).innerHTML += str;
    }
}

function cateViewAjax() {
    $.ajax({
        url: "cateViewAjax.ct",
        data: {cpage: cpage++, key: key},
        success: function(list) {
            console.log(list);

        drawClublist(list);    
            // 서버에서 반환된 데이터를 사용하여 새로운 'contentcard'를 생성하고 페이지에 추가.      
            console.log("AJAX 요청 성공");
        },
        error: function() {
            console.log("AJAX 요청 실패");
        }
    });
}

function catePickAjax() {
    $.ajax({
        url: "catePickAjax.ct",
        data: {cpage: cpage++, key: key},
        success: function(list) {
            console.log(list);

        drawClublist(list);    
            // 서버에서 반환된 데이터를 사용하여 새로운 'contentcard'를 생성하고 페이지에 추가.      
            console.log("AJAX 요청 성공");
        },
        error: function() {
            console.log("AJAX 요청 실패");
        }
    });
}

function cateRecentAjax() {
    $.ajax({
        url: "cateRecentAjax.ct",
        data: {cpage: cpage++, key: key},
        success: function(list) {
            console.log(list);

        drawClublist(list);    
            // 서버에서 반환된 데이터를 사용하여 새로운 'contentcard'를 생성하고 페이지에 추가.      
            console.log("AJAX 요청 성공");
        },
        error: function() {
            console.log("AJAX 요청 실패");
        }
    });
}

$(document).ready(function() {
    const urlParams = new URLSearchParams(window.location.search);
    const key = urlParams.get('key');

    if (key === '소셜링') {
        $('#cateRecent').addClass('highlight');
    } else if (key === '챌린지'){
        $('#cateDibs').addClass('highlight');
    } 
});

//정규식을 사용한 날짜 변환
function formatDate(dateString) {
    // (5월 23일, 2024) to YYYY-MM-DD format
    const regex = /(\d+)월 (\d+)일, (\d+)/;
    const match = regex.exec(dateString);
    if (match) {
        const year = match[3];
        const month = match[1].length === 1 ? '0' + match[1] : match[1]; // 월이 한 자리수일 경우 앞에 0을 붙임
        const day = match[2].length === 1 ? '0' + match[2] : match[2]; // 일이 한 자리수일 경우 앞에 0을 붙임
        const formattedDate = `${year}-${month}-${day}`;
        console.log("날짜 변환 = " + formattedDate);
        return formattedDate;
    }
    console.error("올바르지 않은 날짜 형식: " + dateString);
    throw new Error("올바르지 않은 날짜 형식: " + dateString);
}