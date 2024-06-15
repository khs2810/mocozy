package com.kh.mocozy.myPage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.myPage.model.vo.MyPageClub;
import com.kh.mocozy.myPage.service.MyPageClubService;

@Controller
public class MyPageClubController {
	
	@Autowired
	private MyPageClubService myPageClubService;
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private ClubService clubService;
	
//	찜한 소셜링
	@RequestMapping("dibsSocial.me")
	public String myDibsSocialView(HttpSession session, Model model) {
    	
		// 세션에서 로그인한 사용자 정보를 가져옴
	    Member loginUser = (Member) session.getAttribute("loginUser");
	    if (loginUser == null) {
	        // 로그인한 사용자가 없을 경우
	        return "redirect:/loginPage"; // 로그인 페이지로 리다이렉트
	    }

	    // 새로운 Club 객체를 생성
	    Club club = new Club();
	    // 로그인한 사용자의 UserNo를 Club 객체에 설정
	    club.setUserNo(loginUser.getUserNo());
	    System.out.println("club : " + club);
	    // ClubService를 호출하여 로그인한 사용자가 찜한 소셜링 리스트가져오기
	    List<Club> dibsclist = (List<Club>)clubService.selectMyDibsSocialList(club);
	    System.out.println("dibsclist1 : " + dibsclist);
	    if (dibsclist == null) {
	        // dibsclist가 null일 경우 빈 리스트로 초기화
	        dibsclist = new ArrayList<>();
	    }

	    // 각 Club 객체에 대해 참여한 멤버 리스트를 가져오고 멤버 수를 설정
	    for (Club c : dibsclist) {
	        ArrayList<Member> memberList = memberService.participatedMemberList(c.getClubNo());
	        c.setMemberCnt(memberList.size());
	        System.out.println("memberList : " + memberList);
	    }

	    // 모델에 dibsclist 속성을 추가하여 뷰에 전달
	    model.addAttribute("dibsclist", dibsclist);
	    System.out.println("dibsclist2 : " + dibsclist);
	    // 'myPage/dibsSocial' 뷰 이름을 반환
	    return "myPage/dibsSocial";
    }

	
//	마이페이지 모임(소셜링, 찜) 목록
	@RequestMapping("myPage.me")
	public String myPageClub(HttpSession session, Model model) {
		
		MyPageClub myPageClub = new MyPageClub();
		myPageClub.setUserNo(((Member)session.getAttribute("loginUser")).getUserNo());
		
		
		List<MyPageClub> list = (List<MyPageClub>) myPageClubService.myPageClub(myPageClub);
		List<MyPageClub> plist = (List<MyPageClub>) myPageClubService.myPageClubPicked(myPageClub);
		
		model.addAttribute("list", list);
		model.addAttribute("plist", plist);
		
		return "myPage/myPage";
		
	}
	
}
