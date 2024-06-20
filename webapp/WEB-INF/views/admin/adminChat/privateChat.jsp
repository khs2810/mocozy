<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	type="text/css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminChat_css/adminChat.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminChat_css/chat.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/privateChat.css">
<script src="${pageContext.request.contextPath}/resources/jun/js/privateChat.js"></script>
</head>

<%@ include file="../sideBar.jsp"%>
<body>
	<div class="menubar-hoverable header-fixed menubar-pin">
		<div id="contentBox">
	        <div class="chatPage">
	            <h2 class="title">모꼬지 상담요원</h2>
	            <hr style="background: lightgray; height: 1px; border: 0; margin-bottom: 0px;" >
	            <div class="chatDetail" id="chatDetail">
	                <!-- 여기에 메시지 추가됨 -->
	            </div>
	            <div class="chatInput">
	                <textarea id="textArea" placeholder="메세지를 입력해주세요"></textarea>
	                <button type="button" id="submitBtn">전송</button>
	            </div>
	        </div>
		</div>
	</div>
	<input type="hidden" id="chno" value="${chno}">
	<input type="hidden" id="loginUserNo" value="${loginUserNo}">
	<input type="hidden" id="targetNo" value="${targetNo}">
</body>
</html>