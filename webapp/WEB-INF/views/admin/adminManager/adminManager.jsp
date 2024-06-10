<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="ko">
	
	<head>
		<!-- 공용 -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link
			href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
			rel="stylesheet">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/modal.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminManager_css/adminManager.css">
		<script src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminManager_js/adminManager.js"></script>
	</head>

	<%@ include file="../sideBar.jsp"%>
	<body>
	<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
	<div id="base">
		<div id="basecontent">
			<header class="top-header" id="default-header">
				<div class="headerbar">
					<div class="headerbar-left">
						<ul class="header-nav header-nav-options">
							<li class="header-nav-brand">
								<div class="brand-holder">
									<span class="location-text">
										<a href="_blank">관리자</a></span>
								</div>
							</li>
						</ul>
					</div>

					<div class="headerbar-right">
						<ul class="header-nav header-nav-options">
							<li class="hidden-xs">
								<a class="btn btn-primary-button" href="insertManager.ad">관리자 추가</a>
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
																<span class="twitter-typeahead" style="position: relative; display: block;">
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
															id="total-member-count">1</span>명 
													</header>
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
															<li class="date-join">
																<a href="_blank">가입일</a>
															</li>
															<li class="purchase text-right hidden-xs hidden-sm">누적 포인트</li>
															<li class="action"></li>
														</ul>

														<ul class="content -tbody" id="member-item-m2024051656220aef480fa">
															<li class="check">
																<div class="checkbox checkbox-styled no-margin">
																	<label>
																		<input type="checkbox">
																		<span></span>
																	</label>
																</div>
															</li>

															<li class="nick">
																<a href="_blank">관리자</a>
															</li>

															<li class="account">
																<a href="_blank">qjfhdnaos@gmail.com</a>
															</li>

															<li class="account">관리자</li>

															<li class="date-join">2024-05-16</li>
															<li class="purchase text-center hidden-xs hidden-sm"><a href="adminPoint.ad" style="text-decoration: underline;">20,000</a></li>
															<li class="action">
																<div class="dropdown">
																	<button class="btn btn-danger-button" id="deleteBtn">삭제</button>
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
	</div>

		<!-- 모달창 -->
		<div id="cocoaModal" class="modal in modal-admin deleteModal" data-backdrop="true" data-keyboard="true" style="display: none;">
			<div class="modal-dialog ui-draggable">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
								<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"/>
							  </svg>
						</button>
						<h3 class="modal-title">삭제</h3>
					</div>
					<div class="modal-body"> 
							선택한 관리자를 삭제하시겠습니까? <br>
							삭제된 기록은 복구할 수 없습니다. 
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-primary" id="board-save">삭제</button>
					</div>                        
				</div>
			</div>
		</div>

		<!-- 모달창 -->
		<!-- <div id="cocoaModal" class="modal in modal-admin pointModal" data-backdrop="true" data-keyboard="true" style="display: none;">
			<div class="modal-dialog ui-draggable">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<svg></svg>
						</button>
						<h3 class="modal-title">포인트 지급/차감</h3>
						<div class="modal-body"> 
							<form id="shop-member-point" class="form-horizontal form-validate">
								<div class="form-group">
									<label>지급 또는 차감</label>
									<select class="form-control" name="pointType" id="pointType">
										<option value="plus">지급</option>
										<option value="minus">차감</option>
									</select>
								</div>
								<div class="form-group">
									<label>금액</label>
									<input type="text" name="point" value class="form-control" name="point" autocomplete="off">
								</div>
								<div class="form-group">
									<label>사유 또는 내용</label>
									<input type="text" name="reason" value class="form-control" name="point" autocomplete="off">
								</div>
							</form>
						</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-flat" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-primary btn-flat _submit" id="board-save">적용</button>
					</div>                        
				</div>
			</div>
		</div> -->
</body>
</html>