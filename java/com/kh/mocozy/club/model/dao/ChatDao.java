package com.kh.mocozy.club.model.dao;

import java.util.ArrayList;
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
		int result = sqlSession.insert("chatMapper.insertMessage", msg);
		System.out.println("dao : " + result);
		return result;
	}

	public List<Message> selectMessageList(SqlSessionTemplate sqlSession, int chattingNo) {
		return sqlSession.selectList("chatMapper.selectMessageList", chattingNo);
	}

	public int updateReadFlag(SqlSessionTemplate sqlSession, int chattingNo) {
		return sqlSession.update("chatMapper.updateReadFlag", chattingNo);
	}

	public ChatRoom selectChatRoomByNo(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("chatMapper.selectChatRoomByNo", cno);
	}

	public ArrayList<ChatRoom> selectAdminChatList(SqlSessionTemplate sqlSession, int adminUno) {
		return (ArrayList)sqlSession.selectList("chatMapper.selectAdminChatList", adminUno);
	}

	public ChatRoom selectAdminChat(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("chatMapper.selectAdminChat", userNo);
	}
}
