// 아이디 체크
function checkId(idInput){
    let idReview = document.getElementById('id_review');
    if (idInput.value === '${m.userId}') {
        idReview.className = "none_pass";
        idReview.innerText = '이미 존재하는 아이디입니다.';
        submitBtn.disabled = true;
    } else {
        idReview.className = "pass";
        idReview.innerText = '사용가능한 아이디입니다.';
        submitBtn.disabled = false;
// 닉네임 체크
document.addEventListener('DOMContentLoaded', function () {
    const nickNameInput = document.getElementById('nickName');
    const nickReview = document.getElementById('nick_Review');
    const submitBtn = document.getElementById('submitBtn');

    nickNameInput.addEventListener('keyup', function () {
        const nickName = nickNameInput.value;
        console.log(nickName);
        
        if(dupliCheckNick(nickName)) {
            nickReview.textContent = '이미 가입된 닉네임입니다.';
            nickReview.className = 'none_pass';
            submitBtn.disabled = false;
        } else {
            nickReview.textContent = '';
            nickReview.className = 'pass';
            submitBtn.disabled = true;
        }
        
    });

    function dupliCheckNick(nickName) {
        // AJAX 요청을 통해 닉네임 중복 확인
        $.ajax({
            url: "nickCheck.me",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            data: { nickName: nickName },
            
            success: function(response) {
                if (response === 'NNNNY') {
                    console.log(response);
                    nickReview.textContent = '가입 가능한 닉네임입니다.';
                    nickReview.className = 'pass';
                    submitBtn.disabled = ture;
                } else {
                    nickReview.textContent = '중복된 닉네임입니다.';
                    nickReview.className = 'none_pass';
                    submitBtn.disabled = false;
                }
            },
            error: function() {
                alert("중복 닉네임 확인 중에 오류가 발생했습니다.");
            }
        });
    }
});


// 입력폼 비밀번호 체크
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
    let nickReview = document.getElementById('nick_review');

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

    } else if(nickReview.classList.contains('none_pass')){
        alert("사용할 수 없는 닉네임입니다");
        let nickInput = document.getElementById('nickName');
        nickInput.focus();
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

            if(dupliCheckId(userId)) {
                idReview.textContent = '이미 가입된 계정입니다.';
                submitBtn.disabled = false;
                
            } else {
                idReview.textContent = '';
                submitBtn.disabled = true;
            }
        } else {
            idReview.textContent = '유효하지 않은 이메일 주소입니다.';
            idReview.className = 'none_pass';
            submitBtn.disabled = false;
        }
    });
    
    
    function validateUserId(userId) {
        // 영문, 숫자만 사용. 이메일형식으로 제한.
        const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        // 이메일형식으로만 제한.
        // const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(userId).toLowerCase());
    }

    function dupliCheckId(user_Id) {
        // AJAX 요청을 통해 이메일 중복 확인
        $.ajax({
            url: "idCheck.me",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            data: { user_Id: user_Id },
            
            success: function(response) {
                if (response === 'NNNNY') {
                    console.log(response);
                    idReview.textContent = '가입 가능한 이메일 주소입니다.';
                    idReview.className = 'pass';
                    submitBtn.disabled = false;
                } else {
                    idReview.textContent = '중복된 이메일 주소입니다.';
                    idReview.className = 'none_pass';
                    submitBtn.disabled = ture;
                }
            },
            error: function() {
                alert("중복 아이디 확인 중에 오류가 발생했습니다.");
            }
        });
    }
});


function validateForm() {
    const userIdValid = document.getElementById('id_review').className === 'pass';
    const userNickValid = document.getElementById('nickReview').className === 'pass';
    const passwordValid = checkPass();
    
    if (userIdValid && passwordValid && userNickValid) {
        return true;
    } else {
        alert('폼을 올바르게 작성해 주세요.');
        return false;
    }
}