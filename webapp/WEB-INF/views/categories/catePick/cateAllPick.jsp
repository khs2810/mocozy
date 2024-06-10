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
<script src="${pageContext.request.contextPath}/resources/jo/js/categories_js/catePickAjax.js"></script>
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
						<span> 전체 </span>
					</div>

					<div class="rightlistTitle">
						<div class="rightlistContent">
							<p id="cateRecent"><a href="cateAll.ct">최신순</a></p>
							<span id="cateDibs"><a href="cateAllPick.ct">인기순</a></span>
							<p id="cateViews"><a href="cateAllView.ct">조회순</a></p>
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
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" style="color: gray;" viewBox="0 0 16 16">
													  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
													</svg>
												<div class="count">${club.pickCount}</div>
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