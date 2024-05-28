<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<head>
<%-- 공용 --%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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

<%-- include libraries(jQuery, bootstrap) --%>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%-- include summernote css/js --%>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<%-- --%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/header.css">
<script type="text/javascript" async=""
	src="${pageContext.request.contextPath}/resources/jo/js/common_js/header.js"></script>
</head>

<body>
	<div class="header">
		<%-- 로그인 토글 -- %>
<%--  <c:choose>-- %>
<%--    <c:when test="${empty loginUser}">--%>
		<div class="LoginToggle" id="LoginToggle">
			<a class="Togglelink" id="Togglelink" href="enrollform.cl"> 
			<svg class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
			  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
			  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
			</svg>
				<div class="Toggle">모임 작성하기</div>
			</a>

			<div class="Toggleborder"></div>

			<a class="Togglelink" id="Togglelink" href="myPage.me"> 
			<svg class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
			  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
			</svg>
				<div class="Toggle">마이페이지</div>
			</a> 
			
			<a class="Togglelink" id="Togglelink" href="logout.me"> 
			<svg class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
			  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z"/>
			  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z"/>
			</svg>
				<div class="Toggle">로그아웃</div>
			</a> 
			
			<a class="Togglelink" id="Togglelink" href="_blank"> 
			<svg class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-right-heart-fill" viewBox="0 0 16 16">
			  <path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353zM8 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
			</svg>
				<div class="Toggle">찜 목록</div>
			</a>

			<div class="Toggleborder"></div>

			<a class="Togglelink" id="Togglelink" href="_blank"> 
			<svg  class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-megaphone" viewBox="0 0 16 16">
			  <path d="M13 2.5a1.5 1.5 0 0 1 3 0v11a1.5 1.5 0 0 1-3 0v-.214c-2.162-1.241-4.49-1.843-6.912-2.083l.405 2.712A1 1 0 0 1 5.51 15.1h-.548a1 1 0 0 1-.916-.599l-1.85-3.49-.202-.003A2.014 2.014 0 0 1 0 9V7a2.02 2.02 0 0 1 1.992-2.013 75 75 0 0 0 2.483-.075c3.043-.154 6.148-.849 8.525-2.199zm1 0v11a.5.5 0 0 0 1 0v-11a.5.5 0 0 0-1 0m-1 1.35c-2.344 1.205-5.209 1.842-8 2.033v4.233q.27.015.537.036c2.568.189 5.093.744 7.463 1.993zm-9 6.215v-4.13a95 95 0 0 1-1.992.052A1.02 1.02 0 0 0 1 7v2c0 .55.448 1.002 1.006 1.009A61 61 0 0 1 4 10.065m-.657.975 1.609 3.037.01.024h.548l-.002-.014-.443-2.966a68 68 0 0 0-1.722-.082z"/>
			</svg>
				<div class="Toggle">공지사항</div>
			</a> 
			
			<a class="Togglelink" id="Togglelink" href="_blank"> 
			<svg class="Toggleimg" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-dots" viewBox="0 0 16 16">
			  <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0m4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0m3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
			  <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9 9 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.4 10.4 0 0 1-.524 2.318l-.003.011a11 11 0 0 1-.244.637c-.079.186.074.394.273.362a22 22 0 0 0 .693-.125m.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6-3.004 6-7 6a8 8 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a11 11 0 0 0 .398-2"/>
			</svg>
				<div class="Toggle">관리자 1:1 채팅</div>
			</a>
		</div>
		<%--  </c:when>-- %>
<%--  <c:otherwise>-- %>
<%--  <c:choose>--%>
		<%--  <c:when test="${loginUser.authority == 'N'}">--%>
		<%-- 관리자 토글 -- %>
