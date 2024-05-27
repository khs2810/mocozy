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

function checkPass() {
    const userPwd = document.getElementById('userPwd').value;
    const checkPwd = document.getElementById('checkPwd').value;
    const pwdReview = document.getElementById('pwd_review');

    if (userPwd === checkPwd) {
        pwdReview.textContent = '비밀번호가 일치합니다.';
        pwdReview.className = 'pass';
        return true;
    } else {
        pwdReview.textContent = '비밀번호가 일치하지 않습니다.';
        pwdReview.className = 'none_pass';
        return false;
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

document.addEventListener('DOMContentLoaded', function () {
    const userIdInput = document.getElementById('userId');
    const idReview = document.getElementById('id_review');
    const submitBtn = document.getElementById('submitBtn');

    userIdInput.addEventListener('keyup', function () {
        const email = userIdInput.value;
        if (validateEmail(email)) {
            idReview.textContent = '유효한 이메일 주소입니다.';
            idReview.className = 'pass';
            submitBtn.disabled = false;
        } else {
            idReview.textContent = '유효하지 않은 이메일 주소입니다.';
            idReview.className = 'none_pass';
            submitBtn.disabled = true;
        }
    });

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
});


function validateForm() {
    const emailValid = document.getElementById('id_review').className === 'pass';
    const passwordValid = checkPass();
    
    if (emailValid && passwordValid) {
        return true;
    } else {
        alert('폼을 올바르게 작성해 주세요.');
        return false;
    }
}