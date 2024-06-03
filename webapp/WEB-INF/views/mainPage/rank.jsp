<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/rank.css">
</head>

<body>
	<div class="rank">
		<div class="screen">
		
 			<div class="rankdisplay">
				<div class="ranktitle">
					<a href="_blank">
						<div class="name">리뷰순 모임 TOP5</div>
					</a>
					<div class="text">현재 가장 핫한 모임을 만나보세요.</div>
				</div>

					<c:forEach var="club" items="${rlist}">
					<div class="slide">
						<a href="_blank">
							<div class="ranking">
								<p class="number"></p>
							</div>
						</a>

						<div class="fullscreen">
							<div class="items">

								<div class="rankcontentcard">
									<a href="detail.cl?cno=${club.clubNo}">
										<div class="aspect">
											<img class="aspectimg" src="${club.thumbnailImg}"/>
										</div>
									</a>
								</div>

								<div class="teacher">
									<div class="tutor">${club.clubTitle}</div>
									<div class="class">
										<span>${club.clubContent}</span>
									</div>
								</div>

							</div>
						</div>

						<div class="one">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-feather bootstrapicon" viewBox="0 0 16 16" style="color: gray;">
									<path d="M15.807.531c-.174-.177-.41-.289-.64-.363a3.8 3.8 0 0 0-.833-.15c-.62-.049-1.394 0-2.252.175C10.365.545 8.264 1.415 6.315 3.1S3.147 6.824 2.557 8.523c-.294.847-.44 1.634-.429 2.268.005.316.05.62.154.88q.025.061.056.122A68 68 0 0 0 .08 15.198a.53.53 0 0 0 .157.72.504.504 0 0 0 .705-.16 68 68 0 0 1 2.158-3.26c.285.141.616.195.958.182.513-.02 1.098-.188 1.723-.49 1.25-.605 2.744-1.787 4.303-3.642l1.518-1.55a.53.53 0 0 0 0-.739l-.729-.744 1.311.209a.5.5 0 0 0 .443-.15l.663-.684c.663-.68 1.292-1.325 1.763-1.892.314-.378.585-.752.754-1.107.163-.345.278-.773.112-1.188a.5.5 0 0 0-.112-.172M3.733 11.62C5.385 9.374 7.24 7.215 9.309 5.394l1.21 1.234-1.171 1.196-.027.03c-1.5 1.789-2.891 2.867-3.977 3.393-.544.263-.99.378-1.324.39a1.3 1.3 0 0 1-.287-.018Zm6.769-7.22c1.31-1.028 2.7-1.914 4.172-2.6a7 7 0 0 1-.4.523c-.442.533-1.028 1.134-1.681 1.804l-.51.524zm3.346-3.357C9.594 3.147 6.045 6.8 3.149 10.678c.007-.464.121-1.086.37-1.806.533-1.535 1.65-3.415 3.455-4.976 1.807-1.561 3.746-2.36 5.31-2.68a8 8 0 0 1 1.564-.173"/>
							  	</svg>
							<div class="reviewCount">${club.reviewCount}</div>
						</div>
							
					</div>
					<div class="blankbox"></div>
					</c:forEach>
				
					<div class="plusdiv">
					<a class="pluslink" href="_blank">
						<button class="plusbutton">
							인기 클럽 더보기 
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
							  <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
							</svg>
						</button>
					</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>