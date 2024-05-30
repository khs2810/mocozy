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
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/MyPage.css" />
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
	                            <span class="score">총점 : ${c.totalPoint}</span>
	                        </div>
	                        <div class="btnPart">
	                        	<c:choose>
	                        		<c:when test="${c.isReview eq 0}">
			                            <button type="button" class="writeBtn" data-toggle="modal" data-target="#reviewEnrollWindow" data-cno="${c.clubNo}">리뷰 작성</button>
	                        		</c:when>
	                        		<c:when test="${c.isReview eq 1}">
			                            <button type="button" class="detailBtn" data-toggle="modal" data-target="#reviewDetailWindow">리뷰 보기</button>
	                        		</c:when>
	                        	</c:choose>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            </div>
        </div>
    </div>

    <!-- The Modal -->
    <c:forEach var="r" items="${rlist}">
    	<c:choose>
    		<c:when test="${r eq null}">
			    <div class="modal" id="reviewEnrollWindow">
			        <div class="modal-dialog">
			            <div class="modal-content" style="border: 4px solid black; border-bottom-right-radius: 30px;">
			            
			                <!-- Modal Header -->
			                <div class="modal-header">
			                <h4 class="modal-title">리뷰 작성하기</h4>
			                <button type="button" class="close" data-dismiss="modal">&times;</button>
			                </div>
			                
			                <!-- Modal body -->
			                <form id="" method="post" action="insertReview.cl">
				                <div class="modal-body">
				                    <div class="star-rating">
				                        <input type="radio" id="5-stars" name="rating" value="5"/>
				                        <label for="5-stars" class="star" onclick="countingStar(5)">&#9733;</label>
				                        <input type="radio" id="4-stars" name="rating" value="4"/>
				                        <label for="4-stars" class="star" onclick="countingStar(4)">&#9733;</label>
				                        <input type="radio" id="3-stars" name="rating" value="3"/>
				                        <label for="3-stars" class="star" onclick="countingStar(3)">&#9733;</label>
				                        <input type="radio" id="2-stars" name="rating" value="2"/>
				                        <label for="2-stars" class="star" onclick="countingStar(2)">&#9733;</label>
				                        <input type="radio" id="1-star" name="rating" value="1"/>
				                        <label for="1-star" class="star" onclick="countingStar(1)">&#9733;</label>
				                    </div>
				                    <div class="review-write">
				                        <textarea name="reviewContent" id="" placeholder="리뷰를 작성하세요"></textarea>
				                    </div>
				                </div>
				                
				                <!-- Modal footer -->
				                <div class="modal-footer">
				                	<input type="hidden" name="grade" value=""/>
				                	<input type="hidden" name="clubNo"/>
				                	<input type="hidden" name="userNo" value="${loginUser.userNo}"/>
				                    <button type="submit" class="btn btn-danger">리뷰 등록</button>
				                </div>
			                </form>
			            </div>
			        </div>
			    </div>
    		</c:when>
    		<c:otherwise>
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
							    <div class="star-rated">
							        <c:forTokens var="s" items="5,4,3,2,1" delims=",">
							            <c:choose>
							                <c:when test="${s le r.grade}">
							                    <input type="radio" id="${s}-stared" name="rating" value="${s}"/>
							                    <label for="${s}-stared" class="star" style="color:#f90">&#9733;</label>
							                </c:when>
							                <c:when test="${s gt r.grade}">
							                    <input type="radio" id="${s}-stared" name="rating" value="${s}"/>
							                    <label for="${s}-stared" class="star" style="color:#f90">&#9734;</label>
							                </c:when>
							            </c:choose>
							        </c:forTokens>
							    </div>
							    <div class="review-write">
							        <textarea name="" id="" readonly>${r.reviewContent}</textarea>
							    </div>
							</div>
			            </div>
			        </div>
			    </div>
    		</c:otherwise>
    	</c:choose>
    </c:forEach>
    
    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>

</body>
</html>