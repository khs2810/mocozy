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
public class EventPickController {

    @Autowired
    private EventService eService;

	@RequestMapping("eventArtPick.ev")
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
	    
	    return "eventPick/eventArtPick";

    }
	
	@RequestMapping("eventDessertPick.ev")
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

	    return "eventPick/eventDessertPick";

    }
	
	@RequestMapping("eventGamePick.ev")
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
	    
	    return "eventPick/eventGamePick";

    }
	
	@RequestMapping("eventPartyPick.ev")
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
	    
	    return "eventPick/eventPartyPick";

    }
	
	@RequestMapping("eventPhotoPick.ev")
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
	    
	    return "eventPick/eventPhotoPick";

    }
	
	@RequestMapping("eventStudyPick.ev")
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
	    
	    return "eventPick/eventStudyPick";

    }
	
	@RequestMapping("eventTravelPick.ev")
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
	    
	    return "eventPick/eventTravelPick";

    }
	
	@RequestMapping("eventLovePick.ev")
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
	    
	    return "eventPick/eventLovePick";

    }
}