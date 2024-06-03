package com.kh.mocozy.event.model.dao;

import java.util.ArrayList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class EventDao {
	    public ArrayList<Club> selecteventlist(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("eventMapper.selecteventlist");
	    }
	    
		public ArrayList<Member> MemberList(SqlSessionTemplate sqlSession, int clubNo) {
			ArrayList<Member> result = (ArrayList)sqlSession.selectList("eventMapper.MemberList", clubNo);
			return result;
		}
}
