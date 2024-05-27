$(document).ready(function() {
    // $(".clubRequest-head").click(function(){
    //     const $p = $(this).next();
    
    //     if($p.css("display") === "none") {
    //         $p.slideDown();
    //         const icon = $(this)
    //     } else { //보여지고있는 상태
    //         $p.slideUp();
    //     }
    // })

    $(".reduceBtn").click(function(){
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
    
    $(".acceptBtn").click(function(ev) {
        const btn = ev.target;

        $.ajax({
            url: "accept.re",
            data: {
                    rqno: btn.dataset.rqno,
                    cno: btn.dataset.cno
                },
                success: function(res){
                alert('성공!');
                drawRequest(res);
            },
            error: function(res){
                alert('실패!');
            }
        })
    })

    $(".denyBtn").click(function(ev) {
        const btn = ev.target;
        
        $.ajax({
            url: "deny.re",
            data: {
                    rqno: btn.dataset.rqno,
                    cno: btn.dataset.cno
                },
            success: function(res){
                alert('성공!');
                drawRequest(res);
            },
            error: function(res){
                alert('실패!');
            }
        })
    })
});

document.addEventListener('DOMContentLoaded', function() {
    function drawRequest(data) {
        $('.clubRequestList').empty();
        const contextPath = '<%= request.getContextPath() %>';
        const parent = document.getElementById('clubRequestList');
    
        for (let r of data) {
            // 새로운 clubRequest div 생성
            const clubRequest = document.createElement('div');
            clubRequest.classList.add('clubRequest');
        
            // clubRequest-head div 생성
            const clubRequestHead = document.createElement('div');
            clubRequestHead.classList.add('clubRequest-head');
        
            // simpleInfo div 생성
            const simpleInfo = document.createElement('div');
            simpleInfo.classList.add('simpleInfo');
        
            // simpleInfoLeft div 생성
            const simpleInfoLeft = document.createElement('div');
            simpleInfoLeft.classList.add('simpleInfoLeft');
        
            // profileImg img 생성
            const profileImg = document.createElement('img');
            profileImg.src = `${contextPath}/resources/jun/img/프사.jpg`;
            profileImg.classList.add('profileImg');
            profileImg.dataset.toggle = "modal";
            profileImg.dataset.target = "#profileModal";
            profileImg.style.cursor = "pointer";
        
            // userId b 태그 생성
            const userId = document.createElement('b');
            userId.classList.add('userId');
            userId.textContent = '떡꼬치소마왕';
        
            // status img 생성
            let statusImg = document.createElement('img');
            if (r.status === 'W') {
                statusImg.src = `${contextPath}/resources/jun/img/waiting.png`;
                statusImg.classList.add('status_w');
            } else if (r.status === 'Y') {
                statusImg.src = `${contextPath}/resources/jun/img/accepted.png`;
                statusImg.classList.add('status_a');
            } else if (r.status === 'N') {
                statusImg.src = `${contextPath}/resources/jun/img/denied.png`;
                statusImg.classList.add('status_d');
            }
        
            // simpleInfoRight div 생성
            const simpleInfoRight = document.createElement('div');
            simpleInfoRight.classList.add('simpleInfoRight');
        
            // writeTime span 생성
            const writeTime = document.createElement('span');
            writeTime.classList.add('writeTime');
            writeTime.textContent = r.createDate;
        
            // reduceBtn button 생성
            const reduceBtn = document.createElement('button');
            reduceBtn.classList.add('reduceBtn');
            const chevronIcon = document.createElement('i');
            chevronIcon.classList.add('fa-solid', 'fa-chevron-down');
            reduceBtn.appendChild(chevronIcon);
        
            // simpleInfoRight에 writeTime과 reduceBtn 추가
            simpleInfoRight.appendChild(writeTime);
            simpleInfoRight.appendChild(reduceBtn);
        
            // simpleInfoLeft에 profileImg, userId, statusImg 추가
            simpleInfoLeft.appendChild(profileImg);
            simpleInfoLeft.appendChild(userId);
            simpleInfoLeft.appendChild(statusImg);
        
            // simpleInfo에 simpleInfoLeft와 simpleInfoRight 추가
            simpleInfo.appendChild(simpleInfoLeft);
            simpleInfo.appendChild(simpleInfoRight);
        
            // clubRequestHead에 simpleInfo 추가
            clubRequestHead.appendChild(simpleInfo);
        
            // selectedClubRequest div 생성
            const selectedClubRequest = document.createElement('div');
            selectedClubRequest.classList.add('selectedClubRequest');
        
            // detailInfo div 생성
            const detailInfo = document.createElement('div');
            detailInfo.classList.add('detailInfo');
        
            // detail pre 생성
            const detail = document.createElement('pre');
            detail.classList.add('detail');
            detail.innerHTML = `[질문] ${r.question}<br><br>[대답] ${r.answer}`;
        
            // hidden input 생성
            const hiddenInput = document.createElement('input');
            hiddenInput.type = 'text';
            hiddenInput.value = r.clubNo;
            hiddenInput.hidden = true;
        
            // btns div 생성
            const btns = document.createElement('div');
            btns.classList.add('btns');
        
            // 조건에 따라 버튼 생성 및 추가
            if (r.status === 'W') {
                const denyBtn = document.createElement('button');
                denyBtn.type = 'button';
                denyBtn.classList.add('denyBtn');
                denyBtn.dataset.rqno = r.requestNo;
                denyBtn.dataset.cno = r.clubNo;
                denyBtn.textContent = '거절';
        
                const acceptBtn = document.createElement('button');
                acceptBtn.type = 'button';
                acceptBtn.classList.add('acceptBtn');
                acceptBtn.dataset.rqno = r.requestNo;
                acceptBtn.dataset.cno = r.clubNo;
                acceptBtn.textContent = '수락';
        
                btns.appendChild(denyBtn);
                btns.appendChild(acceptBtn);
            } else if (r.status === 'Y') {
                const acceptedBtn = document.createElement('button');
                acceptedBtn.type = 'button';
                acceptedBtn.classList.add('acceptedBtn');
                acceptedBtn.textContent = '수락됨';
        
                btns.appendChild(acceptedBtn);
            } else if (r.status === 'N') {
                const deniedBtn = document.createElement('button');
                deniedBtn.type = 'button';
                deniedBtn.classList.add('deniedBtn');
                deniedBtn.textContent = '거절됨';
        
                btns.appendChild(deniedBtn);
            }
        
            // detailInfo에 detail, hiddenInput, btns 추가
            detailInfo.appendChild(detail);
            detailInfo.appendChild(hiddenInput);
            detailInfo.appendChild(btns);
        
            // selectedClubRequest에 detailInfo 추가
            selectedClubRequest.appendChild(detailInfo);
        
            // clubRequest에 clubRequestHead와 selectedClubRequest 추가
            clubRequest.appendChild(clubRequestHead);
            clubRequest.appendChild(selectedClubRequest);
        
            // 최종적으로 부모 요소에 clubRequest 추가
            parent.appendChild(clubRequest);
        }
    }
})

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