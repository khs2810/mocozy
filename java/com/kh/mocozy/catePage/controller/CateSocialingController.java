package com.kh.mocozy.catePage.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.mocozy.catePage.service.CateService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class CateSocialingController {

    @Autowired
    private CateService cService;
    
    //조회순
	@RequestMapping("cateBest.ct")
	public String cateBest(Model model) {    
		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	    //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	        //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	    // 클럽 리스트를 count가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateSocialing/cateBest";

    }

	//찜순Ajax
	@RequestMapping(value="cateBestSocialingAjax.ct", produces="application/json; charset=UTF-8")
	public String cateBestSocialingAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);

		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	    //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	        //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	    // 클럽 리스트를 count가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
	

	/* --------------------- */

	//찜순
	@RequestMapping("cateHot.ct")
	public String cateHot(Model model) {    
		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	  //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs); 
	        c.setPickCount(cService.getPickedCount(c.getClubNo()));
	    }
	    
	  //Club의 pickcount 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getPickCount(), c1.getPickCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateSocialing/cateHot";

    }

		
	//찜순Ajax
	@RequestMapping(value="cateHotSocialingAjax.ct", produces="application/json; charset=UTF-8")
	public String cateHotSocialingAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);

		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	  //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs); 
	        c.setPickCount(cService.getPickedCount(c.getClubNo()));
	    }
	    
	  //Club의 pickcount 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getPickCount(), c1.getPickCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//최신순
	@RequestMapping("cateRecent.ct")
	public String cateRecent(Model model) {    
		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	    //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	        //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateSocialing/cateRecent";

    }

	//찜순Ajax
	@RequestMapping(value="cateRecentSocialingAjax.ct", produces="application/json; charset=UTF-8")
	public String cateRecentSocialingAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);

		//소셜링 불러오기
	    ArrayList<Club> catelist = cService.getSocialing();
	    //소셜링 안의 클럽 불러오기
	    for (Club c : catelist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
	        //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
}
