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
import com.kh.mocozy.admin.service.AdminManagerlistService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminManagerController {
	
    @Autowired
    private AdminManagerlistService amService;
    
	 //전체
	@RequestMapping("adminManager.ad")
	public String showAdminManager(@RequestParam(value="cpage", defaultValue="1") int cpage, String sortType, Model model) {  
		
		//카테고리별로 사이즈 구하기
		ArrayList<Member> getmlist = amService.MemberAllList();
		ArrayList<Member> getActivelist = amService.MemberActiveList();
		ArrayList<Member> getEndlist = amService.MemberEndList();
		int manageCount = getmlist.size();
		int manageActiveCount = getActivelist.size();
		int manageEndCount = getEndlist.size();
		
		model.addAttribute("getmlist", getmlist);
		model.addAttribute("getActivelist", getActivelist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("manageCount", manageCount);
		model.addAttribute("manageActiveCount", manageActiveCount);
		model.addAttribute("manageEndCount", manageEndCount);
		model.addAttribute("status", "D");

		return "admin/adminManager/adminManager";
    }		
	
	//전체Ajax
	@ResponseBody
	@RequestMapping(value="adminManagerAjax.ad", produces="application/json; charset=UTF-8")
	public String adminManagerAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, String status, Model model) {  
       
		ArrayList<Member> mlist = new ArrayList<>();
        
    	if (status.equals("D")) {
        	//페이지네이션
        	int memberAllList = amService.getManagerlist();
        	PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
        	
        	//클럽 리스트 불러오기
        	mlist = amService.ManagerAll(mi, sortType);
        	
        } else if (status.equals("Y")) {
        	//페이지네이션
            int memberAllList = amService.getManagerlist(); 
            PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = amService.ManagerActive(mi, sortType);
        	
        } else {
        	//페이지네이션
            int memberAllList = amService.getManagerlist(); 
            PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = amService.ManagerEnd(mi, sortType);
        }
    	
        System.out.println(currentPage);	
		
		return new Gson().toJson(mlist);
   }	
	
	//검색Ajax
	@ResponseBody
	@RequestMapping(value="adminManagerSearchAjax.ad", produces="application/json; charset=UTF-8")
	public String adminManagerSearchAjax(@RequestParam("keyword") String keyword, @RequestParam("cpage") int currentPage, String sortType, String status, Model model) {  
       
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sortType", sortType);
		
		ArrayList<Member> mlist = new ArrayList<>();
        
    	if (status.equals("D")) {
        	//페이지네이션
        	int memberAllList = amService.getManagerSearchlist(map);
        	PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
        	
        	//클럽 리스트 불러오기
        	mlist = amService.ManagerSearchAll(map, mi);
        	
        } else if (status.equals("Y")) {
        	//페이지네이션
            int memberAllList = amService.getManagerSearchlist(map); 
            PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = amService.ManagerSearchActive(map, mi);
        	
        } else {
        	//페이지네이션
            int memberAllList = amService.getManagerSearchlist(map); 
            PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            mlist = amService.ManagerSearchEnd(map, mi);
        }
    	
        System.out.println(currentPage);	
		
		return new Gson().toJson(mlist);
   }
	
	/* -------------------------- */
	
	 //활동중
	@RequestMapping("adminManagerActive.ad")
	public String showManagerActive(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		ArrayList<Member> getmlist = amService.MemberAllList();
		ArrayList<Member> getActivelist = amService.MemberActiveList();
		ArrayList<Member> getEndlist = amService.MemberEndList();
		int manageCount = getmlist.size();
		int manageActiveCount = getActivelist.size();
		int manageEndCount = getEndlist.size();
		
		model.addAttribute("getmlist", getmlist);
		model.addAttribute("getActivelist", getActivelist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("manageCount", manageCount);
		model.addAttribute("manageActiveCount", manageActiveCount);
		model.addAttribute("manageEndCount", manageEndCount);
		model.addAttribute("status", "Y");
		
		return "admin/adminManager/adminManagerActive";
   }	
	
	/* ---------------------------- */
	
	 //종료
	@RequestMapping("adminManagerEnd.ad")
	public String showManagerEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

		ArrayList<Member> getmlist = amService.MemberAllList();
		ArrayList<Member> getActivelist = amService.MemberActiveList();
		ArrayList<Member> getEndlist = amService.MemberEndList();
		int manageCount = getmlist.size();
		int manageActiveCount = getActivelist.size();
		int manageEndCount = getEndlist.size();
		
		model.addAttribute("getmlist", getmlist);
		model.addAttribute("getActivelist", getActivelist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("manageCount", manageCount);
		model.addAttribute("manageActiveCount", manageActiveCount);
		model.addAttribute("manageEndCount", manageEndCount);
		model.addAttribute("status", "N");
		
		return "admin/adminManager/adminManagerEnd";
  }		

}
