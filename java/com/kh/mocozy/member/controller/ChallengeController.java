package com.kh.mocozy.member.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.club.model.vo.Challenge;
import com.kh.mocozy.club.model.vo.ChallengeRequest;
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
		Member m = (Member)session.getAttribute("loginUser");
		int uno = m.getUserNo();
		int result = clubService.finishChallenge(cno, uno);
		
		if (result > 0) {
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
		Member m = (Member)session.getAttribute("loginUser");
		int uno = m.getUserNo();
		int result = clubService.cancleFinishChallenge(cno);
		
		if (result > 0) {
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
		
		ArrayList<Club> clist = clubService.selectGoChallengeList(uno);
		ArrayList<Club> dlist = clubService.selectGoChallengeListDone(uno);
		
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
    		session.setAttribute("alertMsg", "모임 탈퇴 성공");
    		session.setAttribute("loginUser", memberService.loginMember(m));
    		return "redirect:goChallenge.me";
    	} else {
    		model.addAttribute("errorMsg", "소셜링 탈퇴 실패");
			return "common/errorPage";
    	}
    }
    
    // Timestamp를 String으로 바꾸는 메소드
    public static String convertTimestampToString(Timestamp timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return timestamp.toLocalDateTime().format(formatter);
    }
    
    // String을 Date로 바꾸고 다시 Timestamp로 바꾸는 메소드
 	public static Timestamp convertStringToTimestamp(String dateString) {
 		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 		
 		try {
 			Date parsedDate = dateFormat.parse(dateString);
 			return new Timestamp(parsedDate.getTime());
 		} catch (ParseException e) {
 			e.printStackTrace();
 			return null;
 		}
 	}
 	
 	@RequestMapping("/challengeManage.me")
 	public String challengeManageView(HttpSession session, int cno, String challengeDate, Model model) {
 	    Club c = clubService.selectClub(cno);
 	    
 	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	    String createDate = dateFormat.format(c.getCreateDate());
 	    
 	    Timestamp challengeDateTimestamp = convertStringToTimestamp(challengeDate);
 	    
 	    // 각 날짜별로 도전 상태를 저장하는 맵
 	    Map<Timestamp, Map<Integer, String>> challengeStatusMap = new HashMap<>();
 	    
 	    ArrayList<Member> clubMemberList = memberService.participatedMemberList(cno);
 	    Member clubLeader = memberService.selectClubLeader(cno);
 	    Club clubObj = clubService.selectClub(cno);
 	    
 	    ArrayList<Map<String, Object>> memberStatus = clubService.getMemberStatusForDate(cno, challengeDateTimestamp);
 	    
 	    for(Map<String, Object> status : memberStatus) {
 	        Long userNoLong = (Long) status.get("user_no");
 	        int userNo = userNoLong != null ? userNoLong.intValue() : 0;
 	        
 	        String dailyStatus = (String) status.get("daily_status");
 	        Timestamp detailDate = (Timestamp) status.get("detail_date");
 	        
 	        // 해당 날짜의 도전 상태를 저장할 맵
 	        Map<Integer, String> dateStatusMap = challengeStatusMap.getOrDefault(detailDate, new HashMap<>());
 	        dateStatusMap.put(userNo, dailyStatus);
 	        challengeStatusMap.put(detailDate, dateStatusMap);
 	    }
 	    
 	    
 	    
 	    Map<Integer, String> tmp = challengeStatusMap.get(challengeDateTimestamp);
 	    
 	    model.addAttribute("cno", cno);
 	    model.addAttribute("createDate", createDate);
 	    model.addAttribute("clubMemberList", clubMemberList);
 	    model.addAttribute("clubLeader", clubLeader);
 	    model.addAttribute("clubTitle", clubObj.getClubTitle());
 	    model.addAttribute("challengeDate", challengeDate);
 	    model.addAttribute("memberStatus", memberStatus);
 	    model.addAttribute("challengeStatusMap", challengeStatusMap); // 날짜별 도전 상태 맵 추가
 	    model.addAttribute("tmp", tmp);
 	    
 	    return "myPage/challengeManagePage";
 	}
    
    @PostMapping(value = "/saveChallenge.me")
    public String saveChallenge(@RequestBody ChallengeRequest challengeRequest, Model model) {
        try {
            // 날짜 형식 변환
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date challengeDate = dateFormat.parse(challengeRequest.getChallengeDate());

            List<Integer> userNos = challengeRequest.getUserNos();
            List<String> dailyStatuses = challengeRequest.getDailyStatuses();
            int clubNo = challengeRequest.getCno();

            for (int i = 0; i < userNos.size(); i++) {
                int userNo = userNos.get(i);
                String dailyStatus = dailyStatuses.get(i);

                Challenge newChallenge = new Challenge();
                newChallenge.setUserNo(userNo);
                newChallenge.setClubNo(clubNo);
                newChallenge.setDetailDate(challengeDate);
                newChallenge.setDailyStatus(dailyStatus);
                newChallenge.setStatus("Y");

                // 중복 여부 확인
                boolean exists = clubService.checkChallengeExists(newChallenge);

                if (!exists) {
                    int result = clubService.saveChallenge(newChallenge);
                    if (result <= 0) {
                        model.addAttribute("errorMsg", "챌린지 상태 등록 실패");
                        return "common/errorPage";
                    }
                }
            }
            return "redirect:challengeManage.me?cno=" + clubNo + "&challengeDate=" + challengeRequest.getChallengeDate();
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "챌린지 상태 등록 실패");
            return "common/errorPage";
        }
    }
    
    @RequestMapping("/challengeCheck.me")
	public String challengeCheckView(HttpSession session, int cno, String challengeDate, Model model) {
    	Club c = clubService.selectClub(cno);
 	    
 	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	    String createDate = dateFormat.format(c.getCreateDate());
 	    
 	    Timestamp challengeDateTimestamp = convertStringToTimestamp(challengeDate);
 	    
 	    // 각 날짜별로 도전 상태를 저장하는 맵
 	    Map<Timestamp, Map<Integer, String>> challengeStatusMap = new HashMap<>();
 	    
 	    ArrayList<Member> clubMemberList = memberService.participatedMemberList(cno);
 	    Member clubLeader = memberService.selectClubLeader(cno);
 	   Club clubObj = clubService.selectClub(cno);
 	    
 	    ArrayList<Map<String, Object>> memberStatus = clubService.getMemberStatusForDate(cno, challengeDateTimestamp);
 	    
 	    for(Map<String, Object> status : memberStatus) {
 	        Long userNoLong = (Long) status.get("user_no");
 	        int userNo = userNoLong != null ? userNoLong.intValue() : 0;
 	        
 	        String dailyStatus = (String) status.get("daily_status");
 	        Timestamp detailDate = (Timestamp) status.get("detail_date");
 	        
 	        // 해당 날짜의 도전 상태를 저장할 맵
 	        Map<Integer, String> dateStatusMap = challengeStatusMap.getOrDefault(detailDate, new HashMap<>());
 	        dateStatusMap.put(userNo, dailyStatus);
 	        challengeStatusMap.put(detailDate, dateStatusMap);
 	    }
 	    
 	    Map<Integer, String> tmp = challengeStatusMap.get(challengeDateTimestamp);
 	    
 	    model.addAttribute("cno", cno);
 	    model.addAttribute("createDate", createDate);
 	    model.addAttribute("clubMemberList", clubMemberList);
 	    model.addAttribute("clubLeader", clubLeader);
 	    model.addAttribute("clubTitle", clubObj.getClubTitle());
 	    model.addAttribute("challengeDate", challengeDate);
 	    model.addAttribute("memberStatus", memberStatus);
 	    model.addAttribute("challengeStatusMap", challengeStatusMap);
 	    model.addAttribute("tmp", tmp);
        
        return "myPage/challengeCheckPage";
    }
}
