let currentPage = 1;  // 현재 페이지 번호 초기화
const size = 10;  // 한 페이지에 로드할 아이템의 수

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        cateAllViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateAllViewAjax(data, callback) {
    $.ajax({
        url: `cateAllView.ct`,
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
        cateActivityViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateActivityViewAjax(data, callback) {
    $.ajax({
        url: `cateActivityView.ct`,
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
        cateArtViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateArtViewAjax(data, callback) {
    $.ajax({
        url: `cateArtView.ct`,
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
        cateDevelopeViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateDevelopeViewAjax(data, callback) {
    $.ajax({
        url: `cateDevelopeView.ct`,
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
        cateFoodViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateFoodViewAjax(data, callback) {
    $.ajax({
        url: `cateFoodView.ct`,
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
        cateForeignViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateForeignViewAjax(data, callback) {
    $.ajax({
        url: `cateForeignView.ct`,
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
        cateGameViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateGameViewAjax(data, callback) {
    $.ajax({
        url: `cateGameView.ct`,
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
        cateHobbyViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateHobbyViewAjax(data, callback) {
    $.ajax({
        url: `cateHobbyView.ct`,
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
        cateInvestViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateInvestViewAjax(data, callback) {
    $.ajax({
        url: `cateInvestView.ct`,
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
        cateLoveViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateLoveViewAjax(data, callback) {
    $.ajax({
        url: `cateLoveView.ct`,
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
        cateTravelViewAjax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateTravelViewAjax(data, callback) {
    $.ajax({
        url: `cateTravelView.ct`,
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

