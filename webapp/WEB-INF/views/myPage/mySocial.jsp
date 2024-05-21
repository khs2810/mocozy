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
    <link rel="stylesheet" href="${pageContext.request.contextPath}./basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}./social.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!--Get your code at fontawesome.com-->
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/MyPage.js"></script>
    
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