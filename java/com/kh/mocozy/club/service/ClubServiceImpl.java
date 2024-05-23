package com.kh.mocozy.club.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.common.model.vo.Attachment;

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
	
	
	public int insertClub(Club c, Attachment at) {
		
		int result1 = clubDao.insertClub(sqlSession, c);
		int result2 = 1;
		
		if (result1 > 0) {
			result2 = clubDao.insertAttachment(sqlSession, at);			
		}
		
		return result1 * result2;
	}

	@Override
	public int insertChMember(Club c) {
		return clubDao.insertChMember(sqlSession, c);
	}
}
