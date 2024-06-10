package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Repository
public class AdminNoticeDao {

	public ArrayList<Notice> getNoticeList(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAllList", null, rowBounds);
	}

	public int getNoticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getNoticeCount");
	}

	public ArrayList<Notice> getNoticeAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getNoticeAllList");
	}
}
