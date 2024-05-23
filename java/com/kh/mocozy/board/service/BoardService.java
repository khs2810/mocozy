package com.kh.mocozy.board.service;

import java.util.ArrayList;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

public interface BoardService {
	//공지사항 총 갯수 가져오기
	int selectNoticeListCount();
	
	//공지사항 페이징처리해서 리스트 가져오기
	ArrayList<Notice> selectNoticeList(PageInfo pi);
	
	//공지사항 조회수 증가
	int increaseCount(int nno);

	Notice selectNotice(int nno);

	int replyListCount(int nno);

}
