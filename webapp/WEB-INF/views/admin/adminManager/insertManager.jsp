<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- 공용 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- include libraries(jQuery, bootstrap) -->
    <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
        type="text/css" rel="stylesheet">

    <!-- include summernote css/js -->
    <link
        href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
        type="text/css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminManager_css/userInsert.css">
</head>

<%@ include file="../sideBar.jsp"%>
<body>
    <div class="menubar-hoverable header-fixed menubar-pin sidebar-mini">
        <div id="base">
            <div id="basecontent">
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
                <div class="card style-transparent card-top no-tab userlist-card">
                    <div class="card-head">
                        <header>
                            <a href="_blank">
                                <svg style="height: 16px; width: 16px; border: 1px solid black;"><!-- 아이콘 --></svg>
                                리스트로 돌아가기
                            </a>
                        </header>
                        <div class="tools">
                            <div>
                                <div class="btn-group">
                                    <a href="_blank" class="btn btn-icon-toggle dropdown-toggle">
                                        <svg style="height: 16px; width: 16px; border: 1px solid black;"><!-- 아이콘 --></svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="section-body">
                    <div class="tab-pane">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-head">
                                        <header>회원 정보</header>
                                    </div>
                                    <div class="card-body border-top">
                                        <div class="profile-image text-center margin-bottom-xxl">
                                            <div id="fileupload-profile-img">
                                                <img src="_blank" id="profile-img" class="img-circle" style="width: 72px; height: 72px; border: 1px solid black; border-radius: 100%;"><!-- 프로필 이미지-->
                                                <div class="-dropdown-menu dropdown-menu-wrapper">
                                                    <button type="button" class="-btn-dropdown-menu icon-btn">
                                                        <svg style="height: 16px; width: 16px; border: 1px solid black;"><!-- 아이콘 --></svg>
                                                    </button>
                                                </div>
                                            </div>
                                            <h3 class="text-15"></h3>
                                        </div>
                                        
                                        <div class="profile-info">
                                            <form id="dof" method="post" class="form-horizontal form-validate">
                                                <input type="hidden" name="userid">
                                                <input type="hidden" name="photo">
                                                <!--계정-->
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label text-right">
                                                        계정
                                                        <span class="text-danger">(필수)</span>
                                                    </label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control">
                                                        <div class="form-control-line"></div>
                                                    </div>
                                                </div>

                                                <!--비밀번호-->
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label text-right">
                                                        비밀번호
                                                        <span class="text-danger">(필수)</span>
                                                    </label>
                                                    <div class="col-md-9">
                                                        <input type="text" class="form-control" placeholder="비밀번호">
                                                        <div class="form-control-line"></div>
                                                    </div>
                                                </div>

                                                <div class="type-form-wrap">
                                                    <!--닉네임-->
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label text-right">
                                                            닉네임
                                                            <span class="text-danger">(필수)</span>
                                                        </label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control">
                                                            <div class="form-control-line"></div>
                                                        </div>
                                                    </div>

                                                    <!--소셜 로그인-->
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label text-right">
                                                            소셜 로그인
                                                        </label>
                                                        <div class="col-md-9 tw-pt5">
                                                            연결된 소셜 로그인이 없습니다.
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                <a class="btn btn-primary">추가</a> 
                </div>
    


                </section><!--섹션 끝 -->
            </div>
        </div>
    </div>
</body>
</html>