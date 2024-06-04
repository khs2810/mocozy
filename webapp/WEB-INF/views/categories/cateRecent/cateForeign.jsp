<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jo/js/categories_js/cateAjax.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/categories_css/cate.css">
</head>

<%@ include file="../../common/header.jsp"%>

<body>
	<div class="catePage">
		<%@ include file="../../mainPage/banner.jsp"%>
		<%@ include file="../../mainPage/cateButton.jsp"%>

		<div class="screen">
			<div class="box">
				<!-- 카테고리 -->

				<div class="catelistTitle">
					<div class="leftlistTitle">
						<p>미래발전</p>
						<svg class="cateRanklisticon" xmlns="http://www.w3.org/2000/svg"
							width="16" height="16" fill="currentColor"
							class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
												<path fill-rule="evenodd"
								d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671" />
											</svg>
						<span> 외국어
							</p>
					</div>

					<div class="rightlistTitle">
						<div class="rightlistContent">
							<span id="cateRecent"><a href="cateForeign.ct">최신순</a></span>
							<p id="cateDibs"><a href="cateForeignPick.ct">인기순</a></p>
							<p id="cateViews"><a href="cateForeignView.ct">조회순</a></p>
						</div>
					</div>
				</div>

				<div class="display">
					<!--  1번  -->
					<c:forEach var="club" items="${catelist}">
						<div class="contentcard">
							<div class="socialing">
								<a class="cardlink" href="detail.cl?cno=${club.clubNo}"> <img
									class="img" src="${club.thumbnailImg}" />

									<div class="info">
										<div class="subject">
											<div class="tag">${club.clubType}</div>
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
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
													  <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
													  <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
													</svg>
												<div class="count">${club.createDate}</div>
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

		<%@ include file="../../common/footer.jsp"%>
</body>
<%@ include file="../../common/topButton.jsp"%>

</html>