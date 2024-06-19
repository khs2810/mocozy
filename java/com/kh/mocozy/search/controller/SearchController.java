package com.kh.mocozy.search.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class SearchController {

	@Autowired
	private SearchService sService;
	
    @Autowired
    private AdminNoticeService anService;
    
	@GetMapping("searchForm.sc")
	public String searchForm(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {

		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		
		int clubCount = sService.searchForm(map);
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    
		model.addAttribute("keyword", keyword);
		model.addAttribute("clubCount", clubCount);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		return "search/searchMain";
	}

	//검색
	@ResponseBody
	@GetMapping(value="searchFormAjax.sc", produces="application/json; charset=UTF-8")
	public String searchFormAjax(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, String order, Model model, HttpSession session) {

	    HashMap<String, String> map = new HashMap<>();
	    map.put("keyword", keyword);
	    map.put("order", order);
	    
	    // 키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
	    int clubCount = sService.searchForm(map);
	    PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 8, 8);
	    
	    if (clubCount > 0) {
	        ArrayList<Club> clist = sService.searchFormAjax(map, re);
	        for (Club c : clist) {
	            ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
	            ArrayList<String> imgs = new ArrayList<>();
	            for (Member m : memberList) {
	                imgs.add(m.getProfileImg());
	            }
	            c.setProfileImg(imgs);
	        }
	        return new Gson().toJson(clist); // 검색된 클럽 수를 JSON으로 반환
	    } else if (clubCount == 0) {
	        session.setAttribute("alertMsg", "검색 결과가 없습니다");
	    } else {
	        model.addAttribute("errorMsg", "검색 실패");
	        return "common/errorPage"; // 그 외의 경우 에러 페이지를 반환
	    }
	    return new Gson().toJson(clubCount); // 검색된 클럽 수를 JSON으로 반환
	}
}



