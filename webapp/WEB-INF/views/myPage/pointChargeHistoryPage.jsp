<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포인트 충전 내역 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/pointChargeHistoryPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/pointChargeHistoryPage.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <form class="main-content">
            <div class="main-content-head">
                <h2 style="font-size: 36px; margin-top: 0;">충전 내역</h2>
            </div>
            <div class="total-box">
                <div class="month-select">
                    <button type="button">&lt;</button>
                    <span style="padding: 0 20px; margin-bottom: 7px;">2024. 04</span>
                    <button type="button">&gt;</button>
                </div>
                <div class="total-area">
                    <h2>총 액</h2>
                    <div class="amount-area">
                        <h2 id="total-amount">110000</h2>
                        <h2>pt</h2>
                    </div>
                </div>
            </div>
            <div class="history-list-area">
                <div class="history-list">
                    <div class="history-list-main">
                        <span class="history-detail">포인트 충전</span>
                        <div class="history-point">
                            <span id="history-point-num">30000</span>
                            <span>pt</span>
                        </div>
                    </div>
                    <span class="history-date">2024.4.5</span>
                </div>
                <div class="history-list">
                    <div class="history-list-main">
                        <span class="history-detail">포인트 충전</span>
                        <div class="history-point">
                            <span id="history-point-num">30000</span>
                            <span>pt</span>
                        </div>
                    </div>
                    <span class="history-date">2024.4.13</span>
                </div>
                <div class="history-list">
                    <div class="history-list-main">
                        <span class="history-detail">챌린지 상금</span>
                        <div class="history-point">
                            <span id="history-point-num">50000</span>
                            <span>pt</span>
                        </div>
                    </div>
                    <span class="history-date">2024.4.13</span>
                </div>
            </div>
        </form>

        <!-- 프로필 모달 -->
        <%@ include file="../member/profileModal.jsp" %>
    </div>
</body>
</html>