package com.kh.mocozy.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
//		마이페이지 
		@RequestMapping("myPage.me")
		public String myPageView() {
			return "myPage/myPage";
	}
//		마이프로필
		@RequestMapping("myProfile.me")
		public String myProfileView() {
			return "myPage/myProfile";
	}
//	내 소셜
		@RequestMapping("mySocial.me")
		public String mySocialView() {
			return "myPage/mySocial";
	}
//		참가한 소셜
		@RequestMapping("goSocial.me")
		public String goSocialView() {
			return "myPage/goSocial";
	}
//		내 챌린지
		@RequestMapping("myChallenge.me")
		public String myChallengeView() {
			return "myPage/myChallenge";
	}
//		참가한 챌린지
		@RequestMapping("goChallenge.me")
		public String goChallengeView() {
			return "myPage/goChallenge";
	}
//		찜한 챌린지
		@RequestMapping("dibsChallenge.me")
		public String dibsChallengeView() {
			return "myPage/dibsChallenge";
	}
//		찜한 소셜
		@RequestMapping("dibsSocial.me")
		public String dibsSocialView() {
			return "myPage/dibsSocial";
	}
		
		
//		로그인
		@RequestMapping("loginPage.me")
		public String loginPageView() {
			return "member/loginPage";
		}
//		회원가입
		@RequestMapping("enrollForm.me")
		public String signInPageView() {
			return "member/signInPage";
		}
//		약관 동의
		@RequestMapping("terms.me")
		public String termsView() {
			return "member/terms";
		}
}
