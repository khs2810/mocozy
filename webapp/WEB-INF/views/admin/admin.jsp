<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="ko">

        <head>
            <!-- 공용 -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
                rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            <!-- include libraries(jQuery, bootstrap) -->
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" type="text/css"
                rel="stylesheet">
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

            <!-- include summernote css/js -->
            <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" type="text/css"
                rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
            <!-- -->

            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub_css/adminClub.css">
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/admin.css">
        </head>

        <%@ include file="./sideBar.jsp" %>

            <body>
                <div class="menubar-hoverable header-fixed menubar-pin">
                    <div id="base">
                        <div id="basecontent">
                            <header class="top-header">
                                <div class="headerbar">
                                    <div class="headerbar-left">
                                        <div>
                                            <a href="_blank" class="site-name">mo-cozy</a>
                                        </div>
                                    </div>
                                    <div class="headerbar-right">
                                        <ul class="header-nav header-nav-options">
                                            <li>
                                                <a class="clay-button black exit-btn"
                                                    href="${pageContext.request.contextPath}">나가기</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </header>

                            <div id="content" class="dashboard-main">

                                <!-- 신규 모임 -->
                                <section class="section">
                                    <div class="clearfix area-wrap">
                                        <div class="section-body float-l">
                                            <div class="dashboard-section-header dashboard-stats-header">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="svgicon"
                                                        fill="currentColor" class="bi bi-bar-chart-line"
                                                        viewBox="0 0 16 16">
                                                        <path
                                                            d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1zm1 12h2V2h-2zm-3 0V7H7v7zm-5 0v-3H2v3z" />
                                                    </svg>
                                                    <span>신규 모임</span>
                                                </div>
                                                <div>
                                                    <p style="margin: 0px;">더보기</p>
                                                </div>
                                            </div>

                                            <!-- 신규 모임-->
                                            <section class="no-padding-bottom section">
                                                <div style="margin-bottom: 30px;">
                                                    <div class="row">
                                                        <div>
                                                            <div class="row">    
                                                                <div>
                                                                    <div class="card" style="border-radius: 10px;">
                                                                        <div class="table-responsive shop-table check" id="prod-list">
                                                                            <table class="table no-margin">
                                                                                <thead class="subject -prodListHeaderDeselected" id="prod-list-header-deselected">
                                                                                    <tr style="justify-content: left;">
                                                                                        <th class="check checkhead"></th>
                                                                                        <th class="no">No</th>
                                                                                        <th class="image" style="width: 260px;">클럽명</th>
                                                                                        <th class="title"></th>
                                                                                        <th class="group" style="width: 80px;">카테고리</th>
                                                                                        <th class="state">상태</th>
                                                                                        <th class="r-date">등록일</th>
                                                                                    </tr>
                                                                                </thead>
                        
                                                                                <tbody id="prod-list-body" class="-prod-list-body ui-sortable">
                                                                                        <tr class="content -prodListItem" style="justify-content: left;">
                                                                                            <td class="checkhead">
                                                                                                <div class="drag -showcase-handle ui-sortable-handle"></div>
                                                                                                <div class="checkbox checkbox-styled no-margin">
                                                                                                    <label>
                                                                                                        <input type="checkbox" class="-prodListCheck">
                                                                                                        <span></span>
                                                                                                    </label>
                                                                                                </div>
                                                                                            </td>
                            
                                                                                            <td class="no text-12">4</td>
                            
                                                                                            <td class="image">
                                                                                                <a href="_blank">
                                                                                                    <img src="_blank" width="49" height="49" class="item-thumb">
                                                                                                </a>
                                                                                            </td>
                            
                                                                                            <td class="title">
                                                                                                <div>
                                                                                                    <div class="item-tit inline-blocked">
                                                                                                        <a href="_blank">언뇨링</a>
                                                                                                        <a href="_blank" class="im-icon im-ico-new-tab vertical-middle tab-icon" style="margin-left: 4px;"></a>
                                                                                                    </div>
                                                                                                    <span class="btn-sm text-gray-bright"></span>
                                                                                                </div>
                                                                                            </td>
                            
                                                                                            <td class="group" style="width: 150px;">미래발전</td>
                                                                                    
                                                                                            <td class="state on-click">
                                                                                                <a data-toggle="dropdown" style="margin-right: -1px;">
                                                                                                    <span>진행중</span>
                                                                                                </a>
                                                                                                <ul class="dropdown-menu" style="top: 50px;">
                                                                                                    <li id="mixpanel-bo-shopping-item-list-status-sale">
                                                                                                        <a href="_blank">진행중</a>
                                                                                                    </li>
                                                                                                    <li id="mixpanel-bo-shopping-item-list-status-soldout">
                                                                                                        <a href="_blank">종료</a>
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </td>
                            
                                                                                            <td class="r-date text-12">2024-04-01</td>
                                                                                        </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                
                                                                <div class="col-md-12">
                                                                    <nav class="text-center order-paging" id="prod-list-paging"></nav>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section><!--섹션 끝 -->


                                            <!-- 컨텐츠 -->
                                            <div class="dashboard-section-header">
                                                <div>
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="svgicon"
                                                        fill="currentColor" class="bi bi-paragraph" viewBox="0 0 16 16">
                                                        <path
                                                            d="M10.5 15a.5.5 0 0 1-.5-.5V2H9v12.5a.5.5 0 0 1-1 0V9H7a4 4 0 1 1 0-8h5.5a.5.5 0 0 1 0 1H11v12.5a.5.5 0 0 1-.5.5" />
                                                    </svg>
                                                    <span>컨텐츠</span>
                                                </div>
                                            </div>

                                            <div class="flex-box dashboard-section-row dashboard-contents-row">
                                                <div
                                                    class="ma-item col-md-6 col-sm-6 col-xs-12 answers-list shopping-review no-padding-left">
                                                    <div class="card flex-card no-padding-left">
                                                        <!-- // 예약 또는 쇼핑 사용 -->
                                                        <div class="card-head">
                                                            <header>신규 이용자</header>
                                                            <a href="_blank" class="dashboard-card-anchor">더보기</a>
                                                        </div>
                                                        <div class="card-body border-top no-data-card-body">
                                                            <ul class="list list-preview">
                                                                <li class="tile">
                                                                    <div class="no-data-container">
                                                                        <img src="_blank"> <!-- 프로필 이미지-->
                                                                        <p>신규 이용자가 없어요</p>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div
                                                    class="ma-item col-md-6 col-sm-6 col-xs-12 answers-list shopping-qna no-padding-left">
                                                    <div class="card flex-card">
                                                        <div class="card-head">
                                                            <header> 신규 문의</header>
                                                            <a href="_blank" class="dashboard-card-anchor">더보기</a>
                                                        </div>
                                                        <div class="card-body border-top no-data-card-body">
                                                            <ul class=" list list-preview">
                                                                <li class="tile">
                                                                    <div class="no-data-container">
                                                                        <img src="_blank"> <!-- 프로필 이미지-->
                                                                        <p>1:1 채팅 문의가 없어요</p>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div
                                                    class="ma-item col-md-6 col-sm-6 col-xs-12 contents-list !tw-mb-0 no-padding">
                                                    <div class="card flex-card"><!-- // 예약 또는 쇼핑 사용 -->
                                                        <div class="card-head">
                                                            <header>신규 공지사항</header>
                                                            <a href="_blank" class="dashboard-card-anchor">더보기</a>
                                                        </div>
                                                        <div class="card-body border-top">
                                                            <ul class="list list-preview">
                                                                <li class="tile">
                                                                    <a class="tile-content contents-item" href="_blank">
                                                                        <div class="tile-icon">
                                                                            <!-- 프로필 이미지-->
                                                                            <img style="border: 1px solid black; width: 50px; height: 50px; "
                                                                                src="_blank">
                                                                        </div>
                                                                        <div class="tile-text">
                                                                            <div>
                                                                                <span>[게시판 작성] 테스트</span>
                                                                            </div>
                                                                            <small class="text-12">
                                                                                <span>관리자</span>
                                                                                <span
                                                                                    class="opacity-50 text-gray-bright margin-x-8">|</span>
                                                                                <span>2024-05-21 19:00</span>
                                                                            </small>
                                                                        </div>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                </section>
                            </div>

                        </div>
                    </div>
                </div>
            </body>

        </html>