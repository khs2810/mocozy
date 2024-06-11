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
	private AdminManagerDao amDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getManagerlist() {
		return amDao.getManagerlist(sqlSession);
	}
	
	//전체
	@Override
	public ArrayList<Member> ManagerAll(PageInfo mi) {
		return amDao.ManagerAll(sqlSession, mi);
	}

	@Override
	public ArrayList<Member> MemberAllList() {
		return amDao.MemberAllList(sqlSession);
	}
	
	//활동중
	@Override
	public ArrayList<Member> ManagerActive(PageInfo mi) {
		return amDao.ManagerActive(sqlSession, mi);
	}

	@Override
	public ArrayList<Member> MemberActiveList() {
		return amDao.MemberActiveList(sqlSession);
	}
	
	//종료
	@Override
	public ArrayList<Member> ManagerEnd(PageInfo mi) {
		return amDao.ManagerEnd(sqlSession, mi);
	}

	@Override
	public ArrayList<Member> MemberEndList() {
		return amDao.MemberEndList(sqlSession);
	}
	
	
}
