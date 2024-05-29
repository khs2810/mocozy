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

// 비밀번호 변경
$(document).ready(function(){
    $("#changePasswordButton").click(function(){
        const formData = $("#changePasswordForm").serialize();
        
        // AJAX 요청을 통해 비밀번호 변경
        $.ajax({
            url: "updatePassword",
            type: "POST",
            data: formData,
            success: function(response) {
                if (response.success) {
                    alert("비밀번호가 성공적으로 변경되었습니다. 다시 로그인해주세요.");
                    $('#myModal').modal('hide');
                    logout(); // 비밀번호 변경 후 로그아웃 실행
                    
                } else {
                    alert(response.message);
                }
            },
            error: function() {
                alert("비밀번호 변경 중 오류가 발생했습니다.");
            }
            
        });
    });
});

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