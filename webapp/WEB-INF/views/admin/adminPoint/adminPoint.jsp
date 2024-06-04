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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminPoint.css">
	</head>

<%@ include file="../../common/sideBar.jsp"%>
	<body>
		<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
		<div id="base">
		<header class="top-header">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand">
							<div class="brand-holder">
								<span class="location-text">
									<a href="_blank">포인트</a>
								</span>
							</div>
						</li>
					</ul>
				</div>

				<div class="headerbar-right">
					<ul class="header-nav header-nav-options">
						<li>
						</li>
					</ul><!--end .header-nav-options -->
				</div><!--끝 #header-navbar-collapse -->
				<!--끝 #header-navbar-collapse -->
			</div>
		</header>

		<!-- BEGIN CONTENT-->
		<div id="content">
			<div id="alertBox" class="alert--wrap"></div>
			<section class="section">
				<div class="section-body">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-head">
									<header>포인트 지급/차감</header>
								</div>
								<div class="card-body">
									<form id="shop-member-point" class="form-horizontal form-validate">
										<div class="form-group">
											<label class="col-sm-2 control-label">조정 대상</label>
											<div class="col-sm-8">
												<div class="input-group-content width-3"
													style="padding-right: 15px;width: 115px;">
													<select class="form-control static dirty" id="target-type" name="target-type">
														<option value="member">회원</option>
														<option value="group">그룹</option>
													</select>
													<div class="form-control-line"></div>
												</div>

												<div id="target-member-wrap" class="input-group-content width-6">
													<input type="text" name="member-id" class="form-control" placeholder="회원 아이디 또는 이메일 입력">
													<div class="form-control-line"></div>
												</div>

												<div id="target-group-wrap" class="input-group-content width-6" style="display: none;">
													<select class="form-control static dirty" id="group-list" name="group-list">
														<option value="no-group">그룹이 존재하지 않습니다.</option>
														<option value="no-member">그룹 내에 포함되어있는 회원이 존재하지 않습니다.</option>
													</select>
													<div class="form-control-line"></div>
												</div>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label">포인트액</label>
											<div class="col-sm-8">
												<div class="input-group" style="line-height: 2;">
													<div class="input-group-content width-3" style="padding-right: 15px;">
														<select class="form-control static dirty" name="point-type">
															<option value="plus">지급</option>
															<option value="minus">회수</option>
														</select>
														<div class="form-control-line"></div>
													</div>

													<div class="input-group-content width-3" style="padding-right: 15px;">
														<input type="text" class="form-control -point" placeholder="금액" name="point">
														<div class="form-control-line"></div>
													</div>

													<div class="input-group-content width-6">
														<input type="text" class="form-control" placeholder="사유 / 내용 입력" name="reason">
														<div class="form-control-line"></div>
													</div>

													<a class="btn btn-xs-padding btn-rasied btn-primary ink-reaction margin-left-lg" href="_blank">확인</a>
													<div class="input-group-content" style="text-align: right; top: -10px;"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-body no-padding">
									<form class="prod-search" id="point-search-form">
										<div class="twitter-wrap">
											<span class="twitter-typeahead" style="position: relative; display: inline-block;">
												<input type="text" class="-search form-control typeahead tt-input" placeholder="내용 검색"
													style="position: relative; vertical-align: top; background-color: transparent; padding-left: 0; border: none;">
											</span>
										</div>

										<div class="serach-wrap big-search">
											<div class="dd-filter-serach">
												<label class="icon-set">
													<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
												</label>
											</div>
										</div>
									</form>
								</div>
							</div>

							<div class="card">
								<div class="card-head">
									<header>포인트 처리내역</header>
								</div>

								<div class="card-body no-padding">
									<div class="table-responsive">
										<div class="li-table">
											<ul class="subject ">
												<li class="date">일자</li>
												<li class="nick">이름(닉네임)</li>
												<li class="data">사유/내용</li>
												<li class="order">가입한 클럽</li>
												<li class="stz text-right">증감</li>
												<li class="balance text-right">지급/회수자</li>
											</ul>

										</div><!--end.li-table-->
									</div>
									<nav class="text-center">
										<ul class="pagination"></ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div><!--섹션 끝 -->
			</section>
		</div>
	</div>
</body>
</html>