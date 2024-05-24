package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;

@Service
public interface MainService {
		
	//클럽 조회
	 ArrayList<Club> selectSocial(int clubNo);
	 
	 
	    
}