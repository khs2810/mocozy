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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminBlock.css">
	</head>

<%@ include file="../../common/sideBar.jsp"%>
	<body>
		<div class="menubar-hoverable header-fixed menubar-pin">
		<div id="base">
		<header class="top-header" id="default-header">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand">
							<div class="brand-holder">
								<span class="location-text">
									<a href="_blank">신고 · 차단</a> 
								</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</header>

		<div id="content">
			<section class="section-max-width section">
				<div class="section-body">
					<ul class="nav nav-tabs nav-margin">
						<li class="active">
							<a href="_blank">신고 
								<span class="_count text-primary">0</span>
							</a>
						</li>
						<li>
							<a href="_blank">차단 
								<span class="_count text-primary">0</span>
							</a>
						</li>
					</ul>

					<div class="tab-pane">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-body">
										<div style="display: flex; align-items: center; margin-bottom: 3px; column-gap: 4px;"> 
											신고 시 안내문구 
											<a class="btn btn-xs btn-default-bright btn-sm-padding btn-circle">문구 설정</a>
										</div>
										<div>
											신고해주신 내용은 관리자 검토 후 내부 운영정책에 의해 조치가 진행됩니다. 
										</div>
									</div>
								</div>
							</div><!--end.col-->
						</div><!--end.row-->

						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-head">
										<header class="small">신고 
											<span class="_count text-primary">0</span>
										</header>
										<div class="tools">
											<div class="btn-group">
												<div class="text-gray-bright">
													최근 60일 미처리 내역 </div>
											</div>
										</div>
									</div>
									<div class="card-body no-padding">
										<div class="force-padding text-gray-bright text-center" style="padding-bottom:84px; padding-top: 84px">
											<div class="text-lg">접수된 신고가 없습니다.</div>
										</div>
									</div><!--end.card-body-->
								</div><!--end.card-->
							</div><!--end.col-->
						</div>
					</div><!--end.tab-pane-->
				</div>
			</section>
		</div>
	</div>
</body>
</html>