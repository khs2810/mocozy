// /* 노출 모달창 띄우기 */
// $(document).ready(function(){
//     $("#noticeBtn").click(function(){
//       $(".noticeModal").modal('show');
//     });

//   /* 삭제 모달창 띄우기 */
//   $("#deleteBtn").click(function(){
//     $(".deleteModal").modal('show');
//   });
// });

// document.getElementById('startBtn').addEventListener('click', function() {
//   confirm('정말로 노출시키시겠습니까?');
// });

/* -------------------------------------------------------------------------- */
let cpage = 1;

document.addEventListener('DOMContentLoaded', function () {
  //페이지가 처음 로드될때 ajax 요청
  const noticeType = document.querySelector('#noticeType').value;

  document.querySelector("#noticelist").innerHTML = '';
  cpage = 1;

  // 키워드가 있을 경우 adminClubSearchAjax 함수를 호출
  adminNoticeBannerAjax(noticeType);
});

//페이지의 끝에 도달하면 AJAX 요청을 보냄
window.onscroll = function () {
  if (window.innerHeight + window.scrollY >= document.body.scrollHeight) {
    const noticeType = document.querySelector('#noticeType').value;
    adminNoticeBannerAjax(noticeType, banner);
  }
};


// 페이지를 그리는 함수
function renderNoticelist(nlist) {
  for (let i = 0; i < nlist.length; i++) {
    let notice = nlist[i];
    let str = "";
    str = `<div class="card" style="width: 290px; float: left;">
							<div class="card-head">
									<header>
											<a href="_blank"> ${notice.noticeTitle}</a>
									</header>
									<div class="tools">
										<div class="btn-group">
														<button class="btn btn-primary-btn" id="deleteBtn" onclick="eventbannerAjax(${notice.noticeNo},'N')">종료</button>
										</div>
									</div>
							</div>
							<a href="javascript:void(0);">
									<img src="${notice.bannerPath}" style="width: 100%;">
              </a>
							<div class="card-body">
              	<span class="badge style-gray">이벤트</span>
								<p>${notice.noticeContent} </p>
							</div>
					</div>`

    document.querySelector("#noticelist").innerHTML += str;
  }
}

//변경
function eventbannerAjax(nno, banner) {
  window.location.href = "eventbannerAjax.ad?noticeNo=" + nno + "&banner=" + banner;
}

// AJAX 요청을 처리하는 함수
function adminNoticeBannerAjax(noticeType) {
  $.ajax({
    url: 'adminNoticeBannerAjax.ad',
    data: { cpage: cpage++, noticeType: noticeType },
    success: function (nlist) {
      // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
      renderNoticelist(nlist);
      console.log("AJAX 요청 성공, 응답 데이터:", nlist);
    },
    error: function () {
      console.log("ajax 실패");
      alert("요청이 실패했습니다");
    }
  });
}