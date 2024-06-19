function naverLogin() {
    const clientId = 'bkMzl1hFtQzbR1kFgkTh'; // 네이버에서 발급받은 Client ID
    const redirectUri = encodeURIComponent('http://localhost:8890/mocozy/naver-login');
    const state = 'RANDOM_STATE'; // 보안용으로 사용할 랜덤 문자열
    
    const apiURL = `https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}&state=${state}`;
    
    window.location.href = apiURL;
}