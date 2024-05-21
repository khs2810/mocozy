<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모꼬지-회원가입</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/signIn_css/SignInPage.css" />
    
</head>
<body class="SignIn-Page">
    <form action="">
        <div class="content">
            <img src="./img/logo.png" id="logo" alt="">
                <h1>
                    회원 가입하고<br>
                    다양한 모임에서 활동해보세요!
                </h1>
            
            <div class="enrollForm">
                <h4>닉네임(선택)</h4>
                <div class="content-box">
                    <input type="text" placeholder="아이디">
                </div>
                
                <br>
                <h4>이메일 주소</h4>
                <div class="content-box">
                    <input type="text" placeholder="example@kakao.com">
                </div>
                
                <br>
                <h4>비밀번호</h4>
                <div class="content-box">
                    <input type="password" placeholder="숫자와 영문을 포함하여 8자리 이상">
                </div>
                
                <br>
                <h4>비밀번호 확인</h4>
                <div class="content-box">
                    <input type="text" placeholder="비밀번호">
                </div>
                
                <br>

                <div>
                    <input type="button" class="next-btn" value="다 음">
                </div>
                <div class="forlogin">
                    <p>이미 계정이 있다면, <a href="/LoginPage.html">로그인</a> 해보세요.</p>
                </div>
            </div>
            
        </div>

    </form>
</body>
</html>