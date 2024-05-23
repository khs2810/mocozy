package com.kh.mocozy.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.board.service.BoardService;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.no")
	public String listNotice(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int noticeListCount = boardService.selectNoticeListCount();
		
		PageInfo pi = Pagination.getPageInfo(noticeListCount, currentPage, 5, 5);
		ArrayList<Notice> list = boardService.selectNoticeList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "notice/noticeListPage";
	}
	
	@RequestMapping("enrollForm.no")
	public String enrollNoticeForm() {
		return "notice/noticeEnrollPage";
	}
	
	@RequestMapping("detail.no")
	public String selectNotice(int nno, Model model) {
		int result = boardService.increaseCount(nno);
		
		if (result > 0) {
			Notice n = boardService.selectNotice(nno);
			int replyListCount = boardService.replyListCount(nno);
			System.out.println(nno);
			System.out.println(replyListCount);
			
			
			
			model.addAttribute("n", n);
			return "notice/noticeDetailViewPage";
		} else {
			model.addAttribute("errorMsg", "공지사항 조회 실패");
			return "common/errorPage";
		}
	}
	
	
}
