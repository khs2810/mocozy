package com.kh.mocozy.event.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface EventService {
	public ArrayList<Club> selecteventlist();
	
	public ArrayList<Club> selectArt();
	
	public ArrayList<Club> selectActivity();
	
	public ArrayList<Club> selectFood();
	
	public ArrayList<Club> selectHobby();
	
	public ArrayList<Club> selectTravel();
	
	public ArrayList<Club> selectDevelope();
	
	public ArrayList<Club> selectInvest();
	
	public ArrayList<Club> selectLove();
	
	public ArrayList<Club> selectForeign();
	
	public ArrayList<Club> selectGame();
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);
	
	//챌린지, 클럽
	ArrayList<Club> getSocialing(PageInfo pi);
	
	ArrayList<Club> getChallenge(PageInfo pi);

    int getReviewCount(int clubNo);

	int getPickedCount(int clubNo);
}
