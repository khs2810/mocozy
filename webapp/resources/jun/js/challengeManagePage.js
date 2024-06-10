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

    // 날짜 기본값 오늘로 설정
    const today = new Date().toISOString().substring(0,10);
    $('#challengeDate').attr('max', today); // 오늘날짜까지만 선택되도록 제한

    // 날짜 선택 시 form 제출
    document.getElementById('challengeDate').addEventListener('change', function() {
        document.getElementById('challenge-form').submit();
    });
    
    // document.querySelector('.saveBtn').addEventListener('click', function() {
    //     const challengeDate = document.getElementById('challengeDate').value;
    //     const memberStatus = {};
    
    //     document.querySelectorAll('.member').forEach(member => {
    //         const userId = member.dataset.userId;
    //         const status = member.querySelector('.status-done').classList.contains('selected') ? 'done' : 'undone';
    //         memberStatus[userId] = status;
    //     });
    
    //     $.ajax({
    //         url: 'saveChallenge.me',
    //         method: 'POST',
    //         contentType: 'application/json',
    //         data: JSON.stringify({ challengeDate: challengeDate, memberStatus: memberStatus }),
    //         success: function(response) {
    //             if (response.status === 'success') {
    //                 alert('저장되었습니다.');
    //             } else {
    //                 alert('저장에 실패했습니다.');
    //             }
    //         },
    //         error: function() {
    //             alert('저장 중 오류가 발생했습니다.');
    //         }
    //     });
    // });
});