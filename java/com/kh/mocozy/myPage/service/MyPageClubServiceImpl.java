package com.kh.mocozy.myPage.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.myPage.model.dao.MyPageClubDao;
import com.kh.mocozy.myPage.model.vo.MyPageClub;

@Service
public class MyPageClubServiceImpl implements MyPageClubService {
	
	@Autowired
	private MyPageClubDao myPageClubDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyPageClub> myPageClub(MyPageClub myPageClub) {
		return myPageClubDao.myPageClub(sqlSession, myPageClub);
	}
	
	@Override
	public List<MyPageClub> myPageClubPicked(MyPageClub myPageClub) {
		return myPageClubDao.myPageClubPicked(sqlSession, myPageClub);
	}
	
	
}
