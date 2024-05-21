// 마이페이지 메인
$(document).ready(function(){
    // 메인 메뉴의 클릭 이벤트 처리
    $('#main_menu > li > a[href=""]').click(function(event){
        event.preventDefault();
        // 클릭한 메뉴의 다음에 오는 .snd_menu를 슬라이드 토글
        $(this).next('.snd_menu').slideToggle('fast');
    });

    // 서브 메뉴의 클릭 이벤트 처리
    $('.snd_menu > li > a').click(function(e){
        e.stopPropagation(); // 부모 요소의 클릭 이벤트 방지
        // 클릭한 서브 메뉴의 다음에 오는 .trd_menu를 슬라이드 토글
        $(this).next('.trd_menu').slideToggle('fast');
    });
});

// 날짜 기본값 오늘로 설정
$('#challengeDate').val(new Date().toISOString().substring(0,10));

// 완료/미완료 버튼 클릭 ui 구현
const status = document.querySelectorAll('.status');
status.forEach(button => {
    const doneBtn = button.querySelector('.status-done');
    const undoneBtn = button.querySelector('.status-undone');

    doneBtn.addEventListener('click', () => {
        doneBtn.classList.add('done-active');
        undoneBtn.classList.remove('undone-active');
    });
    undoneBtn.addEventListener('click', () => {
        undoneBtn.classList.add('undone-active');
        doneBtn.classList.remove('done-active');
    });
});