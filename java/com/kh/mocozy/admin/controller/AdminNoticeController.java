package com.kh.mocozy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminNoticeController {
	
    @Autowired
    private AdminNoticeService anService;
    
	 //전체
	@RequestMapping("adminNotice.ad")
	public String adminNotice(@RequestParam(value="cpage", defaultValue="1") int cpage, String sortType, Model model) {  
		
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
	    model.addAttribute("noticeType", "D");
		
		return "admin/adminNotice/adminNotice";
    }		
	
	//전체Ajax
	@ResponseBody
	@RequestMapping(value="adminNoticeAjax.ad", produces="application/json; charset=UTF-8")
	public String adminUserlistAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, String noticeType, Model model) {  
        
		ArrayList<Notice> nlist = new ArrayList<>();
        
    	if (noticeType.equals("D")) {
        	//페이지네이션
        	int notice = anService.getNoticeCount();
        	PageInfo ni = Pagination.getPageInfo(notice, currentPage, 15, 15);
        	
        	//클럽 리스트 불러오기
        	nlist = anService.getNoticeAll(ni, sortType);
        	
        } else if (noticeType.equals("이벤트")) {
        	//페이지네이션
            int notice = anService.getNoticeCount(); 
            PageInfo ni = Pagination.getPageInfo(notice, currentPage, 15, 15);
            
            //클럽 리스트 불러오기
            nlist = anService.getNoticeEvent(ni, sortType);
        	
        } else if (noticeType.equals("공지")){
        	//페이지네이션
            int notice = anService.getNoticeCount(); 
            PageInfo ni = Pagination.getPageInfo(notice, currentPage, 15, 15);
            
            //클럽 리스트 불러오기
            nlist = anService.getNoticeBoard(ni, sortType);
        }
    	
		return new Gson().toJson(nlist);
    }	
	
	//검색 Ajax
	@ResponseBody
	@RequestMapping(value="adminNoticeSearchAjax.ad", produces="application/json; charset=UTF-8")
	public String adminUserlistSearchAjax(@RequestParam("keyword") String keyword, @RequestParam("cpage") int currentPage, String sortType, String noticeType, Model model) {  
        
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sortType", sortType);
		
		System.out.println(noticeType);
		ArrayList<Notice> nlist = new ArrayList<>();
        
    	if (noticeType.equals("D")) {
        	//페이지네이션
        	int notice = anService.getNoticeSearchCount(map);
        	PageInfo ni = Pagination.getPageInfo(notice, currentPage, 60, 60);
        	
        	//클럽 리스트 불러오기
        	nlist = anService.getNoticeSearchAll(map, ni);
        	
        } else if (noticeType.equals("이벤트")) {
        	//페이지네이션
            int notice = anService.getNoticeSearchCount(map); 
            PageInfo ni = Pagination.getPageInfo(notice, currentPage, 60, 60);
            
            //클럽 리스트 불러오기
            nlist = anService.getNoticeSearchEvent(map, ni);
        	
        } else if (noticeType.equals("공지")){
        	//페이지네이션
            int notice = anService.getNoticeSearchCount(map); 
            PageInfo ni = Pagination.getPageInfo(notice, currentPage, 60, 60);
            
            //클럽 리스트 불러오기
            nlist = anService.getNoticeSearchBoard(map, ni);
        }
    	
		return new Gson().toJson(nlist);
    }	
	
	/* ---------------------------------------- */
	
	 //이벤트
	@RequestMapping("adminNoticeEvent.ad")
	public String adminNoticeEvent(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
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
	    model.addAttribute("noticeType", "이벤트");
		
		return "admin/adminNotice/adminNoticeEvent";
   }	
	
	 //공지사항
	@RequestMapping("adminNoticeBoard.ad")
	public String adminNoticeBoard(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
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
	    model.addAttribute("noticeType", "공지");
		
		return "admin/adminNotice/adminNoticeBoard";
   }	
}
