/* 삭제 모달창 띄우기 */
$(document).ready(function(){
    $("#deleteBtn").click(function(){
      $(".deleteModal").modal('show');
    });
  });

  /* 승인 모달창 띄우기 */
$(document).ready(function(){
  $("#acceptBtn").click(function(){
    $(".acceptModal").modal('show');
  });
});

/* 시작 모달창 띄우기 */
$(document).ready(function(){
  $("#startBtn").click(function(){
    $(".startModal").modal('show');
  });
});