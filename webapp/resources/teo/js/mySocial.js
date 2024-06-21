function confirmDeleteRequset(cno) {
    if (confirm("정말 모임을 탈퇴하시겠습니까?")) {
        window.location.href = "quitSocial.me?cno=" + cno;
    }
}

function confirmDeleteRequsetC(cno) {
    if (confirm("정말 모임을 탈퇴하시겠습니까?")) {
        window.location.href = "quitChallenge.me?cno=" + cno;
    }
}