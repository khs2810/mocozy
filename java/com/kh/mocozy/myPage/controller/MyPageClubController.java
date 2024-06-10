package com.kh.mocozy.myPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
