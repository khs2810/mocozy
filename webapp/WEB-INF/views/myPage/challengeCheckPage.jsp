<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>챌린지 확인페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/challengeManagePage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/challengeCheckPage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/MyPage.css" />
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        <form class="main-content" id="challenge-form" action="challengeCheck.me" method="get">
        	<input type="hidden" name="cno" value="${cno}">
            <div class="main-content-head">
                <div class="main-content-head-left">
                    <h2>챌린지 관리</h2>
                    <p>발로 개발</p>
                </div>
                <div class="main-content-head-right">
                	<label for="challengeDate">조회날짜 : </label>
                    <input type="date" id="challengeDate" name="challengeDate" value="${challengeDate}" min="${createDate}" max="">
                </div>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;">
            
            <input type="hidden" name="cno" value="${cno}">
            <input type="hidden" name="challengeDate" value="${challengeDate}">
            <input type="hidden" id="challengeData" name="challengeData">
            
            <!-- 파티원 리스트 -->
            <div class="member-list">
	            <!-- 파티장 정보 -->
	            <div class="member">
	                <div class="member-profile" data-userid="${clubLeader.userNo}">
	                    <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
	                    <img src="${pageContext.request.contextPath}/resources/jun/img/crown.png">
	                    <p>${clubLeader.nickname}</p>
	                </div>
	                <div class="introduction">
	                    <p>${clubLeader.introduce}</p>
	                </div>
	                <div class="status">
	                    <c:choose>
	                        <c:when test="${tmp[clubLeader.userNo] == 'Y'}">
	                            <button type="button" class="status-done done-active">완료</button>
	                            <button type="button" class="status-undone">미완료</button>
	                        </c:when>
	                        <c:otherwise>
	                            <button type="button" class="status-done">완료</button>
	                            <button type="button" class="status-undone undone-active">미완료</button>
	                        </c:otherwise>
	                    </c:choose>
	                </div>
	            </div>
            
                <!-- 파티원들의 챌린지 정보 -->
                <c:forEach var="m" items="${clubMemberList}">
                    <div class="member">
                        <div class="member-profile" data-userid="${m.userNo}">
                            <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <p>${m.nickname}</p>
                        </div>
                        <div class="introduction">
                            <p>${m.introduce}</p>
                        </div>
                        <div class="status">
                            <c:choose>
                                <c:when test="${tmp[m.userNo] == 'Y'}">
                                    <button type="button" class="status-done done-active">완료</button>
                                    <button type="button" class="status-undone">미완료</button>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="status-done">완료</button>
                                    <button type="button" class="status-undone undone-active">미완료</button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </form>

        <!-- 프로필 모달 -->
        <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>