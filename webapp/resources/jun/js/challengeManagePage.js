// 마이페이지 메인
$(document).ready(function(){
    // 완료/미완료 버튼 클릭 ui 구현
    const statusBtn = document.querySelectorAll('.status');
    statusBtn.forEach(button => {
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
});

// 날짜 기본값 오늘로 설정
$('#challengeDate').val(new Date().toISOString().substring(0,10));