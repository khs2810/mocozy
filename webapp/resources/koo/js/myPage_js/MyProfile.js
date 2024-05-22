// 비번확인
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

// 자기소개 글자수
function counter(){
    var content = document.getElementById('jagisogae').value;
    if (content.length > 50){
        content = content.substring(0,50);
        document.getElementById('jagisogae').value = content;
    }
   
    document.getElementById('count').innerHTML = '('+content.length+'/50)'

};
counter();

