package com.kh.mocozy.myPage.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.kh.mocozy.member.model.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyPageClub {
	private int clubNo;
	private int userNo;
	private String clubTitle;
	private String clubType;
	private String clubContent;
	private String address;
	private String addressDetail;
	private Timestamp eventDate;
	private int cost;
	private String costInfo;
	private int totalPoint;
	private int capacity;
	private String online;
	private String question;
	private String thumbnailImg;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int count;
	private String nickname;
	private String categoryName1;
	private String categoryName2;
	private String eventDateStr;
	private Member memberlist;
	private int isReview;
	private int memberCnt;
	private String profile_img;
	public ArrayList<String> profileImg;
	public int reviewCount;
	public int PickCount;
}



