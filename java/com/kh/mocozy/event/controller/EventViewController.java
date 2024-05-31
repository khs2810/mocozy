package com.kh.mocozy.event.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.event.service.EventService;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class EventViewController {

    @Autowired
    private EventService eService;

	@RequestMapping("eventArtView.ev")
	public String showeventArt(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventArt";

    }
	
	@RequestMapping("eventDessertView.ev")
	public String showeventDessert(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
	    model.addAttribute("eventlist", eventlist);

	    return "eventView/eventDessert";

    }
	
	@RequestMapping("eventGameView.ev")
	public String showeventGame(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventGame";

    }
	
	@RequestMapping("eventPartyView.ev")
	public String showeventParty(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventParty";

    }
	
	@RequestMapping("eventPhotoView.ev")
	public String showeventPhoto(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventPhoto";

    }
	
	@RequestMapping("eventStudyView.ev")
	public String showeventStudy(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventStudy";

    }
	
	@RequestMapping("eventTravelView.ev")
	public String showeventTravel(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventTravel";

    }
	
	@RequestMapping("eventLoveView.ev")
	public String showeventLove(Model model) {    
		ArrayList<Club> eventlist = eService.selecteventlist();
		for (Club c : eventlist){
		    ArrayList<Member> memberList = eService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("eventlist", eventlist);
	    
	    return "eventView/eventLove";

    }
}