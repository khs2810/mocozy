package com.kh.mocozy.event.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;

@Service
public interface EventService {
	public ArrayList<Club> selecteventlist();

}
