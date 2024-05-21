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
<style>
    * {
        box-sizing: border-box;
    }

    /* 마이페이지 전체 */
    .MyPage-body{
        box-sizing: border-box;
        position: relative;
        width: 1250px;
        height: 100%;
        margin: auto;
        top: 150px;
        display: flex;
        justify-content: space-between;
    }
    /* 좌측 */
    .mypage-main{
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        max-width: 100%;
    }

    .user-profile{
        box-sizing: border-box;
        width: 330px;
        height: 200px;
        background-color: #D9D9D9;
        border-radius: 15px;
        padding: 3%;
    }

    .box{
        box-sizing: border-box;
        display: flex;
        align-items: center;
    }
    .box1 {
        box-sizing: border-box;
        width: 91px;
        height: 91px; 
        border-radius: 70%;
        overflow: hidden;
    }
    .profile {
        width: 91px;
        height: 91px;
        object-fit: cover;
    }
    .account{
        box-sizing: border-box;
        padding-left: 20px;
        line-height: 0.5em;
    }

    .account>p {
        font-size: larger;
        font-weight: bolder;
    }
    .point{
        display: flex;
        margin-top: 2rem;
        justify-content: space-between;
        align-items: center;
    }
    .point>button{
        border-style: none;
        width: 72px;
        height: 30px;
        border-radius: 10px;
        background-color: #F0E3CE;
        font-weight: 700;
        box-shadow: 2px 2px 2px black;
        transition-duration: 0.1s;
        cursor: pointer;
    }

    button:active{
        margin-left: 5px;
        margin-top: 5px;
        box-shadow: none;
    }


    .manner{
        box-sizing: border-box;
        margin: 20px 0px;
        width: 100%;
        display: flex;
        align-items: center;
    }
    .manner>img{
        margin-right: 5px;
    }
    .manner>p{
        font-weight: bolder;
    }


    #progress {
        appearance: none;
        margin-left: 10px;
    }
    #progress::-webkit-progress-bar {
        background:#f0f0f0;
        border-radius:10px;
        box-shadow: inset 3px 3px 10px #fffdfd;
    }
    #progress::-webkit-progress-value {
        border-radius:10px;
        background: #F08A8A;
        /* background: -webkit-linear-gradient(to right, #93F9B9, #1D976C); */
        /* background: linear-gradient(to right, #93F9B9, #1D976C); */

    }

    /* 네비 메뉴바 */
    .mypage-navi{
        box-sizing: content-box;
    }

    nav{
        /* border: 1px solid blue; */
        box-sizing: border-box;
        margin-top: 20px;
        width: 100%;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 100%;
        /* background-color: #f1f1f1; */
        position: relative;
        height: 100%;
        overflow: auto;
    }

    li {
        list-style: none;
        line-height: 34px;
    }

    ul li a {
    display: block;
    color: #000;
    height: 50px;
    padding: 8px 16px;
    text-decoration: none;
    align-content: center;
    justify-content: space-between;
    }

    ul li a.active {
    background-color: #555;
    color: white;
    }
    
    ul li a:hover:not(.active) {
    background-color: #7a7a7a;
    color: white;
    }

    .snd_menu { background: #efefef; }
    .sub_menu { display: none; }

    .snd_title{
        padding-left: 30px;
    }


    .main-content{
    box-sizing: border-box;
    border: 2px solid #D9D9D9;
    width: 905px;
    height: 100%;
    border-radius: 15px;
    padding: 20px;
    }

    hr{
        margin: 0;
    }
    .content-title{
        width: 170px;
    }
    .main-object{
        display: flex;
        align-items: center;
        margin: 15px 0px;
    }
    
    .club-content{
        width: 125px;
        display: flex;
        flex-direction: column;
        margin: 0px 20px;
        cursor: pointer;
    }
    .club-img img{
        box-sizing: border-box;
        border-radius: 15px;
    }
    .club-title{
        box-sizing: border-box;
        display: inline-block;
        width: 125px;
        padding: 10px;
        margin: 0px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .box{
        width: 180px;
    }

    .textbox{
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #8d8d8d;
        width: 100%;
        height: 30px;
    }

    .change>input{
        box-sizing: border-box;
        border-radius: 5px;
        border: none;
        background-color: #F28C8C;
        color: #ffffff;
        padding: 0px 20px ;
        height: 30px;
        margin: 30px;
    }

    .introduce{
        display: flex;
        flex-direction: row-reverse;
    }

    textarea{
        resize: none;
    }

    .edit-user{
        display: flex;
        flex-direction:row;
        justify-content: end;
    }

    .edit-user a{
        margin-inline-start: 30px;
        margin-top: 20px;
    }

    .title{
        display: flex;
        align-items: flex-end;
    }
    .title>h1{
        width: 400px;
    }
    .title>h3{
        width: 300px;
        margin: 20px;
    }
    .binbox{
        width: 100%;
    }
    .title-select{
        display: flex;
        align-items: flex-end;
        margin: 20px 0px;
    }

    select{
        border: 1px solid #8d8d8d;
        border-radius: 5px;
        width: 65px;
        height: 30px;
    }

    option{
        border: 1px solid #8d8d8d;
        border-radius: 5px;
    }

    .main-content-head{
        display: flex;
        align-items: center;
        margin: 0 20px;
    }
    .main-content-head-left{
        display: flex;
        align-items: baseline;
        gap: 20px;
    }
    .member-list{
        padding: 10px 30px;
        overflow-y: auto;
    }
    .member{
        display: flex;
        align-items: center;
    }
    .member-profile{
        width: 25%;
        display: flex;
        align-items: center;
        gap: 10px;
    }
    .profile-img{
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }
    .introduction{
        margin: 0 50px 0 10px;
    }
    .buttons > button:hover{
        cursor: pointer;
    }
    /* profile modal */
    .profile-modal-content{
        background-color: #F3F3F3;
        padding: 30px;
        padding-top: 0;
        border-radius: 10px;
    }
    .profile-modal-header{
        border: none;
        padding-bottom: 30px;
    }
    .m-userProfile{
        font-size: 24px;
    }
    .m-profileImg{
        width: 90px;
        height: 90px;
        border-radius: 50%;
        margin-right: 20px;
    }
    .profile-modal-body{
        border-bottom: 2px solid darkgray;
        padding-top: 0;
    }
    .m-manner{
        display: flex;
        align-items: center;
        margin: 30px 10px;
    }
    .m-manner > img{
        width: 70px;
        transform: rotate(120deg);
        margin-right: 30px;
    }
    .m-score-range{
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 15px;
    }
    .m-manner-area{
        display: flex;
    }
    .m-manner-score-area{
        margin-left: 10px;
    }
    .m-manner-score{
        width: 170px;
        height: 10px;
        background-color: #F48E8E;
        border-radius: 5px;
    }
    .profile-modal-bottom{
        margin-top: 10px;
    }
    .m-introduction{
        resize: none;
        width: 430px;
        height: 100px;
        border: none;
        border-radius: 15px;
        padding: 20px;
        background-color: #F0E3CE;
    }
    .m-introduction:focus{
        outline: none;
        border: none;
    }
</style>
</head>
<body>
    <div class="MyPage-body">
        <div class="mypage-main">
            <div class="user-profile">
                <div class="box">
                    <div>
                        <!-- 프로필사진 -->
                        <div class="box1" style="background: #BDBDBD;">
                            <img class="profile" src="resources/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
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
                        <img class="profile-img" src="resources/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <img src="resources/crown.png">
                        <p>파티장</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀이지롱 오고싶지?</p>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="resources/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
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
                            <img src="resources/프사.jpg" class="m-profileImg">
                            <span class="nickname">떡꼬치대마왕</span>
                            <span> 님</span>
                        </div>
                        <div class="m-manner">
                            <img src="resources/로고.png" class="m-logo-area">
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
    <script>
        $(document).ready(function(){
        // 메인 메뉴의 클릭 이벤트 처리
            $('#main_menu > li > a[href=""]').click(function(event){
                event.preventDefault();
                // 클릭한 메뉴의 다음에 오는 .snd_menu를 슬라이드 토글
                $(this).next('.snd_menu').slideToggle('fast');
            });

            // 서브 메뉴의 클릭 이벤트 처리
            $('.snd_menu > li > a').click(function(e){
                e.stopPropagation(); // 부모 요소의 클릭 이벤트 방지
                // 클릭한 서브 메뉴의 다음에 오는 .trd_menu를 슬라이드 토글
                $(this).next('.trd_menu').slideToggle('fast');
            });
        });
    </script>
</body>
</html>