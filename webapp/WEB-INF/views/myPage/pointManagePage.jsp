<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포인트 관리페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/pointManagePage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/pointManagePage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <div class="main-content">
            <div class="main-content-head">
                <h2>포인트 관리</h2>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;"><br><br>
            <div class="pointBox">
                <div class="pointBox-head">
                    <img src="${pageContext.request.contextPath}/resources/jun/img/coin.png">
                    <p style="font-size: 24px; margin-left: 5px; font-weight: 650;">잔여 포인트</p>
                </div>
                <div class="pointBox-mid">
                    <p class="point-level"><fmt:formatNumber value="${loginUser.point}" pattern="#,###"/>pt</p>
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
                    <span>${strMonth}</span>
                </div>
                <div class="useArea">
                    <span class="area-left">충전 내역</span>
                    <span class="area-right"><fmt:formatNumber value="${sumPoint}" pattern="#,###"/>pt</span>
                </div><br>
                <div class="useArea">
                    <span class="area-left">사용 내역</span>
                    <span class="area-right">-<fmt:formatNumber value="${sumUsePoint}" pattern="#,###"/>pt</span>
                </div><br>
                <div class="useArea">
                    <span class="area-left">출금 내역</span>
                    <span class="area-right">-<fmt:formatNumber value="${sumWithdrawPoint}" pattern="#,###"/>pt</span>
                </div>
            </div>
        </div>
    </div>

    <!-- The Modal -->
    <div class="modal" id="chargeWindow">
        <div class="modal-dialog">
            <div class="modal-content">
                <form type="POST" action="charge.pt">
                    <input type="hidden" name="userNo" value="${loginUser.userNo}">
                    <input type="hidden" name="userId" value="${loginUser.userId}">
                    <input type="hidden" name="userPwd" value="${loginUser.userPwd}">
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h4 class="modal-title">얼마나 충전할까요?</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="radio" name="point" id="btn100" value="1000000"><label for="btn100">100만원</label><br>
                        <input type="radio" name="point" id="btn50" value="500000"><label for="btn50">50만원</label><br>
                        <input type="radio" name="point" id="btn20" value="200000"><label for="btn20">20만원</label><br>
                        <input type="radio" name="point" id="btn10" value="100000"><label for="btn10">10만원</label><br>
                        <input type="radio" name="point" id="btn1" value="10000"><label for="btn1">1만원</label><br>
                        <input type="radio" name="point" id="directInput"><label for="directInput">직접 입력하기</label><br>
                        <input type="number" id="directAmount" placeholder="숫자만 입력해주세요" disabled>
                    </div>
                    
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" >충전하기</button>
                    </div>
                </form>
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
                <form type="POST" action="withdraw.pt">
                    <input type="hidden" name="userNo" value="${loginUser.userNo}">
                    <input type="hidden" name="userId" value="${loginUser.userId}">
                    <input type="hidden" name="userPwd" value="${loginUser.userPwd}">
                    <div class="modal-body">
                        <div class="body-row1">
                            <span>잔여 포인트</span>
                            <div>
                                <span id="remaining-point">${loginUser.point}</span>
                                <span>pt</span>
                            </div>
                        </div>
                        <div class="body-row2">
                            <span>금액 입력</span>
                            <div class="point-area">
                                <input type="number" name="point" id="point-input">
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
                        <button type="submit" class="btn btn-primary">출금하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>
</body>
</html>