<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>참여 확인페이지</title>
    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css"/>

    <!-- 라이브러리 -->
    <script src="${pageContext.request.contextPath}/resources/teo/js/clubParticipateConfirm.js"></script>
</head>
<body>
	<%@ include file="../common/Header.jsp"%>
    <div id="wrap_main">
        <div id="main_text">
            <div id="head_text">
                <h1>모두가 즐거운 모임이 될수 있도록 꼭 확인해 주세요</h1>
                <div><img src="${pageContext.request.contextPath}/resources/teo/img/exclamation_mark2.JPG" alt="느낌표"></div>
            </div>

            <div class="pre_participate_content">
                <div class="pre_participate_content_left">
                    <ul>
                        <li> 모임 시작 전 부득이하게 참여가 어려워진 경우, 
                            반드시 호스트에게 미리 알려주세요!</li>
                        <li> 무단으로 불참하거나, 함께하는 멤버들에게
                            피해를 주는 경우 이용 제재를 받게돼요.</li>
                        <li> 호스트가 제공하는 우선 신청 혜택은 정상적으로 모임 참여를 완료해야 제공되요.</li>
                    </ul>
                    <!-- <div>
                        1. 모임 시작 전 부득이하게 참여가 어려워진 경우, 
                        반드시 호스트에게 미리 알려주세요!
                    </div>
                    <div>
                        2. 무단으로 불참하거나, 함께하는 멤버들에게
                        피해를 주는 경우 이용 제재를 받게돼요.
                    </div>
                    <div>
                        3. 호스트가 제공하는 우선 신청 혜택은 정상적으로 모임 참여를 완료해야 제공되요.
                    </div> -->
                </div>
                <div class="pre_participate_content_right">
                    <img src="${pageContext.request.contextPath}/resources/teo/img/preparticipate.jpg" alt="모임 이미지">
                </div>
            </div>
            <div id="checkbox_pre_participate" class="checkbox_pre_participate" onclick="confirm()">
                V 모꼬지 이용 규칙을 잘 지킬게요!
            </div>
            <div class="club_btns">
                <button class="background_color_brown">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전</button>
                <button class="club_next_btn" onclick="location.href='hostQuestion.cl'" disabled>다 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음</button>
            </div>
        </div>
        </div>
    </div>
    </div>
</body>
</html>