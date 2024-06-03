<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mo-Cozy - Login</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/loginPage_css/loginPage.css" />

</head>
<body class="Login_page">
    <form action="login.me" method="post">
        <div class="Login-content">
            <a href="${pageContext.request.contextPath}">
            	<img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/logo.png" id="logo" alt="모꼬지">
            </a>
                <h1>
                    함께 하면 즐거운<br>
                    모꼬지에 오신 것을 환영합니다!
                </h1>
            <div class="id-box">
                <input type="text" name="userId" placeholder="아이디(이메일@mocozy.com)">
            </div>
            
            <br>
            
            <div class="pwd-box">
                <input type="password" name="userPwd" placeholder="비밀번호">
            </div>
            
            <br>

            <div>
                <button type="submit" class="login-btn">로그인</button>
            </div>

            <div class="flex justify-center gap-1 mt-6 text-sm text-taling-gray-700 ">
                <div w-full text-center >
                    <a href="" class="text-taling-pink-400"> 아이디 찾기</a>
                </div>
                <div w-full text-center >
                    <a href="" class="text-taling-pink-400">비밀번호 찾기</a>
                </div>
            </div>
            
            <br>

            <div class="text-taling-gray-700">
                <a href="signInPage.me" class="text-taling-pink-400">회원가입</a>
            </div>
            
            <div class="line">또는</div>

            <div class="select-login">
                <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/kakao_login_medium_wide.png" alt="">
            </div>
        </div>

    </form>

    <script>
        window.onload = function() {
        const errorMsg = '<%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %>';
        if (errorMsg) {
            alert(errorMsg);
        }
    };
    </script>
</body>
</html>