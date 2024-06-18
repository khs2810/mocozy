package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.admin.model.dao.AdminDao;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public ArrayList<Member> adminMember(PageInfo mi) {
		return adDao.adminMember(sqlSession, mi);
	}

	@Override
	public ArrayList<Notice> adminNotice(PageInfo ni) {
		return adDao.adminNotice(sqlSession, ni);
	}

	@Override
	public ArrayList<Club> adminClub(PageInfo ci) {
		return adDao.adminClub(sqlSession, ci);
	}	
}
