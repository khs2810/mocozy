function submitCharge(type){
    console.log(type);
    if (type === 'cash'){
        $('#charge_form').submit();
    } else if (type === 'kakao') {
        $('#charge_form').attr('action', 'kakaopay.pt');
        $('#charge_form').submit();
    }
}