<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 마이페이지</title>

    <!-- css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/challengeManagePage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/challengeManagePage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/MyPage.css" />
    

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        
        <%@ include file="myPageCommon.jsp" %>
        
        <div class="main-content">
            <h1>마이페이지</h1>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>내 최근 모임</h5>
                </div>
                <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                    <div class="club-img">
                        <img src="${pageContext.request.contextPath}/resources/koo/upfile/club_img/clubImg1.png" href="(해당 클럽상세)" alt="">
                    </div>
                    <div class="wrap">
                        <p class="club-title club-text">♥블랙라이어♥:: with.하이볼 무제한🍺</p>
                    </div>
                </div>
                <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                    <div class="club-img">
                        <img src="./img/image 19.png" alt="">
                    </div>
                    <div class="wrap">
                        <p class="club-title club-text">밥을 먹는 사람들</p>
                    </div>
                </div>
                <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                    <div class="club-img">
                        <img src="./img/image 22.png" alt="">
                    </div>
                    <div class="wrap">
                        <p class="club-title club-text">선착순 10분!! 상품은</p>
                    </div>
                </div>
                <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                    <div class="club-img">
                        <img src="./img/image 21.png" alt="">
                    </div>
                    <div class="wrap">
                        <p class="club-title club-text">리액트 때려부셔버리겠어 으아아아아아</p>
                    </div>
                </div>
            </div>
            <hr>

            <div>
                <div class="main-object dibs">
                    <div class="content-title">
                        <h5>찜</h5>
                    </div>
                    <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                        <div class="club-img">
                            <img src="./img/image 18.png" alt="">
                        </div>
                        <div class="wrap">
                            <div class="club-title" data-hover="♥블랙라이어♥:: with.하이볼 무제한🍺">♥블랙라이어♥:: with.하이볼 무제한🍺</div>
                        </div>
                    </div>
                    <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                        <div class="club-img">
                            <img src="./img/image 19.png" alt="">
                        </div>
                        <div class="wrap">
                            <p class="club-title club-text">밥을 먹는 사람들</p>
                        </div>
                    </div>
                    <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                        <div class="club-img">
                            <img src="./img/image 22.png" alt="">
                        </div>
                        <div class="wrap">
                            <p class="club-title club-text">선착순 10분!! 상품은</p>
                        </div>
                    </div>
                    <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                        <div class="club-img">
                            <img src="./img/image 21.png" alt="">
                        </div>
                        <div class="wrap">
                            <p class="club-title club-text">리액트 때려부셔버리겠어 으아아아아아</p>
                        </div>
                    </div>
                </div>
            </div>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>포인트 이용 내역</h5>
                </div>
                <div class="line-chart">
                    여긴 그래프 넣을거임
                </div>
            </div>
            
            <!-- 프로필 모달 -->
            <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>