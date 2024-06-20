// function naverLogin() {
//     const clientId = 'bkMzl1hFtQzbR1kFgkTh'; // 네이버에서 발급받은 Client ID
//     const redirectUri = encodeURIComponent('http://localhost:8890/mocozy/naver-login');
//     const state = Math.random().toString(36).substring(2); // 보안용으로 사용할 랜덤 문자열
    
//     const apiURL = `https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}&state=${state}`;
    
//     window.open.href = apiURL;
// }   

window.onload = function() {
    const errorMsg = '<%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %>';
    if (errorMsg) {
        alert(errorMsg);
    }
};

//네이버로그인설정
function naverLogin(){
    console.log(1);
    const clientId = "bkMzl1hFtQzbR1kFgkTh";
    console.log(clientId);
    //리다이렉트 URI를 utf-8로 인코딩해서 저장
    const redirectURI = encodeURIComponent("http://localhost:8890/mocozy/naver-login");

    const state = Math.random().toString(36).substring(2);
    
    //로그인 api url
    window.open('https://nid.naver.com/oauth2.0/authorize?response_type=code&'
        + 'client_id=' + clientId + "&redirect_uri=" + redirectURI + '&state=' + state)
}