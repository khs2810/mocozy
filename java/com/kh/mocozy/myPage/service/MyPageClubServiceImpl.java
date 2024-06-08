package com.kh.mocozy.myPage.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.myPage.model.dao.MyPageClubDao;
import com.kh.mocozy.myPage.model.vo.MyPageClub;

@Service
public class MyPageClubServiceImpl implements MyPageClubService {
	
	@Autowired
	private MyPageClub myPageClubDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<MyPageClub> selectClubList(int uno) {
		return myPageClubDao.selectClubList(sqlSession, uno);
	}
}
