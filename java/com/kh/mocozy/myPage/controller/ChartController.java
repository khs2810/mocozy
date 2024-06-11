package com.kh.mocozy.myPage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.myPage.model.vo.Charge;
import com.kh.mocozy.myPage.service.ChartService;

@Controller
public class ChartController {
	
	@Autowired
	private ChartService chartService;
	
	
//	[ajax] 매달 충전 금액 합계
	@ResponseBody
	@RequestMapping("chart.po")
	public List<Charge> point(HttpSession session) {
		
		Charge charge = new Charge();
		charge.setUserNo(((Member)session.getAttribute("loginUser")).getUserNo());
		
		List<Charge> list = chartService.point(charge);
		
		return list;
	}
	
}
