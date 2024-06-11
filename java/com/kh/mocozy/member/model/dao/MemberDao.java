package com.kh.mocozy.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.model.vo.Picked;

@Repository
public class MemberDao {
	public Member loginMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int idCheck(SqlSessionTemplate sqlSession, String checkId) {
		return sqlSession.selectOne("memberMapper.idCheck", checkId);
	}
	
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public int updateMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}
	
	public String pwdCheck(SqlSessionTemplate sqlSession, String userPwd) {
		return sqlSession.selectOne("memberMapper.pwdCheck", userPwd);
	}
	
	public int updatePassword(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updatePassword", m);
	}
	
	public int deleteMember(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.update("memberMapper.deleteMember", userId );
	}

	public int pointUpdateRq(SqlSessionTemplate sqlSession, Request r) {
		return sqlSession.update("memberMapper.updatePointRq", r);
	}

	public ArrayList<Member> participatedMemberList(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("memberMapper.participatedMemberList", cno);
	}

	public Picked ajaxSelectPicked(SqlSessionTemplate sqlSession, Picked p) {
		return sqlSession.selectOne("memberMapper.ajaxSelectPicked", p);
	}

	public int ajaxInsertPicked(SqlSessionTemplate sqlSession, Picked p) {
		return sqlSession.insert("memberMapper.ajaxInsertPicked", p);
	}

	public int ajaxDeletePicked(SqlSessionTemplate sqlSession, Picked p) {
		return sqlSession.insert("memberMapper.ajaxDeletePicked", p);
	}

	
	public ArrayList<Member> requestMemberList(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("memberMapper.requestMemberList", cno);
	}

	public int chargePoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.chargePoint", m);
	}

	public int withdrawPoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.withdrawPoint", m);
	}
	
	public Attachment insertAttachment(SqlSessionTemplate sqlSession, int uno) {
		return null;
	}

	public Member selectClubLeader(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("memberMapper.selectClubLeader", cno);
	}

	public int getUserNoByUserId(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.getUserNoByUserId", userId);
	}

	public String selectNicknameByUserNo(SqlSessionTemplate sqlSession, int userNo) {
		return sqlSession.selectOne("selectNicknameByUserNo", userNo);
	}
	
	
}
