package com.kh.mocozy.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.member.model.vo.Member;

@SessionAttributes({"loginUser"})
@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;

	@RequestMapping("list.ch")
	public String selectChat(@SessionAttribute("loginUser") Member loginUser, Model model) {
		
		// 현재 개설되어 있는 채팅방 목록 불러오기
		List<ChatRoom> roomList = chatService.selectRoomList(loginUser.getUserNo());
		model.addAttribute("roomList", roomList);
		
		return "club/chatPage";
	}
}
