<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/errorPage.css">
</head>

<%@ include file="./header.jsp"%>
<body>
	<div class="errorpage">
		<div class="wrapper">
			<div class="error">

				<div class="errorimg">
					<img class="img" src="${pageContext.request.contextPath}/resources/jo/upfile/common_img/error.png" />
					<h1 class="sign">
						오류 <span class="signspan">Error</span>
					</h1>
				</div>

				<div class="sorry">
					<h2>${errorMsg}</h2>
					<p class="kor">
						요청하신 페이지를 처리 중에 오류가 발생했습니다. <br /> 
						서비스 이용에 불편을 드려 죄송합니다. <br />
						입력하신 내용이 정확한지 확인 후 다시 시도해 주시기 바랍니다.
					</p>
					<p class="eng">
						We have encountered a system error while processing your request.
						<br /> We apologize for the incovenlence. Please check input and
						try again.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>

</html>