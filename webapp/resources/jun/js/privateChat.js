$(document).ready(function() {
    let targetUserNo = $('#targetNo').val();
    const chno = $('#chno').val();

    console.log(chno);
    const loginUserNum = parseInt($('#loginUserNo').val(), 10); // string에서 number로 형변환
    const socket = new WebSocket("ws://localhost:8890/mocozy/server");
    
    // function getQueryParameter(name) {
    //     // 현재 URL에서 쿼리 스트링 부분만 추출
    //     var urlParams = new URLSearchParams(window.location.search);
    //     // 특정 파라미터 값을 반환
    //     return urlParams.get(name);
    // }

    updateChatWindow(chno);

    socket.onopen = function() {
        console.log("웹소켓 연결 성공...");
    }

    socket.onclose = function() {
        console.log("웹소켓 연결 끊어짐...");
    }

    socket.onerror = function() {
        console.log("웹소켓 연결 실패...");
        alert("웹소켓 연결 실패");
    }

    socket.onmessage = function(ev) {
        const receive = JSON.parse(ev.data);
        // const msgContainer = $("#textArea");

        // msgContainer.innerHTML += (receive.nick + "(" + receive.time + ")<br>" + receive.msg + "<br>")
        console.log(receive)
        
        const message = JSON.parse(ev.data);

        // Date 객체로 변환
        const sendTime = new Date(message.sendTime);

        // 두 자리 숫자로 포맷팅하는 함수
        const padZero = (num) => (num < 10 ? '0' : '') + num;

        // 각 구성 요소 추출
        const year = sendTime.getFullYear();
        const month = padZero(sendTime.getMonth() + 1); // getMonth()는 0부터 시작하므로 1을 더해줌
        const day = padZero(sendTime.getDate());
        const hours = padZero(sendTime.getHours());
        const minutes = padZero(sendTime.getMinutes());

        // 원하는 형식으로 문자열 구성
        const formattedDate = `${year}.${month}.${day} ${hours}:${minutes}`;
        addMessage(message.messageContent, message.senderNo, formattedDate);
    }

    function sendMsg(chno) {
        const msgData = {
            message: $("#textArea").val(),
            target: targetUserNo,
            chatNo: chno,
            userNo: loginUserNum
        }
        console.log(msgData);
        socket.send(JSON.stringify(msgData));
    }

    // // 채팅 리스트 클릭 이벤트 처리
    // $('.chatList').on('click', function() {
    //     // 클릭된 채팅 리스트의 정보 가져오기
    //     targetUserNo = $(this).find('.chatSimple').data("userno");
    //     chno = $(this).find('.chatSimple').data("chattingno");

    //     // 채팅창 업데이트 함수 호출
    //     updateChatWindow(chno);

    //     // 다른 채팅 리스트의 활성화 클래스 제거
    //     $('.chatList').removeClass('active');
    //     // 현재 클릭된 채팅 리스트에 활성화 클래스 추가
    //     $(this).addClass('active');
    // });

    $('#submitBtn').on('click', function() {
        sendMsg(chno);
        const messageText = $('#textArea').val().trim();
        if (messageText !== '') {
            // const now = new Date();
            // const sendTime = `${now.getFullYear()}.${(now.getMonth() + 1).toString().padStart(2, '0')}.${now.getDate()}.${now.getHours().toString().padStart(2, '0')}:${now.getMinutes().toString().padStart(2, '0')}`;
        
            // addMessage(messageText, loginUserNum, sendTime);
            $('#textArea').val('');
        }
    });

    $('#textArea').on('keypress', function(e) {
        if (e.key === 'Enter' && !e.shiftKey) {
            e.preventDefault();
            $('#submitBtn').click();
        }
    });

    function addMessage(text, sender, sendTime, nick) {
        let container = $('<div>').addClass('message-container');

        let times = null;
        if (!sendTime) {
            times = getCurrentTime();
        } else {
            times = sendTime;
        }
        
        const timestamp = $('<span>').addClass('timestamp').text(times);
        const profileImg = $('<img>').addClass('user-profile-img').attr('src', getProfileImage(sender));
        
        if (sender === loginUserNum) {
            container = container.addClass('user');
            const message = $('<div>').addClass('message').addClass('user').text(text);
            const messageWrapper = $('<div>').addClass('message-wrapper').append(message);
            container.append(timestamp).append(messageWrapper);
        } else {
            const message = $('<div>').addClass('message').text(text);
            const nickname = $('<div>').addClass('nickname').text(nick); // 상대의 닉네임을 추가
            const messageWrapper = $('<div>').addClass('message-wrapper').append(nickname).append(message);
            container.append(profileImg).append(messageWrapper).append(timestamp);
        }
    
        $('#chatDetail').append(container);
        $('#chatDetail').scrollTop($('#chatDetail')[0].scrollHeight);
    }
    
    function updateChatWindow(chno) {
        // 채팅창 업데이트 로직
        if (!targetUserNo) {
            return;
        }
        console.log("chno :", chno);

        $.ajax({
            url: 'privateChat.ad/selectMessage',
            method: 'GET',
            data: { chno: chno },
            success: function(response) {
                $('#chatDetail').empty(); // 기존 채팅 내용 비우기
                
                response.forEach(function(message) {
                    var sendTimeMillis = message.sendTime;
                    var sendTime = new Date(sendTimeMillis);
                    var formattedTime = formatDate(sendTime);
                    message.sendTime = formattedTime;
                    addMessage(message.messageContent, message.senderNo, message.sendTime, message.nick);
                });
            },
            error: function(xhr, status, error) {
                console.error("메시지 목록을 가져오는 중 오류 발생:", error);
            }
        });
    }

    function formatDate(date) {
        var year = date.getFullYear();
        var month = ("0" + (date.getMonth() + 1)).slice(-2);
        var day = ("0" + date.getDate()).slice(-2);
        var hours = ("0" + date.getHours()).slice(-2);
        var minutes = ("0" + date.getMinutes()).slice(-2);
        return year + "." + month + "." + day + " " + hours + ":" + minutes;
    }

    function getCurrentTime() {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        return `${hours}:${minutes}`;
    }

    function getProfileImage(sender) {
        let hostIndex = location.href.indexOf( location.host ) + location.host.length;
        let contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
        return contextPath + '/resources/jun/img/프사.jpg'; // 사용자의 프로필 이미지 경로
    }
})