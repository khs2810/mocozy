package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public interface AdminNoticeService {
	
	public int getNoticeCount();
	
	//전체
	public ArrayList<Notice> getNoticeAll(PageInfo ni, String sortType);
	ArrayList<Notice> getNoticeAllList();

	//이벤트
	public ArrayList<Notice> getNoticeEvent(PageInfo ni, String sortType);
	public ArrayList<Notice> getNoticeEventList();
	
	//공지사항
	public ArrayList<Notice> getNoticeBoard(PageInfo ni, String sortType);
	public ArrayList<Notice> getNoticeBoardList();
	
	//배너 리스트
	public ArrayList<Notice> getNoticeBanner(PageInfo ni);
	public ArrayList<Notice> getNoticeBannerList();
	
	//검색 리스트
	public int getNoticeSearchCount(HashMap<String, String> map);

	//전체 검색
	public ArrayList<Notice> getNoticeSearchAll(HashMap<String, String> map, PageInfo ni);

	//이벤트 검색
	public ArrayList<Notice> getNoticeSearchEvent(HashMap<String, String> map, PageInfo ni);

	//공지 검색
	public ArrayList<Notice> getNoticeSearchBoard(HashMap<String, String> map, PageInfo ni);
	
	//배너 설정
	public int eventStatusAjax(HashMap<String, Object> map);

	
	
	
	
	
	
	
}
