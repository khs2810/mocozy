//현재 스크롤 위치 저장
let lastScroll = 0;
let page = 0;
let nowPageLimit = 0;
let nextPageLimit = 0;

//데이터 가져오는 함수
function getData(limit){
	//다음페이지
	nextPageLimit = (page + 1) * limit;

	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: "cateAll.ct",
		async : false,
		data: {
			 "nextPageLimit" : nextPageLimit,
			 "limit" : limit
		},
		success: function(data){
			$(".display").append(data);
		},
		error: function (data, status, err) {
			page = page;
		}, complete: function(){
			page = page + 1;
		}
	});
}

$(document).scroll(function(e){
    //현재 높이 저장
    const currentScroll = $(this).scrollTop();
    //전체 문서의 높이
    const documentHeight = $(document).height();

    //(현재 화면상단 + 현재 화면 높이)
    const nowHeight = $(this).scrollTop() + $(window).height();


    //스크롤이 아래로 내려갔을때만 해당 이벤트 진행.
    if(currentScroll > lastScroll){

        //nowHeight을 통해 현재 화면의 끝이 어디까지 내려왔는지 파악가능 
        //즉 전체 문서의 높이에 일정량 근접했을때 글 더 불러오기)
        if(documentHeight < (nowHeight + (documentHeight*0.1))){
        	//함수콜
		getData(50);
		
        }
    }

    //현재위치 최신화
    lastScroll = currentScroll;

});