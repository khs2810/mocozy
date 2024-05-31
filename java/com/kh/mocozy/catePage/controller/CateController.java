package com.kh.mocozy.catePage.controller;

import java.util.ArrayList;
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
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.mainPage.service.MainService;
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
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateAll";

    }
	
	@RequestMapping("cateActivity.ct")
	public String showcateActivity(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);

	    return "categories/cateActivity";

    }
	
	@RequestMapping("cateArt.ct")
	public String showcateArt(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateArt";

    }
	
	@RequestMapping("cateBest20.ct")
	public String showcateBest20(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateBest20";

    }
	
	@RequestMapping("cateDevelope.ct")
	public String showcateDevelope(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateDevelope";

    }
	
	@RequestMapping("cateFood.ct")
	public String showcateFood(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateFood";

    }
	
	@RequestMapping("cateForeign.ct")
	public String showcateForeign(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateForeign";

    }
	
	@RequestMapping("cateGame.ct")
	public String showcateGame(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateGame";

    }
	
	@RequestMapping("cateHobby.ct")
	public String showcateHobby(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);

	    return "categories/cateHobby";

    }
	
	@RequestMapping("cateHot.ct")
	public String showcateHot(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateHot";

    }
	
	@RequestMapping("cateInvest.ct")
	public String showcateInvest(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateInvest";

    }
	
	@RequestMapping("cateLove.ct")
	public String showcateLove(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateLove";

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
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateReview";

    }
	
	@RequestMapping("cateTravel.ct")
	public String showcateTravel(Model model) {    
		ArrayList<Club> catelist = cService.selectcatelist();
		for (Club c : catelist){
		    ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
	    
		model.addAttribute("catelist", catelist);
	    
	    return "categories/cateTravel";

    }
}
