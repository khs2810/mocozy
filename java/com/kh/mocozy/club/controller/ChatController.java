package com.kh.mocozy.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	@RequestMapping("list.ch")
	public String selectChat() {
		return "club/chatPage";
	}
}
