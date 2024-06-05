package com.kh.mocozy.event.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.event.service.EventService;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class EventController {

    @Autowired
    private EventService eService;
    
    //문화
	@RequestMapping("eventArt.ev")
	public String showeventArt(Model model) {    
		ArrayList<Club> eventlist = eService.selectArt();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventArt";

    }

	//문화Ajax
	@RequestMapping(value="eventArtAjax.ev", produces="application/json; charset=UTF-8")
	public String eventArtAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		   
		ArrayList<Club> eventlist = eService.selectArt();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//푸드
	@RequestMapping("eventDessert.ev")
	public String showeventDessert(Model model) {    
		ArrayList<Club> eventlist = eService.selectFood();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
	    model.addAttribute("eventlist", eventlist);

	    return "event/eventDessert";

    }

	//푸드Ajax
	@RequestMapping(value="eventDessertAjax.ev", produces="application/json; charset=UTF-8")
	public String eventDessertAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		   
		ArrayList<Club> eventlist = eService.selectFood();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
	    model.addAttribute("eventlist", eventlist);

	    return new Gson().toJson(eventlist);

    }
	
	/* --------------------- */

	//게임
	@RequestMapping("eventGame.ev")
	public String showeventGame(Model model) {    
		ArrayList<Club> eventlist = eService.selectGame();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventGame";

    }

	//게임Ajax
	@RequestMapping(value="eventGameAjax.ev", produces="application/json; charset=UTF-8")
	public String eventGameAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		 
		ArrayList<Club> eventlist = eService.selectGame();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//파티
	@RequestMapping("eventParty.ev")
	public String showeventParty(Model model) {    
		ArrayList<Club> eventlist = eService.selectGame();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventParty";

    }

	//파티Ajax
	@RequestMapping(value="eventPartyAjax.ev", produces="application/json; charset=UTF-8")
	public String eventPartyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		  
		ArrayList<Club> eventlist = eService.selectGame();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//사진
	@RequestMapping("eventPhoto.ev")
	public String showeventPhoto(Model model) {    
		ArrayList<Club> eventlist = eService.selectHobby();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventPhoto";

    }
	
	//사진Ajax
	@RequestMapping(value="eventPhotoAjax.ev", produces="application/json; charset=UTF-8")
	public String eventPhotoAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		   
		ArrayList<Club> eventlist = eService.selectHobby();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//자기개발
	@RequestMapping("eventStudy.ev")
	public String showeventStudy(Model model) {    
		ArrayList<Club> eventlist = eService.selectForeign();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventStudy";

    }
	
	//자기개발Ajax
	@RequestMapping(value="eventStudyAjax.ev", produces="application/json; charset=UTF-8")
	public String eventStudyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		 
		ArrayList<Club> eventlist = eService.selectForeign();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//여행
	@RequestMapping("eventTravel.ev")
	public String showeventTravel(Model model) {    
		ArrayList<Club> eventlist = eService.selectTravel();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventTravel";

    }

	//여행Ajax
	@RequestMapping(value="eventTravelAjax.ev", produces="application/json; charset=UTF-8")
	public String eventTravelAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		 
		ArrayList<Club> eventlist = eService.selectTravel();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
		
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }

	/* --------------------- */

	//사랑
	@RequestMapping("eventLove.ev")
	public String showeventLove(Model model) {    
		ArrayList<Club> eventlist = eService.selectLove();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
	    
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventLove";
	}
		
	//사랑Ajax
	@RequestMapping(value="eventLoveAjax.ev", produces="application/json; charset=UTF-8")
	public String eventLoveAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {      
		int cateAllList = eService.getEventlist(); 

		PageInfo ci = Pagination.getPageInfo(cateAllList, currentPage, 12, 4);
		  
		ArrayList<Club> eventlist = eService.selectLove();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
	    // 클럽 리스트를 ClubNo가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getClubNo(), c1.getClubNo());
	        }
	    });
	    
		model.addAttribute("ci", ci);
		model.addAttribute("eventlist", eventlist);
	    
	    return new Gson().toJson(eventlist);

    }
}