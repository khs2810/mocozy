package com.kh.mocozy.event.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.event.model.dao.EventDao;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDao eDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
    public ArrayList<Club> selecteventlist() {
    	return eDao.selectcatelist(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectArt() {
    	return eDao.selectArt(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectActivity() {
    	return eDao.selectActivity(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectFood() {
    	return eDao.selectFood(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectHobby() {
    	return eDao.selectHobby(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectTravel() {
    	return eDao.selectTravel(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectDevelope() {
    	return eDao.selectDevelope(sqlSession);
    }
	
	@Override
    public ArrayList<Club> selectLove() {
    	return eDao.selectLove(sqlSession);
    }
	
	@Override
	public ArrayList<Club> selectInvest() {
		return eDao.selectInvest(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectForeign() {
		return eDao.selectForeign(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectGame() {
		return eDao.selectGame(sqlSession);
	}
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = eDao.MemberList(sqlSession, clubNo);
		return result;
	}
	
	@Override
	public ArrayList<Club> getSocialing(PageInfo pi) {
	     return eDao.getSocialing(sqlSession, pi);
	}

	@Override
	public ArrayList<Club> getChallenge(PageInfo pi) {
	     return eDao.getChallenge(sqlSession, pi);
	}

	@Override
	public int getReviewCount(int clubNo) {
		return eDao.getReviewCount(sqlSession, clubNo);
	}
	    
	@Override
	public int getPickedCount(int clubNo) {
		return eDao.getPickedCount(sqlSession, clubNo);
	}

	@Override
	public int getEventlist() {
		return eDao.getEventlist(sqlSession);
	}
}
