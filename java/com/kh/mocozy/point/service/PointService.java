package com.kh.mocozy.point.service;

import java.util.ArrayList;
import java.util.Map;

import com.kh.mocozy.admin.model.dto.SumPointDTO;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.vo.Payment;
import com.kh.mocozy.point.model.vo.Point;

public interface PointService {

	int chargePoint(Member m);
	
	int chargePoint(Map<String, Object> map);

	int withdrawPoint(Member m);

	ArrayList<Point> selectPointChargeList(Map<String, Object> map);

	int sumPointMonth(Map<String, Object> map);

	int totalChargePoint(int uno);

	ArrayList<Point> selectPointWithDrawList(Map<String, Object> map);

	int totalWithdrawPoint(int userNo);

	int sumWithdrawPointMonth(Map<String, Object> map);

	ArrayList<Payment> selectPointUseList(Map<String, Object> map);

	int useTotalPoint(int userNo);

	int sumUsePoint(Map<String, Object> map);

	int insertPointAdmin(Point p);

	ArrayList<Point> selectListPointAdmin(PageInfo pi);

	int selectPointAdminListCount();

	Payment selectPayment(int paymentNo);

	int returnPoint(Payment p);

	int cancelPayment(Payment p);

	SumPointDTO sumAllChargePoint(String status);

	SumPointDTO sumAllPaymentPoint();

}
