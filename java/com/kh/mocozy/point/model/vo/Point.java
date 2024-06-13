package com.kh.mocozy.point.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Point {
	
	private int pointNo;
	private int userNo;
	private int point;
	private Date createDate;
	private String status;
	private String pointType;
	private String dateFormat;
	private String pointFormat;
	private int adminNo;
	private String pointInfo;
	
}
