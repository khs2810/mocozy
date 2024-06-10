// 슬라이드 너비 호출
const subslide = document.querySelector(".subslide");
const subslideWidth = subslide.clientWidth;

// 버튼 엘리먼트 호출
const subprevBtn = document.querySelector(".subprev");
const subnextBtn = document.querySelector(".subnext");

// 슬라이드 전체 호출
let subslideItems = document.querySelectorAll("#subitem");
const maxSubslide = subslideItems.length;

//현재 슬라이드 변수
let currSubslide = 1;

//start, end 무한 슬라이드 배열 생성
const startSubslide = subslideItems[0];
const endSubslide = subslideItems[subslideItems.length - 1];
const startSubElem = document.createElement("div");
const endSubElem = document.createElement("div");

// endSlide의 모든 클래스를 endElem에 추가
// 배열 안의 클래스를 endslide에 저장
endSubslide.classList.forEach((c) => endSubElem.classList.add(c));
endSubElem.innerHTML = endSubslide.innerHTML;

startSubslide.classList.forEach((c) => startSubElem.classList.add(c));
startSubElem.innerHTML = startSubslide.innerHTML;

// 첫 번째 슬라이드 앞에 endElem 추가
subslideItems[0].before(endSubElem);

// 마지막 슬라이드 뒤에 startElem 추가
subslideItems[subslideItems.length - 1].after(startSubElem);

// "item" id를 가진 모든 요소를 선택
subslideItems = document.querySelectorAll("#subitem");

// 현재 슬라이드의 위치를 계산
let offset = subslideWidth * currSubslide;

//foreach를 사용해 슬라이드 아이템의 left에 offset 적용
//현재 슬라이드가 음수이기 때문에 왼쪽으로 이동
subslideItems.forEach((i) => {
  i.setAttribute("style", `left: ${-offset}px`);
});

//다음 슬라이드로 이동하는 함수
function nextSubMove() {
  //현재 슬라이드 증가
  currSubslide++;
  //현재 슬라이드가 전체 슬라이드 갯수보다 작거나 같을 때
  if (currSubslide <= maxSubslide) {
    //슬라이드 아이템의 left에 offset 적용
    //const로 변수 재선언
    const offset = subslideWidth * currSubslide;
    subslideItems.forEach((i) => {
      i.setAttribute("style", `left: ${-offset}px`);
    });
  } else {
    // 무한 슬라이드 기능
    currSubslide = 0;
    let offset = subslideWidth * currSubslide;
    subslideItems.forEach((i) => {
      i.setAttribute("style", `transition: ${0}s; left: ${-offset}px`);
    });

    currSubslide++;
    offset = subslideWidth * currSubslide;

    setTimeout(() => {
      //슬라이드 아이템들에 transition 속성, offset 적용
        subslideItems.forEach((i) => {
          i.setAttribute("style", `transition: ${0.15}s; left: ${-offset}px`);
        });
      }, 0);
    }
  }


//이전 슬라이드로 이동하는 함수
function prevSubMove() {
  currSubslide--;
  // 현재 슬라이드가 0보다 클 때
  if (currSubslide > 0) {
    const offset = subslideWidth * currSubslide;
    // 각 슬라이드 아이템의 left에 offset 적용
    subslideItems.forEach((i) => {
      i.setAttribute("style", `left: ${-offset}px`);
    });
  } else {
    currSubslide = maxSubslide + 1;
    let offset = subslideWidth * currSubslide;
    subslideItems.forEach((i) => {
      i.setAttribute("style", `transition: ${0}s; left: ${-offset}px`);
    });

    // 현재 슬라이드 감소
    currSubslide--;
    // 슬라이드 이동을 위한 offset 계산
    //offset = 현재 슬라이드 위치
    offset = subslideWidth * currSubslide;

    // 0초 뒤에 트랜지션, offset 적용
    setTimeout(() => {
      subslideItems.forEach((i) => {
        i.setAttribute("style", `transition: ${0.15}s; left: ${-offset}px`);
      });
    }, 0);
  }
}

//다음 버튼 늘릴경우 페이지 이동
subnextBtn.addEventListener("click", () => {
  nextSubMove();
});

//이전 버튼 누를 경우 페이지 이동
subprevBtn.addEventListener("click", () => {
  prevSubMove();
});

// 브라우저 창의 크기가 변경될 때마다 이벤트 리스너 추가
window.addEventListener("resize", () => {
  // 슬라이드의 너비 업데이트
    subslideWidth = subslide.clientWidth;
});

// PC 드래그 이벤트를 위한 변수 초기화
let startPoint = 0;
let endPoint = 0;

// 마우스 드래그 이벤트
subslide.addEventListener("mousedown", (e) => {
  // 마우스 드래그 위치 저장
  startPoint = e.pageX;
});

subslide.addEventListener("mouseup", (e) => {
  //마우스 끝 위치 저장
  endPoint = e.pageX;
  //오른쪽으로 드래그 된 경우
  if (startPoint < endPoint) {
    prevSubMove();
    //왼쪽으로 드래그 된 경우
  } else if (startPoint > endPoint) {
    nextSubMove();
  }
});

//모바일 사이즈 드래그 (터치 이벤트)
subslide.addEventListener("touchstart", (e) => {
  //터치 위치 저장
  startPoint = e.touches[0].pageX;
});
subslide.addEventListener("touchend", (e) => {
  // 터치가 끝나는 위치 저장
  endPoint = e.changedTouches[0].pageX;
  //오른쪽으로 클릭 된 경우
  if (startPoint < endPoint) {
    prevSubMove();
    //왼쪽으로 클릭 된 경우
  } else if (startPoint > endPoint) {
    nextSubMove();
  }
});

//3초마다 nextMove 함수 호출하여 무한반복
let loopInterval = setInterval(() => {
  nextSubMove();
}, 3000);

// 슬라이드에 마우스가 올라간 경우 루프 멈추기
subslide.addEventListener("mouseover", () => {
  clearInterval(loopInterval);
});

// 슬라이드에서 마우스가 나온 경우 루프 재시작
subslide.addEventListener("mouseout", () => {
  loopInterval = setInterval(() => {
    nextSubMove();
  }, 3000);
});