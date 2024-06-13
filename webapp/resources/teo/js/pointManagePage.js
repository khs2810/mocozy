function submitCharge(type){
    const v = $('#directAmount').val();
    if (v === ""){
        alert("금액을 입력해주세요!")
    } else {
        
        if (type === 'cash'){
            $('#charge_form').attr('action', 'charge.pt');
            $('#charge_form').submit();
        } else if (type === 'kakao') {
            $('#charge_form').attr('action', 'kakaopay.pt');
            $('#charge_form').submit();
        } else if (type === 'naver'){
            alert("구현중");
        }
        
    }
}