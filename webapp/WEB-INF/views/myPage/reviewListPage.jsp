<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/reviewListPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/reviewListPage.js"></script>
</head>
<body>
	<%@ include file="../common/Header.jsp"%>
    <div class="MyPage-body">
        <div class="mypage-main">
            <div class="user-profile">
                <div class="box">
                    <div>
                        <!-- 프로필사진 -->
                        <div class="box1" style="background: #BDBDBD;">
                            <img class="profile" src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" data-toggle="modal" data-target="#profileModal" style="cursor: pointer;">
                        </div>
                    </div>
                    <div>
                        <!-- 닉네임 및 계정이메일 -->
                        <div class="account">
                            <p>떡꼬치대마왕 님</p>
                            mocozygood@gmail.com
                        </div>

                        <!-- 포인트 -->
                        <div class="account point">
                            <p>100,000pt</p>
                            <button>충전</button>
                        </div>
                    </div>
                </div>
                <!-- 매너점수 -->
                <div class="manner">
                    <img src="./img/로고-떡떡떡.png" alt="">
                    <p>매너점수</p>
                    <div class="gauge">
                        <progress id="progress" value="36.5" min="0" max="100"></progress>
                    </div>
                </div>
            </div>
                
            
            <!-- 메뉴 네비 -->
            <div class="mypage-navi">
                <nav>
                    <ul id="main_menu">
                        <li><a href="./MyPage01.html">마이페이지</a></li>
                        <hr>

                        <li><a href="./MyPage02.html">내 프로필</a></li>
                        <hr>

                        <li><a href="">소셜링 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="./MySocial.html" class="snd_title">내가 만든 소셜링</a></li>
                                <li><a href="./goSocial.html" class="snd_title">참여 중인 소셜링</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="" onclick="">챌린지 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">내가 만든 챌린지</a></li>
                                <li><a href="" class="snd_title">참여 중인 챌린지</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="">포인트</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">포인트 관리</a></li>
                                <li><a href="" class="snd_title">충전 내역</a></li>
                                <li><a href="" class="snd_title">사용 내역</a></li>
                            </ul>
                        </li>
                        <hr>

                        <li><a href="">찜</a></li>
                        <hr>

                        <li><a href="">리뷰</a></li>
                        <hr>

                        <li><a href="">채팅기록</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        
        <div class="main-content">
            <div class="main-content-head">
                <h2 style="margin-right: 30px;">리뷰</h2>
                <h5>참여한 모임</h5>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;">
            <div class="reviewList">
                <div class="review">
                    <div class="leftPart">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/clubImg1.png">
                    </div>
                    <div class="midPart">
                        <div class="clubTitle">
                            <span>♥블랙라이어♥:: with.하이볼 무제한🍺</span>
                        </div>
                        <div class="clubMsg">
                            <pre>새로운 사람과 만나는 설렘과 도파민 터지는 시간 속
