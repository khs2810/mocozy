package com.kh.mocozy.club.model.vo;

import java.sql.Timestamp;

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
public class Message {
	private int messageNo;
	private String messageContent;
	private Timestamp sendTime;
	private int senderNo;
	private int chatroomNo;
	private int targetNo;
	private String nick;
}
