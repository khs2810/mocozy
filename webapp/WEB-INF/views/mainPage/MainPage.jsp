<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- 공용 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/91f9609a45.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!-- -->
    
    <link rel="stylesheet" href="../../../resources/css/common_css/Style.css">
    <link rel="stylesheet" href="../../../resources/css/mainPage_css/MainPage.css">
</head>

<body class="main">
    <div class="screen">
        <div class="box">
            <div class="screenheader">
                <h1 class="title">주간 베스트 TOP20👑</h1>
                <div class="selectBox">모두보기</div>
            </div>

            <div class="display">
                <div class="contentcard">
                    <div class="socialing">
                        <a class="cardlink" href="_blank">
                            <img class="img" srcset="_blank 1x, _blank 2x" />

                            <div class="info">
                                <div class="subject">
                                    <div class="tag">포틀럭파티</div>
                                </div>

                                <div class="infotitle">
                                    [8회차] 집에 가기 싫은 밤, 작은 LP카페에서 같이 저녁 먹어요!
                                </div>

                                <div class="describe">
                                    소셜링 ·
                                    <img srcset="_blank 16w, _blank 32w, _blank 48w, _blank 64w, _blank 96w, _blank 128w, _blank 256w, _blank 384w, _blank 640w, _blank 750w, _blank 828w, _blank 1080w, _blank 1200w, _blank 1920w, _blank 2048w, _blank 3840w"
                                        class="image">
                                    영등포구 · 5.20(월) 오후 8:30
                                </div>

                                <div class="participant">
                                    <img alt="participant" class="img">
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <div class="socialmember">
                                        <img class="people" srcset="_blank1x, _blank 2x" alt="people" />
                                        <div class="count"> 4/5 </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="contentcard">
                    <div class="socialing">
                        <a class="cardlink" href="_blank">
                            <img class="img" srcset="_blank 1x, _blank 2x" />

                            <div class="info">
                                <div class="subject">
                                    <div class="tag">포틀럭파티</div>
                                </div>

                                <div class="infotitle">
                                    [8회차] 집에 가기 싫은 밤, 작은 LP카페에서 같이 저녁 먹어요!
                                </div>

                                <div class="describe">
                                    소셜링 ·
                                    <img srcset="_blank 16w, _blank 32w, _blank 48w, _blank 64w, _blank 96w, _blank 128w, _blank 256w, _blank 384w, _blank 640w, _blank 750w, _blank 828w, _blank 1080w, _blank 1200w, _blank 1920w, _blank 2048w, _blank 3840w"
                                        class="image">
                                    영등포구 · 5.20(월) 오후 8:30
                                </div>

                                <div class="participant">
                                    <img alt="participant" class="img">
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <span class="span">
                                        <img class="cardImg" srcset="_blank 1x, _blank 2x" />
                                    </span>
                                    <div class="socialmember">
                                        <img class="people" srcset="_blank1x, _blank 2x" alt="people" />
                                        <div class="count"> 4/5 </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>

                <a class="plus" href="_blank">
                    <div class="title">더보기
                      <img class="icon" src="_blank" width="14" height="14">
                      </div>
                  </a>

            </div>
        </div>
    </div>
</body>

</html>