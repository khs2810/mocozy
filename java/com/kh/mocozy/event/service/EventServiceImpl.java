package com.kh.mocozy.event.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.event.model.dao.EventDao;

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
}
