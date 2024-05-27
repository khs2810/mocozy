package com.kh.mocozy.club.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;

@Repository
public class ClubDao {

	public int increaseCount(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.increaseCount", cno);
	}

	public Club selectClub(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("clubMapper.selectClub", cno);
	}

	public ArrayList<ClubReview> listReview(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("clubMapper.listReview", cno);
	}
	
	public int insertClub(SqlSessionTemplate sqlSession, Club c) {
		int result = 0;
		
		sqlSession.insert("clubMapper.insertClub", c);
		
		result = c.getClubNo();
		
		return result;
	}

	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment at) {
		return sqlSession.insert("attachmentMapper.insertAttachment", at);
	}

	public int insertChMember(SqlSessionTemplate sqlSession, Club c) {
		return sqlSession.insert("challengeMapper.insertChMember", c);
	}

	public ArrayList<Club> listClub(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.listClub", uno);
	}

	public Club selectClubList(SqlSessionTemplate sqlSession, int uno) {
		return sqlSession.selectOne("clubMapper.selectClubList", uno);
	}

	public ArrayList<Request> selectRequestList(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectRequestList", cno);
	}

	public int acceptRequest(SqlSessionTemplate sqlSession, int rqno) {
		return sqlSession.update("clubMapper.acceptRequest", rqno);
	}

	public int denyRequest(SqlSessionTemplate sqlSession, int rqno) {
		return sqlSession.update("clubMapper.denyRequest", rqno);
	}

	public int updateClub(SqlSessionTemplate sqlSession, Club c) {
		return sqlSession.update("clubMapper.updateClub", c);
	}
	
	public Attachment selectAttachment(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("attachmentMapper.selectAttachment", cno);
	}

	public int updateAttachment(SqlSessionTemplate sqlSession, Attachment at) {
		return sqlSession.update("attachmentMapper.updateAttachment", at);
	}
}
