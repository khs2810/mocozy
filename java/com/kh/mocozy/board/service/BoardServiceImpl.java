package com.kh.mocozy.board.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.dao.BoardDao;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectNoticeListCount() {
		return boardDao.selectNoticeListCount(sqlSession);
	}

	@Override
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		return boardDao.selectNoticeList(sqlSession, pi);
	}

	@Override
	public int increaseCount(int nno) {
		return boardDao.increaseCount(sqlSession, nno);
	}

	@Override
	public Notice selectNotice(int nno) {
		return boardDao.selectNotice(sqlSession, nno);
	}

	@Override
	public int replyListCount(int nno) {
		return boardDao.replyListCount(sqlSession, nno);
	}
	
}
