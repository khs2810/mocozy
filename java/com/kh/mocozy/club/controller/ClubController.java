package com.kh.mocozy.club.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.club.service.ClubService;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.model.vo.Payment;
import com.kh.mocozy.point.service.PointService;

@Controller
public class ClubController {
	
	@Autowired
	private ClubService clubService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private PointService pointService;
	
	@Value("${kakao.api.js.key}")
    private String kakaoApiKey;
	
	@RequestMapping("detail.cl")
	public String selectClub(int cno, Model model, HttpSession session) {
		int result = clubService.increaseCount(cno);
		
		if (result > 0) {
			Club c = clubService.selectClub(cno);
			ArrayList<Member> memberList = memberService.participatedMemberList(cno);
			ArrayList<ClubReview> reviewList = clubService.listReview(cno);
			ArrayList<Member> rqMemberList = memberService.requestMemberList(cno);
			model.addAttribute("c", c);
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("memberList", memberList);
			model.addAttribute("rqMemberList", rqMemberList);
			// Timestamp -> (xxxx년 x월 x일(x) 오전 xx시 xx분) 
	        LocalDateTime dateTime = c.getEventDate().toLocalDateTime();
	        // 날짜 형식 변환을 위한 포매터
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
	        String formattedDate = dateTime.format(dateFormatter);
	        // 요일 가져오기 (짧은 형식)
	        String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
	        // 시간 형식 변환을 위한 포매터
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("a h시 m분").withLocale(Locale.KOREAN);
	        String formattedTime = dateTime.format(timeFormatter);
	        // 최종 형식 조합
	        String eventDateDetailInfo = String.format("%s(%s) %s", formattedDate, dayOfWeek, formattedTime);
	        
	        model.addAttribute("evDate", eventDateDetailInfo);
	        model.addAttribute("kakaoApiKey", kakaoApiKey);
			
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
	public String paymentClub(int cno, String answer, Model model) {
		Club c = clubService.selectClub(cno);
		
		if (c != null && answer != null) {
			
			// Timestamp -> (xxxx년 x월 x일(x) 오전 xx시 xx분) 
	        LocalDateTime dateTime = c.getEventDate().toLocalDateTime();
	        // 날짜 형식 변환을 위한 포매터
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M월 d일");
	        String formattedDate = dateTime.format(dateFormatter);
	        // 요일 가져오기 (짧은 형식)
	        String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
	        // 시간 형식 변환을 위한 포매터
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("a h:mm").withLocale(Locale.KOREAN);
	        String formattedTime = dateTime.format(timeFormatter);
	        // 최종 형식 조합
	        String eventDateDetailInfo = String.format("%s(%s) %s", formattedDate, dayOfWeek, formattedTime);
	        
	        // 현재 날짜와 시간 가져오기
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        
            // D-Day 계산
	        Period period = Period.between(currentDateTime.toLocalDate(), dateTime.toLocalDate());
	        long daysBetween = period.getDays();
	        String dDay = (daysBetween > 0) ? "D-" + daysBetween : (daysBetween == 0) ? "D-0" : "D+" + Math.abs(daysBetween);
	        
	        model.addAttribute("dDay", dDay);	        
	        model.addAttribute("evDate", eventDateDetailInfo);
			model.addAttribute("c", c);
			model.addAttribute("answer", answer);
			
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
		if (result > 0) {
			if (c.getClubType().equals("챌린지")) {
				clubService.insertChMember(c);
			}
			session.setAttribute("alertMsg", "모임 등록 성공");
			return "redirect:detail.cl?cno=" + result;
		} else {
			model.addAttribute("errorMsg", "모임 등록 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("update.cl")
	public String updateClub(Club c, MultipartFile upfile, HttpSession session, Model model) {
		Attachment at = clubService.selectAttachment(c.getClubNo());
		c.setThumbnailImg(at.getChangeName());
		
		String eventT = c.getEventDateStr();
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(eventT, inputFormatter);
        
        // LocalDateTime을 원하는 형식의 문자열로 변환
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(outputFormatter);

        c.setEventDate(convertStringToTimestamp(formattedDateTime));
        
        if (c.getStatus().equals("E")) {
        	int result1 = clubService.cancleFinishSocial(c.getClubNo());
        	int result2 = clubService.clubRequestReset(c.getClubNo());
        	
        	if (result1 > 0) {
        		session.setAttribute("alertMsg", "모임 수정 성공");
        		return "redirect:detail.cl?cno=" + c.getClubNo();
        	} else {
        		model.addAttribute("errorMsg", "게시글 수정 실패1");
        		return "common/errorPage";
        	}
        } else {        	
        	int result = clubService.updateClub(c, at);
        	
        	if (result > 0) {
        		session.setAttribute("alertMsg", "모임 수정 성공");
        		return "redirect:detail.cl?cno=" + c.getClubNo();
        	} else {
        		model.addAttribute("errorMsg", "게시글 수정 실패2");
        		return "common/errorPage";
        	}
        }
	}
	
	// ajax로 들어오는 파일 업로드 요청 처리
	// 파일목록을 저장한 후 저장된 파일명 목록을 반환
	@PostMapping("upload")
	@ResponseBody
	public String upload(List<MultipartFile> fileList, HttpSession session) {
		System.out.println(fileList);
		
		List<String> changeNameList = new ArrayList<String>();
		
		for(MultipartFile f : fileList) {
			String changeName = saveFile(f, session, "/resources/jun/uploadFiles/");
			
			changeNameList.add("/resources/jun/uploadFiles/" + changeName);
		}
		
		return new Gson().toJson(changeNameList);
	}
	
	//실제 넘어온 파일의 이름을 변경해서 서버에 저장하는 메소드
	public String saveFile(MultipartFile upfile, HttpSession session, String path) {
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
		String savePath = session.getServletContext().getRealPath(path);
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
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
	
	@RequestMapping("enrollform.cl")
	public String enrollClub() {
		return "club/clubInsertPage";
	}
	
	@RequestMapping("insert.rq")
	public String insertRequest(Request r, int pt, Model model, HttpSession session) {
		r.setPoint(pt);
		Member m = (Member)session.getAttribute("loginUser");
		
		int result = clubService.insertPayment(r);
		
		if (result > 0) {
			int result1 = clubService.insertRequest(r);
			int result2 = memberService.pointUpdateRq(r);
			
			if (result1 * result2 > 0) {
				
				Member loginUser = memberService.loginMember(m);
				session.setAttribute("loginUser", loginUser);
				
				return "redirect:/";
			} else {
				model.addAttribute("errorMsg", "모임 참가 신청 실패");
				return "common/errorPage";
			}
		} else {
			model.addAttribute("errorMsg", "모임 참가 신청 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateform.cl")
	public String updateClub(int cno, Model model) {
		Club c = clubService.selectClub(cno);
		model.addAttribute("c", c);
		return "club/clubUpdatePage";
	}
	
	@RequestMapping("delete.cl")
	public String deleteClub(int cno, Model model, HttpSession session) {
		//삭제할 클럽의 리퀘스트 목록 가져오기
		ArrayList<Request> rlist = clubService.selectListRequestNotF(cno); 
		
		boolean isTrue = false;
		
		if (rlist.size() > 0) {
			isTrue = false;
			for (Request r : rlist) {
				//리퀘스트의 페이먼트 정보 가져오기
				Payment p = pointService.selectPayment(r.getPaymentNo());
				//페이먼트  취소 (status C)처리
				int result1 = pointService.cancelPayment(p);
				if (result1 > 0) {
					//취소한 페이먼트 포인트 유저한테 돌려주기
					int result2 = pointService.returnPoint(p);
					if (result2 > 0) {
						isTrue = true;
					}
				} else {
					model.addAttribute("errorMsg", "모임 삭제 실패1_1");
					return "common/errorPage";
				}
			}
			if (!isTrue) {
				model.addAttribute("errorMsg", "모임 삭제 실패1_2");
				return "common/errorPage";
			}
		}
		
		int result3 = 0;
		
		if (isTrue) {
			//클럽삭제
			result3 = clubService.deleteClub(cno);
		}
		
		if (result3 > 0) {
			session.setAttribute("alertMsg", "모임이 삭제되었습니다");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "모임 삭제 실패2");
			return "common/errorPage";
		}
	}
	
}
