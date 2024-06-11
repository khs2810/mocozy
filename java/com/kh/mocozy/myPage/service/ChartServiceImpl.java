package com.kh.mocozy.myPage.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.myPage.model.dao.ChartDao;
import com.kh.mocozy.myPage.model.vo.Charge;

@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
	private ChartDao chartDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Charge> point(Charge charge) {
		return chartDao.point(sqlSession, charge);
	}
	
	
}
