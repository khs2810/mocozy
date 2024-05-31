<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/event_css/event.css">
<script type="text/javascript" async=""
	src="${pageContext.request.contextPath}/resources/jo/js/event_js/event.js"></script>
</head>

<%@ include file="../common/header.jsp"%>

<body>
	<div class="bannerbox"></div>
	<!-- 상단배너 -->
	<section class="eventbanner" id="eventsection3">
		<div class="eventbannerdiv">
			<h1>디저트 기획전</h1>
			<h3>
				맛있는 디저트로 <br> 즐거운 시간을 보내 보세요
			</h3>
			<a href="javascript:void(0);" class="scrolldown"> <!-- scroll 애니메이션 -->
				<span></span> <span></span> <span></span> <!-- --> Scroll
			</a>
		</div>
	</section>

	<div class="eventPage">
		<div class="display">
			<!--  1번  -->
			<c:forEach var="club" items="${eventlist}">
				<div class="contentcard">
					<div class="socialing">
						<a class="cardlink" href="detail.cl?cno=${club.clubNo}"> <img
							class="img" src="${club.thumbnailImg}" />

							<div class="info">
								<div class="subject">
									<div class="tag">${club.clubType}</div>
									<div class="tagpick">추천</div>
								</div>

								<div class="infotitle">${club.clubTitle}</div>

								<div class="describe">
									<svg class="image" xmlns="http://www.w3.org/2000/svg"
										width="10" height="10" fill="currentColor"
										class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
																	<path
											d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
																</svg>
									${club.address} · ${club.eventDate}
								</div>

								<div class="participant">
									<c:if test="${not empty club.profileImg}">
										<img class="people"
											src="${pageContext.request.contextPath}${club.profileImg[0]}" />
									</c:if>

									<div class="profileimglist">
										<c:if test="${club.profileImg.size() >= 5}">
											<c:forEach var="clubMember" items="${club.profileImg}"
												begin="2" end="4">
												<img class="cardImg"
													src="${pageContext.request.contextPath}${clubMember}" />
											</c:forEach>
										</c:if>
										<c:choose>
											<c:when test="${club.profileImg.size() eq 1}">
											</c:when>
											<c:when
												test="${1 < club.profileImg.size() && club.profileImg.size() < 5}">
												<c:forEach var="clubMember" items="${club.profileImg}"
													begin="2" end="${club.profileImg.size() - 1}">
													<img class="cardImg"
														src="${pageContext.request.contextPath}${clubMember}" />
												</c:forEach>
											</c:when>
										</c:choose>
									</div>

									<div class="socialmember">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-eye-fill"
											viewBox="0 0 16 16" style="color: gray">
											  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
											  <path
												d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
											</svg>
										<div class="count">${club.count}</div>
									</div>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
</body>
<%@ include file="../common/topButton.jsp"%>

</html>