package com.kh.mocozy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.board.service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	@RequestMapping("list.no")
	public String listNotice() {
		return "notice/noticeListPage";
	}
	
	@RequestMapping("enrollForm.no")
	public String enrollNoticeForm() {
		return "notice/noticeEnrollPage";
	}
	
	@RequestMapping("detail.no")
	public String selectNotice() {
		return "notice/noticeDetailViewPage";
	}
}
