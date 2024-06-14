// /* 삭제 모달창 띄우기 */
// $(document).ready(function(){
//     $("#deleteBtn").click(function(){
//       $(".deleteModal").modal('show');
//     });

//   /* 시작 모달창 띄우기 */
//   $("#startBtn").click(function(){
//     $(".startModal").modal('show');
//   });
// });

// document.getElementById('startBtn').addEventListener('click', function() {
//   confirm('정말로 노출시키시겠습니까?');
// });

// document.getElementById('deleteBtn').addEventListener('click', function() {
//   confirm('정말로 숨기시겠습니까?');
// });

/* -------------------------------------------------------------------------- */
//select html요소의 sortBtn이라는 객체를 가져옴
let selectValue;
let sortType;
let cpage = 1;
let keyword = new URLSearchParams(window.location.search).get('keyword');

document.addEventListener('DOMContentLoaded', function () {
  let orderSelect = document.getElementById("sortBtn");
  console.log(orderSelect.id);

  if (orderSelect) {
    //sortBtn의 value값을 가져와서 sortType에 저장
    selectValue = orderSelect.options[orderSelect.selectedIndex].value;
    sortType = selectValue;

    //페이지가 처음 로드될때 ajax 요청
    const status = document.querySelector('#status').value;
    adminClubAjax(status);

    //sortBtn의 값이 바뀔 때마다 sortType에 저장
    orderSelect.onchange = function (e) {
      sortType = e.target.value;
      console.log("sortType(onChange): ", sortType);

      // sortType 값이 변경될 때마다 기존의 데이터를 지우고 새로운 데이터로 대체
      document.querySelector("#prod-list-body").innerHTML = '';
      cpage = 1;

      //sortType 값이 변경될 때마다 ajax요청을 보냄
      const status = document.querySelector('#status').value;
        
      // 키워드가 있을 경우 adminClubSearchAjax 함수를 호출
      if (keyword) {
        adminClubSearchAjax(keyword, sortType, status);
      } else {
        adminClubAjax(status);
      }
    }

    }
  });

//페이지의 끝에 도달하면 AJAX 요청을 보냄
window.onscroll = function () {
  if (window.innerHeight + window.scrollY >= document.body.scrollHeight) {
    const status = document.querySelector('#status').value;
    if (keyword) {
      adminClubSearchAjax(keyword, sortType, status);
    } else {
      adminClubAjax(status);
    }
  };
}

// 검색 버튼을 실행하면 검색 기능을 위한 AJAX 요청을 실행
$(document).ready(function () {
  $(".serach-wrap.big-search").click(function () {
    keyword = $('#keyword-search-input').val();
    const status = document.querySelector('#status').value;
    if (keyword) {
      adminClubSearchAjax(keyword, sortType, status);
    } else {
      adminClubAjax(status);
    }
  });
});

// 페이지를 그리는 함수
function renderClubList(clist) {
  for (let i = 0; i < clist.length; i++) {
    let club = clist[i];

    //BtnStyle 변수를 생성
    let deleteBtnStyle = '';
    let startBtnStyle = '';

    //status에 따라 버튼을 보여주거나 숨김
    if (club.status === 'E' || club.status === 'N'){
      deleteBtnStyle = 'style="display: none;"';
      startBtnStyle = 'style="display: none;"';
    } else if (club.status === 'H') {
      deleteBtnStyle = 'style="display: none;"';
      startBtnStyle = 'style="display: block;"';
    } else if (club.status === 'Y') {
      startBtnStyle = 'style="display: none;"';
      deleteBtnStyle = 'style="display: block;"';
    }

    let str = "";
    str = `<tr class="content -prodListItem">
					<td class="checkhead">
						<div class="checkbox checkbox-styled no-margin">
								<label> 
                  <input type="checkbox" class="-prodListCheck"> <span></span>
								</label>
						</div>
					</td>

					<td class="no text-12">${club.clubNo}</td>

					<td class="image">
            <a href="detail.cl?cno=${club.clubNo}"> 
              <img src="${club.thumbnailImg}" width="49" height="49" class="item-thumb">
						</a>
          </td>

					<td class="title">
            <div>
							<div class="item-tit inline-blocked">
								<a href="detail.cl?cno=${club.clubNo}">${club.clubTitle}</a> 
                <a href="detail.cl?cno=${club.clubNo}" class="im-icon im-ico-new-tab vertical-middle tab-icon"
									style="margin-left: 4px;"></a>
							</div>

							<span class="btn-sm text-gray-bright"></span>
						</div>
				</td>

				<td class="group">${club.categoryName2}</td>
          <td class="state on-click">
            <a data-toggle="dropdown" style="margin-right: -1px;">
							<span>${club.status}</span>
						</a>
          </td>

					<td class="r-date text-12">${club.modifyDate}</td>
						<td class="more">
							<div class="dropdown">
								<button class="btn btn-danger-button" id="deleteBtn" onclick="clubChangeStatus(${club.clubNo}, 'H')"${deleteBtnStyle}>숨김</button>
								<button class="btn btn-primary-btn" id="startBtn" onclick="clubChangeStatus(${club.clubNo}, 'Y')"${startBtnStyle}>노출</button>
						  </div>
						</td>
            </tr>`

    document.querySelector("#prod-list-body").innerHTML += str;
  }
}

//status hidden으로 변경
function clubChangeStatus(cno, status) {
  window.location.href = "clubChangeStatus.ad?clubNo=" + cno + "&status=" + status;
}

// AJAX 요청을 처리하는 함수
function adminClubAjax(status) {
  $.ajax({
    url: 'adminClubAjax.ad',
    //cpage와 sortType을 같이 보내줌
    data: { cpage: cpage++, sortType: sortType, status: status},
    success: function (clist) {
      console.log(clist);

      // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
      renderClubList(clist);
      console.log("AJAX 요청 성공, 응답 데이터:", clist);
    },
    error: function () {
      console.log("ajax 실패");
      alert("요청이 실패했습니다");
    }
  });
}

// AJAX 요청을 처리하는 함수
function adminClubSearchAjax(keyword, sortType, status) {
  console.log("sortType: ", sortType);
  $.ajax({
    url: 'adminClubSearchAjax.ad',
    //cpage와 sortType을 같이 보내줌
    data: { cpage: 1, sortType: sortType, status: status, keyword: keyword },
    success: function (clist) {
      console.log(clist);
      // 페이지의 내용을 비움
      document.querySelector("#prod-list-body").innerHTML = '';

      // clist의 길이가 0이면 검색 결과가 없다는 알림을 표시
      if (clist.length === 0) {
        alert("검색 결과가 없습니다");
      } else {
        // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
        renderClubList(clist);
        console.log("AJAX 요청 성공, 응답 데이터:", clist);
      }
    },
    error: function () {
      console.log("ajax 실패");
      alert("요청이 실패했습니다");
    }
  });
}