let currentPage = 1;  // 현재 페이지 번호 초기화
const size = 10;  // 한 페이지에 로드할 아이템의 수

/* --------- */
$(window).scroll(function() {
    if($(window).scrollTop() + $(window).height() == $(document).height()) {
        cateAllajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateAllajax(data, callback) {
    $.ajax({
        url: `cateAll.ct`,
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

function cateActivityajax(data, callback) {
    $.ajax({
        url: `cateActivity.ct`,
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
        cateArtajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateArtajax(data, callback) {
    $.ajax({
        url: `cateArt.ct`,
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
        cateDevelopeajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateDevelopeajax(data, callback) {
    $.ajax({
        url: `cateDevelope.ct`,
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
        cateFoodajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateFoodajax(data, callback) {
    $.ajax({
        url: `cateFood.ct`,
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
        cateForeignajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateForeignajax(data, callback) {
    $.ajax({
        url: `cateForeign.ct`,
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
        cateGameajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateGameajax(data, callback) {
    $.ajax({
        url: `cateGame.ct`,
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
        cateHobbyajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateArtajax(data, callback) {
    $.ajax({
        url: `cateHobby.ct`,
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
        cateInvestajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateInvestajax(data, callback) {
    $.ajax({
        url: `cateInvest.ct`,
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
        cateLoveajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateLoveajax(data, callback) {
    $.ajax({
        url: `cateLove.ct`,
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
        cateTravelajax({page: currentPage, size: size}, function() {
            console.log("데이터 로드 성공");
            currentPage++;  // 다음 페이지로 이동
        });
    }
});

function cateTravelajax(data, callback) {
    $.ajax({
        url: `cateTravel.ct`,
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

