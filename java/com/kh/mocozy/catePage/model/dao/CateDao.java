package com.kh.mocozy.catePage.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class CateDao {
		
		public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
			ArrayList<Member> result = (ArrayList)sqlSession.selectList("cateMapper.MemberList", clubNo);
			return result;
		}
		
	    public ArrayList<Club> getSocialing(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("mainPageMapper.getSocialing");
	    }

	    public ArrayList<Club> getChallenge(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("mainPageMapper.getChallenge");
	    }

		public int getReviewCount(SqlSessionTemplate sqlSession, int clubNo) {
			return sqlSession.selectOne("mainPageMapper.getReviewCount", clubNo);
		}

		public int getPickedCount(SqlSessionTemplate sqlSession, int clubNo) {
			return sqlSession.selectOne("mainPageMapper.getPickedCount", clubNo);
		}

		public int getClublist(SqlSessionTemplate sqlSession) {
			return sqlSession.selectOne("mainPageMapper.selectSocialList");
		}
		
		public ArrayList<Club> selectcatelist(SqlSessionTemplate sqlSession, PageInfo pi, String order) {
			int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
			
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			return (ArrayList)sqlSession.selectList("cateMapper.selectcatelist", order, rowBounds);
		}
		
		public ArrayList<Club> selectCateFilter(SqlSessionTemplate sqlSession, Map<String, String> map, PageInfo pi) {
			int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
			
			RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
			return (ArrayList)sqlSession.selectList("cateMapper.selectCateFilter", map, rowBounds);
		}
	}
