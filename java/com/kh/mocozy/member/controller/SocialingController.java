package com.kh.mocozy.member.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

@Controller
public class SocialingController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private MemberService memberService;

    // 내 소셜링
    @RequestMapping("mySocial.me")
    public String mySocialView(Model model) {
        int uno = 2;
        ArrayList<Club> clist = clubService.selectMySocialList(uno);
        ArrayList<Club> dlist = clubService.selectMySocialListDone(uno);

        for (int i = 0; i < clist.size(); i++) {
            ArrayList<Member> memberList = memberService.participatedMemberList(clist.get(i).getClubNo());
            clist.get(i).setMemberCnt(memberList.size());

            // Timestamp를 LocalDateTime으로 변환
            LocalDateTime dateTime = clist.get(i).getEventDate().toLocalDateTime();

            // 밀리초 부분 제거
            dateTime = dateTime.withNano(0);

            // LocalDateTime을 Timestamp로 변환하여 저장
            clist.get(i).setEventDate(Timestamp.valueOf(dateTime));
        }

        model.addAttribute("clist", clist);
        model.addAttribute("dlist", dlist);

        return "myPage/mySocial";
    }
    
    // 소셜링 종료
	@RequestMapping("finishSocial.me")
    public String finishSocial(int cno, Model model) {
    	int result = clubService.finishSocial(cno);

    	if (result > 0) {
    		int uno = 2;
            ArrayList<Club> clist = clubService.selectMySocialList(uno);
            ArrayList<Club> dlist = clubService.selectMySocialListDone(uno);

            for (int i = 0; i < clist.size(); i++) {
                ArrayList<Member> memberList = memberService.participatedMemberList(clist.get(i).getClubNo());
                clist.get(i).setMemberCnt(memberList.size());

                // Timestamp를 LocalDateTime으로 변환
                LocalDateTime dateTime = clist.get(i).getEventDate().toLocalDateTime();

                // 밀리초 부분 제거
                dateTime = dateTime.withNano(0);

                // LocalDateTime을 Timestamp로 변환하여 저장
                clist.get(i).setEventDate(Timestamp.valueOf(dateTime));
            }

            model.addAttribute("clist", clist);
            model.addAttribute("dlist", dlist);

            return "myPage/mySocial";
    	} else {
    		model.addAttribute("errorMsg", "소셜링 종료 실패");
			return "common/errorPage";
    	}
    }
	
	// 소셜링 종료취소
	@RequestMapping("cancleFinishSocial.me")
	public String cancleFinishSocial(int cno, Model model) {
		int result = clubService.cancleFinishSocial(cno);
		
		if (result > 0) {
    		int uno = 2;
            ArrayList<Club> clist = clubService.selectMySocialList(uno);
            ArrayList<Club> dlist = clubService.selectMySocialListDone(uno);

            for (int i = 0; i < clist.size(); i++) {
                ArrayList<Member> memberList = memberService.participatedMemberList(clist.get(i).getClubNo());
                clist.get(i).setMemberCnt(memberList.size());

                // Timestamp를 LocalDateTime으로 변환
                LocalDateTime dateTime = clist.get(i).getEventDate().toLocalDateTime();

                // 밀리초 부분 제거
                dateTime = dateTime.withNano(0);

                // LocalDateTime을 Timestamp로 변환하여 저장
                clist.get(i).setEventDate(Timestamp.valueOf(dateTime));
            }

            model.addAttribute("clist", clist);
            model.addAttribute("dlist", dlist);

            return "myPage/mySocial";
    	} else {
    		model.addAttribute("errorMsg", "소셜링 종료 취소 실패");
			return "common/errorPage";
    	}
	}

    // 참가한 소셜
    @RequestMapping("goSocial.me")
    public String goSocialView(Model model) {
        return "myPage/goSocial";
    }
    
    // Timestamp를 String으로 바꾸는 메소드
    public static String convertTimestampToString(Timestamp timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.toLocalDateTime().format(formatter);
    }
}