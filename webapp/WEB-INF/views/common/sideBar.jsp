<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- 공용 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/sidebar.css">
</head>

<body>
    <div class="admin-sidebar">
        <div id="sidebar-mini">
            <!-- 메뉴바 -->
            <div id="sidebar">
                <div class="nano nanono">  
                    <div class="nano-content">
                        <div class="sidebar-scroll-panel sisidebar-scroll-panel">
                            <div class="margin">
                                <span class="mocozy">mo-cozy</span>
                            </div>
                            <!-- 메인 메뉴 -->
                            <ul id="main-menu" class="gui-controls">
                                <li>
                                    <a class="external-url" href="admin.ad">
                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>
                                        <span class="title title-controls">사이트 바로가기</span>
                                    </a>
                                </li>

                                <li class="spacer"></li>

                                <li class="top-menu">
                                    <div>
                                        <span> 사이트 관리 </span>
                                        <a href="${pageContext.request.contextPath}" class="shop-extend">
                                            <i class="db-shop"></i>
                                        </a>
                                    </div>
                                </li>

                                <!-- 1 -->
                                <li class="gui-folder">
                                    <a href="_blank" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>

                                        <span class="title title-controls">사이트 관리</span>

                                        <div class="gui-mini-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>
                                    </a>
                                    <ul>
                                        <li>
                                            <a href="adminClub.ad">
                                                <span class="title title-controls">모임</span>
                                            </a>
                                        </li>  
                                        <li>
                                            <a href="adminReview.ad">
                                                <span class="title title-controls">리뷰</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="adminPoint.ad">
                                                <span class="title title-controls">포인트</span>
                                            </a>
                                        </li>      
                                    </ul>
                                </li>

                                <!-- 2 -->
                                <li class="gui-folder">
                                    <a href="_blank" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>

                                        <span class="title title-controls">사용자 관리</span>

                                        <div class="gui-mini-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>
                                    </a>
                                    <ul>
                                        <li>
                                            <a href="adminUserlist.ad">
                                                <span class="title title-controls">사용자 목록</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="adminChat.ad">
                                                <span class="title title-controls">채팅 보내기</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="adminManager.ad">
                                                <span class="title title-controls">관리자</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>

                                <!-- 3 -->
                                <li class="gui-folder">
                                    <a href="_blank" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>

                                        <span class="title title-controls">컨텐츠 관리</span>

                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>
                                    </a>
                                    <ul>
                                        <li>
                                            <a href="adminNotice.ad">
                                                <span class="title title-controls">공지사항</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="adminComment.ad">
                                                <span class="title title-controls">댓글</span>
                                            </a>
                                        </li>
                                        <li>
                                            <!-- 임시 -->
                                            <a href="adminBlock.ad">
                                                <span class="title title-controls">신고 · 차단</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>

                                <!-- 4 -->
                                <li class="gui-folder">
                                    <a href="_blank" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>

                                        <span class="title title-controls">환경설정</span>

                                        <div class="gui-mini-icon">
                                            <svg style="border: 1px solid black; width: 24px; height: 24px;"><!-- 아이콘 --></svg>
                                        </div>
                                    </a>
                                    <ul>
                                        <li>
                                            <a href="adminTerms.ad">
                                                <span class="title title-controls">약관</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="nano-pane">
                        <div class="nano-slider nanono-slider"></div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>