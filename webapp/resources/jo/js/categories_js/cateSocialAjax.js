let currentPage = 1;  // 현재 페이지 번호 초기화
const size = 10;  // 한 페이지에 로드할 아이템의 수

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        cateBestAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateBestAjax(data, callback) {
    $.ajax({
        url: `cateBest.ct`,
        method: 'GET',
        data: data,
        success: function (data) {
            console.log(data);
            let $data = $(data); 
            let $contentcards = $data.find('.contentcard'); 

            $contentcards.each(function() {
                let str = $(this).prop('outerHTML');  // 찾은 div의 HTML 가져오기
                $('.display').append(str);  // 화면에 추가
            });

            if(callback) callback();
        },

        error: function () {
            console.error("데이터 요청 ajax 실패");
        }
    });
}

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        cateHotAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateHotAjax(data, callback) {
    $.ajax({
        url: `cateHot.ct`,
        method: 'GET',
        data: data,
        success: function (data) {
            console.log(data);
            let $data = $(data); 
            let $contentcards = $data.find('.contentcard'); 

            $contentcards.each(function() {
                let str = $(this).prop('outerHTML');  // 찾은 div의 HTML 가져오기
                $('.display').append(str);  // 화면에 추가
            });

            if(callback) callback();
        },

        error: function () {
            console.error("데이터 요청 ajax 실패");
        }
    });
}

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        cateRecentAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateRecentAjax(data, callback) {
    $.ajax({
        url: `cateRecent.ct`,
        method: 'GET',
        data: data,
        success: function (data) {
            console.log(data);
            let $data = $(data); 
            let $contentcards = $data.find('.contentcard'); 

            $contentcards.each(function() {
                let str = $(this).prop('outerHTML');  // 찾은 div의 HTML 가져오기
                $('.display').append(str);  // 화면에 추가
            });

            if(callback) callback();
        },

        error: function () {
            console.error("데이터 요청 ajax 실패");
        }
    });
}