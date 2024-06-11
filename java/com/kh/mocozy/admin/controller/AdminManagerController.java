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
    
	 //10개씩 클럽목록 보기
	@RequestMapping("adminManager.ad")
	public String showAdminClub10(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		
		//페이지네이션
		int memberAllList = amService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		
		//멤버 리스트 불러오기
		ArrayList<Member> mlist = amService.MemberList(mi);
		ArrayList<Member> getmlist = amService.MemberAllList();
		int manageCount = getmlist.size();
		
	    model.addAttribute("manageCount", manageCount);
		model.addAttribute("mlist", mlist);
		model.addAttribute("getmlist", getmlist);
		return "admin/adminManager/adminManager";
    }		
}
