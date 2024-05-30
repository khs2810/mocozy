<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공자사항 상세페이지</title>
	
	<!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">
    
    <!-- 라이브러리 -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/teo/js/noticeDetailView.js"></script>
    
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
        <h1>[${n.noticeType}] ${n.noticeTitle}</h1>
        <p>${n.modifyDate}</p>
        <div class="notice_detail_update_btn">
        	<c:if test="${loginUser.nickname eq n.nickname}">
	       		<button class="background_color_green color_white font_weight_bold" onclick="location.href='updateForm.no?nno=${n.noticeNo}'">수 정</button>
           		<button class="background_color_green color_white font_weight_bold" onclick="confirmDelete(${n.noticeNo})">삭 제</button>
	       	</c:if>
        </div>
        <div class="notice_detail_content">
            ${n.noticeContent}
        </div>
        <div class="notice_detail_update_btn">
	       		<button class="background_color_brown color_white font_weight_bold" style="color:black;" onclick="location.href='list.no'">목 록</button>
        </div>
        <div id="notice_review">
            <h3 id="notice_review_size_h">댓글(${rlist.size()})</h3>
            <table id="review_table">
            	<c:choose>
            		<c:when test="${rlist.size() ne 0}">
            			<c:forEach var="p" items="${rlist}">
            				<tr>
            					<td style="padding-left: 5px; width: 105px">${p.nickname}</td>
			                    <td style="width: 75%; padding-left: 14px;">${p.replyContent}</td>
			                    <td>${p.modifyDate}</td>
                                <c:if test="${p.nickname eq loginUser.nickname}">
                                    <td><button id="notice_review_delete_btn" data-rno="${p.replyNo}" data-nno="${n.noticeNo}">X</button></td> <!-- 본인 리뷰일때만 보이게  -->
                                </c:if>
			                    
            				</tr>
            			</c:forEach>
            		</c:when>
            		<c:otherwise>
            			<tr>
            				<td colspan="4" align="center">
            					등록된 댓글이 없습니다.
            				</td>
            			</tr>
            		</c:otherwise>
            	</c:choose>
            </table>
            <br>
            <div id="review_write_box">
                <c:choose>
                    <c:when test="${loginUser eq null}">
                        <h4>닉네임</h4>
                    </c:when>
                    <c:otherwise>
                        <h4>${loginUser.nickname}</h4>
                    </c:otherwise>
                </c:choose>
                <div class="review_content_write_box">
                    <div class="review_content_write">
                        <textarea id="reply_content" required></textarea>
                    </div>
                    <button type="button" id="enroll_notice_reply" data-nno="${n.noticeNo}" data-uno="${loginUser.userNo}" class="background_color_green color_white font_weight_bold review_enroll_btn">
                    	등 록
                    </button>
                </div>
            </div>
            <input id="loginuser_userno_hidden" type="hidden" value="${loginUser.userNo}">
        </div>
    </div>
    <br>
</body>
</html>