<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<!-- 공용 -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>관리자 페이지</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
			<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
				rel="stylesheet">
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

			<!-- include libraries(jQuery, bootstrap) -->
			<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" type="text/css"
				rel="stylesheet">
			<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

			<!-- include summernote css/js -->
			<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" type="text/css"
				rel="stylesheet">
			<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
			<!-- -->

			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/modal.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminNotice_css/adminNotice.css">
			<script
				src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminNotice_js/adminBanner.js"></script>
		</head>

		<%@ include file="../sideBar.jsp" %>

			<body>
				<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
					<div id="base">
						<input type="hidden" value="${noticeType}" id="noticeType">
						<div id="basecontent">
							<header class="top-header" id="header">
								<div class="headerbar">
									<div class="headerbar-left">
										<ul class="header-nav header-nav-options">
											<li class="header-nav-brand">
												<div class="brand-holder">
													<span class="location-text"> <a href="javascript:void(0);">공지사항</a>
													</span>
												</div>
											</li>
										</ul>
									</div>

									<div class="headerbar-right">
										<ul class="header-nav header-nav-options">
											<li class="hidden-xs"><a class="clay-button black exit-btn"
													style="margin-right: 50px;" href="admin.ad">뒤로가기</a></li>
										</ul>
										<!--end .header-nav-options -->
									</div>
									<!--끝 #header-navbar-collapse -->
									<!--끝 #header-navbar-collapse -->
								</div>
							</header>

							<!-- BEGIN CONTENT-->
							<div id="content">
								<section>
									<div class="section-body">
										<div class="row">
											<div class="col-md-9 col-lg-10 col-xl-10">
												<ul class="nav nav-tabs tw-flex nav nav-tabs tw-mb24"
													id="prod-status-tab">
													<li class="owl-dashboard -owl-dashboard owl-carousel owl-theme owl-loaded">
														<div class="owl-stage-outer">
															<div class="owl-stage">
																<div class="owl-item owl-itemitem active">
																	<ul class="owl-nav-tabs">
																		<li class="soldout"><a href="adminNotice.ad">전체
																				<span
																					class="_count text-primary">${noticeCount}</span>
																			</a></li>
																	</ul>
																</div>

																<div class="owl-item owl-itemitem active">
																	<ul class="owl-nav-tabs">
																		<li class="soldout"><a
																				href="adminNoticeEvent.ad">이벤트
																				<span
																					class="_count text-primary">${noticeEventCount}</span>
																			</a></li>
																	</ul>
																</div>


																<div class="owl-item owl-itemitem active">
																	<ul class="owl-nav-tabs">
																		<li class="active -all"><a
																				href="adminNoticeBanner.ad">노출중 <span
																					class="_count text-primary">${noticeBannerCount}</span>
																			</a></li>
																	</ul>
																</div>

																<div class="owl-item owl-itemitem active">
																	<ul class="owl-nav-tabs">
																		<li class="soldout"><a
																				href="adminNoticeBoard.ad">공지사항 <span
																					class="_count text-primary">${noticeBoardCount}</span>
																			</a></li>
																	</ul>
																</div>
															</div>
														</div>
													</li>
												</ul>
											</div>

											<div class="row" id="popup_list">
														<div class="ma-item col-md-3 col-sm-6 col-xs-12" id="noticelist">
														<c:forEach var="notice" items="${nlist}">
															<div class="card" style="width: 290px; float: left;">
																<div class="card-head">
																	<header>
																		<a href="javascript:void(0);">noticeTitle ${noticeTitle}</a>
																		<span class="badge style-gray">이벤트</span>
																	</header>
																	<div class="tools">
																		<div class="btn-group">
																			<div class="btn-group">
																				<button class="btn btn-primary-btn" id="deleteBtn">종료</button>
																			</div>
																		</div>
																	</div>
																</div>
																<a href="_blank">
																	<img src="${bannerpath}" style="width: 100%; height: 200px; background-color: #d4ec67;"></a>
																<div class="card-body">
																	<p> noticeNo${noticeNo} </p>
																	<p> noticeContent ${noticeContent} </p>
																</div>
															</div>
														</div>
														</c:forEach>
													</div>
								</section>
								<!--섹션 끝 -->
							</div>
						</div>
					</div>
			</body>
			<%@ include file="../../common/topButton.jsp" %>

		</html>