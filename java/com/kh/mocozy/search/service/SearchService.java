package com.kh.mocozy.search.service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface SearchService {
	public int searchCount();
	
	public ArrayList<Club> selectSearchList(HashMap<String, String> map, PageInfo re);
	
	public int searchForm(HashMap<String, String> map);
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);
	
	//챌린지, 클럽
	ArrayList<Club> getSocialing(PageInfo pi);
	
	ArrayList<Club> getChallenge(PageInfo pi);

    int getReviewCount(int clubNo);

	int getPickedCount(int clubNo);
}
