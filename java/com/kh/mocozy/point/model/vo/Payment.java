package com.kh.mocozy.point.model.vo;

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
public class Payment {
	
	private int paymentNo;
	private int clubNo;
	private int userNo;
	private int point;
	private Date paymentDate;
	private String status;
	private String club_title;
	
}
