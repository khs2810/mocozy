package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Repository
public class AdminNoticeDao {
	
	public int getNoticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getNoticeCount");
	}
	
	//전체
	public ArrayList<Notice> getNoticeAll(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAll", null, rowBounds);
	}

	public ArrayList<Notice> getNoticeAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAll");
	}
	
	//이벤트
	public ArrayList<Notice> getNoticeEvent(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeEvent", null, rowBounds);
	}

	public ArrayList<Notice> getNoticeEventList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeEvent");
	}
	
	//공지
	public ArrayList<Notice> getNoticeBoard(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBoard", null, rowBounds);
	}

	public ArrayList<Notice> getNoticeBoardList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBoard");
	}
}
