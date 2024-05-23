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
        <!-- 마이페이지 공용 코드 -->
        <div class="mypage-main">
            <!-- 유저 프로필 섹션 -->
            <div class="user-profile">
                <div class="profile-box">
                    <button class="btn-style">
                        <!-- 프로필사진 -->
                        <div class="profile-box1" style="background: #BDBDBD;">
                            <img class="profile profile-img" src="${pageContext.request.contextPath}/resources/koo/upfile/common_img/profile.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
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
                    <img src="${pageContext.request.contextPath}/resources/koo/upfile/myPage_img/로고-떡떡떡.png" alt="">
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
                        <li><a href="myPage.me">마이페이지</a></li>

                        <li><a href="myProfile.me">내 프로필</a></li>

                        <li><a href="">소셜링 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="mySocial.me" class="snd_title">내가 만든 소셜링</a></li>
                                <li><a href="goSocial.me" class="snd_title">참여 중인 소셜링</a></li>
                            </ul>
                        </li>

                        <li><a href="" onclick="">챌린지 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="myChallenge.me" class="snd_title">내가 만든 챌린지</a></li>
                                <li><a href="goChallenge.me" class="snd_title">참여 중인 챌린지</a></li>
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
                                <li><a href="dibsSocial.me" class="snd_title">소셜링</a></li>
                                <li><a href="dibsChallenge.me" class="snd_title">챌린지</a></li>
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
            
        <!-- The Modal -->
        <div class="modal fade" id="profileModal">
            <div class="modal-dialog">
                <div class="profile-modal-content">
                
                    <!-- Modal Header -->
                    <div class="profile-modal-header">
                        <button type="button" class="close" data-dismiss="modal">×</button>
                    </div>
                    
                    <!-- Modal body -->
                    <div class="profile-modal-body">
                        <div class="m-userProfile">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="m-profileImg">
                            <span class="nickname">떡꼬치대마왕</span>
                            <span> 님</span>
                        </div>
                        <div class="m-manner">
                            <img src="${pageContext.request.contextPath}/resources/koo/upfile/myPage_img/로고-떡떡떡.png" class="m-logo-area">
                            <div class="m-manner-area">
                                <span>매너 점수</span>
                                <div class="m-manner-score-area">
                                    <div class="m-score-range">
                                        <p>0</p>
                                        <p>100</p>
                                    </div>
                                    <progress id="progress" value="36.5" min="0" max="100"></progress>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Modal footer -->
                    <div class="profile-modal-bottom">
                        <h6 style="font-size: 20px; font-weight: 600; margin: 10px 30px;">자기소개</h6>
                        <textarea class="m-introduction"></textarea>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>