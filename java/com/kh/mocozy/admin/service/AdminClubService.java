package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminClubService {
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int userNo);

	public int getClublist();
	
	//전체
	public ArrayList<Club> selectClublist(PageInfo ci, String sortType);

	ArrayList<Club> getClubAllList();
	
	//진행중
	ArrayList<Club> selectClubProcess(PageInfo ci, String sortType);

	ArrayList<Club> getClubProcessList();

	//종료
	ArrayList<Club> selectClubEnd(PageInfo ci, String sortType);

	ArrayList<Club> getClubEndList();
	
	//검색 개수
	int getClubSearchlist(HashMap<String, String> map);
	
	//전체 검색
	ArrayList<Club> selectSearchClublist(HashMap<String, String> map, PageInfo ci);
	
	//진행중 검색
	ArrayList<Club> selectClubSearchProcess(HashMap<String, String> map, PageInfo ci);
	
	//종료 검색
	ArrayList<Club> selectClubSearchEnd(HashMap<String, String> map, PageInfo ci);
	
	
}
