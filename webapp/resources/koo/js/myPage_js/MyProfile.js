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
        const currentPassword = $("#currentPassword").val().trim();
        const newPassword = $("#newPassword").val().trim();
        const confirmPassword = $("#confirmPassword").val().trim();

        if (!currentPassword || !newPassword || !confirmPassword) {
            alert("모든 필드를 입력해 주세요.");
            return;
        }

        if (newPassword.length < 8) {
            alert("새 비밀번호는 8자 이상이어야 합니다.");
            return;
        }

        if (newPassword !== confirmPassword) {
            alert("새 비밀번호가 일치하지 않습니다.");
            return;
        }

        // AJAX 요청을 통해 비밀번호 변경
        $.ajax({
            url: "/changePassword",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                currentPassword: currentPassword,
                newPassword: newPassword
            }),
            success: function(response) {
                if (response.success) {
                    alert("비밀번호가 성공적으로 변경되었습니다.");
                    $('#myModal').modal('hide');
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
