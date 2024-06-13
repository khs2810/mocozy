package com.kh.mocozy.club.service;

import java.util.List;

import com.kh.mocozy.club.model.vo.ChatRoom;

public interface ChatService {
	List<ChatRoom> selectRoomList(int userNo);
}
