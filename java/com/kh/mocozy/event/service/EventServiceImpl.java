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
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = eDao.MemberList(sqlSession, clubNo);
		return result;
	}


	@Override
	public int getEventlist() {
		return eDao.getEventlist(sqlSession);
	}


	@Override
	public ArrayList<Club> eventArt(PageInfo pi) {
		return eDao.eventArt(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventFood(PageInfo pi) {
		return eDao.eventFood(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventGame(PageInfo pi) {
		return eDao.eventGame(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventParty(PageInfo pi) {
		return eDao.eventParty(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventPhoto(PageInfo pi) {
		return eDao.eventPhoto(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventStudy(PageInfo pi) {
		return eDao.eventStudy(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventTravel(PageInfo pi) {
		return eDao.eventTravel(sqlSession, pi);
	}


	@Override
	public ArrayList<Club> eventLove(PageInfo pi) {
		return eDao.eventLove(sqlSession, pi);
	}
}
