function checkPass(){
    let userPwd = document.getElementById('user_pwd');
    let checkPwd = document.getElementById('check_pwd');
    let pwdReview = document.getElementById('pwd_review');

    if (userPwd.value === checkPwd.value) {
        pwdReview.className = 'pass';
        pwdReview.innerText = '비밀번호가 일치합니다.';
    } else {
        pwdReview.className = 'none_pass';
        pwdReview.innerText = '비밀번호가 다릅니다.';
    }
}