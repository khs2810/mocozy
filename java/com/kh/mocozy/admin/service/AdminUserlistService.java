package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminUserlistService {	
	public int getMemberlist();
	
	//insertManager
	ArrayList<Member> insertManagerList(PageInfo mi, String sortType);
	
	//전체
	public ArrayList<Member> MemberAll(PageInfo mi, String sortType);
	public ArrayList<Member> MemberAllList();
	
	//진행중
	public ArrayList<Member> MemberActive(PageInfo mi, String sortType);
	public ArrayList<Member> MemberActiveList();
	
	//종료
	ArrayList<Member> MemberEnd(PageInfo mi, String sortType);
	public ArrayList<Member> MemberEndList();
	
	//숨김
	public ArrayList<Member> MemberHidden(PageInfo mi, String sortType);
	public ArrayList<Member> MemberHiddenList();
	
	//검색리스트
	public int getMemberSearchlist(HashMap<String, String> map);

	//전체 검색
	public ArrayList<Member> MemberSearchAll(HashMap<String, String> map, PageInfo mi);
	
	//진행중 검색
	public ArrayList<Member> MemberSearchActive(HashMap<String, String> map, PageInfo mi);

	//종료된 검색
	public ArrayList<Member> MemberSearchEnd(HashMap<String, String> map, PageInfo mi);
	
	//insertManager 검색
	public ArrayList<Member> insertManagerSearchList(HashMap<String, String> map, PageInfo mi);
	
	//숨김 검색
	public ArrayList<Member> MemberSearchHidden(HashMap<String, String> map, PageInfo mi);
	
	//숨김 처리
	public int userChangeStatus(HashMap<String, Object> map);
	
	//권한 부여
	public int ManagerstatusAjax(HashMap<String, Object> map);



	
	
	
	

}
