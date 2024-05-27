package com.kh.mocozy.member.service;

import com.kh.mocozy.member.model.vo.Member;

public interface MemberService {

	//로그인서비스
	Member loginMember(Member m);
	
	//id check를 위한 서비스
	int idCheck(String checkId);
	
	//회원가입
	int insertMember(Member m);
	
	//회원수정
	int updateMember(Member m);
	
	//회원탈퇴
	Member deleteMember(Member m);
	int deleteMember(String userId);

}
