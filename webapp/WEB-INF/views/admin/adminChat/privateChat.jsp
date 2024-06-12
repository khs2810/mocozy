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
</head>

<%@ include file="../sideBar.jsp"%>
<body>
	<div class="menubar-hoverable header-fixed menubar-pin">
		<div id="base">
			<div id="basecontent">
				<header class="top-header" id="default-header">
					<div class="headerbar">
						<div class="headerbar-left">
							<ul class="header-nav header-nav-options">
								<li class="header-nav-brand">
									<div class="brand-holder">
										<span class="location-text"> <a href="_blank"
											class="site-name">채팅</a>
										</span>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</header>

				<main id="content">
					<section class="section">
						<div class="chatbody">
							<div class="chat-normal-room">
								<div class="chat-userprofile">
									<div class="chat-header">
										<div class="chat-header-profile">
											<img class="chat-header-image" src="_blank"
												style="width: 38px; height: 38px; border-radius: 100%; border: 1px solid black;">
											<!-- 프로필 이미지-->
											<div class="main-title">
												<span>유저</span>
											</div>
										</div>
									</div>
									<!-- 채팅 목록 -->
									<div class="chatlist">
										<div class="day-divider">
											<div class="date-text">2023년 7월 29일</div>
										</div>
										<div class="for-contaiment right">
											<div class="for-containment listcontain">
												<div class="sender sender-message">
													<div class="message-date">오후 3:46</div>
												</div>
												<div class="message-wrapper">
													<div>
														<p class="message-box">안녕하세요 무엇을 도와드릴까여?</p>
													</div>
												</div>
											</div>
										</div>
										<div class="for-contaiment left">
											<div class="receive-imgbox">
												<div class="receive-profileimg">
													<img class="profile-image" src="_blank"
														style="width: 38px; height: 38px; border-radius: 100%; border: 1px solid black;">
													<!-- 프로필 이미지-->
												</div>
												<div class="message-wrapper">
													<div>
														<p class="message-box">부자되게 해주세용
													</div>
												</div>
												<div class="receive-date">
													<div class="message-date">오후 4:24분</div>
												</div>
											</div>
										</div>

									</div>
								</div>
								<form class="chat-textarea">
									<textarea placeholder="메세지를 입력하세요" class="message-area-send"></textarea>
									<div class="chatform-option-area">
										<div class="chatform-submenu"></div>
										<button class="disable send-submit">전송</button>
									</div>
									<span class="text-length">0 / 1000</span>
								</form>
							</div>
						</div>
			</div>
			</section>
			</main>
		</div>
	</div>
	</div>
</body>
</html>