<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="ko">
	
	<head>
		<!-- 공용 -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<!-- include libraries(jQuery, bootstrap) -->
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	
		<!-- include summernote css/js -->
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/common_css/adminstyle.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminManager.css">
	</head>

<%@ include file="../../common/sideBar.jsp"%>
	<body>
	<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
	<div id="base">
		<header class="top-header" id="default-header">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand">
							<div class="brand-holder">
								<span class="location-text">
									<a href="_blank">관리자</a> </span>
							</div>
						</li>
					</ul>
				</div>

				<div class="headerbar-right">
					<ul class="header-nav header-nav-options">
						<li class="hidden-md hidden-lg hidden-sm">
							<button class="btn btn-flat" type="button" id="dLabel" style="padding: 4px 8px;">
								<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
							</button>
							<ul class="dropdown-menu animation-dock">
								<li>
									<a href="_blank">관리자 추가</a>
								</li>
							</ul>
						</li>
						<li class="hidden-xs">
							<a class="btn btn-primary">관리자 추가</a>
						</li>
					</ul><!--end .header-nav-options -->
				</div><!--끝 #header-navbar-collapse -->
				<!--끝 #header-navbar-collapse -->
			</div>
		</header>

		<header class="top-header control-fixed" id="select-header" style="display: none;">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav">
						<li class="header-nav-brand">
							<div class="brand-holder ">
								<a class="btn btn-flat btn-default-white no-padding-x margin-right-xl" href="_blank">
									<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
								</a>
							</div>

							<div class="brand-holder">
								<div class="dropdown">
									<button class="btn btn-flat btn-default-white no-padding-x margin-right-xl text-lg tw-whitespace-nowrap" type="button" id="dLabel">
										<span id="select-cnt"></span>명 선택됨 
										<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
									</button>

									<ul class="dropdown-menu animation-dock">
										<li>
											<a href="_blank">모두 선택</a>
										</li>
										<li>
											<a href="_blank">선택 안함</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>

				<div class="headerbar-right">
					<ul class="header-nav header-nav-options">
						<li>
							<div class="btn-group">
								<div class="btn-group">
									<a class="btn btn-default-bright">그룹
										<span class="hidden-xs">지정</span> 
										<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
									</a>

									<ul class="dropdown-menu animation-dock check">
										<div class="select-group -check-drop-group-list"></div>
										<div class="footer">
											<li class="divider"></li>
											<li><a href="_blank">새 그룹</a></li>
										</div>
									</ul>
								</div>

								<a class="btn btn-default-bright">
									<span class="hidden-xs">가입</span> 승인 
								</a>

								<div class="btn-group">
									<a class="btn btn-default-bright">메시지 
										<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
									</a>

									<ul class="dropdown-menu animation-dock check">
										<li>
											<a href="_blank">SMS</a>
										</li>

										<li>
											<a href="_blank">알림</a>
										</li>
									</ul>
								</div>
								<div class="btn-group">
									<a class="btn btn-default-bright border-radius-right">기타 
										<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
									</a>

									<ul class="dropdown-menu animation-dock check">
										<li>
											<a href="_blank">적립금 지급/차감</a>
										</li>
										<li>
											<a href="_blank">사용자 삭제</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</header>

		<!-- BEGIN CONTENT-->
		<div id="content">
			<section class="section">
				<div class="section-body">
					<div class="tab-pane" id="daily">
						<div class="row">
							<div class="col-md-3 col-xl-2 hidden-xs hidden-sm">
								<div class="card">
									<div class="card-body no-padding">
										<ul class="nav nav-pills nav-stacked" id="group-list">
											<li class="active" id="group-item-total" style="border-bottom: 1px solid #e5e5e5;">
												<a href="_blank">전체 사용자 
													<small class="margin-left-lg text-bold opacity-75" id="total-left-member-count">1</small>
												</a>
											</li>

											<li id="group-item-nogroup">
												<a href="_blank">그룹 없음 
													<small class="margin-left-lg text-bold opacity-75 -no-group-cnt" id="total-no-group-count">1</small>
												</a>
											</li>
										</ul>

										<ul class="nav nav-pills nav-stacked">
											<li class="no-hover" id="new-group-btn">
												<a href="_blank" class="text-primary">새 그룹 만들기</a>
											</li>
										</ul>
									</div><!--end.card-body-->
								</div><!--end.card-->
							</div><!--end.col-->

							<div class="col-md-9 col-xl-10">
								<div class="row">
									<div class="col-md-10">
										<div class="card">
											<div class="card-body no-padding">
												<div class="user-search" id="userSearch">
													<div class="form-group">
														<label class="icon-set left">
															<i class="btl bt-search"></i>
														</label>
														<div id="prefetch">
															<span class="twitter-typeahead" style="position: relative; display: inline-block;">
																<input type="hidden" name="q" class="form-control typeahead">
																<input type="text" class="form-control typeahead tt-input" id="keyword-search1" name="keyword" placeholder="검색"
																	style="position: relative; vertical-align: top; background-color: transparent;">
																<pre style="position: absolute; visibility: hidden; white-space: pre; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; word-spacing: 0px; letter-spacing: 0px; text-indent: 0px; text-rendering: optimizelegibility; text-transform: none;"></pre>
																<div class="tt-menu" style="position: absolute; top: 100%; left: 0px; z-index: 100; display: none;">
																	<div class="tt-dataset tt-dataset-users"></div>
																</div>
															</span>
														</div>
													</div>
												</div>
											</div>
										</div><!--end.card-->
									</div><!--end.col-->

									<div class="col-md-12">
										<div class="card">
											<div id="order-list-loader-sub" class="se-pre-con" style="background: none; position: relative; height: 100px; display: none;">
												<div class="page-loader-spinner">
													<div class="double-bounce1"></div>
													<div class="double-bounce2"></div>
												</div>
											</div>
											<div class="card-head" id="card-head">
												<header class="small">전체 사용자 <span class="text-primary"
														id="total-member-count">1</span>명 </header>

											</div>

											<div class="card-body no-padding">
												<div class="li-table" id="UI-TABLE">
													<ul class="subject -thead" id="table-header">
														<li class="check">
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="-all-check">
																	<span></span>
																</label>
															</div>
														</li>
														<li class="nick"><a href="_blank">닉네임</a></li>
														<li class="account">계정</li>
														<li class="account">회원 유형</li>
														<li class="group">그룹</li>
														<li class="date-join">
															<a href="_blank">가입일
																<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
															</a>
														</li>
														<li class="count-post">글/댓글/리뷰/문의</li>
														<li class="purchase text-right hidden-xs hidden-sm">누적 포인트</li>
														<li class="memo text-center">메모</li>
														<li class="action"></li>
													</ul>

													<ul class="content -tbody" id="member-item-m2024051656220aef480fa">
														<li class="check">
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox"><span></span></label>
															</div>
														</li>

														<li class="nick">
															<a href="_blank">관리자
																<span class="badge">소유자</span>
															</a>
														</li>

														<li class="account">
															<a href="_blank">qjfhdnaos@gmail.com</a>
														</li>

														<li class="account">관리자</li>

														<li class="group">
															<div class="dropdown">
																<button id="dLabel" type="button" class="btn-flat no-padding -drop-group-btn-39549572">그룹없음</button>
																<ul class="dropdown-menu animation-dock check">
																	<div class="select-group -drop-group-list -drop-group-list-39549572"></div>
																	<div class="footer">
																		<li class="divider"></li>
																		<li>
																			<a href="_blank">새 그룹</a></li>
																	</div>
																</ul>
															</div>
														</li>

														<li class="date-join">2024-05-16</li>
														<li class="date-mileage text-right"></li>
														<li class="count-post hidden-xs hidden-sm">1/ 0/ 0/ 0</li>
														<li class="purchase text-right hidden-xs hidden-sm"></li>
														<li class="memo">
															<a href="_blank" class="btn btn-flat text-gray-bright">
																<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
															</a>
														</li>
														<li class="action">
															<div class="dropdown">
																<button id="dLabel" type="button" class="btn btn-flat">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>
																<ul class="dropdown-menu animation-dock right">
																	<li><a href="_blank">삭제</a></li>
																	<li><a href="_blank">알림</a></li>
																	<li><a href="_blank">채팅</a></li>
																	<li><a href="_blank">포인트 지급/차감</a></li>
																</ul>
															</div>
														</li>
													</ul>
												</div><!--end.li-table-->

												<nav class="text-center" id="paginate"></nav>

											</div><!--end.card-body-->
										</div><!--end.card-->
									</div><!--end.col-->
								</div><!--end.row-->
							</div><!--end.col-->
						</div><!--end.row-->
					</div><!--end.tab-pane-->
				</div> <!--end.section-body.tab-content-->
			</section>
		</div>
	</div>
</body>
</html>