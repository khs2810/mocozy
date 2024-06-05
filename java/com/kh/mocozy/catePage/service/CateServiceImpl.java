package com.kh.mocozy.catePage.service;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.catePage.model.dao.CateDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class CateServiceImpl implements CateService{

	@Autowired
	private CateDao cDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
    @Override
    public ArrayList<Club> selectcatelist(PageInfo pi, String order) {
        return cDao.selectcatelist(sqlSession, pi, order);
    }
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = cDao.MemberList(sqlSession, clubNo);
		return result;
	}
	
	@Override
	public ArrayList<Club> getSocialing() {
	     return cDao.getSocialing(sqlSession);
	}

	@Override
	public ArrayList<Club> getChallenge() {
	     return cDao.getChallenge(sqlSession);
	}

	@Override
	public int getReviewCount(int clubNo) {
		return cDao.getReviewCount(sqlSession, clubNo);
	}
	    
	@Override
	public int getPickedCount(int clubNo) {
		return cDao.getPickedCount(sqlSession, clubNo);
	}

	@Override
	public int getClublist() {
		return cDao.getClublist(sqlSession);
	}

	@Override
	public ArrayList<Club> selectCateFilter(Map<String, String> map, PageInfo pi) {
		return cDao.selectCateFilter(sqlSession, map, pi);
	}
}
