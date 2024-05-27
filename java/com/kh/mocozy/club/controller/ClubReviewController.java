package com.kh.mocozy.club.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubReviewController {
	
	@Autowired
	private ClubService clubService;

	@RequestMapping("reviewList.cl")
	public String selectClubList(int uno, Model model) {
		ArrayList<Club> list = clubService.selectClubList(uno);
		
		model.addAttribute("list", list);
		model.addAttribute("uno", uno);
		
		return "myPage/reviewListPage";
	}
}
