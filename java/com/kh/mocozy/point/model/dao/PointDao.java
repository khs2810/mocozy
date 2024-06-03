package com.kh.mocozy.point.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.member.model.vo.Member;

@Repository
public class PointDao {

	public int chargePoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("pointMapper.chargePoint", m);
	}

	public int withdrawPoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("pointMapper.withdrawPoint", m);
	}

}
