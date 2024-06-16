package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
	public ArrayList<Notice> getNoticeAll(SqlSessionTemplate sqlSession, PageInfo ni, String sortType) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAll", sortType, rowBounds);
	}

	public ArrayList<Notice> getNoticeAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAll");
	}
	
	//이벤트
	public ArrayList<Notice> getNoticeEvent(SqlSessionTemplate sqlSession, PageInfo ni, String sortType) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeEvent", sortType, rowBounds);
	}

	public ArrayList<Notice> getNoticeEventList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeEvent");
	}
	
	//공지
	public ArrayList<Notice> getNoticeBoard(SqlSessionTemplate sqlSession, PageInfo ni, String sortType) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBoard", sortType, rowBounds);
	}

	public ArrayList<Notice> getNoticeBoardList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBoard");
	}
	
	//배너
	public ArrayList<Notice> getNoticeBanner(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBanner", rowBounds);
	}
	
	public ArrayList<Notice> getNoticeBannerList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeBanner");
	}
	
	//검색리스트
	public int getNoticeSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.getNoticeCount", map);
	}
	
	//전체 검색
	public ArrayList<Notice> getNoticeSearchAll(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeSearchAll", map, rowBounds);
	}
	
	//공지 검색
	public ArrayList<Notice> getNoticeSearchBoard(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeSearchBoard", map, rowBounds);
	}
	
	//이벤트 검색
	public ArrayList<Notice> getNoticeSearchEvent(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeSearchEvent", map, rowBounds);
	}

	public int eventStatusAjax(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("adminMapper.eventStatusAjax", map);
	}

	public int eventBannerAjax(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("adminMapper.eventBannerAjax", map);
	}

}
