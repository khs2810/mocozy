<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>챌린지 관리페이지</title>
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
        <%@ include file="myPageCommon.jsp" %>
        
        <div class="main-content">
            <div class="main-content-head">
                <div class="main-content-head-left">
                    <h2>챌린지 관리</h2>
                    <p>발로 개발</p>
                </div>
                <div class="main-content-head-right">
                    <input type="date" id="challengeDate">
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
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
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
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원2</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원3</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원4</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원5</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원6</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <p>파티원7</p>
                    </div>
                    <div class="introduction">
                        <p>사랑둥이 셔니의 우당탕탕 모꼬지 생활 🎀</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
            </div>
            <div class="buttons">
                <button type="button" class="chatBtn">저장</button>
                <!-- <button type="button" class="finishBtn">챌린지 종료</button> -->
            </div>
        </div>

        <!-- 프로필 모달 -->
        <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>