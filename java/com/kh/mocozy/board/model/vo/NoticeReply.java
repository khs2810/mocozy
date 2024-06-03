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
public class NoticeReply {
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private Date modifyDate;
	private String status;
	private int noticeNo;
	private int userNo;
	private String nickname;
	private String dateFormat;
}
