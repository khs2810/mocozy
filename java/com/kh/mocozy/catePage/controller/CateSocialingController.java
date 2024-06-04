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

import com.kh.mocozy.catePage.service.CateService;
import com.kh.mocozy.club.model.vo.Club;
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateSocialing/cateRecent";

    }
}
