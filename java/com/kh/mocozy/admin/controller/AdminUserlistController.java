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
import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminUserlistController {
	
    @Autowired
    private AdminUserlistService auService;
    
	//insertManager
	@RequestMapping("insertManager.ad")
	public String showInsertManager(@RequestParam(value="cpage", defaultValue="1") int cpage, Model model) {  
		return "admin/adminManager/insertManager";
  }
	
	//insertManager Ajax
		@ResponseBody
		@RequestMapping(value="insertManagerAjax.ad", produces="application/json; charset=UTF-8")
		public String insertManagerAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String sortType) {  
	        
			//페이지네이션
			int memberAllList = auService.getMemberlist(); 
			//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
			PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
			
			//멤버 리스트 불러오기
			ArrayList<Member> mlist = auService.MemberList(mi, sortType);
	    	
			return new Gson().toJson(mlist);
	    }	
		
		//검색 Ajax
		@ResponseBody
		@RequestMapping(value="insertManagerSearchAjax.ad", produces="application/json; charset=UTF-8")
		public String insertManagerSearchAjax(@RequestParam("keyword") String keyword, @RequestParam("cpage") int currentPage, Model model, String sortType) {  
			
			HashMap<String, String> map = new HashMap<>();
			map.put("keyword", keyword);
			
			//페이지네이션
			int memberAllList = auService.getMemberSearchlist(map); 
			//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
			PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
			
			//멤버 리스트 불러오기
			ArrayList<Member> mlist = auService.MemberSearchList(map, mi);
	    	
			return new Gson().toJson(mlist);
	    }	
		
	/* -------------------------------------- */
	
	//전체
	@RequestMapping("adminUserlist.ad")
	public String adminUserlist(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		ArrayList<Member> getMlist = auService.MemberAllList();
		ArrayList<Member> getActivelist = auService.MemberActiveList();
		ArrayList<Member> getEndlist = auService.MemberEndList();
		int userCount = getMlist.size();
		int activeCount = getActivelist.size();
		int endCount = getEndlist.size();
		
	    model.addAttribute("userCount", userCount);
	    model.addAttribute("activeCount", activeCount);
	    model.addAttribute("endCount", endCount);
	    model.addAttribute("getMlist", getMlist);
	    model.addAttribute("getActivelist", getActivelist);
	    model.addAttribute("getEndlist", getEndlist);
	    model.addAttribute("status", "D");
		
		return "admin/adminUserlist/adminUserlist";
    }	
	
	//전체Ajax
	@ResponseBody
	@RequestMapping(value="adminUserlistAjax.ad", produces="application/json; charset=UTF-8")
	public String adminUserlistAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, String status, Model model) {  
		
		ArrayList<Member> mlist = new ArrayList<>();
        
    	if (status.equals("D")) {
        	//페이지네이션
        	int userlist = auService.getMemberlist();
        	PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
        	
        	//클럽 리스트 불러오기
        	mlist = auService.MemberAll(mi, sortType);
        	
        } else if (status.equals("Y")) {
        	//페이지네이션
            int userlist = auService.getMemberlist(); 
            PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = auService.MemberActive(mi, sortType);
        	
        } else {
        	//페이지네이션
            int userlist = auService.getMemberlist(); 
            PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = auService.MemberEnd(mi, sortType);
        }
    	
		return new Gson().toJson(mlist);
    }	
	
	//검색 Ajax
	@ResponseBody
	@RequestMapping(value="adminUserSearchlistAjax.ad", produces="application/json; charset=UTF-8")
	public String adminUserlistSearchAjax(@RequestParam("keyword") String keyword, @RequestParam("cpage") int currentPage, String sortType, String status, Model model) {  
        
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		
		ArrayList<Member> mlist = new ArrayList<>();
        
    	if (status.equals("N")) {
        	//페이지네이션
        	int userlist = auService.getMemberSearchlist(map);
        	PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
        	
        	//유저 리스트 불러오기
        	mlist = auService.MemberSearchAll(map, mi);
        	
        } else if (status.equals("Y")) {
        	//페이지네이션
            int userlist = auService.getMemberSearchlist(map); 
            PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
            
            //유저 리스트 불러오기
            mlist = auService.MemberSearchActive(map, mi);
        	
        } else {
        	//페이지네이션
            int userlist = auService.getMemberSearchlist(map); 
            PageInfo mi = Pagination.getPageInfo(userlist, currentPage, 10, 10);
            
            //유저 리스트 불러오기
            mlist = auService.MemberSearchEnd(map, mi);
        }
    	
		return new Gson().toJson(mlist);
    }
	
	/* -------------------------------------- */
	
	//활동중
	@RequestMapping("adminUserActive.ad")
	public String adminUserActive(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		ArrayList<Member> getMlist = auService.MemberAllList();
		ArrayList<Member> getActivelist = auService.MemberActiveList();
		ArrayList<Member> getEndlist = auService.MemberEndList();
		int userCount = getMlist.size();
		int activeCount = getActivelist.size();
		int endCount = getEndlist.size();
		
	    model.addAttribute("userCount", userCount);
	    model.addAttribute("activeCount", activeCount);
	    model.addAttribute("endCount", endCount);
	    model.addAttribute("getMlist", getMlist);
	    model.addAttribute("getActivelist", getActivelist);
	    model.addAttribute("getEndlist", getEndlist);
	    model.addAttribute("status", "Y");
		
		return "admin/adminUserlist/adminUserActive";
    }	
	
	//종료
	@RequestMapping("adminUserEnd.ad")
	public String adminUserEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		ArrayList<Member> getMlist = auService.MemberAllList();
		ArrayList<Member> getActivelist = auService.MemberActiveList();
		ArrayList<Member> getEndlist = auService.MemberEndList();
		int userCount = getMlist.size();
		int activeCount = getActivelist.size();
		int endCount = getEndlist.size();
		
	    model.addAttribute("userCount", userCount);
	    model.addAttribute("activeCount", activeCount);
	    model.addAttribute("endCount", endCount);
	    model.addAttribute("getMlist", getMlist);
	    model.addAttribute("getActivelist", getActivelist);
	    model.addAttribute("getEndlist", getEndlist);
	    model.addAttribute("status", "N");
		
		return "admin/adminUserlist/adminUserEnd";
    }	
}
