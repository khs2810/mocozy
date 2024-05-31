package com.kh.mocozy.board.service;

import java.util.ArrayList;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.dao.BoardDao;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.board.model.vo.NoticeReply;
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

	@Override
	public ArrayList<NoticeReply> selectNoticeReplyList(int nno, PageInfo pi) {
		return boardDao.selectNoticeReplyList(sqlSession, nno, pi);
	}

	@Override
	public int insertNotice(Notice n) {
		return boardDao.insertNotice(sqlSession, n);
	}

	@Override
	public int updateNotice(Notice n) {
		return boardDao.updateNotice(sqlSession, n);
	}

	@Override
	public int deleteNotice(int nno) {
		return boardDao.deleteNotice(sqlSession, nno);
	}

	@Override
	public int insertNoticeReply(NoticeReply nr) {
		return boardDao.insertNoticeReply(sqlSession, nr);
	}

	@Override
	public int deleteNoticeReply(int rno) {
		return boardDao.deleteNoticeReply(sqlSession, rno);
	}

	@Override
	public int selectNoticeListCount(Map<String, String> map) {
		return boardDao.selectNoticeListCount(sqlSession, map);
	}

	@Override
	public ArrayList<Notice> selectNoticeListKeyword(Map<String, String> map, PageInfo pi) {
		return boardDao.selectNoticeListKeyword(sqlSession, map, pi);
	}

	
}
