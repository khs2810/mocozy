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
    public ArrayList<Club> selectArt() {
    	return cDao.selectArt(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectActivity() {
    	return cDao.selectActivity(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectFood() {
    	return cDao.selectFood(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectHobby() {
    	return cDao.selectHobby(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectTravel() {
    	return cDao.selectTravel(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectDevelope() {
    	return cDao.selectDevelope(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectLove() {
    	return cDao.selectLove(sqlSession);
    }
	
	@Override
	public ArrayList<Club> selectInvest() {
		return cDao.selectInvest(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectForeign() {
		return cDao.selectForeign(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectGame() {
		return cDao.selectGame(sqlSession);
	}
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = cDao.MemberList(sqlSession, clubNo);
		return result;
	}
}
