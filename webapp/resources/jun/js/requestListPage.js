$(document).ready(function() {
    // $(".clubRequest-head").click(function(){
    //     const $p = $(this).next();
    
    //     if($p.css("display") === "none") {
    //         $p.slideDown();
    //         const icon = $(this)
    //     } else { //보여지고있는 상태
    //         $p.slideUp();
    //     }
    // })

    $(".reduceBtn").click(function(){
        const $p = $(this).parent().parent().parent().next();

        if($(this).hasClass("rerotated")) {
            setTimeout(function() {
            }, 500); // 0.5초 지연
            $(this).removeClass("rotated");
            $(this).removeClass("rerotated");
        };

        if($p.css("display") === "none") {
            $p.slideDown();
            $(this).addClass("rotated");
        } else { //보여지고있는 상태
            $p.slideUp();
            $(this).addClass("rerotated");
        }
    })

    $(".acceptBtn").click(function(ev) {
        // const $p = $(this).parent().parent().parent().parent().parent().parent();

        const btn = ev.target;
        console.log(btn.dataset.club);

        $.ajax({
            url: "accept.re",
            data: {
                    rqno: btn.dataset.rqno,
                    cno: btn.dataset.cno
                },
            success: function(res){
                drawRequest(res);
            },
            error: function(res){
                alert('실패!')
            }
        })
    })

    $(".denyBtn").click(function() {
        
        const rqno = this.value;

        $.ajax({
            url: "deny.re",
            data: {rqno: rqno},
            success: function(res){
                alert('성공')
            },
            error: function(res){
                alert('실패!')
            }
        })
    })
});

document.addEventListener("DOMContentLoaded", function() {
    const timeElements = document.querySelectorAll('.writeTime');
    timeElements.forEach(function(element) {
        const timestamp = element.innerText.trim();
        const formattedDate = formatTimestamp(timestamp);
        element.innerText = formattedDate;
    });
})

function formatTimestamp(timestamp) {
    // Create a new Date object from the timestamp string
    const date = new Date(timestamp.replace(' ', 'T').replace('.0', ''));
    
    // Extract year, month, day, hours, and minutes
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // getMonth() is zero-based
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');

    // Format the date and time
    return `${year}.${month}.${day} ${hours}:${minutes}`;
}

function drawRequest(data) {
    
}