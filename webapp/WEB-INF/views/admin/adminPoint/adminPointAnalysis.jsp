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
									<span style="margin-left: 200px;"><a href="analysis.ad">통계</a></span>
								</div>
							</li>
						</ul>
					</div>

					<div class="headerbar-right">
						<ul class="header-nav header-nav-options">
							<li class="hidden-xs">
								<a class="clay-button black exit-btn" style="margin-right: 50px;" href="admin.ad">뒤로가기</a>
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
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
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