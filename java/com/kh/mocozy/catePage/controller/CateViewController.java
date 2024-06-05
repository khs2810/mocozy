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
public class CateViewController {

    @Autowired
    private CateService cService;
    
    //전체
	@RequestMapping("cateAllView.ct")
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
	    
	    return "categories/cateView/cateAllView";

    }
	
	//전체Ajax
	@RequestMapping(value="cateAllViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateAllViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//액티비티
	@RequestMapping("cateActivityView.ct")
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

	    return "categories/cateView/cateActivityView";

    }

	//액티비티Ajax
	@RequestMapping(value="cateActivityViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateActivityViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//문화
	@RequestMapping("cateArtView.ct")
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
	    
	    return "categories/cateView/cateArtView";

    }
	
	//문화Ajax
	@RequestMapping(value="cateArtViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateArtViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//자기개발
	@RequestMapping("cateDevelopeView.ct")
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
	    
	    return "categories/cateView/cateDevelopeView";

    }

	//액티비티Ajax
	@RequestMapping(value="cateDevelopeViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateDevelopeViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//푸드 드링크
	@RequestMapping("cateFoodView.ct")
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
	    
	    return "categories/cateView/cateFoodView";

    }

	//액티비티Ajax
	@RequestMapping(value="cateFoodViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateFoodViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//외국어
	@RequestMapping("cateForeignView.ct")
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
	    
	    return "categories/cateView/cateForeignView";

    }

	//액티비티Ajax
	@RequestMapping(value="cateForeignViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateForeignViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//게임
	@RequestMapping("cateGameView.ct")
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
	    
	    return "categories/cateView/cateGameView";

    }

	//액티비티Ajax
	@RequestMapping(value="cateGameViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateGameViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//취미
	@RequestMapping("cateHobbyView.ct")
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

	    return "categories/cateView/cateHobbyView";

    }

	//취미Ajax
	@RequestMapping(value="cateHobbyViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateHobbyViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//자기개발
	@RequestMapping("cateInvestView.ct")
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
	    
	    return "categories/cateView/cateInvestView";

    }

	//자기개발Ajax
	@RequestMapping(value="cateInvestViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateInvestViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//연애
	@RequestMapping("cateLoveView.ct")
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
	    
	    return "categories/cateView/cateLoveView";

    }

	//연애Ajax
	@RequestMapping(value="cateLoveViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateLoveViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

	//여행
	@RequestMapping("cateTravelView.ct")
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
	    
	    return "categories/cateView/cateTravelView";

    }
	//여행Ajax
	@RequestMapping(value="cateTravelViewAjax.ct", produces="application/json; charset=UTF-8")
	public String cateTravelViewAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }	
}
