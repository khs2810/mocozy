<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/banner.css">
<script type="text/javascript" async="" src="${pageContext.request.contextPath}/resources/jo/js/mainPage_js/banner.js"></script>
</head>

<body>
	<div class="bannerbox"></div>
	<div class="banner">
		<div class="slide" id="slide">
			<div class="item1" id="item"><a href="eventTravel.ev"></a></div>
			<div class="item2" id="item"><a href="eventArt.ev"></a></div>
			<div class="item3" id="item"><a href="eventFood.ev"></a></div>
			<div class="item4" id="item"><a href="eventPhoto.ev"></a></div>
			<div class="item5" id="item"><a href="eventStudy.ev"></a></div>
			<div class="item6" id="item"><a href="eventGame.ev"></a></div>
			<div class="item7" id="item"><a href="eventParty.ev"></a></div>
			<div class="item8" id="item"><a href="eventLove.ev"></a></div>
			<div class="prev" id="prev"></div>
			<div class="next" id="next"></div>
		</div>
	</div>
</body>

</html>