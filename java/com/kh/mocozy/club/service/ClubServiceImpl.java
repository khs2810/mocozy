package com.kh.mocozy.club.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mocozy.club.model.dao.ClubDao;
import com.kh.mocozy.club.model.vo.Challenge;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.dao.MemberDao;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.point.model.dao.PointDao;
import com.kh.mocozy.point.model.vo.Payment;

@Service
public class ClubServiceImpl implements ClubService { 
	
	@Autowired
	private ClubDao clubDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private PointDao pointDao;
	@Autowired
	private MemberDao memberDao;
	
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
	
	@Transactional
	@Override
	public int insertClub(Club c, Attachment at) {
		
		int result1 = clubDao.insertClub(sqlSession, c);
		int result2 = 1;
		
		if (result1 > 0) {
			result2 = clubDao.insertAttachment(sqlSession, at);			
		}
		
		return result1 * result2;
	}

	@Override
	public int insertChMember(Challenge ch) {
		return clubDao.insertChMember(sqlSession, ch);
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

	@Transactional
	@Override
	public int acceptRequest(int rqno, int cno) {
		int result1 = clubDao.acceptRequest(sqlSession, rqno);
		int result2 = clubDao.addTotalPoint(sqlSession, cno);
		
		return result1 * result2;
	}
	
	@Transactional
	@Override
	public String insertRequest(Request r) {
		
		String result = null;
		
		int r1 = clubDao.insertPayment(sqlSession, r);
		int r2 = clubDao.insertRequest(sqlSession, r);
		int r3 = memberDao.pointUpdateRq(sqlSession, r);
		
		if (r1 * r2 * r3 == 0) {
			result = "모임 참가 신청 실패";
		}
		
		return result;
	}

	public int denyRequest(int rqno) {
		return clubDao.denyRequest(sqlSession, rqno);
	}
	
	@Override
	public Attachment selectAttachment(int cno) {
		return clubDao.selectAttachment(sqlSession, cno);
	}
	
	@Transactional
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
	public int selectCountReview(int cno, int uno) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("cno", cno);
		map.put("uno", uno);
		
		return clubDao.selectCountReview(sqlSession, map);
	}

	@Transactional
	@Override
	public int insertClubReview(ClubReview r, Club c) {
		ArrayList<ClubReview> rList = clubDao.selectClubReviewList(sqlSession, r.getClubNo());
		int totalPoint = c.getTotalPoint();	// 해당 모임의 리뷰 점수 합계
		int reviewCnt = rList.size();	// 해당 모임의 리뷰 갯수
		int reviewScore = r.getGrade();	// 작성한 리뷰 점수
		
		int result1 = clubDao.insertReviewList(sqlSession, r);
		
		int score = ((totalPoint) * reviewCnt + reviewScore) / (reviewCnt + 1);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("cno", c.getClubNo());
		map.put("score", score);
		
		int result2 = clubDao.updateClubTotalPoint(sqlSession, map);
		return result1 * result2;
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

	@Transactional
	@Override
	public int finishChallenge(int cno, int uno) {
		ArrayList<Integer> successedUserList = clubDao.selectSuccessedUserList(sqlSession, cno);	// 챌린지 성공한 사람들의 userNo
		int successedUserCnt = successedUserList.size();	// 챌린지 성공한 사람들 수
		int challengeTotalPoint = clubDao.selectChallengeTotalPoint(sqlSession, cno);	// 챌린지 총 상금
		int challengeRewardPoint = 0;	// 인당 챌린지 상금(아무도 성공 못했을 때)
		if (successedUserCnt > 0) {
			challengeRewardPoint = challengeTotalPoint / successedUserCnt;	// 인당 챌린지 상금(성공한 멤버가 있을 때)
		}
		HashMap<String, Integer> map = new HashMap<>();
		map.put("uno", uno);
		map.put("reward", challengeRewardPoint);
		
		int result3 = 1;
		for(int successedUser : successedUserList) {
			Member m = new Member();
			
			m.setUserNo(successedUser);
			m.setPoint(challengeRewardPoint);
			
			int result = memberDao.chargePoint(sqlSession, m);
			if (result == 0) {
				result3 = 0;
			}
		}
		
		int result1 = clubDao.finishChallenge(sqlSession, cno);
		if (result1 > 0) {
			clubDao.finishClubChallenge(sqlSession, cno);
		}
		int result2 = clubDao.calculateReward(sqlSession, map);
		return result1 * result2 * result3;
	}

	@Transactional
	@Override
	public int cancleFinishChallenge(int cno) {
		int result = clubDao.cancleFinishChallenge(sqlSession, cno);
		if (result > 0) {
			clubDao.cancleFinishClubChallenge(sqlSession, cno);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int quitClub(HashMap<String, Integer> map) {
		
		int result = clubDao.quitClub(sqlSession, map);
		int point = clubDao.getPointWithCno(sqlSession, map.get("cno"));
		Member m = new Member();
		m.setUserNo(map.get("uno"));
		m.setPoint(point);
		int result2 = pointDao.refundPoint(sqlSession, m);
		int result3 = memberDao.refundPoint(sqlSession, m);
		
		return result * result2 * result3;
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
	
	@Transactional
	@Override
	public int deleteClub(ArrayList<Request> rlist, int cno) {
		
		if (!rlist.isEmpty()) {
			int result1 = 0;
			int result2 = 0;
			
			for (Request r : rlist) {
				result1 = 0;
				result2 = 0;
				//리퀘스트의 페이먼트 정보 가져오기
				Payment p = pointDao.selectPayment(sqlSession, r.getPaymentNo());
				//페이먼트  취소 (status C)처리
				result1 = pointDao.cancelPayment(sqlSession, p);
				result2 = pointDao.returnPoint(sqlSession, p);
				
				if (result1 * result2 == 0) {
					break;
				}
			}
		}
		return clubDao.deleteClub(sqlSession, cno);
	}

	@Override
	public List<Club> selectMyDibsChallengeList(Club club) {
		return clubDao.selectMyDibsChallengeList(sqlSession, club);
	}

	@Override
	public ArrayList<Club> selectGoChallengeList(int uno) {
		return clubDao.selectGoChallengeList(sqlSession, uno);
	}

	@Override
	public ArrayList<Club> selectGoChallengeListDone(int uno) {
		return clubDao.selectGoChallengeListDone(sqlSession, uno);
	}
}
