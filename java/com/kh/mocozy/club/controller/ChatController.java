package com.kh.mocozy.club.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.member.model.vo.Member;

@SessionAttributes({"loginUser"})
@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	// ChatService 주입을 위한 생성자
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@RequestMapping("list.ch")
	public String selectChat(@SessionAttribute("loginUser") Member loginUser, Model model) {
		
		// 현재 개설되어 있는 채팅방 목록 불러오기
		List<ChatRoom> roomList = chatService.selectRoomList(loginUser.getUserNo());
		model.addAttribute("roomList", roomList);
		
		return "club/chatPage";
	}
	
//	@GetMapping("/list.ch/enter")
//	@ResponseBody
//	public int chattingEnter(int targetNo, @SessionAttribute("loginUser") Member loginUser) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		map.put("targetNo", targetNo);
//		map.put("loginUserNo", loginUser.getUserNo());
//		
//		int chattingNo = chatService.checkChattingNo(map);
//		
//		return chattingNo;
//	}
	
	// 채팅방 번호에 해당하는 메시지 목록 조회
	@ResponseBody
	@GetMapping(value="/list.ch/selectMessage", produces="application/json; charset=UTF-8")
	public List<Message> selectMessageList(@RequestParam("chattingNo") int chattingNo) {
		return chatService.selectMessageList(chattingNo);
	}
}
