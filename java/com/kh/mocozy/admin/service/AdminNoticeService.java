package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public interface AdminNoticeService {
	
	public int getNoticeCount();
	
	//전체
	public ArrayList<Notice> getNoticeAll(PageInfo ni);
	ArrayList<Notice> getNoticeAllList();

	//이벤트
	public ArrayList<Notice> getNoticeEvent(PageInfo ni);
	public ArrayList<Notice> getNoticeEventList();
	
	//공지사항
	public ArrayList<Notice> getNoticeBoard(PageInfo ni);
	public ArrayList<Notice> getNoticeBoardList();

	
	
}
