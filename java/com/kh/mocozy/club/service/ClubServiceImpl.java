package com.kh.mocozy.club.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ClubDao;

@Service
public class ClubServiceImpl implements ClubService { 
	
	@Autowired
	private ClubDao clubDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
}
