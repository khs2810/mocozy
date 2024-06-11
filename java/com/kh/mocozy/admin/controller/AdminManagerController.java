package com.kh.mocozy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.admin.service.AdminManagerlistService;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminManagerController {
	
    @Autowired
    private AdminManagerlistService amService;
    
	 //전체
	@RequestMapping("adminManager.ad")
	public String showAdminManager(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = amService.getManagerlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = amService.ManagerAll(mi);
		
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminManager/adminManager";
    }		
	
	 //활동중
	@RequestMapping("adminManagerActive.ad")
	public String showManagerActive(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = amService.getManagerlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = amService.ManagerActive(mi);
			
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminManager/adminManagerActive";
   }	
	
	 //종료
	@RequestMapping("adminManagerEnd.ad")
	public String showManagerEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = amService.getManagerlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = amService.ManagerEnd(mi);
		
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
		model.addAttribute("mlist", mlist);
		
		return "admin/adminManager/adminManagerEnd";
  }		
}
