package com.kh.mocozy.myPage.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.myPage.model.vo.Charge;

@Repository
public class ChartDao {
//	한달 충전금액합계
	public List<Charge> point(SqlSessionTemplate sqlSession, Charge charge) {
		return sqlSession.selectList("chartMapper.sumPointMonth", charge);
	}
}
