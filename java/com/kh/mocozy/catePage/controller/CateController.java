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
public class CateController {

    @Autowired
    private CateService cService;
    
    //전체
	@RequestMapping("cateAll.ct")
	public String showcateAll(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateAll";

    }
	
	//액티비티
	@RequestMapping("cateActivity.ct")
	public String selectActivity(Model model) {    
		ArrayList<Club> catelist = cService.selectActivity();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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

	    return "categories/cateRecent/cateActivity";

    }
	
	//문화
	@RequestMapping("cateArt.ct")
	public String selectArt(Model model) {    
		ArrayList<Club> catelist = cService.selectArt();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateArt";

    }
	
	//자기개발
	@RequestMapping("cateDevelope.ct")
	public String selectDevelope(Model model) {    
		ArrayList<Club> catelist = cService.selectDevelope();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateDevelope";

    }
	
	//푸드 드링크
	@RequestMapping("cateFood.ct")
	public String selectFood(Model model) {    
		ArrayList<Club> catelist = cService.selectFood();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateFood";

    }
	
	//외국어
	@RequestMapping("cateForeign.ct")
	public String selectForeign(Model model) {    
		ArrayList<Club> catelist = cService.selectForeign();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateForeign";

    }
	
	//게임
	@RequestMapping("cateGame.ct")
	public String selectGame(Model model) {    
		ArrayList<Club> catelist = cService.selectGame();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateGame";

    }
	
	//취미
	@RequestMapping("cateHobby.ct")
	public String selectHobby(Model model) {    
		ArrayList<Club> catelist = cService.selectHobby();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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

	    return "categories/cateRecent/cateHobby";

    }
	
	//재테크
	@RequestMapping("cateInvest.ct")
	public String showcateInvest(Model model) {    
		ArrayList<Club> catelist = cService.selectInvest();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateInvest";

    }
	
	//연애
	@RequestMapping("cateLove.ct")
	public String showcateLove(Model model) {    
		ArrayList<Club> catelist = cService.selectLove();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateLove";

    }
	
	//여행
	@RequestMapping("cateTravel.ct")
	public String showcateTravel(Model model) {    
		ArrayList<Club> catelist = cService.selectTravel();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/cateRecent/cateTravel";

    }
}
