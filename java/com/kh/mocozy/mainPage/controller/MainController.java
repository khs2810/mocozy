package com.kh.mocozy.mainPage.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.mainPage.service.MainService;


@Controller
public class MainController {
	
	@Autowired
    private MainService mService;
	
	
//	@GetMapping("/main.ma")
//    public String login() {
//        return "mainPage/mainPage";
//    }
	
	@RequestMapping("/")
	public String showMainPage(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 5, 8);
		PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
		PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);

		
	    
		ArrayList<Club> clist = mService.selectClist(ci);
		ArrayList<Club> rlist = mService.selectRlist(ri); 
		ArrayList<Club> flist = mService.selectFlist(fi);
	    
	    model.addAttribute("ci", ci);
		model.addAttribute("ri", ri); 
		model.addAttribute("fi", fi);


	    model.addAttribute("clist", clist);
		model.addAttribute("rlist", rlist); 
		model.addAttribute("flist", flist);

	    
	    System.out.println(clist);
	    System.out.println(clist.size());
	    
		System.out.println(rlist); 
		System.out.println(rlist.size());
		  
		System.out.println(flist); 
		System.out.println(flist.size());
		 

	    return "mainPage/mainPage";
	}
	
	@RequestMapping("challenge.ma")
	public String showchallenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 5, 8);
		PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
		PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);

		
	    
		ArrayList<Club> clist = mService.selectClist(ci);
		ArrayList<Club> rlist = mService.selectRlist(ri); 
		ArrayList<Club> flist = mService.selectFlist(fi);
	    
	    model.addAttribute("ci", ci);
		model.addAttribute("ri", ri); 
		model.addAttribute("fi", fi);


	    model.addAttribute("clist", clist);
		model.addAttribute("rlist", rlist); 
		model.addAttribute("flist", flist);

	    
	    System.out.println(clist);
	    System.out.println(clist.size());
	    
		System.out.println(rlist); 
		System.out.println(rlist.size());
		  
		System.out.println(flist); 
		System.out.println(flist.size());
		 

	    return "mainPage/challenge";
	}
}