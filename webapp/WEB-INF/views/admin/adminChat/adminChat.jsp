<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<!-- 공용 -->
			<meta charset="utf-8">
			<title>관리자 페이지</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
			<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
				rel="stylesheet">
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

			<!-- include libraries(jQuery, bootstrap) -->
			<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" type="text/css"
				rel="stylesheet">
			<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

			<!-- include summernote css/js -->
			<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" type="text/css"
				rel="stylesheet">
			<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
			<!-- -->

			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/modal.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminChat_css/adminChat.css">
			<script
				src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminCommon_js/adminChat.js"></script>
		</head>

		<%@ include file="../sideBar.jsp" %>

			<body>
				<c:if test="${not empty alertMsg}">
					<script>
						alert("${alertMsg}");
					</script>
					<c:remove var="alertMsg" scope="session" />
				</c:if>
				<div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
					<div id="base">
						<div id="basecontent">
							<header class="top-header" id="default-header">
								<div class="headerbar">
									<div class="headerbar-left">
										<ul class="header-nav header-nav-options">
											<li class="header-nav-brand">
												<div class="brand-holder">
													<span class="location-text"> <a href="_blank"
															class="site-name">채팅</a>
													</span>
												</div>
											</li>
										</ul>
									</div>

									<div class="headerbar-right">
										<ul class="header-nav header-nav-options">
											<li class="hidden-xs"><a class="clay-button black exit-btn"
													style="margin-right: 50px;" href="admin.ad">뒤로가기</a></li>
										</ul>
										<!--end .header-nav-options -->
									</div>
									<!--끝 #header-navbar-collapse -->
									<!--끝 #header-navbar-collapse -->
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
															<div class="card-head">
																<header class="small">
																	채팅 목록 <span id="comment-count"
																		class="text-primary _count">${adminChat}</span>
																</header>
															</div>

															<div class="card-body no-padding">
																<div class="li-table">
																	<ul class="subject">
																		<li class="title">제목</li>
																		<li class="author">유저명</li>
																		<li class="date">문의일</li>
																		<li class="action"></li>
																	</ul>

																	<c:forEach var="c" items="${adminChatList}">
																		<ul class="-tbody holder content">
																			<li class="title"><span
																					class="-icon-notice-p20240521492f0349dfaec"
																					style="display: none"> <svg
																						style="border: 1px solid black; height: 16px; width: 16px;">
																						<!-- 아이콘 --></svg>
																				</span> <a href="jascript:void(0);"
																					class="post-link"> <span
																						class="-post-subject-p20240521492f0349dfaec">${c.roomTitle}</span>
																					<span
																						class="badge -hide-badge-p20240521492f0349dfaec"
																						style="margin-left: 5px; display: none">숨김</span>
																				</a></li>
																			<li class="author">
																				<a href="jascript:void(0);"
																					class="text-primary">${c.targetNickname}</a>
																			</li>
																			<li class="date">${c.createDate}</li>
																			<li class="action">
																				<div class="dropdown">
																					<button
																						class="btn btn-primary-button">
																						<a
																							href="privateChat.ad?chno=${c.chatNo}">이동</a>
																					</button>
																					<button class="btn btn-flat"
																						id="deleteBtn${c.chatNo}"
																						onclick="chatStatus(${c.chatNo}, 'H')">종료</button>
																				</div>
																			</li>
																		</ul>
																	</c:forEach>
																	<script>
																		function chatStatus(chatNo, status) {
																			$.ajax({
																				url: 'chatStatus.ad',
																				data: { chatNo: chatNo, status: status },
																				success: function (response) {
																					console.log("요청 성공");
																					// 서버에서 받은 redirect URL로 페이지를 리다이렉트
																					if (response.redirect) {
																						window.location.href = response.redirect;
																					}
																				},
																				error: function () {
																					alert("요청이 실패했습니다");
																				}
																			});
																		}
																	</script>
																</div>
																<!--end.li-table-->
																<nav class="text-center"></nav>
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

					<!-- 모달창 -->
					<div id="cocoaModal" class="modal in modal-admin deleteModal" data-backdrop="true"
						data-keyboard="true" style="display: none;">
						<div class="modal-dialog ui-draggable">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										<svg>
											<!--아이콘 --></svg>
									</button>
									<h3 class="modal-title">삭제</h3>
								</div>
								<div class="modal-body">
									선택한 채팅을 삭제하시겠습니까? <br> 삭제된 기록은 복구할 수 없습니다.
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-default btn-flat"
										data-dismiss="modal">취소</button>
									<button type="submit" class="btn btn-primary btn-flat" id="board-save">삭제</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</body>
			<%@ include file="../../common/topButton.jsp" %>

		</html>