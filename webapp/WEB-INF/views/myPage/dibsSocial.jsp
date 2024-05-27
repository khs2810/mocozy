<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜 - 소셜링</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/dibs.css" />

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!--Get your code at fontawesome.com-->
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    
    

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <!-- 메인 컨텐츠 부 전체-->
        <div class="main-content">
            <!-- 메인컨텐츠 타이틀 -->
            <div class="title">
                <h1>찜</h1>
                <h3>소셜링</h3>
                
                <!-- 셀렉버튼 -->
                <div class="title-select">
                    <select name="" id="">
                        <option value="">진행중</option>
                        <option value="">종료됨</option>
                    </select>
                </div> 
            </div>
            <hr>

            <!-- 컨텐츠 내용 -->
            <!-- 소셜링 목록 -->
            <div class="club-content container">
                <div class="club-img" onclick="location.href='이동할 링크주소(URL)';">
                    <img src="./img/image 18.png" alt="">
                </div>
                <div class="club-title" onclick="location.href='이동할 링크주소(URL)';">
                    <h4>♥블랙라이어♥:: with.하이볼 무제한🍺</h4>
                    <p>새로운 사람과 만나는 설렘과 도파민 터지는 시간 속
                        라이어를 찾아내는 블랙라이어파티에
                        일상에서 벗어나고픈 여러분들을 초대합니다 💌</p>
                </div>

                <div class="status">
                    <!-- 찜 -->
                    <div class="dibs">
                        <!-- <button class="btn" onclick="toggleAct(this)">찜하기</button> -->
                        <div class="club_picked"><i class="fa-regular fa-heart" style="color: red;"></i></div>
                    </div>
                    <div class="mozip">
                        <p>모집중(18/20)</p>
                    </div>
                </div>
            </div>

            <div class="club-content container">
                <div class="club-img" onclick="location.href='이동할 링크주소(URL)';">
                    <img src="./img/image 22.png" alt="">
                </div>
                <div class="club-title" onclick="location.href='이동할 링크주소(URL)';">
                    <h4>선착순 10분!! 상품은....함정카드 발동!</h4>
                    <p>들어오지 않고는 못베길거야</p>
                </div>
                <div class="status">
                    <!-- 찜 -->
                    <div class="dibs">
                        <!-- <button class="btn" onclick="toggleAct(this)">찜하기</button> -->
                        <div class="club_picked"><i class="fa-regular fa-heart" style="color: red;"></i></div>
                    </div>
                    <div class="mozip">
                        <p>모집중(18/20)</p>
                    </div>
                </div>
            </div>
            
            <div class="club-content container">
                <div class="club-img" onclick="location.href='이동할 링크주소(URL)';">
                    <img src="./img/image 21.png" alt="">
                </div>
                <div class="club-title" onclick="location.href='이동할 링크주소(URL)';">
                    <h4>리액트 때려부셔버리겠어 으아아아아아</h4>
                    <p>리액트와 원수진 사람 여기여기 모여라</p>
                </div>
                <div class="status">
                    <!-- 찜 -->
                    <div class="dibs">
                        <!-- <button class="btn" onclick="toggleAct(this)">찜하기</button> -->
                        <div class="club_picked"><i class="fa-regular fa-heart" style="color: red;"></i></div>
                    </div>
                    <div class="mozip">
                        <p>모집중(18/20)</p>
                    </div>
                </div>
            </div>

            <div class="club-content container">
                <div class="club-img" onclick="location.href='이동할 링크주소(URL)';">
                    <img src="./img/image 23.png" alt="">
                </div>
                <div class="club-title" onclick="location.href='이동할 링크주소(URL)';">
                    <h4>발로 개발</h4>
                    <p>개발... 그거슨... 전쟁같은 사랑....</p>
                </div>
                <div class="status">
                    <!-- 찜 -->
                    <div class="dibs">
                        <!-- <button class="btn" onclick="toggleAct(this)">찜하기</button> -->
                        <div class="club_picked"><i class="fa-regular fa-heart" style="color: red;"></i></div>
                    </div>
                    <div class="mozip">
                        <p>모집중(18/20)</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
</body>
</html>