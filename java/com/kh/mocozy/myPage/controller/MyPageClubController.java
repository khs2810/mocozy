package com.kh.mocozy.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.myPage.service.MyPageClubService;

public class MyPageClubController {
	
	@Autowired
	private MyPageClubService myPageClubService;
	
	@Autowired
	private MemberService memberService;
}
