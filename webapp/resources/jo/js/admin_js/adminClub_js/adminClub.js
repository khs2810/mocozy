$(document).ready(function () {
  /* 삭제 모달창 띄우기 */
  $("#deleteBtn").click(function () {
    $(".deleteModal").modal('show');
  });

  /* 승인 모달창 띄우기 */
  $("#acceptBtn").click(function () {
    $(".acceptModal").modal('show');
  });

  /* 시작 모달창 띄우기 */
  $("#startBtn").click(function () {
    $(".startModal").modal('show');
  });
});

/* -------------------------------------------------------------------------- */
  //select html요소의 sortBtn이라는 객체를 가져옴
  let selectValue;
  let sortType;
  let cpage = 2;

  document.addEventListener('DOMContentLoaded', function() {
    let orderSelect = document.getElementById("sortBtn");
    console.log(orderSelect.id);
    
    if(orderSelect) {
      //sortBtn의 value값을 가져와서 sortType에 저장
      selectValue = orderSelect.options[orderSelect.selectedIndex].value;
      sortType = selectValue;
      
      //페이지가 처음 로드될때 ajax 요청
      adminClubAjax();
      
      //sortBtn의 값이 바뀔 때마다 sortType에 저장
      orderSelect.onchange = function(e) {  
        sortType = e.target.value;
        console.log("sortType(onChange): ", sortType);

        // sortType 값이 변경될 때마다 기존의 데이터를 지우고 새로운 데이터로 대체
        document.querySelector("#prod-list-body").innerHTML = '';
        cpage = 2;

        //sortType 값이 변경될 때마다 ajax요청을 보냄
        adminClubAjax();
      }
    }
  });

//페이지의 끝에 도달하면 AJAX 요청을 보냄
   window.onscroll = function() {
       if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
          adminClubAjax();
       }
  };

// 페이지를 그리는 함수
function renderClubList(clist) {
  for (let club of clist) {
    const tr = document.createElement('tr');
    tr.className = "content -prodListItem";
    let str = "";
    str = `
					<td class="checkhead">
						<div class="checkbox checkbox-styled no-margin">
								<label> 
                  <input type="checkbox" class="-prodListCheck"> <span></span>
								</label>
						</div>
					</td>

					<td class="no text-12">${club.clubNo}</td>

					<td class="image">
            <a href="_blank"> 
              <img src="${club.thumbnailImg}" width="49" height="49" class="item-thumb">
						</a>
          </td>

					<td class="title">
            <div>
							<div class="item-tit inline-blocked">
								<a href="_blank">${club.clubTitle}</a> 
                <a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon"
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

					<td class="state on-click">
            <a data-toggle="dropdown" style="margin-right: -1px;">
							<span>${club.request_status}</span>
						</a>
          </td>

					<td class="r-date text-12">${club.modifyDate}</td>
						<td class="more">
							<div class="dropdown">
								<button class="btn btn-primary-btn" id="acceptBtn${club.clubNo}">승인</button>
								<button class="btn btn-danger-button" id="deleteBtn${club.clubNo}">종료</button>
								<button class="btn btn-flat" id="startBtn${club.clubNo}">시작</button>
						  </div>
						</td>
				</tr>`
        document.querySelector("#prod-list-body").appendChild(tr).innerHTML += str;
    }
}

// AJAX 요청을 처리하는 함수
function adminClubAjax() {
  console.log("sortType: ", sortType); 
  $.ajax({
      url: 'adminClubAjax.ad',
      //cpage와 sortType을 같이 보내줌
      data : {cpage: cpage++, sortType: sortType},
      success: function(clist){
        console.log(clist);
        cpage++;

          // AJAX 요청이 성공하면 페이지를 그리는 함수를 호출합니다.
          renderClubList(clist);   
          console.log("AJAX 요청 성공, 응답 데이터:", clist);
      },
      error: function(){
        console.log("ajax 실패");
        alert("요청이 실패했습니다");
      }
    });
  }