package com.kh.mocozy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminUserlistController {
	
    @Autowired
    private AdminUserlistService auService;
    
	//insertManager
	@RequestMapping("insertManager.ad")
	public String showInsertManager(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = auService.MemberList(mi);
		    
		model.addAttribute("mlist", mlist);
		return "admin/adminManager/insertManager";
  }
	
	//전체
	@RequestMapping("adminUserlist.ad")
	public String adminUserlist(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = auService.MemberList(mi);
		
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminUserlist/adminUserlist";
    }	
	
	//활동중
	@RequestMapping("adminUserActive.ad")
	public String adminUserActive(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = auService.MemberActive(mi);
		
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminUserlist/adminUserActive";
    }	
	
	//종료
	@RequestMapping("adminUserEnd.ad")
	public String adminUserEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = auService.MemberEnd(mi);
		
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminUserlist/adminUserEnd";
    }	
}
