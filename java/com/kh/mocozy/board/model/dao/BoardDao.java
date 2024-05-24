package com.kh.mocozy.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.board.model.vo.NoticeReply;
import com.kh.mocozy.common.model.vo.PageInfo;

@Repository
public class BoardDao {

	public int selectNoticeListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.selectNoticeListCount");
	}

	public ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)(sqlSession.selectList("boardMapper.selectNoticeList", null, rowBounds));
	}

	public int increaseCount(SqlSessionTemplate sqlSession, int nno) {
		return sqlSession.update("boardMapper.increaseCount", nno);
	}

	public Notice selectNotice(SqlSessionTemplate sqlSession, int nno) {
		return sqlSession.selectOne("boardMapper.selectNotice", nno);
	}

	public int replyListCount(SqlSessionTemplate sqlSession, int nno) {
		return sqlSession.selectOne("boardMapper.replyListCount", nno);
	}

	public ArrayList<NoticeReply> selectNoticeReplyList(SqlSessionTemplate sqlSession, int nno, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)(sqlSession.selectList("boardMapper.selectNoticeReplyList", nno, rowBounds));
	}

	public int insertNotice(SqlSessionTemplate sqlSession, Notice n) {
		return sqlSession.insert("boardMapper.insertNotice", n);
	}

}
