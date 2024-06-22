<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모임 결제페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/pointManagePage.css">
	
	<!-- 라이브러리 -->
    <script src="${pageContext.request.contextPath}/resources/teo/js/clubPayment.js"></script>
	<script src="${pageContext.request.contextPath}/resources/jun/js/pointManagePage.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<form action="insert.rq">
		<div id="wrap_main">
			<input type="hidden" name="clubNo" value="${c.clubNo}">
			<input type="hidden" name="userNo" value="${loginUser.userNo}">
			<input type="hidden" name="answer" value="${answer}">
			<input type="hidden" name="pt" value="${c.cost}">
			<div id="payment_main_text">
				<h1 align="center">결제 정보</h1>
				<div class="payment_top">
					<div class="main_img_div"><img src="${c.thumbnailImg}" alt="메인이미지"></div>
					<div class="payment_top_right">
						<div>
							<h4>${c.clubTitle }</h4>
							<div id="club_detail_info_payment">
								<div>${dDay}</div>
								<span>${c.address} · ${evDate}</span>
							</div>
						</div>
						<div class="payment_price_info">
							<p>결제 포인트 : <fmt:formatNumber value="${c.cost}" pattern="#,###"/>pt</p>
						</div>
						<div>
							<p>참가비 정보 <br>
							- ${c.costInfo }</p>
						</div>
					</div>
				</div>
				<div class="payment_bottom">
					<!-- <div class="payment_type_radio">
						<div>
							<input type="radio" name="paymentType" id="kakaopay">
							<label for="kakaopay">카카오결제</label>
						</div>
						<div>
							<input type="radio" name="paymentType" id="card">
							<label for="card">카드 결제</label>
						</div>
						<div>
							<input type="radio" name="paymentType" id="cash">
							<label for="cash">계좌 이체</label>
						</div>
					</div> -->
					<div class="payment_table">
						<table>
							<tr>
								<td>보유 중인 포인트</td>
								<td>:</td>
								<td><fmt:formatNumber value="${loginUser.point}" pattern="#,###"/>pt</td>
							</tr>
							<tr>
								<td>필요한 포인트</td>
								<td>:</td>
								<td><fmt:formatNumber value="${c.cost}" pattern="#,###"/>pt</td>
							</tr>
							<tr>
								<td>결제 후 남은 포인트</td>
								<td>:</td>
								<c:choose>
									<c:when test="${loginUser.point >= c.cost}">
										<td><fmt:formatNumber value="${loginUser.point - c.cost}" pattern="#,###"/>pt</td>
									</c:when>
									<c:otherwise>
										<td style="color: red"><fmt:formatNumber value="${loginUser.point - c.cost}" pattern="#,###"/>pt</td>
										<td><button type="button" id="charge_btn" data-toggle="modal" data-target="#chargeWindow">충전</button></td>
									</c:otherwise>
								</c:choose>
								
							</tr>
						</table>
					</div>
					<img id="ticket_img" src="${pageContext.request.contextPath}/resources/teo/img/ticket.png" alt="">
					<div class="payment_bottom_right">
						<h4>참가비 환불 규정 안내</h4>
						<ul>
							<li>결제 후 30분 경과 전 : 전액 환불</li>
							<li>승인 대기 중인 상태에서 신청 취조한 경우 : 전액 환불</li>
							<li>참여되거나 승인 후 내보내진 경우 : 전액 환불</li>
							<li>참여 확정 모임의 진행일 기준 4일 전까지 : 전액 환불</li>
							<li>참여 활정 모임의 진행일 기준 3일 전부터 : 환불 불가</li>
							<li>모임 진행 당일에 신청한 경우 : 환불 불가</li>
						</ul>
					</div>
				</div>            
			</div>
			<div class="club_btns">
				<button class="background_color_brown" type="button" onclick="history.back()">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전</button>
				<c:choose>
					<c:when test="${loginUser.point >= c.cost}">
						<button class="background_color_green" type="submit" onclick="return confirmPay()">결 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제</button>
					</c:when>
					<c:otherwise>
						<button disabled style="background-color: #cccccc;">결 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제</button>
					</c:otherwise>
				</c:choose>				
			</div>
		</div>
	</form>

	<!-- The Modal -->
    <div class="modal" id="chargeWindow">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" accept-charset="UTF-8" action="chargeInClub.pt" id="charge_form">
                    <!-- <input type="hidden" name="userNo" value="${loginUser.userNo}">
					<input type="hidden" name="userId" value="${loginUser.userId}">
					<input type="hidden" name="userPwd" value="${loginUser.userPwd}"> -->
					<input type="hidden" name="cno" value="${c.clubNo}">
					<input type="hidden" name="answer" value="${answer}">
					<input type="hidden" name="dDay" value="${dDay}">
					<input type="hidden" name="evDate" value="${evDate}">
					
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h4 class="modal-title">얼마나 충전할까요?</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <!-- Modal body -->
                    <div class="modal-body">
                        <input type="radio" name="pointOpt" id="btn100" value="1000000"><label for="btn100">100만원</label><br>
                        <input type="radio" name="pointOpt" id="btn50" value="500000"><label for="btn50">50만원</label><br>
                        <input type="radio" name="pointOpt" id="btn20" value="200000"><label for="btn20">20만원</label><br>
                        <input type="radio" name="pointOpt" id="btn10" value="100000"><label for="btn10">10만원</label><br>
                        <input type="radio" name="pointOpt" id="btn1" value="10000"><label for="btn1">1만원</label><br>
                        <input type="radio" name="pointOpt" id="directInput"><label for="directInput">직접 입력하기</label><br>
                        <input type="number" name="point" id="directAmount" placeholder="숫자만 입력해주세요" readonly required>
                    </div>
                    
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <div class="modal-footer">
							<button type="button" onclick="submitCharge('cash')" class="btn btn-primary">충전하기</button>
						</div>
						<div id="modal_pay_img">
                            <img onclick="submitCharge('kakao')" src="${pageContext.request.contextPath}/resources/teo/img/kakao_small.png" alt="">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>