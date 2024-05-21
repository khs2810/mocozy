<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage - 내 프로필</title>

    <!-- modal, css -->
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}./basic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}./MyProfile.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!--Get your code at fontawesome.com-->
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/MyPage.js"></script>
    <script src="${pageContext.request.contextPath}/MyProfile.js"></script>

</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <div class="MyPage-body">
        <!-- 마이페이지 공용 코드 -->
        <div class="mypage-main">
            <!-- 유저 프로필 섹션 -->
            <div class="user-profile">
                <div class="profile-box">
                    <button class="btn-style">
                        <div class="profile-box1">
                            <!-- 프로필사진 -->
                            <img type="button" class="profile-img" src="${pageContext.request.contextPath}/img/profile.jpg" alt="">
                        </div>
                    </button>
                    <!-- 닉네임 및 계정이메일 -->
                    <div class="account">
                        <h5>떡꼬치대마왕 님</h5>
                        <h6>mocozygood@gmail.com</h6>

                        <!-- 포인트 -->
                        <div class="account point">
                            100,000pt
                            <button class="btn-style">충전</button>
                        </div>
                    </div>
                    
                </div>

                <!-- 매너점수 -->
                <div class="manner">
                    <img src="${pageContext.request.contextPath}/img/로고-떡떡떡.png" alt="">
                    <h6>매너점수</h6>
                    <div class="gauge">
                        <progress id="progress" value="36.5" min="0" max="100"></progress>
                    </div>
                </div>
            </div>
                
            <!-- 메뉴 네비 -->
            <div class="mypage-navi">
                <nav>
                    <ul id="main_menu">
                        <li><a href="${pageContext.request.contextPath}/MyPage.jsp">마이페이지</a></li>

                        <li><a href="${pageContext.request.contextPath}/MyProfile.jsp">내 프로필</a></li>

                        <li><a href="">소셜링 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/MySocial.jsp" class="snd_title">내가 만든 소셜링</a></li>
                                <li><a href="${pageContext.request.contextPath}/goSocial.jsp" class="snd_title">참여 중인 소셜링</a></li>
                            </ul>
                        </li>

                        <li><a href="" onclick="">챌린지 관리</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/MyChallenge.jsp" class="snd_title">내가 만든 챌린지</a></li>
                                <li><a href="${pageContext.request.contextPath}/GoChallenge.jsp" class="snd_title">참여 중인 챌린지</a></li>
                            </ul>
                        </li>

                        <li><a href="">포인트</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="" class="snd_title">포인트 관리</a></li>
                                <li><a href="" class="snd_title">충전 내역</a></li>
                                <li><a href="" class="snd_title">사용 내역</a></li>
                            </ul>
                        </li>

                        <li><a href="">찜</a>
                            <ul class="snd_menu sub_menu">
                                <li><a href="${pageContext.request.contextPath}/dibs_social.jsp" class="snd_title">소셜링</a></li>
                                <li><a href="${pageContext.request.contextPath}/dibs_challenge.jsp" class="snd_title">챌린지</a></li>
                            </ul>
                        </li>

                        <li><a href="">리뷰</a></li>

                        <li><a href="">채팅기록</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        
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
            <div class="main-object">
                <div class="content-title">
                    <h5>닉네임(별명)</h5>
                </div>
                <div class="box">
                    <input type="text" class="textbox" value="떡꼬치대마왕">
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
                        <img class="profile-img" src="./img/profile.jpg" alt="">
                    </div>
                </div>
            </div>
            <hr>

            <!-- 이메일(로그인 ID) -->
            <div class="main-object">
                <div class="content-title">
                    <h5>이메일(로그인 ID)</h5>
                </div>
                <p>mocozygood@gmail.com</p>
            </div>
            <hr>

            <!-- 비밀번호 -->
            <div class="main-object">
                <div class="content-title">
                    <h5>비밀번호</h5>
                </div>
                <div class="box">
                    <input type="password" class="textbox" value="비밀번호 입니다"id="check_pwd" onblur="checkPass()">
                    <span id="pwd_review"></span>
                </div>

                <!-- 비밀번호 변경 modal창 -->
                <div class="change">
                    <!-- Button to Open the Modal -->
                    <input type="button" class="change-btn box1" data-toggle="modal" data-target="#myModal" value="비밀번호 변경하기">
                </div>

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
                        <div class="modal-body">
                            <h5>기존 비밀번호</h5>
                            <div class="content-box">
                                <input type="password" placeholder="기존 비밀번호를 입력해 주세요.">
                            </div>
                            <br>
                            <hr>
                            <br>

                            <h5>새 비밀번호</h5>
                            <div class="content-box">
                                <input type="password" placeholder="새 비밀번호를 입력해주세요 (8자 이상)">
                            </div>
                            <br>

                            <h5>새 비밀번호 확인</h5>
                            <div class="content-box">
                                <input type="password" placeholder="새 비밀번호를 다시 한 번 입력해주세요">
                            </div>
                        </div>
                
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="change-btn2">변경하기</button>
                        </div>
                
                    </div>
                    </div>
                </div>
            </div>
            <hr>

            <!-- 전화번호 -->
            <div class="main-object">
                <div class="content-title">
                    <h5>전화번호</h5>
                </div>
                <div class="box">
                    <input type="text" class="textbox" value="010-8282-9999">
                </div>
                <div class="change">
                    <!-- Button to Open the Modal -->
                    <input type="button" class="change-btn box1" data-toggle="modal" data-target="#myModal1"  value="인증 요청">
                </div>
                
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
            </div>
            <hr>

            <div class="main-object">
                <div class="content-title">
                    <h5>한줄 자기소개</h5>
                </div>
                <div id="introduce">
                    <div>
                        <textarea onkeyup="counter();" class="form-control textbox"  id="jagisogae" style="width: 500px; height: 50px;">내 최애 떡꼬치. 근데 누가 뺐어갔어...</textarea>
                        <span id = "count"></span>
                    </div>
                </div>
            </div>

            <div class="edit-user">
                <a href="">수정</a>
                <a href="">로그아웃</a>
                <a type="button" data-toggle="modal" data-target="#myModal3">회원 탈퇴</a>

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
                                <h5>(떡꼬치대마왕) 님 <br>
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
                                    mocozygood@gmail.com
                                </div>
                            </div>
                            <div class="main-object height">
                                <div class="content-title">
                                    <h6>비밀번호</h6>
                                </div>
                                <div class="box">
                                    <input type="password" class="textbox" value="비밀번호 입니다"id="check_pwd" onblur="checkPass()">
                                    <span id="pwd_review"></span>
                                </div>
                            </div>

                        </div>
                
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="change-btn2">인증 하기</button>
                        </div>
                
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        const checkbox1 = document.querySelector('[data-id="checkbox-1"]');

        checkbox1.addEventListener('click', function() {
              checkboxes.forEach(function(checkbox) {
                if (checkbox.classList.contains('bi-square')) {
                  checkbox.classList.remove('bi-square');
                  checkbox.classList.add('bi-check-square-fill');
                } else {
                  checkbox.classList.remove('bi-check-square-fill');
                  checkbox.classList.add('bi-square');
                }
              });
            });

            checkboxes.forEach(function(checkbox) {
              checkbox.addEventListener('click', function() {
                if (checkbox === checkbox1) {
                  checkboxes.forEach(function(cb) {
                    if (checkbox1.classList.contains('bi-check-square-fill')) {
                      cb.classList.remove('bi-square');
                      cb.classList.add('bi-check-square-fill');
                    } else {
                      cb.classList.remove('bi-check-square-fill');
                      cb.classList.add('bi-square');
                    }
                  });
                } else {
                  if (checkbox.classList.contains('bi-square')) {
                    checkbox.classList.remove('bi-square');
                    checkbox.classList.add('bi-check-square-fill');
                  } else {
                    checkbox.classList.remove('bi-check-square-fill');
                    checkbox.classList.add('bi-square');
                  }
                }
                });
            });
    </script>
</body>
</html>