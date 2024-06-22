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

	// 메인 페이지 수정
	@RequestMapping("/")
	public String showMainPage(@RequestParam(value = "cpage", defaultValue = "1") int currentPage, Model model) throws java.text.ParseException {
	    int socialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(socialList, currentPage, 6, 6);
	    PageInfo ri = Pagination.getPageInfo(socialList, currentPage, 5, 5);
	    PageInfo fi = Pagination.getPageInfo(socialList, currentPage, 5, 2);

	    //소셜링 데이터 가져오기
	    ArrayList<Club> clist = mService.getSocialing(ci);
	    ArrayList<Club> rlist = mService.getSocialRank(ri);
	    ArrayList<Club> flist = mService.getSocialView(fi);
	    
	    SimpleDateFormat newEventDateFormat = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분", Locale.KOREA);

	    // 날짜 포맷 설정
	    SimpleDateFormat newCreateDateFormat = new SimpleDateFormat("M월 d, yyyy", Locale.KOREA);

	    // 데이터 처리
	    processClubData(clist, newEventDateFormat, newCreateDateFormat);
	    processClubData(rlist, newEventDateFormat, newCreateDateFormat);
	    processClubData(flist, newEventDateFormat, newCreateDateFormat);

	    // 이벤트 배너 가져오기
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

	// 챌린지 페이지 수정
	@RequestMapping("challenge.ma")
	public String showchallenge(@RequestParam(value = "cpage", defaultValue = "1") int currentPage, Model model) throws java.text.ParseException {
	    int socialList = mService.selectSocialList();

	    PageInfo ci = Pagination.getPageInfo(socialList, currentPage, 6, 6);
	    PageInfo ri = Pagination.getPageInfo(socialList, currentPage, 5, 5);
	    PageInfo fi = Pagination.getPageInfo(socialList, currentPage, 5, 2);

	    // 챌린지 데이터 가져오기
	    ArrayList<Club> clist = mService.getChallenge(ci);
	    ArrayList<Club> rlist = mService.getChallRank(ri);
	    ArrayList<Club> flist = mService.getChallView(fi);
	    
	    SimpleDateFormat newEventDateFormat = new SimpleDateFormat("yyyy년 M월 d일 a h시 m분", Locale.KOREA);

	    // 날짜 포맷 설정
	    SimpleDateFormat newCreateDateFormat = new SimpleDateFormat("M월 d, yyyy", Locale.KOREA);

	    // 데이터 처리
	    processClubData(clist, newEventDateFormat, newCreateDateFormat);
	    processClubData(rlist, newEventDateFormat, newCreateDateFormat);
	    processClubData(flist, newEventDateFormat, newCreateDateFormat);

	    // 이벤트 배너 가져오기
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

	private void processClubData(ArrayList<Club> clubList, SimpleDateFormat newEventDateFormat, SimpleDateFormat newCreateDateFormat) {
	    for (Club c : clubList) {
	        // 클럽의 createDate를 가져와서 포맷팅
	        Date createDate = c.getCreateDate();
	        String formattedCreateDate = newCreateDateFormat.format(createDate);

	        // 클럽의 eventDate를 가져와서 포맷팅
	        Date eventDate = c.getEventDate();
	        String formattedEventDate = newEventDateFormat.format(eventDate);

	        // 멤버들의 이미지 리스트 설정
	        ArrayList<Member> memberList = mService.MemberList(c.getClubNo());
	        ArrayList<String> imgs = new ArrayList<>();
	        for (Member m : memberList) {
	            imgs.add(m.getProfileImg());
	        }
	        c.setProfileImg(imgs);

	        // 날짜 설정
	        c.setCreateDateStr(formattedCreateDate);
	        c.setEventDateStr(formattedEventDate);
	    }
	}
}