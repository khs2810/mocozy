package com.kh.mocozy.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@RequestMapping("detail.cl")
	public String selectClub(int cno, Model model) {
		
		int result = clubService.increaseCount(cno);
		
		if (result > 0) {
			Club c = clubService.selectClub(cno);
			model.addAttribute("c", c);
			System.out.println(c);
			return "club/clubDetailPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("confirm.cl")
	public String participateClub() {
		return "club/clubParticipateConfirm";
	}
	
	@RequestMapping("hostQuestion.cl")
	public String hostQuestion() {
		return "club/hostQuestionPage";
	}
	
	@RequestMapping("payment.cl")
	public String paymentClub() {
		return "club/clubPaymentPage";
	}
}
