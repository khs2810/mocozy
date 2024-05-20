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
	href="${pageContext.request.contextPath}/resources/jo/css/common_css/Style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/mainPage_css/CateButton.css">
</head>

<body>
	<div class="catebutton">
		<div class="screen">
			<div class="grid">
				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">전체</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">문화 · 예술</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">액티비티</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">푸드 · 드링크</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">취미</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">여행 · 동행</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">자기계발</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">파티 · 게임</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">재테크</div>
				</div>

				<div class="icon">
					<a href="_blank">
						<div class="img">
							<img class="imgsrc" src="_blank" />
						</div>
					</a>
					<div class="name">연애 · 사랑</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>