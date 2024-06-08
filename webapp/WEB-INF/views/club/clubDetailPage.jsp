<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모임 상세페이지
    </title>
    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/clubDetailPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/teo/css/noticePage.css">

    <!-- 라이브러리 -->
    <script src="${pageContext.request.contextPath}/resources/teo/js/clubDetailPage.js"></script>
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <!-- 카카오 지도 api -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoApiKey}&libraries=services,clusterer,drawing"></script>
    
    
</head>
<body onload="init({clubNo: ${c.clubNo}})">
	<%@ include file="../common/header.jsp"%>
    <div id="wrap_main">
        <div id="wrap_club">
            <!-- 제목 프로필 -->
            <div id="club_main_img">
                <img src="${c.thumbnailImg}" alt="메인이미지">
            </div>
            <div class="club_title_profile" align="center">
                <div class="club_profile_img"><img src="${pageContext.request.contextPath}${c.profile_img}" alt="프로필 사진"></div>
                <div align="center">${c.nickname}</div>
            </div>
            <div class="club_title">
                <div class="club_modify_btn"></div>
                <div>
                    <h3 id="club_title">${c.clubTitle }</h2>
                </div>
                <div class="club_modify_btn">
                    <c:if test="${c.userNo eq loginUser.userNo}">
						<button onclick="location.href='updateform.cl?cno=${c.clubNo}'">수 정</button>
	                    <button onclick="deleteClub(${c.clubNo})">삭 제</button>
                    </c:if>
                </div>
            </div>

            <!-- 소셜링 or 챌린지 -->
            <c:choose>
            	<c:when test="${c.clubType eq '소셜링'}">
            		<div class="club_type"><span>소셜링</span></div>
            	</c:when>
            	<c:when test="${c.clubType eq '챌린지'}">
            		<div class="club_type2"><span>챌린지</span></div>
            	</c:when>
            	<c:otherwise>
            	</c:otherwise>
            </c:choose>          
            
            <!-- 찜 -->
            <div class="club_picked" data-cno="${c.clubNo}" data-uno="${loginUser.userNo}"></div>

            <div class="club_title_info">
                <p align="center" style="color: rgb(90, 90, 90);"><i class="fa-solid fa-location-dot"></i> ${c.address} <i class="fa-solid fa-calendar-days"></i>  ${evDate}    <i class="fa-solid fa-user"></i>    ${memberList.size()}/${c.capacity}</p>
            </div>

            <!-- 모임 상세정보 -->
            <div class="club_detail_info">
                ${c.clubContent}
            </div>
            
            <!-- 멤버 소개-->
            <div class="club_member_info" >
                <div>
                    <p class="color_red">멤버 소개(${memberList.size()})</p>
                    <p>우리 반갑게 만나요</p>
                </div>
                <c:choose>
                	<c:when test="${memberList.size() ne 0}">
                		<c:forEach var="m" items="${memberList}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.index < 5}">
                                    <div class="club_members">
                                        <div class="club_profile_img"><img src="${pageContext.request.contextPath}${m.profileImg}" alt="프로필사진"></div>
                                        <div class="club_member_div">
                                            <div><b>${m.nickname}</b></div> 
                                            <div class="club_member_intro">${m.introduce}</div>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div id="hidden_club_members" class="club_members">
                                        <div class="club_profile_img"><img src="${pageContext.request.contextPath}${m.profileImg}" alt="프로필사진"></div>
                                        <div class="club_member_div">
                                            <div><b>${m.nickname}</b></div> 
                                            <div class="club_member_intro">${m.introduce}</div>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>    
                        
                			
                		</c:forEach>
                        <c:if test="${memberList.size() > 5}">
		                	<div class="club_more_member" style="margin-left: 275px;" onclick="showMoreMembers()">더보기 ></div>
		                </c:if>
                	</c:when>
                	<c:otherwise>
	                	<tr>
            				<td colspan="3" align="center">
            					<div class="empty_p_member">
            						<span>아직 참여자가 없습니다.</span>
            					</div>
            				</td>
            			</tr>
	                </c:otherwise>
                </c:choose>
                
            </div>

            <!-- 안내 사항 -->
            <div class="club_caution">
                <div>
                    <span class="color_red">안내사항</span><br>
                    <span>자세한 정보를 알려드릴게요</span>
                </div>
                <div>
                	<table class="club_info">
                		<tr>
                			<td><i class="fa-solid fa-folder-open"></i> </td>
                			<td> ${c.categoryName1} > ${c.categoryName2}</td>
                		</tr>
                		<tr>
                			<td><i class="fa-solid fa-user"></i> </td>
                			<td> 최대  ${c.capacity}명</td>
                		</tr>
                		<tr>
                			<td><i class="fa-solid fa-coins"></i> </td>
                			<td> ${c.cost}pt</td>
                		</tr>
                		<tr>
                			<td><i class="fa-solid fa-circle-info"></i></td>
                			<td> 참가비 정보 - ${c.costInfo}</td>
                		</tr>
                		<tr>
                			<td><i class="fa-solid fa-calendar-days"></i> </td>
                			<td> ${evDate}</td>
                		</tr>
                		<tr>
                			<td><i class="fa-solid fa-location-dot"></i> </td>
                			<td> ${c.address} (${c.addressDetail})</td>
                		</tr>
                	</table>
                </div>
            </div>
            <div class="club_address_center">
                <div id="club_address_btn" class="club_address" data-toggle="modal" data-target="#myModal" onclick="modalMap('${c.address}')">
                    <div>
                        <i class="fa-solid fa-map-location-dot fa-xl"></i>
                    </div>
                    <div class="club_warning">
                        <span>${c.address}</span><br>
                        <span>${c.addressDetail}</span>
                    </div>
                </div>
                <div class="club_address">
                    <div>
                        <i class="fa-solid fa-circle-info fa-xl"></i>
                    </div>
                    <div class="club_warning">
                    <span>개인 계좌 입금 유도, 개인 정보 요구, 모꼬지 멤버가 아닌 외부 인원 
                        초대 등 가이드를 위반하는 경우 모꼬지에게 신고해주세요!</span>
                    </div>
                </div>
            </div>
            <br>
            <div class="club_member_info" >
                <h3>리뷰(${reviewList.size()})</h3>
                <table id="review_table">
                	<c:choose>
                		<c:when test="${reviewList.size() ne 0}">
	                		<c:forEach var="cr" items="${reviewList}">
			                	<tr>
			                        <td style="padding-left: 5px;">${cr.nickname}</td>
			                        <td style="width: 75%; padding-left: 14px;">${cr.reviewContent}</td>
			                        <td style="padding-right: 5px;" align="right">${cr.modifyDate}</td>
			                        <!-- <td>X</td> -->
			                    </tr>
		                	</c:forEach>
                		</c:when>
	                	<c:otherwise>
	                		<tr>
            				<td colspan="3" align="center">
            					등록된 리뷰가 없습니다.
            				</td>
            			</tr>
	                	</c:otherwise>
	                </c:choose>
                </table>
            </div>
            <br>
            <div class="club_btns">
                    <button class="background_color_brown" onclick="history.back()">목록으로</button>
                    <c:forEach var="rq" items="${rqMemberList}">
					    <c:if test="${rq.userNo == loginUser.userNo}">
					        <c:set var="isUserFound" value="true" />
					    </c:if>
					</c:forEach>
					<c:choose>
                        <c:when test="${memberList.size() eq c.capacity}">
                            <div disabled>모집 완료</div>
                        </c:when>
						<c:when test="${c.status eq 'E'}">
							<div disabled>종료된 모임</div>
						</c:when>
						<c:when test="${c.status eq 'N'}">
							<div disabled>취소된 모임</div>
						</c:when>
					    <c:when test="${isUserFound}">
					        <div disabled>이미 신청한 모임</div>
					    </c:when>
                        <c:when test="${loginUser.userNo eq c.userNo}">
                            <button id="join_club_btn" class="background_color_green" value="${c.clubType}" onclick="finishClub(${c.clubNo})">모임 종료하기</button>
                        </c:when>
					    <c:otherwise>
					        <button id="join_club_btn" class="background_color_green" value="${loginUser.userNo}" onclick="joinClub(${c.clubNo})">참여 신청하기</button>
					    </c:otherwise>
					</c:choose>
                    
            </div>
        </div>
    </div>
    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog modal-lg">
        <div class="modal-content">
    
            <!-- Modal Header -->
            <div class="modal-header">
            <h4 class="modal-title">지도 보기</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
    
            <!-- Modal body -->
            <div class="modal-body">
                <div id="map" style="width:100%;height:500px;"></div>
            </div>
    
            <!-- Modal footer -->
            <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
            </div>
    
        </div>
        </div>
    </div>
</body>
</html>