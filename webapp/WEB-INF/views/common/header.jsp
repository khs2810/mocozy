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

			<a class="Togglelink" id="Togglelink" href="enrollform.cl"> <img
				class="Toggleimg" src="_blank" alt="모임 작성하기" />
				<div class="Toggle">모임 작성하기</div>
			</a>

			<div class="Toggleborder"></div>

			<a class="Togglelink" id="Togglelink" href="myPage.me"> <img
				src="_blank" class="Toggleimg" alt="마이페이지" />
				<div class="Toggle">마이페이지</div>
			</a> <a class="Togglelink" id="Togglelink" href="_blank"> <img
				src="_blank" class="Toggleimg" alt="로그아웃" />
				<div class="Toggle">로그아웃</div>
			</a> <a class="Togglelink" id="Togglelink" href="_blank"> <img
				src="_blank" class="Toggleimg" alt="찜 목록" />
				<div class="Toggle">찜 목록</div>
			</a>

			<div class="Toggleborder"></div>

			<a class="Togglelink" id="Togglelink" href="_blank"> <img
				src="_blank" class="Toggleimg" alt="공지사항" />
				<div class="Toggle">공지사항</div>
			</a> <a class="Togglelink" id="Togglelink" href="_blank"> <img
				src="_blank" class="Toggleimg" alt="관리자 1:1 채팅" />
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
					<a href="../../views/mainPage/MainPage.html"> <img src="_blank"
						class="searchlogo" />
					</a>
					<%-- 로그인바 - 검색바 --%>
					<div class="search">
						<form class="searchForm" action="_blank" method="POST">
							<input class="searchInput" placeholder="원하는 모임을 검색해보세요." value="">
							<button type="submit">
								<img src="_blank" class="searchIcon" src="검색 아이콘" />
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
				              	${loginUser.userName} 님</button>
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
							<img class="cateIcon" src="_blank" alt="">
							<p class="cateTitle">카테고리</p>
						</button>
						<a class="catelist" href="_blank">소셜링</a> <a class="catelist"
							href="_blank">챌린지</a>
					</div>

					<div class="studio">
						<div class="stu">
							<a href="_blank">실시간 HOT 🔥</a>
						</div>

						<div class="studioBorder"></div>

						<div class="stubutton">
							<a href="_blank">주간베스트</a>
						</div>
					</div>

				</div>
			</div>

			<%-- 카테고리 --%>
			<div class="cateToggle" id="cateToggle">
				<div class="grid">
					<div class="categrid">
						<h3 class="getName">
							<a href="_blank">전체</a>
						</h3>
						<div class="getTitle">
							<%-- 빈칸 --%>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">인기</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="_blank" class="cateT">주간 베스트 20</a> <a href="_blank"
									class="cateT">HOT 클래스</a> <a href="_blank" class="cateT">실시간
									랭킹</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">문화생활</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="_blank" class="cateT">문화 · 예술</a> <a href="_blank"
									class="cateT">푸드 · 드링크</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">미래발전</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="_blank" class="cateT">자기계발</a> <a href="_blank"
									class="cateT">재테크</a> <a href="_blank" class="cateT">외국어</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">스포츠</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="_blank" class="cateT">액비티비</a> <a href="_blank"
									class="cateT">여행 · 동행</a>
							</div>
						</div>
					</div>

					<div class="categrid">
						<h3 class="getName">취미</h3>
						<div class="getTitle">
							<div class="cateL">
								<a href="_blank" class="cateT">취미</a> <a href="_blank"
									class="cateT">파티 · 게임</a> <a href="_blank" class="cateT">연애
									· 사랑</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>