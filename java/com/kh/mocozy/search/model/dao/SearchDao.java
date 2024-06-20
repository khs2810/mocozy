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

	public ArrayList<Club> searchFormAjax(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo re) {
		int offset = (re.getCurrentPage() - 1) * re.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, re.getBoardLimit());
		return (ArrayList)sqlSession.selectList("searchMapper.searchFormAjax", map, rowBounds);
	}
}

