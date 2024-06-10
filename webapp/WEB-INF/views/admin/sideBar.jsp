<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- 공용 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/sideBar.css">
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
                                <span class="mocozy"><a href="admin.ad">mo-cozy</a></span>
                            </div>
                            <!-- 메인 메뉴 -->
                            <ul id="main-menu" class="gui-controls">
                                <li>
                                    <a class="external-url" href="${pageContext.request.contextPath}">
                                        <div class="gui-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-door-open" viewBox="0 0 16 16">
                                                <path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1"/>
                                                <path d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 1 .43-.495l7-1a.5.5 0 0 1 .398.117M11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5M4 1.934V15h6V1.077z"/>
                                              </svg>
                                        </div>
                                        <span class="title title-controls">사이트 바로가기</span>
                                    </a>
                                </li>

                                <li class="spacer"></li>

                                <li class="top-menu">
                                    <div>
                                        <span> 사이트 관리 </span>
                                    </div>
                                </li>

                                <!-- 1 -->
                                <li class="gui-folder">
                                    <a href="adminClub.ad" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-flag" viewBox="0 0 16 16">
                                                <path d="M14.778.085A.5.5 0 0 1 15 .5V8a.5.5 0 0 1-.314.464L14.5 8l.186.464-.003.001-.006.003-.023.009a12 12 0 0 1-.397.15c-.264.095-.631.223-1.047.35-.816.252-1.879.523-2.71.523-.847 0-1.548-.28-2.158-.525l-.028-.01C7.68 8.71 7.14 8.5 6.5 8.5c-.7 0-1.638.23-2.437.477A20 20 0 0 0 3 9.342V15.5a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 1 0v.282c.226-.079.496-.17.79-.26C4.606.272 5.67 0 6.5 0c.84 0 1.524.277 2.121.519l.043.018C9.286.788 9.828 1 10.5 1c.7 0 1.638-.23 2.437-.477a20 20 0 0 0 1.349-.476l.019-.007.004-.002h.001M14 1.221c-.22.078-.48.167-.766.255-.81.252-1.872.523-2.734.523-.886 0-1.592-.286-2.203-.534l-.008-.003C7.662 1.21 7.139 1 6.5 1c-.669 0-1.606.229-2.415.478A21 21 0 0 0 3 1.845v6.433c.22-.078.48-.167.766-.255C4.576 7.77 5.638 7.5 6.5 7.5c.847 0 1.548.28 2.158.525l.028.01C9.32 8.29 9.86 8.5 10.5 8.5c.668 0 1.606-.229 2.415-.478A21 21 0 0 0 14 7.655V1.222z"/>
                                              </svg>
                                        </div>

                                        <span class="title title-controls">전체 모임 관리</span>
                                    </a>
                                </li>

                                <!-- 2 -->
                                <li class="gui-folder">
                                    <a href="adminUserlist.ad" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                                <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-file-person" viewBox="0 0 16 16">
                                                    <path d="M12 1a1 1 0 0 1 1 1v10.755S12 11 8 11s-5 1.755-5 1.755V2a1 1 0 0 1 1-1zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                                                    <path d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                                </svg>
                                        </div>

                                        <span class="title title-controls">사용자 관리</span>
                                    </a>
                                </li>

                                <!-- 3 -->
                                <li class="gui-folder">
                                    <a href="adminNotice.ad" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
                                                <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2M8 1.918l-.797.161A4 4 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4 4 0 0 0-3.203-3.92zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5 5 0 0 1 13 6c0 .88.32 4.2 1.22 6"/>
                                              </svg>
                                        </div>

                                        <span class="title title-controls">공지사항 관리</span>
                                    </a>
                                </li>

                                <!-- 4 -->
                                <li class="gui-folder">
                                    <a href="adminManager.ad" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-exclude" viewBox="0 0 16 16">
                                                <path d="M0 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v2h2a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-2H2a2 2 0 0 1-2-2zm12 2H5a1 1 0 0 0-1 1v7h7a1 1 0 0 0 1-1z"/>
                                              </svg>
                                        </div>

                                        <span class="title title-controls">운영진 관리</span>
                                    </a>
                                </li>

                                <!-- 5 -->
                                <li class="gui-folder">
                                    <a href="adminChat.ad" class="sidebar-nav-menu">
                                        <div class="gui-icon">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-chat-square-quote" viewBox="0 0 16 16">
                                                <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                                                <path d="M7.066 4.76A1.665 1.665 0 0 0 4 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112zm4 0A1.665 1.665 0 0 0 8 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112z"/>
                                              </svg>
                                        </div>

                                        <span class="title title-controls">전체 채팅 관리</span>
                                    </a>
                                </li>

                               <!-- 6 -->
                               <li class="gui-folder">
                                <a href="adminPoint.ad" class="sidebar-nav-menu">
                                    <div class="gui-icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" fill="currentColor" class="bi bi-piggy-bank" viewBox="0 0 16 16">
                                            <path d="M5 6.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0m1.138-1.496A6.6 6.6 0 0 1 7.964 4.5c.666 0 1.303.097 1.893.273a.5.5 0 0 0 .286-.958A7.6 7.6 0 0 0 7.964 3.5c-.734 0-1.441.103-2.102.292a.5.5 0 1 0 .276.962"/>
                                            <path fill-rule="evenodd" d="M7.964 1.527c-2.977 0-5.571 1.704-6.32 4.125h-.55A1 1 0 0 0 .11 6.824l.254 1.46a1.5 1.5 0 0 0 1.478 1.243h.263c.3.513.688.978 1.145 1.382l-.729 2.477a.5.5 0 0 0 .48.641h2a.5.5 0 0 0 .471-.332l.482-1.351c.635.173 1.31.267 2.011.267.707 0 1.388-.095 2.028-.272l.543 1.372a.5.5 0 0 0 .465.316h2a.5.5 0 0 0 .478-.645l-.761-2.506C13.81 9.895 14.5 8.559 14.5 7.069q0-.218-.02-.431c.261-.11.508-.266.705-.444.315.306.815.306.815-.417 0 .223-.5.223-.461-.026a1 1 0 0 0 .09-.255.7.7 0 0 0-.202-.645.58.58 0 0 0-.707-.098.74.74 0 0 0-.375.562c-.024.243.082.48.32.654a2 2 0 0 1-.259.153c-.534-2.664-3.284-4.595-6.442-4.595M2.516 6.26c.455-2.066 2.667-3.733 5.448-3.733 3.146 0 5.536 2.114 5.536 4.542 0 1.254-.624 2.41-1.67 3.248a.5.5 0 0 0-.165.535l.66 2.175h-.985l-.59-1.487a.5.5 0 0 0-.629-.288c-.661.23-1.39.359-2.157.359a6.6 6.6 0 0 1-2.157-.359.5.5 0 0 0-.635.304l-.525 1.471h-.979l.633-2.15a.5.5 0 0 0-.17-.534 4.65 4.65 0 0 1-1.284-1.541.5.5 0 0 0-.446-.275h-.56a.5.5 0 0 1-.492-.414l-.254-1.46h.933a.5.5 0 0 0 .488-.393m12.621-.857a.6.6 0 0 1-.098.21l-.044-.025c-.146-.09-.157-.175-.152-.223a.24.24 0 0 1 .117-.173c.049-.027.08-.021.113.012a.2.2 0 0 1 .064.199"/>
                                          </svg>
                                    </div>

                                    <span class="title title-controls">포인트 관리</span>
                                </a>
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