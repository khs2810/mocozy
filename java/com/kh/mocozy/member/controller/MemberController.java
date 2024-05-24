package com.kh.mocozy.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

@Controller
public class MemberController {
	
//	로그인
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
//	로그인 페이지
	@RequestMapping("loginPage.me")
	public String loginPageView() {
		return "member/loginPage";
	}
	
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session, String saveId, HttpServletResponse response) {	
		//암호화 전
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) { //로그인 실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
			mv.addObject("errorMsg", "로그인실패");
			
			mv.setViewName("common/errorPage");
		} else { // 로그인 성공 => sessionScope에 로그인유저 담아서 메인으로 url재요청
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
		
		
//		//암호화 후
//		//Member m의 id => 사용자가 입력한 아이디
//		//		 m의 pwd => 사용자가 입력한 pwd(평문)
//		
//		Member loginUser = memberService.loginMember(m);
//		
//		// loginUser id => 아이디로 db에서 검색해온 id
//		//loginUser pwd => db에 기록된 암호화된 비밀번호
//		
//		
//		//bcryptPasswordEncoder객체의 matches()
//		//matches(평문, 암호문)을 작성하면 내부적으로 복호화작업 후 비교가 이루어짐
//		//두 구문이 일치하면 true를 반환 일치하지않으면 false 반환
//		
//		bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd());
//		
//		if (loginUser == null) { // 아이디가 없는 경우
//			mv.addObject("errorMsg", "일치하는 아이디를 찾을 수 없습니다.");
//			
//			mv.setViewName("common/errorPage");
//			
//			//비밀번호가 다른경우
//		} else if (!bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())){ 
//			mv.addObject("errorMsg", "비밀번호가 일치하지 않습니다.");
//			mv.setViewName("common/errorPage");
//		} else { // 성공
//			Cookie ck = new Cookie("saveId", loginUser.getUserId());
//			if (saveId == null) {
//				ck.setMaxAge(0);
//			}
//			response.addCookie(ck);
//			
//			session.setAttribute("loginUser", loginUser);
//			mv.setViewName("redirect:/");
//		}
//		
//		return mv;
//	}
	
//	로그아웃
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session){
		//로그아웃 -> session에서 loginUser 삭제, 만료
		//session.invalidate();
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	
//	회원가입
	@RequestMapping("signInPage.me")
	public String signInPageView() {
		return "member/signInPage";
	}

	//idCheck ajax요청을 받아줄 controller
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if (result > 0) {// 이미존재한다면
			return "NNNNN";
		} else { //존재하지않는다면
			return "NNNNY";
		}
		
		//return memberService.idCheck(checkId) > 0 ? "NNNNN" : "NNNNY";
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		/*
		 * 1. 한글깨짐문제 발생 => web.xml에 스프링에서 제공하는 인코딩 필터 등록
		 * 2. 나이를 입력하지 않을 경우 int자료형에 빈문자열을 대입해야하는 경우가 발생한다.
		 * => 400에러 방생  Member의 age필드 자료형을 String으로 변경해주면 된다.
		 * 3. 비밀번호가 사용자 입력 그대로 전달이 된다(평문)
		 * Bcrypt방식을 이용해서 암호화를 한 후 저장을 하겠다.
		 * => 스프링시큐리티에서 제공하는 모듈을 이용<pom.xml에 라이브러리 추가>
		 */
		
		//암호화작업
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if (result > 0) {
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
	
//	마이페이지 
	@RequestMapping("myPage.me")
	public String myPageView() {
		return "myPage/myPage";
}
	
//	회원정보 수정
	@RequestMapping("update.me")
	public String updateMember(Member m, HttpSession session, Model model) {
		
		int result = memberService.updateMember(m);
		
		if (result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/myPage.me";
		} else {
			model.addAttribute("errorMsg", "회원정보 수정 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session) {
		
		//1. 암호화된 비밀번호 가져오기
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
		
		//2. 비밀번호 일치/불일치 판단후
		if (bcryptPasswordEncoder.matches(m.getUserPwd(), encPwd)) {
			//일치 -> 탈퇴처리 -> session에서 제거 -> 메인페이지로
			int result = memberService.deleteMember(m.getUserId());
			
			if(result > 0) {
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "회원탈퇴가 성공적으로 이루어졌습니다.");
				return "redirect:/";
			} else {
				session.setAttribute("alertMsg", "탈퇴처리 실패");
				return "redirect:/myPage.me";
			}
			
		} else {
			//불일치 -> alertMsg: 비밀번호 다시 입력 -> 마이페이지
			session.setAttribute("alertMsg", "비밀번호를 다시 확인해주세요");
			return "redirect:/myPage.me";
		}
	}
	

//	약관 동의
	@RequestMapping("terms.me")
	public String termsView() {
		return "member/terms";
	}


//		마이프로필
		@RequestMapping("myProfile.me")
		public String myProfileView() {
			return "myPage/myProfile";
	}
//		내 소셜
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
		
}