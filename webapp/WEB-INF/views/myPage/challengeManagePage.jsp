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
        <form class="main-content" id="challenge-form" action="challnegManage.me" method="get">
        	<input type="hidden" name="cno", value="${cno}">
            <div class="main-content-head">
                <div class="main-content-head-left">
                    <h2>챌린지 관리</h2>
                    <p>발로 개발</p>
                </div>
                <div class="main-content-head-right">
                	<label for="challengeDate">조회날짜 : </label>
                    <input type="date" id="challengeDate" name="challengeDate" value="${selectedDate}" min="" max="">
                </div>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;">
            
            <div class="member-list">
            	<c:set var="l" value="${clubLeader}"/>
                <div class="member">
                    <div class="member-profile">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/crown.png">
                        <p>${l.nickname}</p>
                    </div>
                    <div class="introduction">
                        <p>${l.introduce}</p>
                    </div>
                    <div class="status">
                        <button type="button" class="status-done">완료</button>
                        <button type="button" class="status-undone">미완료</button>
                    </div>
                </div>
                
                <%-- <c:forEach var="m" items="${clubMemberList}">
                	<div class="member">
	                    <div class="member-profile">
	                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
	                        <p>${m.nickname}</p>
	                    </div>
	                    <div class="introduction">
	                        <p>${m.introduce}</p>
	                    </div>
	                    <div class="status">
	                        <button type="button" class="status-done">완료</button>
	                        <button type="button" class="status-undone">미완료</button>
	                    </div>
	                </div>
                </c:forEach> --%>
                <c:forEach var="m" items="${clubMemberList}">
				    <div class="member" data-user-id="${m.userNo}">
				        <div class="member-profile">
				            <img class="profile-img" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
				            <p>${m.nickname}</p>
				        </div>
				        <div class="introduction">
				            <p>${m.introduce}</p>
				        </div>
				        <div class="status">
				            <c:choose>
				                <c:when test="${memberStatus[m.userNo] == 'done'}">
				                    <button type="button" class="status-done" style="background-color: green;">완료</button>
				                    <button type="button" class="status-undone">미완료</button>
				                </c:when>
				                <c:otherwise>
				                    <button type="button" class="status-done">완료</button>
				                    <button type="button" class="status-undone" style="background-color: red;">미완료</button>
				                </c:otherwise>
				            </c:choose>
				        </div>
				    </div>
				</c:forEach>
            </div>
            
            <div class="buttons">
                <button type="button" class="saveBtn">저장</button>
            </div>
        </form>

        <!-- 프로필 모달 -->
        <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>