package com.kh.mocozy.club.service;

import java.util.List;
import java.util.Map;

import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;

public interface ChatService {
	List<ChatRoom> selectRoomList(int userNo);

	int checkChattingNo(Map<String, Integer> map);
	
	int insertMessage(Message msg);

	List<Message> selectMessageList(int chattingNo);
}
