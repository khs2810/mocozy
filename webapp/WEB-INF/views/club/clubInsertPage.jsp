<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>모임 신청 내역 페이지</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/clubInsertPage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/clubInsertPage.js"></script>
</head>
<body>
	<%@ include file="../common/Header.jsp"%>
    <form id="contentBox">
        <h2 style="margin-left: 10px;">모임 등록</h2>
        <hr style="background: lightgray; height: 1px; border: 0;">
        <div id="content">
            <div id="pictureInputBox">
                <h3 style="margin-left: 10px; margin-bottom: 0;">대표사진</h3>
                <hr style="margin-bottom: 0px;">
                <img src="${pageContext.request.contextPath}/resources/jun/img/fileImg.png" id="fileImg" onclick="chooseFile(1)">
                <input type="file" style="display: none;" name="attachment" id="file1" required onchange="loadImg(this, 1)">
            </div>
            <div id="clubInputBox">
                <div id="manyInputBox">
                    <div id="inputHead">
                        <h3 style="margin-left: 10px; margin-bottom: 0;">모임 정보</h3>
                        <div id="clubTypes">
                            <input type="radio" name="clubType">소셜링
                            <input type="radio" name="clubType" style="margin-left: 10px;">챌린지
                        </div>
                    </div>
                    <hr style="margin-bottom: 0px;">
                    <table id="inputTable">
                        <tr class="row1">
                            <td class="column1">
                                &nbsp;<b>장소</b><br>
                                <input type="text" placeholder="도로명주소 API" name="address" id="address">
                                <input type="radio" name="online">온라인
                                <input type="radio" name="online" style="margin-left: 10px;">오프라인<br>
                                <input type="text" name="detailAddress" id="detailAddress" placeholder="자세한 주소">
                            </td>
                            <td class="column2">
                                &nbsp;<b>카테고리</b><br>
                                <select name="category" id="category">
                                    <option value="" hidden>카테고리를 선택해주세요</option>
                                    <option value="">카테고리1</option>
                                    <option value="">카테고리2</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="row2">
                            <td class="column1">
                                &nbsp;<b>날짜 & 시간</b><br>
                                <input type="datetime-local" name="datetime" id="datetime">
                            </td>
                            <td class="column2">
                                &nbsp;<b>참가비</b><br>
                                <input type="number" name="cost" id="cost" placeholder="인당 참가비를 설정해주세요">
                            </td>
                        </tr>
                        <tr class="row3">
                            <td class="column1">
                                &nbsp;<b>비용정보</b><br>
                                <input type="text" name="costInfo" id="costInfo" placeholder="비용 정보를 입력해주세요">
                            </td>
                            <td class="column2">
                                &nbsp;<b>인원수</b><br>
                                <input type="number" name="maxPeople" id="maxPeople" placeholder="최대 인원수를 설정해주세요">
                            </td>
                        </tr>
                        <tr class="row4">
                            <td colspan="2">
                                &nbsp;<b>제목</b><br>
                                <input type="text" name="title" id="title" placeholder="모임 글의 제목을 작성해주세요">
                            </td>
                        </tr>
                        <tr class="row5">
                            <td colspan="2">
                                &nbsp;<b>게스트에게 하고 싶은 질문</b>
                                <sub class="letter_count" id="question_letter_count">0/300</sub>
                                <textarea name="question" id="question" maxlength="300" placeholder="가입 신청자에게 묻고 싶은 질문을 작성해주세요(300자)&#13;&#10;&#13;&#10;※ 전화번호, 카카오톡 아이디, 신청 폼 작성 요구 등 과도한 개인정보를 요구하는 경우, 가이드 위반으로 신고 대상자가 될 수 있습니다."></textarea>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="detailInputBox">
                    <h3 style="margin-left: 15px; margin-bottom: 0;">글 상세</h3>
                    <hr>
                    <textarea id="summernote" name="content"></textarea>
                </div>
                <div id="buttons">
                    <button type="reset" id="resetBtn">초기화</button>
                    <button type="submit" id="submitBtn">등록하기</button>
                </div>
            </div>
        </div>
    </form><br>
</body>
</html>