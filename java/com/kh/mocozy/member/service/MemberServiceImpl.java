package com.kh.mocozy.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.dao.MemberDao;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.model.vo.Picked;

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

//	프로필 사진첨부
	@Override
	public Attachment insertAttachment(int uno) {
		return memberDao.insertAttachment(sqlSession, uno);
	}

//	비밀번호 체크
	@Override
	public String pwdCheck(String userId) {
		
		return memberDao.pwdCheck(sqlSession, userId);
	}
	
//	닉네임체크
	@Override
	public int nickNameCheck(String checkNickName) {
		return memberDao.nickNameCheck(sqlSession, checkNickName);
	}
	
//	아이디체크
	@Override
	public int idCheck(String checkId) {
		return memberDao.idCheck(sqlSession, checkId);
	}

//	회원가입
	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(sqlSession, m);
	}

//	회원정보 수정
	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(sqlSession, m);
	}
	
//	비번체크
	public String pwdCheck(Member m, String userId) {
        return memberDao.pwdCheck(sqlSession, userId);
    }
	
//	비번변경
	@Override
	public int updatePassword(Member m) {
		return memberDao.updatePassword(sqlSession, m);
	}
	
//	회원탈퇴
	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(sqlSession, userId);
	}

	@Override
	public int pointUpdateRq(Request r) {
		return memberDao.pointUpdateRq(sqlSession, r);
	}

	@Override
	public ArrayList<Member> participatedMemberList(int cno) {
		return memberDao.participatedMemberList(sqlSession, cno);
	}

	@Override
	public Member deleteMember(Member m) {
		return null;
	}
//	club pick되었는지 확인
	@Override
	public Picked ajaxSelectPicked(Picked p) {
		return memberDao.ajaxSelectPicked(sqlSession, p);
	}

	@Override
	public int ajaxInsertPicked(Picked p) {
		return memberDao.ajaxInsertPicked(sqlSession, p);
	}

	@Override
	public int ajaxDeletePicked(Picked p) {
		return memberDao.ajaxDeletePicked(sqlSession, p);
	}

	@Override
	public ArrayList<Member> requestMemberList(int cno) {
		return memberDao.requestMemberList(sqlSession, cno);
	}

	@Override
	public int chargePoint(Member m) {
		return memberDao.chargePoint(sqlSession, m);
	}

	@Override
	public int withdrawPoint(Member m) {
		return memberDao.withdrawPoint(sqlSession, m);
	}

	@Override
	public Member selectClubLeader(int cno) {
		return memberDao.selectClubLeader(sqlSession, cno);
	}

	@Override
	public int getUserNoByUserId(String userId) {
		return memberDao.getUserNoByUserId(sqlSession, userId);
	}

	@Override
	public String selectNicknameByUserNo(int userNo) {
		return memberDao.selectNicknameByUserNo(sqlSession, userNo);
	}

	@Override
	public Member findUserByEmail(String email) {
		return memberDao.findUserByEmail(sqlSession,email);
	}
	
}
