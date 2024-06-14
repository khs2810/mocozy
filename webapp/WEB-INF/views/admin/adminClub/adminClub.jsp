<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<title>관리자 페이지</title>
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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/modal.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub_css/adminClub.css">
<script
	src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminClub_js/adminClub.js"></script>
</head>

<%@ include file="../sideBar.jsp"%>
<body>
	<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
		<div id="base">
		<input type="hidden" value="${status}" id="status">
			<div id="basecontent">
				<header class="top-header" id="header">
					<div class="headerbar">
						<div class="headerbar-left">
							<ul class="header-nav header-nav-options">
								<li class="header-nav-brand">
									<div class="brand-holder">
										<span class="location-text"> <a href="javascript:void(0);">클럽</a>
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
					<section class="no-padding-bottom section">
						<div class="section-body">
							<div class="row">
								<div>
									<ul class="nav nav-tabs tw-flex nav nav-tabs tw-mb24"
										id="prod-status-tab">
										<li
											class="owl-dashboard -owl-dashboard owl-carousel owl-theme owl-loaded">
											<div class="owl-stage-outer">
												<div class="owl-stage">
													<div class="owl-item owl-itemitem active">
														<ul class="owl-nav-tabs">
															<li class="active -all" id="club-All"><a
																href="adminClub.ad">전체 <span
																	class="_count text-primary">${clubAllCount}</span>
															</a></li>
														</ul>
													</div>

													<div class="owl-item owl-itemitem active">
														<ul class="owl-nav-tabs">
															<li class="soldout" id="club-process"><a
																href="adminProcess.ad">노출 <span
																	class="_count text-primary">${clubProcessCount}</span>
															</a></li>
														</ul>
													</div>

													<div class="owl-item owl-itemitem active">
														<ul class="owl-nav-tabs">
															<li class="soldout" id="club-process"><a
																href="adminHidden.ad">숨김 <span
																	class="_count text-primary">${clubHiddenCount}</span>
															</a></li>
														</ul>
													</div>

													<div class="owl-item owl-itemitem active">
														<ul class="owl-nav-tabs">
															<li class="soldout" id="club-end"><a
																href="adminEnd.ad">종료 <span
																	class="_count text-primary">${clubEndCount}</span>
															</a></li>
														</ul>
													</div>
												</div>
											</div>
										</li>

										<li class="hidden-xs hidden-sm">
										<select class="tw-relative tw-bg-transparent tw-appearance-none tw-pr13 tw-text-right" id="sortBtn" onchange="orderSelect()">
												<option value="DESC">내림차순</option>
												<option value="ASC">오름차순</option>
										</select></li>
									</ul>

									<div class="row">
										<div>
											<div class="clearfix search-form">
												<div class="card">
													<div class="card-body no-padding">
														<div class="prod-search" id="prod-search-form">
															<div class="twitter-wrap no-margin-left">
																<span class="twitter-typeahead twitter-relative">
																	<div class="on-click">
																		<a class="on-click-ahref"> <span
																			id="search-keyword-type-text">검색어 입력</span>
																		</a>
																		</div>
																	<input type="hidden" name="cpage" value="1"> 
																	 <input type="text" id="keyword-search-input" name="keyword" value="${keyword}"
																	class="keyword-search keysearch-input form-control typeahead tt-input"
																	placeholder="모임명, 모임 카테고리 검색">
																</span>
															</div>

															<div class="serach-wrap big-search">
																<div class="dd-filter-serach">
																	<label class="icon-set"> <svg
																			xmlns="http://www.w3.org/2000/svg" class="svgicon"
																			fill="currentColor" class="bi bi-search"
																			viewBox="0 0 16 16">
																			<path
																				d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
																		  </svg>
																	</label>
																</div>
															</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div>
										<div class="card">
											<div class="table-responsive shop-table check" id="prod-list">
												<table class="table no-margin">
													<thead class="subject -prodListHeaderDeselected"
														id="prod-list-header-deselected">
														<tr>
															<th class="check checkhead"></th>
															<th class="no" style="margin-left: 5px">No</th>
															<th class="image" style="width: 250px">클럽명</th>
															<th class="group" style="margin-left: 5px">카테고리</th>
															<th class="state">상태</th>
															<th class="r-date" style="margin-left: 20px">등록일</th>
															<th class="more"></th>
														</tr>
													</thead>

													<tbody id="prod-list-body"
														class="-prod-list-body ui-sortable">
														<%-- <c:forEach var="club" items="${clist}">
															<tr class="content -prodListItem">
																<td class="checkhead">
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

																<td class="group">${club.categoryName2}</td>

																<td class="state on-click"><a
																	data-toggle="dropdown" style="margin-right: -1px;">
																		<span>${club.status}</span>
																</a></td>

																<td class="r-date text-12">${club.modifyDate}</td>
																<td class="more">
																	<div class="dropdown">
																		<button class="btn btn-danger-button" id="deleteBtn">종료</button>
																		<button class="btn btn-flat" id="startBtn">시작</button>
																	</div>
																</td>
															</tr>
														</c:forEach> --%>
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
				</section>
				<!--섹션 끝 -->
			</div>
		</div>
	</div>

	<!-- 모달창 -->
	<div id="cocoaModal" class="modal in modal-admin deleteModal"
		data-backdrop="true" data-keyboard="true" style="display: none;">
		<input type="hidden" value="${loginUser.userNo}" id="clubStatus" name="adminNo">
		<div class="modal-dialog ui-draggable">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36"
							fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
								<path
								d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
							</svg>
					</button>
					<h3 class="modal-title">종료</h3>
				</div>
				<div class="modal-body">선택한 모임을 종료하시겠습니까?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-flat"
						data-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-primary btn-flat"
						id="board-save">종료</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 모달창 -->
	<div id="cocoaModal" class="modal in modal-admin startModal"
		data-backdrop="true" data-keyboard="true" style="display: none;">
		<input type="hidden" value="${loginUser.userNo}" id="clubStatus" name="adminNo">
		<div class="modal-dialog ui-draggable">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36"
							fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
								<path
								d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
							</svg>
					</button>
					<h3 class="modal-title">진행</h3>
				</div>
				<div class="modal-body">선택한 모임을 진행하시겠습니까?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-flat"
						data-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-primary btn-flat"
						id="board-save">진행</button>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="../../common/topButton.jsp"%>
</html>