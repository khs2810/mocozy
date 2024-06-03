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
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

		<!-- include summernote css/js -->
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/common_css/adminstyle.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminTerms.css">
		<script src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminTerms.js"></script>
	</head>

<%@ include file="../../common/sideBar.jsp"%>
	<body>
		<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
		<div id="base">
		<header class="top-header" id="header">
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand">
							<div class="brand-holder">
								<span class="location-text"><a href="_blank">약관</a></span>
							</div>
						</li>
					</ul>
				</div>

				<div class="headerbar-right">
					<ul class="header-nav header-nav-options -option-list">
						<li><a class="btn btn-primary disabled">저장</a></li>
					</ul><!--end .header-nav-options -->
				</div><!--끝 #header-navbar-collapse -->
				<!--끝 #header-navbar-collapse -->
			</div>
		</header>

		<div id="content">
			<section class="section-max-width section">
				<div class="section-body">
					<div class="row">
						<div class="col-md-12">
							<div class="card hidden-lg hidden-md hidden-sm" id="select-tos">
								<div class="card-body sm-padding-y">
									<div class="form-control no-border">이용약관</div>
								</div>
							</div>

							<div class="card">
								<div class="card-head style-default-light hidden-xs">
									<ul class="nav nav-tabs">
										<li class="active">
											<a href="_blank">이용약관</a>
										</li>
										<li> 
											<a href="_blank">개인정보처리방침</a>
										</li>
										<li>
											<a href="_blank">마케팅 활용동의 및 광고수신동의</a></li>
										<li>
											<a href="_blank">소모임 가입 주의사항</a>
										</li>
										<li>
											<a href="_blank">참가비 환불 규정 안내</a>
										</li>
										<li>
											<a href="_blank">만 14세 이상 동의</a>
										</li>
									</ul>
								</div>

								<div class="card-body">
									<div class="margin-bottom-xxl">
										<svg style="border: 1px solid black; height: 16px; width: 16px;"><!-- 아이콘 --></svg>
										이용약관  
									</div>

									<div class="alert alert-success">
										법률 자문이나 법적 검토가 이루어지지 않았다면, 공정거래위원회의 표준약관을 수정없이 사용해야 합니다.<br>
										아래 양식은 샘플로 제공되는 서식으로 운영형태에 따른 수정이 필요합니다.<br>
										HTML태그 사용이 가능하지만 줄바꿈(BR태그)은 자동으로 처리되어 입력하실 필요가 없습니다.
									</div>

									<p>
										<a class="btn btn-default-bright" href="_blank">표준약관 적용</a>
									</p>

									<div class="summernote_div">
											<textarea id="summernote" name="noticeContent" required></textarea>
									</div>
							</div><!--end.card-body-->
						</div><!--end.card-->
					</div><!--end.col-->
				</div><!--end.row-->

			</div> <!--end.section-body.tab-content-->
			<div><a class="btn btn-primary disabled">저장</a></div>
		</section>
	</div>
</div>
</body>
</html>