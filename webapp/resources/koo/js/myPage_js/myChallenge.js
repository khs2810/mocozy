$(document).ready(function() {
    $('#optionSelect').change(function() {
        const selectedOption = $(this).val();

        if (selectedOption === '진행중') {
            $('#club-ing').show();
            $('#club-done').hide();
        } else if (selectedOption === '종료됨') {
            $('#club-ing').hide();
            $('#club-done').show();
        }
    })
});

function redirectToChallengeManage(cno) {
    const challengeDate = new Date().toISOString().split('T')[0];
    const url = `http://localhost:8890/mocozy/challengeManage.me?cno=${cno}&challengeDate=${challengeDate}`;
    window.location.href = url;
};

function redirectToChallengeCheck(cno) {
    const challengeDate = new Date().toISOString().split('T')[0];
    const url = `http://localhost:8890/mocozy/challengeCheck.me?cno=${cno}&challengeDate=${challengeDate}`;
    window.location.href = url;
};