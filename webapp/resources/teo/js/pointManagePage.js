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
            // const userId = document.querySelector('#naver_pay_btn').dataset.id;
            // const userPwd = document.querySelector('#naver_pay_btn').dataset.pwd;
            // const point = document.querySelector('#directAmount').value;

            // const data = {
            //     userId : userId,
            //     userPwd : userPwd,
            //     point : point,
            //     pointType : type
            // }
            
            // ajaxPointChargeNpay(data, function(res){
            //     console.log(res);


            // })

        }
        
    }
}

function ajaxPointChargeNpay(data, callback) { 
    $.ajax({
        url: 'ajaxPointChargeNpay.pt',
        data : data,
        success: function(res){
            callback(res);
        },
        error: function(){
            console.log("ajax 실패")
        }
    })
}