<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 등록</title>

    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
	
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

    <!-- 라이브러리 -->
    <script src="${pageContext.request.contextPath}/resources/teo/js/noticeEnrollSummernote.js"></script>
    
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
	    <form method="post" action="update.no" enctype="multipart/form-data">
	    	<input name="noticeNo" type="hidden" value="${n.noticeNo}" >
	        <div id="wapper_notice_enroll">
	            <div>
	                <span>제목</span>
	                <input id="input_notice_title" name="noticeTitle" type="text" value="${n.noticeTitle}" required>
	            </div>
	            <div class="notice_div_second_row" >
	                <div>
	                    <span>말머리</span>
	                    <select name="noticeType">
	                    	<c:choose>
	                    		<c:when test="${n.noticeType eq '공지'}">
	                    			<option selected>공지</option>
	                        		<option>이벤트</option>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<option>공지</option>
	                        		<option selected>이벤트</option>
	                    		</c:otherwise>
	                    	</c:choose>
	                        
	                    </select>
	                </div>
	                <div>
	                    <span>작성자</span>
	                    <input id="input_notice_writer" name="nickname" type="text" value="${n.nickname}" readonly>
	                </div>
	            </div>
				<div >
					<div class="notice_div_second_banner" >
						<span>배너</span>
						<input style="font-size: 17.5px; margin-left: 10px;" type="file" name="reupfile" value="배너등록">
					</div>
					<c:if test="${not empty n.bannerPath}">
						<div>
							<span>현재 배너 </span>
							<a id="banner_download" href="${n.bannerPath}" download="${n.bannerPath}"><i class="fa-solid fa-file-arrow-down"></i></i></a>
							<input type="hidden" name="bannerPath" value="${n.bannerPath}">
						</div>
					</c:if>
				</div>
	        </div>
	        <div class="summernote_div">
	            <textarea id="summernote" name="noticeContent" required>${n.noticeContent}</textarea>
	        </div>
	        <div class="notice_enroll_btns">
	            <button type="button" class="background_color_brown font_weight_bold" onclick="location.href = 'detail.no?nno=${n.noticeNo}'">이 전</button>
	            <button type="submit" class="background_color_green font_weight_bold">등 록</button>
	        </div>
        </form>
    </div>
</body>
</html>