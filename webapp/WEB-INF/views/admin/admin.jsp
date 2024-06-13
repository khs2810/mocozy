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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub_css/adminClub.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/admin.css">
</head>

<%@ include file="./sideBar.jsp"%>

<body>
	<div class="menubar-hoverable header-fixed menubar-pin">
		<div id="base">
			<div id="basecontent">
				<header class="top-header">
					<div class="headerbar">
						<div class="headerbar-left">
							<div>
								<a href="_blank" class="site-name">mo-cozy</a>
							</div>
						</div>
						<div class="headerbar-right">
							<ul class="header-nav header-nav-options">
								<li><a class="clay-button black exit-btn"
									href="${pageContext.request.contextPath}">나가기</a></li>
							</ul>
						</div>
					</div>
				</header>

				<div id="content" class="dashboard-main">

					<section class="section">
						<div class="clearfix area-wrap">
							<div class="section-body float-l">
								<div class="dashboard-section-header dashboard-stats-header">
									<div>
										<svg xmlns="http://www.w3.org/2000/svg" class="svgicon"
											fill="currentColor" class="bi bi-bar-chart-line"
											viewBox="0 0 16 16">
                                                        <path
												d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1zm1 12h2V2h-2zm-3 0V7H7v7zm-5 0v-3H2v3z" />
                                                    </svg>
										<span>신규 모임</span>
									</div>
									<div>
										<p style="margin: 0px;">
											<a href="adminClub.ad">더보기</a>
										</p>
									</div>
								</div>

								<!-- 신규 모임-->
								<section class="no-padding-bottom section">
									<div style="margin-bottom: 30px;">
										<div class="row">
											<div>
												<div class="row">
													<div>
														<div class="card" style="border-radius: 10px;">
															<div class="table-responsive shop-table check"
																id="prod-list">
																<table class="table no-margin">
																	<thead class="subject -prodListHeaderDeselected"
																		id="prod-list-header-deselected">
																		<tr style="justify-content: left;">
																			<th class="check checkhead"></th>
																			<th class="no" style="margin-left: 5px;">No</th>
																			<th class="image" style="width: 260px;">클럽명</th>
																			<th class="group" style="width: 80px;">카테고리</th>
																			<th class="state">상태</th>
																			<th class="r-date" style="margin-left: 15px;">등록일</th>
																		</tr>
																	</thead>

																	<tbody id="prod-list-body"
																		class="-prod-list-body ui-sortable">
																		<c:forEach var="club" items="${clist}">
																			<tr class="content -prodListItem">
																				<td class="checkhead">
																					<div
																						class="drag -showcase-handle ui-sortable-handle"></div>
																					<div class="checkbox checkbox-styled no-margin">
																						<label> <input type="checkbox"
																							class="-prodListCheck"> <span></span>
																						</label>
																					</div>
																				</td>

																				<td class="no text-12">${club.clubNo}</td>

																				<td class="image"><a href="_blank"> <img
																						src="${club.thumbnailImg}" width="49" height="49"
																						class="item-thumb">
																				</a></td>

																				<td class="title">
																					<div>
																						<div class="item-tit inline-blocked">
																							<a href="_blank">${club.clubTitle}</a> <a
																								href="_blank"
																								class="im-icon im-ico-new-tab vertical-middle tab-icon"
																								style="margin-left: 4px;"></a>
																						</div>
																						<span class="btn-sm text-gray-bright"></span>
																					</div>
																				</td>

																				<td class="group" style="width: 90px;">${club.categoryName2}</td>

																				<td class="state on-click"><a
																					data-toggle="dropdown" style="margin-right: -1px;">
																						<span>${club.status}</span>
																				</a>
																					<ul class="dropdown-menu" style="top: 50px;">
																						<li
																							id="mixpanel-bo-shopping-item-list-status-sale">
																							<a href="_blank">진행중</a>
																						</li>
																						<li
																							id="mixpanel-bo-shopping-item-list-status-soldout">
																							<a href="_blank">종료</a>
																						</li>
																					</ul></td>

																				<td class="r-date text-12">${club.modifyDate}</td>
																				<td class="more"></td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>

													<div class="col-md-12">
														<nav class="text-center order-paging"
															id="prod-list-paging"></nav>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
								<!--섹션 끝 -->

								<div class="dashboard-section-header dashboard-stats-header">
									<div>
										<svg xmlns="http://www.w3.org/2000/svg" class="svgicon" fill="currentColor" class="bi bi-person-add" viewBox="0 0 16 16">
										  <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4"/>
										  <path d="M8.256 14a4.5 4.5 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10q.39 0 .74.025c.226-.341.496-.65.804-.918Q8.844 9.002 8 9c-5 0-6 3-6 4s1 1 1 1z"/>
										</svg>
										<span>신규 유저</span>
									</div>
									<div>
										<p style="margin: 0px;">
											<a href="adminUserlist.ad">더보기</a>
										</p>
									</div>
								</div>

								<!-- 신규 유저-->
								<section class="no-padding-bottom section">
									<div style="margin-bottom: 30px;">
										<div class="row">
											<div>
												<div class="row">
													<div>
														<div class="card" style="border-radius: 10px;">
															<div class="table-responsive shop-table check"
																id="prod-list">
																<table class="table no-margin">
																	<thead class="subject -prodListHeaderDeselected"
																		id="prod-list-header-deselected">
																		<tr>
																			<th class="check checkhead"></th>
																			<th class="no" style="margin-left: 5px;">No</th>
																			<th class="image" style="width: 165px;">유저명</th>
																			<th class="state">상태</th>
																			<th class="r-date" Style="margin-left: 10px;">가입일</th>
																			<th class="group">누적 포인트</th>
																			<th class="more"></th>
																		</tr>
																	</thead>

																	<tbody id="prod-list-body"
																		class="-prod-list-body ui-sortable">
																		<c:forEach var="user" items="${mlist}">
																			<tr class="content -prodListItem">
																				<td class="checkhead">
																					<div
																						class="drag -showcase-handle ui-sortable-handle"></div>
																					<div class="checkbox checkbox-styled no-margin">
																						<label> <input type="checkbox"
																							class="-prodListCheck"> <span></span>
																						</label>
																					</div>
																				</td>

																				<td class="no text-12">${user.userNo}</td>

																				<td class="image"><a href="_blank"> <img
																						src="${user.profileImg}"
																						width="49" height="49" class="item-thumb">
																				</a></td>

																				<td class="title" style="width: 100px;">
																					<div>
																						<div class="item-tit inline-blocked">
																							<a href="_blank">${user.nickname}</a> <a
																								href="_blank"
																								class="im-icon im-ico-new-tab vertical-middle tab-icon"
																								style="margin-left: 4px;"></a>
																						</div>
																						<span class="btn-sm text-gray-bright"></span>
																					</div>
																				</td>

																				<td class="state on-click"><a
																					data-toggle="dropdown" style="margin-right: -1px;">
																						<span>${user.status}</span>
																				</a></td>

																				<td class="r-date text-12">${user.enrollDate}</td>
																				<td class="purchase text-center hidden-xs hidden-sm"
																					style="width: 100px;"><a href="adminPoint.ad"
																					style="text-decoration: underline;">${user.point}</a></td>
																				<td class="more">
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>

													<div class="col-md-12">
														<nav class="text-center order-paging"
															id="prod-list-paging"></nav>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
								<!--섹션 끝 -->


								<!-- 컨텐츠 -->
								<div class="dashboard-section-header">
									<div>
										<svg xmlns="http://www.w3.org/2000/svg" class="svgicon"
											fill="currentColor" class="bi bi-paragraph"
											viewBox="0 0 16 16">
                                                        <path
												d="M10.5 15a.5.5 0 0 1-.5-.5V2H9v12.5a.5.5 0 0 1-1 0V9H7a4 4 0 1 1 0-8h5.5a.5.5 0 0 1 0 1H11v12.5a.5.5 0 0 1-.5.5" />
                                                    </svg>
										<span>컨텐츠</span>
									</div>
								</div>

								<div
									class="flex-box dashboard-section-row dashboard-contents-row">
									<div
										class="ma-item col-md-6 col-sm-6 col-xs-12 answers-list shopping-qna no-padding-left">
										<div class="card flex-card">
											<div class="card-head">
												<header> 신규 문의</header>
												<a href="_blank" class="dashboard-card-anchor">더보기</a>
											</div>
											<div class="card-body border-top no-data-card-body">
												<ul class=" list list-preview">
													<li class="tile">
														<div class="no-data-container">
															<img src="_blank">
															<!-- 프로필 이미지-->
															<p>1:1 채팅 문의가 없어요</p>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</div>

									<div
										class="ma-item col-md-6 col-sm-6 col-xs-12 contents-list !tw-mb-0 no-padding">
										<div class="card flex-card">
											<!-- // 예약 또는 쇼핑 사용 -->
											<div class="card-head">
												<header>신규 공지사항</header>
												<a href="adminNotice.ad" class="dashboard-card-anchor">더보기</a>
											</div>
											<div class="card-body border-top">
												<ul class="list list-preview">
													<c:if test="${not empty nlist}">
														<li class="tile"><a
															class="tile-content contents-item" href="_blank">
																<div class="tile-text">
																	<div>
																		<strong>${nlist[0].noticeTitle}</strong> <span
																			class="tile-content">${nlist[0].noticeContent}</span>
																	</div>
																	<small class="text-12"> <span>${nlist[0].noticeNo}</span>
																		<span class="opacity-50 text-gray-bright margin-x-8">|</span>
																		<span>${nlist[0].modifyDate}</span>
																	</small>
																</div>
														</a></li>
													</c:if>
												</ul>
											</div>
										</div>
									</div>
								</div>
					</section>
				</div>

			</div>
		</div>
	</div>
</body>

</html>