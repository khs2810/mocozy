/* 요소를 변수에 할당 */
var accordions = document.querySelectorAll("#menu1, #menu2, #menu3, #menu4, #menu5");
var toggleItems = document.querySelectorAll('.gui1, .gui2, .gui3, .gui4, .gui5');

/* 메뉴 버튼 클릭시 카테고리 토글 */
accordions.forEach(function (accordion, index) {
    accordion.addEventListener('click', function () {
        var display = toggleItems[index].style.display;
        if (display === 'none') {
            toggleItems[index].style.display = 'block';
        } else {
            toggleItems[index].style.display = 'none';
        }
    });

    var Items = document.querySelectorAll("#menubar");

    /* 마우스가 요소 위에서 벗어났을 때 display를 none으로 설정 */
    Items.forEach(function(item) {
        item.addEventListener('mouseleave', function () {
            toggleItems[index].style.display = 'none';
        });
    });
});