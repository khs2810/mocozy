package com.kh.mocozy.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.dao.MemberDao;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member loginMember(Member m) {
			
		return memberDao.loginMember(sqlSession, m);
	}

	@Override
	public int idCheck(String checkId) {
		return memberDao.idCheck(sqlSession, checkId);
	}

	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(sqlSession, m);
	}

	@Override
	public int updateMember(Member m, Attachment at) {
		return memberDao.updateMember(sqlSession, m);
	}
	
	@Override
	public int updatePassword(Member m) {
		return memberDao.updatePassword(sqlSession, m);
	}
	
	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(sqlSession, userId);
	}

	@Override
	public int pointUpdate(Request r) {
		return memberDao.pointUpdate(sqlSession, r);
	}

	@Override
	public ArrayList<Member> participatedMemberList(int cno) {
		return memberDao.participatedMemberList(sqlSession, cno);
	}

	@Override
	public Member deleteMember(Member m) {
		return null;
	}
	
}
