package com.kh.mocozy.admin.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface AdminUserlistService {	
	public int getMemberlist();
	
	//insertManager + 전체
	ArrayList<Member> MemberList(PageInfo mi);
	
	//전체
	public ArrayList<Member> MemberAllList();
	
	//진행중
	public ArrayList<Member> MemberActive(PageInfo mi);
	public ArrayList<Member> MemberActiveList();
	
	//종료
	ArrayList<Member> MemberEnd(PageInfo mi);
	public ArrayList<Member> MemberEndList();

	

}
