package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminClubServiceImpl implements AdminClubService{
	
	@Autowired
	private AdminClubDao acDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Member> MemberList(int userNo) {
		ArrayList<Member> result = acDao.MemberList(sqlSession, userNo);
		return result;
	}
	
	@Override
	public int getClublist() {
		return acDao.getClublist(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectClublist(PageInfo ci) {
		return acDao.selectClublist(sqlSession, ci);
	}
}
