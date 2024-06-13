package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminManagerlistService {

	public int getManagerlist();
	
	//전체
	ArrayList<Member> ManagerAll(PageInfo mi, String sortType);
	public ArrayList<Member> MemberAllList();
	
	//활동중
	public ArrayList<Member> ManagerActive(PageInfo mi, String sortType);
	public ArrayList<Member> MemberActiveList();
	
	//종료
	public ArrayList<Member> ManagerEnd(PageInfo mi, String sortType);
	public ArrayList<Member> MemberEndList();
	
	//검색 리스트
	public int getManagerSearchlist(HashMap<String, String> map);

	//전체
	public ArrayList<Member> ManagerSearchAll(HashMap<String, String> map, PageInfo mi);

	//진행중
	public ArrayList<Member> ManagerSearchActive(HashMap<String, String> map, PageInfo mi);

	//종료됨
	public ArrayList<Member> ManagerSearchEnd(HashMap<String, String> map, PageInfo mi);
	
	
	
	
}
