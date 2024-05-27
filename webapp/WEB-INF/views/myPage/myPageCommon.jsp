<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 마이페이지</title>
    
</head>
<body>
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
                <h5>${loginUser.nickname}</h5>
                <h6>${loginUser.userId}</h6>

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
                <li><a href="reviewList.cl">리뷰</a></li>
                <li><a href="">채팅기록</a></li>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>