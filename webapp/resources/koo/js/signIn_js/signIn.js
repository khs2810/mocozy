function checkId(idInput){
    let idReview = document.getElementById('id_review');
    if (idInput.value === 'user01') {
        idReview.className = "none_pass";
        idReview.innerText = '이미 존재하는 아이디입니다.';
    } else {
        idReview.className = "pass";
        idReview.innerText = '사용가능한 아이디입니다.';
    }
}

function checkPass(){
    let userPwd = document.getElementById('userPwd');
    let checkPwd = document.getElementById('checkPwd');
    let pwdReview = document.getElementById('pwd_review');

    if (userPwd.value === checkPwd.value) {
        pwdReview.className = 'pass';
        pwdReview.innerText = '비밀번호가 일치합니다.';
    } else {
        pwdReview.className = 'none_pass';
        pwdReview.innerText = '비밀번호가 다릅니다.';
    }
}  

function validate(){
    let idReview = document.getElementById('id_review');
    let pwdReview = document.getElementById('pwd_review');

    if (idReview.classList.contains('none_pass')){
        alert("사용할 수 없는 아이디입니다");

        let idInput = document.getElementById('userId');
        idInput.focus();
        
        return false;
    } else if(pwdReview.classList.contains('none_pass')){
        alert("비밀번호가 일치하지 않습니다");
        let userPwd = document.getElementById('userPwd');
        userPwd.focus();
        return false;
    }
    
    alert(document.getElementById('userPwd').value + "님 회원가입이 성공적으로 완료되었습니다.^^");
}