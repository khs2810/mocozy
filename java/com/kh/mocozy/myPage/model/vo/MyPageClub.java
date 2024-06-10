package com.kh.mocozy.myPage.model.vo;

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
public class MyPageClub {
	private int userNo;
	private int clubNo;
	private String clubTitle;
	private String status;
	private String thumbnailImg;
}



