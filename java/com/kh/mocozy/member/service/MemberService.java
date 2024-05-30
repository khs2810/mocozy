package com.kh.mocozy.member.service;

import java.util.ArrayList;

import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.model.vo.Picked;

public interface MemberService {

	//로그인서비스
	Member loginMember(Member m);
	
	//id check를 위한 서비스
	int idCheck(String checkId);
	
	//회원가입
	int insertMember(Member m);
	
	//회원수정
	int updateMember(Member m, Attachment at);
	
//	유저 프로필 사진
	Attachment selectAttachment(String userId);
	
	//현재 비밀번호 확인
	String pwdCheck(String userId);
	
	//비밀번호 수정
	int updatePassword(Member m);
	
	//회원탈퇴
	Member deleteMember(Member m);
	int deleteMember(String userId);

	int pointUpdate(Request r);
	
	//cno클럽에 참여한 맴버들
	ArrayList<Member> participatedMemberList(int cno);
	
	//club pick되었는지 확인 ajax
	Picked ajaxSelectPicked(Picked p);

	int ajaxInsertPicked(Picked p);

	int ajaxDeletePicked(Picked p);

	

	

}
