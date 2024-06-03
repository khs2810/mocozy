package com.kh.mocozy.event.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
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
    	return eDao.selecteventlist(sqlSession);
    }
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = eDao.MemberList(sqlSession, clubNo);
		return result;
	}
}
