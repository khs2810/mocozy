package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.mainPage.model.dao.MainDao;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDao mainDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
    @Override
    public int selectSocialList() {
        return mainDao.selectSocialList(sqlSession);
    }
    
    @Override
    public ArrayList<Club> selectClist(PageInfo ci) {
    	return mainDao.selectClist(sqlSession, ci);
    }
    
    @Override
    public ArrayList<Club> selectRlist(PageInfo ri) {
    	return mainDao.selectClist(sqlSession, ri);
    }
    
    @Override
    public ArrayList<Club> selectFlist(PageInfo fi) {
    	return mainDao.selectClist(sqlSession, fi);
    }

	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = mainDao.MemberList(sqlSession, clubNo);
		return result;
	}

    @Override
    public ArrayList<Club> getSocialing(PageInfo pi) {
        return mainDao.getSocialing(sqlSession, pi);
    }

    @Override
    public ArrayList<Club> getChallenge(PageInfo pi) {
        return mainDao.getChallenge(sqlSession, pi);
    }
}