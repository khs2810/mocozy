<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mo-Cozy - 이용약관</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/koo/js/signIn_js/terms.js" defer></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/signIn_css/terms.css" />

</head>
<body class="Login_page">
    <form action="insert.me" name="thisForm" onsubmit="return checkEssential()">
        <div class="Login-content">
          <a href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/logo.png" id="logo" alt="">
          </a>
                <h1>
                    서비스 이용을 위해<br>
                    약관에 동의해주세요.
                </h1>

            <div class="checked">
                <!-- 부트스트랩 아이콘을 이용한 체크박스 -->
                <i class="bi bi-square" id="checkboxAll"></i>
                <!-- 전체동의 텍스트 -->
                전체동의
            </div><br>
            <hr>

            <div id="terms-content">
                <div class="custom-checkbox">
                    <!-- 부트스트랩 아이콘을 이용한 체크박스 -->
                    <i class="bi bi-square chk" name="mustCheck"></i>
                    <!-- 서비스 이용약관 텍스트 -->
                    서비스 이용약관 (필수)
                    <!-- 간격을 위한 공간 -->
                    <div class="space"></div>
                    <!-- 서비스 이용약관 보기 링크 -->
                    <a href="serviceTerms" style="width: 40px;" target="_blank">보기</a>
                </div><br>
                <div class="custom-checkbox">
                    <!-- 부트스트랩 아이콘을 이용한 체크박스 -->
                    <i class="bi bi-square chk" name="mustCheck"></i>
                    <!-- 개인정보처리방침 텍스트 -->
                    개인정보처리방침 (필수)
                    <!-- 간격을 위한 공간 -->
                    <div class="space"></div>
                    <!-- 개인정보처리방침 보기 링크 -->
                    <a href="privacy-policy" style="width: 40px;" target="_blank">보기</a>
                </div><br>
                <div class="custom-checkbox">
                    <!-- 부트스트랩 아이콘을 이용한 체크박스 -->
                    <i class="bi bi-square chk" name="mustCheck"></i>
                    <!-- 만 14세 이상 확인 텍스트 -->
                    만 14세 이상 확인 (필수)
                </div><br>
                <div class="custom-checkbox">
                    <!-- 부트스트랩 아이콘을 이용한 체크박스 -->
                    <i class="bi bi-square chk"></i>
                    <!-- 이벤트 정보 수신 동의 텍스트 -->
                    이벤트 정보 수신 동의 (선택)
                </div><br>
            </div>

            <div class="start-account">
            	<input type="hidden" name="nickname" value="${m.nickname}">
            	<input type="hidden" name="userId" value="${m.userId}">
            	<input type="hidden" name="userPwd" value="${m.userPwd}">
                <button type="submit" class="start-btn" id="startBtn">시작하기</button>
            </div>
        </div>
    </form>
</body>
</html>