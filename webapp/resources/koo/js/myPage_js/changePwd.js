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
