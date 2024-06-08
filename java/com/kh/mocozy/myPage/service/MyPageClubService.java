package com.kh.mocozy.myPage.service;

import java.util.ArrayList;

import com.kh.mocozy.myPage.model.vo.MyPageClub;

public interface MyPageClubService {
	//클럽 조회
	ArrayList<MyPageClub> selectClubList(int uno);
}
