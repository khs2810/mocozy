package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class AdminDao {

	public ArrayList<Member> adminMember(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.adminMember", null, rowBounds);
	}

	public ArrayList<Notice> adminNotice(SqlSessionTemplate sqlSession, PageInfo ni) {
		int offset = (ni.getCurrentPage() - 1) * ni.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ni.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.adminNotice", null, rowBounds);
	}

	public ArrayList<Club> adminClub(SqlSessionTemplate sqlSession, PageInfo ci) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.adminClub", null, rowBounds);
	}

}
