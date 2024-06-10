<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- 공용 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
        rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- include libraries(jQuery, bootstrap) -->
    <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
        type="text/css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link
        href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
        type="text/css" rel="stylesheet">
    <script
        src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!-- -->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub_css/InsertClub.css">
<script src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminClub_js/InsertClub.js"></script>
</head>

<%@ include file="../sideBar.jsp"%>
<body>
    <div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
        <div id="base">
            <header class="top-header" id="header">
                <div class="headerbar">
                    <div class="headerbar-left">
                        <ul class="header-nav header-nav-options">
                            <li class="header-nav-brand">
                                <div class="brand-holder">
                                    <span class="location-text">
                                        <a href="_blank" class="site-name">편집 및 추가</a>
                                    </span>
                                </div>
                            </li>
                        </ul>
                    </div>

                    <div class="headerbar-right">
                        <ul class="header-nav header-nav-options -option-list">
                            <li>
                                <a class="btn btn-default-bright" href="_blank">취소</a>
                            </li>
                            <li>
                                <a class="btn btn-primary disabled" href="_blank">저장</a>
                            </li>
                        </ul><!--end .header-nav-options -->
                    </div><!--끝 #header-navbar-collapse -->
                    <!--끝 #header-navbar-collapse -->
                </div>
            </header>

            <!-- BEGIN CONTENT-->
            <div id="content">
                <section>
                    <div class="section-body">
                        <form id="prod-add" method="post" class="form form-validate" >
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="row margin-bottom-xxl flexed sm-flex-direction-column">
                                        <!-- 이미지 추가 -->
                                        <div class="col-md-6">
                                            <div class="card full-height">
                                                <div class="card-head">
                                                    <header>대표사진</header>
                                                </div>
                                                <div id="prod-image-dropzone2">
                                                    <div class="card-body">
                                                        <div id="prod-image-dropzone">
                                                            <div class="text-center text-xl text-default-light empty-img-box">
                                                                <div class="prod-image-upload inline-blocked">
                                                                    <svg style="width: 16px; height: 16px; border: 1px solid black;"><!-- 아이콘 --></svg>
                                                                    <input type="file" id="prod-image-upload" name="files[]" class="shop-img-up ico-active">
                                                                </div>
                                                            </div>
                                                            <p class="text-center text-default-light" style="margin-top: 15px;">
                                                                이미지를 여기로 드래그 <br>
                                                                750 x 750px / JPG 권장
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        
                                        <!-- 글 상세 -->
                                        <div class="card">
                                            <div class="card full-height">
                                                <div class="card-body">
                                                    <div class="form-group">
                                                        <label class="control-label">글 상세</label>
                                                        <div>
                                                            <input type="text"
                                                                class="form-control prod-title-fixed-top inline-blocked"
                                                                name="name-u20240516664558215af61" maxlength="200" placeholder="상세설명을 입력해주세요.">
                                                        </div>
                                                    </div>

                                                    <div class="form-group no-margin">
                                                        <label class="control-label" style="position: static; margin-top: -12px; display: block;">
                                                            요약 설명. 모임 상세정보 상단에 출력됩니다. 필수 입력.
                                                        </label>
                                                        <!-- 써머노트 추가 -->
                                                        <div class="summernote-div">
                                                            <textarea id="summernote" name="noticeContent" required></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <!-- 상세내용 추가 -->
                                    <div class="card">
                                        <textarea style="display: none;"></textarea>
                                        <textarea style="display: none;"></textarea>
                                        <div class="card-body">
                                            <div class="form-group margin-bottom-40 sm">
                                                <label class="control-label label-add">상세내용 추가</label>
                                                <!-- 써머노트 추가 -->
                                                <div class="summernote-div">
                                                    <textarea id="summernote" name="noticeContent" class="summernote" required></textarea>
                                                </div>
                                            </div>

                                            <!-- 모임 정보 -->
                                            <div class="form-group">
                                                <label class="control-label">모임 정보 </label>
                                                <div class="select-form padding-top-10 sm">
                                                    <div class="radio-inline radio-styled">
                                                        <label>
                                                            <input type="radio" id="use-mobile-prod-content" name="use-mobile-prod-content">
                                                            <span>소셜링</span>
                                                        </label>
                                                    </div>
                                                    <div class="radio-inline radio-styled">
                                                        <label>
                                                            <input type="radio" id="use-mobile-prod-content" name="use-mobile-prod-content">
                                                            <span>챌린지</span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div style="margin-bottom: 30px;"></div>

                                        <!-- 모임 제목 -->	
                                        <div class="card">
                                            <div class="card-head">
                                                <header>모임 제목</header>
                                            </div>

                                            <div class="card-body no-padding-top">
                                                <div class="form-group">
                                                    <div class="row">
                                                        <div class="col-md-3 m-margin-bottom-xl">
                                                            <input type="text" placeholder="모임 글의 제목을 입력해주세요." class="form-control prod-title-fixed-top inline-blocked">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">	
                                                    <label class="control-label">장소</label>
                                                    <div class="select-form padding-top-10 sm">
                                                        <div class="radio-inline radio-styled">
                                                            <label>
                                                                <input type="radio" id="use-mobile-prod-content" name="use-mobile-prod-content">
                                                                <span>온라인</span>
                                                            </label>
                                                        </div>
                                                        <div class="radio-inline radio-styled">
                                                            <label>
                                                                <input type="radio" id="use-mobile-prod-content" name="use-mobile-prod-content">
                                                                <span>오프라인</span>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="row">
                                                        <div class="col-md-3 m-margin-bottom-xl">
                                                            <label class="control-label">도로명 주소</label>
                                                            <input type="text" placeholder="도로명 주소 API" class="form-control prod-title-fixed-top inline-blocked">
                                                        </div>

                                                        <div class="col-md-3 m-margin-bottom-xl">
                                                            <label class="control-label">상세주소</label>
                                                            <input type="text" placeholder="상세주소를 입력해주세요" class="form-control prod-title-fixed-top inline-blocked">
                                                        </div>

                                                        <div class="col-md-3 m-margin-bottom-xl">
                                                            <label class="control-label">비용정보</label>
                                                            <input type="text" placeholder="비용 정보를 입력해주세요" class="form-control prod-title-fixed-top inline-blocked">
                                                        </div>
                                                    </div>    
                                                </div>
                                            </div>
                                        </div>                                    
                                    
                                    <div style="margin-bottom: 30px;"></div>

                                    <!-- 카테고리 -->
                                    <div class="card">
                                        <div class="card-head">
                                            <header>카테고리</header>
                                        </div>
                                        <div class="card-body no-padding-top">
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-3 m-margin-bottom-xl">
                                                        <label class="control-label">상위 카테고리 선택</label>
                                                        <select id="stock-use" name="stock-use" class="form-control -select-stock-use">
                                                            <option>미래발전</option>
                                                            <option>연애 · 사랑</option>
                                                        </select>
                                                    </div>

                                                    <div class="col-md-3 m-margin-bottom-xl">
                                                        <label class="control-label">하위 카테고리 선택</label>
                                                        <select id="stock-use" name="stock-use" class="form-control -select-stock-use">
                                                            <option>미래발전</option>
                                                            <option>연애 · 사랑</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>									

                                    <div style="margin-bottom: 30px;"></div>

                                    <!-- 모임 설정 -->	
                                    <div class="card">
                                        <div class="card-head">
                                            <header>모임 설정</header>
                                        </div>
                                        <div class="card-body no-padding-top">
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-3 m-margin-bottom-xl">
                                                        <label class="control-label">참가비</label>
                                                        <input type="text" placeholder="인당 참가비를 설정해주세요" class="form-control prod-title-fixed-top inline-blocked">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body no-padding-top">
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-3 m-margin-bottom-xl">
                                                        <label class="control-label">인원수</label>
                                                        <input type="text" placeholder="최대 인원수를 설정해주세요" class="form-control prod-title-fixed-top inline-blocked">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-body no-padding-top">
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-3 m-margin-bottom-xl">
                                                        <label class="control-label">비용정보</label>
                                                        <input type="text" placeholder="비용 정보를 입력해주세요" class="form-control prod-title-fixed-top inline-blocked">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>	

                                    <div style="height: 30px;"></div>
                                    
                                    <!-- 게스트에게 하고 싶은 질문 -->
                                    <div class="card">
                                        <textarea style="display: none;"></textarea>
                                        <textarea style="display: none;"></textarea>
                                        <div class="card-body">
                                            <div class="form-group margin-bottom-40 sm">
                                                <label class="control-label">게스트에게 하고 싶은 질문</label>
                                                <textarea class="textarea-insert" placeholder="질문을 작성해주세요."></textarea>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </form>
                    </div><!--섹션 끝 -->
                    <div><a class="btn btn-primary disabled">저장</a></div>
                </section>
            </div><!--end #content-->
            <!-- END CONTENT -->
        </div>
</body>
</html>