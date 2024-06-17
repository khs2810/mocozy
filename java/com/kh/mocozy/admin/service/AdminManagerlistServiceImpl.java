package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

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
	public ArrayList<Member> ManagerAll(PageInfo mi, String sortType) {
		return amDao.ManagerAll(sqlSession, mi, sortType);
	}

	@Override
	public ArrayList<Member> MemberAllList() {
		return amDao.MemberAllList(sqlSession);
	}
	
	//검색 리스트
	@Override
	public int getManagerSearchlist(HashMap<String, String> map) {
		return amDao.getManagerSearchlist(sqlSession, map);
	}
	
	//전체
	@Override
	public ArrayList<Member> ManagerSearchAll(HashMap<String, String> map, PageInfo mi) {
		return amDao.ManagerSearchAll(sqlSession, map, mi);
	}	
	
	//권한 박탈
	@Override
	public int adminstatusAjax(HashMap<String, Object> map) {
		return amDao.adminstatusAjax(sqlSession, map);
	}	
}
