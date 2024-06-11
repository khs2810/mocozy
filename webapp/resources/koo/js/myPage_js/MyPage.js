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


// 그래프 차트


document.addEventListener('DOMContentLoaded', function () {
const myCt = document.getElementById('myChart');
var monthArr = new Array(); 
var chargeArr = new Array(); 
var amountArr = new Array(); 

    $.ajax({
      url: "chart.po",
      type: "POST",
      dataType: "json",
      async: false,
      success: function(response) {
        //console.log("response::",response);
            
            for (idx in response) {
              monthArr.push(response[idx].month.toString());
              chargeArr.push(response[idx].totalCharge.toString());
              amountArr.push(response[idx].totalAmount.toString());
            }
      },
      error: function(xhr, status, error) {
          console.error("AJAX error: ", status, error);
          alert("차트 호출 중에 오류가 발생했다.");
      }
    });

new Chart(myCt, {
  type: 'line',
  data: {
    labels: monthArr, // x축 데이터
      datasets: [ // 데이터의 속성
        {
          label: '충전 내역', // 축의 제목
          fill: false, // line 형태일 때, 선 안쪽을 채우는지 여부
          data: chargeArr, // dataset 값
          backgroundColor: '#f08a8a', // dataset 배경색
          borderColor: '#f08a8a', // dataset 테두리 색상
          borderWidth: 2, // dataset 테두리 두께
          maxBarThickness: 30 // 최대 bar의 두께 설정
        },
        {
          label: '사용 내역',
          fill: false, // line 형태일 때, 선 안쪽을 채우는지 여부
          data: amountArr,
          backgroundColor: '#00C7E2', // dataset 배경색
          borderColor: '#00C7E2', // dataset 테두리 색상
          borderWidth: 2, // dataset 테두리 두께
          maxBarThickness: 30
        }
      ]}
    })
});