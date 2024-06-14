package com.kh.mocozy.club.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.dao.ClubDao;
import com.kh.mocozy.club.model.vo.Challenge;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;

@Service
public class ClubServiceImpl implements ClubService { 
	
	@Autowired
	private ClubDao clubDao;
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	@Override
	public int increaseCount(int cno) {
		return clubDao.increaseCount(sqlSession, cno);
	}

	@Override
	public Club selectClub(int cno) {
		return clubDao.selectClub(sqlSession, cno);
	}

	@Override
	public ArrayList<ClubReview> listReview(int cno) {
		return clubDao.listReview(sqlSession, cno);
	}
	
	
	public int insertClub(Club c, Attachment at) {
		
		int result1 = clubDao.insertClub(sqlSession, c);
		int result2 = 1;
		
		if (result1 > 0) {
			result2 = clubDao.insertAttachment(sqlSession, at);			
		}
		
		return result1 * result2;
	}

	@Override
	public int insertChMember(Club c) {
		return clubDao.insertChMember(sqlSession, c);
	}

	@Override
	public ArrayList<Club> listClub(int uno) {
		return clubDao.listClub(sqlSession, uno);
	}

	@Override
	public ArrayList<Club> selectClubList(int uno) {
		return clubDao.selectClubList(sqlSession, uno);
	}

	@Override
	public ArrayList<Request> requestList(int cno) {
		return clubDao.selectRequestList(sqlSession, cno);
	}

	@Override
	public int acceptRequest(int rqno) {
		return clubDao.acceptRequest(sqlSession, rqno);
	}

	@Override
	public int insertRequest(Request r) {
		return clubDao.insertRequest(sqlSession, r);
	}

	public int denyRequest(int rqno) {
		return clubDao.denyRequest(sqlSession, rqno);
	}
	
	@Override
	public Attachment selectAttachment(int cno) {
		return clubDao.selectAttachment(sqlSession, cno);
	}

	@Override
	public int updateClub(Club c, Attachment at) {
		int result1 = clubDao.updateClub(sqlSession, c);
		int result2 = 1;
		
		if (result1 > 0) {
			result2 = clubDao.updateAttachment(sqlSession, at);
		}
		
		return result1 * result2;
	}

	@Override
	public int selectCountReview(int cno) {
		return clubDao.selectCountReview(sqlSession, cno);
	}

	@Override
	public int insertClubReview(ClubReview r) {
		return clubDao.insertReviewList(sqlSession, r);
	}

	@Override
	public ClubReview selectClubReview(HashMap<String, Integer> map) throws Exception {
		return clubDao.selectClubReview(sqlSession, map);
	}

	@Override
	public ArrayList<Club> selectMySocialList(int uno) {
		return clubDao.selectMySocialList(sqlSession, uno);
	}

	@Override
	public int insertPayment(Request r) {
		return clubDao.insertPayment(sqlSession, r);
	}

	@Override
	public ArrayList<Club> selectMySocialListDone(int uno) {
		return clubDao.selectMySocialListDone(sqlSession, uno);
	}

	@Override
	public int finishSocial(int cno) {
		return clubDao.finishSocial(sqlSession, cno);
	}

	@Override
	public int cancleFinishSocial(int cno) {
		return clubDao.cancleFinishSocial(sqlSession, cno);
	}

	@Override
	public int clubRequestReset(int cno) {
		return clubDao.clubRequestReset(sqlSession, cno);
	}

	@Override
	public ArrayList<Club> selectGoSocialList(int uno) {
		return clubDao.selectGoSocialList(sqlSession, uno);
	}

	@Override
	public ArrayList<Club> selectGoSocialListDone(int uno) {
		return clubDao.selectGoSocialListDone(sqlSession, uno);
	}

	@Override
	public ArrayList<Club> selectMyChallengeList(int uno) {
		return clubDao.selectMyChallengeList(sqlSession, uno);
	}

	@Override
	public ArrayList<Club> selectMyChallengeListDone(int uno) {
		return clubDao.selectMyChallengeListDone(sqlSession, uno);
	}

	@Override
	public int finishChallenge(int cno) {
		return clubDao.finishChallenge(sqlSession, cno);
	}

	@Override
	public int cancleFinishChallenge(int cno) {
		return clubDao.cancleFinishChallenge(sqlSession, cno);
	}

	@Override
	public int quitClub(HashMap<String, Integer> map) {
		return clubDao.quitClub(sqlSession, map);
	}

	@Override
	public int insertMemberChallengeStatus(HashMap<String, String> map) {
		return clubDao.insertMemberChallengeStatus(sqlSession, map);
	}

	@Override
	public ArrayList<Map<String, Object>> getMemberStatusForDate(int cno, Timestamp challengeDateTimestamp) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cno", cno);
		paramMap.put("challengeDateTimestamp", challengeDateTimestamp);
		return clubDao.getMemberStatusForDate(sqlSession, paramMap);
	}

	@Override
	public boolean checkChallengeExists(Challenge Challenge) {
		return clubDao.selectChallengeCount(sqlSession, Challenge) > 0;
	}

	@Override
	public int saveChallenge(Challenge Challenge) {
		return clubDao.insertMemberChallengeStatus(sqlSession, Challenge);
	}
//	찜 소셜링 리스트
	@Override
	public ArrayList<Club> selectMyDibsSocialList(Club club) {
		return clubDao.selectMyDibsSocialList(sqlSession, club);
	}

	@Override
	public ArrayList<Request> selectListRequestNotF(int cno) {
		return clubDao.selectListRequestNotF(sqlSession, cno);
	}

	@Override
	public int deleteClub(int cno) {
		return clubDao.deleteClub(sqlSession, cno);
	}
}
