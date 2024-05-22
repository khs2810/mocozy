package com.kh.mocozy.club.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;

@Service
public class ClubServiceImpl implements ClubService { 
	
	@Autowired
	private ClubDao clubDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int increaseCount(int cno) {
		return clubDao.increaseCount(sqlSession, cno);
	}

	@Override
	public Club selectClub(int cno) {
		return clubDao.selectClub(sqlSession, cno);
	}

	@Override
	public ArrayList<ClubReview> listReview(int cno) {
		return clubDao.listReview(sqlSession, cno);
	}
	
	
}
