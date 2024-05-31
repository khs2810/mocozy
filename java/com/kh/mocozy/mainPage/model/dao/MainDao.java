package com.kh.mocozy.mainPage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class MainDao {
	
	public int selectSocialList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("mainPageMapper.selectSocialList");
	}

	public ArrayList<Club> selectClist(SqlSessionTemplate sqlSession, PageInfo ci) {
		int offset = (ci.getCurrentPage() - 1) * ci.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, ci.getBoardLimit());
		return (ArrayList)sqlSession.selectList("mainPageMapper.selectClist", null, rowBounds);
	}
	
	public ArrayList<Club> selectRlist(SqlSessionTemplate sqlSession, PageInfo ri) {
		int offset = 10;
		    
		    RowBounds rowBounds = new RowBounds(offset, ri.getBoardLimit());
		    return (ArrayList)sqlSession.selectList("mainPageMapper.selectRlist", null, rowBounds);
	}
	
	public ArrayList<Club> selectFlist(SqlSessionTemplate sqlSession, PageInfo fi) {
		int offset = 2;
		    
		    RowBounds rowBounds = new RowBounds(offset, fi.getBoardLimit());
		    return (ArrayList)sqlSession.selectList("mainPageMapper.selectRlist", null, rowBounds);
	}

	public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
		ArrayList<Member> result = (ArrayList)sqlSession.selectList("mainPageMapper.MemberList", clubNo);
		return result;
	}

    public ArrayList<Club> getSocialing(SqlSessionTemplate sqlSession, PageInfo pi) {
        return (ArrayList)sqlSession.selectList("mainPageMapper.getSocialing", pi);
    }

    public ArrayList<Club> getChallenge(SqlSessionTemplate sqlSession, PageInfo pi) {
        return (ArrayList)sqlSession.selectList("mainPageMapper.getChallenge", pi);
    }
	

}
