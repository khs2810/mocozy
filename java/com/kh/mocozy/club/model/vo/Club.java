package com.kh.mocozy.club.model.vo;

import java.sql.Timestamp;
import java.util.Date;

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
public class Club {
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
}