<%--  <div class="LoginToggle" id="LoginToggle">--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img class="Toggleimg" src="_blank" alt="모임 작성하기" />--%>
		<%--      <div class="Toggle">공지사항 작성하기</div>--%>
		<%--    </a>--%>

		<%--    <div class="Toggleborder"></div>--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img src="_blank" class="Toggleimg" alt="마이페이지" />--%>
		<%--      <div class="Toggle">관리자페이지</div>--%>
		<%--    </a>--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img src="_blank" class="Toggleimg" alt="로그아웃" />--%>
		<%--      <div class="Toggle">로그아웃</div>--%>
		<%--    </a>--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img src="_blank" class="Toggleimg" alt="찜 목록" />--%>
		<%--      <div class="Toggle">찜 목록</div>--%>
		<%--    </a>--%>

		<%--    <div class="Toggleborder"></div>--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img src="_blank" class="Toggleimg" alt="공지사항" />--%>
		<%--      <div class="Toggle">공지사항</div>--%>
		<%--    </a>--%>

		<%--    <a class="Togglelink" id="Togglelink" href="_blank">--%>
		<%--      <img src="_blank" class="Toggleimg" alt="관리자 1:1 채팅" />--%>
		<%--      <div class="Toggle">1:1 채팅</div>--%>
		<%--    </a>--%>
		<%--  </div>--%>
		<%--  </c:otherwise>--%>
		<%--  </c:choose>--%>
		<%--  </c:otherwise>--%>
		<%--  </c:choose>--%>

		<%-- 헤더 --%>
		<div class="bar">

			<div class="loginwrap">
				<%-- 로그인바 - 로고--%>
				<div class="logobox">
					<a href="${pageContext.request.contextPath}"> 
					<img src="${pageContext.request.contextPath}/resources/jo/upfile/common_img/logo.png" class="searchlogo" />
					</a>
					<%-- 로그인바 - 검색바 --%>
					<div class="search">
						<form class="searchForm" action="searchForm.sc" method="GET">
							<input type="hidden" name="rpage" value="1">
							<input type="text" 	name="keyword" class="searchInput" id="search-box" value="${keyword}" placeholder="원하는 모임을 검색해보세요.">
							
							<button type="submit" value="검색">
								<svg class="searchIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  									<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 
  											1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
								</svg>
							</button>
						</form>
					</div>
				</div>

				<%-- 로그인바 - 회원정보 --%>
				<!-- <div class="userId">
					<div class="profile" href="_blank">
						<img class="profileImg" src="_blank" alt="image" />
					</div>
					<div class="alarm">+99</div>
					<button class="userName" id="userName" type="button">
						떡꼬치대마왕 님</button>
				</div> -->
				<%-- 로그인바 - 로그인 --%>
				<div class="userId">
				<c:choose>
		         	<c:when test="${empty loginUser}">
			              <!-- 로그인 전 -->
			              <a href="loginPage.me">로그인</a>
		         	</c:when>
			             <c:otherwise>
				            <!-- 로그인 후 -->
				            <div class="profile" href="_blank">
								<img class="profileImg" src="_blank" alt="image" />
							</div>
							<div class="alarm">+99</div>
				              <button class="userName" id="userName" type="button">
				              	${loginUser.nickname} 님</button>
			             </c:otherwise>
		         </c:choose>
            
      </div>
			</div>
		</div>


		<%-- 메뉴바 --%>
		<div class="menuwrap">
			<div class="catewrap">
				<%--카테고리 버튼--%>
				<div class="categories">
					<div class="cate">
						<button class="catebtn" type="button" id="cateButton">
							<svg class="cateIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
  								<path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 
  										1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
							</svg>
							
							<p class="cateTitle">카테고리</p>
						</button>
						<a class="catelist" id="catesocial" href="${pageContext.request.contextPath}">소셜링</a> 
						<a class="catelist" id="catechallenge" href="challenge.ma">챌린지</a>
					</div>

					<div class="studio">
						<div class="stu">
							<a href="cateHot.ct">실시간 HOT 🔥</a>
						</div>

						<div class="studioBorder"></div>

						<div class="stubutton">
							<a href="cateBest20.ct">주간베스트</a>
						</div>
					</div>

				</div>
			</div>

			<%-- 카테고리 --%>
			<div class="cateToggle" id="cateToggle">
				<div class="grid">
					<div class="categrid">
						<h3 class="getName">
							<a href="cateAll.ct">전체</a>
						</h3>
						<div class="getTitle">
							<%-- 빈칸 --%>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">인기</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="cateBest20.ct" class="cateT">주간 베스트 20</a> <a href="cateReview.ct"
									class="cateT">HOT 클래스</a> <a href="_blank" class="cateT">최대 리뷰순</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">문화생활</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="cateArt.ct" class="cateT">문화 · 예술</a> <a href="cateFood.ct"
									class="cateT">푸드 · 드링크</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">미래발전</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="cateDevelope.ct" class="cateT">자기계발</a> 
								<a href="cateInvest.ct" class="cateT">재테크</a> 
								<a href="cateForeign.ct" class="cateT">외국어</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">스포츠</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="cateActivity.ct" class="cateT">액비티비</a> 
								<a href="cateTravel.ct" class="cateT">여행 · 동행</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">취미</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="cateHobby.ct" class="cateT">취미</a> 
								<a href="cateGame.ct" class="cateT">파티 · 게임</a> 
								<a href="cateLove.ct" class="cateT">연애 · 사랑</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>