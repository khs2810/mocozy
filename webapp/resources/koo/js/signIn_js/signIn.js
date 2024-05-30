// 아이디 체크
function checkId(idInput){
    let idReview = document.getElementById('id_review');
    if (idInput.value === '${m.userId}') {
        idReview.className = "none_pass";
        idReview.innerText = '이미 존재하는 아이디입니다.';
    } else {
        idReview.className = "pass";
        idReview.innerText = '사용가능한 아이디입니다.';
    }
}
//비밀번호 체크
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

//유효성 검사
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
        const userId = userIdInput.value;
        
        if (validateUserId(userId)) {
            //idReview.textContent = '유효한 이메일 주소입니다.';
            //idReview.className = 'pass';

            if(dupliCheck(userId)) {
                idReview.textContent = '이미 가입된 계정입니다.';
                submitBtn.disabled = true;
                
            } else {
                idReview.textContent = '';
                submitBtn.disabled = false;
            }
        } else {
            idReview.textContent = '유효하지 않은 이메일 주소입니다.';
            idReview.className = 'none_pass';
            submitBtn.disabled = true;
        }
    });
    
    
    function validateUserId(userId) {
        // 영문, 숫자만 사용. 이메일형식으로 제한.
        const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        // 이메일형식으로만 제한.
        // const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(userId).toLowerCase());
    }

    function dupliCheck(user_Id, callback) {
        // AJAX 요청을 통해 이메일 중복 확인
        $.ajax({
            url: "idCheck.me",
            type: "POST",
            contentType: 'application/json',
            data: JSON.stringify({ userId: user_Id }),
            
            success: function(response) {
                if (response == 'NNNNY') {
                    console.log(user_Id);
                    idReview.textContent = '';
                    submitBtn.disabled = false;
                } else {
                    callback(false);
                    idReview.textContent = '중복된 이메일 주소입니다.';
                    idReview.className = 'none_pass';
                }
            },
            error: function() {
                alert("중복 아이디 확인 중에 오류가 발생했습니다.");
                callback(false);
            }
        });
    }
});


function validateForm() {
    const userIdValid = document.getElementById('id_review').className === 'pass';
    const passwordValid = checkPass();
    
    if (userIdValid && passwordValid) {
        return true;
    } else {
        alert('폼을 올바르게 작성해 주세요.');
        return false;
    }
}