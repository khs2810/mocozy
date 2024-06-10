package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public interface AdminNoticeService {
	//프로필 사진 가져오기
	ArrayList<Notice> getNoticeAllList(PageInfo ni);
	
	public int getNoticeCount();
}
