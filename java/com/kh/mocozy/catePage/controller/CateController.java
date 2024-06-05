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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.mocozy.catePage.service.CateService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
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

	//전체Ajax
	@RequestMapping(value="cateAllAjax.ct", produces="application/json; charset=UTF-8")
	public String cateAllAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
			
			// 클럽 리스트를 createDate가 최신인 순으로 정렬
			Collections.sort(catelist, new Comparator<Club>() {
				@Override
				public int compare(Club c1, Club c2) {
					return c2.getCreateDate().compareTo(c1.getCreateDate());
				}
			});
			
			model.addAttribute("ci", ci);
			model.addAttribute("catelist", catelist);

			return new Gson().toJson(catelist);
		}


	/* --------------------- */

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

	//액티비티Ajax
	@RequestMapping(value="cateActivityAjax.ct", produces="application/json; charset=UTF-8")
	public String cateActivityAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);

	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

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

	//문화Ajax
	@RequestMapping(value="cateArtAjax.ct", produces="application/json; charset=UTF-8")
	public String cateArtAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

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

	//자기개발Ajax
	@RequestMapping(value="cateDevelopeAjax.ct", produces="application/json; charset=UTF-8")
	public String cateDevelopeAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

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

	//푸드 드링크Ajax
	@RequestMapping(value="cateFoodAjax.ct", produces="application/json; charset=UTF-8")
	public String cateFoodAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
	
	/* --------------------- */

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

	//외국어Ajax
	@RequestMapping(value="cateForeignAjax.ct", produces="application/json; charset=UTF-8")
	public String cateForeignAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
		
	/* --------------------- */

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

	//게임Ajax
	@RequestMapping(value="cateGameAjax.ct", produces="application/json; charset=UTF-8")
	public String cateGameAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
		
	/* --------------------- */

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
	
	//취미Ajax
	@RequestMapping(value="cateHobbyAjax.ct", produces="application/json; charset=UTF-8")
	public String cateHobbyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	   
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);

	    return new Gson().toJson(catelist);

    }
	
	/* --------------------- */

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
	
	//재테크Ajax
	@RequestMapping(value="cateInvestAjax.ct", produces="application/json; charset=UTF-8")
	public String cateInvestAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
		
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
	
	/* --------------------- */

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

	//연애Ajax
	@RequestMapping(value="cateLoveAjax.ct", produces="application/json; charset=UTF-8")
	public String cateLoveAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }

	/* --------------------- */

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

	//여행Ajax
	@RequestMapping(value="cateTravelAjax.ct", produces="application/json; charset=UTF-8")
	public String cateTravelAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
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
		}
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(catelist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("catelist", catelist);
	    
	    return new Gson().toJson(catelist);

    }
}	
