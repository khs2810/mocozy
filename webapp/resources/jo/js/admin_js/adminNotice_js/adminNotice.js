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
  //select html요소의 sortBtn이라는 객체를 가져옴
  let selectValue;
  let sortType;
  let cpage = 1;
  let keyword = new URLSearchParams(window.location.search).get('keyword');
  
  document.addEventListener('DOMContentLoaded', function() {
    let orderSelect = document.getElementById("sortBtn");
    console.log(orderSelect.id);
    
    if(orderSelect) {
      //sortBtn의 value값을 가져와서 sortType에 저장
      selectValue = orderSelect.options[orderSelect.selectedIndex].value;
      sortType = selectValue;
      
      //페이지가 처음 로드될때 ajax 요청
      const noticeType = document.querySelector('#noticeType').value; 
      adminNoticeAjax(noticeType);

      //sortBtn의 값이 바뀔 때마다 sortType에 저장
      orderSelect.onchange = function(e) {  
        sortType = e.target.value;
        console.log("sortType(onChange): ", sortType);

        // sortType 값이 변경될 때마다 기존의 데이터를 지우고 새로운 데이터로 대체
        document.querySelector("#prod-list-body").innerHTML = '';
        cpage = 1;

      //sortType 값이 변경될 때마다 ajax요청을 보냄
      const status = document.querySelector('#status').value;
              
      // 키워드가 있을 경우 adminClubSearchAjax 함수를 호출
      if (keyword) {
        adminNoticeSearchAjax(keyword, sortType);
      } else {
        adminNoticeAjax();
      }
    }

    }
  });

//페이지의 끝에 도달하면 AJAX 요청을 보냄
   window.onscroll = function() {
    if (window.innerHeight + window.scrollY >= document.body.scrollHeight) {
        const noticeType = document.querySelector('#noticeType').value; 
        if (keyword) {
          adminNoticeSearchAjax(keyword, sortType, noticeType);
        } else {
          adminNoticeAjax(noticeType);
      }
    };
   }

   // 검색 버튼을 실행하면 검색 기능을 위한 AJAX 요청을 실행
$(document).ready(function(){
  $(".serach-wrap.big-search").click(function(){
    keyword = $('#keyword-search-input').val();
    const noticeType = document.querySelector('#noticeType').value; 
    if (keyword) {
      adminNoticeSearchAjax(keyword, sortType, noticeType);
    } else {
      adminNoticeAjax(noticeType);
  }
  });
});

// 페이지를 그리는 함수
function renderNoticelist(nlist) {
  for (let i = 0; i < nlist.length; i++) {
    let notice = nlist[i];

    //BtnStyle 변수를 생성
    let startBtnStyle = '';

    //noticeType 따라 버튼을 보여주거나 숨김
    if (notice.noticeType === '이벤트' && notice.bannerPath != null){
      startBtnStyle = 'style="display: block;"';
    } else {
      startBtnStyle = 'style="display: none;"';
    }
    
    let str = "";
    str = `										<tr class="content -prodListItem" height="50px;">
																<td class="checkhead">
																	<div class="drag -showcase-handle ui-sortable-handle"></div>
																	<div class="checkbox checkbox-styled no-margin">
																		<label> <input type="checkbox"
																			class="-prodListCheck"> <span></span>
																		</label>
																	</div>
																</td>

																<td class="no text-12">${notice.noticeNo}</td>

																<td class="title" style="width: 150px">
																	<div>
																		<div class="item-tit inline-blocked">
																			<a href="detail.no?nno=${notice.noticeNo}">${notice.noticeTitle}</a> <a
																				href="detail.no?nno=${notice.noticeNo}"
																				class="im-icon im-ico-new-tab vertical-middle tab-icon"
																				style="margin-left: 4px;"></a>
																		</div>
																		<span class="btn-sm text-gray-bright"></span>
																	</div>
																</td>

																<td class="group" style="text-decoration: underline;">${notice.noticeType}</td>

																<td class="state on-click"><a
																	data-toggle="dropdown"> 
                                  <span style="text-align: left">${notice.status}</span>
																</a></td>

                                <td class="state on-click"><a
																	data-toggle="dropdown"> 
                                  <span style="text-align: left">${notice.banner}</span>
																</a></td>

                                <td class="state on-click"><a
																	data-toggle="dropdown"> 
                                  <div style="text-align: left; width: 80px; overflow: hidden; text-overflow: ellipsis;
                                    white-space: nowrap;">${notice.bannerPath}</div>
																</a></td>

																<td class="r-date text-12">${notice.modifyDate}</td>
                                
                                <td class="more">
																	<div class="dropdown">
																		<button class="btn btn-primary-btn" id="startBtn" onclick="eventStatusAjax(${notice.noticeNo},'Y')"${startBtnStyle}>노출</button>
																	</div>
																</td>

                              </tr>`
        
          document.querySelector("#prod-list-body").innerHTML += str;
    }
}

//변경
function eventStatusAjax(nno, banner) {
  window.location.href = "eventStatusAjax.ad?noticeNo=" + nno + "&banner=" + banner;
}

// AJAX 요청을 처리하는 함수
function adminNoticeAjax(noticeType) {
  console.log("sortType: ", sortType); 
  $.ajax({
      url: 'adminNoticeAjax.ad',
      //cpage와 sortType을 같이 보내줌
      data : {cpage: cpage++, sortType: sortType, noticeType: noticeType},
      success: function(nlist){
        console.log(nlist);

          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
          renderNoticelist(nlist);   
          console.log("AJAX 요청 성공, 응답 데이터:", nlist);
      },
      error: function(){
        console.log("ajax 실패");
        alert("요청이 실패했습니다");
      }
    });
  }

    // AJAX 요청을 처리하는 함수
function adminNoticeSearchAjax(keyword, sortType, noticeType) {
  console.log("sortType: ", sortType); 
  $.ajax({
      url: 'adminNoticeSearchAjax.ad',
      //cpage와 sortType을 같이 보내줌
      data : {cpage: 1, sortType: sortType, noticeType: noticeType, keyword: keyword},
      success: function(nlist){
        console.log(nlist);
          // 페이지의 내용을 비움
          document.querySelector("#prod-list-body").innerHTML = '';

           // nlist의 길이가 0이면 검색 결과가 없다는 알림을 표시
           if (nlist.length === 0) {
            alert("검색 결과가 없습니다");
          } else {
          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
          renderNoticelist(nlist);   
          console.log("AJAX 요청 성공, 응답 데이터:", nlist);
      }
    },
      error: function(){
        console.log("ajax 실패");
        alert("요청이 실패했습니다");
      }
    });
}