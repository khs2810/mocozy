package com.kh.mocozy.catePage.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface CateService {
	public ArrayList<Club> selectcatelist();
	
	//프로필 사진 가져오기
	ArrayList<Member> MemberList(int clubNo);
}
