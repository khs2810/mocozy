<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 신청 내역 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    *{
        box-sizing: border-box;
    }
    body{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    #contentBox{
        border: 1px solid #F6EEE2;
        width: 900px;
        height: 100%;
        padding: 10px 30px;
        overflow-y: auto;
    }
    .clubList{
        width: 85%;
        margin: auto;
        margin-bottom: 50px;
    }
    .titlePart{
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-bottom: 10px;
    }
    .title{
        font-size: 20px;
        display: flex;
    }
    .ing{
        display: flex;
        align-items: center;
        justify-content: center;
        width: 135px;
        height: 30px;
        border: 2px solid #14A307;
        border-radius: 5px;
        color: #14A307;
    }
    .done{
        display: flex;
        align-items: center;
        justify-content: center;
        width: 135px;
        height: 30px;
        border: 2px solid #FFB800;
        border-radius: 5px;
        color: #FFB800;
    }
    .clubRequestList > div{
        border-radius: 5px;
    }
    .selectedClubRequest{
        border: none;
        background-color: #F6EEE2;
        padding: 20px;
    }
    .clubRequest{
        border: 1px solid #D9D9D9;
        border-top: none;
        padding: 20px;
    }
    .profileImg{
        width: 50px;
        border-radius: 50%;
        margin-right: 10px;
    }
    .userId{
        font-size: 20px;
    }
    .writeTime{
        font-size: 12px;
        color: #545454;
    }
    .reduceBtn{
        background-color: white;
        border: none;
        font-size: 20px;
        margin-left: 15px;
    }
    .simpleInfo{
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .simpleInfoLeft{
        display: flex;
        align-items: center;
        justify-content: left;
    }
    .simpleInfoRight{
        display: flex;
        align-items: center;
        justify-content: right;
    }
    .btns{
        display: flex;
        align-items: center;
        justify-content: right;
        gap: 20px;
        margin-right: 15px;
    }
    .denyBtn{
        border: none;
        background-color: #F28C8C;
        width: 70px;
        height: 30px;
        color: white;
        font-size: 18px;
        font-weight: 600;
        border-radius: 15%;
    }
    .acceptBtn{
        border: none;
        background-color: #7CCDA6;
        width: 70px;
        height: 30px;
        color: white;
        font-size: 18px;
        font-weight: 600;
        border-radius: 15%;
    }
    .acceptedBtn{
        border: none;
        background-color: #7CCDA6;
        width: 100px;
        height: 30px;
        color: white;
        font-size: 18px;
        font-weight: 600;
        border-radius: 15%;
        margin-right: 30px;
    }
    .status_w{
        width: 30px;
        margin-left: 10px;
        color: #FFB800;
    }
    .status_a{
        width: 25px;
        margin-left: 10px;
    }
    .status_d{
        width: 20px;
        margin-left: 10px;
        background-color: none;
    }
    button:hover{
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
    <div id="contentBox">
        <h2>모임 신청 목록</h2>
        <hr style="background: lightgray; height: 1px; border: 0;" >
        <br><br>
        <div class="clubList">
            <div class="titlePart">
                <span class="title">♥블랙라이어♥:: with.하이볼 무제한🍺</span>
                <div class="ing">모집중(18/20)</div>
            </div>
            <div class="clubRequestList">
                <div class="selectedClubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="resources/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치대마왕</b>
                            <img src="resources/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 09:40</span>
                            <button type="button" class="reduceBtn" style="background-color: #F6EEE2;">︿</button>
                        </div>
                    </div>
                    <div class="detailInfo">
                        <pre class="detail">    [질문] 나이 / 성별 / 직업 / MBTI 를 작성해주세요 ✨
            (블랙라이어 지원하실 분은 요기에 남겨주세용💌)

    [대답] 26살 / 남자 / 홈프로텍터 / ESFJ</pre>
                        <div class="btns">
                            <button type="button" class="denyBtn">거절</button>
                            <button type="button" class="acceptBtn">수락</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="resources/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치중마왕</b>
                            <img src="resources/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 10:31</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="resources/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치소마왕</b>
                            <img src="resources/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 10:48</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clubList">
            <div class="titlePart">
                <span class="title">【D-2🐥어른이날】 천지방축 운동회</span>
                <div class="done">모집완료(50/50)</div>
            </div>
            <div class="clubRequestList">
                <div class="selectedClubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="resources/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치대마왕</b>
                            <img src="resources/accepted.png" class="status_a">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.04.16 00:12</span>
                            <button type="button" class="reduceBtn" style="background-color: #F6EEE2;">︿</button>
                        </div>
                    </div>
                    <div class="detailInfo">
                        <pre class="detail">    [질문] 1. 성별  2. 나이  3. MBTI  4. 관심종목  5. 운동신경 1~10
    
    [대답] 1. 남자  2. 26살  3. ESFJ  4. 구기종목  5. 운동신경 6</pre>
                        <div class="btns">
                            <button type="button" class="acceptedBtn">수락됨</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="resources/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치중마왕</b>
                            <img src="resources/denied.png" class="status_d">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.04.17 17:09</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
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
</body>
</html>