<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포인트 사용 내역 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/pointUseHistoryPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/pointUseHistoryPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/pointUseHistoryPage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <script src="${pageContext.request.contextPath}/resources/teo/js/ajaxPointUseHistory.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <form class="main-content">
            <div class="main-content-head">
                <h2 align="center" style="font-size: 30px; margin-top: 0;">사용 내역</h2>
            </div>
            <div class="total-box" style="border-radius: 20px;">
                <div class="month-select" id="month_select_use">
                    <button id="month_before_btn_use" type="button" data-month="${month - 1}" data-uno="${loginUser.userNo}">&lt;</button>
                    <span style="padding: 0 20px; margin-bottom: 7px;">${strMonth}</span>
                    <div><b style="cursor: default;">&gt;</b></div>
                </div>
                <div class="total-area">
                    <h3 id="total-area-month-use">${month}월</h3>
                    <div class="amount-area">
                        <h3 id="total-amount-use"><fmt:formatNumber value="${sumUsePoint}" pattern="#,###"/></h3>
                        <h3>pt</h3>
                    </div>
                </div>
                <div class="total-area">
                    <h3>총액</h3>
                    <div class="amount-area">
                        <h3><fmt:formatNumber value="${useTotalPoint}" pattern="#,###"/></h3>
                        <h3>pt</h3>
                    </div>
                </div>
            </div>
            <div class="history-list-area-use">
                <c:if test="${empty ulist}">
                    <br><br>
                    <h3 align="center">사용 내역이 없습니다.</h3>
                    <br><br>
                </c:if>
                <c:forEach var="p" items="${ulist}">
                    <div class="history-list">
                        <div class="history-list-main">
                            <c:choose>
                                <c:when test="${p.status eq 'Y'}">
                                    <span class="history-detail">
                                        <c:if test="${p.club_type eq '소셜링'}">
                                            <span id="payment_use_social">소셜링</span>
                                        </c:if>
                                        <c:if test="${p.club_type eq '챌린지'}">
                                            <span id="payment_use_challenge">챌린지</span>
                                        </c:if>
                                        ${p.club_title}
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <span class="history-detail">${p.club_title}</span>
                                </c:otherwise>
                            </c:choose>
                            <div class="history-point">
                                <span id="history-point-num"><fmt:formatNumber value="${p.point}" pattern="#,###"/></span>
                                <span>pt</span>
                            </div>
                        </div>
                        <span class="history-date">${p.paymentDate}</span>
                    </div>
                </c:forEach>
            </div>

            <div class="main-content-head">
                <h2 align="center" style="font-size: 30px; margin-top: 0;">출금 내역</h2>
            </div>
            <div class="total-box" style="border-radius: 20px;">
                <div class="month-select" id="month_select_withdraw">
                    <button id="month_before_btn_withdraw" type="button" data-month="${month - 1}" data-uno="${loginUser.userNo}">&lt;</button>
                    <span style="padding: 0 20px; margin-bottom: 7px;">${strMonth}</span>
                    <div><b style="cursor: default;">&gt;</b></div>
                </div>
                <div class="total-area">
                    <h3 id="total-area-month-withdraw">${month}월</h3>
                    <div class="amount-area">
                        <h3 id="total-amount-withdraw"><fmt:formatNumber value="${sumWithdrawPoint}" pattern="#,###"/></h3>
                        <h3>pt</h3>
                    </div>
                </div>
                <div class="total-area">
                    <h3>총액</h3>
                    <div class="amount-area">
                        <h3><fmt:formatNumber value="${withdrawTotalPoint}" pattern="#,###"/></h3>
                        <h3>pt</h3>
                    </div>
                </div>
            </div>
            <div class="history-list-area-withdraw">
                <c:if test="${empty wlist}">
                    <br><br>
                    <h3 align="center">출금 내역이 없습니다.</h3>
                    <br><br>
                </c:if>
                <c:forEach var="p" items="${wlist}">
                    <div class="history-list">
                        <div class="history-list-main">
                            <c:choose>
                                <c:when test="${p.status eq 'W'}">
                                    <span class="history-detail">포인트 출금</span>
                                </c:when>
                            </c:choose>
                            <div class="history-point">
                                <span id="history-point-num"><fmt:formatNumber value="${p.point}" pattern="#,###"/></span>
                                <span>pt</span>
                            </div>
                        </div>
                        <span class="history-date">${p.createDate}</span>
                    </div>
                </c:forEach>
            </div>
        </form>
    </div>

    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>
</body>
</html>