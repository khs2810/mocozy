<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- /WEB-INF/views/myPage/profileModal.jsp -->
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
                    <span class="nickname">${loginUser.nickname}</span>
                    <span> 님</span>
                </div>
                <div class="m-manner">
                    <img src="${pageContext.request.contextPath}/resources/koo/upfile/myPage_img/로고-떡떡떡.png" class="m-logo-area">
                    <div class="m-manner-area">
                        <span>매너 점수</span>
                        <div class="m-manner-score-area">
                            <div class="m-score-range">
                                <p>0</p>
                                <p>100</p>
                            </div>
                            <progress id="progress" value="36.5" min="0" max="100"></progress>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Modal footer -->
            <div class="profile-modal-bottom">
                <h6 style="font-size: 20px; font-weight: 600; margin: 10px 30px;">자기소개</h6>
                <textarea class="m-introduction">${m.introduce}</textarea>
            </div>
            
        </div>
    </div>
</div>

</body>
</html>