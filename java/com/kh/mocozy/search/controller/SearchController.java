package com.kh.mocozy.search.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchList(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);    
		    
		    // createDate 형식 변경
	        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	        try {
	            Date date = originalFormat.parse(c.getCreateDate().toString());
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            c.setCreateDate(sqlDate);
	        } catch (ParseException | java.text.ParseException e) {
	            e.printStackTrace();
	        }
		 }
		
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
	    
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);
		
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (clubCount == 0) { //검색결과 없음
			return "search/searchError";
		} else { //검색결과있음
			return "search/searchMain";
		}
	}

	//검색
	@ResponseBody
	@GetMapping(value="searchFormAjax.sc", produces="application/json; charset=UTF-8")
	public String searchFormAjax(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {

		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchList(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);    
		    
		    // createDate 형식 변경
	        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	        try {
	            Date date = originalFormat.parse(c.getCreateDate().toString());
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            c.setCreateDate(sqlDate);
	        } catch (ParseException | java.text.ParseException e) {
	            e.printStackTrace();
	        }
		 }
		
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
	    
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		return new Gson().toJson(clist);
	}
	
	/* --------------------- */

	//찜순
	@GetMapping("searchPick.sc")
	public String searchFormPick(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchPick(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);
		}
		
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
	    
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (clubCount == 0) { //검색결과 없음
			return "search/searchError";
		} else { //검색결과있음
			return "search/searchPick";
		}
	}

	//찜순Ajax
	@ResponseBody
	@GetMapping(value="searchPickAjax.sc", produces="application/json; charset=UTF-8")
	public String searchPickAjax(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {

		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchPick(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);    
		}
		
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);

		return new Gson().toJson(clist);
	}

	/* --------------------- */

	//조회순
	@GetMapping("searchView.sc")
	public String searchView(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchView(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);    
		}
		
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
	    
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (clubCount == 0) { //검색결과 없음
			return "search/searchError";
		} else { //검색결과있음
			return "search/searchView";
		}
	}

	//조회순Ajax
	@ResponseBody
	@GetMapping(value="searchViewAjax.sc", produces="application/json; charset=UTF-8")
	public String searchViewAjax(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {

		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		//키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
		int clubCount = sService.searchForm(map);

		PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 4, 4);
		ArrayList<Club> clist = sService.selectSearchView(map, re);

		for (Club c : clist){
			ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
			ArrayList<String> imgs = new ArrayList<String>();
			for (Member m : memberList) {
				imgs.add(m.getProfileImg());
			}
			c.setProfileImg(imgs);    
		}
		
		model.addAttribute("clist", clist);
		model.addAttribute("re", re);
		model.addAttribute("keyword", keyword);

		return new Gson().toJson(clist);
	}
}	



