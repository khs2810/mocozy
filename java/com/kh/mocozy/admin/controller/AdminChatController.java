package com.kh.mocozy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.mocozy.admin.service.AdminChatService;
import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminChatController {

	@Autowired
	private AdminChatService achService;

	@Autowired
	private ChatService chatService;

	@RequestMapping("adminChat.ad")
	public String showAdminChat(Model model, HttpSession session) {
		// 세션 만료 확인
		Member loginUser = (Member)session.getAttribute("loginUser");
		if (loginUser == null) {
			return "redirect:/"; // 메인 페이지로 리다이렉트
		} else {
			int adminUno = ((Member)session.getAttribute("loginUser")).getUserNo();
			ArrayList<ChatRoom> adminChatList = chatService.selectAdminChatList(adminUno);
			int adminChat = adminChatList.size();

			model.addAttribute("adminChatList", adminChatList);
			model.addAttribute("adminChat", adminChat);
			return "admin/adminChat/adminChat";
		}
	}

	//chat의 status 변경
	@ResponseBody
	@RequestMapping(value="chatStatus.ad", produces="application/json; charset=UTF-8")
	public HashMap<String, Object> chatStatus(String status, int chatNo, Model model, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("status", status);
		map.put("chatNo", chatNo);

		int result = achService.chatStatus(map);

		HashMap<String, Object> response = new HashMap<>();
		if (result > 0) {
			session.setAttribute("alertMsg", "채팅 삭제 성공");
			response.put("redirect", "admin.ad");
		} else {
			model.addAttribute("errorMsg", "채팅 삭제 실패");
			response.put("redirect", "common/errorPage");
		}

		return response;
	}

	@RequestMapping("privateChat.ad")
	public String showPrivateChat(int chno, Model model, HttpSession session) {
		// 세션 만료 확인
		Member loginUser = (Member)session.getAttribute("loginUser");
		if (loginUser == null) {
			return "redirect:/"; // 메인 페이지로 리다이렉트
		} else {
			int loginUserNo = ((Member)session.getAttribute("loginUser")).getUserNo();
			ChatRoom cr = chatService.selectChatRoomByNo(chno);

			model.addAttribute("chno", chno);
			model.addAttribute("targetNo", cr.getTargetNo());
			model.addAttribute("loginUserNo", loginUserNo);

			return "admin/adminChat/privateChat";
		}
	}


	// 채팅방 번호에 해당하는 메시지 목록 조회
	@ResponseBody
	@GetMapping(value="/privateChat.ad/selectMessage", produces="application/json; charset=UTF-8")
	public List<Message> selectMessageList(@RequestParam("chno") int chno) {
		return chatService.selectMessageList(chno);
	}
}
