package com.kh.mocozy.club.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class ClubReviewController {
	
	@Autowired
	private ClubService clubService;

	@RequestMapping("reviewList.cl")
	public String selectClubList(HttpSession session, Model model) throws Exception {
		Member m = (Member)session.getAttribute("loginUser");
		int uno = m.getUserNo();
		ArrayList<Club> list = clubService.selectClubList(uno);
		ArrayList<ClubReview> rlist = new ArrayList<ClubReview>();
		
		for(Club club : list) {	// 파티장 닉네임
			// Timestamp -> (xxxx년 x월 x일(x) 오전 xx시 xx분) 
			LocalDateTime dateTime = club.getEventDate().toLocalDateTime();
			// 날짜 형식 변환을 위한 포매터
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
			String formattedDate = dateTime.format(dateFormatter);
			// 요일 가져오기 (짧은 형식)
			String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
			// 시간 형식 변환을 위한 포매터
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("a h시 mm분").withLocale(Locale.KOREAN);
			String formattedTime = dateTime.format(timeFormatter);
			// 최종 형식 조합
			String eventDateDetailInfo = String.format("%s(%s) %s", formattedDate, dayOfWeek, formattedTime);
			
			club.setEventDateStr(eventDateDetailInfo);
			
			int cno = club.getClubNo();

			// review가 있으면 1반환, 없으면 0반환
			int isReview = clubService.selectCountReview(cno, uno) ==  0 ? 0 : 1;
			club.setIsReview(isReview);
			
			HashMap<String, Integer> map = new HashMap<>();
			map.put("cno", cno);
			map.put("uno", uno);
			
			ClubReview r = clubService.selectClubReview(map);
			rlist.add(r);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("rlist", rlist);
		model.addAttribute("uno", uno);
		
		System.out.println("list : " + list);
		System.out.println("rlist : " + rlist);
		System.out.println("uno : " + uno);
		
		return "myPage/reviewListPage";
	}
	
	@RequestMapping("getReview.cl")
	@ResponseBody
	public ClubReview getReview(int clubNo, int userNo) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("cno", clubNo);
		map.put("uno", userNo);
		return clubService.selectClubReview(map);
	}
	
	@RequestMapping("insertReview.cl")
	public String insertClubReview(ClubReview r, HttpSession session, Model model) {
		Club c = clubService.selectClub(r.getClubNo());
		int result = clubService.insertClubReview(r, c);
		if (result > 0) {
			session.setAttribute("alertMsg", "리뷰 작성 성공");
			return "redirect:reviewList.cl";
		} else {
			model.addAttribute("errorMsg", "리뷰 작성 실패");
			return "common/errorPage";
		}
	}
}
