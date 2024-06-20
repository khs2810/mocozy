<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<!-- 공용 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminStyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminClub_css/adminClub.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/admin.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/jo/css/admin_css/adminCommon_css/adminExchange.css">
<script
	src="${pageContext.request.contextPath}/resources/jo/js/admin_js/adminCommon_js/adminExchange.js"></script>
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
								<a href="javascript:void(0);" class="site-name">mo-cozy</a>
							</div>
						</div>
						<div class="headerbar-right">
							<ul class="header-nav header-nav-options">
								<li><a class="clay-button black exit-btn"
									href="${pageContext.request.contextPath}">나가기</a></li>
							</ul>
						</div>
					</div>
				</header>

				<div id="content" class="dashboard-main">

					<section class="section">
						<div class="clearfix area-wrap">
							<div class="section-body float-l">

								<div class="I4v0Kc wlkW8 PZPZlf">
									<div class="nRbRnb" id="knowledge-currency__updatable-data-column">
										<div class="b1hJbf">
											<div class="vk_sh c8Zgcf B682Df">
												<div class="vLqKYe">
													<span>1</span>
													<span>대한민국 원</span>
													=
												</div>
												<div class="w5HbFd">
												</div>
											</div>
											<div class="dDoNo ikb4Bb gsrt">
												<span class="DFlfde SwHCTb">0.00072</span>
												<span class="MWvIVe nGP2Tb">미국
													달러</span>
											</div>
										</div>
										<div class="k0Rg6d hqAUc">
											<span>6월 19일 오후 7:07 UTC ·</span>
											<span class="NXHf6d">면책조항</span>
										</div>
										<div class="ePzRBb">
											<div class="wLNyTe">
												<div class="vLqKYe egcvbb q0WxUd">
													<input class="lWzCpb ZEB7Fb" placeholder="1">
													<div class="xNzW0d">
														<div class="aURkK"></div>
														<select class="zuzy3c l84FKc">
															<option>
																CFP
																프랑
															</option>
															<option>
																가나
																세디
															</option>
															<option>
																가이아나
																달러
															</option>
															<option>
																감비아
																달라시
															</option>
															<option>
																과테말라
																케찰
															</option>
															<option>
																기니
																프랑
															</option>
															<option>
																나미비아
																달러
															</option>
															<option>
																나이지리아
																나이라
															</option>
															<option>
																남아프리카
																공화국
																랜드
															</option>
															<option>
																네덜란드령
																안틸레스
																휠던
															</option>
															<option>
																네팔
																루피
															</option>
															<option>
																노르웨이
																크로네
															</option>
															<option>
																뉴질랜드
																달러
															</option>
															<option>
																니카라과
																코르도바
															</option>
															<option>
																대한민국
																원
															</option>
															<option>
																덴마크
																크로네
															</option>
															<option>
																도미니카
																페소
															</option>
															<option>
																동카리브
																달러
															</option>
															<option>
																라오스
																킵
															</option>
															<option>
																라이베리아
																달러
															</option>
															<option>
																러시아
																루블
															</option>
															<option>
																레바논
																파운드
															</option>
															<option>
																레소토
																로티
															</option>
															<option>
																루마니아
																레우
															</option>
															<option>
																르완다
																프랑
															</option>
															<option>
																리비아
																디나르
															</option>
															<option>
																마다가스카르
																아리아리
															</option>
															<option>
																마카오
																파타카
															</option>
															<option>
																마케도니아
																데나르
															</option>
															<option>
																말라위
																콰차
															</option>
															<option>
																말레이시아
																링깃
															</option>
															<option>
																멕시코
																페소
															</option>
															<option>
																모로코
																디르함
															</option>
															<option>
																모리셔스
																루피
															</option>
															<option>
																모리타니
																우기야
															</option>
															<option>
																모잠비크
																메티칼
															</option>
															<option>
																몰도바
																레우
															</option>
															<option>
																몰디브
																루피야
															</option>
															<option>
																미국
																달러
															</option>
															<option>
																미얀마
																짯
															</option>
															<option>
																바레인
																디나르
															</option>
															<option>
																바베이도스
																달러
															</option>
															<option>
																바하마
																달러
															</option>
															<option>
																방글라데시
																타카
															</option>
															<option>
																버뮤다
																달러
															</option>
															<option>
																베네수엘라
																볼리바르
															</option>
															<option>
																베트남
																동
															</option>
															<option>
																벨라루스
																루블
															</option>
															<option>
																벨리즈
																달러
															</option>
															<option>
																보스니아
																헤르체고비나
																태환
																마르카
															</option>
															<option>
																보츠와나
																풀라
															</option>
															<option>
																볼리비아
																볼리비아노
															</option>
															<option>
																부룬디
																프랑
															</option>
															<option>
																부탄
																눌트럼
															</option>
															<option>
																불가리아
																레프
															</option>
															<option>
																브라질
																헤알
															</option>
															<option>
																브루나이
																달러
															</option>
															<option>
																사우디아라비아
																리얄
															</option>
															<option>
																서아프리카
																CFA
																프랑
															</option>
															<option>
																세르비아
																디나르
															</option>
															<option>
																세이셸
																루피
															</option>
															<option>
																소말리아
																실링
															</option>
															<option>
																솔로몬
																제도
																달러
															</option>
															<option>
																수단
																파운드
															</option>
															<option>
																수리남
																달러
															</option>
															<option>
																스리랑카
																루피
															</option>
															<option>
																스와질란드
																릴랑게니
															</option>
															<option>
																스웨덴
																크로나
															</option>
															<option>
																스위스
																프랑
															</option>
															<option>
																시에라리온
																리온
															</option>
															<option>
																신
																타이완
																달러
															</option>
															<option>
																싱가포르
																달러
															</option>
															<option>
																아랍에미리트
																디르함
															</option>
															<option>
																아루바
																플로린
															</option>
															<option>
																아르메니아
																드람
															</option>
															<option>
																아르헨티나
																페소
															</option>
															<option>
																아이슬란드
																크로나
															</option>
															<option>
																아이티
																구르드
															</option>
															<option>
																아제르바이잔
																마나트
															</option>
															<option>
																아프가니스탄
																아프가니
															</option>
															<option>
																알바니아
																레크
															</option>
															<option>
																알제리
																디나르
															</option>
															<option>
																앙골라
																콴자
															</option>
															<option>
																에티오피아
																비르
															</option>
															<option>
																엘살바도르
																콜론
															</option>
															<option>
																예멘
																리알
															</option>
															<option>
																오만
																리알
															</option>
															<option>
																오스트레일리아
																달러
															</option>
															<option>
																온두라스
																렘피라
															</option>
															<option>
																요르단
																디나르
															</option>
															<option>
																우간다
																실링
															</option>
															<option>
																우루과이
																페소
															</option>
															<option>
																우즈베키스탄
																숨
															</option>
															<option>
																우크라이나
																흐리우냐
															</option>
															<option>
																유로
															</option>
															<option>
																이라크
																디나르
															</option>
															<option>
																이란
																리알
															</option>
															<option>
																이스라엘
																신
																셰켈
															</option>
															<option>
																이집트
																파운드
															</option>
															<option>
																인도
																루피
															</option>
															<option>
																인도네시아
																루피아
															</option>
															<option>
																일본
																엔
															</option>
															<option>
																자메이카
																달러
															</option>
															<option>
																잠비아
																콰차
															</option>
															<option>
																조지아
																라리
															</option>
															<option>
																중국
																위안화
															</option>
															<option>
																중국
																위안화(역외)
															</option>
															<option>
																중앙아프리카
																CFA
																프랑
															</option>
															<option>
																지부티
																프랑
															</option>
															<option>
																체코
																코루나
															</option>
															<option>
																칠레
																(UF)
															</option>
															<option>
																칠레
																페소
															</option>
															<option>
																카보베르데
																이스쿠두
															</option>
															<option>
																카자흐스탄
																텡게
															</option>
															<option>
																카타르
																리얄
															</option>
															<option>
																캄보디아
																리엘
															</option>
															<option>
																캐나다
																달러
															</option>
															<option>
																케냐
																실링
															</option>
															<option>
																케이맨
																제도
																달러
															</option>
															<option>
																코모로
																프랑
															</option>
															<option>
																코스타리카
																콜론
															</option>
															<option>
																콜롬비아
																페소
															</option>
															<option>
																콩고
																프랑
															</option>
															<option>
																쿠바
																페소
															</option>
															<option>
																쿠웨이트
																디나르
															</option>
															<option>
																키르기스스탄
																솜
															</option>
															<option>
																타지키스탄
																소모니
															</option>
															<option>
																탄자니아
																실링
															</option>
															<option>
																태국
																밧
															</option>
															<option>
																터키
																리라
															</option>
															<option>
																통가
																팡가
															</option>
															<option>
																투르크메니스탄
																마나트
															</option>
															<option>
																튀니지
																디나르
															</option>
															<option>
																트리니다드
																토바고
																달러
															</option>
															<option>
																파나마
																발보아
															</option>
															<option>
																파라과이
																과라니
															</option>
															<option>
																파운드
																스털링
															</option>
															<option>
																파키스탄
																루피
															</option>
															<option>
																파푸아뉴기니
																키나
															</option>
															<option>
																페루
																솔
															</option>
															<option>
																폴란드
																즈워티
															</option>
															<option>
																피지
																달러
															</option>
															<option>
																필리핀
																페소
															</option>
															<option>
																헝가리
																포린트
															</option>
															<option>
																홍콩
																달러
															</option>
														</select>
														<span class="sBsFoc">대한민국 원</span>
													</div>
												</div>
												<div class="MWvIVe egcvbb">
													<input class="lWzCpb a61j6" type="number" placeholder="0.00072">
													<div class="xNzW0d">
														<div class="aURkK"></div>
														<select class="zuzy3c NKvwhd">
															<option>
																CFP
																프랑
															</option>
															<option>
																가나
																세디
															</option>
															<option>
																가이아나
																달러
															</option>
															<option>
																감비아
																달라시
															</option>
															<option>
																과테말라
																케찰
															</option>
															<option>
																기니
																프랑
															</option>
															<option>
																나미비아
																달러
															</option>
															<option>
																나이지리아
																나이라
															</option>
															<option>
																남아프리카
																공화국
																랜드
															</option>
															<option>
																네덜란드령
																안틸레스
																휠던
															</option>
															<option>
																네팔
																루피
															</option>
															<option>
																노르웨이
																크로네
															</option>
															<option>
																뉴질랜드
																달러
															</option>
															<option>
																니카라과
																코르도바
															</option>
															<option>
																대한민국
																원
															</option>
															<option>
																덴마크
																크로네
															</option>
															<option>
																도미니카
																페소
															</option>
															<option>
																동카리브
																달러
															</option>
															<option>
																라오스
																킵
															</option>
															<option>
																라이베리아
																달러
															</option>
															<option>
																러시아
																루블
															</option>
															<option>
																레바논
																파운드
															</option>
															<option>
																레소토
																로티
															</option>
															<option>
																루마니아
																레우
															</option>
															<option>
																르완다
																프랑
															</option>
															<option>
																리비아
																디나르
															</option>
															<option>
																마다가스카르
																아리아리
															</option>
															<option>
																마카오
																파타카
															</option>
															<option>
																마케도니아
																데나르
															</option>
															<option>
																말라위
																콰차
															</option>
															<option>
																말레이시아
																링깃
															</option>
															<option>
																멕시코
																페소
															</option>
															<option>
																모로코
																디르함
															</option>
															<option>
																모리셔스
																루피
															</option>
															<option>
																모리타니
																우기야
															</option>
															<option>
																모잠비크
																메티칼
															</option>
															<option>
																몰도바
																레우
															</option>
															<option>
																몰디브
																루피야
															</option>
															<option>
																미국
																달러
															</option>
															<option>
																미얀마
																짯
															</option>
															<option>
																바레인
																디나르
															</option>
															<option>
																바베이도스
																달러
															</option>
															<option>
																바하마
																달러
															</option>
															<option>
																방글라데시
																타카
															</option>
															<option>
																버뮤다
																달러
															</option>
															<option>
																베네수엘라
																볼리바르
															</option>
															<option>
																베트남
																동
															</option>
															<option>
																벨라루스
																루블
															</option>
															<option>
																벨리즈
																달러
															</option>
															<option>
																보스니아
																헤르체고비나
																태환
																마르카
															</option>
															<option>
																보츠와나
																풀라
															</option>
															<option>
																볼리비아
																볼리비아노
															</option>
															<option>
																부룬디
																프랑
															</option>
															<option>
																부탄
																눌트럼
															</option>
															<option>
																불가리아
																레프
															</option>
															<option>
																브라질
																헤알
															</option>
															<option>
																브루나이
																달러
															</option>
															<option>
																사우디아라비아
																리얄
															</option>
															<option>
																서아프리카
																CFA
																프랑
															</option>
															<option>
																세르비아
																디나르
															</option>
															<option>
																세이셸
																루피
															</option>
															<option>
																소말리아
																실링
															</option>
															<option>
																솔로몬
																제도
																달러
															</option>
															<option>
																수단
																파운드
															</option>
															<option>
																수리남
																달러
															</option>
															<option>
																스리랑카
																루피
															</option>
															<option>
																스와질란드
																릴랑게니
															</option>
															<option>
																스웨덴
																크로나
															</option>
															<option>
																스위스
																프랑
															</option>
															<option>
																시에라리온
																리온
															</option>
															<option>
																신
																타이완
																달러
															</option>
															<option>
																싱가포르
																달러
															</option>
															<option>
																아랍에미리트
																디르함
															</option>
															<option>
																아루바
																플로린
															</option>
															<option>
																아르메니아
																드람
															</option>
															<option>
																아르헨티나
																페소
															</option>
															<option>
																아이슬란드
																크로나
															</option>
															<option>
																아이티
																구르드
															</option>
															<option>
																아제르바이잔
																마나트
															</option>
															<option>
																아프가니스탄
																아프가니
															</option>
															<option>
																알바니아
																레크
															</option>
															<option>
																알제리
																디나르
															</option>
															<option>
																앙골라
																콴자
															</option>
															<option>
																에티오피아
																비르
															</option>
															<option>
																엘살바도르
																콜론
															</option>
															<option>
																예멘
																리알
															</option>
															<option>
																오만
																리알
															</option>
															<option>
																오스트레일리아
																달러
															</option>
															<option>
																온두라스
																렘피라
															</option>
															<option>
																요르단
																디나르
															</option>
															<option>
																우간다
																실링
															</option>
															<option>
																우루과이
																페소
															</option>
															<option>
																우즈베키스탄
																숨
															</option>
															<option>
																우크라이나
																흐리우냐
															</option>
															<option>
																유로
															</option>
															<option>
																이라크
																디나르
															</option>
															<option>
																이란
																리알
															</option>
															<option>
																이스라엘
																신
																셰켈
															</option>
															<option>
																이집트
																파운드
															</option>
															<option>
																인도
																루피
															</option>
															<option>
																인도네시아
																루피아
															</option>
															<option>
																일본
																엔
															</option>
															<option>
																자메이카
																달러
															</option>
															<option>
																잠비아
																콰차
															</option>
															<option>
																조지아
																라리
															</option>
															<option>
																중국
																위안화
															</option>
															<option>
																중국
																위안화(역외)
															</option>
															<option>
																중앙아프리카
																CFA
																프랑
															</option>
															<option>
																지부티
																프랑
															</option>
															<option>
																체코
																코루나
															</option>
															<option>
																칠레
																(UF)
															</option>
															<option>
																칠레
																페소
															</option>
															<option>
																카보베르데
																이스쿠두
															</option>
															<option>
																카자흐스탄
																텡게
															</option>
															<option>
																카타르
																리얄
															</option>
															<option>
																캄보디아
																리엘
															</option>
															<option>
																캐나다
																달러
															</option>
															<option>
																케냐
																실링
															</option>
															<option>
																케이맨
																제도
																달러
															</option>
															<option>
																코모로
																프랑
															</option>
															<option>
																코스타리카
																콜론
															</option>
															<option>
																콜롬비아
																페소
															</option>
															<option>
																콩고
																프랑
															</option>
															<option>
																쿠바
																페소
															</option>
															<option>
																쿠웨이트
																디나르
															</option>
															<option>
																키르기스스탄
																솜
															</option>
															<option>
																타지키스탄
																소모니
															</option>
															<option>
																탄자니아
																실링
															</option>
															<option>
																태국
																밧
															</option>
															<option>
																터키
																리라
															</option>
															<option>
																통가
																팡가
															</option>
															<option>
																투르크메니스탄
																마나트
															</option>
															<option>
																튀니지
																디나르
															</option>
															<option>
																트리니다드
																토바고
																달러
															</option>
															<option>
																파나마
																발보아
															</option>
															<option>
																파라과이
																과라니
															</option>
															<option>
																파운드
																스털링
															</option>
															<option>
																파키스탄
																루피
															</option>
															<option>
																파푸아뉴기니
																키나
															</option>
															<option>
																페루
																솔
															</option>
															<option>
																폴란드
																즈워티
															</option>
															<option>
																피지
																달러
															</option>
															<option>
																필리핀
																페소
															</option>
															<option>
																헝가리
																포린트
															</option>
															<option>
																홍콩
																달러
															</option>
														</select>
														<span class="sBsF9c">미국 달러</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

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
										<p style="margin: 0px;">
											<a href="adminClub.ad">더보기</a>
										</p>
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
															<div class="table-responsive shop-table check"
																id="prod-list">
																<table class="table no-margin">
																	<thead class="subject -prodListHeaderDeselected"
																		id="prod-list-header-deselected">
																		<tr style="justify-content: left;">
																			<th class="check checkhead"></th>
																			<th class="no" style="margin-left: 5px;">No</th>
																			<th class="image" style="width: 260px;">클럽명</th>
																			<th class="group" style="width: 80px;">카테고리</th>
																			<th class="state">상태</th>
																			<th class="r-date" style="margin-left: 15px;">등록일</th>
																		</tr>
																	</thead>

																	<tbody id="prod-list-body"
																		class="-prod-list-body ui-sortable">
																		<c:forEach var="club" items="${clist}">
																			<tr class="content -prodListItem">
																				<td class="checkhead">
																					<div
																						class="drag -showcase-handle ui-sortable-handle"></div>
																					<div class="checkbox checkbox-styled no-margin">
																						<label> <input type="checkbox"
																							class="-prodListCheck"> <span></span>
																						</label>
																					</div>
																				</td>

																				<td class="no text-12">${club.clubNo}</td>

																				<td class="image"><a href="detail.cl?cno=${club.clubNo}"> <img
																						src="${club.thumbnailImg}" width="49" height="49"
																						class="item-thumb">
																				</a></td>

																				<td class="title">
																					<div>
																						<div class="item-tit inline-blocked">
																							<a href="detail.cl?cno=${club.clubNo}">${club.clubTitle}</a> <a
																								href="detail.cl?cno=${club.clubNo}"
																								class="im-icon im-ico-new-tab vertical-middle tab-icon"
																								style="margin-left: 4px;"></a>
																						</div>
																						<span class="btn-sm text-gray-bright"></span>
																					</div>
																				</td>

																				<td class="group" style="width: 90px;">${club.categoryName2}</td>

																				<td class="state on-click"><a
																					data-toggle="dropdown" style="margin-right: -1px;">
																						<span>${club.status}</span>
																				</a>
																				</td>

																				<td class="r-date text-12">${club.modifyDate}</td>
																				<td class="more"></td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>

													<div class="col-md-12">
														<nav class="text-center order-paging"
															id="prod-list-paging"></nav>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
								<!--섹션 끝 -->

								<div class="dashboard-section-header dashboard-stats-header">
									<div>
										<svg xmlns="http://www.w3.org/2000/svg" class="svgicon" fill="currentColor" class="bi bi-person-add" viewBox="0 0 16 16">
										  <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4"/>
										  <path d="M8.256 14a4.5 4.5 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10q.39 0 .74.025c.226-.341.496-.65.804-.918Q8.844 9.002 8 9c-5 0-6 3-6 4s1 1 1 1z"/>
										</svg>
										<span>신규 유저</span>
									</div>
									<div>
										<p style="margin: 0px;">
											<a href="adminUserlist.ad">더보기</a>
										</p>
									</div>
								</div>

								<!-- 신규 유저-->
								<section class="no-padding-bottom section">
									<div style="margin-bottom: 30px;">
										<div class="row">
											<div>
												<div class="row">
													<div>
														<div class="card" style="border-radius: 10px;">
															<div class="table-responsive shop-table check"
																id="prod-list">
																<table class="table no-margin">
																	<thead class="subject -prodListHeaderDeselected"
																		id="prod-list-header-deselected">
																		<tr>
																			<th class="check checkhead"></th>
																			<th class="no" style="margin-left: 5px;">No</th>
																			<th class="image" style="width: 165px;">유저명</th>
																			<th class="state">상태</th>
																			<th class="r-date" Style="margin-left: 10px;">가입일</th>
																			<th class="group">누적 포인트</th>
																			<th class="more"></th>
																		</tr>
																	</thead>

																	<tbody id="prod-list-body"
																		class="-prod-list-body ui-sortable">
																		<c:forEach var="user" items="${mlist}">
																			<tr class="content -prodListItem">
																				<td class="checkhead">
																					<div
																						class="drag -showcase-handle ui-sortable-handle"></div>
																					<div class="checkbox checkbox-styled no-margin">
																						<label> <input type="checkbox"
																							class="-prodListCheck"> <span></span>
																						</label>
																					</div>
																				</td>

																				<td class="no text-12">${user.userNo}</td>

																				<td class="image"><a href="javascript:void(0);"> <img
																						src="${user.profileImg}"
																						width="49" height="49" class="item-thumb">
																				</a></td>

																				<td class="title" style="width: 100px;">
																					<div>
																						<div class="item-tit inline-blocked">
																							<a href="javascript:void(0);">${user.nickname}</a> <a
																								href="javascript:void(0);""
																								class="im-icon im-ico-new-tab vertical-middle tab-icon"
																								style="margin-left: 4px;"></a>
																						</div>
																						<span class="btn-sm text-gray-bright"></span>
																					</div>
																				</td>

																				<td class="state on-click"><a
																					data-toggle="dropdown" style="margin-right: -1px;">
																						<span>${user.status}</span>
																				</a></td>

																				<td class="r-date text-12">${user.enrollDate}</td>
																				<td class="purchase text-center hidden-xs hidden-sm"
																					style="width: 100px;"><a href="adminPoint.ad"
																					style="text-decoration: underline;">${user.point}</a></td>
																				<td class="more">
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>

													<div class="col-md-12">
														<nav class="text-center order-paging"
															id="prod-list-paging"></nav>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
								<!--섹션 끝 -->


								<!-- 컨텐츠 -->
								<div class="dashboard-section-header">
									<div>
										<svg xmlns="http://www.w3.org/2000/svg" class="svgicon"
											fill="currentColor" class="bi bi-paragraph"
											viewBox="0 0 16 16">
                                                        <path
												d="M10.5 15a.5.5 0 0 1-.5-.5V2H9v12.5a.5.5 0 0 1-1 0V9H7a4 4 0 1 1 0-8h5.5a.5.5 0 0 1 0 1H11v12.5a.5.5 0 0 1-.5.5" />
                                                    </svg>
										<span>컨텐츠</span>
									</div>
								</div>

								<div
									class="flex-box dashboard-section-row dashboard-contents-row">
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
															<img src="_blank">
															<!-- 프로필 이미지-->
															<p>1:1 채팅 문의가 없어요</p>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</div>

									<div
										class="ma-item col-md-6 col-sm-6 col-xs-12 contents-list !tw-mb-0 no-padding">
										<div class="card flex-card">
											<!-- // 예약 또는 쇼핑 사용 -->
											<div class="card-head">
												<header>신규 공지사항</header>
												<a href="adminNotice.ad" class="dashboard-card-anchor">더보기</a>
											</div>
											<div class="card-body border-top">
												<ul class="list list-preview">
													<c:if test="${not empty nlist}">
														<li class="tile"><a
															class="tile-content contents-item" href="detail.no?nno=${nlist[0].noticeNo}">
																<div class="tile-text">
																	<div style="width: 60%;">
																		<strong>${nlist[0].noticeTitle}</strong> <span
																			class="tile-content">${nlist[0].noticeContent}</span>
																	</div>
																	<small class="text-12"> <span>${nlist[0].noticeNo}</span>
																		<span class="opacity-50 text-gray-bright margin-x-8">|</span>
																		<span>${nlist[0].modifyDate}</span>
																	</small>
																</div>
														</a></li>
													</c:if>
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