let rpage = 1;
//유저가 입력한 정보 (키워드, 정렬)
let url = new URL(window.location.href);
let order = url.searchParams.get('order');
let keyword = url.searchParams.get('keyword');


document.addEventListener('DOMContentLoaded', function () {
        searchFormAjax(keyword, order);
    });

window.onscroll = function () {
    //페이지 사이즈 구하기
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        // 페이지의 끝에 도달하면 AJAX 요청을 보냄.
        searchFormAjax(keyword, order);
    }
};


function drawClublist(clist){    
    let urlParams = new URLSearchParams(window.location.search);
    let order = urlParams.get('order');

    let str = '';
    for (let i = 0; i < clist.length; i++) {
        let club = clist[i];

        // formatDate 함수 호출
        let [formattedEventDate, formattedCreateDate] = formatDate(club.eventDate, club.createDate);
        str += `
        <div class="contentcard">
            <div class="socialing">
                <a class="cardlink" href="detail.cl?cno=${club.clubNo}">
                    <img class="img" src="${club.thumbnailImg}" />
                    <div class="info">
                        <div class="subject">
                            <div class="tag ${'clubType' + club.clubType}">${club.clubType}</div>
                            <div class="tagone">${club.categoryName1}</div>
                            <div class="tagtwo">${club.categoryName2}</div>
                        </div>
                        <div class="infotitle">${club.clubTitle}</div>
                        <div class="describe">
                            <svg class="image" xmlns="http://www.w3.org/2000/svg" width="10" height="10" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                                <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
                            </svg>
                            ${club.address} · ${formattedEventDate}
                        </div>
                        <div class="participant">`;

            if (club.profileImg && club.profileImg.length > 0) {
                str += `<div style="width: 45px, height: 45px">
                            <img class="people" src="${club.profileImg[0]}" />
                        </div>`;
            }

            str += '<div class="profileimglist">';

            if (club.profileImg && club.profileImg.length >= 2) {
                for (let i = 1; i < club.profileImg.length; i++) {
                    str += `<img class="cardImg" src="${club.profileImg[i]}" />`;
                }
            }

            str += `</div>`;
            str += getSocialMemberDiv(club, formattedCreateDate);
            str += `
                            </div>
                        </div>
                    </a>
                </div>
            </div>`;
        }

        function getSocialMemberDiv(club, formattedCreateDate) {
            let countValue;
            if (order === 'pickCount') {
                countValue = club.PickCount;
                svgIcon = `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" style="color: gray;" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
                                    </svg>`;
            } else if (order === 'count') {
                countValue = club.count;
                svgIcon = `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16" style="color: gray">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
                                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
                                    </svg>`;
            } else {
                countValue = formattedCreateDate;
                svgIcon = `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
                                        <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
                                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
                                    </svg>`;
            }
        
            return `<div class="socialmember">
                        ${svgIcon}
                        <div class="count">${countValue}</div>
                    </div>`;
        }

    document.querySelector(".display").innerHTML += str;
}

function searchFormAjax(keyword, order) {
    $.ajax({
        url: "searchFormAjax.sc",
        data: {rpage: rpage++, keyword: keyword, order: order},
        success: function(clist) {
            drawClublist(clist);
        },
        error: function() {
        }
    });
}


$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const order = urlParams.get('order');

    if (order === 'club_no') {
        $('#cateRecent').addClass('highlight');
    } else if (order === 'pickCount') {
        $('#cateDibs').addClass('highlight');
    } else if (order === 'count') {
        $('#cateViews').addClass('highlight');
    }
});

$(document).ready(function () {
    // .leftlistTitle p의 텍스트 값이 없는지 확인
    if (!$('.leftlistTitle p').text().trim()) {
        // 'cname'이 없다면, 해당 클래스와 
        //'cateRanklisticon' 클래스의 CSS를 'color: #fff'으로 설정
        $('.leftlistTitle p, .cateRanklisticon').css('color', '#fff');
    }
});

function formatDate(eventDate, createDate) {
    // Date 객체 생성
    let eventDateObj = new Date(eventDate);
    let createDateObj = new Date(createDate);
    
    // 옵션 설정
    let eventDateOptions = { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric', 
        hour: 'numeric', 
        minute: 'numeric', 
        hour12: true 
    };
    
    let createDateOptions = { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric' 
    };
    
    // 날짜 형식 변경
    let formattedEventDate = eventDateObj.toLocaleDateString('ko-KR', eventDateOptions);
    let formattedCreateDate = createDateObj.toLocaleDateString('en-US', createDateOptions);
    
   // 월을 한국어로 변환
   let monthInKorean = ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"];
   let monthIndex = createDateObj.getMonth();
   formattedCreateDate = formattedCreateDate.replace(/January|February|March|April|May|June|July|August|September|October|November|December/g, monthInKorean[monthIndex]);
   
   return [formattedEventDate, formattedCreateDate];
}

