package com.kh.mocozy.mainPage.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.mainPage.service.MainService;
import com.kh.mocozy.member.model.vo.Member;


@Controller
public class MainController {
	
	@Autowired
    private MainService mService;
	
	
	@RequestMapping("/")
	public String showMainPage(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 10, 8);
	    PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
	    PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);
	    
	    //소셜링 불러오기
	    ArrayList<Club> clist = mService.getSocialing(ci);
	    //소셜링 안의 클럽 불러오기
	    for (Club c : clist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	    //Club의 count 높은 순으로 정렬
	    Collections.sort(clist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    ArrayList<Club> rlist = mService.getSocialing(ri);
	    for (Club c : rlist){
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	  //Club의 count 높은 순으로 정렬
	    Collections.sort(rlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	        
	    ArrayList<Club> flist = mService.getSocialing(fi);
	    for (Club c : flist){
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
	  //Club의 count 높은 순으로 정렬
	    Collections.sort(flist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    model.addAttribute("ci", ci);
	    model.addAttribute("ri", ri); 
	    model.addAttribute("fi", fi);

	    model.addAttribute("clist", clist);
	    model.addAttribute("rlist", rlist); 
	    model.addAttribute("flist", flist);

	    return "mainPage/mainPage";
	}


	@RequestMapping("challenge.ma")
	public String showchallenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 10, 8);
	    PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
	    PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);
	    
	    ArrayList<Club> clist = mService.getChallenge(ci);
	    for (Club c : clist){
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
		 //Club의 count 높은 순으로 정렬
	    Collections.sort(clist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    ArrayList<Club> rlist = mService.getChallenge(ri);
	    for (Club c : rlist){
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	    
		 //Club의 count 높은 순으로 정렬
	    Collections.sort(rlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    ArrayList<Club> flist = mService.getChallenge(fi);
	    for (Club c : flist){
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);    
	    }
	   
		//Club의 count 높은 순으로 정렬
	    Collections.sort(flist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    model.addAttribute("ci", ci);
	    model.addAttribute("ri", ri); 
	    model.addAttribute("fi", fi);

	    model.addAttribute("clist", clist);
	    model.addAttribute("rlist", rlist); 
	    model.addAttribute("flist", flist);

	    return "mainPage/mainPage";
	}
}