package com.kh.mocozy.point.model.vo;

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
public class PointDTO {
	private int pointNo;
	private int userNo;
	private int point;
	private Date createDate;
	private String status;
	private String dateFormat;
	private String pointFormat;
	private int adminNo;
	private String pointInfo;
	private String userNickname;
	private String adminNickname;
	
	public PointDTO(Point point) {
        this.pointNo = point.getPointNo();
        this.userNo = point.getUserNo();
        this.point = point.getPoint();
        this.createDate = point.getCreateDate();
        this.status = point.getStatus();
        this.dateFormat = point.getDateFormat();
        this.pointFormat = point.getPointFormat();
        this.adminNo = point.getAdminNo();
        this.pointInfo = point.getPointInfo();
    }
}
