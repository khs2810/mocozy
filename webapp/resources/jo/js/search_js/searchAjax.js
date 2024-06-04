let currentPage = 1;  // 현재 페이지 번호 초기화
const size = 10;  // 한 페이지에 로드할 아이템의 수

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        searchFormAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function searchFormAjax(data, callback) {
    $.ajax({
        url: `searchForm.sc`,
        method: 'GET',
        data: data,
        success: function (data) {
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
        searchFormPickAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function searchFormPickAjax(data, callback) {
    $.ajax({
        url: `searchFormPick.sc`,
        method: 'GET',
        data: data,
        success: function (data) {
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
        searchFormViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function searchFormViewAjax(data, callback) {
    $.ajax({
        url: `searchFormView.sc`,
        method: 'GET',
        data: data,
        success: function (data) {
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