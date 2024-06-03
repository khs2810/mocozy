$(document).ready(function() {
    $('#optionSelect').change(function() {
        const selectedOption = $(this).val();

        if (selectedOption === '진행중') {
            $('#club-ing').show();
            $('#club-done').hide();
        } else if (selectedOption === '종료됨') {
            $('#club-ing').hide();
            $('#club-done').show();
        }
    })

    // $('#club-ing').on('click', '.btn-color2', function(ev) {
    //     const btn = ev.target;
        
    //     $.ajax({
    //         url: "finishSocial.me",
    //         data: {
    //             cno: btn.dataset.cno
    //         },
    //         success: function(res) {
    //             alert('소셜링 종료 성공');
    //         },
    //         error: function(res) {
    //             alert('소셜링 종료 실패');
    //         }
    //     })
    // })
});