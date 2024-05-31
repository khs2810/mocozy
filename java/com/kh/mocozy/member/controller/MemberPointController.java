package com.kh.mocozy.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberPointController {
	
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
}
