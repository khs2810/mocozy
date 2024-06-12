$(document).ready(function(){
  // 메인 메뉴의 클릭 이벤트 처리
  $('.main_menu > li > a[href=""]').click(function(event){
      event.preventDefault();
      // 클릭한 메뉴의 다음에 오는 .snd_menu를 슬라이드 토글
      $(this).next('.snd_menu').slideToggle('fast');
  });

  // 서브 메뉴의 클릭 이벤트 처리
  $('.snd_menu > li > a').click(function(e){
      e.stopPropagation(); // 부모 요소의 클릭 이벤트 방지
      // 클릭한 서브 메뉴의 다음에 오는 .trd_menu를 슬라이드 토글
      $(this).next('.trd_menu').slideToggle('fast');
  });
});


/* 마이페이지 프로필영역 안 포인트 */
$(document).ready(function() {
  var moneyValue = $("#money").text();
  var formattedValue = parseFloat(moneyValue).toLocaleString();
  $("#money").text(formattedValue);
});