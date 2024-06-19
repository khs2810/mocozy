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
	public String showMainPage(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 6, 6);
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

	    
	 // createDate 형식 변경
        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        try {
            Date date = originalFormat.parse(c.getCreateDate().toString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            c.setCreateDate(sqlDate);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
	   }
	    
	  //소셜링 불러오기
	    ArrayList<Club> rlist = mService.getSocialRank(ri);
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
	        c.setPickCount(mService.getPickedCount(c.getClubNo()));
	    }
	    
		  //Club의 pickcount 높은 순으로 정렬
	    Collections.sort(rlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getPickCount(), c1.getPickCount());
	        }
	    });
	     
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
	    }
	    
	    // 클럽 리스트를 count가 높은 순으로 정렬
	    Collections.sort(flist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
		
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
	public String showchallenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
	    int SocialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(SocialList, currentPage, 6, 6);
	    PageInfo ri = Pagination.getPageInfo(SocialList, currentPage, 5, 5); 
	    PageInfo fi = Pagination.getPageInfo(SocialList, currentPage, 5, 2);
	    
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
	        
	   	 // createDate 형식 변경
	        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	        try {
	            Date date = originalFormat.parse(c.getCreateDate().toString());
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            c.setCreateDate(sqlDate);
	        } catch (ParseException | java.text.ParseException e) {
	            e.printStackTrace();
	        }
		 }
	    
	    // 클럽 리스트를 createDate가 최신인 순으로 정렬
	    Collections.sort(clist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return c2.getCreateDate().compareTo(c1.getCreateDate());
	        }
	    });
	    
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
	    
		  //Club의 pickcount 높은 순으로 정렬
	    Collections.sort(rlist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getPickCount(), c1.getPickCount());
	        }
	    });
	     
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
	    }
	    
	    //이벤트 가져오기
	    ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
	    // 각 Notice 객체에서 noticeNo 가져오기
	    for (Notice notice : getnoticeBanner) {
	        int noticeNo = notice.getNoticeNo();
	        String bannerPath = notice.getBannerPath();
	    }
	    
	    // 클럽 리스트를 count가 높은 순으로 정렬
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
	    
	    model.addAttribute("getnoticeBanner", getnoticeBanner);

	    return "mainPage/challenge";
	}
}