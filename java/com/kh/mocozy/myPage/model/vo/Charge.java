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
public class Charge {
	
	private int userNo;
	private String month;
	private int totalCharge;
	private int totalAmount;
	
}
