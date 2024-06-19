<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mo-cozy</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/mainPage.css">
</head>

<%@ include file="../common/header.jsp"%>
<%@ include file="../mainPage/banner.jsp"%>
<body>
	<div class="main">
		<%@ include file="../mainPage/cateButton.jsp"%>

		<!--  1번 -->
		<div class="screen">
			<div class="box">
				<div class="screenheader">
					<h1 class="title">주간 베스트 TOP20👑</h1>
					<div class="selectBox">
						<a href="cateRecent.ct?key=${'챌린지'}">모두보기</a>
					</div>
				</div>
				<div class="display">

					<c:forEach var="club" items="${clist}">
						<div class="contentcard">
							<div class="socialing">
								<a class="cardlink" href="detail.cl?cno=${club.clubNo}"> <img
									class="img" src="${club.thumbnailImg}" />

									<div class="info">
										<div class="subject">
											<div class="tag tagChallenge">${club.clubType}</div>
											<div class="tagone">${club.categoryName1}</div>
											<div class="tagtwo">${club.categoryName2}</div>
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
												<img class="people" src="${club.profileImg[0]}" />
											</c:if>
										
											<div class="profileimglist">
												<c:if test="${club.profileImg.size() >= 2}">
													<c:forEach var="clubMember" items="${club.profileImg}" begin="1" end="${club.profileImg.size() - 1}">
														<img class="cardImg" src="${clubMember}" />
													</c:forEach>
												</c:if>
											</div>

											<div class="socialmember">
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
													  <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
													  <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
													</svg>
												<div class="count">${club.createDateStr}</div>
											</div>
										</div>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>


				</div>
			</div>


			<%@ include file="../mainPage/rank.jsp"%>
			<%@ include file="../mainPage/subBanner.jsp"%>

			<div class="box">
				<div class="screenheader">
					<h1 class="title">다수가 본 최다 조회수 HOT 클래스 🔥</h1>
					<div class="selectBox">
						<a href="cateView.ct?key=챌린지&order=club_no">모두보기</a>
					</div>
				</div>

				<div class="display">
					<c:forEach var="club" items="${flist}">
						<div class="contentcard">
							<div class="socialing">
								<a class="cardlink" href="detail.cl?cno=${club.clubNo}"> <img
									class="img" src="${club.thumbnailImg}" />

									<div class="info">
										<div class="subject">
											<div class="tag tagChallenge">${club.clubType}</div>
											<div class="tagone">${club.categoryName1}</div>
											<div class="tagtwo">${club.categoryName2}</div>
										</div>

										<div class="infotitle">${club.clubTitle}</div>

										<div class="describe">
											<svg class="image" xmlns="http://www.w3.org/2000/svg"
												width="10" height="10" fill="currentColor"
												class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
											 <path
													d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
										</svg>
											${club.address} · ${club.eventDateStr}
										</div>

										<div class="participant">
											<c:if test="${not empty club.profileImg}">
												<img class="people" src="${club.profileImg[0]}" />
											</c:if>
										
											<div class="profileimglist">
												<c:if test="${club.profileImg.size() >= 2}">
													<c:forEach var="clubMember" items="${club.profileImg}" begin="1" end="${club.profileImg.size() - 1}">
														<img class="cardImg" src="${clubMember}" />
													</c:forEach>
												</c:if>
											</div>

											<div class="socialmember">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-eye-fill"
													viewBox="0 0 16 16" style="color: gray">
											  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
											  <path
														d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7" />
											</svg>
												<div class="count">${club.count}</div>
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