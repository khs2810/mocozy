package com.kh.mocozy.search.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class SearchDao {
	public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
		ArrayList<Member> result = (ArrayList)sqlSession.selectList("searchMapper.MemberList", clubNo);
		return result;
	}

	public int searchForm(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("searchMapper.searchForm", map);
	}

	public ArrayList<Club> selectSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map,
			PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("searchMapper.selectSearchList", map, rowBounds);
	}
	
	public ArrayList<Club> selectSearchPick(SqlSessionTemplate sqlSession, HashMap<String, String> map,
			PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("searchMapper.selectSearchPick", map, rowBounds);
	}
	
	public ArrayList<Club> selectSearchView(SqlSessionTemplate sqlSession, HashMap<String, String> map,
			PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("searchMapper.selectSearchView", map, rowBounds);
	}
}

