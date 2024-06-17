<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜 - 소셜링</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/challengeManagePage.css">
    

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!--Get your code at fontawesome.com-->
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/dibsSocialPage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPageCommon.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/mySocial.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/dibs.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/social.css" />
    
    
    

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <!-- 메인 컨텐츠 부 전체-->
        <div class="main-content">
            <!-- 메인컨텐츠 타이틀 -->
            <div class="title">
                <h1>찜</h1>
                <h3>소셜링</h3>
                
                <!-- 셀렉버튼 -->
                <!-- <div class="title-select">
                    <select id="optionSelect">
                        <option value="진행중" selected>진행중</option>
                        <option value="종료됨">종료됨</option>
                    </select>
                </div>  -->
            </div>
            <hr>

            <!-- 컨텐츠 내용 -->
            <!-- 찜한 진행중인 소셜링 목록 -->
            <div id="club-ing">
                <c:forEach var="Club" items="${dibsclist}">
                    <div class="club-content">
                        <div class="club-img" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${Club.clubNo}';">
                            <img src="${pageContext.request.contextPath}/${Club.thumbnailImg}">
                        </div>
                        <div class="club-title" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${Club.clubNo}';">
                            <h4>${Club.clubTitle}</h4>
                            <p>카테고리 : ${Club.categoryName1} > ${Club.categoryName2}</p>
                            <P>모임 날짜 : ${Club.eventDate}</P>
                        </div>
                        <div class="status">
                            <!-- 찜 -->
                            <div class="dibs">
                                <div class="club_picked" onclick="clickedPicked('${Club.clubNo}', '${loginUser.userNo}', this)">
                                    <i class="fa-solid fa-heart" style="color: red; display: flex; justify-content: flex-end;"></i>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${Club.memberCnt eq Club.capacity}">
                                    <div class="done">
                                        <p>모집완료(${Club.memberCnt}/${Club.capacity})</p>
                                    </div>
                                </c:when>
                                <c:when test="${Club.memberCnt ne Club.capacity}">
                                    <div class="ing">
                                        <p>모집중(${Club.memberCnt}/${Club.capacity})</p>
                                    </div>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
        
        </div>
    </div>

    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>
    
</body>
</html>