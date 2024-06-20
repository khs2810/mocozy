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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminPoint_css/adminPointAnalysis.css">
	
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
										<a href="javascript:void(0);">통계</a>
									</span>
								</div>
							</li>
						</ul>
					</div>

					<div class="headerbar-right">
						<ul class="header-nav header-nav-options">
							<li class="hidden-xs">
								<a class="clay-button black exit-btn" style="margin-right: 50px;" href="adminPoint.ad">뒤로가기</a>
							</li>
						</ul><!--end .header-nav-options -->
					</div><!--끝 #header-navbar-collapse -->
					<!--끝 #header-navbar-collapse -->
				</div>

			</header>

			<!-- BEGIN CONTENT-->
			<div id="content">
				<section>
					<div class="section-body">
						<form id="analyticsForm">
							<input type="hidden" id="inputOrderBy" name="orderby" value="">
							<input type="hidden" id="inputSort" name="sort" value="">
							<div class="row">
								<div class="col-xs-12 custom-width-5">
									<div class="card card-sm-padding">
										<div class="card-body">
											<a href="javascript:void(0);" style="display: block;" id="selectDateRangeType">
												<select>
													<span class="caret"></span>
													<option>주별 통계</option>
													<option>월별 통계</option>
													<option>시간별 통계</option>
													<option>제품별 통계</option>
													<option>카테고리별 통계</option>
												</select>
											</a>
										</div>
									</div>
								</div>
								<div class="col-xs-12 custom-width-11" style="position: relative;">
									<div class="card card-sm-padding">
										<div class="card-body">
											<a href="javascript:void(0);" id="selectDateRangeType">
												<select>
													<span class="caret"></span>
													<option>최근 1주일</option>
													<option>최근 1개월</option>
													<option>최근 6개월</option>
													<option>최근 1년</option>
													<option>이번달</option>
													<option>지난달</option>
												</select>
											</a>

											<div id="dateRangeRangeWrap">
												<div class="form-control-datepicker">
													<input type="date" id="date" max="2077-06-20" min="1900-12-05" placeholder="시작일"  class="_start_date _date_range_input form-control width-3" style="display: inline-block;">
												</div>
												<span style="padding: 0px 8px;">~</span>
												<div class="form-control-datepicker">
													<input type="date" id="date" max="2077-06-20" min="1900-12-05" placeholder="시작일"  class="_start_date _date_range_input form-control width-3" style="display: inline-block;">
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
	
	
							<div class="row">
								<div class="col-md-12">
									<div class="card">
	
										<div class="card-body no-padding">
											<div class="table-responsive">
												<div class="li-table">
													<ul class="subject">
														<!-- 여기 데이터는 입맛대로 수정하세요-->
														<li class="date">날짜</li>
														<li class="nick">구매건수</li>
														<li class="data">구매금액</li>
														<li class="order">추가/환불</li>
														<li class="stz text-right">순매출</li>
														<li class="balance text-right">매출합계</li>
													</ul>
														<ul class="subject ">
															<li class="date">2024-12-01</li>
															<li class="nick">300</li>
															<li class="data">40000</li>
															<li class="order" style="color: blue;">환불</li>
															<li class="stz text-right">30,0000,0000</li>
															<li class="balance text-right">400,0000,0000</li>
														</ul>

												</div><!--end.li-table-->
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</section>
			</div>
		</div>
	</div>
</body>
<%@ include file="../../common/topButton.jsp"%>
</html>