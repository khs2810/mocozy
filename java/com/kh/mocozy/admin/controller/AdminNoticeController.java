package com.kh.mocozy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminNoticeController {
	
    @Autowired
    private AdminNoticeService anService;
    
	 //전체
	@RequestMapping("adminNotice.ad")
	public String adminNotice(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int NoticeAllList = anService.getNoticeCount(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ni = Pagination.getPageInfo(NoticeAllList, currentPage, 5, 5);
		
		//리스트 불러오기
		ArrayList<Notice> nlist = anService.getNoticeAll(ni);
		
		ArrayList<Notice> getNlist = anService.getNoticeAllList();
		ArrayList<Notice> getnoticeEvent = anService.getNoticeEventList();
		ArrayList<Notice> getnoticeBoard = anService.getNoticeBoardList();
		int noticeCount = getNlist.size();
		int noticeEventCount = getnoticeEvent.size();
		int noticeBoardCount = getnoticeBoard.size();
		
		model.addAttribute("getNlist", getNlist);
		model.addAttribute("getnoticeEvent", getnoticeEvent);
		model.addAttribute("noticeBoardCount", noticeBoardCount);
	    model.addAttribute("noticeCount", noticeCount);
	    model.addAttribute("noticeEventCount", noticeEventCount);
	    model.addAttribute("noticeBoardCount", noticeBoardCount);
		model.addAttribute("nlist", nlist);
		
		return "admin/adminNotice/adminNotice";
    }		
	
	 //이벤트
	@RequestMapping("adminNoticeEvent.ad")
	public String adminNoticeEvent(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int NoticeAllList = anService.getNoticeCount(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ni = Pagination.getPageInfo(NoticeAllList, currentPage, 5, 5);
		
		//리스트 불러오기
		ArrayList<Notice> nlist = anService.getNoticeEvent(ni);
		
		ArrayList<Notice> getNlist = anService.getNoticeAllList();
		ArrayList<Notice> getnoticeEvent = anService.getNoticeEventList();
		ArrayList<Notice> getnoticeBoard = anService.getNoticeBoardList();
		int noticeCount = getNlist.size();
		int noticeEventCount = getnoticeEvent.size();
		int noticeBoardCount = getnoticeBoard.size();
		
		model.addAttribute("getNlist", getNlist);
		model.addAttribute("getnoticeEvent", getnoticeEvent);
		model.addAttribute("noticeBoardCount", noticeBoardCount);
	    model.addAttribute("noticeCount", noticeCount);
	    model.addAttribute("noticeEventCount", noticeEventCount);
	    model.addAttribute("noticeBoardCount", noticeBoardCount);
		model.addAttribute("nlist", nlist);
		
		return "admin/adminNotice/adminNoticeEvent";
   }	
	
	 //공지사항
	@RequestMapping("adminNoticeBoard.ad")
	public String adminNoticeBoard(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int NoticeAllList = anService.getNoticeCount(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ni = Pagination.getPageInfo(NoticeAllList, currentPage, 5, 5);
		
		//리스트 불러오기
		ArrayList<Notice> nlist = anService.getNoticeBoard(ni);
		
		ArrayList<Notice> getNlist = anService.getNoticeAllList();
		ArrayList<Notice> getnoticeEvent = anService.getNoticeEventList();
		ArrayList<Notice> getnoticeBoard = anService.getNoticeBoardList();
		int noticeCount = getNlist.size();
		int noticeEventCount = getnoticeEvent.size();
		int noticeBoardCount = getnoticeBoard.size();
		
		model.addAttribute("getNlist", getNlist);
		model.addAttribute("getnoticeEvent", getnoticeEvent);
		model.addAttribute("noticeBoardCount", noticeBoardCount);
	    model.addAttribute("noticeCount", noticeCount);
	    model.addAttribute("noticeEventCount", noticeEventCount);
	    model.addAttribute("noticeBoardCount", noticeBoardCount);
	    model.addAttribute("nlist", nlist);
		
		return "admin/adminNotice/adminNoticeBoard";
   }	
}
