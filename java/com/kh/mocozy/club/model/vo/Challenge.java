package com.kh.mocozy.club.model.vo;

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
public class Challenge {
	private int challengeNo;
	private int userNo;
	private int clubNo;
	private Date detailDate;
	private String dailyStatus;
	private String status;
	private int masterNo;
}
