package com.kh.mocozy.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.admin.service.AdminClubService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class AdminClubController {
	
    @Autowired
    private AdminClubService acService;
    
    //전체
    @RequestMapping("adminClub.ad")
    public String adminClub(@RequestParam(value="cpage", defaultValue="1") int cpage, String sortType, Model model) {
    	ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getApprovelist = acService.getClubApproveList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubApproveCount = getApprovelist.size();
		
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("getApprovelist", getApprovelist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
		model.addAttribute("clubApproveCount", clubApproveCount);
    	
    	return "admin/adminClub/adminClub";
    }
	
    //전체Ajax
    @ResponseBody
    @RequestMapping(value="adminClubAjax.ad", produces="application/json; charset=UTF-8")
	public String adminClubAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

        //페이지네이션
        int clubAllList = acService.getClublist();
        PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
        
        //클럽 리스트 불러오기
        ArrayList<Club> clist = acService.selectClublist(ci, sortType);
        for (Club c : clist){
            ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);

            // modifyDate 형식 변경
            SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            try {
                Date date = originalFormat.parse(c.getModifyDate().toString());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                c.setModifyDate(sqlDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Gson().toJson(clist);
    }
    
	/* --------------------- */

	//진행중 클럽목록
	@RequestMapping("adminProcess.ad")
	public String adminProcess(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

		//페이지네이션
		int clubAllList = acService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> clist = acService.selectClubProcess(ci, sortType);
		for (Club c : clist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs);    
		    
        // modifyDate 형식 변경
        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        try {
            Date date = originalFormat.parse(c.getModifyDate().toString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            c.setModifyDate(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
	
		ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getApprovelist = acService.getClubApproveList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubApproveCount = getApprovelist.size();
		
		model.addAttribute("clist", clist);
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("getApprovelist", getApprovelist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
		model.addAttribute("clubApproveCount", clubApproveCount);
	    
	    return "admin/adminClub/adminProcess";
	}
	
    //진행중Ajax
    @ResponseBody
    @RequestMapping(value="adminProcessAjax.ad", produces="application/json; charset=UTF-8")
	public String adminProcessAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

        //페이지네이션
        int clubAllList = acService.getClublist(); 
        PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
        
        //클럽 리스트 불러오기
        ArrayList<Club> clist = acService.selectClubProcess(ci, sortType);
        for (Club c : clist){
            ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);

            // modifyDate 형식 변경
            SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            try {
                Date date = originalFormat.parse(c.getModifyDate().toString());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                c.setModifyDate(sqlDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Gson().toJson(clist);
    }
    
	/* --------------------- */
	
	//종료된 클럽목록
	@RequestMapping("adminEnd.ad")
	public String adminEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

		//페이지네이션
		int clubAllList = acService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> clist = acService.selectClubEnd(ci, sortType);
		for (Club c : clist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs); 
		    
	        // modifyDate 형식 변경
	        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	        try {
	            Date date = originalFormat.parse(c.getModifyDate().toString());
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            c.setModifyDate(sqlDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
		
		ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getApprovelist = acService.getClubApproveList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubApproveCount = getApprovelist.size();
		
		model.addAttribute("clist", clist);
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("getApprovelist", getApprovelist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
		model.addAttribute("clubApproveCount", clubApproveCount);
	    
	    return "admin/adminClub/adminEnd";
	}
	
    //종료된Ajax
    @ResponseBody
    @RequestMapping(value="adminEndAjax.ad", produces="application/json; charset=UTF-8")
	public String adminEndAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

        //페이지네이션
        int clubAllList = acService.getClublist(); 
        PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
        
        //클럽 리스트 불러오기
        ArrayList<Club> clist = acService.selectClubEnd(ci, sortType);
        for (Club c : clist){
            ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);

            // modifyDate 형식 변경
            SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            try {
                Date date = originalFormat.parse(c.getModifyDate().toString());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                c.setModifyDate(sqlDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Gson().toJson(clist);
    }
    
    
	/* --------------------- */
	
	//미승인 클럽목록
	@RequestMapping("adminApprove.ad")
	public String adminApprove(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

		//페이지네이션
		int clubAllList = acService.getClublist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
		
		//클럽 리스트 불러오기
	    ArrayList<Club> clist = acService.selectClubApprove(ci, sortType);
		for (Club c : clist){
			//현재 클럽(c) 의 회원 목록 호출하여 memberList에 저장
		    ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
		    //회원 목록의 프로필 이미지 url를 arraylist에 저장
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	//현재 회원의 프로필 이미지 url을 img리스트에 추가
		    	imgs.add(m.getProfileImg());
		    }
		    //img리스트에 있는 모든 프로필 이미지를 현재 클럽(c)에 넣기
		    c.setProfileImg(imgs); 
		    
	        // modifyDate 형식 변경
	        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	        try {
	            Date date = originalFormat.parse(c.getModifyDate().toString());
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            c.setModifyDate(sqlDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
		
		
		ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getApprovelist = acService.getClubApproveList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubApproveCount = getApprovelist.size();
		
		model.addAttribute("clist", clist);
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("getApprovelist", getApprovelist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
		model.addAttribute("clubApproveCount", clubApproveCount);
	    
	    return "admin/adminClub/adminApprove";
	}
	
    //미승인Ajax
    @ResponseBody
    @RequestMapping(value="adminApproveAjax.ad", produces="application/json; charset=UTF-8")
	public String adminApproveAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  

        //페이지네이션
        int clubAllList = acService.getClublist(); 
        PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
        
        //클럽 리스트 불러오기
        ArrayList<Club> clist = acService.selectClubApprove(ci, sortType);
        for (Club c : clist){
            ArrayList<Member> memberList = acService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);

            // modifyDate 형식 변경
            SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            try {
                Date date = originalFormat.parse(c.getModifyDate().toString());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                c.setModifyDate(sqlDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Gson().toJson(clist);
    }
}		
