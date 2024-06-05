package com.kh.mocozy.member.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.model.vo.Point;
import com.kh.mocozy.point.service.PointService;

	
@Controller
public class MemberPointController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private PointService pointService;
	
	@RequestMapping("manage.po")
	public String managePoint() {
		return "myPage/pointManagePage";
	}
	
	@RequestMapping("chargeHistory.po")
	public String chargeHistory(HttpSession session, Model model) {
		
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
			String strMonth = formatter.format(now);
			System.out.println(strMonth);
			
			Map <String, Object> map = new HashMap<>();
			
			map.put("userNo", m.getUserNo());
			map.put("strMonth", strMonth);
			
			ArrayList<Point> plist = pointService.selectPointChargeList(map);
			
			int sumPoint = pointService.sumPointMonth(map);
			
			model.addAttribute("plist", plist);
			model.addAttribute("sumPoint", sumPoint);
			model.addAttribute("strMonth", strMonth);
			
			return "myPage/pointChargeHistoryPage";
			
		} else {
			model.addAttribute("errorMsg", "로그인 후에 이용가능한 기능입니다.");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("useHistory.po")
	public String userHistory() {
		return "myPage/pointUseHistoryPage";
	} 
	
	@RequestMapping("charge.pt")
	public String chargePoint(Member m, Model model, HttpSession session) {
		
		int result1 = pointService.chargePoint(m);
		
		if (result1 > 0) {
			int result2 = memberService.chargePoint(m);
			
			if (result2 > 0) {
				session.setAttribute("loginUser", memberService.loginMember(m));
				return "redirect:manage.po";
			} else {
				model.addAttribute("errorMsg", "포인트 충전 실패");
				return "common/errorPage";
			}
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
			
			int result1 = pointService.withdrawPoint(m);
			
			int result2 = memberService.withdrawPoint(m);
			
			if (result1 * result2 > 0) {
				session.setAttribute("loginUser", memberService.loginMember(m));
				return "redirect:manage.po";
			} else {
				model.addAttribute("errorMsg", "포인트 출금 실패");
				return "common/errorPage";
			}
		}
		
		
	}
}
