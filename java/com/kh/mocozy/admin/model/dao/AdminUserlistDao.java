package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class AdminUserlistDao {

	public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.getUserAllList", null, rowBounds);
	}

	public int getMemberlist(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getUserlist");
	}

	public ArrayList<Member> MemberAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.getUserAllList");
	}
}
