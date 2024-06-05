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


function deleteMember() {
    const userPwd = document.getElementById('userPwd').value;

    if (userPwd === "") {
        alert("비밀번호를 입력해주세요.");
        return;
    }

}
