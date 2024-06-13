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

import com.kh.mocozy.admin.service.AdminClubService;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.model.vo.Point;
import com.kh.mocozy.point.model.vo.PointDTO;
import com.kh.mocozy.point.service.PointService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class AdminController {
	
    @Autowired
    private AdminClubService acService;
    
    @Autowired
    private AdminUserlistService auService;
    
    @Autowired
    private AdminNoticeService anService;
    
    @Autowired
    private PointService pointService;
    
    @Autowired
    private MemberService memberService;
    
	@RequestMapping("admin.ad")
	public String showAdmin(@RequestParam(value="cpage", defaultValue="1") int currentPage, String sortType, Model model) throws java.text.ParseException {  
		//페이지네이션
		int NoticeAllList = anService.getNoticeCount(); 
		int clubAllList = acService.getClublist(); 
		int memberAllList = auService.getMemberlist(); 
		//총 클럽수, 현재 페이지 번호, 한 페이지에 표시할 클럽 수, 페이지 번호 수 설정
		PageInfo ci = Pagination.getPageInfo(clubAllList, currentPage, 5, 5);
		PageInfo mi = Pagination.getPageInfo(memberAllList, currentPage, 5, 5);
		PageInfo ni = Pagination.getPageInfo(NoticeAllList, currentPage, 5, 5);
		
		ArrayList<Member> mlist = auService.MemberAll(mi, sortType);
		ArrayList<Notice> nlist = anService.getNoticeAll(ni, sortType);
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
	public String showAdminPoint(@RequestParam(value = "cpage", defaultValue = "1") int currentPage, Model model) {    
		int pointListCount = pointService.selectPointAdminListCount();
		
		PageInfo pi = Pagination.getPageInfo(pointListCount, currentPage, 10, 5);
		
		ArrayList<Point> plist = pointService.selectListPointAdmin(pi);
		ArrayList<PointDTO> list = new ArrayList<>();
		
		for(Point p : plist) {
			PointDTO pd = new PointDTO(p);
			pd.setUserNickname(memberService.selectNicknameByUserNo(p.getUserNo()));
			pd.setAdminNickname(memberService.selectNicknameByUserNo(p.getAdminNo()));
			list.add(pd);
		}
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
	    return "admin/adminPoint/adminPoint";
    }
}
