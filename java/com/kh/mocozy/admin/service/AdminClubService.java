package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminClubService {
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int userNo);

	public int getClublist();
	
	public ArrayList<Club> selectClublist(PageInfo ci);
}
