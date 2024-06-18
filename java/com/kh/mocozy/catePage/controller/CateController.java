package com.kh.mocozy.catePage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.catePage.service.CateService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class CateController {

    @Autowired
    private CateService cService;
    
    @Autowired
    private AdminNoticeService anService;
    
    //전체
	@RequestMapping("cateAll.ct")
	public String showcateAll(@RequestParam(value="cpage", defaultValue="1") int currentPage, String order, Model model) {  

		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> catelist = cService.selectcateAll(pi, order);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
	    String orderby = "";
	    if (order.equals("club_no")) {
	    	orderby = "클럽번호";
	    } else if(order.equals("pickCount"))  {
	    	orderby = "찜수";
	    } else if(order.equals("count")) {
	    	orderby= "조회수";
	    } 
	    
	    model.addAttribute("orderby", orderby);
	    model.addAttribute("order", order);
		model.addAttribute("catelist", catelist);
	    
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (cateAllList == 0) {
			return "common/errorPage";
		} else {
	    return "categories/cateView/cateAll";
		}
    }

	//전체Ajax
	@ResponseBody
	@RequestMapping(value="cateAllAjax.ct", produces="application/json; charset=UTF-8")
	public String cateAllAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String order, Model model) {    
		
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = cService.selectcateAll(pi, order);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
		return new Gson().toJson(catelist);
	}


	/* --------------------- */

	//카테고리별 페이지
	@RequestMapping("cateKey.ct")
	public String cateKey(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key, String order) { 
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		map.put("order", order);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.selectCateFilter(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
			ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
			//회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
	    String cname = "";
	    if (key.equals("문화, 예술") || key.equals("푸드, 드링크")) {
	    	cname = "문화생활";
	    } else if(key.equals("자기계발") || key.equals("재테크") || key.equals("외국어"))  {
	    	cname = "미래발전";
	    } else if(key.equals("액티비티") || key.equals("여행 · 동행")) {
	    	cname= "스포츠";
	    } else if(key.equals("취미") || key.equals("파티  · 게임")) {
	    	cname="취미";
	    }
	    
	   
	    model.addAttribute("cname", cname);
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
	    
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (cateAllList == 0) {
			return "common/errorPage";
		} else {
			return "categories/cateView/cateKey";
		}
    }

	//카테고리별 ajax
	@ResponseBody
	@RequestMapping(value="cateKeyAjax.ct", produces="application/json; charset=UTF-8")
	public String cateKeyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key, String order) {      
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		map.put("order", order);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.selectCateFilter(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	        
		 //한번더 형식 변경
		Date date = c.getCreateDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(date);
		
		}
		
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		
	    return new Gson().toJson(catelist);

    }
	
	/* --------------------- */
	
	//인기순별 페이지
	@RequestMapping("catePick.ct")
	public String catePick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) { 
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.catePick(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
			ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
			//회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (cateAllList == 0) {
			return "common/errorPage";
		} else {
			return "categories/cateBest/catePick";
		}
    }
	
	//인기순별 ajax
	@ResponseBody
	@RequestMapping(value="catePickAjax.ct", produces="application/json; charset=UTF-8")
	public String catePickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) {      
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.catePick(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
		
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		
	    return new Gson().toJson(catelist);

	}
	
	/* --------------------- */
	
	//최신별 페이지
	@RequestMapping("cateRecent.ct")
	public String cateRecent(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) { 
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.cateRecent(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
			ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
			//회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
		
		if (cateAllList == 0) {
			return "common/errorPage";
		} else {
			return "categories/cateBest/cateRecent";
		}
    }
	
	//최신순별 ajax
	@ResponseBody
	@RequestMapping(value="cateRecentAjax.ct", produces="application/json; charset=UTF-8")
	public String cateRecentAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) {      
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.cateRecent(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    	
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
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		
	    return new Gson().toJson(catelist);

	}
	
	/* --------------------- */
	
	//조회순별 페이지
	@RequestMapping("cateView.ct")
	public String cateView(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) { 
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.cateView(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
			ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
			//회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
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
	    
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		model.addAttribute("getnoticeBanner", getnoticeBanner);
	    
		if (cateAllList == 0) {
			return "common/errorPage";
		} else {
			return "categories/cateBest/cateView";
		}
    }
	
	//조회순별 ajax
	@ResponseBody
	@RequestMapping(value="cateViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key) {      
		//페이지네이션
		int cateAllList = cService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
	    //map으로 key=카테고리와 order=정렬 값 불러오기
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		
		//클럽 리스트 불러오기
		ArrayList<Club> catelist = cService.cateView(map, pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);   
		    
		 // createDate 형식 변경
		    SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);
		    try {
		        Date date = null;
				try {
					date = originalFormat.parse(c.getCreateDate().toString());
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        String formattedDate = newFormat.format(date);
		        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
		        c.setCreateDate(sqlDate);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		 }
	    
	    model.addAttribute("key", key);
		model.addAttribute("catelist", catelist);
		
	    return new Gson().toJson(catelist);

	}
	
	/* --------------------- */
}	
