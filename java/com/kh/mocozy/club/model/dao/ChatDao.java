package com.kh.mocozy.club.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Message;

@Repository
public class ChatDao {
	
	public List<ChatRoom> selectRoomList(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectList("chatMapper.selectRoomList", userNo);
	}

	public int checkChattingNo(SqlSessionTemplate sqlSession, Map<String, Integer> map) {
		return sqlSession.selectOne("chatMapper.checkChattingNo", map);
	}

	public int insertMessage(SqlSessionTemplate sqlSession, Message msg) {
		return sqlSession.insert("chatMapper.insertMessage", msg);
	}

	public List<Message> selectMessageList(SqlSessionTemplate sqlSession, int chattingNo) {
		List<Message> result = sqlSession.selectList("chatMapper.selectMessageList", chattingNo);
		System.out.println("dao : " + result);
		return result;
	}

	public int updateReadFlag(SqlSessionTemplate sqlSession, int chattingNo) {
		return sqlSession.update("chatMapper.updateReadFlag", chattingNo);
	}
}
