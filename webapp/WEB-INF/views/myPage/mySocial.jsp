<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 내 소셜링</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/social.css" />

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
                <h1>소셜링 관리</h1>
                <h3>내가 만든 소셜링</h3>
                
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
                    <img src="./img/image 22.png" alt="">
                </div>
                <div class="club-title" onclick="location.href='이동할 링크주소(URL)';">
                    <h4>선착순 10분!! 상품은....함정카드 발동!</h4>
                    <p>들어오지 않고는 못베길거야</p>
                </div>
                <div class="status">
                    
                        <div class="mozip">
                            <p>모집중(18/20)</p>
                        </div>
                    
                    <div class="btn">
                        <button class="btn-style btn-color1">수정</button>
                        <button class="btn-style btn-color2">삭제</button>
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
                    
                        <div class="mozip">
                            <p>모집중(18/20)</p>
                        </div>
                    
                    <div class="btn">
                        <button class="btn-style btn-color1">수정</button>
                        <button class="btn-style btn-color2">삭제</button>
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
                    
                        <div class="mozip">
                            <p>모집중(18/20)</p>
                        </div>
                    
                    <div class="btn">
                        <button class="btn-style btn-color1">수정</button>
                        <button class="btn-style btn-color2">삭제</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>