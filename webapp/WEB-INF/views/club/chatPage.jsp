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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/chatPage.css">
    <script src="${pageContext.request.contextPath}/resources/jun/js/chatPage.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="contentBox">
        <div class="chatLists">
            <h2 class="title">내 채팅함</h2>
            <p class="chatCategory">1:1 상담</p>
            <div class="chatList">
                <div class="profile">
                    <img src="${pageContext.request.contextPath}/resources/jun/img/타노스.png" class="profileImg">
                </div>
                <div class="chatSimple chatWithAdmin" data-userNo="1" data-chattingNo="0">
                    <div class="chatTitle">모꼬지 상담요원</div>
                    <div class="chatContent">안녕하세요</div>
                </div>
            </div>
            <p class="chatCategory">모임 채팅</p>
            
           	<c:forEach var="c" items="${roomList}">
           		<div class="chatList">
           			<div class="profile">
           				<img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg">
           			</div>
           			<div class="chatSimple" data-userNo="${c.targetNo}" data-chattingNo="${c.chatNo}">
           				<div class="chatTitle">${c.roomTitle}</div>
           				<div class="chatContent">${c.lastMessage}</div>
           			</div>
           		</div>
           	</c:forEach>
        </div>
        <div class="chatPage">
            <h2 class="title">모꼬지 상담요원</h2>
            <hr style="background: lightgray; height: 1px; border: 0;" >
            <div class="chatDetail" id="chatDetail">
                <!-- 여기에 메시지 추가됨 -->
            </div>
            <div class="chatInput">
                <textarea id="textArea" placeholder="메세지를 입력해주세요"></textarea>
                <button type="button" id="submitBtn">전송</button>
            </div>
        </div>
    </div><br>
    
   <!--------------------------------------- sockjs를 이용한 WebSocket 구현을 위해 라이브러리 추가 ---------------------------------------------->
   
   <!-- https://github.com/sockjs/sockjs-client -->
   <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
   <script>
      // 로그인한 회원 번호
      const loginUserNo = "${loginUser.userNo}";
   </script>

   <script src="/resources/js/chatting/chatting.js"></script>
</body>
</html>