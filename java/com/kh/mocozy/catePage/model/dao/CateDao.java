package com.kh.mocozy.catePage.model.dao;

import java.util.ArrayList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class CateDao {
	    public ArrayList<Club> selectcatelist(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectcatelist");
	    }
	    
		public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
			ArrayList<Member> result = (ArrayList)sqlSession.selectList("cateMapper.MemberList", clubNo);
			return result;
		}
	}
