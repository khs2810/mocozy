package com.kh.mocozy.event.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String eventArt(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

		//페이지네이션
		int eventAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> catelist = eService.eventArt(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
	    
		if (eventAllList == 0) {
			return "common/errorPage";
		} else {
			return "event/eventArt";
		}
    }

	//문화Ajax
    @ResponseBody
	@RequestMapping(value="eventArtAjax.ev", produces="application/json; charset=UTF-8")
	public String eventArtAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventArt(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//푸드
    @RequestMapping("eventFood.ev")
	public String eventFood(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

		//페이지네이션
		int eventAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> catelist = eService.eventFood(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}

		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
	    
		if (eventAllList == 0) {
			return "common/errorPage";
		} else {
			return "event/eventFood";
		}
    }

	//푸드Ajax
    @ResponseBody
	@RequestMapping(value="eventFoodAjax.ev", produces="application/json; charset=UTF-8")
	public String eventFoodAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventFood(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}
	
	/* --------------------- */

	//게임
    @RequestMapping("eventGame.ev")
   	public String eventGame(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventGame(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventGame";
   		}
       }

	//게임Ajax
    @ResponseBody
	@RequestMapping(value="eventGameAjax.ev", produces="application/json; charset=UTF-8")
	public String eventGameAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventGame(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//파티
    @RequestMapping("eventParty.ev")
   	public String eventParty(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventParty(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventParty";
   		}
       }

	//파티Ajax
    @ResponseBody
	@RequestMapping(value="eventPartyAjax.ev", produces="application/json; charset=UTF-8")
	public String eventPartyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventParty(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//사진
    @RequestMapping("eventPhoto.ev")
   	public String eventPhoto(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventPhoto(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventPhoto";
   		}
      }
	
	//사진Ajax
    @ResponseBody
	@RequestMapping(value="eventPhotoAjax.ev", produces="application/json; charset=UTF-8")
	public String eventPhotoAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventPhoto(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//자기개발
    @RequestMapping("eventStudy.ev")
   	public String studyEvent(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventStudy(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventStudy";
   		}
      }
	
	//자기개발Ajax
    @ResponseBody
	@RequestMapping(value="eventStudyAjax.ev", produces="application/json; charset=UTF-8")
	public String eventStudyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventStudy(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//여행
    @RequestMapping("eventTravel.ev")
   	public String eventTravel(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventTravel(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    
		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventTravel";
   		}
      }

	//여행Ajax
    @ResponseBody
	@RequestMapping(value="eventTravelAjax.ev", produces="application/json; charset=UTF-8")
	public String eventTravelAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventTravel(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}

	/* --------------------- */

	//사랑
    @RequestMapping("eventLove.ev")
   	public String eventLove(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  

   		//페이지네이션
   		int eventAllList = eService.getEventlist(); 
   		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
   		PageInfo pi= Pagination.getPageInfo(eventAllList, currentPage, 4, 4);
   		
   		//클럽 리스트 불러오기
   	    ArrayList<Club> catelist = eService.eventLove(pi);
   		for (Club c : catelist){
   			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
   		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
   		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
   		    ArrayList<String> imgs = new ArrayList<String>();
   		    for (Member m : memberList) {
   		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
   		    	imgs.add(m.getProfileImg());
   		    }
   		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
   		    c.setProfileImg(imgs);    
   		}
   	    

		model.addAttribute("pi", pi);
		model.addAttribute("catelist", catelist);
   	    
   		if (eventAllList == 0) {
   			return "common/errorPage";
   		} else {
   			return "event/eventLove";
   		}
      }

		
	//사랑Ajax
    @ResponseBody
	@RequestMapping(value="eventLoveAjax.ev", produces="application/json; charset=UTF-8")
	public String eventLoveAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {    
		
		//페이지네이션
		int cateAllList = eService.getEventlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo pi= Pagination.getPageInfo(cateAllList, currentPage, 4, 4);
		
		//카테고리 조건 건 클럽 불러오기
	    ArrayList<Club> catelist = eService.eventLove(pi);
		for (Club c : catelist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		}
	    
		return new Gson().toJson(catelist);
	}
}