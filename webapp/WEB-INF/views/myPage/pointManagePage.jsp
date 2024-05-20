<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 관리페이지</title>
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
    padding: 50px;
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
        align-items: baseline;
    }
    .pointBox{
        width: 670px;
        height: 300px;
        border: 1px solid lightgray;
        border-radius: 10px;
        padding: 50px;
        margin: 0 auto;
    }
    .pointBox-head{
        display: flex;
        align-items: center;
    }
    .pointBox-mid{
        display: flex;
        align-items: center;
        justify-content: right;
    }
    .point-level{
        font-size: 40px;
        font-weight: 700;
    }
    .pointBox-foot{
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 100px;
    }
    .pointBox-foot > button{
        font-weight: 600;
    }
    .pointBox-foot > button:hover{
        cursor: pointer;
    }
    .chargeBtn{
        width: 220px;
        height: 60px;
        border: none;
        border-radius: 15px;
        font-size: 24px;
        background-color: #F0E3CE;
    }
    .withdrawBtn{
        width: 220px;
        height: 60px;
        border: none;
        border-radius: 15px;
        font-size: 24px;
        background-color: #70C9A0;
    }
    .currentHistory{
        width: 760px;
        margin: auto;
        border: none;
        background-color: #ECECEC;
        padding: 50px;
        border-radius: 20px;
    }
    .dateArea{
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 20px;
    }
    .chargeArea{
        font-size: 24px;
        padding: 30px 0;
    }
    .useArea{
        font-size: 24px;
        padding-top: 10px;
        padding-bottom: 20px;
    }
    .area-left{
        float: left;
    }
    .area-right{
        float: right;
    }
    .modal-footer{
        margin: auto;
        width: 100%;
        margin-top: 20px;
    }
    .modal-footer > button{
        background-color: #9BCFFF;
        border: none;
    }
    .modal-footer > button:hover{
        background-color: #9BCFFF;
    }
    input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    .modal-content{
        padding: 20px;
        border-radius: 10px;
    }
    .modal-body{
        padding: 20px;
    }
    .modal-body > label{
        font-size: 20px;
        font-weight: 600;
        margin-left: 5px;
        margin-top: 10px;
    }
    #directAmount{
        margin-left: 20px;
        width: 85%;
        border: 1px solid darkgray;
        border-radius: 5px;
        box-shadow: 1px 2px 3px darkgray;
        padding-left: 10px;
    }
    #directAmount:focus{
        outline: none;
    }
    .modal-footer{
        display: flex;
        justify-content: center;
    }
    .modal-footer > button{
        width: 70%;
    }
    .body-row1{
        display: flex;
        justify-content: space-between;
        font-size: 20px;
        font-weight: 600;
        margin-bottom: 50px;
    }
    .body-row2{
        display: flex;
        justify-content: space-between;
        font-size: 20px;
        font-weight: 600;
    }
    #point-input{
        width: 100%;
        border: 1px solid darkgray;
        border-radius: 5px;
        box-shadow: 1px 2px 3px darkgray;
        padding-left: 10px;
    }
    #point-input:focus{
        outline: none;
    }
    .point-opt{
        font-size: 14px;
        font-weight: 400;
        display: flex;
        justify-content: space-between;
        margin-top: 5px;
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
                            <img class="profile" src="resources/프사.jpg"  data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
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
                <h2>포인트 관리</h2>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;"><br><br>
            <div class="pointBox">
                <div class="pointBox-head">
                    <img src="resources/coin.png">
                    <p style="font-size: 24px; margin-left: 5px; font-weight: 650;">잔여 포인트</p>
                </div>
                <div class="pointBox-mid">
                    <p class="point-level">110,000,000,000pt</p>
                </div>
                <div class="pointBox-foot">
                    <button type="button" class="chargeBtn" data-toggle="modal" data-target="#chargeWindow">충 전</button>
                    <button type="button" class="withdrawBtn" data-toggle="modal" data-target="#withdrawWindow">출 금</button>
                </div>
            </div><br><br>

            <div class="main-content-head">
                <h2>최근 이용 내역</h2>
                <p style="color: darkgray; margin-left: 10px;">(최근 한 달간)</p>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;" ><br>
            <div class="currentHistory">
                <div class="dateArea">
                    <span>2024.04</span>
                </div>
                <div class="chargeArea">
                    <span class="area-left">충전 내역</span>
                    <span class="area-right">1,620,000pt</span>
                </div><br>
                <div class="useArea">
                    <span class="area-left">사용 내역</span>
                    <span class="area-right">-1,620,000pt</span>
                </div>
            </div>
        </div>
    </div>

    <!-- The Modal -->
    <div class="modal" id="chargeWindow">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">얼마나 충전할까요?</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <input type="radio" name="chargeMoney" id="btn100"><label for="btn100">100만원</label><br>
                    <input type="radio" name="chargeMoney" id="btn50"><label for="btn50">50만원</label><br>
                    <input type="radio" name="chargeMoney" id="btn20"><label for="btn20">20만원</label><br>
                    <input type="radio" name="chargeMoney" id="btn10"><label for="btn10">10만원</label><br>
                    <input type="radio" name="chargeMoney" id="btn1"><label for="btn1">1만원</label><br>
                    <input type="radio" name="chargeMoney" id="directInput"><label for="directInput">직접 입력하기</label><br>
                    <input type="number" id="directAmount" placeholder="숫자만 입력해주세요" disabled>
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">충전하기</button>
                </div>
                
            </div>
        </div>
    </div>
    <!-- The Modal -->
    <div class="modal" id="withdrawWindow">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">얼마를 출금할까요?<sub style="font-size: 12px; color: darkgray;">(1pt당 1원)</sub></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="body-row1">
                        <span>잔여 포인트</span>
                        <div>
                            <span id="remaining-point">110000</span>
                            <span>pt</span>
                        </div>
                    </div>
                    <div class="body-row2">
                        <span>금액 입력</span>
                        <div class="point-area">
                            <input type="number" id="point-input">
                            <div class="point-opt">
                                <div>
                                    <input type="checkbox" id="widthdrawAll"> 전액 출금
                                </div>
                                <span>※ 출금 수수료 10%</span>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">출금하기</button>
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

        const radioButtons = document.querySelectorAll('input[name="chargeMoney"]');
        const directAmountInput = document.getElementById('directAmount');

        radioButtons.forEach(radio => {
            radio.addEventListener('change', () => {
                if (document.getElementById('directInput').checked) {
                    // directInput이 체크되면 숫자 입력 필드 활성화
                    directAmountInput.disabled = false;
                } else {
                    // 그렇지 않으면 숫자 입력 필드 비활성화
                    directAmountInput.disabled = true;
                    document.getElementById('directAmount').value = '';
                }
            });
        });

        const widthdrawAll = document.getElementById('widthdrawAll');
        const pointInput = document.getElementById('point-input');
        const remainingPoint = document.getElementById('remaining-point').innerText;

        widthdrawAll.addEventListener('change', () => {
            if (widthdrawAll.checked) {
                pointInput.value = remainingPoint;
            } else {
                pointInput.value = '';
            }
        });
    </script>
</body>
</html>