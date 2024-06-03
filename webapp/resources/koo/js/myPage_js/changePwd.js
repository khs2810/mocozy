//기존 비밀번호 체크
function checkPwd() {
    const checkPwd1 = document.getElementById('checkPwd1').value;
    const currentPwd = document.getElementById('currentPwd').value;
    const pwdReview1 = document.getElementById('pwd_review1');

    if (checkPwd1 === currentPwd) {
        pwdReview1.textContent = '비밀번호가 일치합니다.';
        pwdReview1.className = 'pass';
        return true;
    } else {
        pwdReview1.textContent = '비밀번호가 일치하지 않습니다.';
        pwdReview1.className = 'none_pass';
        return false;
    }
}

// 비밀번호 체크
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

//비밀번호 변경
function change_pass(){

    // DB
    const formData = $("#changePasswordForm").serialize();
    
    $.ajax({
        url: "checkPassword.me",
        type: "POST",
        // contentType: 'application/json',
        data: formData,
        
        success: function(response) {
            console.log("AJAX success: ", response);
            // DB 정상
            if (response === 'NNNNY') {
                // 팝업을 닫고 로그아웃
                pwdReview.textContent = '';
                submitBtn.disabled = false;
                console.log(alertMsg);
                alert("새 비밀번호로 다시 로그인 해주세요.");
            } else { // 업데이트 실패(alert메세지)
                // 팝업에 실패 내용 표시
                alert("입력 내용에 오류가 있습니다.");
                console.log(errorMsg);
                pwdReview.textContent = '잘못된 비밀번호 입니다.';
                pwdReview.className = 'none_pass';
            }
            
        },
        error: function(xhr, status, error) {
            console.error("AJAX error: ", status, error);
            alert("비밀번호 확인 중에 오류가 발생했습니다.");
        }
    })
};


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




// 세션 삭제 후 로그아웃 페이지로 리다이렉트
function logout() {
    
    $.ajax({
        url: "/logout",
        type: "POST",
        success: function(response) {
            // 세션 삭제 성공 시 로그아웃 페이지로 리다이렉트
            window.location.href = "logout.me"; // 로그아웃 페이지의 URL로 변경해주세요.
        },
        error: function() {
            // 오류 발생 시 알림 표시
            alert("로그아웃 중 오류가 발생했습니다.");
        }
    });
}