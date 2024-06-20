package com.kh.mocozy.club.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;

public interface ChatService {
	List<ChatRoom> selectRoomList(int userNo);

	int checkChattingNo(Map<String, Integer> map);
	
	int insertMessage(Message msg);

	List<Message> selectMessageList(int chattingNo);

	ChatRoom selectChatRoomByNo(int cno);

	ArrayList<ChatRoom> selectAdminChatList(int adminUno);

	ChatRoom selectAdminChat(int userNo);
}
