package com.kh.mocozy.club.service;

import com.kh.mocozy.club.model.vo.Club;

public interface ClubService {
	
	//클럽 조회수 증가
	int increaseCount(int cno);
	
	//클럽 조회
	Club selectClub(int cno);

}
