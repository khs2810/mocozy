package com.kh.mocozy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.admin.service.AdminClubService;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class AdminController {
	
    @Autowired
    private AdminClubService acService;
    
    @Autowired
    private AdminUserlistService auService;
    
    @Autowired
    private AdminNoticeService anService;
    
	@RequestMapping("admin.ad")
	public String showAdmin(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {  
		//페이지네이션
		int NoticeAllList = anService.getNoticeCount(); 
		int clubAllList = acService.getClublist(); 
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		PageInfo ni = Pagination.getPageInfo(NoticeAllList, currentPage, 5, 5);
		
		ArrayList<Member> mlist = auService.MemberList(mi);
		ArrayList<Notice> nlist = anService.getNoticeList(ni);
	    ArrayList<Club> clist = acService.selectClublist(ci);
	    
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
		}
		
		model.addAttribute("nlist", nlist);
		model.addAttribute("mlist", mlist);
		model.addAttribute("clist", clist);

	    return "admin/admin";
    }
	
	@RequestMapping("adminChat.ad")
	public String showAdminChat(Model model) {    
	    return "admin/adminChat/adminChat";
    }
	
	@RequestMapping("privateChat.ad")
	public String showPrivateChat(Model model) {    
	    return "admin/adminChat/privateChat";
    }
	
	@RequestMapping("adminPoint.ad")
	public String showAdminPoint(Model model) {    
	    return "admin/adminPoint/adminPoint";
    }
}
