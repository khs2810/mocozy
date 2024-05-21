<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 목록 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/memberListPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/memberListPage.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <div class="mypage-main">
            <div class="user-profile">
                <div class="box">
                    <div>
                        <!-- 프로필사진 -->
                        <div class="box1" style="background: #BDBDBD;">
                            <img class="profile" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        </div>
                    </div>
                    <div>
                        <!-- 닉네임 및 계정이메일 -->
                        <div class="account">
                            <p>떡꼬치대마왕 님</p>
                            mocozygood@gmail.com
                        </div>

                        <!-- 포인트 -->
                        <div class="account point">
                            <p>100,000pt</p>
                            <button>충전</button>
                        </div>
                    </div>
                </div>
                <!-- 매너점수 -->
                <div class="manner">
                    <img src="./img/로고-떡떡떡.png" alt="">
                    <p>매너점수</p>
                    <div class="gauge">
                        <progress id="progress" value="36.5" min="0" max="100"></progress>
                    </div>
                </div>
            </div>
                
            
            <!-- 메뉴 네비 -->
            <div class="mypage-navi">
                <nav>
                    <ul id="main_menu">
                        <li><a href="./MyPage01.html">마이페이지</a></li>
                        <hr>

                        <li><a href="./MyPage02.html">내 프로필</a></li>
                        <hr>

                        <li><a href="">소셜링 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="./MySocial.html" class="snd_title">내가 만든 소셜링</a></li>
                                <li><a href="./goSocial.html" class="snd_title">참여 중인 소셜링</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="" onclick="">챌린지 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">내가 만든 챌린지</a></li>
                                <li><a href="" class="snd_title">참여 중인 챌린지</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="">포인트</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">포인트 관리</a></li>
                                <li><a href="" class="snd_title">충전 내역</a></li>
                                <li><a href="" class="snd_title">사용 내역</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="">찜</a></li>
                        <hr>

                        <li><a href="">리뷰</a></li>
                        <hr>

                        <li><a href="">채팅기록</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        
        <div class="main-content">
            <div class="main-content-head">
                <div class="main-content-head-left">
                    <h2>멤버 목록</h2>
                    <p>발로 개발</p>
                </div>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;">
            <div class="member-list">
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/crown.png">
                        <p>파티장</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀이지롱 오고싶지?</p>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원1</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                </div>
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
                            <img src="${pageContext.request.contextPath}/resources/jun/img/로고.png" class="m-logo-area">
                            <div class="m-manner-area">
                                <span>매너 점수</span>
                                <div class="m-manner-score-area">
                                    <div class="m-score-range">
                                        <p>0</p>
                                        <p>100</p>
                                    </div>
                                    <div class="m-manner-score"></div>
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