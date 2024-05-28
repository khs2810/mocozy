<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <!-- 공용 -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/resources/jo/css/search_css/searchError.css">
</head>

<%@ include file="../common/header.jsp" %>
<body>
	<div class="searcherror">
        <p class="title">
            <span class="span">${keyword}</span>
            	에 대한 <br/> 검색결과가 없습니다.
        </p>
        </div>
        <%@ include file="../common/footer.jsp" %>
</body>

</html>