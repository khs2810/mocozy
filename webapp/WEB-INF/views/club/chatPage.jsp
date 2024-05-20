<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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
        padding: 0px;
        border: 1px solid #F6EEE2;
        width: 900px;
        height: 85vh;
        overflow-y: auto;
        display: flex;
        justify-content: left;
    }
    .chatLists{
        background-color: #F0E3CE;
        width: 250px;
    }
    .chatList{
        padding: 5px 0px;
        display: flex;
        align-items: center;
        justify-content: left;
    }
    .chatList:hover{
        cursor: pointer;
        background-color: #E9D5B6;
    }
    .chatPage{
        width: 650px;
        position: relative;
    }
    .title{
        margin-left: 20px;
    }
    .chatCategory{
        color: gray;
        font-size: 15px;
        margin: 20px 0px 10px 20px;
    }
    .profile{
        margin-left: 20px;
        margin-right: 10px;
    }
    .profileImg{
        width: 40px;
        border-radius: 50%;
    }
    .chatSimple > div{
        font-size: 13px;
    }
    .chatDetail{
        overflow-y: auto;
        padding: 15px;
    }
    .chatInput{
        position: absolute;
        bottom: 5px;
        right: 12px;
        width: 625px;
        height: 130px;
        border: 2px solid lightgray;
        border-radius: 15px;
        padding: 10px;
    }
    #textArea{
        border: none;
        resize: none;
        width: 100%;
        height: 100%;
        font-size: 16px;
    }
    #textArea:focus{
        outline: none;
    }
    #submitBtn{
        width: 60px;
        height: 35px;
        font-size: 18px;
        border: none;
        background-color: #9BCFFF;
        border-radius: 5px;
        color: white;
        position: absolute;
        bottom: 10px;
        right: 15px;
    }
    button:hover{
        cursor: pointer;
    }
</style>
</head>
<body>
    <div id="contentBox">
        <div class="chatLists">
            <h2 class="title">내 채팅함</h2>
            <p class="chatCategory">1:1 상담</p>
            <div class="chatList">
                <div class="profile">
                    <img src="resources/타노스.png" class="profileImg">
                </div>
                <div class="chatSimple">
                    <div class="chatTitle">모꼬지 상담요원</div>
                    <div class="chatContent">안녕하세요</div>
                </div>
            </div>
            <p class="chatCategory">모임 채팅</p>
            <div class="chatList">
                <div class="profile">
                    <img src="resources/프사.jpg" class="profileImg">
                </div>
                <div class="chatSimple">
                    <div class="chatTitle">♥블랙라이어♥...</div>
                    <div class="chatContent">내일 봬요~!</div>
                </div>
            </div>
            <div class="chatList">
                <div class="profile">
                    <img src="resources/프사.jpg" class="profileImg">
                </div>
                <div class="chatSimple">
                    <div class="chatTitle">【D-2🐥어른이날】...</div>
                    <div class="chatContent">몇 살까지 어린이인줄 앎?</div>
                </div>
            </div>
        </div>
        <div class="chatPage">
            <h2 class="title">【D-2🐥어른이날】 천지방축 운동회</h2>
            <hr style="background: lightgray; height: 1px; border: 0;" >
            <div class="chatDetail">
                
            </div>
            <div class="chatInput">
                <textarea id="textArea" placeholder="메세지를 입력해주세요"></textarea>
                <button type="button" id="submitBtn">전송</button>
            </div>
        </div>
    </div>
</body>
</html>