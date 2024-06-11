<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <!-- 라이브러리 -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/teo/js/noticeListView.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
        <div id="notice_header">
        	<br><br>
            <h1>공지사항</h1>
            <img src="${pageContext.request.contextPath}/resources/teo/img/mocozy1.JPG" alt="이미지">
        </div>
        
        <table align="center" id="notice_list_table">
            <thead  >
                <tr>
                    <th >번호</th>
                    <th style="width: 70%;">제목</th>
                    <th >조회수</th>
                    <th >글쓴이</th>
                    <th >날짜</th>
                </tr>
            </thead>
            <tbody align="center">
            	<c:forEach var="n" items="${list}">
            		<tr>
	                    <td>${n.noticeNo}</td>
	                    <td class="notice_title" ><p onclick="location.href = 'detail.no?nno=${n.noticeNo}'">[${n.noticeType}] ${n.noticeTitle} (${n.replys})</p></td>
	                    <td>${n.count}</td>
	                    <td>${n.nickname}</td>
	                    <td>${n.modifyDate}</td>
	                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <div class="notice_search_bar_div">
            <select name="keywordType" id="keyword_type">
                <option>제목</option>
                <option>작성자</option>
                <option>말머리</option>
            </select>
            <input id="search_keyword" type="text" name="keyword">
            <button id="notice_search_btn">검 색</button>
        </div>
        
       	<c:if test="${loginUser.admin eq 'Y'}">
       		<button class="notice_write_btn background_color_green color_white font_weight_bold" 
        	onclick="location.href='enrollForm.no'">작 성</button>
       	</c:if>
        
        <div class="paging_bar">
        	<c:if test="${pi.currentPage ne 1}">
				<button class="page_btn"><i class="fa-solid fa-angle-left" onclick="location.href='list.no?cpage=${pi.currentPage - 1}'"></i></button>
			</c:if>
        	<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
        		<c:choose>
        			<c:when test="${p eq pi.currentPage }">
        				<div class="notice_cpage">${p}</div>
        			</c:when>
        			<c:otherwise>
        			    <button class="page_btn" onclick="location.href='list.no?cpage=${p}'">${p}</button>
        			</c:otherwise>
        		</c:choose>
        	</c:forEach>
			<c:if test="${pi.currentPage ne pi.maxPage}">
				<button class="page_btn" onclick="location.href='list.no?cpage=${pi.currentPage + 1}'"><i class="fa-solid fa-angle-right"></i></button>
			</c:if>
        </div>
    </div>
</body>
</html>