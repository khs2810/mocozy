$(document).ready(function(){
    // 메인 메뉴의 클릭 이벤트 처리
    $('#main_menu > li > a[href=""]').click(function(event){
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

const radioButtons = document.querySelectorAll('input[name="chargeMoney"]');
const directAmountInput = document.getElementById('directAmount');

radioButtons.forEach(radio => {
    radio.addEventListener('change', () => {
        if (document.getElementById('directInput').checked) {
            // directInput이 체크되면 숫자 입력 필드 활성화
            directAmountInput.disabled = false;
        } else {
            // 그렇지 않으면 숫자 입력 필드 비활성화
            directAmountInput.disabled = true;
            document.getElementById('directAmount').value = '';
        }
    });
});

const widthdrawAll = document.getElementById('widthdrawAll');
const pointInput = document.getElementById('point-input');
const remainingPoint = document.getElementById('remaining-point').innerText;

widthdrawAll.addEventListener('change', () => {
    if (widthdrawAll.checked) {
        pointInput.value = remainingPoint;
    } else {
        pointInput.value = '';
    }
});