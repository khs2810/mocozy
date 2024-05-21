<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>호스트 질문페이지</title>

    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">

</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrap_main">
        <div id="main_text">
            <div class="host_question_head">
                <div>
                    <h1>호스트의 질문에 <br>
                        답변을 작성해주세요!</h1>
                    <p>작성한 답변은 호스트와 스태프에게만 공개돼요.</p>
                </div>
                <div><img src="${pageContext.request.contextPath}/resources/teo/img/question_mark.JPG" alt="물음표"></div>
            </div>
            <div class="host_question_q" >
                <div>
                    <div class="club_profile_img"><img src="${pageContext.request.contextPath}/resources/teo/img/profile_img.jpg" alt="프로필 사진"></div>
                    <div align="center">이름</div>
                </div>
                <div class="host_question_question" >
                    <p>나이 / 성별 / 직업 / MBTI 를 작성해주세요 ✨ <br>
                    (블랙라이어 지원하실 분은 요기에 남겨주세용💌)</p>
                </div>
            </div>
            
            <div class="host_question_content">
                <span class="counting_words"><span class="textCount1">0</span>/300자</span>
                <textarea name="" id="host_question_answer" maxlength="300"></textarea>
            </div>
            <div class="host_question_caution">
                <div>!</div>
                <div class="host_question_caution_content">전화번호, 카카오톡 아이디, 신청 폼 작성 요구등 과도한 개인정보를 요구하는 경우 가이드 위반 모임이므로 모꼬지에 신고해 주세요.</div>
            </div>
            <div class="club_btns">
                <button class="background_color_brown">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전</button>
                <button class="background_color_green" onclick="location.href='payment.cl'" >결 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제</button>
            </div>
        </div>
        
    </div>
</body>

<script>
    $("#host_question_answer").keyup(function(ev) {
            let content = $(this).val();
            $(".textCount1").text(content.length); 
        });
</script>


</html>