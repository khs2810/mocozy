<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>모임 신청 내역 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/requestListPage.css">
</head>
<body>
	<%@ include file="../common/Header.jsp"%>
    <div id="contentBox">
        <h2>모임 신청 목록</h2>
        <hr style="background: lightgray; height: 1px; border: 0;" >
        <br><br>
        <div class="clubList">
            <div class="titlePart">
                <span class="title">♥블랙라이어♥:: with.하이볼 무제한🍺</span>
                <div class="ing">모집중(18/20)</div>
            </div>
            <div class="clubRequestList">
                <div class="selectedClubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치대마왕</b>
                            <img src="${pageContext.request.contextPath}/resources/jun/img/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 09:40</span>
                            <button type="button" class="reduceBtn" style="background-color: #F6EEE2;">︿</button>
                        </div>
                    </div>
                    <div class="detailInfo">
                        <pre class="detail">    [질문] 나이 / 성별 / 직업 / MBTI 를 작성해주세요 ✨
            (블랙라이어 지원하실 분은 요기에 남겨주세용💌)

    [대답] 26살 / 남자 / 홈프로텍터 / ESFJ</pre>
                        <div class="btns">
                            <button type="button" class="denyBtn">거절</button>
                            <button type="button" class="acceptBtn">수락</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치중마왕</b>
                            <img src="${pageContext.request.contextPath}/resources/jun/img/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 10:31</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치소마왕</b>
                            <img src="${pageContext.request.contextPath}/resources/jun/img/waiting.png" class="status_w">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.05.02 10:48</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clubList">
            <div class="titlePart">
                <span class="title">【D-2🐥어른이날】 천지방축 운동회</span>
                <div class="done">모집완료(50/50)</div>
            </div>
            <div class="clubRequestList">
                <div class="selectedClubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치대마왕</b>
                            <img src="${pageContext.request.contextPath}/resources/jun/img/accepted.png" class="status_a">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.04.16 00:12</span>
                            <button type="button" class="reduceBtn" style="background-color: #F6EEE2;">︿</button>
                        </div>
                    </div>
                    <div class="detailInfo">
                        <pre class="detail">    [질문] 1. 성별  2. 나이  3. MBTI  4. 관심종목  5. 운동신경 1~10
    
    [대답] 1. 남자  2. 26살  3. ESFJ  4. 구기종목  5. 운동신경 6</pre>
                        <div class="btns">
                            <button type="button" class="acceptedBtn">수락됨</button>
                        </div>
                    </div>
                </div>
                <div class="clubRequest">
                    <div class="simpleInfo">
                        <div class="simpleInfoLeft">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                            <b class="userId">떡꼬치중마왕</b>
                            <img src="${pageContext.request.contextPath}/resources/jun/img/denied.png" class="status_d">
                        </div>
                        <div class="simpleInfoRight">
                            <span class="writeTime">2024.04.17 17:09</span>
                            <button class="reduceBtn">﹀</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><br>

    <!-- The Modal -->
    <div class="modal fade" id="profileModal">
        <div class="modal-dialog">
            <div class="profile-modal-content">
            
                <!-- Modal Header -->
                <div class="profile-modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                </div>
                
                <!-- Modal body -->
                <div class="profile-modal-body">
                    <div class="m-userProfile">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="m-profileImg">
                        <span class="nickname">떡꼬치대마왕</span>
                        <span> 님</span>
                    </div>
                    <div class="m-manner">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/로고.png" class="m-logo-area">
                        <div class="m-manner-area">
                            <span>매너 점수</span>
                            <div class="m-manner-score-area">
                                <div class="m-score-range">
                                    <p>0</p>
                                    <p>100</p>
                                </div>
                                <div class="m-manner-score"></div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Modal footer -->
                <div class="profile-modal-bottom">
                    <h6 style="font-size: 20px; font-weight: 600; margin: 10px 30px;">자기소개</h6>
                    <textarea class="m-introduction"></textarea>
                </div>
                
            </div>
        </div>
    </div>
</body>
</html>