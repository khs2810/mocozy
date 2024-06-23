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
    <form action="insert.me">
        <div class="Login-content">
          <a href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/logo.png" id="logo" alt="">
          </a>
                <h1>
                    서비스 이용을 위해<br>
                    약관에 동의해주세요.
                </h1>
            <div class="checked">
                <div class="custom-checkbox">
                    <input type="checkbox" id="checkboxAll" />
                    <i class="bi bi-square"></i> 전체동의
                </div>
                <hr>
                <div class="custom-checkbox">
                    <input type="checkbox" class="chk" id="checkboxTerms" />
                        <i class="bi bi-square"></i> 서비스 이용약관 (필수)
                    <div class="space"></div>
                    <a href="serviceTerms" style="width: 40px;" target="_blank">보기</a>
                </div>
                <div class="custom-checkbox">
                    <input type="checkbox" class="chk" id="checkboxPrivacy" />
                        <i class="bi bi-square"></i> 개인정보처리방침 (필수)
                    <div class="space"></div>
                    <a href="privacy-policy" style="width: 40px;" target="_blank">보기</a>
                </div>
                <div class="custom-checkbox">
                    <input type="checkbox" class="chk" class ="chk" id="checkboxAge" />
                        <i class="bi bi-square"></i> 만 14세 이상 확인 (필수)
                </div>
                <div class="custom-checkbox">
                    <input type="checkbox" class="chk" id="checkboxEvents" />
                        <i class="bi bi-square"></i> 이벤트 정보 수신 동의 (선택)
                </div>
                <!-- <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-all"> 전체동의</span>
                
                <hr>

                <div class="checked-content">
                    <span class="bi bi-square custom-checkbox checkbox checkbox-essential" data-id="checkbox1"> 서비스 이용약관 (필수)</span>
                    <a href="serviceTerms" target="_blank">보기</a>
                </div>
                <br>
                <div class="checked-content">
                    <span class="bi bi-square custom-checkbox checkbox checkbox-essential" data-id="checkbox2"> 개인정보처리방침 (필수)</span>
                    <a href="privacy-policy" target="_blank">보기</a>
                </div>
                <br>
                <div>
                    <span class="bi bi-square custom-checkbox checkbox checkbox-essential" data-id="checkbox3"> 만 14세 이상 확인 (필수)</span>
                </div>
                <br>
                <div>
                    <span class="bi bi-square custom-checkbox checkbox checkbox-optional" data-id="checkbox4"> 이벤트 정보 수신 동의 (선택)</span>
                <div> -->

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