document.addEventListener('DOMContentLoaded', function() {
    // 'checkboxAll' 아이콘을 선택
    const checkboxAll = document.querySelector('#checkboxAll');
    // 모든 개별 체크박스 아이콘을 선택
    const checkboxes = document.querySelectorAll('.chk');
    
    // 'checkboxAll' 아이콘 클릭 이벤트 리스너 추가
    checkboxAll.addEventListener('click', function() {
        // 'checkboxAll' 아이콘의 현재 클래스가 'bi-square'인지 확인
        const isChecked = checkboxAll.classList.contains('bi-square');
        
        // 모든 개별 체크박스 아이콘의 클래스 변경
        checkboxes.forEach(function(checkbox) {
            if (isChecked) {
                checkboxAll.classList.remove('bi-square');
                checkboxAll.classList.add('bi-check-square-fill');
                checkbox.classList.remove('bi-square');
                checkbox.classList.add('bi-check-square-fill');
            } else {
                checkboxAll.classList.remove('bi-check-square-fill');
                checkboxAll.classList.add('bi-square');
                checkbox.classList.remove('bi-check-square-fill');
                checkbox.classList.add('bi-square');
            }
        });
    });
    
    // 각 개별 체크박스 아이콘에 클릭 이벤트 리스너 추가
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('click', function() {
            // 현재 아이콘의 클래스가 'bi-square'인지 확인
            const isChecked = checkbox.classList.contains('bi-square');
            // 클릭된 체크박스의 클래스 변경
            if (isChecked) {
                checkbox.classList.remove('bi-square');
                checkbox.classList.add('bi-check-square-fill');
            } else {
                checkbox.classList.remove('bi-check-square-fill');
                checkbox.classList.add('bi-square');
            }
            
            // 모든 체크박스 아이콘이 체크 상태인지 확인
            const totalCnt = checkboxes.length;
            const checkedCnt = document.querySelectorAll('.chk.bi-check-square-fill').length;
            if (totalCnt === checkedCnt) {
                checkboxAll.classList.remove('bi-square');
                checkboxAll.classList.add('bi-check-square-fill');
            } else {
                checkboxAll.classList.remove('bi-check-square-fill');
                checkboxAll.classList.add('bi-square');
            }
        });
    });
    
});

    // // 필수 체크박스 검사를 위한 함수
    // function checkEssential() {
    //     // 필수 체크박스 중 체크되지 않은 항목이 있는지 확인
    //     const essentialCheckboxes = document.querySelectorAll('.chk[name="mustCheck"]');
    //     const essentialUnchecked = Array.from(essentialCheckboxes).some(cb => cb.classList.contains('bi-square'));
        
    //     // 필수 체크박스가 모두 체크된 경우에만 제출 허용
    //     if (essentialUnchecked) {
    //         alert('필수 항목에 동의해주세요.');
    //         return false; // 제출 방지
    //     }
    //     return true; // 제출 허용
    // }
    document.getElementById('startBtn').addEventListener('click', function() {
        // 회원가입 정보를 가져오는 코드
        const signUpData = {
            nickname: document.getElementById('nickname').value,
            userId: document.getElementById('userId').value,
            userPwd: document.getElementById('userPwd').value,
            // 이하 필요한 정보들을 추가로 가져옴
        };

        const essentialCheckboxes = document.querySelectorAll('.chk[name="mustCheck"]');
            const essentialUnchecked = Array.from(essentialCheckboxes).some(cb => cb.classList.contains('bi-square'));
            
            // 필수 체크박스가 모두 체크된 경우에만 제출 허용
            if (essentialUnchecked) {
                alert('필수 항목에 동의해주세요.');
                return false; // 제출 방지
            }

            // 서버로 회원가입 정보를 전송
            const form = document.forms.thisForm;
            form.submit();
                
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