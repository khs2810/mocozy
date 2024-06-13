package com.kh.mocozy.club.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.ChatRoom;

@Repository
public class ChatDao {
	
	public List<ChatRoom> selectRoomList(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectList("chatMapper.selectRoomList", userNo);
	}
}
