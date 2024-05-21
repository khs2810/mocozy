<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공자사항 상세페이지</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
        <h1>[공지] 5.5.0 버전 업데이트 안내</h1>
        <p> 2024.05.02</p>

        <div class="notice_detail_content">
            안녕하세요!  모꼬지에요🤗<br>
            수채화 같은 봄날과 함께 찾아온모꼬지 업데이트 소식 들려드릴게요!<br>
            <br>
            1) 클래스도 모꼬지라면 신뢰할 수 있도록<br>
             모꼬지에서 인증 절차를 거친 공식 클래스 호스트 기능이 새롭게 생겼어요.<br>
             공식 클래스 호스트는 프로필 배지가 부여되며, 1:1 소셜링을 진행할 수 있어요.<br>
             @모꼬지 가이드도 이와 맞추어 일부 수정되었어요!<br>
             클래스 호스트에 대한 더욱 자세한 사항은@클래스 호스트FAQ 를 참고해주세요!<br>
            <br>
            2) 여러가지 불편한 점들을 개선했어요.<br>
             소셜링 상세페이지에서 같은 호스트의 소셜링을 날짜별로 쉽게 살펴볼 수 있어요.<br>
             프로필 배지를 누르면 배지의 종류와 의미를 알 수 있도록 소개해 드려요.<br>
             성향 테스트 내역을 삭제하는 기능이 추가됐어요.<br>
             [마이페이지 > 설정]에서 호스트 활동과 관련된 메뉴가 추가됐어요.<br>
            <br>
            @모꼬지 드림 
        </div>
        <div class="notice_detail_update_btn">
            <button class="background_color_green color_white font_weight_bold">수 정</button>
            <button class="background_color_green color_white font_weight_bold">삭 제</button>
        </div>
        <div id="notice_review">
            <h3>댓글(3)</h3>
            <table id="review_table">
                <tr>
                    <td style="padding-left: 5px;">떡꼬치대마왕</td>
                    <td style="width: 75%; padding-left: 14px;">리뷰입니다3</td>
                    <td>2024.05.09</td>
                    <td>X</td>
                </tr>
                <tr>
                    <td style="padding-left: 5px;">떡꼬치대마왕</td>
                    <td style="width: 75%; padding-left: 14px;">리뷰입니다3</td>
                    <td>2024.05.09</td>
                    <td>X</td>
                </tr>
                <tr>
                    <td style="padding-left: 5px;">떡꼬치대마왕</td>
                    <td style="width: 75%; padding-left: 14px;">리뷰입니다3</td>
                    <td>2024.05.09</td>
                    <td>X</td>
                </tr>
            </table>
            <br>
            <div id="review_write_box">
                <h4>떡꼬치대마왕</h4>
                <div class="review_content_write_box">
                    <div class="review_content_write">
                        <textarea></textarea>
                    </div>
                    <button class="background_color_green color_white font_weight_bold review_enroll_btn">등 록</button>
                </div>
            </div>
        </div>
    </div>
    <br>
</body>
</html>