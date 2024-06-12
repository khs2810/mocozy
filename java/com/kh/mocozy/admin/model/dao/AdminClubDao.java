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

	//전체
	public ArrayList<Club> selectClublist(SqlSessionTemplate sqlSession, PageInfo ci, String sortType) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectClublist", sortType, rowBounds);
	}

	public ArrayList<Club> getClubAllList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.selectClublist");
	}

	//진행중
	public ArrayList<Club> selectClubProcess(SqlSessionTemplate sqlSession, PageInfo ci, String sortType) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubProcess", sortType, rowBounds);
	}

	public ArrayList<Club> getClubProcessList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubProcess");
	}

	//종료
	public ArrayList<Club> selectClubEnd(SqlSessionTemplate sqlSession, PageInfo ci, String sortType) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubEnd", sortType, rowBounds);
	}

	public ArrayList<Club> getClubEndList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubEnd");
	}

	//미승인
	public ArrayList<Club> selectClubApprove(SqlSessionTemplate sqlSession, PageInfo ci, String sortType) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubApprove", sortType, rowBounds);
	}

	public ArrayList<Club> getClubApproveList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("adminMapper.selectClubApprove");
	}
}
