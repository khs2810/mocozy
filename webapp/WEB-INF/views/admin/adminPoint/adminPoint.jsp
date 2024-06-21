<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="ko">
	
	<head>
		<!-- 공용 -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>관리자 페이지</title>
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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminPoint_css/adminPoint.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">
	
		<!-- font awesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
	</head>

	<%@ include file="../sideBar.jsp"%>
	<body>
		<c:if test="${not empty alertMsg}">
			<script>
				alert("${alertMsg}");
			</script>
			<c:remove var="alertMsg" scope="session"/>
		</c:if>
		<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
		<div id="base">
			<div id="basecontent">
			<header class="top-header">
				<div class="headerbar">
					<div class="headerbar-left">
						<ul class="header-nav header-nav-options">
							<li class="header-nav-brand">
								<div class="brand-holder">
									<span class="location-text">
										<a href="adminPoint.ad">포인트</a>
									</span>
								</div>
							</li>
						</ul>
					</div>

					<div class="headerbar-right">
						<ul class="header-nav header-nav-options">
							<li class="hidden-xs">
								<ul class="header-nav header-nav-options">
									<li class="hidden-xs" style="margin-right: 10px !important">
										<a class="clay-button black exit-btn" href="admin.ad">뒤로가기</a>
									</li>
									<li class="hidden-xs" style="margin-right: 40px !important">
										<a class="clay-button btn-primary-button" href="analysis.ad">통계</a>
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
										<form id="shop-member-point" class="form-horizontal form-validate" action="point.ad" method="POST">
											
											<div class="form-group">
												<label class="col-sm-2 control-label">조정 대상</label>
												<div class="col-sm-8">
													<!-- <div class="input-group-content width-3"
														style="padding-right: 15px;width: 115px;">
														<select class="form-control static dirty" id="target-type" name="target-type">
															<option value="member">회원</option>
															<option value="group">관리자</option>
														</select>
														<div class="form-control-line"></div>
													</div> -->

													<div id="target-member-wrap" class="input-group-content width-6">
														<input type="text" name="userId" class="form-control" placeholder="회원 아이디 또는 이메일 입력" required>
														<div class="form-control-line"></div>
													</div>

													<!-- <div id="target-group-wrap" class="input-group-content width-6" style="display: none;">
														<select class="form-control static dirty" id="group-list" name="group-list">
															<option value="no-group">그룹이 존재하지 않습니다.</option>
															<option value="no-member">그룹 내에 포함되어있는 회원이 존재하지 않습니다.</option>
														</select>
														<div class="form-control-line"></div>
													</div> -->
												</div>
											</div>

											<div class="form-group">
												<input type="hidden" name="adminNo" value="${loginUser.userNo}">
												<label class="col-sm-2 control-label">포인트액</label>
												<div class="col-sm-8">
													<div class="input-group" style="line-height: 2; display: flex;">
														<div class="input-group-content width-3" style="padding-right: 15px;">
															<select class="form-control static dirty" name="pointType">
																<option value="plus">지급</option>
																<option value="minus">회수</option>
															</select>
															<div class="form-control-line"></div>
														</div>

														<div class="input-group-content width-3" style="padding-right: 15px;">
															<input type="text" class="form-control -point" placeholder="금액" name="point" required>
															<div class="form-control-line"></div>
														</div>

														<div class="input-group-content width-6">
															<input type="text" class="form-control" placeholder="사유 / 내용 입력" name="pointInfo" required>
															<div class="form-control-line"></div>
														</div>
														<button class="btn margin-left-lg btn-primary-button" type="submit">확인</button>
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
								<!-- <div class="card">
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
														<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
															<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
														  </svg>
													</label>
												</div>
											</div>
										</form>
									</div>
								</div> -->

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
													<li class="order">포인트</li>
													<li class="stz text-right">지급/회수자</li>
													<li class="balance text-right"></li>
												</ul>
												<c:forEach var="p" items="${list}">
													<ul class="subject ">
														<li class="date">${p.createDate}</li>
														<li class="nick">${p.userNickname}</li>
														<li class="data">${p.pointInfo}</li>
														<c:choose>
															<c:when test="${p.status eq 'P'}">
																<li style="color: blue;" class="order">+${p.point}</li>
															</c:when>
															<c:when test="${p.status eq 'M'}">
																<li style="color: red;" class="order">-${p.point}</li>
															</c:when>
														</c:choose>
														<li class="stz text-right">${p.adminNickname}</li>
														<li class="balance text-right"></li>
													</ul>
												</c:forEach>

											</div><!--end.li-table-->
										</div>
										<nav class="text-center">
											<ul class="pagination"></ul>
										</nav>
									</div>
									<div class="paging_bar">
										<c:if test="${pi.currentPage ne 1}">
											<button class="page_btn"><i class="fa-solid fa-angle-left" onclick="location.href='adminPoint.ad?cpage=${pi.currentPage - 1}'"></i></button>
										</c:if>
										<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
											<c:choose>
												<c:when test="${p eq pi.currentPage }">
													<div class="notice_cpage">${p}</div>
												</c:when>
												<c:otherwise>
													<button class="page_btn" onclick="location.href='adminPoint.ad?cpage=${p}'">${p}</button>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${pi.currentPage ne pi.maxPage}">
											<button class="page_btn" onclick="location.href='adminPoint.ad?cpage=${pi.currentPage + 1}'"><i class="fa-solid fa-angle-right"></i></button>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div><!--섹션 끝 -->
				</section>
			</div>
		</div>
	</div>
</body>
<%@ include file="../../common/topButton.jsp"%>
</html>