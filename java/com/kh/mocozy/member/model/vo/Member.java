package com.kh.mocozy.member.model.vo;

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
public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private String nickname;
	private String phone;
	private Date birth;
	private Date enroll_date;
	private Date modify_date;
	private String introduce;
	private String profileImg;
	private int point;
	private String status;
	private String admin;
		
}
