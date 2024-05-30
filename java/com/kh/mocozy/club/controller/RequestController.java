package com.kh.mocozy.club.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

@Controller
public class RequestController {
	
	@Autowired
	private ClubService clubService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("list.re")
	public String selectClub(int cno, Model model) {
		ArrayList<Member> memberList = memberService.participatedMemberList(cno);
		int memberCnt = memberList.size();
		
		Club c = clubService.selectClub(cno);
		model.addAttribute("c", c);
		
		ArrayList<Request> requestList = clubService.requestList(cno);
		
		for(int i=0; i<requestList.size(); i++) {
			// Timestamp를 String으로 변환
            String requestTime = convertTimestampToString(requestList.get(i).getCreateDate());

            // String을 LocalDateTime으로 변환
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(requestTime, inputFormatter);

            // LocalDateTime을 원하는 형식의 문자열로 변환
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(outputFormatter);
            
            // String을 다시 Timestamp로 변환하여 저장
            requestList.get(i).setCreateDate(convertStringToTimestamp(formattedDateTime));
		}
		
		model.addAttribute("requestList", requestList);
		model.addAttribute("memberCnt", memberCnt);
		
		return "club/requestListPage";
	}
	
	// String을 Date로 바꾸고 다시 Timestamp로 바꾸는 메소드
	public static Timestamp convertStringToTimestamp(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date parsedDate = dateFormat.parse(dateString);
			return new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Timestamp를 String으로 바꾸는 메소드
    public static String convertTimestampToString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(timestamp);
    }
	
	@ResponseBody
	@RequestMapping(value = "accept.re", produces="application/json; charset-UTF-8")
	public String ajaxAcceptRequest(@RequestParam int rqno, int cno, HttpSession session) {
		ArrayList<Member> memberList = memberService.participatedMemberList(cno);
		int memberCnt = memberList.size();
		Club c = clubService.selectClub(cno);
		int capacity = c.getCapacity();
		
		if (memberCnt < capacity) {
			int result = clubService.acceptRequest(rqno);
			
			ArrayList<Request> rList = clubService.requestList(cno);
			
			return new Gson().toJson(rList);
		} else {
			session.setAttribute("alertMsg", "모임 인원 초과");
			return "redirect:list.re";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "deny.re", produces="application/json; charset-UTF-8")
	public String ajaxDenyRequest(@RequestParam int rqno, int cno) {
		int result = clubService.denyRequest(rqno);
		
		ArrayList<Request> rList = clubService.requestList(cno);
		
		return new Gson().toJson(rList);
	}
}
