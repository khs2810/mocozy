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
        <div id="payment_main_text">
            <h1 align="center">결제 정보</h1>
            <div class="payment_top">
                <div class="main_img_div"><img src="${pageContext.request.contextPath}/resources/teo/img/clubMainImg.jpg" alt="메인이미지"></div>
                <div>
                    <div>
                        <h3>❤️블랙라이어 ❤️:: with.하이볼 무제한🍹</h3>
                        <div id="club_detail_info_payment"><div>D-2</div><span>관악구 · 5.4(토) 오후 6:00</span></div>
                    </div>
                    <div class="payment_price_info">
                        <p>결제 포인트</p>
                        <p>38,000pt</p>
                    </div>
                    <div>
                        <p>참가비 정보</p>
                        <p>운영비 - 콘텐츠 제작비, 호스트 수고비 <br>
                            모임비 - 노쇼방지비, 대관료, 재료비, 다과비 <br>
                            기타 - 플랫폼 수수료</p>
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
                            <td>100,000pt</td>
                        </tr>
                        <tr>
                            <td>필요한 포인트</td>
                            <td>:</td>
                            <td>38,000pt</td>
                        </tr>
                        <tr>
                            <td>결제 후 남은 포인트</td>
                            <td>:</td>
                            <td>62,000pt</td>
                        </tr>
                        
                    </table>
                </div>
                <img id="ticket_img" src="${pageContext.request.contextPath}/resources/teo/img/ticket.png" alt="">
                <div>
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
            <button class="background_color_brown">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전</button>
            <button class="background_color_green">다 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음</button>
        </div>
        <a href="list.no">공지사항</a>
    </div>
</body>
</html>