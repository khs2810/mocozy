package com.kh.mocozy.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class AdminClubDao {

	public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
		ArrayList<Member> result = (ArrayList)sqlSession.selectList("adminMapper.MemberList", clubNo);
		return result;
	}
	
	public int getClublist(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.getClubList");
	}
	
	public ArrayList<Club> selectClublist(SqlSessionTemplate sqlSession, PageInfo ci) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectClublist", null, rowBounds);
	}

	public ArrayList<Club> getClubAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.selectClublist");
	}
}
