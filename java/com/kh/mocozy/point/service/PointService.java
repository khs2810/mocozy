package com.kh.mocozy.point.service;

import com.kh.mocozy.member.model.vo.Member;

public interface PointService {

	int chargePoint(Member m);

	int withdrawPoint(Member m);

}
