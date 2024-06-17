package com.kh.mocozy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
		int manageCount = getmlist.size();

		model.addAttribute("getmlist", getmlist);
		model.addAttribute("manageCount", manageCount);

		return "admin/adminManager/adminManager";
	}		

	//전체Ajax
	@ResponseBody
	@RequestMapping(value="adminManagerAjax.ad", produces="application/json; charset=UTF-8")
	public String adminManagerAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, String status, Model model) {  

		ArrayList<Member> mlist = new ArrayList<>();

		//페이지네이션
		int memberAllList = amService.getManagerlist();
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 10, 10);

		//클럽 리스트 불러오기
		mlist = amService.ManagerAll(mi, sortType);

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

		//페이지네이션
		int memberAllList = amService.getManagerSearchlist(map);
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 50, 50);

		//클럽 리스트 불러오기
		mlist = amService.ManagerSearchAll(map, mi);

		return new Gson().toJson(mlist);
	}

	//권한 박탈
	@RequestMapping("adminstatusAjax.ad")
	public String adminstatusAjax(String admin, int userNo, Model model, HttpSession session) {

		HashMap<String, Object> map = new HashMap<>();
        map.put("admin", admin);
        map.put("userNo", userNo);

		int result = amService.adminstatusAjax(map); 

		if (result > 0) {	
			if (admin.equals("N")) {
				session.setAttribute("alertMsg", "관리자 권한 박탈 성공");
				return "redirect:adminManager.ad";
		} else {
			model.addAttribute("errorMsg", "관리자 권한 박탈 실패");
			return "common/errorPage";
        }
	}
		return "admin/adminManager/adminManager";
	}
}
