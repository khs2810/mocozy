package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class AdminUserlistDao {
	
	public int getMemberlist(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getMemberlist");
	}

	//전체
	public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberAll", null, rowBounds);
	}

	public ArrayList<Member> MemberAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberAll");
	}
	
	//진행중
	public ArrayList<Member> MemberActive(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberActive", null, rowBounds);
	}

	public ArrayList<Member> MemberActiveList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberActive");
	}
	
	//종료
	public ArrayList<Member> MemberEnd(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberEnd", null, rowBounds);
	}

	public ArrayList<Member> MemberEndList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberEnd");
	}
}
