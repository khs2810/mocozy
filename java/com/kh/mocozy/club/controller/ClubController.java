package com.kh.mocozy.club.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.common.model.vo.Attachment;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	
	@RequestMapping("detail.cl")
	public String selectClub(int cno, Model model) {
		
		int result = clubService.increaseCount(cno);
		ArrayList<ClubReview> reviewList = clubService.listReview(cno);
		
		
		if (result > 0) {
			Club c = clubService.selectClub(cno);
//			System.out.println(c);
			model.addAttribute("c", c);
			model.addAttribute("reviewList", reviewList);
//			System.out.println(reviewList);
			return "club/clubDetailPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("confirm.cl")
	public String participateClub(int cno, Model model) {
		model.addAttribute("cno", cno);
		return "club/clubParticipateConfirm";
	}
	
	@RequestMapping("hostQuestion.cl")
	public String hostQuestion(int cno, Model model) {
		Club c = clubService.selectClub(cno);
		
		if (c != null) {
			model.addAttribute("c", c);
			return "club/hostQuestionPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("payment.cl")
	public String paymentClub(int cno, Model model) {
		Club c = clubService.selectClub(cno);
//		System.out.println(c);
		if (c != null) {
			model.addAttribute("c", c);
			return "club/clubPaymentPage";
		} else {
			model.addAttribute("errorMsg", "모임 조회 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("insert.cl")
	public String insertClub(Club c, MultipartFile upfile, HttpSession session, Model model) {
		Attachment at = new Attachment();
		String eventT = c.getEventDateStr();
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(eventT, inputFormatter);
        
        // LocalDateTime을 원하는 형식의 문자열로 변환
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(outputFormatter);
        System.out.println(formattedDateTime);

        c.setEventDate(convertStringToTimestamp(formattedDateTime));

		//전달된 파일이 있을 경우 => 파일이름 변경 => 서버에 저장 => 원본명, 서버업로드된 경로를 b객체에 담기
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = saveFile(upfile, session);
			
			at.setOriginName(upfile.getOriginalFilename());
			at.setChangeName("resources/jun/uploadFiles/" + changeName);
			at.setFilePath("resources/jun/uploadFiles/");
			c.setThumbnailImg("resources/jun/uploadFiles/" + changeName);
		}
		
		int result = clubService.insertClub(c, at);
		if (result > 0) { //성공 => list페이지로 이동
			session.setAttribute("alertMsg", "모임 등록 성공");
			return "redirect:detail.cl?cno=1";
		} else { //실패 => 에러페이지
			model.addAttribute("errorMsg", "모임 등록 실패");
			return "common/errorPage";
		}
	}
	
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
	
	//실제 넘어온 파일의 이름을 변경해서 서버에 저장하는 메소드
	public String saveFile(MultipartFile upfile, HttpSession session) {
		//파일명 수정 후 서버에 업로드하기("imgFile.jpg => 202404231004305488.jpg")
		String originName = upfile.getOriginalFilename();
		
		//년월일시분초 
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//5자리 랜덤값
		int ranNum = (int)(Math.random() * 90000) + 10000;
		
		//확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//수정된 첨부파일명
		String changeName = currentTime + ranNum + ext;
		
		//첨부파일을 저장할 폴더의 물리적 경로(session)
		String savePath = session.getServletContext().getRealPath("/resources/jun/uploadFiles/");
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	@RequestMapping("enrollform.cl")
	public String enrollClub() {
		return "club/clubInsertPage";
	}
}
