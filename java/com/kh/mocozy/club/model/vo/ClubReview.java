package com.kh.mocozy.club.model.vo;

import java.sql.Date;

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
public class ClubReview {
	private int clubReviewNo;
	private String reviewContent;
	private Date createDate;
	private Date modifyDate;
	private int grade;
	private String status;
	private int clubNo;
	private int userNo;
	private String nickname;
}

