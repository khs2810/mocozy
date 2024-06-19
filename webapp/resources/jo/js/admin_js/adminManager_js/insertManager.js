// /* 권한 모달창 띄우기 */
// $(document).ready(function(){
//   $("#adminBtn").click(function(){
//     $(".adminModal").modal('show');
//   });
// });

// document.getElementById('adminBtn').addEventListener('click', function() {
//   confirm('정말로 관리자 권한을 부여하시겠습니까?');
// });

/* -------------------------------------------------------------------------- */
let selectValue;
let sortType;
let cpage = 1;
let keyword = new URLSearchParams(window.location.search).get('keyword');

document.addEventListener('DOMContentLoaded', function() {
    let orderSelect = document.getElementById("sortBtn");
    
    if(orderSelect) {
      //sortBtn의 value값을 가져와서 sortType에 저장
      selectValue = orderSelect.options[orderSelect.selectedIndex].value;
      sortType = selectValue;
      
      //페이지가 처음 로드될때 ajax 요청);
      insertManagerAjax();

      //sortBtn의 값이 바뀔 때마다 sortType에 저장
      orderSelect.onchange = function(e) {  
      sortType = e.target.value;

        // sortType 값이 변경될 때마다 기존의 데이터를 지우고 새로운 데이터로 대체
        document.querySelector("#prod-list-body").innerHTML = '';
        cpage = 1;

        // 키워드가 있을 경우 adminClubSearchAjax 함수를 호출
        if (keyword) {
          insertManagerSearchAjax(keyword, sortType);
        } else {
          insertManagerAjax();
        }
      }

    }
  });
  
  // 검색 버튼을 실행하면 검색 기능을 위한 AJAX 요청을 실행
  $(document).ready(function(){
  $(".serach-wrap.big-search").click(function(){
    keyword = $('#keyword-search-input').val();
    if (keyword) {
      insertManagerSearchAjax(keyword, sortType);
    } else {
      insertManagerAjax();
  }
  });

//페이지의 끝에 도달하면 AJAX 요청을 보냄
   window.onscroll = function() {
    if (window.innerHeight + window.scrollY >= document.body.scrollHeight) {
      if (keyword) {
        insertManagerSearchAjax(keyword, sortType);
      } else {
        insertManagerAjax();
    }
  };
  }

});

// 페이지를 그리는 함수
function renderinsertManagerlist(mlist) {
  for (let user of mlist) {
    let str = "";
    str = `<tr class="content -prodListItem">
																<td class="checkhead">
																	<div class="drag -showcase-handle ui-sortable-handle">
																	</div>
																	<div class="checkbox checkbox-styled no-margin">
																		<label> <input type="checkbox"
																			class="-prodListCheck"> <span></span>
																		</label>
																	</div>
																</td>

																<td class="no text-12">${user.userNo}</td>

																<td class="image"><a href="javascript:void(0);"> <img
																		src="${user.profileImg}"
																		width="49" height="49" class="item-thumb">
																</a></td>

																<td class="title" style="width: 100px;">
																	<div>
																		<div class="item-tit inline-blocked">
																			<a href="javascript:void(0);">${user.nickname}</a> <a
																				href="javascript:void(0);"
																				class="im-icon im-ico-new-tab vertical-middle tab-icon"
																				style="margin-left: 4px;"></a>
																		</div>
																		<span class="btn-sm text-gray-bright"></span>
																	</div>
																</td>

																<td class="state on-click"><a
																	data-toggle="dropdown" style="margin-right: -1px;">
																		<span>${user.admin}</span>
																</a></td>

																<td class="r-date text-12">${user.enrollDate}</td>
																<td class="purchase text-center hidden-xs hidden-sm"
																	style="width: 100px;"><a href="adminPoint.ad"
																	style="text-decoration: underline;">${user.point}</a></td>
																<td class="more">
																	<div class="dropdown">
																		<button class="btn btn-primary-btn" id="adminBtn" onclick="insertManagerStatusAjax(${user.userNo}, 'Y')">권한
																			부여</button>
																	</div>
																</td>
															</tr>`
        
          document.querySelector("#prod-list-body").innerHTML += str;
    }
}

//admin 변경
function insertManagerStatusAjax(uno, admin) {
  window.location.href = "insertManagerStatusAjax.ad?userNo=" + uno + "&admin=" + admin;
}

// AJAX 요청을 처리하는 함수
function insertManagerAjax() {
  $.ajax({
      url: 'insertManagerAjax.ad',
      //cpage를 보내줌
      data : {cpage: cpage++, sortType: sortType},
      success: function(mlist){
          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
          renderinsertManagerlist(mlist);   
      },
      error: function(){
        alert("요청이 실패했습니다");
      }
    });
  }

  // AJAX 요청을 처리하는 함수
function insertManagerSearchAjax(keyword, sortType) {
  $.ajax({
      url: 'insertManagerSearchAjax.ad',
      //cpage와 sortType을 같이 보내줌
      data : {cpage: 1, sortType: sortType, keyword: keyword},
      success: function(mlist){
        console.log(mlist);
          // 페이지의 내용을 비움
          document.querySelector("#prod-list-body").innerHTML = '';
          
          // mlist의 길이가 0이면 검색 결과가 없다는 알림을 표시
          if (mlist.length === 0) {
            alert("검색 결과가 없습니다");
          } else {
          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
          renderinsertManagerlist(mlist);   
          console.log("AJAX 요청 성공, 응답 데이터:", mlist);
      }
    },
      error: function(){
        alert("요청이 실패했습니다");
      }
    });
}

//status 변경
function ManagerstatusAjax(uno){
  //클럽 status 변경
      if (confirm("정말로 권한을 부여 하시겠습니까?")) {
          $.ajax({
              type : "POST",
              url : "ManagerstatusAjax.ad",
              data : {
                admin : "Y", userNo : uno
              },
              success : function(response) {
                  alert("성공적으로 처리되었습니다.");
                  refreshManagerList();
              },
              error : function(xhr, status, error) {
                  alert("오류가 발생했습니다.");
              }
          });
        }
};

//status hidden으로 변경
function managerChangeStatus(uno, status) {
  window.location.href = "managerChangeStatus.ad?userNo=" + uno + "&status=" + status;
}