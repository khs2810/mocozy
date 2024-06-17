//클럽 status 변경
$(document).ready(function() {
    $("#startBtn").click(function() {
        if (confirm("정말로 노출시키시겠습니까?")) {
            console.log("confirm returned true"); // confirm 확인
            $.ajax({
                type : "POST",
                url : "changeClubStatus.ma",
                data : {status : 'Y'},
                success : function(response) {
                    alert("성공적으로 처리되었습니다.");
                },
                error : function(xhr, status, error) {
                    console.error("AJAX error:")
                    alert("오류가 발생했습니다.");
                }
            });
        } else {
            console.log("confirm returned false"); // confirm 취소 확인
        }
    });

    $("#deleteBtn").click(function() {
        console.log(1);
        if (confirm("정말로 숨김처리 하시겠습니까?")) {
            console.log("deleteBtn clicked"); // 버튼 클릭 확인
            $.ajax({
                type : "POST",
                url : "changeClubStatus.ma",
                data : {status : 'H'},
                success : function(response) {
                    alert("성공적으로 처리되었습니다.");
                },
                error : function(xhr, status, error) {
                    alert("오류가 발생했습니다.");
                }
            });
        } else {
            console.log("confirm returned false"); // confirm 취소 확인
        }
    });
});