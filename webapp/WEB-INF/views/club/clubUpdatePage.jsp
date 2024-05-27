<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>모임 수정 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/clubInsertPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/clubUpdatePage.js"></script>
    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
    <form id="contentBox" method="post" action="update.cl?cno=${c.clubNo}" enctype="multipart/form-data">
        <h2 style="margin-left: 10px;">모임 등록</h2>
        <hr style="background: lightgray; height: 1px; border: 0;">
        <div id="content">
            <div id="pictureInputBox">
                <h3 style="margin-left: 10px; margin-bottom: 0;">대표사진</h3>
                <hr style="margin-bottom: 0px;">
                <img src="${pageContext.request.contextPath}/${c.thumbnailImg}" id="fileImg" onclick="chooseFile(1)">
                <input type="file" style="display: none;" name="upfile" id="file1" onchange="loadImg(this, 1, '${pageContext.request.contextPath}')">
            </div>
            <div id="clubInputBox">
                <div id="manyInputBox">
                    <div id="inputHead">
                        <h3 style="margin-left: 10px; margin-bottom: 0;">모임 정보</h3>
                        <div id="clubTypes">
                        	<c:choose>
							    <c:when test="${c.clubType eq '소셜링'}">
							        <input type="radio" name="clubType" value="소셜링" checked>소셜링
							        <input type="radio" name="clubType" value="챌린지" style="margin-left: 10px;">챌린지
							    </c:when>
							    <c:otherwise>
							        <input type="radio" name="clubType" value="소셜링">소셜링
							        <input type="radio" name="clubType" value="챌린지" style="margin-left: 10px;" checked>챌린지
							    </c:otherwise>
							</c:choose>
                        </div>
                    </div>
                    <hr style="margin-bottom: 0px;">
                    <table id="inputTable">
                        <tr class="row1">
                            <td class="column1">
                                &nbsp;<b style="margin-right: 20px;">장소</b>
                                <c:choose>
                                	<c:when test="${c.online eq '온라인'}">
                                		<input type="radio" name="online" value="온라인" checked>온라인
                                		<input type="radio" name="online" value="오프라인" style="margin-left: 10px;">오프라인
                                	</c:when>
                                	<c:otherwise>
                                		<input type="radio" name="online" value="온라인">온라인
                                		<input type="radio" name="online" value="오프라인" style="margin-left: 10px;" checked>오프라인
                                	</c:otherwise>
                                </c:choose>
                                
                                <br>
                                <input type="text" placeholder="도로명주소 API" name="address" id="address" readonly value="${c.address}">
                                <i class="fa-solid fa-magnifying-glass" onclick="searchAd()" style="cursor: pointer;"></i>
                                <input type="text" name="addressDetail" id="detailAddress" placeholder="자세한 주소" value="${c.addressDetail}">
                            </td>
                            <td class="column2">
                                &nbsp;<b>카테고리</b><br>
                                <label for="categoryName1">
	                                <select name="categoryName1" id="category1" onclick="showSubcategories()">
	                                    <option value="" hidden>상위 카테고리 선택</option>
	                                    <option value="문화생활" ${c.categoryName1 eq '문화생활' ? 'selected' : ''}>문화생활</option>
	                                    <option value="미래발전" ${c.categoryName1 eq '미래발전' ? 'selected' : ''}>미래발전</option>
	                                    <option value="스포츠" ${c.categoryName1 eq '스포츠' ? 'selected' : ''}>스포츠</option>
	                                    <option value="취미" ${c.categoryName1 eq '취미' ? 'selected' : ''}>취미</option>
	                                    <option value="연애" ${c.categoryName1 eq '연애' ? 'selected' : ''}>연애</option>
	                                </select>
                                </label>
                                <label for="categoryName2">
	                                <select name="categoryName2" class="category2" id="category2_1" style="display: none;">
	                                    <option value="" hidden>하위 카테고리 선택</option>
	                                    <option value="문화, 예술" ${c.categoryName2 eq '문화, 예술' ? 'selected' : ''}>문화, 예술</option>
	                                    <option value="푸드, 드링크" ${c.categoryName2 eq '푸드, 드링크' ? 'selected' : ''}>푸드, 드링크</option>
	                                </select>
	                                <select name="categoryName2" class="category2" id="category2_2" style="display: none;">
	                                    <option value="" hidden>하위 카테고리 선택</option>
	                                    <option value="자기계발" ${c.categoryName2 eq '자기계발' ? 'selected' : ''}>자기계발</option>
	                                    <option value="재테크" ${c.categoryName2 eq '재테크' ? 'selected' : ''}>재테크</option>
	                                    <option value="외국어" ${c.categoryName2 eq '외국어' ? 'selected' : ''}>외국어</option>
	                                </select>
	                                <select name="categoryName2" class="category2" id="category2_3" style="display: none;">
	                                    <option value="" hidden>하위 카테고리 선택</option>
	                                    <option value="액티비티" ${c.categoryName2 eq '액티비티' ? 'selected' : ''}>액티비티</option>
	                                    <option value="여행, 동행" ${c.categoryName2 eq '여행, 동행' ? 'selected' : ''}>여행, 동행</option>
	                                </select>
	                                <select name="categoryName2" class="category2" id="category2_4" style="display: none;">
	                                    <option value="" hidden>하위 카테고리 선택</option>
	                                    <option value="취미" ${c.categoryName2 eq '취미' ? 'selected' : ''}>취미</option>
	                                    <option value="파티, 게임" ${c.categoryName2 eq '파티, 게임' ? 'selected' : ''}>파티, 게임</option>
	                                </select>
	                                <select name="categoryName2" class="category2" id="category2_5" disabled>
	                                    <option value="" ${c.categoryName1 eq '연애' ? 'selected' : ''} hidden>하위 카테고리 없음</option>
	                                </select>
                                </label>
                            </td>
                        </tr>
                        <tr class="row2">
                            <td class="column1">
                                &nbsp;<b>날짜 & 시간</b><br>
                                <input type="datetime-local" name="eventDateStr" id="datetime" value="${c.eventDate}">
                                <!-- <input type="date" name="eventDate" id="eventDate">
                                <input type="time" name="eventTime" id="eventTime"> -->
                            </td>
                            <td class="column2">
                                &nbsp;<b>참가비</b><br>
                                <input type="number" name="cost" id="cost" placeholder="인당 참가비를 설정해주세요" value="${c.cost}">
                            </td>
                        </tr>
                        <tr class="row3">
                            <td class="column1">
                                &nbsp;<b>비용정보</b><br>
                                <input type="text" name="costInfo" id="costInfo" placeholder="비용 정보를 입력해주세요" value="${c.costInfo}">
                            </td>
                            <td class="column2">
                                &nbsp;<b>인원수</b><br>
                                <input type="number" name="capacity" id="maxPeople" placeholder="최대 인원수를 설정해주세요" value="${c.capacity}">
                            </td>
                        </tr>
                        <tr class="row4">
                            <td colspan="2">
                                &nbsp;<b>제목</b><br>
                                <input type="text" name="clubTitle" id="title" placeholder="모임 글의 제목을 작성해주세요" value="${c.clubTitle}">
                            </td>
                        </tr>
                        <tr class="row5">
                            <td colspan="2">
                                &nbsp;<b>게스트에게 하고 싶은 질문</b>
                                <sub class="letter_count" id="question_letter_count">0/300</sub>
                                <textarea name="question" id="question" maxlength="300" placeholder="가입 신청자에게 묻고 싶은 질문을 작성해주세요(300자)&#13;&#10;&#13;&#10;※ 전화번호, 카카오톡 아이디, 신청 폼 작성 요구 등 과도한 개인정보를 요구하는 경우, 가이드 위반으로 신고 대상자가 될 수 있습니다.">${c.question}</textarea>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div id="detailInputBox">
            <h3 style="margin-left: 15px; margin-bottom: 0;">글 상세</h3>
            <hr>
            <textarea id="summernote" name="clubContent">${c.clubContent}</textarea>
        </div>
        <div id="buttons">
            <button type="reset" id="resetBtn">초기화</button>
            <button type="submit" id="submitBtn">수정하기</button>
        </div>
        <input type="hidden" name="userNo" id="userNo" value="2">
        <input type="hidden" name="clubNo" id="clubNo" value="${c.clubNo}">
    </form><br>
</body>
</html>