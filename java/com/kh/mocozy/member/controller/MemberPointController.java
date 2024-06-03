package com.kh.mocozy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

	
@Controller
public class MemberPointController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("manage.po")
	public String managePoint() {
		return "myPage/pointManagePage";
	}
	
	@RequestMapping("chargeHistory.po")
	public String chargeHistory() {
		return "myPage/pointChargeHistoryPage";
	}
	
	@RequestMapping("useHistory.po")
	public String userHistory() {
		return "myPage/pointUseHistoryPage";
	} 
	
	@RequestMapping("charge.pt")
	public String chargePoint(Member m, Model model, HttpSession session) {
		
		int result = memberService.chargePoint(m);
		
		if (result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			return "redirect:manage.po";
		} else {
			model.addAttribute("errorMsg", "포인트 충전 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("withdraw.pt")
	public String withdrawPoint(Member m, Model model, HttpSession session) {
		
		Member mv = memberService.loginMember(m);
		
		if (m.getPoint() > mv.getPoint()) {
			model.addAttribute("errorMsg", "포인트가 부족합니다.");
			return "common/errorPage";
		} else {
			int result = memberService.withdrawPoint(m);
			
			if (result > 0) {
				session.setAttribute("loginUser", memberService.loginMember(m));
				return "redirect:manage.po";
			} else {
				model.addAttribute("errorMsg", "포인트 출금 실패");
				return "common/errorPage";
			}
		}
		
		
	}
}
