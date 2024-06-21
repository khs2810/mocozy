// 체크박스 변경 기능
document.addEventListener('DOMContentLoaded', function() {
    const checkboxes = document.querySelectorAll('.checkbox');
    const checkboxAll = document.querySelector('[data-id="checkbox-all"]');
    const checkboxEssential = document.querySelector('.checkbox-essential');
    const checkboxOptional = document.querySelector('[data-id="checkbox-optional"]');
    
    // 1. 전체 동의 박스 클릭시
    checkboxAll.addEventListener('click', function() {
        // 체크박스 반복하는 기능
        checkboxes.forEach(function(checkbox) {
            // 빈 박스 상태라면
            if (checkbox.classList.contains('bi-square')) {
                // 빈박스를 삭제
                checkbox.classList.remove('bi-square');
                // 체크 검정박스 추가
                checkbox.classList.add('bi-check-square-fill');

                // 체크 검정박스 상태라면
            } else if(){
                
                else {
                // 체크 검정 박스 삭제
                checkbox.classList.remove('bi-check-square-fill');
                // 빈 박스 추가
                checkbox.classList.add('bi-square');
            }}
        });
    });

    // 2. 개별 체크박스 요소 클릭시 반복되는 기능
    checkboxes.forEach(function(checkbox) {
         // 각 체크박스 클릭시 이벤트 리스너 추가
        checkbox.addEventListener('click', function() {
           // 클릭된 체크박스가 '전체동의' 체크박스인지 확인
            if (checkbox === checkboxAll) {
                // 모든 체크박스 요소에 대해 반복
                checkboxes.forEach(function(cb) {
                     // '전체동의' 체크박스가 선택된 상태라면
                    if (checkboxAll.classList.contains('bi-check-square-fill')) {
                       // 각 체크박스에서 'bi-square' 클래스를 제거하고
                        cb.classList.remove('bi-square');
                        // 'bi-check-square-fill' 클래스를 추가하여 선택 상태로 변경
                        cb.classList.add('bi-check-square-fill');

                       // '전체동의' 체크박스가 선택 해제된 상태라면
                    } else {
                        // 각 체크박스에서 'bi-check-square-fill' 클래스를 제거하고
                        cb.classList.remove('bi-check-square-fill');
                        // 'bi-square' 클래스를 추가하여 선택 해제 상태로 변경
                        cb.classList.add('bi-square');
                    }
                });
                
            // 'checkboxAll'이 아닌 다른 체크박스가 클릭된 경우
            } else {
                // 만약 빈박스라면?
                if (checkbox.classList.contains('bi-square')) {
                    // 빈박스 클래스 제거
                    checkbox.classList.remove('bi-square');
                    // 체크 검정박스 추가
                    checkbox.classList.add('bi-check-square-fill');
                    
                // 빈박스 아니고 현재 체크박스가 체크 검정박스 클래스의 경우
                } else {
                    // 체크 검정박스 제거
                    checkbox.classList.remove('bi-check-square-fill');
                    // 빈 박스 추가
                    checkbox.classList.add('bi-square');
                }
            }

                // 모든 체크박스들이 체크 검정박스 클래스를 가지고 있는지 확인 (모두 체크된 상태인지 확인)
                const allChecked = Array.from(checkboxes).every(cb => cb.classList.contains('bi-check-square-fill'));
                // 필수 체크가 체크 검정박스 클래스를 가지고 있는지 확인.
                const essentialChecked = Array.from(checkboxEssential).every(cb => cb.classList.contains('bi-check-square-fill'));

                // 모든 체크박스가 체크된 상태라면
                if (allChecked) {
                    // 'checkbox'의 'bi-square' 클래스를 제거하고
                    checkbox.classList.remove('bi-square');
                    // 'bi-check-square-fill' 클래스를 추가하여 '전체동의' 체크박스를 체크된 상태로 변경
                    checkbox.classList.add('bi-check-square-fill');

                    // 모든 체크박스가 체크된 상태가 아니라면
                } else {
                    // 'checkboxAll'의 'bi-check-square-fill' 클래스를 제거하고
                    checkboxAll.classList.remove('bi-check-square-fill');
                    // 'bi-square' 클래스를 추가하여 '전체동의' 체크박스를 체크 해제된 상태로 변경
                    checkboxAll.classList.add('bi-square');

                    
                }

        });
    });

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
});