package com.kh.mocozy.club.service;

import java.util.ArrayList;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;

public interface ClubService {
	
	//클럽 조회수 증가
	int increaseCount(int cno);
	
	//클럽 조회
	Club selectClub(int cno);
	
	//클럽 리뷰 조회
	ArrayList<ClubReview> listReview(int cno);

}
