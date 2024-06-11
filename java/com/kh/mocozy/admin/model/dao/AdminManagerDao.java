package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class AdminManagerDao {

	public int getManagerlist(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getManagerlist");
	}
	
	//전체
	public ArrayList<Member> ManagerAll(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerAll", null, rowBounds);
	}

	public ArrayList<Member> MemberAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerAll");
	}
	
	//진행중
	public ArrayList<Member> ManagerActive(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerActive", null, rowBounds);
	}

	public ArrayList<Member> MemberActiveList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerActive");
	}
	
	//종료
	public ArrayList<Member> ManagerEnd(SqlSessionTemplate sqlSession, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerEnd", null, rowBounds);
	}

	public ArrayList<Member> MemberEndList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.ManagerEnd");
	}

	
}
