package com.kh.mocozy.club.model.vo;

import java.sql.Timestamp;
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
public class Request {
	private int requestNo;
	private int userNo;
	private int clubNo;
	private String answer;
	private Timestamp createDate;
	private String status;
}
