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
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/subBanner.css">
<script type="text/javascript" async=""
	src="${pageContext.request.contextPath}/resources/jo/js/mainPage_js/subBanner.js"></script>
</head>

<body>
	<div class="Subbanner">
		<div class="subslide" id="subslide">
			<div class="subitem1" id="subitem"><a href="detail.no?nno=47"></a></div>
			<div class="subitem2" id="subitem"><a href="detail.no?nno=46"></a></div>
			<div class="subprev" id="subprev"></div>
			<div class="subnext" id="subnext"></div>
		</div>
	</div>
</body>

</html>