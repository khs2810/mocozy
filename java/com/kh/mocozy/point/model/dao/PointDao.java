package com.kh.mocozy.point.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.vo.Payment;
import com.kh.mocozy.point.model.vo.Point;

@Repository
public class PointDao {

	public int chargePoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("pointMapper.chargePoint", m);
	}
	
	public int chargePoint(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.insert("pointMapper.chargePointType", map);
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

	public ArrayList<Payment> selectPointUseList(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return (ArrayList)sqlSession.selectList("pointMapper.selectPointUseList", map);
	}

	public int useTotalPoint(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("pointMapper.useTotalPoint", userNo);
	}

	public int sumUsePoint(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.selectOne("pointMapper.sumUsePoint", map);
	}

	public int insertPointAdmin(SqlSessionTemplate sqlSession, Point p) {
		return sqlSession.update("insertPointAdmin", p);
	}

	public ArrayList<Point> selectListPointAdmin(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("selectListPointAdmin", null, rowBounds);
	}

	public int selectPointAdminListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("selectPointAdminListCount");
	}

	public Payment selectPayment(SqlSessionTemplate sqlSession, int paymentNo) {
		return sqlSession.selectOne("pointMapper.selectPayment", paymentNo);
	}

	public int returnPoint(SqlSessionTemplate sqlSession, Payment p) {
		return sqlSession.update("pointMapper.returnPoint", p);
	}

	public int cancelPayment(SqlSessionTemplate sqlSession, Payment p) {
		return sqlSession.update("pointMapper.cancelPayment", p);
	}

}
