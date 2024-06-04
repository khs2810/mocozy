package com.kh.mocozy.point.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.vo.Point;

@Repository
public class PointDao {

	public int chargePoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("pointMapper.chargePoint", m);
	}

	public int withdrawPoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("pointMapper.withdrawPoint", m);
	}

	public ArrayList<Point> selectPointChargeList(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return (ArrayList)sqlSession.selectList("pointMapper.selectPointChargeList", map);
	}

	public int sumPointMonth(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.selectOne("pointMapper.sumPointMonth", map);
	}

}
