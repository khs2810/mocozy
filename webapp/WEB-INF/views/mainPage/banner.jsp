<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/91f9609a45.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/banner.css">
<script type="text/javascript" async=""
	src="${pageContext.request.contextPath}/resources/jo/js/mainPage_js/banner.js"></script>
</head>

<body>
	<div class="banner">
		<div class="slide" id="slide">
			<div class="item1" id="item"></div>
			<div class="item2" id="item"></div>
			<div class="item3" id="item"></div>
			<div class="item4" id="item"></div>
			<div class="item5" id="item"></div>
			<div class="item6" id="item"></div>
			<div class="item7" id="item"></div>
			<div class="item8" id="item"></div>
			<div class="prev" id="prev"></div>
			<div class="next" id="next"></div>
		</div>
	</div>
</body>

</html>