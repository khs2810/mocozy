package com.kh.mocozy.club.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.service.ClubService;

@Controller
public class ClubReviewController {
	
	@Autowired
	private ClubService clubService;

	@RequestMapping("reviewList.cl")
	public String selectClubList(Model model) {
		int uno = 4;
		ArrayList<Club> list = clubService.selectClubList(uno);
		
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

			// review가 있으면 1반환, 없으면 0반환
			int isReview = clubService.selectCountReview(club.getClubNo()) ==  0 ? 0 : 1;
			System.out.println(isReview);
			
			club.setIsReview(isReview);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("uno", uno);
		
		return "myPage/reviewListPage";
	}
	
//	@RequestMapping("reviewDetail.cl")
//	public String selectClubReview(int cno, Model model) {
//		
//		ClubReview r = clubService.selectClubReview(cno);
//		
//		model.addAttribute("r", r);
//		
//		return "myPage/reviewListPage";
//	}
//	
//	@RequestMapping("reviewInsert.cl")
//	public String insertReview(ClubReview r, Model model) {
//		int result = clubService.insertClubReview(r);
//		if (result > 0) {
//			model.addAttribute("r", r);
//		} else {
//			model.addAttribute("errorMsg", "리뷰 작성 실패");
//		}
//		return "myPage/reviewListPage";
//	}
}
