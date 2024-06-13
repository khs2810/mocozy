package com.kh.mocozy.club.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mocozy.club.model.vo.Challenge;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.ClubReview;
import com.kh.mocozy.club.model.vo.Request;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.myPage.model.vo.MyPageClub;

public interface ClubService {
	
	//클럽 조회수 증가
	int increaseCount(int cno);
	
	//클럽 조회
	Club selectClub(int cno);
	
	//클럽 리뷰 조회
	ArrayList<ClubReview> listReview(int cno);

	// 클럽 추가
	int insertClub(Club c, Attachment at);

	int insertChMember(Club c);

	ArrayList<Club> listClub(int uno);

	ArrayList<Club> selectClubList(int uno);

	ArrayList<Request> requestList(int cno);

	int acceptRequest(int rqno);

	int insertRequest(Request r);


	int denyRequest(int rqno);

	Attachment selectAttachment(int cno);
	
	int updateClub(Club c, Attachment at);

	int selectCountReview(int cno);

	int insertClubReview(ClubReview r);

	ClubReview selectClubReview(HashMap<String, Integer> map) throws Exception;

	ArrayList<Club> selectMySocialList(int uno);

	int insertPayment(Request r);

	ArrayList<Club> selectMySocialListDone(int uno);

	int finishSocial(int cno);

	int cancleFinishSocial(int cno);

	int clubRequestReset(int cno);

	ArrayList<Club> selectGoSocialList(int uno);

	ArrayList<Club> selectGoSocialListDone(int uno);

	ArrayList<Club> selectMyChallengeList(int uno);

	ArrayList<Club> selectMyChallengeListDone(int uno);

	int finishChallenge(int cno);

	int cancleFinishChallenge(int cno);

	int quitClub(HashMap<String, Integer> map);

	int insertMemberChallengeStatus(HashMap<String, String> map);

	ArrayList<Map<String, Object>> getMemberStatusForDate(int cno, Timestamp challengeDateTimestamp);

	boolean checkChallengeExists(Challenge Challenge);

	int saveChallenge(Challenge Challenge);
	
//	내가 찜한 소셜링 리스트
	List<Club> selectMyDibsSocialList(Club club);
}
