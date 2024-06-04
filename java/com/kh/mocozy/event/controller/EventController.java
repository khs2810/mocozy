package com.kh.mocozy.event.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventArt";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
	    model.addAttribute("eventlist", eventlist);

	    return "event/eventDessert";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventGame";

    }
	
	//게임
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventParty";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventPhoto";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventStudy";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventTravel";

    }
	
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
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(eventlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
		model.addAttribute("eventlist", eventlist);
	    
	    return "event/eventLove";

    }
}