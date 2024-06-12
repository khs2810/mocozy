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
                    <img class="profile profile-img" src="${pageContext.request.contextPath}${loginUser.profileImg}" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                </div>
            </button>
            <!-- 닉네임 및 계정이메일 -->
            <div class="account">
                <h5>${loginUser.nickname}</h5>
                <h6>${loginUser.userId}</h6>

                <!-- 포인트 -->
                <div class="account point">
                    <span id="money">${loginUser.point}</span><span>pt</span>
                    <button type="button" class="btn-style" data-toggle="modal" data-target="#chargeWindow">충전</button>
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
            <ul class="main_menu">
                <li class="main_menu1"><a class="main_menu2" href="myPage.me">마이페이지</a></li>
                <li class="main_menu1"><a class="main_menu2" href="myProfile.me">내 프로필</a></li>
                <li class="main_menu1"><a class="main_menu2" href="">소셜링 관리</a>
                    <ul class="main_menu snd_menu sub_menu">
                        <li><a href="mySocial.me" class="main_menu2 snd_title">내가 만든 소셜링</a></li>
                        <li><a href="goSocial.me" class="main_menu2 snd_title">참여 중인 소셜링</a></li>
                    </ul>
                </li>
                <li class="main_menu1"><a class="main_menu2" href="" onclick="">챌린지 관리</a>
                    <ul class="main_menu snd_menu sub_menu">
                        <li><a href="myChallenge.me" class="main_menu2 snd_title">내가 만든 챌린지</a></li>
                        <li><a href="goChallenge.me" class="main_menu2 snd_title">참여 중인 챌린지</a></li>
                    </ul>
                </li>
                <li class="main_menu1"><a class="main_menu2" href="">포인트</a>
                    <ul class="main_menu snd_menu sub_menu">
                        <li><a href="manage.po" class="main_menu2 snd_title">포인트 관리</a></li>
                        <li><a href="chargeHistory.po" class="main_menu2 snd_title">충전 내역</a></li>
                        <li><a href="useHistory.po" class="main_menu2 snd_title">사용 내역</a></li>
                    </ul>
                </li>
                <li class="main_menu1"><a class="main_menu2" href="">찜</a>
                    <ul class="main_menu snd_menu sub_menu">
                        <li><a href="dibsSocial.me" class="main_menu2 snd_title">소셜링</a></li>
                        <li><a href="dibsChallenge.me" class="main_menu2 snd_title">챌린지</a></li>
                    </ul>
                </li>
                <li class="main_menu1"><a class="main_menu2" href="reviewList.cl">리뷰</a></li>
                <li class="main_menu1"><a class="main_menu2" href="list.ch">채팅</a></li>
            </ul>
        </nav>
    </div>
</div>

<!-- The Modal -->
<div class="modal" id="chargeWindow">
    <div class="modal-dialog">
        <div class="modal-content">
            <form type="POST" action="charge.pt">
                <input type="hidden" name="userNo" value="${loginUser.userNo}">
                <input type="hidden" name="userId" value="${loginUser.userId}">
                <input type="hidden" name="userPwd" value="${loginUser.userPwd}">
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">얼마나 충전할까요?</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <input type="radio" name="point" id="btn100" value="1000000"><label for="btn100">100만원</label><br>
                    <input type="radio" name="point" id="btn50" value="500000"><label for="btn50">50만원</label><br>
                    <input type="radio" name="point" id="btn20" value="200000"><label for="btn20">20만원</label><br>
                    <input type="radio" name="point" id="btn10" value="100000"><label for="btn10">10만원</label><br>
                    <input type="radio" name="point" id="btn1" value="10000"><label for="btn1">1만원</label><br>
                    <input type="radio" name="point" id="directInput"><label for="directInput">직접 입력하기</label><br>
                    <input type="number" id="directAmount" placeholder="숫자만 입력해주세요" disabled>
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >충전하기</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>