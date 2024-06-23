<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 마이페이지</title>

    <!-- css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/challengeManagePage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/challengeManagePage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/myPage.css" />

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <div class="main-content">
            <h1>마이페이지</h1>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>내 최근 모임</h5>
                </div>

                <c:if test="${empty list}">
                    <p>내역 없음</p>
                </c:if>
                <c:forEach var="myPageClub" items="${list}">
                    <div class="club-content">
                        <div class="club-img" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${myPageClub.clubNo}';">
                            <img src="${pageContext.request.contextPath}/${myPageClub.thumbnailImg}">
                        </div>
                        <div class="wrap">
                            <p class="club-title club-text" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${myPageClub.clubNo}';">
                                ${myPageClub.clubTitle}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr>

            <div>
                <div class="main-object dibs">
                    <div class="content-title">
                        <h5>찜</h5>
                    </div>
                    <c:if test="${empty list}">
                        <p>내역 없음</p>
                    </c:if>
                    <c:forEach var="myPageClub" items="${plist}">
                        <div class="club-content">
                            <div class="club-img" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${myPageClub.clubNo}';">
                                <img src="${pageContext.request.contextPath}/${myPageClub.thumbnailImg}" alt="">
                            </div>
                            <div class="wrap">
                                <div class="club-title">${myPageClub.clubTitle}</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>포인트 이용 내역</h5>
                </div>
                <div class="line-chart">
                    <canvas id="myChart" width="600" height="180"></canvas>
                </div>
            </div>
            
            <!-- 프로필 모달 -->
            <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>