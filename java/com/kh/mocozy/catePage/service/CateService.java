package com.kh.mocozy.catePage.service;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface CateService {
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);
	
	//챌린지, 클럽
	ArrayList<Club> getSocialing();
	
	ArrayList<Club> getChallenge();

    int getReviewCount(int clubNo);

	int getPickedCount(int clubNo);

	public int getClublist();
	
	public ArrayList<Club> selectcatelist(PageInfo pi, String order);
	
	ArrayList<Club> selectCateFilter(Map<String, String> map, PageInfo pi);

}
