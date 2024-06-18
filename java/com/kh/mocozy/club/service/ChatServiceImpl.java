package com.kh.mocozy.club.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.kh.mocozy.club.model.dao.ChatDao;
import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatDao chatDao;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ChatRoom> selectRoomList(int userNo) {
		return chatDao.selectRoomList(sqlSession, userNo);
	}

	@Override
	public int checkChattingNo(Map<String, Integer> map) {
		return chatDao.checkChattingNo(sqlSession, map);
	}
	
	@Override
	public int insertMessage(Message msg) {
		int result = chatDao.insertMessage(sqlSession, msg);
		System.out.println("service : " + result);
		return result;
	} 

	@Override
	public List<Message> selectMessageList(int chattingNo) {
		return chatDao.selectMessageList(sqlSession, chattingNo);
//		if(!messageList.isEmpty()) {
//			int result = chatDao.updateReadFlag(sqlSession, paramMap);
//		}
	}

	@Override
	public ChatRoom selectChatRoomByNo(int cno) {
		return chatDao.selectChatRoomByNo(sqlSession, cno);
	}
	
}
