package com.kh.mocozy.club.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Challenge;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.myPage.model.vo.MyPageClub;

@Repository
public class ClubDao {

	public int increaseCount(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.increaseCount", cno);
	}

	public Club selectClub(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("clubMapper.selectClub", cno);
	}

	public ArrayList<ClubReview> listReview(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("clubMapper.listReview", cno);
	}
	
	public int insertClub(SqlSessionTemplate sqlSession, Club c) {
		int result = 0;
		
		sqlSession.insert("clubMapper.insertClub", c);
		
		result = c.getClubNo();
		
		return result;
	}

	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment at) {
		return sqlSession.insert("attachmentMapper.insertAttachment", at);
	}

	public int insertChMember(SqlSessionTemplate sqlSession, Club c) {
		return sqlSession.insert("challengeMapper.insertChMember", c);
	}

	public ArrayList<Club> listClub(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.listClub", uno);
	}

	public ArrayList<Club> selectClubList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectClubList", uno);
	}

	public ArrayList<Request> selectRequestList(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectRequestList", cno);
	}

	public int acceptRequest(SqlSessionTemplate sqlSession, int rqno) {
		return sqlSession.update("clubMapper.acceptRequest", rqno);
	}

	public int insertRequest(SqlSessionTemplate sqlSession, Request r) {
		return sqlSession.insert("clubMapper.insertRequest", r);
	}

	public int denyRequest(SqlSessionTemplate sqlSession, int rqno) {
		return sqlSession.update("clubMapper.denyRequest", rqno);
	}

	public int updateClub(SqlSessionTemplate sqlSession, Club c) {
		return sqlSession.update("clubMapper.updateClub", c);
	}
	
	public Attachment selectAttachment(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("attachmentMapper.selectAttachment", cno);
	}

	public int updateAttachment(SqlSessionTemplate sqlSession, Attachment at) {
		return sqlSession.update("attachmentMapper.updateAttachment", at);
	}

	public int selectCountReview(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("clubMapper.selectCountReview", cno);
	}

	public int insertReviewList(SqlSessionTemplate sqlSession, ClubReview r) {
		return sqlSession.insert("clubMapper.insertClubReview", r);
	}

	public ClubReview selectClubReview(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.selectOne("clubMapper.selectClubReview", map);
	}

	public ArrayList<Club> selectMySocialList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMySocialList", uno);
	}

	public int insertPayment(SqlSessionTemplate sqlSession, Request r) {
		return sqlSession.insert("pointMapper.insertPayment", r);
	}

	public ArrayList<Club> selectMySocialListDone(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMySocialListDone", uno);
	}

	public int finishSocial(SqlSessionTemplate sqlSession, int cno) {
		int result1 = sqlSession.update("clubMapper.finishSocial", cno);
		int result2 = sqlSession.update("clubMapper.finishRequest", cno);
		return result1 * result2;
	}

	public int cancleFinishSocial(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.cancleFinishSocial", cno);
	}

	public int clubRequestReset(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.clubRequestReset", cno);
	}

	public ArrayList<Club> selectGoSocialList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectGoSocialList", uno);
	}

	public ArrayList<Club> selectGoSocialListDone(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectGoSocialListDone", uno);
	}

	public ArrayList<Club> selectMyChallengeList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMyChallengeList", uno);
	}

	public ArrayList<Club> selectMyChallengeListDone(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMyChallengeListDone", uno);
	}

	public int finishChallenge(SqlSessionTemplate sqlSession, int cno) {
		int result1 = sqlSession.update("clubMapper.finishChallenge", cno);
		int result2 = sqlSession.update("clubMapper.finishRequest",cno);
		return result1 * result2;
	}

	public int cancleFinishChallenge(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.cancleFinishChallenge", cno);
	}

	public int quitClub(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.update("clubMapper.quitClub", map);
	}

	public int insertMemberChallengeStatus(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.insert("challengeMapper.insertStatus", map);
	}

	public ArrayList<Map<String, Object>> getMemberStatusForDate(SqlSessionTemplate sqlSession, Map<String, Object> paramMap) {
		return (ArrayList)sqlSession.selectList("challengeMapper.getMemberStatusForDate", paramMap);
	}

	public int selectChallengeCount(SqlSessionTemplate sqlSession, Challenge challenge) {
	    List<Integer> counts = sqlSession.selectList("challengeMapper.selectChallengeCount", challenge);
	    if (!counts.isEmpty()) {
	        return counts.get(0);
	    } else {
	        return 0;
	    }
	}

	public int insertMemberChallengeStatus(SqlSessionTemplate sqlSession, Challenge challenge) {
		return sqlSession.insert("challengeMapper.insertChallenge", challenge);
	}
	
//	최근 찜 소셜링 리스트
	public ArrayList<Club> selectMyDibsSocialList(SqlSessionTemplate sqlSession, Club club) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMyDibsSocialList", club);
	}

	public ArrayList<Request> selectListRequestNotF(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectListRequestNotF", cno);
	}

	public int deleteClub(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.deleteClub", cno);
	}

	public List<Club> selectMyDibsChallengeList(SqlSessionTemplate sqlSession, Club club) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectMyDibsChallengeList", club);
	}

	public int getPointWithCno(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("clubMapper.getPointWithCno", cno);
	}
	
	public int finishClubChallenge(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("challengeMapper.finishClubChallenge", cno);
	}

	public int cancleFinishClubChallenge(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("challengeMapper.cancleFinishClubChallenge", cno);
	}

	public int calculatePayment(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("pointMapper.calculatePayment", cno);
	}

	public int addTotalPoint(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.update("clubMapper.addTotalPoint", cno);
	}

	public ArrayList<Club> selectGoChallengeList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectGoChallengeList", uno);
	}

	public ArrayList<Club> selectGoChallengeListDone(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectGoChallengeListDone", uno);
	}
}