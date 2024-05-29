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
	<%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <div class="main-content">
            <div class="main-content-head">
                <h2 style="margin-right: 30px;">리뷰</h2>
                <h5>참여한 모임</h5>
            </div>
            <hr style="background: lightgray; height: 1px; border: 0;">
            <div class="reviewList">
            
            	<c:forEach var="c" items="${list}">
            		<div class="review">
	                    <div class="leftPart">
	                        <img class="thumbnail" src="${pageContext.request.contextPath}/${c.thumbnailImg}">
	                    </div>
	                    <div class="midPart">
	                        <div class="clubTitle">
	                            <span>${c.clubTitle}</span>
	                        </div>
	                        <div class="clubMsg">
	                            <pre>모임 종류 : ${c.clubType}<br>파티장 : ${c.nickname}<br>날짜 : ${c.eventDateStr}</pre>
	                        </div>
	                    </div>
	                    <div class="rightPart">
	                        <div class="scorePart">
	                            <img src="${pageContext.request.contextPath}/resources/jun/img/star.png">
	                            <span class="score">${c.totalPoint}</span>
	                        </div>
	                        <div class="btnPart">
	                        	<c:choose>
	                        		<c:when test="${c.isReview eq 0}">
			                            <button type="button" class="writeBtn" data-toggle="modal" data-target="#reviewEnrollWindow">리뷰 작성</button>
	                        		</c:when>
	                        		<c:when test="${c.isReview eq 1}">
			                            <button type="button" class="detailBtn" data-toggle="modal" data-target="#reviewDetailWindow">리뷰 보기</button>
	                        		</c:when>
	                        	</c:choose>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            
                <%-- <div class="review">
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
                            <pre>모임 종류 : 소셜링<br>파티장 : 누구누구<br>날짜 : 언제언제</pre>
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
                </div> --%>
            </div>
        </div>
    </div>

    <!-- The Modal -->
    <c:forEach var="r" items="${list}">
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
    </c:forEach>
    
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
    <c:forEach var="r" items="${list}">
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
	                        <textarea name="" id=""><%-- ${r.reviewContent} --%>리뷰내용</textarea>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
    </c:forEach>
    
    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>
    
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