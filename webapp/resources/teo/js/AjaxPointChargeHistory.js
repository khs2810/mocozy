$(document).ready(function(){
    $('.month-select').on("click", '#month_before_btn, #month_after_btn', function(ev){
        const btn = ev.target;
        data = {
            month : btn.dataset.month,
            uno : btn.dataset.uno
        }
        
        ajaxPointChargeHistory(data, function(res){
            
            const plist = res.plist;
            const month = res.month;
            const strMonth = res.strMonth;
            const sumPoint = res.sumPoint;
            const uno = res.userNo;

            drawMonthSelect(strMonth, month, uno);
            drawSumPoint(sumPoint, month);
            drawPointChargeHistory(plist);
        });
    })
})

function ajaxPointChargeHistory(data, callback) {
    $.ajax({
        url: 'ajaxPointChargeHistory.pt',
        data : data,
        success: function(res){
            callback(res);
        },
        error: function(){
            console.log("ajax 실패")
        }
    })
}

function drawMonthSelect(strMonth, month, uno) {
    str = "";
    if (month === 1) {
        str += '<div><b style="cursor: default;">&lt;</b></div>';
    } else {
        str += `<button id="month_before_btn" type="button" data-month="${month - 1}" data-uno="${uno}">&lt;</button>`;
    }
    str += `<span style="padding: 0 20px; margin-bottom: 7px;">${strMonth}</span>`;
    if (month === 12) {
        str += `<div><b style="cursor: default;">&gt;</b></div>`; 
    } else {
        str += `<button id="month_after_btn" type="button" data-month="${month + 1}" data-uno="${uno}">&gt;</button>`;
    } 
    document.querySelector('.month-select').innerHTML = str;
}

function drawSumPoint(sumPoint, month) {
    $('#total-area-month').html(month + '월')
    $('#total-amount').html(sumPoint);
}

function drawPointChargeHistory(data) {
    let str = "";
    if (data.length === 0) {
        str += `<br><br><br><br>
                <h3 align="center">충전 내역이 없습니다.</h3>`      
    } else {
        for (let p of data) {
            str += `<div class="history-list">\n
                    <div class="history-list-main">\n`
            if (p.status === 'D') {
                str += `<span class="history-detail">포인트 충전</span>\n`
            } else {
                str += `<span class="history-detail">챌린지 상금</span>\n`
            }
            str += `<div class="history-point">\n
                        <span id="history-point-num">${p.point}</span>\n
                        <span>pt</span>\n
                    </div>\n
                    </div>\n
                    <span class="history-date">${p.dateFormat}</span>\n
                    </div>`
        }
    }
    $('.history-list-area').html(str);
}