package com.studyhub.common.vo;

import java.sql.Date;

public class Schedule {
	private int scheduleNo;
	private Date meetingDate;
	private int groupNo;
	private int ungNo;
	private String meetingName;

	public Schedule() {
		super();
	}

	public Schedule(int scheduleNo, Date meetingDate, int groupNo, int ungNo, String meetingName) {
		super();
		this.scheduleNo = scheduleNo;
		this.meetingDate = meetingDate;
		this.groupNo = groupNo;
		this.ungNo = ungNo;
		this.meetingName = meetingName;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getUngNo() {
		return ungNo;
	}

	public void setUngNo(int ungNo) {
		this.ungNo = ungNo;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", meetingDate=" + meetingDate + ", groupNo=" + groupNo
				+ ", ungNo=" + ungNo + ", meetingName=" + meetingName + "]";
	}

}
