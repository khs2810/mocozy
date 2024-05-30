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
    <script src="${pageContext.request.contextPath}/resources/jun/js/requestListPage.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="contentBox">
        <h2>모임 신청 목록</h2>
        <hr style="background: lightgray; height: 1px; border: 0;" >
        <br><br>
        <div class="clubList">
        	<div class="titlePart">
                <span class="title">${c.clubTitle}</span>
                <c:choose>
                	<c:when test="${memberCnt eq c.capacity}">
                		<div class="done">모집완료(${memberCnt}/${c.capacity})</div>
                	</c:when>
                	<c:when test="${memberCnt ne c.capacity}">
                		<div class="ing">모집중(${memberCnt}/${c.capacity})</div>
                	</c:when>
                </c:choose>
            </div>
            <div class="clubRequestList" id="clubRequestList">
            	<c:forEach var="r" items="${requestList}">
	                <div class="clubRequest">
	                    <div class="clubRequest-head">
	                        <div class="simpleInfo">
	                            <div class="simpleInfoLeft">
	                                <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="profileImg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
	                                <b class="userId">${r.nickname}</b>
	                                <c:choose>
	                                	<c:when test="${r.status eq 'W'}">
			                                <img src="${pageContext.request.contextPath}/resources/jun/img/waiting.png" class="status_w">
	                                	</c:when>
	                                	<c:when test="${r.status eq 'Y'}">
			                                <img src="${pageContext.request.contextPath}/resources/jun/img/accepted.png" class="status_a">
	                                	</c:when>
	                                	<c:when test="${r.status eq 'N'}">
			                                <img src="${pageContext.request.contextPath}/resources/jun/img/denied.png" class="status_d">
	                                	</c:when>
	                                </c:choose>
	                            </div>
	                            <div class="simpleInfoRight">
	                                <span class="writeTime">${r.createDate}</span>
	                                <button class="reduceBtn"><i class="fa-solid fa-chevron-down"></i></button>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="selectedClubRequest">
	                        <div class="detailInfo">
                                <div>
                                    <pre class="detail">[질문] ${c.question}<br><br>[대답] ${r.answer}
                                </div>
                                <input type="text" value="${r.clubNo}" hidden>
	                            <div class="btns">
	                            	<c:choose>
	                            		<c:when test="${r.status eq 'W'}">
			                                <button type="button" class="denyBtn" data-rqno="${r.requestNo}" data-cno="${r.clubNo}" data-url="${pageContext.request.contextPath}" data-question="${c.question}">거절</button>
			                                <button type="button" class="acceptBtn" data-rqno="${r.requestNo}" data-cno="${r.clubNo}" data-url="${pageContext.request.contextPath}" data-question="${c.question}">수락</button>	                            			
	                            		</c:when>
	                            		<c:when test="${r.status eq 'Y'}">
			                                <button type="button" class="acceptedBtn">수락됨</button>
	                            		</c:when>
	                            		<c:when test="${r.status eq 'N'}">
			                                <button type="button" class="deniedBtn">거절됨</button>
	                            		</c:when>
	                            	</c:choose>
	                            </div>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
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