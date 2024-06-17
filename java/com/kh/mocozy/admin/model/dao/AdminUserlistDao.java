package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

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

	//insertManager
	public ArrayList<Member> insertManagerList(SqlSessionTemplate sqlSession, PageInfo mi, String sortType) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.insertManagerList", sortType, rowBounds);
	}
	
	//전체
	public ArrayList<Member> MemberAll(SqlSessionTemplate sqlSession, PageInfo mi, String sortType) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
			
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberAll", sortType, rowBounds);
	}
		
	public ArrayList<Member> MemberAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberAll");
	}
	
	//진행중
	public ArrayList<Member> MemberActive(SqlSessionTemplate sqlSession, PageInfo mi, String sortType) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberActive", sortType, rowBounds);
	}

	public ArrayList<Member> MemberActiveList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberActive");
	}
	
	//종료
	public ArrayList<Member> MemberEnd(SqlSessionTemplate sqlSession, PageInfo mi, String sortType) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberEnd", sortType, rowBounds);
	}

	public ArrayList<Member> MemberEndList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberEnd");
	}
	
	//숨김
	public ArrayList<Member> MemberHidden(SqlSessionTemplate sqlSession, PageInfo mi, String sortType) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberHidden", sortType, rowBounds);
	}
	
	public ArrayList<Member> MemberHiddenList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.MemberHidden");
	}
	
	//검색 리스트
	public int getMemberSearchlist(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("adminMapper.getMemberlist", map);
	}
	
	//전체 검색
	public ArrayList<Member> MemberSearchAll(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberSearchActive", map, rowBounds);
	}
	
	//진행중
	public ArrayList<Member> MemberSearchActive(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberSearchActive", map, rowBounds);
	}
	
	//종료됨
	public ArrayList<Member> MemberSearchEnd(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberSearchEnd", map, rowBounds);
	}
	
	//insertManager 검색
	public ArrayList<Member> MemberSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberSearchList", map, rowBounds);
	}

	//숨김 검색
	public ArrayList<Member> MemberSearchHidden(SqlSessionTemplate sqlSession, HashMap<String, String> map,
			PageInfo mi) {
		int offset = (mi.getCurrentPage() - 1) * mi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, mi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.MemberSearchHidden", map, rowBounds);
	}
		
	//숨김 처리
	public int userChangeStatus(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("adminMapper.userChangeStatus", map);
	}
	
	//권한 부여
	public int ManagerstatusAjax(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("adminMapper.adminstatusAjax", map);
	}
}
