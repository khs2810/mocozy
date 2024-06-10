package com.kh.mocozy.member.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.model.vo.Payment;
import com.kh.mocozy.point.model.vo.Point;
import com.kh.mocozy.point.service.PointService;

	
@Controller
public class MemberPointController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private PointService pointService;
	
	@RequestMapping("manage.po")
	public String managePoint(HttpSession session, Model model) {
		
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
			String strMonth = formatter.format(now);
			
			Map <String, Object> map = new HashMap<>();
			
			map.put("userNo", m.getUserNo());
			map.put("strMonth", strMonth);
			
			int sumPoint = pointService.sumPointMonth(map);
			int sumWithdrawPoint = pointService.sumWithdrawPointMonth(map);
			int sumUsePoint = pointService.sumUsePoint(map);
			
			model.addAttribute("strMonth", strMonth);
			model.addAttribute("sumPoint", sumPoint);
			model.addAttribute("sumWithdrawPoint", sumWithdrawPoint);
			model.addAttribute("sumUsePoint", sumUsePoint);
		}
		
		return "myPage/pointManagePage";
	}
	
	@RequestMapping("chargeHistory.po")
	public String chargeHistory(HttpSession session, Model model) {
		
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
			String strMonth = formatter.format(now);
			String[] tmp = strMonth.split("-");
			
			int month = Integer.parseInt(tmp[1]);
			
			
			Map <String, Object> map = new HashMap<>();
			
			map.put("userNo", m.getUserNo());
			map.put("strMonth", strMonth);
			
			//userNo의 한달 충전 리스트 및 총액
			ArrayList<Point> plist = pointService.selectPointChargeList(map);
			
			int totalPoint = 0;
			int sumPoint = 0;
			if (!plist.isEmpty()) {
				totalPoint = pointService.totalChargePoint(m.getUserNo());
				sumPoint = pointService.sumPointMonth(map);
			} 
			
			model.addAttribute("plist", plist);
			model.addAttribute("sumPoint", sumPoint);
			model.addAttribute("strMonth", strMonth);
			model.addAttribute("month", month);
			model.addAttribute("totalPoint", totalPoint);
			
			return "myPage/pointChargeHistoryPage";
			
		} else {
			model.addAttribute("errorMsg", "로그인 후에 이용가능한 기능입니다.");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("useHistory.po")
	public String userHistory(HttpSession session, Model model) {
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
			String strMonth = formatter.format(now);
			String[] tmp = strMonth.split("-");
			
			int month = Integer.parseInt(tmp[1]);
			
			Map <String, Object> map = new HashMap<>();
			
			map.put("userNo", m.getUserNo());
			map.put("strMonth", strMonth);
			
			//userNo의 한달 출금 리스트 및 총액
			ArrayList<Point> wlist = pointService.selectPointWithDrawList(map);
			
			int withdrawTotalPoint = 0;
			int sumWithdrawPoint = 0;
			if (!wlist.isEmpty()) {
				withdrawTotalPoint = pointService.totalWithdrawPoint(m.getUserNo());
				sumWithdrawPoint = pointService.sumWithdrawPointMonth(map);
			} 
			
			//userNo의 사용 리스트
			ArrayList<Payment> ulist = pointService.selectPointUseList(map);
			
			int useTotalPoint = 0;
			int sumUsePoint = 0;
			if (!ulist.isEmpty()) {
				useTotalPoint = pointService.useTotalPoint(m.getUserNo());
				sumUsePoint = pointService.sumUsePoint(map);
			} 
			
			model.addAttribute("wlist", wlist);
			model.addAttribute("sumWithdrawPoint", sumWithdrawPoint);
			model.addAttribute("strMonth", strMonth);
			model.addAttribute("month", month);
			model.addAttribute("withdrawTotalPoint", withdrawTotalPoint);
			model.addAttribute("ulist", ulist);
			model.addAttribute("useTotalPoint", useTotalPoint);
			model.addAttribute("sumUsePoint", sumUsePoint);
			
			return "myPage/pointUseHistoryPage";
		
		}  else {
			model.addAttribute("errorMsg", "로그인 후에 이용가능한 기능입니다.");
			return "common/errorPage";
		}
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
	
	@ResponseBody
	@RequestMapping(value = "ajaxPointChargeHistory.pt", produces = "application/json; charset-UTF-8")
	public String ajaxPointChargeBefore(int month, int uno) {
		
		String strMonth = "";
		if (month < 10) {
			strMonth = "2024-0" + month;
		} else {
			strMonth = "2024-" + month;
		}
		
		Map <String, Object> map = new HashMap<>();
		
		map.put("userNo", uno);
		map.put("strMonth", strMonth);
		
		ArrayList<Point> plist = pointService.selectPointChargeList(map);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
		for (Point p : plist) {
			p.setDateFormat(dateFormat.format(p.getCreateDate()));
			p.setPointFormat(NumberFormat.getInstance().format(p.getPoint())); 
		}
		
		int sumPoint = 0;
		if (!plist.isEmpty()) {
			sumPoint = pointService.sumPointMonth(map);
		} 
		
		String sumPointFormat = NumberFormat.getInstance().format(sumPoint);
		
		map.put("plist", plist);
		map.put("sumPoint", sumPointFormat);
		map.put("month", month);
		
		return new Gson().toJson(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "ajaxPointUseHistory.pt", produces = "application/json; charset-UTF-8")
	public String ajaxPointUseHistory(int month, int uno) {
		
		String strMonth = "";
		if (month < 10) {
			strMonth = "2024-0" + month;
		} else {
			strMonth = "2024-" + month;
		}
		
		Map <String, Object> map = new HashMap<>();
		
		map.put("userNo", uno);
		map.put("strMonth", strMonth);
		
		//userNo의 사용 리스트
		ArrayList<Payment> ulist = pointService.selectPointUseList(map);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
		for (Payment p : ulist) {
			p.setDateFormat(dateFormat.format(p.getPaymentDate()));
			p.setPointFormat(NumberFormat.getInstance().format(p.getPoint()));
		}
		
		int sumUsePoint = 0;
		if (!ulist.isEmpty()) {
			sumUsePoint = pointService.sumUsePoint(map);
		} 
		
		String sumUsePointFormat = NumberFormat.getInstance().format(sumUsePoint);
		
		map.put("ulist", ulist);
		map.put("sumPoint", sumUsePointFormat);
		map.put("month", month);
		
		return new Gson().toJson(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "ajaxPointWithdrawHistory.pt", produces = "application/json; charset-UTF-8")
	public String ajaxPointWithdrawHistory(int month, int uno) {
		
		String strMonth = "";
		if (month < 10) {
			strMonth = "2024-0" + month;
		} else {
			strMonth = "2024-" + month;
		}
		
		Map <String, Object> map = new HashMap<>();
		
		map.put("userNo", uno);
		map.put("strMonth", strMonth);
		
		//userNo의 한달 출금 리스트 및 총액
		ArrayList<Point> wlist = pointService.selectPointWithDrawList(map);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
		for (Point p : wlist) {
			p.setDateFormat(dateFormat.format(p.getCreateDate()));
			p.setPointFormat(NumberFormat.getInstance().format(p.getPoint()));
		}
		
		int sumWithdrawPoint = 0;
		if (!wlist.isEmpty()) {
			sumWithdrawPoint = pointService.sumWithdrawPointMonth(map);
		} 
		
		String sumWithdrawPointFormat = NumberFormat.getInstance().format(sumWithdrawPoint);
		
		map.put("wlist", wlist);
		map.put("sumPoint", sumWithdrawPointFormat);
		map.put("month", month);
		
		return new Gson().toJson(map);
	}
}
