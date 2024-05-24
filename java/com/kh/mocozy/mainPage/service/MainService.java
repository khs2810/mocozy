package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface MainService {
		
	//클럽 조회
	 ArrayList<Club> selectSocial(int cno);
	 
	 //클럽 멤버 조회
	Member selectClubMem(int uno);
	 
	 
	    
}