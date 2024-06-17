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
public class ChatRoom {
	private int chatNo;
	private Date createDate;
	private int clubNo;
	private int masterNo;
	private String lastMessage;
	private int targetNo;
	private String targetNickname;
	private String targetProfile;
	private int notReadCount;
	private String roomTitle;
}
