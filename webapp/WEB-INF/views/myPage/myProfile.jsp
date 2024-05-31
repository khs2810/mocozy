<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 내 프로필</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jun/css/challengeManagePage.css">
	<script src="${pageContext.request.contextPath}/resources/jun/js/challengeManagePage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyPage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/changePwd.js"></script>
    <script src="${pageContext.request.contextPath}/resources/koo/js/myPage_js/MyProfile.js"></script>
    <script src="${pageContext.request.contextPath}/resources/jun/js/clubInsertPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/MyPage.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/koo/css/myPage_css/myProfile.css">

    <style>
        .none_pass{
            color: red;
        }
        .pass{
            color: green;
        }
        
    </style>

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <%@ include file="myPageCommon.jsp" %>
        
        <!-- 메인 컨텐츠 부 전체-->
        <div class="main-content">
            <!-- 메인컨텐츠 타이틀 -->
            <div class="title">
                <h1>내 프로필</h1>
                <!-- <h3>부제목</h3> -->

                <div class="binbox"></div>

                <!-- 셀렉버튼 -->
                <!-- <div class="title-select">
                    <select name="" id="">
                        <option value="">진행중</option>
                        <option value="">종료됨</option>
                    </select>
                </div>  -->
            </div>
            <hr>

            <!-- 컨텐츠 내용 -->
            <!-- 프로필 정보 -->
            <form action="update.me" method="post" enctype="multipart/form-data">
                <input type="hidden" name="userNo" value="${ loginUser.userNo}">
                <input type="hidden" name="userId" value="${ loginUser.userId}">
                <input type="hidden" name="userPwd" value="${ loginUser.userPwd}">
                <div class="main-object">
                    <div class="content-title">
                        <h5>닉네임(별명)</h5>
                    </div>
                    <div class="box">
                        <input type="text" name="nickname" class="textbox" value="${loginUser.nickname}">
                    </div>
                </div>
                <hr>

                <div class="main-object">
                    <div class="content-title">
                        <h5>프로필 이미지</h5>
                    </div>
                    <div>
                        <!-- 프로필이미지 -->
                        <div class="profile-box1" style="">
                            <img class="profile-img" src="${pageContext.request.contextPath}${loginUser.profileImg}" id="fileImg" onclick="chooseFile(1)" alt="">
                            <input type="file" style="display: none;" name="upfile" id="file1" required onchange="loadImg(this, 1, '${pageContext.request.contextPath}')">
                        </div>
                    </div>
                </div>
                <hr>

                <!-- 이메일(로그인 ID) -->
                <div class="main-object">
                    <div class="content-title">
                        <h5>이메일(로그인 ID)</h5>
                    </div>
                    <p>${loginUser.userId}</p>
                </div>
                <hr>

                <!-- 비밀번호 -->
                <div class="main-object">
                    <div class="content-title">
                        <h5>비밀번호</h5>
                    </div>
                    <div class="box">
                        <input type="password" class="textbox" value="${loginUser.userPwd }"id="check_pwd" onblur="checkPass()">
                    </div>

                    <!-- 비밀번호 변경 modal창 -->
                    <div class="change">
                        <!-- Button to Open the Modal -->
                        <input type="button" class="change-btn box1" data-toggle="modal" data-target="#myModal" value="비밀번호 변경하기">
                    </div>

                </div>
                <hr>

                <!-- 전화번호 -->
                <div class="main-object">
                    <div class="content-title">
                        <h5>전화번호</h5>
                    </div>
                    <div class="box">
                        <input type="text" name="phone" class="textbox" value="${loginUser.phone}">
                    </div>
                    <div class="change">
                        <!-- Button to Open the Modal -->
                        <input type="button" class="change-btn box1" data-toggle="modal" data-target="#myModal1"  value="인증 요청">
                    </div>
                    
                </div>
                <hr>

                <div class="main-object">
                    <div class="content-title">
                        <h5>한줄 자기소개</h5>
                    </div>
                    <div id="introduce">
                        <div>
                            <textarea name="introduce" onkeyup="counter();" class="form-control textbox" id="jagisogae" style="width: 500px; height: 50px;">${loginUser.introduce}</textarea>
                            <span id = "count"></span>
                        </div>
                    </div>
                </div>

                <div class="edit-user">
                    <button type="submit">수정</button>
                    <button type="button" href="logout.me">로그아웃</button>
                    <button type="button" data-toggle="modal" data-target="#myModal3">회원 탈퇴</button>
                </div>
            </form>

        <!-- 비번 변경 모달창 -->
        <!-- The Modal -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h2 class="modal-title">비밀번호 변경하기</h2>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <form action="updatePwd.me" method="post" id="changePasswordForm">
                        <div class="modal-body">
                            <h5>기존 비밀번호</h5>
                            <div class="content-box">
                                <input type="hidden" id="userId" name="userId" value="${loginUser.userId}">
                                <input type="password" id="currentPwd" name="currentPwd" onkeyup="checkPwd(this)"placeholder="기존 비밀번호를 입력해 주세요." required>
                            </div>

                            <br>
                            <hr>
                            <br>

                            <h5>새 비밀번호</h5>
                            <div class="content-box">
                                <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="새 비밀번호를 입력해주세요" required>
                            </div>
                            <br>

                            <h5>새 비밀번호 확인</h5>
                            <div class="content-box">
                                <input type="password" class="form-control" id="checkPwd" onblur="checkPass()" placeholder="새 비밀번호를 다시 한 번 입력해주세요" required>
                                <span id="pwd_review"></span><br>
                                <div id="checkResult" style="font-size:0.7em; display:none;"></div>
                            </div>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="submit" class="change-btn2" id="submitBtn" onclick="change_pass();">변경하기</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- 전화번호 인증 모달창 -->
        <!-- The Modal -->
        <div class="modal fade" id="myModal1">
            <div class="modal-dialog">
                <div class="modal-content">
            
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h2 class="modal-title">전화번호 인증</h2>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
            
                    <!-- Modal body -->
                    <div class="modal-body">
                        <h5>전화번호 인증하기기기</h5>
                    </div>
            
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="change-btn2">인증 하기</button>
                    </div>
            
                </div>
            </div>
        </div>

        <!-- 회원탈퇴 모달창1 -->
        <!-- The Modal -->
        <div class="modal fade" id="myModal3">
            <div class="modal-dialog">
            <div class="modal-content">
        
                <!-- Modal Header -->
                <div class="modal-header">
                <h2 class="modal-title">회원 탈퇴하기</h2>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
        
                <!-- Modal body -->
                <div class="modal-body">
                    <h5>정말 탈퇴하시겠어요?</h5>
                    <br>
                    <div class="signout-caution">
                        <p>지금 탈퇴하시면 참가 예정이거나, 참가중인 모임을 이용할 수 없게 되요.</p>
                        <p>지금 탈퇴하시면 보유중인 매너 점수가 사라져요.</p>
                        <p>지금 탈퇴하시면 채팅 이력이 모두 사라져요.</p>
                        <p>추후에 동일 계정으로 가입해도 복구되지 않아요.</p>
                    </div>
                    <br>

                    <div class="checked">
                        <label for="agree" class="chk_box">
                            <input type="checkbox" id="agree" checked="checked" />
                            <span class="on"></span>
                            <p>상기 유의 사항을 확인 하였으며, 탈퇴 신청에 동의 합니다.</p>
                        </label>
                    </div>
                </div>
        
                <!-- 탈퇴신청 Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="change-btn2" data-toggle="modal" data-target="#myModal4">탈퇴 신청하기</button>
                </div>
        
            </div>
            </div>
        </div>

        <!-- 회원탈퇴 모달창2 -->
            <!-- The Modal -->
            <div class="modal fade" id="myModal4">
                <div class="modal-dialog">
                <div class="modal-content">
            
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h2 class="modal-title">회원 탈퇴하기</h2>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
            
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div>
                            <h5>${loginUser.nickname} 님 <br>
                                마지막 기회에요. <br>
                                정말로 탈퇴하시겠어요?</h5>
                        </div>
                        <p id="last-caution">비밀번호를 입력하고 확인을 누르면 탈퇴신청이 완료됩니다.</p>
                        <br>
                        <div class="main-object">
                            <div class="content-title">
                                <h6>이메일 (로그인 ID)</h6>
                            </div>
                            <div>
                                ${loginUser.userId}
                            </div>
                        </div>
                        <div class="main-object height">
                            <div class="content-title">
                                <h6>비밀번호</h6>
                            </div>
                            <div class="box">
                                <input type="password" class="textbox" id="delete-password" >
                                <span id="pwd_review"></span>
                            </div>
                        </div>

                    </div>
            
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="change-btn2" id="delete-account-btn">탈 퇴</button>
                    </div>
            
                </div>
                </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 프로필 모달 -->
    <%@ include file="../member/profileModal.jsp" %>
    

    
</body>
</html>