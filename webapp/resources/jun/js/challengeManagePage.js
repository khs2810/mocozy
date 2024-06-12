// 마이페이지 메인
$(document).ready(function(){
    // 완료/미완료 버튼 클릭 ui 구현
    const statusBtn = document.querySelectorAll('.status');
    statusBtn.forEach(button => {
        const doneBtn = button.querySelector('.status-done');
        const undoneBtn = button.querySelector('.status-undone');
        // undoneBtn.classList.add('undone-active');   // 초기에 미완료가 선택되어있도록 함
    
        doneBtn.addEventListener('click', () => {
            doneBtn.classList.add('done-active');
            undoneBtn.classList.remove('undone-active');
        });
        undoneBtn.addEventListener('click', () => {
            undoneBtn.classList.add('undone-active');
            doneBtn.classList.remove('done-active');
        });
    });

    // 오늘날짜까지만 선택되도록 제한
    const now_utc = Date.now() // 지금 날짜를 밀리초로
    // getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
    const timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
    // new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
    const today = new Date(now_utc-timeOff).toISOString().split("T")[0];
    $('#challengeDate').attr('max', today);

    // 날짜 선택 시 form 제출
    document.getElementById('challengeDate').addEventListener('change', function() {
        // 이전에 선택된 날짜에 대한 쿼리 문자열을 가져옴
        const currentUrl = window.location.href;
        const baseUrl = currentUrl.split('?')[0]; // '?'를 기준으로 URL을 자름
        const newDate = document.getElementById('challengeDate').value;

        // 기존의 cno 값 유지
        const cnoParam = getUrlParameter('cno');

        // 새로운 URL 생성
        const newUrl = baseUrl + '?cno=' + cnoParam + '&challengeDate=' + newDate;

        // Form 제출
        window.location.href = newUrl; // 페이지를 새로운 URL로 이동
    });

    // URL에서 파라미터 값을 가져오는 함수
    function getUrlParameter(name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
        const results = regex.exec(location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    }
    
    $('.saveBtn').click(function() {
        const userNos = [];
        const dailyStatuses = [];
        const clubNo = $('input[name="cno"]').val();
        const challengeDate = $('input[name="challengeDate"]').val();

        // 사용자 번호와 상태를 배열에 추가
        $('.member').each(function() {
            const userNo = $(this).find('.member-profile').data('userid');
            const dailyStatus = $(this).find('.status button').hasClass('done-active') ? 'Y' : 'N';
            userNos.push(userNo);
            dailyStatuses.push(dailyStatus);
        });

        const challengeData = {
            userNos: userNos,
            dailyStatuses: dailyStatuses,
            cno: clubNo,
            challengeDate: challengeDate
        };

        // AJAX 요청 보내기
        $.ajax({
            type: 'POST',
            url: 'saveChallenge.me',
            contentType: 'application/json', // 데이터 형식을 JSON으로 지정
            data: JSON.stringify(challengeData), // JSON 문자열로 변환하여 전송
            success: function(response) {
                // 요청이 성공한 경우 처리
                console.log(response);
                alert('챌린지 상태 등록 성공');
                window.location.reload(); // 페이지 새로고침
            },
            error: function(xhr, status, error) {
                // 요청이 실패한 경우 처리
                alert('챌린지 상태 등록 실패');
                console.error(xhr.responseText);
            }
        });
    });
});