라이어를 찾아내는 블랙라이어파티에
일상에서 벗어나고픈 여러분들을 초대합니다 💌</pre>
                        </div>
                    </div>
                    <div class="rightPart">
                        <div class="scorePart">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/star.png">
                            <span class="score">4.5</span>
                        </div>
                        <div class="btnPart">
                            <button type="button" class="writeBtn" data-toggle="modal" data-target="#reviewEnrollWindow">리뷰 작성</button>
                        </div>
                    </div>
                </div>

                <div class="review">
                    <div class="leftPart">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/clubImg2.png">
                    </div>
                    <div class="midPart">
                        <div class="clubTitle">
                            <span>선착순 10분!! 상품은....함정카드 발동!</span>
                        </div>
                        <div class="clubMsg">
                            <pre>들어오지 않고는 못베길거야</pre>
                        </div>
                    </div>
                    <div class="rightPart">
                        <div class="scorePart">
                            <img src="${pageContext.request.contextPath}/resources/jun/img/star.png">
                            <span class="score">4.5</span>
                        </div>
                        <div class="btnPart">
                            <button type="button" class="detailBtn" data-toggle="modal" data-target="#reviewDetailWindow">리뷰 보기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- The Modal -->
    <div class="modal" id="reviewEnrollWindow">
        <div class="modal-dialog">
            <div class="modal-content" style="border: 4px solid black; border-bottom-right-radius: 30px;">
            
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">리뷰 작성하기</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="star-rating">
                        <input type="radio" id="5-stars" name="rating" value="5" />
                        <label for="5-stars" class="star">&#9733;</label>
                        <input type="radio" id="4-stars" name="rating" value="4" />
                        <label for="4-stars" class="star">&#9733;</label>
                        <input type="radio" id="3-stars" name="rating" value="3" />
                        <label for="3-stars" class="star">&#9733;</label>
                        <input type="radio" id="2-stars" name="rating" value="2" />
                        <label for="2-stars" class="star">&#9733;</label>
                        <input type="radio" id="1-star" name="rating" value="1" />
                        <label for="1-star" class="star">&#9733;</label>
                    </div>
                    <div class="review-write">
                        <textarea name="" id="" placeholder="리뷰를 작성하세요"></textarea>
                    </div>
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">리뷰 등록</button>
                </div>
                
            </div>
        </div>
    </div>
    
    <!-- <div class="reviewEnrollWindow">
        <div class="review-head">
            <p class="review-title">리뷰 작성하기</p>
        </div>
        <div>
            <img class="closeBtn" src="${pageContext.request.contextPath}/resources/jun/img/x.png">
        </div>
        <div class="star-rating">
            <input type="radio" id="5-stars" name="rating" value="5" />
            <label for="5-stars" class="star">&#9733;</label>
            <input type="radio" id="4-stars" name="rating" value="4" />
            <label for="4-stars" class="star">&#9733;</label>
            <input type="radio" id="3-stars" name="rating" value="3" />
            <label for="3-stars" class="star">&#9733;</label>
            <input type="radio" id="2-stars" name="rating" value="2" />
            <label for="2-stars" class="star">&#9733;</label>
            <input type="radio" id="1-star" name="rating" value="1" />
            <label for="1-star" class="star">&#9733;</label>
        </div>
        <div class="review-write">
            <textarea name="" id="" placeholder="리뷰를 작성하세요"></textarea>
        </div>
        <div class="reviewEnrollBtn">
            <button>리뷰 등록</button>
        </div>
    </div> -->
    
    <!-- The Modal -->
    <div class="modal" id="reviewDetailWindow">
        <div class="modal-dialog">
            <div class="modal-content" style="padding-bottom: 20px; border: 4px solid black; border-bottom-right-radius: 30px;">
            
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">리뷰 보기</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="star-rating">
                        <input type="radio" id="5-stars" name="rating" value="5" />
                        <label for="5-stars" class="star">&#9733;</label>
                        <input type="radio" id="4-stars" name="rating" value="4" />
                        <label for="4-stars" class="star">&#9733;</label>
                        <input type="radio" id="3-stars" name="rating" value="3" />
                        <label for="3-stars" class="star">&#9733;</label>
                        <input type="radio" id="2-stars" name="rating" value="2" />
                        <label for="2-stars" class="star">&#9733;</label>
                        <input type="radio" id="1-star" name="rating" value="1" />
                        <label for="1-star" class="star">&#9733;</label>
                    </div>
                    <div class="review-write">
                        <textarea name="" id="">짐이 작성한 리뷰이니라. 소중하게 생각하도록.</textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- The Modal -->
    <div class="modal fade" id="profileModal">
        <div class="modal-dialog">
            <div class="profile-modal-content">
            
                <!-- Modal Header -->
                <div class="profile-modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                </div>
                
                <!-- Modal body -->
                <div class="profile-modal-body">
                    <div class="m-userProfile">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/프사.jpg" class="m-profileImg">
                        <span class="nickname">떡꼬치대마왕</span>
                        <span> 님</span>
                    </div>
                    <div class="m-manner">
                        <img src="${pageContext.request.contextPath}/resources/jun/img/로고.png" class="m-logo-area">
                        <div class="m-manner-area">
                            <span>매너 점수</span>
                            <div class="m-manner-score-area">
                                <div class="m-score-range">
                                    <p>0</p>
                                    <p>100</p>
                                </div>
                                <div class="m-manner-score"></div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Modal footer -->
                <div class="profile-modal-bottom">
                    <h6 style="font-size: 20px; font-weight: 600; margin: 10px 30px;">자기소개</h6>
                    <textarea class="m-introduction"></textarea>
                </div>
                
            </div>
        </div>
    </div>
    <!-- <div class="reviewDetailWindow">
        <div class="review-head">
            <p class="review-title">리뷰 보기</p>
        </div>
        <div>
            <img class="closeBtn" src="${pageContext.request.contextPath}/resources/jun/img/x.png">
        </div>
        <div class="star-rating">
            <input type="radio" id="5-stars" name="rating" value="5" />
            <label for="5-stars" class="star">&#9733;</label>
            <input type="radio" id="4-stars" name="rating" value="4" />
            <label for="4-stars" class="star">&#9733;</label>
            <input type="radio" id="3-stars" name="rating" value="3" />
            <label for="3-stars" class="star">&#9733;</label>
            <input type="radio" id="2-stars" name="rating" value="2" />
            <label for="2-stars" class="star">&#9733;</label>
            <input type="radio" id="1-star" name="rating" value="1" />
            <label for="1-star" class="star">&#9733;</label>
        </div>
        <div class="review-write">
            <textarea name="" id="">짐이 작성한 리뷰이니라. 소중하게 생각하도록.</textarea>
        </div>
    </div> -->
</body>
</html>