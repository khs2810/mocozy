package com.kh.mocozy.myPage.service;

import java.util.List;

import com.kh.mocozy.myPage.model.vo.Charge;

public interface ChartService {

//	한달 충전 금액 합계
	List<Charge> point(Charge charge);
}

