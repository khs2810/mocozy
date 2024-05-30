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

function drawRequest(requestList, url, question) {
    $('.clubRequestList').empty();
    const parent = document.getElementById('clubRequestList');

    for (let request of requestList) {
        const clubRequest = document.createElement('div');
        console.log(request);
        console.log(url);
        clubRequest.id = "clubRequest";
        let str = "";
        str = `<div class="clubRequest-head">
                                    <div class="simpleInfo">
                                        <div class="simpleInfoLeft">
                                            <img src="${url}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                                            <b class="userId">떡꼬치소마왕</b>`;

        if (request.status === 'W') {
            str += `<img src="${url}/resources/jun/img/waiting.png" class="status_w">`
        } else if (request.status === 'Y') {
            str += `<img src="${url}/resources/jun/img/accepted.png" class="status_a">`
        } else {
            str += `<img src="${url}/resources/jun/img/denied.png" class="status_d">`
        }
        str +=  (`</div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">` + request.createDate + `</span>
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