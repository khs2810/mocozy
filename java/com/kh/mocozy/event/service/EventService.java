package com.kh.mocozy.event.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface EventService {
	public ArrayList<Club> selecteventlist();
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);
}
