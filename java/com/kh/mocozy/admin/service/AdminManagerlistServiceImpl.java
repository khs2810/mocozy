package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminManagerDao;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminManagerlistServiceImpl implements AdminManagerlistService{
	
	@Autowired
	private AdminManagerDao auDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Member> MemberList(PageInfo pi) {
		return auDao.MemberList(sqlSession, pi);
	}
	
	@Override
	public int getMemberlist() {
		return auDao.getMemberlist(sqlSession);
	}
	

	
}
