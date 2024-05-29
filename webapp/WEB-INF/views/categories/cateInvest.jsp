<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
				href="${pageContext.request.contextPath}/resources/jo/css/categories_css/cate.css">
		</head>

		<%@ include file="../common/header.jsp" %>

			<body>
				<div class="catePage">
					<%@ include file="../mainPage/banner.jsp" %>
						<%@ include file="../mainPage/cateButton.jsp" %>

							<div class="screen">
								<div class="box" style="background-color: #F5F6F9 !important;">
									<!-- 카테고리 -->

									<div class="catelistTitle">
										<div class="leftlistTitle">
											<p> 미래발전 </p>
											<svg class="cateRanklisticon" xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-chevron-compact-right"
												viewBox="0 0 16 16">
												<path fill-rule="evenodd"
													d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671" />
											</svg>
											<span> 재테크 </p>
										</div>

										<div class="rightlistTitle">
											<div class="rightlistContent">
												<span id="cateRecent"> 최근순 </span>
												<p id="cateDibs"> 추천순 </p>
												<p id="cateViews"> 인기순 </p>
											</div>
										</div>
									</div>

									<div class="display">
										<!--  1번  -->
										<c:forEach var="club" items="${catelist}">
											<div class="contentcard">
												<div class="socialing">
													<a class="cardlink" href="detail.cl?cno=1">
														<img class="img" src="${club.thumbnailImg}" />

														<div class="info">
															<div class="subject">
																<div class="tag">${club.clubType}</div>
															</div>

															<div class="infotitle">${club.clubTitle}</div>

															<div class="describe">
																<svg class="image" xmlns="http://www.w3.org/2000/svg"
																	width="10" height="10" fill="currentColor"
																	class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
																	<path
																		d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
																</svg> ${club.address} · ${club.eventDate}
															</div>

															<div class="participant">
																<img alt="participant" class="img" />
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<span class="span">
																	<img class="cardImg" src="_blank" />
																</span>
																<div class="socialmember">
																	<svg class="people"
																		xmlns="http://www.w3.org/2000/svg" width="10"
																		height="10" fill="currentColor"
																		class="bi bi-people-fill" viewBox="0 0 16 16">
																		<path
																			d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5" />
																	</svg>
																	<div class="count">${club.count}/5</div>
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

							<%@ include file="../common/footer.jsp" %>
			</body>
			<%@ include file="../common/topButton.jsp" %>

		</html>