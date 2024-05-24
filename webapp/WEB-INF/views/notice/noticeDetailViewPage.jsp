<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공자사항 상세페이지</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
        <h1>[${n.noticeType}] ${n.noticeTitle}</h1>
        <p>${n.modifyDate}</p>
        <div class="notice_detail_content">
            ${n.noticeContent}
        </div>
        <div class="notice_detail_update_btn">
            <button class="background_color_green color_white font_weight_bold">수 정</button>
            <button class="background_color_green color_white font_weight_bold">삭 제</button>
        </div>
        <div id="notice_review">
            <h3>댓글(${rlist.size()})</h3>
            <table id="review_table">
            	<c:choose>
            		<c:when test="${rlist.size() ne 0}">
            			<c:forEach var="p" items="${rlist}">
            				<tr>
            					<td style="padding-left: 5px;">${p.nickname}</td>
			                    <td style="width: 75%; padding-left: 14px;">${p.replyContent}</td>
			                    <td>${p.modifyDate}</td>
			                    <td>X</td> <!-- 본인 리뷰일때만 보이게  -->
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
                <h4>떡꼬치대마왕</h4>
                <div class="review_content_write_box">
                    <div class="review_content_write">
                        <textarea></textarea>
                    </div>
                    <button class="background_color_green color_white font_weight_bold review_enroll_btn">등 록</button>
                </div>
            </div>
        </div>
    </div>
    <br>
</body>
</html>