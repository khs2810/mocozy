package com.kh.mocozy.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
		//카테고리별로 클럽의 사이즈 구하기
    	ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getHiddenlist = acService.getClubHiddenList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubHiddenCount = getHiddenlist.size();
		
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
	    model.addAttribute("clubHiddenCount", clubHiddenCount);
		model.addAttribute("status", "D");
    	
    	return "admin/adminClub/adminClub";
    }
	
    //전체Ajax
    @ResponseBody
    @RequestMapping(value="adminClubAjax.ad", produces="application/json; charset=UTF-8")
	public String adminClubAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, String status, Model model) throws java.text.ParseException {  
        ArrayList<Club> clist = new ArrayList<>();
        
    	if (status.equals("D")) {
        	//페이지네이션
        	int clubAllList = acService.getClublist();
        	PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
        	
        	//클럽 리스트 불러오기
        	clist = acService.selectClublist(ci, sortType);
        } else if (status.equals("Y")) {
        	//페이지네이션
            int clubAllList = acService.getClublist(); 
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubProcess(ci, sortType);
            
        } else if (status.equals("H")) {
        	//페이지네이션
            int clubAllList = acService.getClublist(); 
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubHidden(ci, sortType);    
        	
        } else {
        	//페이지네이션
            int clubAllList = acService.getClublist(); 
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubEnd(ci, sortType);
        }
       
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
    
    //검색 Ajax 
    @ResponseBody
    @RequestMapping(value="adminClubSearchAjax.ad", produces="application/json; charset=UTF-8")
	public String adminClubSearchAjax(@RequestParam("keyword") String keyword, @RequestParam("cpage") int currentPage, String sortType, String status, Model model) throws java.text.ParseException {  
        
    	HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sortType", sortType);

    	ArrayList<Club> clist = new ArrayList<>();
    	
    	if (status.equals("D")) {
        	//페이지네이션
        	int clubAllList = acService.getClubSearchlist(map);
        	PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 50, 50);
        	
        	//클럽 리스트 불러오기
        	clist = acService.selectSearchClublist(map, ci);
        	
        } else if (status.equals("Y")) {
        	//페이지네이션
            int clubAllList = acService.getClubSearchlist(map); 
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 50, 50);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubSearchProcess(map, ci);
            
        } else if (status.equals("H")) {
        	//페이지네이션
            int clubAllList = acService.getClublist(); 
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 10, 10);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubSearchHidden(map, ci);    
        		
        } else {
        	//페이지네이션
            int clubAllList = acService.getClubSearchlist(map);
            PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 50, 50);
            
            //클럽 리스트 불러오기
            clist = acService.selectClubSearchEnd(map, ci);
        }
    		  
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
		//카테고리별로 클럽의 사이즈 구하기
    	ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getHiddenlist = acService.getClubHiddenList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubHiddenCount = getHiddenlist.size();
		
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
	    model.addAttribute("clubHiddenCount", clubHiddenCount);
		model.addAttribute("status", "Y");
	    
	    return "admin/adminClub/adminProcess";
	}
	
	/* --------------------- */
	
	//종료된 클럽목록
	@RequestMapping("adminEnd.ad")
	public String adminEnd(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  
		//카테고리별로 클럽의 사이즈 구하기
    	ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getHiddenlist = acService.getClubHiddenList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubHiddenCount = getHiddenlist.size();
		
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
	    model.addAttribute("clubHiddenCount", clubHiddenCount);
		model.addAttribute("status", "N");
		
	    return "admin/adminClub/adminEnd";
	}
	
	/* --------------------- */
	
	//숨김 클럽목록
	@RequestMapping("adminHidden.ad")
	public String adminHidden(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  
		//카테고리별로 클럽의 사이즈 구하기
    	ArrayList<Club> getClist = acService.getClubAllList();
		ArrayList<Club> getProcesslist = acService.getClubProcessList();
		ArrayList<Club> getEndlist = acService.getClubEndList();
		ArrayList<Club> getHiddenlist = acService.getClubHiddenList();
		int clubAllCount = getClist.size();
		int clubProcessCount = getProcesslist.size();
		int clubEndCount = getEndlist.size();
		int clubHiddenCount = getHiddenlist.size();
		
		model.addAttribute("getClist", getClist);
		model.addAttribute("getProcesslist", getProcesslist);
		model.addAttribute("getEndlist", getEndlist);
		model.addAttribute("clubAllCount", clubAllCount);
		model.addAttribute("clubProcessCount", clubProcessCount);
		model.addAttribute("clubEndCount", clubEndCount);
	    model.addAttribute("clubHiddenCount", clubHiddenCount);
	    model.addAttribute("status", "H");
	    
	    return "admin/adminClub/adminClubHidden";
	}
}		
