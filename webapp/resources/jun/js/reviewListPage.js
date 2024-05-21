/*
const writeBtns = document.querySelectorAll('.writeBtn');
const detailBtns = document.querySelectorAll('.detailBtn');
const reviewEnrollWindows = document.querySelectorAll('.reviewEnrollWindow');
const reviewDetailWindows = document.querySelectorAll('.reviewDetailWindow');

writeBtns.addEventListener('click', () => {
    reviewEnrollWindows.forEach(writeBtn => {
        writeBtn.classList.add('show');
    });
});
reviewEnrollWindows.forEach(reviewEnrollWindow => {
    const closeBtn = reviewEnrollWindow.querySelector('.closeBtn');
    closeBtn.addEventListener('click', () => {
        reviewEnrollWindow.classList.remove('show');
    });
});

detailBtns.addEventListener('click', () => {
    reviewDetailWindows.forEach(detailBtn => {
        detailBtn.classList.add('show');
    });
});
reviewDetailWindows.forEach(reviewDetailWindow => {
    const closeBtn = reviewDetailWindow.querySelector('.closeBtn');
    closeBtn.addEventListener('click', () => {
        reviewDetailWindow.classList.remove('show');
    });
});
*/

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