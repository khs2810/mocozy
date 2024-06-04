let currentPage = 1;  // 현재 페이지 번호 초기화
const size = 10;  // 한 페이지에 로드할 아이템의 수

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        eventArtAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventArtAjax(data, callback) {
    $.ajax({
        url: `eventArt.ev`,
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
        cateActivityajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventDessertAjax(data, callback) {
    $.ajax({
        url: `eventDessert.ev`,
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
        eventGameAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventGameAjax(data, callback) {
    $.ajax({
        url: `eventGame.ev`,
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
        eventPartyAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventPartyAjax(data, callback) {
    $.ajax({
        url: `eventParty.ev`,
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
        eventPhotoAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventPhotoAjax(data, callback) {
    $.ajax({
        url: `eventPhoto.ev`,
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
        eventStudyAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventStudyAjax(data, callback) {
    $.ajax({
        url: `eventStudy.ev`,
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
        eventTravelAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventTravelAjax(data, callback) {
    $.ajax({
        url: `eventTravel.ev`,
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
        eventLoveAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function eventLoveAjax(data, callback) {
    $.ajax({
        url: `eventLove.ev`,
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