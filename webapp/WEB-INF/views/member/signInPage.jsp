<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모꼬지-회원가입</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/signIn_css/signInPage.css" />
    
</head>
<body class="SignIn-Page">
        <div class="content">
            <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_imp/logo.png" id="logo" alt="">
                <h1>
                    회원 가입하고<br>
                    다양한 모임에서 활동해보세요!
                </h1>
         <form action="terms.me" method="post" id="">
            <div class="enrollForm">
                <h4>닉네임(선택)</h4>
                <div class="content-box">
                    <input type="text" name="nickname" placeholder="닉네임(선택)">
                </div>
                
                <br>
                <h4>* 아이디(이메일 주소)</h4>
                <div class="content-box">
                    <input type="text" class="form-control" id="userId" placeholder="example@kakao.com" name="userId" required>
                    <div id="checkResult" style="font-size:0.7em; display:none;"></div>
                </div>
                
                <br>
                <h4>* 비밀번호</h4>
                <div class="content-box">
                    <input type="password" class="form-control" id="userPwd" placeholder="숫자와 영문을 포함하여 8자리 이상" name="userPwd" required> <br>
                </div>
                
                <br>
                <h4>* 비밀번호 확인</h4>
                <div class="content-box">
                    <input type="password" class="form-control" id="checkPwd" placeholder="비밀번호" required> <br>
                </div>
                
                <br>
                <hr>
                <br>

                <div>
                    <!-- <input type="button" class="next-btn" value="다 음" href="terms"> -->
                    <button type="submit" class="next-btn btn btn-primary">다 음</button>
                </div>
                <div class="forlogin">
                    <p>이미 계정이 있다면, <a href="loginPage.me">로그인</a> 해보세요.</p>
                </div>
            </div>
            </form>
       </div>
       
       
		<script>
            $(function(ev){
                const idInput = document.querySelector("#enrollForm input[name=userId]");
                let eventFlag;
                console.log(ev);
                idInput.onkeyup = function(ev){
                    clearTimeout(eventFlag);
                    //키가 눌릴때마다 해당 아이디가 중복이되는지 검사
                    //서버에 데이터를 보내서 응답을 받아야한다 -> ajax
                    const str = ev.target.value;
                    console.log(str);
					if(str.trim().length >= 7) { // 5글자이상
                        eventFlag = setTimeout(function(){ // 1.5초후에 서버로 check요청 전송
                                        $.ajax({
                                            url: "idCheck.me",
                                            data: {checkId : ev.target.value}, // 체크하고싶은 사용자가 입력한 아이디
                                            success: function(result){
                                                const checkResult = document.getElementById("checkResult");
                                                checkResult.style.display = "block";
                                                
                                                if(result === "NNNNN"){ //사용이 불가한경우
                                                    //회원가입버튼 비활성화
                                                    document.querySelector("#enrollForm button[type='submit']").disabled = true;
                                                    
                                                    checkResult.style.color = "red";
                                                    checkResult.innerText = "이미 사용중인 아이디입니다.";
                                                } else { //사용이 가능한 경우
                                                    //회원가입버튼 활성화
                                                    document.querySelector("#enrollForm button[type='submit']").disabled = false;

                                                    checkResult.style.color = "green";
                                                    checkResult.innerText = "사용가능한 아이디입니다.";
                                                }
                                            },
                                            error: function(){
                                                console.log("아이디 중복체크 ajax 실패");
                                            }
                                        })
                                    }, 300)
                    } else { // 5글자이하
                        //disabled상태 유지
                        document.querySelector("#enrollForm button[type='submit']").disabled = true;
                        //checkResult 안보이는 상태
                        document.getElementById("checkResult").style.display = "none";
                    }
                }
                
            });
        </script>
    	
</body>
</html>