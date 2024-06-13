package com.kh.mocozy.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.model.vo.Picked;
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
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session, String saveId,
			HttpServletResponse response) {
		// 암호화 전
		Member loginUser = memberService.loginMember(m);

		if (loginUser == null) { // 로그인 실패 => 에러문구를 requestScope에 담고 로그인페이지로 포워딩
			mv.addObject("errorMsg", "아이디와 비밀번호를 확인하세요.");

			mv.setViewName("member/loginPage");
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
	public String logoutMember(HttpSession session) {
		// 로그아웃 -> session에서 loginUser 삭제, 만료
//		 session.invalidate();
		session.removeAttribute("loginUser");

		return "redirect:/";
	}

//	회원가입 페이지
	@RequestMapping("signInPage.me")
	public String signInPageView() {
		return "member/signInPage";
	}

	// idCheck ajax요청을 받아줄 controller
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(@RequestBody String checkId) {
		int result = memberService.idCheck(checkId);

		if (result > 0) {// 이미존재한다면
			return "NNNNN";
		} else { // 존재하지않는다면
			return "NNNNY";
		}

		// return memberService.idCheck(checkId) > 0 ? "NNNNN" : "NNNNY";
	}

//	회원정보 수정
	@RequestMapping("update.me")
	public String updateMember(Member m, MultipartFile upfile, HttpSession session, Model model) {
		Attachment at = new Attachment();
		
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = saveFile(upfile, session);
			
			at.setOriginName(upfile.getOriginalFilename());
			at.setChangeName("/resources/koo/upfile/profile_img/" + changeName);
			at.setFilePath("/resources/koo/upfile/profile_img/");
		}
		
		m.setProfileImg(at.getChangeName());

		int result = memberService.updateMember(m);

		if (result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/myPage.me?uno=" + m.getUserNo();
		} else {
			model.addAttribute("errorMsg", "회원정보 수정 실패");
			return "myPage/myProfile";
		}

	}

	// 실제 넘어온 파일의 이름을 변경해서 서버에 저장하는 메소드
	public String saveFile(MultipartFile upfile, HttpSession session) {
		// 파일명 수정 후 서버에 업로드하기("imgFile.jpg => 202404231004305488.jpg")
		String originName = upfile.getOriginalFilename();

		// 년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		// 5자리 랜덤값
		int ranNum = (int) (Math.random() * 90000) + 10000;

		// 확장자
		String ext = originName.substring(originName.lastIndexOf("."));

		// 수정된 첨부파일명
		String changeName = currentTime + ranNum + ext;

		// 첨부파일을 저장할 폴더의 물리적 경로(session)
		String savePath = session.getServletContext().getRealPath("/resources/koo/upfile/profile_img/");

		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return changeName;
	}
	
	
	
	String functionName(int number) {
		return "abc";
	}

	// pwdCheck ajax요청을 받아줄 controller
	// 비밀번호 확인 요청을 처리하는 메서드
	@ResponseBody
    @PostMapping("checkPassword.me")
    public String checkPassword(Member m, @RequestParam("currentPwd") String currentPwd, HttpSession session) {
        // 현재 로그인한 사용자의 정보를 세션에서 가져옴
        Member loginUser = (Member) session.getAttribute("loginUser");
        
        if (loginUser == null) {
            return "NNNNN"; // 사용자가 로그인되어 있지 않음
            
        } else {
        	// 사용자의 ID를 이용해 현재 비밀번호를 가져옴
	        String userId = loginUser.getUserId();
	        String actualPwd = memberService.pwdCheck(userId);
	        
	     // 입력된 비밀번호와 실제 비밀번호를 비교
	        
	        if (currentPwd.equals(actualPwd)) {
	            return "NNNNY"; // 비밀번호가 일치함
	            
	        } else {
	            return "NNNNN"; // 비밀번호가 일치하지 않음
	        }
	      
        }
    }
	
//	비밀번호 수정
	@RequestMapping("updatePwd.me")
	public String updatePassword(Member m, HttpSession session, Model model) {

		
		int result = memberService.updatePassword(m);

		if (result > 0) {
			
			session.setAttribute("loginUser", memberService.updatePassword(m));
			session.setAttribute("alertMsg", "비밀번호 수정 성공. 다시 로그인 해주세요.");
			session.removeAttribute("loginUser");
			return "redirect:/";
			
		} else {
			model.addAttribute("errorMsg", "비밀번호 수정 실패");
			return "redirect:/myProfile.me";
		}

	}

	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session, String userPwd, Model model) {

		// 1. (암호화된) 비밀번호 가져오기
		Member loginUser = memberService.loginMember(m);
//		String userPwd = ((Member) session.getAttribute("loginUser")).getUserPwd();
		String plainPwd = ((Member) session.getAttribute("loginUser")).getUserPwd();
		// 2. 비밀번호 일치/불일치 판단후
//		if (bcryptPasswordEncoder.matches(m.getUserPwd(), userPwd)) {

		if (m.getUserPwd().equals(plainPwd)) {
			
		// 일치 -> 탈퇴처리 -> session에서 제거 -> 메인페이지로
			int result = memberService.deleteMember(m.getUserId());
			if (result > 0) {
				
				session.removeAttribute("loginUser");
				model.addAttribute("alertMsg", "회원탈퇴가 성공적으로 이루어졌습니다.");
				return "redirect:/";

			} else {
				model.addAttribute("alertMsg", "비밀번호를 다시 확인해주세요");
				return "redirect:/myProfile.me";
			}
		} else {
			//불일치 -> alertMsg: 비밀번호 다시 입력 -> 마이페이지
			model.addAttribute("alertMsg", "비밀번호를 다시 확인해주세요");
			return "redirect:/myProfile.me";
		}
	}
	
//	약관 동의
	@RequestMapping("terms.me")
	public String termsView(Member m, Model model) {

		model.addAttribute("m", m);

		return "member/terms";
	}

	@RequestMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		int result = memberService.insertMember(m);
		if (result > 0) {
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}

//		마이프로필
	@RequestMapping("myProfile.me")
	public String myProfileView() {
		return "myPage/myProfile";
	}

//		찜한 챌린지
	@RequestMapping("dibsChallenge.me")
	public String dibsChallengeView() {
		return "myPage/dibsChallenge";
	}

	
	//찜 ajax 확인
	@ResponseBody
	@RequestMapping(value = "getPicked.cl", produces="application/json; charset-UTF-8")
	public String ajaxGetPicked(Picked p, HttpSession session) {
		Member m = (Member)session.getAttribute("loginUser");
		if (m != null) {
			p.setUserNo(m.getUserNo());
			
			Picked pd = memberService.ajaxSelectPicked(p);
			if (pd != null) {
				return new Gson().toJson("YYY");
			} else {
				return new Gson().toJson("NNN");
			}
		} else {
			return new Gson().toJson("NNN");
		}
	} 
	
	//찜 ajax 업데이트
		@ResponseBody
		@RequestMapping(value ="updatePicked.cl", produces="application/json; charset-UTF-8")
		public String ajaxUpdatePicked(Picked p, HttpSession session) {
			Picked pd = memberService.ajaxSelectPicked(p);
			if (pd == null) { //picked 생성
				int result = memberService.ajaxInsertPicked(p);
				if (result > 0) {
					return new Gson().toJson("YYY");
				} else {
					return new Gson().toJson("NNN");
				}
			} else { //picked 제거
				int result = memberService.ajaxDeletePicked(p);
				if (result > 0) {
					return new Gson().toJson("NNN");
				} else {
					return new Gson().toJson("YYY");
				}
			}
		}

}