package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

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
	public ArrayList<Notice> getNoticeAll(PageInfo ni, String sortType) {
		return anDao.getNoticeAll(sqlSession, ni, sortType);
	}

	@Override
	public ArrayList<Notice> getNoticeAllList() {
		return anDao.getNoticeAllList(sqlSession);
	}

	//이벤트
	@Override
	public ArrayList<Notice> getNoticeEvent(PageInfo ni, String sortType) {
		return anDao.getNoticeEvent(sqlSession, ni, sortType);
	}

	@Override
	public ArrayList<Notice> getNoticeEventList() {
		return anDao.getNoticeEventList(sqlSession);
	}

	//공지
	@Override
	public ArrayList<Notice> getNoticeBoard(PageInfo ni, String sortType) {
		return anDao.getNoticeBoard(sqlSession, ni, sortType);
	}

	@Override
	public ArrayList<Notice> getNoticeBoardList() {
		return anDao.getNoticeBoardList(sqlSession);
	}
	
	//배너 리스트
	@Override
	public ArrayList<Notice> getNoticeBanner(PageInfo ni) {
		System.out.println("service: " + ni);
		return anDao.getNoticeBanner(sqlSession, ni);
	}
	
	@Override
	public ArrayList<Notice> getNoticeBannerList() {
		return anDao.getNoticeBannerList(sqlSession);
	}
	
	//검색 리스트
	@Override
	public int getNoticeSearchCount(HashMap<String, String> map) {
		return anDao.getNoticeSearchCount(sqlSession, map);
	}
	
	//전체 검색
	@Override
	public ArrayList<Notice> getNoticeSearchAll(HashMap<String, String> map, PageInfo ni) {
		return anDao.getNoticeSearchAll(sqlSession, map, ni);
	}
	
	//이벤트 검색
	@Override
	public ArrayList<Notice> getNoticeSearchEvent(HashMap<String, String> map, PageInfo ni) {
		return anDao.getNoticeSearchEvent(sqlSession, map, ni);
	}
	
	//공지 검색
	@Override
	public ArrayList<Notice> getNoticeSearchBoard(HashMap<String, String> map, PageInfo ni) {
		return anDao.getNoticeSearchBoard(sqlSession, map, ni);
	}
	
	//배너 설정
	@Override
	public int eventStatusAjax(HashMap<String, Object> map){
		return anDao.eventStatusAjax(sqlSession, map);
	}

}
