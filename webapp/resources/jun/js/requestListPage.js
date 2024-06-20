$(document).ready(function() {
    $("#contentBox").on('click', '.reduceBtn', function(){
        const $p = $(this).parent().parent().parent().next();

        if($(this).hasClass("rerotated")) {
            setTimeout(function() {
            }, 500); // 0.5초 지연
            $(this).removeClass("rotated");
            $(this).removeClass("rerotated");
        };

        if($p.css("display") === "none") {
            $p.slideDown();
            $(this).addClass("rotated");
        } else { //보여지고있는 상태
            $p.slideUp();
            $(this).addClass("rerotated");
        }
    })
    
    $("#contentBox").on('click', '.acceptBtn', function(ev) {
        const btn = ev.target;
        const url = btn.dataset.url;
        const question = btn.dataset.question;

        $.ajax({
            url: "accept.re",
            data: {
                    rqno: btn.dataset.rqno,
                    cno: btn.dataset.cno
                },
            success: function(res){
                alert('참가 신청 수락됨!');
                drawRequest(res, url, question);
                addCount();
            },
            error: function(res){
                alert('모임 인원 초과');
            }
        })
    })

    $("#contentBox").on('click', '.denyBtn', function(ev) {
        const btn = ev.target;
        const url = btn.dataset.url;
        const question = btn.dataset.question;
        
        $.ajax({
            url: "deny.re",
            data: {
                    rqno: btn.dataset.rqno,
                    cno: btn.dataset.cno
                },
            success: function(res){
                alert('참가 신청 거절됨!');
                drawRequest(res, url, question);
            },
            error: function(res){
                alert('오류');
            }
        })
    })
});

function addCount() {
    $('.titlePart').empty();
    
    const memberCnt = parseInt($('#memberCnt').val(), 10) + 1;
    const capacity = parseInt($('#capacity').val(), 10);
    const clubTitle = $('#clubTitle').val();

    $('#memberCnt').val(memberCnt);
    let str = `<span class="title">` + clubTitle + `</span>`;

    if (memberCnt === capacity) {
        str += (`<div class="done">모집완료(` + memberCnt + `/` + capacity + `)</div>`);
    } else {
        str += (`<div class="ing">모집중(` + memberCnt + `/` + capacity + `)</div>`);
    }

    $('.titlePart').html(str);
}

function drawRequest(requestList, url, question) {
    $('.clubRequestList').empty();
    const parent = document.getElementById('clubRequestList');

    for (let request of requestList) {
        const clubRequest = document.createElement('div');
        clubRequest.id = "clubRequest";
        let str = "";
        str = `<div class="clubRequest-head">
                                    <div class="simpleInfo">
                                        <div class="simpleInfoLeft">
                                            <img src="/mocozy/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                                            <b class="userId">` + request.nickname + `</b>`;

        if (request.status === 'W') {
            str += `<img src="/mocozy/resources/jun/img/waiting.png" class="status_w">`
        } else if (request.status === 'Y') {
            str += `<img src="/mocozy/resources/jun/img/accepted.png" class="status_a">`
        } else {
            str += `<img src="/mocozy/resources/jun/img/denied.png" class="status_d">`
        }
        str +=  (`</div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">` + formatDate(request.createDate) + `</span>
                            <button class="reduceBtn"><i class="fa-solid fa-chevron-down"></i></button>
                        </div>
                    </div>
                </div>
                <div class="selectedClubRequest">
                    <div class="detailInfo>
                        <div>
                            <pre class="detail">[질문] ` + question + `<br><br>[대답] ` + request.answer + `
                        </div>
                        <input type="text" value="` + request.clubNo + `" hidden>
                        <div class="btns">`);
        if (request.status === 'W') {
            str += `<button type="button" class="denyBtn" data-rqno="` + request.requestNo + `" data-cno="` + request.clubNo + `">거절</button>
            <button type="button" class="acceptBtn" data-rqno="` + request.requestNo + `" data-cno="` + request.clubNo + `">수락</button>`
        } else if (request.status === 'Y') {
            str += `<button type="button" class="acceptedBtn">수락됨</button>`
        } else if (request.status === 'N') {
            str += `<button type="button" class="deniedBtn">거절됨</button>`
        }
        str += `</div>
                    </div>
                </div>`;
        clubRequest.innerHTML = str;
        parent.appendChild(clubRequest);
    }
}

function formatDate(dateStr) {
    // Date 객체로 변환
    const date = new Date(dateStr);

    // 두 자리 숫자로 포맷팅하는 함수
    const padZero = (num) => (num < 10 ? '0' : '') + num;

    // 각 구성 요소 추출
    const year = date.getFullYear();
    const month = padZero(date.getMonth() + 1); // getMonth()는 0부터 시작하므로 1을 더해줌
    const day = padZero(date.getDate());
    const hours = padZero(date.getHours());
    const minutes = padZero(date.getMinutes());

    // 원하는 형식으로 문자열 구성
    const formattedDate = `${year}.${month}.${day} ${hours}:${minutes}`;

    return formattedDate;
}

document.addEventListener("DOMContentLoaded", function() {
    const timeElements = document.querySelectorAll('.writeTime');
    timeElements.forEach(function(element) {
        const timestamp = element.innerText.trim();
        const formattedDate = formatTimestamp(timestamp);
        element.innerText = formattedDate;
    });
})

function formatTimestamp(timestamp) {
    // Create a new Date object from the timestamp string
    const date = new Date(timestamp.replace(' ', 'T').replace('.0', ''));
    
    // Extract year, month, day, hours, and minutes
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // getMonth() is zero-based
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');

    // Format the date and time
    return `${year}.${month}.${day} ${hours}:${minutes}`;
}