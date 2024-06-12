package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminManagerlistService {

	public int getManagerlist();
	
	//전체
	ArrayList<Member> ManagerAll(PageInfo mi);

	public ArrayList<Member> MemberAllList();
	
	//활동중
	public ArrayList<Member> ManagerActive(PageInfo mi);

	public ArrayList<Member> MemberActiveList();
	
	//종료
	public ArrayList<Member> ManagerEnd(PageInfo mi);

	public ArrayList<Member> MemberEndList();
	
	
}
