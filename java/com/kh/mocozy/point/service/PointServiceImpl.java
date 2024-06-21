package com.kh.mocozy.point.service;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mocozy.admin.model.dto.SumPointDTO;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.dao.PointDao;
import com.kh.mocozy.point.model.vo.Payment;
import com.kh.mocozy.point.model.vo.Point;



@Service
public class PointServiceImpl implements PointService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PointDao pointDao;

	@Override
	public int chargePoint(Member m) {
		return pointDao.chargePoint(sqlSession, m);
	}
	
	@Override
	public int chargePoint(Map<String, Object> map) {
		return pointDao.chargePoint(sqlSession, map);
	}

	@Override
	public int withdrawPoint(Member m) {
		return pointDao.withdrawPoint(sqlSession, m);
	}

	@Override
	public ArrayList<Point> selectPointChargeList(Map<String, Object> map) {
		return pointDao.selectPointChargeList(sqlSession, map);
	}

	@Override
	public int sumPointMonth(Map<String, Object> map) {
		return pointDao.sumPointMonth(sqlSession, map);
	}

	@Override
	public int totalChargePoint(int uno) {
		return pointDao.totalChargePoint(sqlSession, uno);
	}

	@Override
	public ArrayList<Point> selectPointWithDrawList(Map<String, Object> map) {
		return pointDao.selectPointWithDrawList(sqlSession, map);
	}

	@Override
	public int totalWithdrawPoint(int userNo) {
		return pointDao.totalWithdrawPoint(sqlSession, userNo);
	}

	@Override
	public int sumWithdrawPointMonth(Map<String, Object> map) {
		return pointDao.sumWithdrawPointMonth(sqlSession, map);
	}

	@Override
	public ArrayList<Payment> selectPointUseList(Map<String, Object> map) {
		return pointDao.selectPointUseList(sqlSession, map);
	}

	@Override
	public int useTotalPoint(int userNo) {
		return pointDao.useTotalPoint(sqlSession, userNo);
	}

	@Override
	public int sumUsePoint(Map<String, Object> map) {
		return pointDao.sumUsePoint(sqlSession, map);
	}

	@Override
	public int insertPointAdmin(Point p) {
		return pointDao.insertPointAdmin(sqlSession, p);
	}

	@Override
	public ArrayList<Point> selectListPointAdmin(PageInfo pi) {
		return pointDao.selectListPointAdmin(sqlSession, pi);
	}

	@Override
	public int selectPointAdminListCount() {
		return pointDao.selectPointAdminListCount(sqlSession);
	}

	@Override
	public Payment selectPayment(int paymentNo) {
		return pointDao.selectPayment(sqlSession, paymentNo);
	}

	@Override
	public int returnPoint(Payment p) {
		return pointDao.returnPoint(sqlSession, p);
	}

	@Override
	public int cancelPayment(Payment p) {
		return pointDao.cancelPayment(sqlSession, p);
	}

	@Override
	public SumPointDTO sumAllChargePoint(String status) {
		return pointDao.sumAllChargePoint(sqlSession, status);
	}

	@Override
	public SumPointDTO sumAllPaymentPoint() {
		return pointDao.sumAllPaymentPoint(sqlSession);
	}
	
}