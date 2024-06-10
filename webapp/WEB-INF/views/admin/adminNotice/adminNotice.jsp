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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminNotice_css/adminNotice.css">
		<script src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminNotice_js/adminNotice.js"></script>
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
								<div class="col-md-9 no-padding">
										<div class="row">
											<div class="col-md-12">
												<div class="card">
													<div class="card-body no-padding">
														<form class="user-search">
															<div class="form-group">
																<label for="postSearch2" class="icon-set left">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
																		<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
																	  </svg>
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
																		<button class="btn btn-danger-button" id="deleteBtn">삭제</button>
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
			</div>
		</div>
	</div>

	<!-- 모달창 -->
	<div id="cocoaModal" class="modal in modal-admin deleteModal" data-backdrop="true" data-keyboard="true" style="display: none">
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
						선택한 공지사항을 삭제하시겠습니까? <br>
						삭제된 기록은 복구할 수 없습니다. 
				</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-flat" data-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-primary btn-flat" id="board-save">삭제</button>
                </div>                        
            </div>
        </div>
    </div>
</body>
</html>