package com.kh.mocozy.club.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@RequestMapping("detail.cl")
	public String selectClub(int cno, Model model) {
		
		int result = clubService.increaseCount(cno);
		ArrayList<ClubReview> reviewList = clubService.listReview(cno);
		
		
		if (result > 0) {
			Club c = clubService.selectClub(cno);
//			System.out.println(c);
			model.addAttribute("c", c);
			model.addAttribute("reviewList", reviewList);
//			System.out.println(reviewList);
			return "club/clubDetailPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("confirm.cl")
	public String participateClub(int cno, Model model) {
		model.addAttribute("cno", cno);
		return "club/clubParticipateConfirm";
	}
	
	@RequestMapping("hostQuestion.cl")
	public String hostQuestion(int cno, Model model) {
		Club c = clubService.selectClub(cno);
		
		if (c != null) {
			model.addAttribute("c", c);
			return "club/hostQuestionPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("payment.cl")
	public String paymentClub(int cno, Model model) {
		Club c = clubService.selectClub(cno);
//		System.out.println(c);
		if (c != null) {
			model.addAttribute("c", c);
			return "club/clubPaymentPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
	}
	
}
