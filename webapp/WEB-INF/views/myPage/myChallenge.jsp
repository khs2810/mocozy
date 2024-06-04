<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 내가 만든 챌린지</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/social.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!--Get your code at fontawesome.com-->
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
	<script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/myChallenge.js"></script>

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
                <h1>챌린지 관리</h1>
                <h3>내가 만든 챌린지</h3>
                
                <!-- 셀렉버튼 -->
                <div class="title-select">
                    <select id="optionSelect">
                        <option value="진행중" selected>진행중</option>
                        <option value="종료됨">종료됨</option>
                    </select>
                </div> 
            </div>
            <hr>

            <!-- 진행중인 소셜링 목록 -->
            <div id="club-ing">
	            <c:forEach var="c" items="${clist}">
		            <div class="club-content">
		                <div class="club-img" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${c.clubNo}';">
		                    <img src="${pageContext.request.contextPath}/${c.thumbnailImg}">
		                </div>
		                <div class="club-title" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${c.clubNo}';">
		                    <h4>${c.clubTitle}</h4>
		                    <p>카테고리 : ${c.categoryName1} > ${c.categoryName2}</p>
		                    <P>모임 날짜 : ${c.eventDate}</P>
		                </div>
		                <div class="status">
		                    <c:choose>
			                	<c:when test="${c.memberCnt eq c.capacity}">
			                		<div class="done">
			                			<p>모집완료(${c.memberCnt}/${c.capacity})</p>
			                		</div>
			                	</c:when>
			                	<c:when test="${c.memberCnt ne c.capacity}">
			                		<div class="ing">
			                			<p>모집중(${c.memberCnt}/${c.capacity})</p>
			                		</div>
			                	</c:when>
			                </c:choose>
		                    <div class="btn">
		                        <button class="btn-style btn-color1" onclick="location.href='http://localhost:8890/mocozy/list.re?cno=${c.clubNo}'">요청목록</button>
		                        <button class="btn-style btn-color2" onclick="location.href='http://localhost:8890/mocozy/finishChallenge.me?cno=${c.clubNo}'">종료</button>
		                    </div>
		                </div>
		            </div>
	            </c:forEach>
            </div>
            
            <!-- 종료된 소셜링 목록 -->
            <div id="club-done" style="display: none;">
	            <c:forEach var="d" items="${dlist}">
		            <div class="club-content">
		                <div class="club-img" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${d.clubNo}';">
		                    <img src="${pageContext.request.contextPath}/${d.thumbnailImg}">
		                </div>
		                <div class="club-title" onclick="location.href='http://localhost:8890/mocozy/detail.cl?cno=${d.clubNo}';">
		                    <h4>${d.clubTitle}</h4>
		                    <p>카테고리 : ${d.categoryName1} > ${d.categoryName2}</p>
		                    <P>모임 날짜 : ${d.eventDate}</P>
		                </div>
		                <div class="status">
		                    <div class="done">
			                	<p>모임종료</p>
			                </div>
		                    <div class="btn">
		                        <button class="btn-style btn-color1" onclick="location.href='http://localhost:8890/mocozy/updateform.cl?cno=${d.clubNo}'">재탕</button>
		                        <button class="btn-style btn-color2" onclick="location.href='http://localhost:8890/mocozy/cancleFinishChallenge.me?cno=${d.clubNo}'">종료취소</button>
		                    </div>
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