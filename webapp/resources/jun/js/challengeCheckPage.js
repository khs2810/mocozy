// 마이페이지 메인
$(document).ready(function(){
    // 완료/미완료 버튼 클릭 ui 구현
    const statusBtn = document.querySelectorAll('.status');
    statusBtn.forEach(button => {
        const doneBtn = button.querySelector('.status-done');
        const undoneBtn = button.querySelector('.status-undone');
    
        // doneBtn.addEventListener('click', () => {
        //     doneBtn.classList.add('done-active');
        //     undoneBtn.classList.remove('undone-active');
        // });
        // undoneBtn.addEventListener('click', () => {
        //     undoneBtn.classList.add('undone-active');
        //     doneBtn.classList.remove('done-active');
        // });
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
});