package com.kh.mocozy.club.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ChatDao;
import com.kh.mocozy.club.model.vo.ChatRoom;

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
	
}
