package com.kh.mocozy.mainPage.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.mainPage.service.MainService;
import com.kh.mocozy.mainPage.service.MainServiceImpl;
import com.kh.mocozy.member.model.vo.Member;

@RestController
public class MainController {
	
	@Autowired
    private MainServiceImpl mService;
	
	@RequestMapping("social.ma")
    public ArrayList<Club> selectSocial(int cno, Model model) {
		ArrayList<Club> clist = new MainServiceImpl().selectSocial(cno);
		
			for (Club c : clist) {
				Member m = new MainServiceImpl().selectClubMem(c.getUserNo()); 
				c.setMemberlist(m);
		
		}
		
		return clist;
	}

}