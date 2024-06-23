package com.kh.mocozy.board.model.vo;

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
public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeType;
	private int userNo;
	private String noticeContent;
	private int count;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private String nickname;
	private String banner;
	private String bannerPath;
	private int replys;
	private String dateFormat;
}
