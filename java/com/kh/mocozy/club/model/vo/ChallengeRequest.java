package com.kh.mocozy.club.model.vo;

import java.util.List;

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
public class ChallengeRequest {
	private List<Integer> userNos;
	private List<String> dailyStatuses;
	private int cno;
    private String challengeDate;
}
