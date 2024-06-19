package com.kh.mocozy.mainPage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.mainPage.service.MainService;
import com.kh.mocozy.member.model.vo.Member;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


@Controller
public class MainController {
	
	@Autowired
    private MainService mService;
	
	@Autowired
	private AdminNoticeService anService;

	@RequestMapping("/")
	public String showMainPage(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) throws java.text.ParseException {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 6, 6);
	    PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
	    PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);
	    
	    // 날짜 포맷을 이용하여 날짜 문자열을 Date 객체로 변환
	    SimpleDateFormat eventDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	    Date eventDate = eventDateFormat.parse("2024-06-30 22:40:00.0");

	    SimpleDateFormat newEventDateFormat = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분", Locale.KOREA);
	    String newEventDateStr = newEventDateFormat.format(eventDate);

	    SimpleDateFormat newCreateDateFormat = new SimpleDateFormat("M월 d, yyyy", Locale.KOREA);
	    String newCreateDateStr = "6월 19, 2024"; // 예시로 직접 지정한 날짜 문자열

	    // SimpleDateFormat을 사용하여 날짜 문자열을 Date 객체로 변환
	    Date createDate = newCreateDateFormat.parse(newCreateDateStr);
	    
	    
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
	        c.setCreateDateStr(newCreateDateStr);
	        c.setEventDateStr(newEventDateStr);
	    }
	   
	
	  //소셜링 불러오기
	    ArrayList<Club> rlist = mService.getSocialRank(ri);
	    for (Club c : rlist){
    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);   
	        c.setPickCount(mService.getPickedCount(c.getClubNo()));
	    }
	    
	    
	    // 리뷰 top5
	    if (rlist.size() > 5) {
	        rlist = new ArrayList<Club>(rlist.subList(0, 5));
	    }
	    
	    
	  //소셜링 불러오기
	    ArrayList<Club> flist = mService.getSocialView(fi);
	  //소셜링 안의 클럽 불러오기
	    for (Club c : flist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs); 
	        c.setEventDateStr(newEventDateStr);
	    }
	       
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	
	    model.addAttribute("ci", ci);
	    model.addAttribute("ri", ri); 
	    model.addAttribute("fi", fi);

	    model.addAttribute("clist", clist);
	    model.addAttribute("rlist", rlist); 
	    model.addAttribute("flist", flist);
	    
	    model.addAttribute("getnoticeBanner", getnoticeBanner);
	    
	    return "mainPage/mainPage";
	}


	@RequestMapping("challenge.ma")
	public String showchallenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) throws java.text.ParseException {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 6, 6);
	    PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
	    PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);
	    
	    // 날짜 포맷을 이용하여 날짜 문자열을 Date 객체로 변환
	    SimpleDateFormat eventDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	    Date eventDate = eventDateFormat.parse("2024-06-30 22:40:00.0");

	    SimpleDateFormat newEventDateFormat = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분", Locale.KOREA);
	    String newEventDateStr = newEventDateFormat.format(eventDate);

	    SimpleDateFormat newCreateDateFormat = new SimpleDateFormat("M월 d, yyyy", Locale.KOREA);
	    String newCreateDateStr = "6월 19, 2024"; // 예시로 직접 지정한 날짜 문자열

	    // SimpleDateFormat을 사용하여 날짜 문자열을 Date 객체로 변환
	    Date createDate = newCreateDateFormat.parse(newCreateDateStr);
	    
	    //챌린지 불러오기
	    ArrayList<Club> clist = mService.getChallenge(ci);
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
	        c.setCreateDateStr(newCreateDateStr);
	        c.setEventDateStr(newEventDateStr);
	     
		 }
	    
	  //챌린지 불러오기
	    ArrayList<Club> rlist = mService.getChallRank(ri);
	  //소셜링 안의 클럽 불러오기
	    for (Club c : rlist){
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);   
	    }
	     
	    // 리뷰 top5
	    if (rlist.size() > 5) {
	        rlist = new ArrayList<Club>(rlist.subList(0, 5));
	    }
	    
	  //소셜링 불러오기
	    ArrayList<Club> flist = mService.getChallView(fi);
	  //소셜링 안의 클럽 불러오기
	    for (Club c : flist){ 
	    	//클럽 안의 멤버들
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	      //멤버 이미지
	        ArrayList<String> imgs = new ArrayList<String>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs); 
	        c.setPickCount(mService.getPickedCount(c.getClubNo()));
	        c.setEventDateStr(newEventDateStr);
	    }
	    
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    
	    model.addAttribute("ci", ci);
	    model.addAttribute("ri", ri); 
	    model.addAttribute("fi", fi);

	    model.addAttribute("clist", clist);
	    model.addAttribute("rlist", rlist); 
	    model.addAttribute("flist", flist);
	    
	    model.addAttribute("getnoticeBanner", getnoticeBanner);

	    return "mainPage/challenge";
	}
}