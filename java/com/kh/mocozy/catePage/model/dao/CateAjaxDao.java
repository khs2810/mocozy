package com.kh.mocozy.catePage.model.dao;

import java.util.ArrayList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class CateAjaxDao {
	    public ArrayList<Club> selectcatelist(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectcatelist");
	    }
	    
	    public ArrayList<Club> selectArt(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectArt");
	    }
	    
	    public ArrayList<Club> selectActivity(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectActivity");
	    }
	    
	    public ArrayList<Club> selectFood(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectFood");
	    }
	    
	    public ArrayList<Club> selectHobby(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectHobby");
	    }
	    
	    public ArrayList<Club> selectTravel(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectTravel");
	    }
	    
	    public ArrayList<Club> selectDevelope(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectDevelope");
	    }
	    
	    public ArrayList<Club> selectInvest(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectInvest");
	    }
	    
	    public ArrayList<Club> selectLove(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectLove");
	    }
	    
		public ArrayList<Club> selectForeign(SqlSessionTemplate sqlSession) {
			 return (ArrayList)sqlSession.selectList("cateMapper.selectForeign");
		}

		public ArrayList<Club> selectGame(SqlSessionTemplate sqlSession) {
			 return (ArrayList)sqlSession.selectList("cateMapper.selectGame");
		}
		
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
	}
