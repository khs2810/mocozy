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
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrapper_notice">
        <div id="notice_header">
            <h1>공지사항</h1>
            <img src="${pageContext.request.contextPath}/resources/teo/img/mocozy1.JPG" alt="이미지">
        </div>
        
        <table align="center" id="notice_list_table">
            <thead>
                <tr>
                    <th >번호</th>
                    <th style="width: 70%;">제목</th>
                    <th >조회수</th>
                    <th >글쓴이</th>
                    <th >날짜</th>
                </tr>
            </thead>
            <tbody align="center">
                <tr>
                    <td>6</td>
                    <td class="notice_title" ><p onclick="location.href = 'detail.no'">[공지] 5.5.0버전 업데이트 안내</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td class="notice_title"><p>[공지] 5.5.0버전 업데이트 안내</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td class="notice_title"><p>[공지] 5.5.0버전 업데이트 안내</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td class="notice_title"><p>[공지] 5.5.0버전 업데이트 안내</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="notice_title"><p>[공지] 5.5.0버전 업데이트 안내</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td class="notice_title"><p>[이벤트] 이벤트입니다</p></td>
                    <td>12</td>
                    <td>관리자</td>
                    <td>24.05.02</td>
                </tr>
            </tbody>
        </table>
        <div class="notice_search_bar_div">
            <select name="" id="">
                <option >제목</option>
                <option >작성자</option>
                <option >말머리</option>
            </select>
            <input type="text">
            <button id="notice_search-btn">검 색</button>
        </div>

        <button class="notice_write_btn background_color_green color_white font_weight_bold" 
        	onclick="location.href='enrollForm.no'">작 성</button>
        <div class="paging_bar">
            <button disabled>1</button>
            <button>2</button>
            <button>3</button>
            <button><i class="fa-solid fa-angle-right"></i></button>
        </div>
    </div>
</body>
</html>