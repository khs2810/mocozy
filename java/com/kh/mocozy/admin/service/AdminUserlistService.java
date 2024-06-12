package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminUserlistService {	
	public int getMemberlist();
	
	//insertManager
	ArrayList<Member> MemberList(PageInfo mi, String sortType);
	
	//전체
	public ArrayList<Member> MemberAll(PageInfo mi, String sortType);
	public ArrayList<Member> MemberAllList();
	
	//진행중
	public ArrayList<Member> MemberActive(PageInfo mi, String sortType);
	public ArrayList<Member> MemberActiveList();
	
	//종료
	ArrayList<Member> MemberEnd(PageInfo mi, String sortType);
	public ArrayList<Member> MemberEndList();
	
	//검색리스트
	public int getMemberSearchlist(HashMap<String, String> map);

	//전체 검색
	public ArrayList<Member> MemberSearchAll(HashMap<String, String> map, PageInfo mi);
	
	//진행중 검색
	public ArrayList<Member> MemberSearchActive(HashMap<String, String> map, PageInfo mi);

	//종료된 검색
	public ArrayList<Member> MemberSearchEnd(HashMap<String, String> map, PageInfo mi);
	
	//insertManager 검색
	public ArrayList<Member> MemberSearchList(HashMap<String, String> map, PageInfo mi);
	
	
	
	

}
