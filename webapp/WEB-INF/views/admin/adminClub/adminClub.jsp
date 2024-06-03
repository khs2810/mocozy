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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub.css">
	</head>

<%@ include file="../../common/sideBar.jsp"%>
	<body>
		<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
		<div id="base">
		<header class="top-header" id="header">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand">
							<div class="brand-holder">
								<span class="location-text">
									<a href="_blank">클럽</a>
								</span>
							</div>
						</li>
					</ul>
				</div>

				<div class="headerbar-right">
					<ul class="header-nav header-nav-options -option-list">
						<li class="hidden-xs">
							<a class="btn btn-primary" href="_blank">클럽 추가</a>
						</li>

						<li class="hidden-md hidden-lg hidden-sm">
							<button class="btn btn-flat" id="dLabel" style="padding: 4px 8px;">
								<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
							</button>

							<ul class="dropdown-menu animation-dock">
								<li>
									<a href="_blank">상품 추가</a>
								</li>
								<li>
									<a href="_blank">상품 일괄 추가</a>
								</li>
							</ul>
						</li>
					</ul><!--end .header-nav-options -->
				</div><!--끝 #header-navbar-collapse -->
				<!--끝 #header-navbar-collapse -->
			</div>
		</header>

		<!-- BEGIN CONTENT-->
		<div id="content">
			<section class="no-padding-bottom section">
				<div class="section-body">
					<div class="row">
						<div class="col-md-3 col-lg-2 col-xl-2 hidden-xs hidden-sm">
							<div class="card">
								<div class="card-body no-padding">
									<ul class="nav nav-pills nav-stacked">
										<li class="no-hover" id="new-group-btn">
											<a href="_blank" class="text-primary">
												카테고리 추가 
												<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
											</a>
										</li>
									</ul>

									<div class="nav nav-pills nav-stacked nav-category">
										<div id="prod-list-category-" class="dropdown-handle dd-handle  active">
											<a href="_blank">전체 카테고리</a>
										</div>

										<div id="prod-category-list" class="prod-category-list">
											<div class="holder">
												<div class="dropdown-handle dd-handle -menu-item">
													<span class="_name">소셜링</span>
												</div>
											</div>

											<div class="holder">
												<div class="dropdown-handle dd-handle -menu-item" id="prod-list-category-s20240401723e96dccd326">
													<span class="_name">챌린지</span>
												</div>
											</div>

											<div class="holder">
												<div class="dropdown-handle dd-handle -menu-item" id="prod-list-category-s20240401ae119f81cc87a">
													<span class="_name">미래발전</span>
												</div>
											</div>

											<div class="holder">
												<div class="dropdown-handle dd-handle -menu-item" id="prod-list-category-s202404017c0c84752e9c2">
													<span class="_name">외국어</span>
												</div>
											</div>
										</div>
									</div>
								</div><!--end.card-body-->
							</div><!--end.card-->
						</div><!--end.col-->

						<div class="col-md-9 col-lg-10 col-xl-10">
							<ul class="nav nav-tabs tw-flex nav nav-tabs tw-mb24" id="prod-status-tab">
								<li class="owl-dashboard -owl-dashboard owl-carousel owl-theme owl-loaded">
									<div class="owl-stage-outer">
										<div class="owl-stage">
											<div class="owl-item owl-itemitem active">
												<ul class="owl-nav-tabs">
													<li class="active -all">
														<a href="_blank">전체
															<span class="_count text-primary">4</span>
														</a>
													</li>
												</ul>
											</div>

											<div class="owl-item owl-itemitem active">
												<ul class="owl-nav-tabs">
													<li class="sale">
														<a href="_blank">진행중
															<span class="_count text-primary">4</span>
														</a>
													</li>
												</ul>
											</div>

											<div class="owl-item owl-itemitem active">
												<ul class="owl-nav-tabs">
													<li class="soldout">
														<a href="_blank">종료
															<span class="_count text-primary">0</span>
														</a>
													</li>
												</ul>
											</div>

											<div class="owl-item owl-itemitem active">
												<ul class="owl-nav-tabs">
													<li class="nosale">
														<a href="_blank">숨김
															<span class="_count text-primary">0</span>
														</a>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</li>

								<li class="hidden-xs hidden-sm">
									<select class="tw-relative tw-bg-transparent tw-appearance-none tw-pr13 tw-text-right">
										<option value="10">10개씩 보기</option>
										<option value="20">20개씩 보기</option>
										<option value="50">50개씩 보기</option>
										<option value="100">100개씩 보기</option>
									</select>
								</li>
							</ul>

							<div class="row">
								<div class="col-md-12">
									<div class="clearfix search-form">
										<div class="card">
											<div class="card-body no-padding">
												<form class="prod-search" id="prod-search-form">
													<div class="twitter-wrap no-margin-left">
														<span class="twitter-typeahead twitter-relative">
															<div class="on-click">
																<a class="on-click-ahref">
																	<span id="search-keyword-type-text">기본</span>
																</a>
																<ul class="dropdown-menu top36">
																	<li><a href="_blank">기본</a></li>
																	<li><a href="_blank">옵션 클럽번호</a></li>
																</ul>
																<input type="hidden" name="search-keyword-type" class="search-keyword-type" id="search-keyword-type">
															</div>

															<input type="text" id="keyword-search-input" class="keyword-search keysearch-input form-control typeahead tt-input"
																placeholder="모임명, 모임 카테고리 검색">
														</span>
													</div>

													<div class="serach-wrap big-search">
														<div class="dd-filter-serach">
															<label class="icon-set">
																<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
															</label>
													</div>
												</form>
											</div>
										</div>
										</div>
									</div>
								</div>

								<div class="col-md-12">
									<div class="card">
										<div class="table-responsive shop-table check" id="prod-list">
											<table class="table no-margin">
												<thead class="subject -prodListHeaderDeselected" id="prod-list-header-deselected">
													<tr>
														<th class="check checkhead">
															<div class="checkbox checkbox-styled no-margin" style="border: 1px solid black;">
																<label>
																	<input type="checkbox" class="prodListAllCheck">
																	<span></span>
																</label>
															</div>
														</th>
														<th class="no">No</th>
														<th class="image">클럽명</th>
														<th class="title"></th>
														<th class="group">카테고리</th>
														<th class="state">상태</th>
														<th class="r-date">등록일</th>
														<th class="more"></th>
													</tr>
												</thead>

												<tbody id="prod-list-body" class="-prod-list-body ui-sortable">
													<tr class="content -prodListItem" id="prod-list-s20240516ae197a3da7242">
														<td class="checkhead">
															<div class="drag -showcase-handle ui-sortable-handle"></div>
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="-prodListCheck">
																	<span></span>
																</label>
															</div>
														</td>

														<td class="no text-12">4</td>

														<td class="image">
															<a href="_blank">
																<img src="_blank" width="49" height="49" class="item-thumb">
															</a>
														</td>

														<td class="title">
															<div>
																<div class="item-tit inline-blocked">
																	<a href="_blank">봄나들이를 같이 가봐요</a>
																	<a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon" style="margin-left: 4px;"></a>
																</div>
																<span class="btn-sm text-gray-bright"></span>
															</div>
														</td>

														<td class="group">임시</td>
												
														<td class="state on-click">
															<a data-toggle="dropdown" style="margin-right: -1px;">
																<span>진행중</span>
															</a>
															<ul class="dropdown-menu" style="top: 50px;">
																<li id="mixpanel-bo-shopping-item-list-status-sale">
																	<a href="_blank">진행중</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-soldout">
																	<a href="_blank">종료</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-nosale">
																	<a href="_blank">숨김</a>
																</li>
															</ul>
														</td>

														<td class="r-date text-12">2024-04-01</td>
														<td class="more">
															<div class="dropdown">
																<button class="btn btn-flat" type="button" id="dLabel">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>

																<ul class="dropdown-menu animation-dock right">
																	<li>
																		<a href="_blank">맨 위로</a>
																	</li>
																	<li>
																		<a href="_blank">위로</a>
																	</li>
																	<li>
																		<a href="_blank">아래로</a>
																	</li>
																	<li>
																		<a href="_blank">맨 아래로</a>
																	</li>
																</ul>
															</div>
														</td>
													</tr>

													<!--<tr class='content on">-->
													<tr class="content -prodListItem" id="prod-list-s20240516499115c1a7064">
														<td class="checkhead">
															<div class="drag -showcase-handle ui-sortable-handle"></div>
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="-prodListCheck">
																	<span></span>
																</label>
															</div>
														</td>

														<td class="no text-12">3</td>

														<td class="image">
															<a href="_blank">
																<img src="_blank" width="49" height="49" class="item-thumb">
															</a>
														</td>

														<td class="title">
															<div>
																<div class="item-tit inline-blocked">
																	<a href="_blank">임시</a>
																	<a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon" style="margin-left: 4px;"></a>
																</div>
															</div>
														</td>

														<td class="group">임시</td>

														<td class="state on-click">
															<a style="margin-right: -1px;">
																<span>진행중</span>
															</a>
															<ul class="dropdown-menu" style="top: 50px;">
																<li id="mixpanel-bo-shopping-item-list-status-sale">
																	<a href="_blank">진행중</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-soldout">
																	<a href="_blank">품절</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-nosale">
																	<a href="_blank">숨김</a>
																</li>
															</ul>
														</td>

														<td class="r-date text-12">2024-04-01</td>

														<td class="more">
															<div class="dropdown">
																<button class="btn btn-flat" type="button" id="dLabel">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>

																<ul class="dropdown-menu animation-dock right">
																	<li>
																		<a href="_blank">맨 위로</a>
																	</li>
																	<li>
																		<a href="_blank">위로</a>
																	</li>
																	<li>
																		<a href="_blank">아래로</a>
																	</li>
																	<li>
																		<a href="_blank">맨 아래로</a>
																	</li>
																</ul>
															</div>
														</td>
													</tr>
													
													<!--<tr class='content on">-->
													<tr class="content -prodListItem" id="prod-list-s202405169fa45a3e9e184">
														<td class="checkhead">
															<div class="drag -showcase-handle ui-sortable-handle"></div>
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="-prodListCheck">
																	<span></span>
																</label>
															</div>
														</td>

														<td class="no text-12">2</td>

														<td class="image">
															<a href="_blank">
																<img src="_blank" width="49" height="49" class="item-thumb">
															</a>
														</td>

														<td class="title">
															<div>
																<div class="item-tit inline-blocked">
																	<a href="_blank">임시</a>
																	<a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon" style="margin-left: 4px;"></a>
																</div>
																<span class="btn-sm text-gray-bright"></span>
															</div>
														</td>

														<td class="group">임시</td>

														<td class="state on-click">
															<a data-toggle="dropdown" style="margin-right: -1px;">
																<span>진행중</span>
															</a>
															<ul class="dropdown-menu" style="top: 50px;">
																<li id="mixpanel-bo-shopping-item-list-status-sale">
																	<a href="_blank">진행중</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-soldout">
																	<a href="_blank">종료</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-nosale">
																	<a href="_blank">숨김</a>
																</li>
															</ul>
														</td>

														<td class="r-date text-12">2024-04-01</td>

														<td class="more">
															<div class="dropdown">
																<button class="btn btn-flat" type="button" id="dLabel">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>
																<ul class="dropdown-menu animation-dock right">
																	<li>
																		<a href="_blank">맨 위로</a>
																	</li>
																	<li>
																		<a href="_blank">위로</a>
																	</li>
																	<li>
																		<a href="_blank">아래로</a>
																	</li>
																	<li>
																		<a href="_blank">맨 아래로</a>
																	</li>
																</ul>
															</div>
														</td>
													</tr>

													<!--<tr class='content on">-->
													<tr class="content -prodListItem" id="prod-list-s20240516baee51a6519ef">
														<td class="checkhead">
															<div class="drag -showcase-handle ui-sortable-handle"></div>
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="-prodListCheck">
																	<span></span>
																</label>
															</div>
														</td>

														<td class="no text-12">1</td>

														<td class="image">
															<a href="_blank">
																<img src="_blank" width="49" height="49" class="item-thumb">
															</a>
														</td>

														<td class="title">
															<div>
																<div class="item-tit inline-blocked">
																	<a href="_blank">임시</a>
																	<a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon" style="margin-left: 4px;"></a>
																</div>
																<span class="btn-sm text-gray-bright"></span>
															</div>
														</td>

														<td class="group">임시</td>

														<td class="state on-click">
															<a style="margin-right: -1px;">
																<span>진행중</span>
															</a>
															<ul class="dropdown-menu" style="top: 50px;">
																<li id="mixpanel-bo-shopping-item-list-status-sale">
																	<a href="_blank">진행중</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-soldout">
																	<a href="_blank">종료</a>
																</li>
																<li id="mixpanel-bo-shopping-item-list-status-nosale">
																	<a href="_blank">숨김</a>
																</li>
															</ul>
														</td>

														<td class="r-date text-12">2024-04-01</td>

														<td class="more">
															<div class="dropdown">
																<button class="btn btn-flat" id="dLabel">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>

																<ul class="dropdown-menu animation-dock right">
																	<li>
																		<a href="_blank">맨 위로</a>
																	</li>
																	<li>
																		<a href="_blank">위로</a>
																	</li>
																	<li>
																		<a href="_blank">아래로</a>
																	</li>
																	<li>
																		<a href="_blank">맨 아래로</a>
																	</li>
																</ul>
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<nav class="text-center order-paging" id="prod-list-paging"></nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section><!--섹션 끝 -->
		</div>
	</div>
</body>
</html>