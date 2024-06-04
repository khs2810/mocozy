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
public class CatePickController {

    @Autowired
    private CateService cService;
    
    //전체
	@RequestMapping("cateAllPick.ct")
	public String showcateAll(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateAllPick";

    }
	
	//전체Ajax
	@RequestMapping(value="cateAllPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateAllPickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
	        c.setPickCount(cService.getPickedCount(c.getClubNo()));
		}
	    
		  //Club의 pickcount 높은 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getPickCount(), c1.getPickCount());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------------- */

	//액티비티
	@RequestMapping("cateActivityPick.ct")
	public String selectActivity(Model model) {    
		ArrayList<Club> catelist = cService.selectActivity();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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

	    return "categories/catePick/cateActivityPick";

    }
	
	//액티비티Ajax
	@RequestMapping(value="cateActivityPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateActivityPickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
			c.setPickCount(cService.getPickedCount(c.getClubNo()));
		}
			
		//Club의 pickcount 높은 순으로 정렬
		Collections.sort(catelist, new Comparator<Club>() {
			@Override
			public int compare(Club c1, Club c2) {
				return Integer.compare(c2.getPickCount(), c1.getPickCount());
			}
		});
			
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	
		return new Gson().toJson(catelist);
	
	}

	/* --------------------------- */

	//문화
	@RequestMapping("cateArtPick.ct")
	public String selectArtAjax(Model model) {    
		ArrayList<Club> catelist = cService.selectArt();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateArtPick";

    }
	
	//문화Ajax
	@RequestMapping(value="cateArtPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateArtPickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
  
		ArrayList<Club> catelist = cService.selectArt();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------------- */

	//자기개발
	@RequestMapping("cateDevelopePick.ct")
	public String selectDevelope(Model model) {    
		ArrayList<Club> catelist = cService.selectDevelope();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateDevelopePick";

    }
	
	//자기개발Ajax
	@RequestMapping(value="cateDevelopePickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateDevelopePick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
  
		ArrayList<Club> catelist = cService.selectDevelope();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* ---------------------- */

	//푸드 드링크
	@RequestMapping("cateFoodPick.ct")
	public String selectFoodAjax(Model model) {    
		ArrayList<Club> catelist = cService.selectFood();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateFoodPick";

    }
	
	//푸드 드링크Ajax
	@RequestMapping(value="cateFoodPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateFoodPickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
 
		ArrayList<Club> catelist = cService.selectFood();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* ---------------------- */

	//외국어
	@RequestMapping("cateForeignPick.ct")
	public String selectForeign(Model model) {    
		ArrayList<Club> catelist = cService.selectForeign();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateForeignPick";

    }
	
	//외국어Ajax
	@RequestMapping(value="cateForeignPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateForeignPickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
 
		ArrayList<Club> catelist = cService.selectForeign();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* ---------------------- */

	//게임
	@RequestMapping("cateGamePick.ct")
	public String selectGame(Model model) {    
		ArrayList<Club> catelist = cService.selectGame();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateGamePick";

    }
	
		//게임Ajax
		@RequestMapping(value="cateGamePickAjax.ct", produces="application/json; charset=UTF-8")
		public String cateGamePick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
			int cateAllList = cService.getClublist(); 
	
			PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
	  
			ArrayList<Club> catelist = cService.selectGame();
			for (Club c : catelist){
				ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
			
			model.addAttribute("ci", ci);
			model.addAttribute("catelist", catelist);
			
			return new Gson().toJson(catelist);
	
		}

	/* ---------------------- */

	//취미
	@RequestMapping("cateHobbyPick.ct")
	public String selectHobby(Model model) {    
		ArrayList<Club> catelist = cService.selectHobby();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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

	    return "categories/catePick/cateHobbyPick";

    }
	
	//취미Ajax
	@RequestMapping(value="cateHobbyPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateHobbyPick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);

		ArrayList<Club> catelist = cService.selectHobby();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	   
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);

	    return new Gson().toJson(catelist);

    }

	/* ---------------------- */

	//재테크
	@RequestMapping("cateInvestPick.ct")
	public String showcateInvest(Model model) {    
		ArrayList<Club> catelist = cService.selectInvest();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateInvestPick";

    }
	
	//재테크Ajax
	@RequestMapping(value="cateInvestPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateInvestPick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
 
		ArrayList<Club> catelist = cService.selectInvest();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }	

	/* ---------------------- */

	//연애
	@RequestMapping("cateLovePick.ct")
	public String showcateLove(Model model) {    
		ArrayList<Club> catelist = cService.selectLove();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateLovePick";

    }
	
	
	//연애Ajax
	@RequestMapping(value="cateLovePickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateLovePick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);

		ArrayList<Club> catelist = cService.selectLove();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* ---------------------- */

	//여행
	@RequestMapping("cateTravelPick.ct")
	public String showcateTravel(Model model) {    
		ArrayList<Club> catelist = cService.selectTravel();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
	    return "categories/catePick/cateTravelPick";

    }

	//여행Ajax
	@RequestMapping(value="cateTravelPickAjax.ct", produces="application/json; charset=UTF-8")
	public String cateTravelPick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = cService.getClublist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
 
		ArrayList<Club> catelist = cService.selectTravel();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
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
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
}

