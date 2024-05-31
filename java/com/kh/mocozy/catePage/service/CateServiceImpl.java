package com.kh.mocozy.catePage.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.catePage.model.dao.CateDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class CateServiceImpl implements CateService{

	@Autowired
	private CateDao cDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
    public ArrayList<Club> selectcatelist() {
    	return cDao.selectcatelist(sqlSession);
    }
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = cDao.MemberList(sqlSession, clubNo);
		return result;
	}
}
