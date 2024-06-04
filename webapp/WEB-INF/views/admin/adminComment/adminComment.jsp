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
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/common_css/adminstyle.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminComment.css">
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
									<a href="_blank">댓글</a> 
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

						<div class="col-md-11 no-padding">
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
												<header class="small">댓글 목록
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
														
														<li class="category hidden-xs hidden-sm" id="category-type">
															<a>자기계발</a>
														</li>

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
															<a href="_blank" class="text-primary">뽀꿈이</a>
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
				<!--end.section-body.tab-content-->
			</section>
		</div>
	</div>
</body>
</html>