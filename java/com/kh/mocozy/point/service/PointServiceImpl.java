package com.kh.mocozy.point.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.dao.PointDao;



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
	public int withdrawPoint(Member m) {
		return pointDao.withdrawPoint(sqlSession, m);
	}
	
}