package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface MainService {
	
	 //총 갯수 가져오기
	 int selectSocialList();
	 
	//클럽 조회
	ArrayList<Club> selectClist(PageInfo ci);
	
	ArrayList<Club> selectRlist(PageInfo ri);
	
	ArrayList<Club> selectFlist(PageInfo fi);
	 
}