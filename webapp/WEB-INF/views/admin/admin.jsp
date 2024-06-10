<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/admin.css">
</head>

<%@ include file="./sideBar.jsp"%>
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
                                <a class="clay-button black exit-btn" href="${pageContext.request.contextPath}">나가기</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </header>

            <div id="content" class="dashboard-main">

                <!-- 통계 -->
                <section class="section">
                    <div class="clearfix area-wrap">
                        <div class="section-body float-l">
                            <div class="dashboard-section-header dashboard-stats-header">
                                <div>
                                    <svg xmlns="http://www.w3.org/2000/svg" class="svgicon" fill="currentColor" class="bi bi-bar-chart-line" viewBox="0 0 16 16">
                                        <path d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1zm1 12h2V2h-2zm-3 0V7H7v7zm-5 0v-3H2v3z"/>
                                      </svg>
                                    <span>통계</span>
                                </div>
                            </div>

                            <div class="flex-box dashboard-stats">
                                <div class="ma-item col-md-6 col-sm-12 col-xs-12 stat-analytics-list">
                                    <div class="card">
                                        <div class="card-head">
                                            <header>기간별 분석</header>
                                            <a href="_blank" class="dashboard-card-anchor">더보기</a>
                                        </div>

                                        <div class="card-body no-padding border-top">
                                            <table class="table no-margin summary-table">
                                                <thead>
                                                    <tr>
                                                        <th class="text-13 text-left opacity-50">일자</th>
                                                        <th class="text-13 text-center opacity-50">가입수</th>
                                                        <th class="text-13 text-center opacity-50">포인트</th>
                                                        <th class="text-13 text-center opacity-50">방문자</th>
                                                        <th class="text-13 text-center opacity-50">가입</th>
                                                        <th class="text-13 text-center opacity-50">문의</th>
                                                        <th class="text-13 text-center opacity-50">후기</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <!-- 주단위 반복 -->
                                                    <tr class="today">
                                                        <td class="text-left">2024-06-02</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-06-01</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-05-31</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-05-30</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-05-29</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-05-28</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>

                                                    <!-- // 주단위 반복 -->
                                                    <tr>
                                                        <td class="text-left">2024-05-27</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0원</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>

                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>
                                                </tbody>

                                                <tfoot>
                                                    <tr>
                                                        <td class="text-left no-border">최근 7일 합계</td>
                                                        <td class="text-center no-border">0건</td>
                                                        <td class="text-center no-border">0원</td>
                                                        <td class="text-center no-border">0명</td>
                                                        <td class="text-center no-border">0명</td>
                                                        <td class="text-center no-border">0</td>
                                                        <td class="text-center no-border">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="text-left">이번달 합계</td>
                                                        <td class="text-center">0건</td>
                                                        <td class="text-center">0원</td>
                                                        <td class="text-center">0명</td>
                                                        <td class="text-center ">0명</td>
                                                        <td class="text-center">0</td>
                                                        <td class="text-center">0</td>
                                                    </tr>
                                                </tfoot>
                                            </table><!-- // 예약 또는 쇼핑 사용 -->
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- 컨텐츠 -->
                            <div class="dashboard-section-header">
                                <div>
                                    <svg xmlns="http://www.w3.org/2000/svg" class="svgicon" fill="currentColor" class="bi bi-paragraph" viewBox="0 0 16 16">
                                        <path d="M10.5 15a.5.5 0 0 1-.5-.5V2H9v12.5a.5.5 0 0 1-1 0V9H7a4 4 0 1 1 0-8h5.5a.5.5 0 0 1 0 1H11v12.5a.5.5 0 0 1-.5.5"/>
                                      </svg>
                                    <span>컨텐츠</span>
                                </div>
                            </div>

                            <div class="flex-box dashboard-section-row dashboard-contents-row">
                                <div class="ma-item col-md-6 col-sm-6 col-xs-12 answers-list shopping-review no-padding-left">
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

                                <div class="ma-item col-md-6 col-sm-6 col-xs-12 answers-list shopping-qna no-padding-left">
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

                                <div class="ma-item col-md-6 col-sm-6 col-xs-12 contents-list !tw-mb-0 no-padding">
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
                                                            <img style="border: 1px solid black; width: 50px; height: 50px; " src="_blank">
                                                        </div>
                                                        <div class="tile-text">
                                                            <div>
                                                                <span>[게시판 작성] 테스트</span>
                                                            </div>
                                                            <small class="text-12">
                                                                <span>관리자</span>
                                                                <span class="opacity-50 text-gray-bright margin-x-8">|</span>
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

                <div style="height: 40px;"></div>
                
                <div class="dashboard-right right-menu-fixed float-l no-margin-left">
                    <div class="card card-sm-padding">
                        <div class="card-head">
                            <header>관리자</header>
                            <a class="float-r text-13 opacity-50 force-padding no-padding-y" href="_blank">관리</a>
                        </div>
                        <div class="card-body no-padding-top">
                            <div class="admin-img-wrap clearfix">
                                <div class="float-l"> 
                                    <a class="inline-blocked" href="_blank">
                                        <!-- 프로필 이미지-->
                                        <img style="border: 1px solid black; border-radius: 100%; height: 50px; width: 50px;" src="_none">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="update-memo-list"></div>
        
                    <div class="card card-sm-padding" style="background: #fffbd5;">
                        <form id="add-memo">
                            <input type="hidden" name="write-token" value="none">
                            <input type="hidden" name="write-token_key" value="none">
                            <div class="card-body card-memo">
                                <div class="tabled holder full-width" style="margin-bottom: 5px;">
                                    <div class="table-cell vertical-middle memo-thumb">
                                        <!-- 프로필 이미지-->
                                        <img style="border: 1px solid black; border-radius: 100%; height: 50px; width: 50px;" src="_none">
                                    </div>
                                    <div class="table-cell vertical-middle">
                                        <div id="memo-writer" class="text-13 text-bold">관리자</div>
                                    </div>
                                </div>
        
                                <div class="memo-body">
                                    <textarea name="memo" id="memo" class="form-control margin-bottom-xl resize-vertical"
                                        rows="1" placeholder="관리자들과 공유할 메모를 남겨주세요"
                                        style="overflow: hidden; overflow-wrap: break-word; resize: none; height: 38px;">
                                    </textarea>
                                    <div>
                                        <a href="_blank" class="btn btn-xs btn-rounded btn-xs-padding btn-default-bright">저장</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

			</div>
            </div>
        </div>
</body>

</html>