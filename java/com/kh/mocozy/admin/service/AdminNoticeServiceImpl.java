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

	@Override
	public ArrayList<Notice> getNoticeList(PageInfo ni) {
		return anDao.getNoticeList(sqlSession, ni);
	}

	@Override
	public ArrayList<Notice> getNoticeAllList() {
		return anDao.getNoticeAllList(sqlSession);
	}
}
