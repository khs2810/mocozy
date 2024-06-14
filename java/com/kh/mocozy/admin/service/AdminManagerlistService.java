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
	
	//검색 리스트
	public int getManagerSearchlist(HashMap<String, String> map);

	//전체
	public ArrayList<Member> ManagerSearchAll(HashMap<String, String> map, PageInfo mi);


	
	
	
}
