package com.kh.mocozy.club.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

@Controller
public class RequestController {
	
	@Autowired
	private ClubService clubService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("list.re")
	public String selectClub(int cno, Model model) {
		ArrayList<Member> memberList = memberService.participatedMemberList(cno);
		int memberCnt = memberList.size();
		
		Club c = clubService.selectClub(cno);
		model.addAttribute("c", c);
		
		ArrayList<Request> requestList = clubService.requestList(cno);
		model.addAttribute("requestList", requestList);
		model.addAttribute("memberCnt", memberCnt);
		
		return "club/requestListPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "accept.re", produces="application/json; charset-UTF-8")
	public String ajaxAcceptRequest(@RequestParam int rqno, int cno, HttpSession session) {
		ArrayList<Member> memberList = memberService.participatedMemberList(cno);
		int memberCnt = memberList.size();
		Club c = clubService.selectClub(cno);
		int capacity = c.getCapacity();
		
		if (memberCnt < capacity) {
			int result = clubService.acceptRequest(rqno);
			
			ArrayList<Request> rList = clubService.requestList(cno);
			
			return new Gson().toJson(rList);
		} else {
			session.setAttribute("alertMsg", "모임 인원 초과");
			return "redirect:list.re";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "deny.re", produces="application/json; charset-UTF-8")
	public String ajaxDenyRequest(@RequestParam int rqno, int cno) {
		int result = clubService.denyRequest(rqno);
		
		ArrayList<Request> rList = clubService.requestList(cno);
		
		return new Gson().toJson(rList);
	}
}
