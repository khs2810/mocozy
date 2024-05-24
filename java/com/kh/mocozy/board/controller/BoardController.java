package com.kh.mocozy.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.board.model.vo.NoticeReply;
import com.kh.mocozy.board.service.BoardService;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.no")
	public String listNotice(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int noticeListCount = boardService.selectNoticeListCount();
		
		PageInfo pi = Pagination.getPageInfo(noticeListCount, currentPage, 5, 5);
		ArrayList<Notice> list = boardService.selectNoticeList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "notice/noticeListPage";
	}
	
	@RequestMapping("enrollForm.no")
	public String enrollNoticeForm() {
		return "notice/noticeEnrollPage";
	}
	
	@RequestMapping("detail.no")
	public String selectNotice(@RequestParam(value="rpage", defaultValue="1") int currentPage, int nno, Model model) {
		int result = boardService.increaseCount(nno);
		
		if (result > 0) {
			Notice n = boardService.selectNotice(nno);
			int replyListCount = boardService.replyListCount(nno);
//			System.out.println(replyListCount);
			
			PageInfo pi = Pagination.getPageInfo(replyListCount, currentPage, 5, 5);
			
			ArrayList<NoticeReply> rlist = boardService.selectNoticeReplyList(nno, pi);
			
//			System.out.println(rlist);
			model.addAttribute("n", n);
			model.addAttribute("rlist", rlist);
			
			return "notice/noticeDetailViewPage";
		} else {
			model.addAttribute("errorMsg", "공지사항 조회 실패");
			return "common/errorPage";
		}
	}
	
	//summernote ajax로 들어오는 파일 업로드 요청 처리
	@PostMapping("upload.no")
	@ResponseBody
	public String upload(List<MultipartFile> fileList, HttpSession session) {
		System.out.println(fileList);
		
		List<String> changeNameList = new ArrayList<String>();
		
		for (MultipartFile f : fileList) {
			String changeName = saveFile(f, session, "/resources/teo/tempImg/");
			
			changeNameList.add("/resources/teo/tempImg/" + changeName);
		}
		
		return new Gson().toJson(changeNameList);
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session, String path) {
		//파일명 수정 후 서버에 업로드하기("imgFile.jpg => 2024042310043054884.jpg)
		String originName = upfile.getOriginalFilename();
		
		//년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//랜덤 5자리 값
		int ranNum = (int)(Math.random()*90000) + 10000;
		
		//확장자
		String ext =originName.substring(originName.lastIndexOf("."));
		
		//수정된 첨부파일명
		String changeName = currentTime + ranNum + ext;
		
		//첨부파일을 저장할 폴더의 물리적 경로(session)
		String savePath = session.getServletContext().getRealPath(path);	
		
		//경로 또는 url넣어주면 입력한 경로 이름으로 파일을 만들어줌
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	@RequestMapping("insert.no")
	public String insertNotice(Notice n, Model model) {
		//로그인 유저로 하고 지워야함
		n.setUserNo(1);
		int result = boardService.insertNotice(n);
		
		if (result > 0) {
			return "redirect:list.no";
		} else {
			model.addAttribute("errorMsg", "공지사항 등록 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("updateForm.no")
	public String updateFormNotice(int nno, Model model) {
		Notice n = boardService.selectNotice(nno);
		model.addAttribute("n", n);
		
		return "notice/noticeUpdateFormPage";
	}
	
	@RequestMapping("update.no")
	public String updateNotice(Notice n, Model model) {
		int result = boardService.updateNotice(n);
		
		if (result > 0) {
			return "redirect:list.no";
		} else {
			model.addAttribute("errorMsg", "공지사항 수정 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("delete.no")
	public String deleteNotice(int nno, Model model) {
		int result = boardService.deleteNotice(nno);
		
		if (result > 0) {
			return "redirect:list.no";
		} else {
			model.addAttribute("errorMsg", "공지사항 삭제 실패");
			return "common/errorPage";
		}
	}
	
}
