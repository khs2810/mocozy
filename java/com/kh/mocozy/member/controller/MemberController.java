package com.kh.mocozy.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	

	@RequestMapping("myPage.me")
	public String myPageView() {
		return "myPage/myPage";
}
}
