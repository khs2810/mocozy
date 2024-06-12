// 슬라이드 너비 호출
  const mainSlide = document.querySelector(".slide");
  const mainSlideWidth = mainSlide.clientWidth;

  // 버튼 엘리먼트 호출
  const mainPrevBtn = document.querySelector(".prev");
  const mainNextBtn = document.querySelector(".next");

  // 슬라이드 전체 호출
  let mainSlideItems = document.querySelectorAll("#item");
  const mainMaxSlide = mainSlideItems.length;

  //현재 슬라이드 변수
  let mainCurrSlide = 1;

  //start, end 무한 슬라이드 배열 생성
  const mainStartSlide = mainSlideItems[0];
  const mainEndSlide = mainSlideItems[mainSlideItems.length - 1];
  const mainStartElem = document.createElement("div");
  const mainEndElem = document.createElement("div");

  // endSlide의 모든 클래스를 endElem에 추가
  // 배열 안의 클래스를 endslide에 저장
  mainEndSlide.classList.forEach((c) => mainEndElem.classList.add(c));
  mainEndElem.innerHTML = mainEndSlide.innerHTML;

  mainStartSlide.classList.forEach((c) => mainStartElem.classList.add(c));
  mainStartElem.innerHTML = mainStartSlide.innerHTML;

  // 첫 번째 슬라이드 앞에 endElem 추가
  mainSlideItems[0].before(mainEndElem);

  // 마지막 슬라이드 뒤에 startElem 추가
  mainSlideItems[mainSlideItems.length - 1].after(mainStartElem);

  // "item" id를 가진 모든 요소를 선택
  mainSlideItems = document.querySelectorAll("#item");

  // 현재 슬라이드의 위치를 계산
  let mainOffset = mainSlideWidth * mainCurrSlide;

  //foreach를 사용해 슬라이드 아이템의 left에 offset 적용
  //현재 슬라이드가 음수이기 때문에 왼쪽으로 이동
  mainSlideItems.forEach((i) => {
    i.setAttribute("style", `left: ${-mainOffset}px`);
  });

  //다음 슬라이드로 이동하는 함수
  function mainNextMove() {
    //현재 슬라이드 증가
    mainCurrSlide++;
    //현재 슬라이드가 전체 슬라이드 갯수보다 작거나 같을 때
    if (mainCurrSlide <= mainMaxSlide) {
      //슬라이드 아이템의 left에 offset 적용
      //const로 변수 재선언
      const mainOffset = mainSlideWidth * mainCurrSlide;
      mainSlideItems.forEach((i) => {
        i.setAttribute("style", `left: ${-mainOffset}px`);
      });      
    } else {
      // 무한 슬라이드 기능
      mainCurrSlide = 0;
      let mainOffset = mainSlideWidth * mainCurrSlide;
      mainSlideItems.forEach((i) => {
        i.setAttribute("style", `transition: ${0}s; left: ${-mainOffset}px`);
      });

      mainCurrSlide++;
      mainOffset = mainSlideWidth * mainCurrSlide;

      setTimeout(() => {
        //슬라이드 아이템들에 transition 속성, offset 적용
        mainSlideItems.forEach((i) => {
          i.setAttribute("style", `transition: ${0.15}s; left: ${-mainOffset}px`);
        });
      }, 0);
    }
  }


//이전 슬라이드로 이동하는 함수
function mainPrevMove() {
  mainCurrSlide--;
  // 현재 슬라이드가 0보다 클 때
  if (mainCurrSlide > 0) {
    const mainOffset = mainSlideWidth * mainCurrSlide;
    // 각 슬라이드 아이템의 left에 offset 적용
    mainSlideItems.forEach((i) => {
      i.setAttribute("style", `left: ${-mainOffset}px`);
    });
  } else {
    mainCurrSlide = mainMaxSlide + 1;
    let mainOffset = mainSlideWidth * mainCurrSlide;
    mainSlideItems.forEach((i) => {
      i.setAttribute("style", `transition: ${0}s; left: ${-mainOffset}px`);
    });

    // 현재 슬라이드 감소
    mainCurrSlide--;
    // 슬라이드 이동을 위한 offset 계산
    //offset = 현재 슬라이드 위치
    mainOffset = mainSlideWidth * mainCurrSlide;

    // 0초 뒤에 트랜지션, offset 적용
    setTimeout(() => {
      mainSlideItems.forEach((i) => {
        i.setAttribute("style", `transition: ${0.15}s; left: ${-mainOffset}px`);
      });
    }, 0);
  }
}

//다음 버튼 늘릴경우 페이지 이동
mainNextBtn.addEventListener("click", () => {
  mainNextMove();
});

//이전 버튼 누를 경우 페이지 이동
mainPrevBtn.addEventListener("click", () => {
  mainPrevMove();
});

// 브라우저 창의 크기가 변경될 때마다 이벤트 리스너 추가
window.addEventListener("resize", () => {
  // 슬라이드의 너비 업데이트
  mainSlideWidth = mainSlide.clientWidth;
});


// PC 드래그 이벤트를 위한 변수 초기화
let mainStartPoint = 0;
let mainEndPoint = 0;

// 마우스 드래그 이벤트
mainSlide.addEventListener("mousedown", (e) => {
  // 마우스 드래그 위치 저장
  mainStartPoint = e.pageX;
});

mainSlide.addEventListener("mouseup", (e) => {
  //마우스 끝 위치 저장
  mainEndPoint = e.pageX;
  //오른쪽으로 드래그 된 경우
  if (mainStartPoint < mainEndPoint) {
    mainPrevMove();
    //왼쪽으로 드래그 된 경우
  } else if (mainStartPoint > mainEndPoint) {
    mainNextMove();
  }
});

//모바일 사이즈 드래그 (터치 이벤트)
mainSlide.addEventListener("touchstart", (e) => {
  //터치 위치 저장
  mainStartPoint = e.touches[0].pageX;
});
mainSlide.addEventListener("touchend", (e) => {
  // 터치가 끝나는 위치 저장
  mainEndPoint = e.changedTouches[0].pageX;
  //오른쪽으로 클릭 된 경우
  if (mainStartPoint < mainEndPoint) {
    mainPrevMove();
    //왼쪽으로 클릭 된 경우
  } else if (mainStartPoint > mainEndPoint) {
    mainNextMove();
  }
});

//3초마다 nextMove 함수 호출하여 무한반복
let mainLoopInterval = setInterval(() => {
  mainNextMove();
}, 3000);

// 슬라이드에 마우스가 올라간 경우 루프 멈추기
mainSlide.addEventListener("mouseover", () => {
  clearInterval(mainLoopInterval);
});

// 슬라이드에서 마우스가 나온 경우 루프 재시작
mainSlide.addEventListener("mouseout", () => {
  mainLoopInterval = setInterval(() => {
    mainNextMove();
  }, 3000);
});