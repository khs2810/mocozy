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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminNotice.css">
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
									<a href="_blank">공지사항</a> 
								</span>
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

						<div class="row no-margin">
							<div class="hidden-xs hidden-sm">
								<!-- PC 검색 시작 -->
								<div class="card search-box">
									<div class="card-body no-padding">
										<form class="user-search">
											<div class="form-group">
												<label class="icon-set left">
													<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
												</label>
												<div id="prefetch">
													<input type="text" placeholder="게시판 양식명 검색" id="postSearch" name="board-keyword" class="form-control typeahead" >
												</div>
											</div>
										</form>
									</div>
								</div>

								<!-- PC 검색 끝 -->
								<div class="card cardscroll">
									<div class="card-body no-padding">
										<ul class="nav nav-pills nav-stacked sortable-list -sortable-list ui-sortable">
											<li class="active">
												<a href="_blank">공지사항 전체
													<small id="total-list-comment-count" class="margin-left-lg text-bold opacity-75 count">1</small>
												</a>
											</li>
											<li>
												<a href="_blank">
													<img src="_blank" width="20">공지사항
													<small id="list-comment-count-b2024051627b50eaa64a9a" class="margin-left-lg text-bold opacity-75 count"></small>
														<button class="pull-right btn btn-flat no-padding hover-visible">
															<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
														</button>
												</a>
											</li>
											<li id="board-item-b202405169c294be1ca714">
												<a href="_blank">
													<img src="_blank" width="20">이벤트
													<small id="list-comment-count-b202405169c294be1ca714" class="margin-left-lg text-bold opacity-75 count">1</small>
													<button class="pull-right btn btn-flat no-padding hover-visible">
														<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
													</button>
												</a>
											</li>
										</ul>
									</div><!--end.card-body-->
								</div><!--end.card-->
							</div><!--end.col-->

							<div class="col-md-3 hidden-md hidden-lg">
								<!-- 모바일 검색 시작 -->
								<div class="card search-box">
									<div class="card-body no-padding">
										<form class="user-search">
											<div class="form-group">
												<label class="icon-set left">
													<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
												</label>
												<div id="prefetch">
													<input type="text" placeholder="게시판 양식명 검색" id="postSearch" name="board-keyword"  class="form-control typeahead">
												</div>
											</div>
										</form>
									</div>
								</div>

								<!-- 모바일 검색 끝 -->
								<div class="card" style="margin-bottom: 10px">
									<div class="card-body sm-padding-y">
										<div class="form-control no-border cont-select">
											<button class="btn-select">전체 게시물</button>
										</div>
									</div>
								</div>
							
							</div>
						</div>

						<div class="col-md-9 no-padding">
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-body no-padding">
												<form class="user-search">
													<div class="form-group">
														<label for="postSearch2" class="icon-set left">
															<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
														</label>
														<div id="prefetch">
															<input type="text" placeholder="작성자, 제목 검색" id="postSearch2" name="keyword"  class="form-control typeahead">
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>

									<div class="col-md-12">
										<div class="card">
											<div class="card-head">
												<header class="small">공지사항 목록
													<span id="comment-count" class="text-primary _count">1</span>
												</header>
											</div>

											<div class="card-body no-padding">
												<div class="li-table" id="UI-TABLE">
													<ul class="subject">
														<li class="check">
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" class="all-check">
																	<span></span>
																</label>
															</div>
														</li>
														<li class="lang-icon width20"></li>
														<li class="category hidden-xs hidden-sm"> 카테고리</li>
														<li class="title">제목</li>
														<li class="author">작성자</li>
														<li class="date">작성일</li>
														<li class="action"></li>
													</ul>

													<ul class="-tbody holder content" id="post-item-p20240521492f0349dfaec">
														<li class="check">
															<div class="checkbox checkbox-styled no-margin">
																<label>
																	<input type="checkbox" >
																	<span></span>
																</label>
															</div>
														</li>

														<li class="lang-icon">
															<img src="_blank" style="width:20px">
														</li>
														
														<li class="based">공지사항</li>

														<li class="title">
															<span class="-icon-notice-p20240521492f0349dfaec" style="display:none">
																<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
															</span> 
															<a href="_blank" class="post-link">
																<span class="-post-subject-p20240521492f0349dfaec">테스트</span>
																<span class="badge -hide-badge-p20240521492f0349dfaec" style="margin-left:5px;display:none">숨김</span>
															</a>
														</li>
														<li class="author">
															<a href="_blank" class="text-primary">관리자</a>
														</li>
														<li class="date" > 2024-05-21 </li>
														<li class="action">
															<div class="dropdown">
																<button class="btn btn-flat" id="dLabel">
																	<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
																</button>
																<ul class="dropdown-menu animation-dock right">
																	<li>
																		<a href="_blank" class="-hide-post-btn-p20240521492f0349dfaec">숨기기</a>
																	</li>

																	<li>
																		<a href="_blank">삭제</a>
																	</li>
																	
																	<li>
																		<a href="_blank">이동</a>
																	</li>

																	<li>
																		<a href="_blank" class="-notice-post-btn-p20240521492f0349dfaec">공지 설정</a>
																	</li>

																	<li>
																		<a href="_blank">조회수 수정</a>
																	</li>

																	<li>
																		<a href="_blank">좋아요 수정</a>
																	</li>
																	<li>
																		<a href="_blank">작성자 수정</a>
																	</li>
																	<li>
																		<a href="_blank">작성시각 수정</a>
																	</li>
																</ul>
															</div>
														</li>
													</ul>
												</div>
												<!--end.li-table-->
												<nav class="text-center">
												</nav>
											</div>
											<!--end.card-body-->
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!--end.tab-pane-->
				</div>
				<!--end.section-body.tab-content-->
			</section>
		</div>
	</div>
</body>
</html>