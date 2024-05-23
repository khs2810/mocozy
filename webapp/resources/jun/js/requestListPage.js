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
});