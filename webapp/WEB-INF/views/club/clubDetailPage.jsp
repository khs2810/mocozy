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

    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <div id="wrap_main">
        <div id="wrap_club">
            <!-- 제목 프로필 -->
            <div id="club_main_img">
                <img src="${pageContext.request.contextPath}/${c.thumbnailImg}" alt="메인이미지">
            </div>
            <div class="club_title_profile" align="center">
                <div class="club_profile_img"><img src="${pageContext.request.contextPath}${c.thumbnailImg}" alt="프로필 사진"></div>
                <div align="center">${c.nickname}</div>
            </div>
            <div class="club_title">
                <div class="club_modify_btn"></div>
                <div>
                    <h3 id="club_title">${c.clubTitle }</h2>
                </div>
                <div class="club_modify_btn"><button>수 정</button><button>삭 제</button></div>
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
            <!-- <div class="club_picked"><i class="fa-solid fa-heart" style="color: red;"></i></div> -->
            <div class="club_picked"><i class="fa-regular fa-heart" style="color: red;"></i></div>
            <div class="club_title_info">
                <p align="center" style="color: rgb(90, 90, 90);"><i class="fa-solid fa-location-dot"></i> 관악구 · 5.4(토) 오후 6:00      18/20</p>
            </div>

            <!-- 모임 상세정보 -->
            <div class="club_detail_info">
                ${c.clubContent}
            </div>
            
            <!-- 멤버 소개-->
            <div class="club_member_info" >
                <div>
                    <p class="color_red">멤버 소개</p>
                    <p>우리 반갑게 만나요</p>
                </div>
                <div class="club_members">
                    <div class="club_profile_img"><img src="${pageContext.request.contextPath}/resources/teo/img/profile_img.jpg" alt="프로필사진"></div>
                    <div class="club_member_div">
                        <div>이름</div>
                        <div class="club_member_intro">한줄 자기소개</div>
                    </div>
                </div>
                <div class="club_members">
                    <div class="club_profile_img"><img src="${pageContext.request.contextPath}/resources/teo/img/profile_img.jpg" alt="프로필사진"></div>
                    <div class="club_member_div">
                        <div>이름</div>
                        <div>한줄 자기소개</div>
                    </div>
                </div>
                <div class="club_more_member" style="margin-left: 275px;">더보기 ></div>
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
                			<td> 최대  ${c.capacity}</td>
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
                <div class="club_address">
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
                    <button class="background_color_brown">목록으로</button>
                    <button class="background_color_green" onclick="location.href='confirm.cl?cno=${c.clubNo}'">참여 신청하기</button>
            </div>
        </div>
    </div>
</body>
</html>