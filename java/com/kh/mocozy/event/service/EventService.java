package com.kh.mocozy.event.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface EventService {
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);

	public int getEventlist();
	
	public ArrayList<Club> eventArt(PageInfo pi);
	
	public ArrayList<Club> eventFood(PageInfo pi);
	
	public ArrayList<Club> eventGame(PageInfo pi);
	
	public ArrayList<Club> eventParty(PageInfo pi);
	
	public ArrayList<Club> eventPhoto(PageInfo pi);
	
	public ArrayList<Club> eventStudy(PageInfo pi);
	
	public ArrayList<Club> eventTravel(PageInfo pi);
	
	public ArrayList<Club> eventLove(PageInfo pi);
}
