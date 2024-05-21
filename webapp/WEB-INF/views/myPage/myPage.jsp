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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/MyPage.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- 라이브러리 -->
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <div class="mypage-main">
            <!-- 유저 프로필 섹션 -->
            <div class="user-profile">
                <div class="profile-box">
                    <button class="btn-style">
                        <div class="profile-box1">
                            <!-- 프로필사진 -->
                            <img type="button" class="profile-img" src="${pageContext.request.contextPath}/img/profile.jpg" alt="">
                        </div>
                    </button>
                    <!-- 닉네임 및 계정이메일 -->
                    <div class="account">
                        <h5>떡꼬치대마왕 님</h5>
                        <h6>mocozygood@gmail.com</h6>

                        <!-- 포인트 -->
                        <div class="account point">
                            100,000pt
                            <button class="btn-style">충전</button>
                        </div>
                    </div>
                    
                </div>

                <!-- 매너점수 -->
                <div class="manner">
                    <img src="${pageContext.request.contextPath}/img/로고-떡떡떡.png" alt="">
                    <h6>매너점수</h6>
                    <div class="gauge">
                        <progress id="progress" value="36.5" min="0" max="100"></progress>
                    </div>
                </div>
            </div>
                
            <!-- 메뉴 네비 -->
            <div class="mypage-navi">
                <nav>
                    <ul id="main_menu">
                        <li><a href="${pageContext.request.contextPath}/MyPage.jsp">마이페이지</a></li>

                        <li><a href="${pageContext.request.contextPath}/MyProfile.jsp">내 프로필</a></li>

                        <li><a href="">소셜링 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/MySocial.jsp" class="snd_title">내가 만든 소셜링</a></li>
                                <li><a href="${pageContext.request.contextPath}/goSocial.jsp" class="snd_title">참여 중인 소셜링</a></li>
                            </ul>
                        </li>

                        <li><a href="" onclick="">챌린지 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/MyChallenge.jsp" class="snd_title">내가 만든 챌린지</a></li>
                                <li><a href="${pageContext.request.contextPath}/GoChallenge.jsp" class="snd_title">참여 중인 챌린지</a></li>
                            </ul>
                        </li>

                        <li><a href="">포인트</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">포인트 관리</a></li>
                                <li><a href="" class="snd_title">충전 내역</a></li>
                                <li><a href="" class="snd_title">사용 내역</a></li>
                            </ul>
                        </li>

                        <li><a href="">찜</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/dibs_social.jsp" class="snd_title">소셜링</a></li>
                                <li><a href="${pageContext.request.contextPath}/dibs_challenge.jsp" class="snd_title">챌린지</a></li>
                            </ul>
                        </li>

                        <li><a href="">리뷰</a></li>

                        <li><a href="">채팅기록</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        
        <div class="main-content">
            <h1>마이페이지</h1>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>내 최근 모임</h5>
                </div>
                <div class="club-content" onclick="location.href='이동할 링크주소(URL)';">
                    <div class="club-img">
                        <img src="./img/image 18.png" href="" alt="">
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
        </div>
    </div>
</body>
</html>