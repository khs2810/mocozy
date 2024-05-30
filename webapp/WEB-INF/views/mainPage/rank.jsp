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
									<a href="_blank">
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
							<div class="iconbox">
								<div class="c">
									<div class="graycontent">
										<svg class="icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
										  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
										</svg>
									</div>
								</div>
							</div>
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