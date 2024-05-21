<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mo-Cozy - 이용약관</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}./terms.css" />

</head>
<body class="Login_page">
    <form action="">
        <div class="Login-content">
            <img src="./img/logo.png" id="logo" alt="">
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
                <input type="button" class="start-btn" value="시작하기">
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
    </form>
</body>
</html>