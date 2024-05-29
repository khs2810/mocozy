document.addEventListener('DOMContentLoaded', function(){
  /* 메뉴 토글*/
  const TogglemenuButton = document.querySelector('#cateButton');
  const TogglemenuItems = document.querySelector('#cateToggle');

  /* 메뉴 버튼 클릭시 카테고리 토글*/
  TogglemenuButton.addEventListener('click', function() {
  /* css display 속성 가져오기 */	
  const Toggledisplay = TogglemenuItems.style.display;
    if (Toggledisplay === 'none') {
      TogglemenuItems.style.display = 'block';
    } else {
      TogglemenuItems.style.display = 'none';
    }
  });


  /* 로그인 토글*/
  const ToggleLoginButton = document.querySelector('#userName');
  const ToggleLoginItems = document.querySelector('#LoginToggle');

  ToggleLoginButton.addEventListener('click', function() {
  console.log("1");
  /* css display 속성 가져오기 */
  const ToggleLogindisplay = ToggleLoginItems.style.display;
    if (ToggleLogindisplay === 'none') {
      ToggleLoginItems.style.display = 'block';

      /* 클릭 이벤트시 클릭한 위치를 좌표 설정 */
      ToggleLoginItems.style.position = 'fixed';
      ToggleLoginItems.style.left = event.clientX + 'px';
      ToggleLoginItems.style.top = event.clientY + 'px';
    } else {
      ToggleLoginItems.style.display = 'none';
    }
  });
});