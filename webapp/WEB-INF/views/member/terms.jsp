<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mo-Cozy - 이용약관</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/signIn_css/terms.css" />

</head>
<body class="Login_page">
    <form action="insert.me">
        <div class="Login-content">
            <img src="${pageContext.request.contextPath}/resources/koo/upfile/loginPage_img/logo.png" id="logo" alt="">
                <h1>
                    서비스 이용을 위해<br>
                    약관에 동의해주세요.
                </h1>
            <div class="checked">
                <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-1"> 전체동의</span>
                
                <hr>

                <div class="checked-content">
                    <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-2"> 서비스 이용약관 (필수)</span>
                    <a href="./serviceTerms.html" target='_blank'>보기</a>
                </div>
                <br>
                <div class="checked-content">
                    <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-3"> 개인정보처리방침 (필수)</span>
                    <a href="./privacy policy.html" target='_blank'>보기</a>
                </div>
                <br>
                <div>
                    <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-4"> 만 14세 이상 확인 (필수)</span>
                </div>
                <br>
                <div>
                    <span class="bi bi-square custom-checkbox checkbox" data-id="checkbox-5"> 이벤트 정보 수신 동의 (선택)</span>
                <div>

            </div>

            <div class="start-account">
            	<input type="hidden" name="nickname" value="${m.nickname}">
            	<input type="hidden" name="userId" value="${m.userId}">
            	<input type="hidden" name="userPwd" value="${m.userPwd}">
                <button type="submit" class="start-btn" id="startBtn">시작하기</button>
            </div>
        </div>

        

        <script>
            // JavaScript to toggle checkbox state
            const checkboxes = document.querySelectorAll('.checkbox');
            const checkbox1 = document.querySelector('[data-id="checkbox-1"]');
        
            checkbox1.addEventListener('click', function() {
              checkboxes.forEach(function(checkbox) {
                if (checkbox.classList.contains('bi-square')) {
                  checkbox.classList.remove('bi-square');
                  checkbox.classList.add('bi-check-square-fill');
                } else {
                  checkbox.classList.remove('bi-check-square-fill');
                  checkbox.classList.add('bi-square');
                }
              });
            });
        
            checkboxes.forEach(function(checkbox) {
              checkbox.addEventListener('click', function() {
                if (checkbox === checkbox1) {
                  checkboxes.forEach(function(cb) {
                    if (checkbox1.classList.contains('bi-check-square-fill')) {
                      cb.classList.remove('bi-square');
                      cb.classList.add('bi-check-square-fill');
                    } else {
                      cb.classList.remove('bi-check-square-fill');
                      cb.classList.add('bi-square');
                    }
                  });
                } else {
                  if (checkbox.classList.contains('bi-square')) {
                    checkbox.classList.remove('bi-square');
                    checkbox.classList.add('bi-check-square-fill');
                  } else {
                    checkbox.classList.remove('bi-check-square-fill');
                    checkbox.classList.add('bi-square');
                  }
                }
                // 모든 체크박스가 bi-check-square-fill로 변하면 checkbox-1도 bi-check-square-fill로 변경
                const allChecked = Array.from(checkboxes).every(cb => cb.classList.contains('bi-check-square-fill'));
                if (allChecked) {
                  checkbox1.classList.remove('bi-square');
                  checkbox1.classList.add('bi-check-square-fill');
                } else {
                  checkbox1.classList.remove('bi-check-square-fill');
                  checkbox1.classList.add('bi-square');
                }
              });
            });
            
            
          </script>
          
          <script>
			    document.getElementById('startBtn').addEventListener('click', function() {
			        // 회원가입 정보를 가져오는 코드
			        const signUpData = {
			            nickname: document.getElementById('nickname').value,
			            userId: document.getElementById('userId').value,
			            userPwd: document.getElementById('userPwd').value,
			            // 이하 필요한 정보들을 추가로 가져옴
			        };
			
			        // 서버로 회원가입 정보를 전송
			        fetch('insert.me', {
			            method: 'POST',
			            headers: {
			                'Content-Type': 'application/json',
			            },
			            body: JSON.stringify(signUpData), // 데이터를 JSON 형식으로 변환하여 전송
			        })
			        .then(response => {
			            if (!response.ok) {
			                throw new Error('Network response was not ok');
			            }
			            return response.text(); // 응답 텍스트 반환
			        })
			        .then(data => {
			            // 서버 응답 처리
			            // 예를 들어, 회원가입 성공/실패 메시지 출력 등
			            console.log(data); // 서버에서 반환된 데이터 출력 (선택사항)
			            // 회원가입 성공 시 메인 페이지로 이동 등
			            window.location.href = '/'; // 이동할 페이지 URL 설정 (메인 페이지로 이동)
			        })
			        .catch(error => {
			            console.error('There has been a problem with your fetch operation:', error);
			        });
			    });
			</script>
    </form>
</body>
</html>