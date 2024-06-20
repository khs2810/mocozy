<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모꼬지-회원가입</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/signIn_css/signInPage.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/signIn_js/signIn.js"></script>
    
    <style>
        .none_pass{
            color: red;
        }
        .pass{
            color: green;
        }
        
    </style>
</head>
<body class="SignIn-Page">
        <div class="content">
            <a href="${pageContext.request.contextPath}">
                <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/logo.png" id="logo" alt="">
            </a>
                <h1>
                    회원 가입하고<br>
                    다양한 모임에서 활동해보세요!
                </h1>
         <form action="terms.me" method="post" id="signUpForm" onsubmit="return validateForm()">
            <div class="enrollForm">
                <h4>* 닉네임</h4>
                <div class="content-box">
                    <input type="text" id="nickName" name="nickName" onkeyup="checkNickName()" placeholder="닉네임" required><br>
                    <span id="nick_Review"></span>
                    <div id="checkNickResult" style="font-size:0.7em; display:none;"></div>
                </div>
                
                <br>
                <h4>* 아이디(이메일 주소)</h4>
                <div class="content-box">
                    <input type="text" class="form-control" id="userId" onkeyup="checkId(this)" placeholder="example@kakao.com" name="userId" required><br>
                    <span id="id_review"></span>
                    <div id="checkIdResult" style="font-size:0.7em; display:none;"></div>
                </div>
                
                <br>
                <h4>* 비밀번호</h4>
                <div class="content-box">
                    <input type="password" class="form-control" id="userPwd" onkeyup="validateUserPwd()" placeholder="숫자와 영문을 포함하여 8자리 이상" name="userPwd" required><br>
                    <span id="pwd_review"></span>
                    <div id="checkIdResult" style="font-size:0.7em; display:none;"></div>
                </div>
                
                <br>
                <h4>* 비밀번호 확인</h4>
                <div class="content-box">
                    <input type="password" class="form-control" id="checkPwd" onblur="checkPass()" placeholder="비밀번호" required><br>
                    <span id="checkPass_review"></span><br>
                </div>
                
                <br>
                <hr>
                <br>

                <div>
                    <!-- <input type="button" class="next-btn" value="다 음" href="terms"> -->
                    <button type="submit" class="next-btn btn btn-primary" id="submitBtn">다 음</button>
                </div>
                <div class="forlogin">
                    <p>이미 계정이 있다면, <a href="loginPage.me">로그인</a> 해보세요.</p>
                </div>
            </div>
            </form>
       </div>
       
	
    	
</body>
</html>