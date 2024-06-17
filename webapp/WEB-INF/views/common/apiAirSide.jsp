<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/apiAirSide.css">

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <script src="${pageContext.request.contextPath}/resources/teo/js/ajaxAirSide.js"></script>
    
</head>
<body>
    <div id="air_side_bar" align="center">
        <div>
            <h3>대기오염정보</h3>
            <h4>서울 강남구</h4>
        </div>
        <table id="air_info_side">          
        </table>
    </div>
</body>
</html>