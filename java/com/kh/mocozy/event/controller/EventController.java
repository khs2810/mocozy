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
public class EventController {

    @Autowired
    private EventService eService;

	@RequestMapping("eventArt.ev")
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
	    
	    return "event/eventArt";

    }
	
	@RequestMapping("eventDessert.ev")
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

	    return "event/eventDessert";

    }
	
	@RequestMapping("eventGame.ev")
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
	    
	    return "event/eventGame";

    }
	
	@RequestMapping("eventParty.ev")
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
	    
	    return "event/eventParty";

    }
	
	@RequestMapping("eventPhoto.ev")
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
	    
	    return "event/eventPhoto";

    }
	
	@RequestMapping("eventStudy.ev")
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
	    
	    return "event/eventStudy";

    }
	
	@RequestMapping("eventTravel.ev")
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
	    
	    return "event/eventTravel";

    }
	
	@RequestMapping("eventLove.ev")
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
	    
	    return "event/eventLove";

    }
}