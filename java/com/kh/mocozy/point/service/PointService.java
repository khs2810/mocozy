package com.kh.mocozy.point.service;

import java.util.ArrayList;
import java.util.Map;

import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.vo.Point;

public interface PointService {

	int chargePoint(Member m);

	int withdrawPoint(Member m);

	ArrayList<Point> selectPointChargeList(Map<String, Object> map);

	int sumPointMonth(Map<String, Object> map);

	int totalChargePoint(int uno);

}
