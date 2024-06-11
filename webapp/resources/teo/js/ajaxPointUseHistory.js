$(document).ready(function(){
    $('#month_select_use').on("click", '#month_before_btn_use, #month_after_btn_use', function(ev){
        const btn = ev.target;
        data = {
            month : btn.dataset.month,
            uno : btn.dataset.uno
        }
        
        ajaxPointUseHistory(data, function(res){
            
            const ulist = res.ulist;
            const month = res.month;
            const strMonth = res.strMonth;
            const sumPoint = res.sumPoint;
            const uno = res.userNo;

            drawMonthSelectUse(strMonth, month, uno);
            drawSumPointUse(sumPoint, month);
            drawPointChargeHistoryUse(ulist);
        })
    })

    $('#month_select_withdraw').on("click", '#month_before_btn_withdraw, #month_after_btn_withdraw', function(ev){
        const btn = ev.target;
        data = {
            month : btn.dataset.month,
            uno : btn.dataset.uno
        }
        
        ajaxPointWithdrawHistory(data, function(res){
            
            const wlist = res.wlist;
            const month = res.month;
            const strMonth = res.strMonth;
            const sumPoint = res.sumPoint;
            const uno = res.userNo;

            drawMonthSelectWithdraw(strMonth, month, uno);
            drawSumPointWithdraw(sumPoint, month);
            drawPointChargeHistoryWithdraw(wlist);
        })
    })
})

function ajaxPointUseHistory(data, callback) {
    $.ajax({
        url: 'ajaxPointUseHistory.pt',
        data : data,
        success: function(res){
            callback(res);
        },
        error: function(){
            console.log("ajax 실패")
        }
    })
}

function ajaxPointWithdrawHistory(data, callback) {
    $.ajax({
        url: 'ajaxPointWithdrawHistory.pt',
        data : data,
        success: function(res){
            callback(res);
        },
        error: function(){
            console.log("ajax 실패")
        }
    })
}


function drawMonthSelectUse(strMonth, month, uno) {

    str = "";
    if (month === 1) {
        str += '<div><b style="cursor: default;">&lt;</b></div>';
    } else {
        str += `<button id="month_before_btn_use" type="button" data-month="${month - 1}" data-uno="${uno}">&lt;</button>`;
    }
    str += `<span style="padding: 0 20px; margin-bottom: 7px;">${strMonth}</span>`;
    if (month === 12) {
        str += `<div><b style="cursor: default;">&gt;</b></div>`; 
    } else {
        str += `<button id="month_after_btn_use" type="button" data-month="${month + 1}" data-uno="${uno}">&gt;</button>`;
    } 
    $('#month_select_use').html(str);
}

function drawSumPointUse(sumPoint, month) {
    $('#total-area-month-use').html(month + '월')
    $('#total-amount-use').html(sumPoint);
}

function drawPointChargeHistoryUse(data) {
    let str = "";
    if (data.length === 0) {
        str += `<br><br>
                <h3 align="center">사용 내역이 없습니다.</h3>
                <br><br>`      
    } else {
        for (let p of data) {
            str += `<div class="history-list">\n
                    <div class="history-list-main">\n`;
            str += `<span class="history-detail">`;
            if (p.club_type === '소셜링') {
                str += `<span id="payment_use_social">소셜링</span>`;
            } else {
                str += `<span id="payment_use_challenge">챌린지</span>`;
            }
            str += `${p.club_title}</span>\n`
            str += `<div class="history-point">\n
                        <span id="history-point-num">${p.pointFormat}</span>\n
                        <span>pt</span>\n
                    </div>\n
                    </div>\n
                    <span class="history-date">${p.dateFormat}</span>\n
                    </div>`
        }
    }
    $('.history-list-area-use').html(str);
}

function drawMonthSelectWithdraw(strMonth, month, uno) {

    str = "";
    if (month === 1) {
        str += '<div><b style="cursor: default;">&lt;</b></div>';
    } else {
        str += `<button id="month_before_btn_withdraw" type="button" data-month="${month - 1}" data-uno="${uno}">&lt;</button>`;
    }
    str += `<span style="padding: 0 20px; margin-bottom: 7px;">${strMonth}</span>`;
    if (month === 12) {
        str += `<div><b style="cursor: default;">&gt;</b></div>`; 
    } else {
        str += `<button id="month_after_btn_withdraw" type="button" data-month="${month + 1}" data-uno="${uno}">&gt;</button>`;
    } 
    $('#month_select_withdraw').html(str);
}

function drawSumPointWithdraw(sumPoint, month) {
    $('#total-area-month-withdraw').html(month + '월')
    $('#total-amount-withdraw').html(sumPoint);
}

function drawPointChargeHistoryWithdraw(data) {
    let str = "";
    if (data.length === 0) {
        str += `<br><br>
                <h3 align="center">출금 내역이 없습니다.</h3>
                <br><br>`      
    } else {
        for (let p of data) {
            str += `<div class="history-list">\n
                    <div class="history-list-main">\n
                    <span class="history-detail">포인트 출금</span>
                    <div class="history-point">\n
                        <span id="history-point-num">${p.pointFormat}</span>\n
                        <span>pt</span>\n
                    </div>\n
                    </div>\n
                    <span class="history-date">${p.dateFormat}</span>\n
                    </div>`
        }
    }
    $('.history-list-area-withdraw').html(str);
}
