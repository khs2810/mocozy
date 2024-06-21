package com.kh.mocozy.search.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.search.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService sService;
	@Autowired
	private AdminNoticeService anService;
	
	//서치
	@GetMapping("searchForm.sc")
	public String searchForm(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		int clubCount = sService.searchForm(map);
		ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
		model.addAttribute("keyword", keyword);
		model.addAttribute("clubCount", clubCount);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		return "search/searchMain";
	}
	
	//서치 ajax
	@ResponseBody
	@GetMapping(value="searchFormAjax.sc", produces="application/json; charset=UTF-8")
	public String searchFormAjax(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, String order, Model model, HttpSession session) {
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("order", order);
		int clubCount = sService.searchForm(map);
		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 8, 8);

			ArrayList<Club> clist = sService.searchFormAjax(map, re);
			for (Club c : clist) {
				ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
				ArrayList<String> imgs = new ArrayList<>();
				for (Member m : memberList) {
					imgs.add(m.getProfileImg());
				}
				c.setProfileImg(imgs);
			}
			return new Gson().toJson(clist);
		}
	}



