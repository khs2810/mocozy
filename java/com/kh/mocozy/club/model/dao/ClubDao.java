package com.kh.mocozy.club.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClubDao {

	public int increaseCount(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.increaseCount", cno);
	}

}
