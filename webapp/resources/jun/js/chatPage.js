$(document).ready(function() {
    let lastMessageDate = null;

    // 채팅 리스트 클릭 이벤트 처리
    $('.chatList').on('click', function() {
        // 클릭된 채팅 리스트의 정보 가져오기
        const profileImgSrc = $(this).find('.profileImg').attr('src');
        const chatTitle = $(this).find('.chatTitle').text();
        const chatContent = $(this).find('.chatContent').text();

        // 채팅창 업데이트 함수 호출
        updateChatWindow(profileImgSrc, chatTitle, chatContent);

        // 다른 채팅 리스트의 활성화 클래스 제거
        $('.chatList').removeClass('active');
        // 현재 클릭된 채팅 리스트에 활성화 클래스 추가
        $(this).addClass('active');
    });

    $('#submitBtn').on('click', function() {
        const messageText = $('#textArea').val().trim();
        if (messageText !== '') {
            addMessage(messageText, 'user');
            $('#textArea').val('');
            simulatePartnerResponse();

            // 현재 날짜 가져오기
            const currentDate = getCurrentDate();

            // 날짜가 변경되었는지 확인 후 날짜 표시 추가
            if (!lastMessageDate || lastMessageDate !== currentDate) {
                addDateSeparator(currentDate);
                lastMessageDate = currentDate;
            }
        }
    });

    $('#textArea').on('keypress', function(e) {
        if (e.key === 'Enter' && !e.shiftKey) {
            e.preventDefault();
            $('#submitBtn').click();
        }
    });

    function addMessage(text, sender) {
        const container = $('<div>').addClass('message-container').addClass(sender);
        const message = $('<div>').addClass('message').addClass(sender).text(text);
        const timestamp = $('<span>').addClass('timestamp').text(getCurrentTime());
        const profileImg = $('<img>').addClass('user-profile-img').attr('src', getProfileImage(sender));
    
        if (sender === 'user') {
            const messageWrapper = $('<div>').addClass('message-wrapper').append(message);
            container.append(timestamp).append(messageWrapper);
        } else {
            const nickname = $('<div>').addClass('nickname').text('상대 닉네임'); // 상대의 닉네임을 추가
            const messageWrapper = $('<div>').addClass('message-wrapper').append(nickname).append(message);
            container.append(profileImg).append(messageWrapper).append(timestamp);
        }
    
        // 현재 날짜 가져오기
        const currentDate = getCurrentDate();
    
        // 처음으로 보낸 메시지인 경우 날짜 표시 추가
        if (!lastMessageDate || lastMessageDate !== currentDate) {
            addDateSeparator(currentDate);
            lastMessageDate = currentDate;
        }
    
        $('#chatDetail').append(container);
        $('#chatDetail').scrollTop($('#chatDetail')[0].scrollHeight);
    }
    
    function updateChatWindow(profileImgSrc, chatTitle, chatContent) {
        // 채팅창 업데이트 로직
        $('#chatPage').find('.profileImg').attr('src', profileImgSrc);
        $('#chatPage').find('.title').text(chatTitle);
        $('#chatDetail').empty(); // 기존 채팅 내용 비우기 (새로운 채팅으로 초기화)
        addMessage(chatContent, 'partner'); // 새로운 채팅 내용 추가
    }

    function getCurrentTime() {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        return `${hours}:${minutes}`;
    }

    function getCurrentDate() {
        const now = new Date();
        const year = now.getFullYear();
        const month = (now.getMonth() + 1).toString().padStart(2, '0');
        const day = now.getDate().toString().padStart(2, '0');
        return `${year}-${month}-${day}`;
    }

    function addDateSeparator(date) {
        const dateElement = $('<div>').addClass('message-container date-separator');
        const dateText = $('<div>').addClass('message date-separator').text(date);
        $('#chatDetail').append(dateElement.append(dateText));
    }

    function simulatePartnerResponse() {
        const responses = [
            "네, 안녕하세요?",
            "밥은 드셨나요?"
        ];
        const randomResponse = responses[Math.floor(Math.random() * responses.length)];
        setTimeout(function() {
            addMessage(randomResponse, 'partner');
        }, 1000);
    }

    function getProfileImage(sender) {
        let hostIndex = location.href.indexOf( location.host ) + location.host.length;
        let contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
        return contextPath + '/resources/jun/img/프사.jpg'; // 사용자의 프로필 이미지 경로
    }
});