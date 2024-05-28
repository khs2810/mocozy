package com.kh.mocozy.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

//	메인페이지 이동 
	@RequestMapping("mainPage.re")
	public String mainPageView() {
		return "mainPage/mainPage";
}
}
