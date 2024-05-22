package com.kh.mocozy.club.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Category;
import com.kh.mocozy.club.model.vo.Club;

@Repository
public class ClubDao {

	public int increaseCount(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.increaseCount", cno);
	}

	public Club selectClub(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("clubMapper.selectClub", cno);
	}

}
