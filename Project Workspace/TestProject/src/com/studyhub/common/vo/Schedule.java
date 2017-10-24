package com.studyhub.common.vo;

import java.sql.Date;

public class Schedule implements java.io.Serializable{
	private int scheduleNo;
	private int groupNo;
	private String meetingDate;
	private String ampm;
	private int hour;
	private int minute;
	private String onoff;
	private String meetingName;
	
	public Schedule() {
		super();
	}
	
	public Schedule(int scheduleNo, int groupNo, String meetingDate, String ampm, int hour, int minute, String onoff,
			String meetingName) {
		super();
		this.scheduleNo = scheduleNo;
		this.groupNo = groupNo;
		this.meetingDate = meetingDate;
		this.ampm = ampm;
		this.hour = hour;
		this.minute = minute;
		this.onoff = onoff;
		this.meetingName = meetingName;
	}
	public int getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getOnoff() {
		return onoff;
	}
	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", groupNo=" + groupNo + ", meetingDate=" + meetingDate
				+ ", ampm=" + ampm + ", hour=" + hour + ", minute=" + minute + ", onoff=" + onoff + ", meetingName="
				+ meetingName + "]";
	}
}