package com.kh.mocozy.club.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;

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

	@Override
	public ArrayList<Club> listClub(int uno) {
		return clubDao.listClub(sqlSession, uno);
	}

	@Override
	public Club selectClubList(int uno) {
		return clubDao.selectClubList(sqlSession, uno);
	}

	@Override
	public ArrayList<Request> requestList(int cno) {
		return clubDao.selectRequestList(sqlSession, cno);
	}

	@Override
	public int acceptRequest(int rqno) {
		return clubDao.acceptRequest(sqlSession, rqno);
	}

	@Override
	public int insertRequest(Request r) {
		return clubDao.insertRequest(sqlSession, r);
	}

	public int denyRequest(int rqno) {
		return clubDao.denyRequest(sqlSession, rqno);
	}
	
	@Override
	public Attachment selectAttachment(int cno) {
		return clubDao.selectAttachment(sqlSession, cno);
	}

	@Override
	public int updateClub(Club c, Attachment at) {
		int result1 = clubDao.updateClub(sqlSession, c);
		int result2 = 1;
		
		if (result1 > 0) {
			result2 = clubDao.updateAttachment(sqlSession, at);
		}
		
		return result1 * result2;
	}
}
