/* 노출 모달창 띄우기 */
$(document).ready(function(){
    $("#noticeBtn").click(function(){
      $(".noticeModal").modal('show');
    });

  /* 삭제 모달창 띄우기 */
  $("#deleteBtn").click(function(){
    $(".deleteModal").modal('show');
  });
});