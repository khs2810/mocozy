package com.kh.mocozy.catePage.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;

@Service
public interface CateService {
	public ArrayList<Club> selectcatelist();

}
