package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.admin.model.dao.AdminUserlistDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminUserlistServiceImpl implements AdminUserlistService{
	
	@Autowired
	private AdminUserlistDao auDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Member> MemberList(PageInfo mi) {
		return auDao.MemberList(sqlSession, mi);
	}
	
	@Override
	public int getMemberlist() {
		return auDao.getMemberlist(sqlSession);
	}
	

	
}
