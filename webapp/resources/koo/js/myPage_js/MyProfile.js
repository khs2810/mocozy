// 자기소개 글자수
function counter(){
    var content = document.getElementById('jagisogae').value;
    if (content.length > 50){
        content = content.substring(0,50);
        document.getElementById('jagisogae').value = content;
    }
   
    document.getElementById('count').innerHTML = '('+content.length+'/50)'

};
counter();

function withdraw(){
    var drawcheck = document.querySelector('input[name="checked"]:checked')
    if(drawcheck == 0) {
        alert('동의에 체크해주세요.')
        return false;
    }
}

function deleteMember() {
    const userPwd = document.getElementById('userPwd').value;

    if (userPwd === "") {
        alert("비밀번호를 입력해주세요.");
        return false;
    } else {
        alert("회원탈퇴가 성공적으로 이루어졌습니다.");
        return true;
    }

}

function loadImg(inputFile, num, contextPath){
    // console.log(inputFile)
    // console.log(num)
    //inputFile : 현재 변화가 생긴 input type=file 요소객체
    //num : 몇번째 input요소인지 확인하기 위한 파라미터
    
    
    //inputFile.files[0] => 선택된 파일이 담겨있다.
    //inputFile.files.length -> 1
    // console.log(inputFile.files.length)

    if (inputFile.files.length == 1){//파일을 하나 선택 => 미리보기
        const reader = new FileReader();

        reader.readAsDataURL(inputFile.files[0]);

        reader.onload = function(ev){
            if(num == 1) {
                document.getElementById("fileImg").src = ev.target.result;
            }
        }
    } else { // 선택된 파일을 취소한 경우 => 미리보기 지우기
        if (num == 1) {
			document.getElementById("fileImg").src = contextPath + "/resources/jun/img/fileImg.png";
			console.log(document.getElementById("fileImg").src);
        }
    }
}

function chooseFile(num){
    document.getElementById('fileInput');
    const imgInput = document.querySelector("#file" + num);
    imgInput.click();
}

// 폼 제출 시 파일 입력이 비어있는지 검사
document.getElementById('profileForm').addEventListener('submit', function(event) {
    const fileInput = document.getElementById('file1');
    if (fileInput.files.length === 0) {
        alert('파일을 선택해주세요.');
        event.preventDefault(); // 폼 제출 중단
        chooseFile(1); // 파일 선택 창 열기
    }
});