package com.kh.mocozy.myPage.service;

import java.util.List;

import com.kh.mocozy.myPage.model.vo.MyPageClub;

public interface MyPageClubService {
	
//	마이페이지 최근 활동 모임 리스트
	List<MyPageClub> myPageClub(MyPageClub myPageClub);
}
