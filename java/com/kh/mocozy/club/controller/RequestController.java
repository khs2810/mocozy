package com.kh.mocozy.club.controller;

import java.util.ArrayList;

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

@Controller
public class RequestController {
	
	@Autowired
	private ClubService clubService;

	@RequestMapping("list.re")
	public String selectClub(int cno, Model model) {
//		ArrayList<Club> clubList = clubService.listClub(uno);
//		model.addAttribute("clubList", clubList);
//		int uno = 2;
		
		Club c = clubService.selectClub(cno);
		model.addAttribute("c", c);
		
		ArrayList<Request> requestList = clubService.requestList(cno);
		model.addAttribute("requestList", requestList);
		
		return "club/requestListPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "accept.re", produces="application/json; charset-UTF-8")
	public String ajaxAcceptRequest(@RequestParam int rqno, int cno) {
		int result = clubService.acceptRequest(rqno);
		
		ArrayList<Request> rList = clubService.requestList(cno);
		
		return new Gson().toJson(rList);
	}
}
