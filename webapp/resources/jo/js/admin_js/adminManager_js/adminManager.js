/* 삭제 모달창 띄우기 */
$(document).ready(function(){
    $("#deleteBtn").click(function(){
      $(".deleteModal").modal('show');
    });

  /* 시작 모달창 띄우기 */
  $("#startBtn").click(function(){
    $(".startModal").modal('show');
  });
});