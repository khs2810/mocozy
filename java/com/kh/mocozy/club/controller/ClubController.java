package com.kh.mocozy.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@RequestMapping("detail.cl")
	public String selectClub(int cno) {
		
		int result = clubService.increaseCount(cno);
		
		return "club/clubDetailPage";
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
