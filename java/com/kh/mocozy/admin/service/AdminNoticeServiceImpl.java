package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminNoticeDao;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService{
	
	@Autowired
	private AdminNoticeDao anDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public int getNoticeCount() {
		return anDao.getNoticeCount(sqlSession);
	}

	//전체
	@Override
	public ArrayList<Notice> getNoticeAll(PageInfo ni) {
		return anDao.getNoticeAll(sqlSession, ni);
	}

	@Override
	public ArrayList<Notice> getNoticeAllList() {
		return anDao.getNoticeAllList(sqlSession);
	}

	//이벤트
	@Override
	public ArrayList<Notice> getNoticeEvent(PageInfo ni) {
		return anDao.getNoticeEvent(sqlSession, ni);
	}

	@Override
	public ArrayList<Notice> getNoticeEventList() {
		return anDao.getNoticeEventList(sqlSession);
	}

	//공지
	@Override
	public ArrayList<Notice> getNoticeBoard(PageInfo ni) {
		return anDao.getNoticeBoard(sqlSession, ni);
	}

	@Override
	public ArrayList<Notice> getNoticeBoardList() {
		return anDao.getNoticeBoardList(sqlSession);
	}

	
}
