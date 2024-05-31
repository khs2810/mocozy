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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateAll";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);

	    return "cateRecent/cateActivity";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateArt";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateDevelope";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateFood";

    }
	
	/* 수정해야함 */
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateForeign";

    }
	
	/* 수정해야함 */
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateGame";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	   
		model.addAttribute("catelist", catelist);

	    return "cateRecent/cateHobby";

    }
	
	
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
		
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateInvest";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateLove";

    }
	
	@RequestMapping("cateReview.ct")
	public String showcateReview(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateReview";

    }
	
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
	    
		//Club의 count 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
		model.addAttribute("catelist", catelist);
	    
	    return "cateRecent/cateTravel";

    }
}
