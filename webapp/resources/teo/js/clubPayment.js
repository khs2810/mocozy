function confirmPay() {
    if (confirm("정말 이 모임에 가입하시겠습니까?")){
        return true;
    } else {
        return false;
    }
}

function submitCharge(type){
    const v = $('#directAmount').val();
    if (v === ""){
        alert("금액을 입력해주세요!")
    } else {
        if (type === 'cash'){
            $('#charge_form').attr('action', 'chargeInClub.pt');
            $('#charge_form').submit();
        } else if (type === 'kakao') {
            $('#charge_form').attr('action', 'kakaopayInClub.pt');
            $('#charge_form').submit();
        } else if (type === 'naver'){
            alert("구현중");
        }
    }
}