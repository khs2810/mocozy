/* 삭제 모달창 띄우기 */
$(document).ready(function(){
    $("#deleteBtn").click(function(){
      $(".deleteModal").modal('show');
    });

  /* 시작 모달창 띄우기 */
  $("#startBtn").click(function(){
    $(".startModal").modal('show');
  });
});

/* -------------------------------------------------------------------------- */
  //select html요소의 sortBtn이라는 객체를 가져옴
  let selectValue;
  let sortType;
  let cpage = 1;

  document.addEventListener('DOMContentLoaded', function() {
    let orderSelect = document.getElementById("sortBtn");
    console.log(orderSelect.id);
    
    if(orderSelect) {
      //sortBtn의 value값을 가져와서 sortType에 저장
      selectValue = orderSelect.options[orderSelect.selectedIndex].value;
      sortType = selectValue;
      
      //페이지가 처음 로드될때 ajax 요청
      const status = document.querySelector('#status').value; 
      adminUserlistAjax(status);

      //sortBtn의 값이 바뀔 때마다 sortType에 저장
      orderSelect.onchange = function(e) {  
        sortType = e.target.value;
        console.log("sortType(onChange): ", sortType);

        // sortType 값이 변경될 때마다 기존의 데이터를 지우고 새로운 데이터로 대체
        document.querySelector("#prod-list-body").innerHTML = '';
        cpage = 1;

        //sortType 값이 변경될 때마다 ajax요청을 보냄
        const status = document.querySelector('#status').value; 
        adminUserlistAjax(status);

      }
    }
  });

//페이지의 끝에 도달하면 AJAX 요청을 보냄
   window.onscroll = function() {
    if (window.innerHeight + window.scrollY >= document.body.scrollHeight) {
        const status = document.querySelector('#status').value; 
        adminUserlistAjax(status);
       }
  };

// 페이지를 그리는 함수
function renderUserlist(mlist) {
  for (let user of mlist) {
    let str = "";
    str = `<tr class="content -prodListItem">
																<td class="checkhead">
																	<div class="checkbox checkbox-styled no-margin">
																		<label> <input type="checkbox"
																			class="-prodListCheck"> <span></span>
																		</label>
																	</div>
																</td>

																<td class="no text-12">${user.userNo}</td>

																<td class="image"><a href="_blank"> <img
																		src="${user.profileImg}"
																		width="49" height="49" class="item-thumb">
																</a></td>

																<td class="title" style="width: 100px;">
																	<div>
																		<div class="item-tit inline-blocked">
																			<a href="_blank">${user.nickname}</a> <a
																				href="_blank"
																				class="im-icon im-ico-new-tab vertical-middle tab-icon"
																				style="margin-left: 4px;"></a>
																		</div>
																		<span class="btn-sm text-gray-bright"></span>
																	</div>
																</td>

																<td class="state on-click"><a
																	data-toggle="dropdown" style="margin-right: -1px;">
																		<span>${user.status}</span>
																</a></td>

																<td class="r-date text-12">${user.enrollDate}</td>
																<td class="purchase text-center hidden-xs hidden-sm"
																	style="width: 100px;"><a href="adminPoint.ad"
																	style="text-decoration: underline;">${user.point}</a></td>
																<td class="more">
																	<div class="dropdown">
																		<button class="btn btn-primary-btn" id="startBtn">시작</button>
																		<button class="btn btn-flat" id="deleteBtn">종료</button>
																	</div>
																</td>
															</tr>`
        
          document.querySelector("#prod-list-body").innerHTML += str;
    }
}

// AJAX 요청을 처리하는 함수
function adminUserlistAjax(status) {
  console.log("sortType: ", sortType); 
  $.ajax({
      url: 'adminUserlistAjax.ad',
      //cpage와 sortType을 같이 보내줌
      data : {cpage: cpage++, sortType: sortType, status: status},
      success: function(mlist){
        console.log(mlist);

          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출
          renderUserlist(mlist);   
          console.log("AJAX 요청 성공, 응답 데이터:", mlist);
      },
      error: function(){
        console.log("ajax 실패");
        alert("요청이 실패했습니다");
      }
    });
  }