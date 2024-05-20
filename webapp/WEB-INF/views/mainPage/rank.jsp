<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/91f9609a45.js"
	crossorigin="anonymous"></script>
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
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/rank.css">
</head>

<body>
	<div class="rank">
		<div class="screen">
			<div class="display">
				<div class="ranktitle">
					<a href="_blank">
						<div class="name">실시간 랭킹 TOP100</div>
					</a>
					<div class="text">현재 가장 핫한 클래스를 만나보세요.</div>
				</div>

				<div class="ranklayer">
					<div class="wrapper">
						<div class="arank">
							<p class="rankP">1</p>
						</div>

						<div class="rankbox">
							<div class="gap">

								<div class="container">
									<a href="_blank"> <img class="img" alt="클래스 썸네일"
										srcset="_blank 1x, _blank 2x">
									</a>
								</div>

								<div class="title">
									<div class="captain">제레미 튜터</div>
									<div class="explain">
										<span>취업에 필수! 포트폴리오 10분만에 노션으로 만들기</span>
									</div>
								</div>
							</div>
						</div>

						<div class="circle">
							<div class="box">
								<div class="c">
									<div class="graycontent">
										<img class="icon" />
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="slide">
						<a href="_blank">
							<div class="ranking">
								<p class="number">2</p>
							</div>
						</a>

						<div class="fullscreen">
							<div class="items">

								<div class="contentcard">
									<a href="_blank">
										<div class="aspect">
											<img class="img" srcset="_blank 1x, _blank 2x">
										</div>
									</a>
								</div>

								<div class="teacher">
									<div class="tutor">쏘피 튜터</div>
									<div class="class">
										<span>실무에 진짜 필요한 엑셀 노하우</span>
									</div>
								</div>

							</div>
						</div>

						<div class="one">
							<div class="box">
								<div class="c">
									<div class="graycontent">
										<img class="icon" src="_blank" /> </img>
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="slide">
						<a href="_blank">
							<div class="ranking">
								<p class="number">3</p>
							</div>
						</a>

						<div class="fullscreen">
							<div class="items">

								<div class="contentcard">
									<a href="_blank">
										<div class="aspect">
											<img class="img" srcset="_blank 1x, _blank 2x" />
										</div>
									</a>
								</div>

								<div class="teacher">
									<div class="tutor">오상직 튜터</div>
									<div class="class">
										<span>단, 10일만에 팔로워 1K이상 만드는 인스타 노하우</span>
									</div>
								</div>

							</div>
						</div>

						<div class="one">
							<div class="box">
								<div class="c">
									<div class="graycontent">
										<img src="_blank" class="icon"> </img>
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="slide">
						<a href="_blank">
							<div class="ranking">
								<p class="number">4</p>
							</div>
						</a>

						<div class="fullscreen">
							<div class="items">

								<div class="contentcard">
									<a href="_blank"> <img class="img"
										srcset="_blank 1x, _blank 2x" />
									</a>
								</div>

								<div class="teacher">
									<div class="tutor">내성적인 건물주 튜터</div>
									<div class="class">
										<span>부동산 경매로 월급 대신 월세 받기</span>
									</div>
								</div>

							</div>
						</div>

						<div class="one">
							<div class="box">
								<div class="c">
									<div class="graycontent">
										<img class="icon" src="_blank"> </img>
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="slide">
						<a href="_blank">
							<div class="ranking">
								<p class="number">5</p>
							</div>
						</a>

						<div class="fullscreen">
							<div class="items">

								<div class="contentcard">
									<a href="_blank">
										<div class="aspect">
											<img class="img" srcset="_blank 1x, _blank 2x" />
										</div>
									</a>
								</div>

								<div class="teacher">
									<div class="tutor">비됴클래스 튜터</div>
									<div class="class">
										<span>50만 유튜버들의 극찬! 비됴클래스의 한 방에 끝내는 영상편집 올인원 패키지</span>
									</div>
								</div>

							</div>
						</div>

						<div class="one">
							<div class="box">
								<div class="c">
									<div class="graycontent">
										<img class="icon" src="_blank" />
									</div>
								</div>
							</div>
						</div>

					</div>

					<a class="pluslink" href="_blank">
						<button class="plusbutton">
							실시간 랭킹 더보기 <img class="icon" src="_blank" />
						</button>
					</a>

				</div>
			</div>
		</div>
	</div>
</body>
</html>