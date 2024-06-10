package com.kh.mocozy.member.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

@Controller
public class ChallengeController {
	
	@Autowired
    private ClubService clubService;
    @Autowired
    private MemberService memberService;
	
	// 내가 만든 챌린지
	@RequestMapping("myChallenge.me")
	public String myChallengeView(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("loginUser");
		int uno = m.getUserNo();
		
		ArrayList<Club> clist = clubService.selectMyChallengeList(uno);
		ArrayList<Club> dlist = clubService.selectMyChallengeListDone(uno);
		
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

        return "myPage/myChallenge";
	}
	
	// 챌린지 종료
	@RequestMapping("finishChallenge.me")
	public String finishChallenge(HttpSession session, int cno, Model model) {
		int result = clubService.finishChallenge(cno);
		
		if (result > 0) {
			Member m = (Member)session.getAttribute("loginUser");
			int uno = m.getUserNo();
			
			ArrayList<Club> clist = clubService.selectMyChallengeList(uno);
			ArrayList<Club> dlist = clubService.selectMyChallengeListDone(uno);
			
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

	        return "myPage/myChallenge";
		} else {
			model.addAttribute("errorMsg", "소셜링 종료 실패");
			return "common/errorPage";
		}
	}
	
	// 챌린지 종료취소
	@RequestMapping("cancleFinishChallenge.me")
	public String cancleFinishChallenge(HttpSession session, int cno, Model model) {
		int result = clubService.cancleFinishChallenge(cno);
		
		if (result > 0) {
			Member m = (Member)session.getAttribute("loginUser");
			int uno = m.getUserNo();
			
			ArrayList<Club> clist = clubService.selectMyChallengeList(uno);
			ArrayList<Club> dlist = clubService.selectMyChallengeListDone(uno);
			
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

	        return "myPage/myChallenge";
		} else {
			model.addAttribute("errorMsg", "소셜링 종료 실패");
			return "common/errorPage";
		}
	}
	
	// 참가한 챌린지
	@RequestMapping("goChallenge.me")
	public String goChallengeView(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("loginUser");
		int uno = m.getUserNo();
		
		ArrayList<Club> clist = clubService.selectMyChallengeList(uno);
		ArrayList<Club> dlist = clubService.selectMyChallengeListDone(uno);
		
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
        
        return "myPage/goChallenge";
	}
	
	// 챌린지 탈퇴
    @RequestMapping("quitChallenge.me")
    public String quitSocial(HttpSession session, int cno, Model model) {
    	Member m = (Member)session.getAttribute("loginUser");
    	int uno = m.getUserNo();
    	
    	HashMap<String, Integer> map = new HashMap<>();
		map.put("cno", cno);
		map.put("uno", uno);
    	
    	int result = clubService.quitClub(map);
    	
    	if (result > 0) {
    		return "myPage/myChallenge";
    	} else {
    		model.addAttribute("errorMsg", "챌린지 탈퇴 실패");
			return "common/errorPage";
    	}
    }
    
    // Timestamp를 String으로 바꾸는 메소드
    public static String convertTimestampToString(Timestamp timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.toLocalDateTime().format(formatter);
    }
    
    @RequestMapping("challengeManage.me")
    public String challengeManageView(HttpSession session, int cno, @RequestParam("challengeDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {
        System.out.println("0");
    	Member m = (Member)session.getAttribute("loginUser");
        int uno = m.getUserNo();
        System.out.println("1");
        ArrayList<Member> clubMemberList = memberService.participatedMemberList(cno);
        Member clubLeader = memberService.selectClubLeader(cno);
        System.out.println("2");
        Map<Integer, String> memberStatus = clubService.getMemberStatusForDate(cno, date);
        System.out.println("3");
        model.addAttribute("clubMemberList", clubMemberList);
        model.addAttribute("clubLeader", clubLeader);
        model.addAttribute("selectedDate", date);
        model.addAttribute("memberStatus", memberStatus);
        
        return "myPage/challengeManagePage";
    }

    
//    @PostMapping("saveChallenge.me")
//    @ResponseBody
//    public Map<String, String> saveChallenge(@RequestBody Map<String, Object> data) {
//        String date = (String) data.get("challengeDate");
//        Map<String, String> memberStatus = (Map<String, String>) data.get("memberStatus");
//
//        memberStatus.forEach((memberId, status) -> {
//        	HashMap<String, String> map = new HashMap<>();
//        	map.put("memberId", memberId);
//        	map.put("date", date);
//        	map.put("status", status);
//            clubService.insertMemberChallengeStatus(map);
//        });
//
//        Map<String, String> response = new HashMap<>();
//        response.put("status", "success");
//        return response;
//    }

}
