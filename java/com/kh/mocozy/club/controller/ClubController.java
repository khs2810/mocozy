package com.kh.mocozy.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
}
