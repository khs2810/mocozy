// 스크롤 이벤트 감지
let rpage = 2;
let keyword = new URLSearchParams(window.location.search).get('keyword');


window.onscroll = function() {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        // 페이지의 끝에 도달하면 AJAX 요청을 보냅니다.
        searchFormAjax();
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

            str += `</div>`;
        document.querySelector(".display").appendChild(div).innerHTML += str;
    }
}

function searchFormAjax() {
    $.ajax({
        url: "searchFormAjax.sc",
        data: {rpage: rpage++, keyword: keyword},
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

function searchPickAjax() {
    $.ajax({
        url: "searchPickAjax.sc",
        data: {rpage: rpage++, keyword: keyword},
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

function searchViewAjax() {
    $.ajax({
        url: "searchViewAjax.sc",
        data: {rpage: rpage++, keyword: keyword},
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

