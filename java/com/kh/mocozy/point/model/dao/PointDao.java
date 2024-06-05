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

	public int totalChargePoint(SqlSessionTemplate sqlSession, int uno) {
		return sqlSession.selectOne("pointMapper.totalChargePoint", uno);
	}

	public ArrayList<Point> selectPointWithDrawList(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return (ArrayList)sqlSession.selectList("pointMapper.selectPointWithDrawList", map);
	}

	public int totalWithdrawPoint(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("pointMapper.totalWithdrawPoint", userNo);
	}

	public int sumWithdrawPointMonth(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.selectOne("pointMapper.sumWithdrawPointMonth", map);
	}

	public ArrayList<Point> selectPointUseList(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return (ArrayList)sqlSession.selectList("pointMapper.selectPointUseList", map);
	}

	public int useTotalPoint(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("pointMapper.useTotalPoint", userNo);
	}

	public int sumUsePoint(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.selectOne("pointMapper.sumUsePoint", map);
	}

}
