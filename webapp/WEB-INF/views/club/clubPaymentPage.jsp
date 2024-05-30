<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모임 결제페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css"/>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrap_main">
    	<form action="insert.rq">
    		<input type="hidden" name="clubNo" value="${c.clubNo}">
    		<input type="hidden" name="userNo" value="${loginUser.userNo}">
    		<input type="hidden" name="answer" value="${answer}">
    		<input type="hidden" name="pt" value="${loginUser.point - c.cost}">
	        <div id="payment_main_text">
	            <h1 align="center">결제 정보</h1>
	            <div class="payment_top">
	                <div class="main_img_div"><img src="${pageContext.request.contextPath}/resources/teo/img/clubMainImg.jpg" alt="메인이미지"></div>
	                <div class="payment_top_right">
	                    <div>
	                        <h4>${c.clubTitle }</h4>
	                        <div id="club_detail_info_payment"><div>D-2</div><span>관악구 · 5.4(토) 오후 6:00</span></div>
	                    </div>
	                    <div class="payment_price_info">
	                        <p>결제 포인트</p>
	                        <p>${c.cost}pt</p>
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
	                            <td>${loginUser.point}pt</td>
	                        </tr>
	                        <tr>
	                            <td>필요한 포인트</td>
	                            <td>:</td>
	                            <td>${c.cost }pt</td>
	                        </tr>
	                        <tr>
	                            <td>결제 후 남은 포인트</td>
	                            <td>:</td>
	                            <td>${loginUser.point - c.cost}pt</td>
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
	            <button class="background_color_brown" type="button">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전</button>
	            <button class="background_color_green" type="submit">결 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제</button>
	        </div>
        </form>
    </div>
</body>
</html>