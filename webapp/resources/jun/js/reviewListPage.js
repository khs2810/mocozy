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

    $('#reviewEnrollWindow').on('show.bs.modal', function(event) {
        // 버튼에서 data-cno 값을 가져오기
        var button = $(event.relatedTarget);
        var clubNo = button.data('cno');
        
        document.querySelector('input[name="clubNo"]').value = clubNo;
    });

    $('.detailBtn').on('click', function() {
        let clubNo = $(this).data('cno');
        let userNo = $(this).data('uno');

        $.ajax({
            url: 'getReview.cl',
            method: 'GET',
            data: { clubNo: clubNo, userNo: userNo },
            success: function(data) {
                let starsHtml = '';
                for (let i = 5; i >= 1; i--) {
                    if (i <= data.grade) {
                        starsHtml += '<label class="star" style="color:#f90">&#9733;</label>';
                    } else {
                        starsHtml += '<label class="star" style="color:#f90">&#9734;</label>';
                    }
                }
                $('#reviewDetailWindow .star-rated').html(starsHtml);
                $('#reviewDetailWindow .review-write textarea').val(data.reviewContent);
            },
            error: function(err) {
                console.error('리뷰 데이터를 불러오지 못했습니다.', err);
            }
        });
    });
});

function countingStar(n) {
    document.querySelector('input[name="grade"]').value = n;
}