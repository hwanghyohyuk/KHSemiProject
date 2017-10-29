package com.studyhub.common.vo;

import java.sql.Date;

public class Schedule implements java.io.Serializable{
	private int scheduleNo;
	private int groupNo;
	private String meetingDate;
	private String ampm;
	private String hour;
	private String minute;
	private String onoff;
	private String meetingName;
	private String datetypeDate;
	
	public Schedule() {
		super();
	}
	
	public Schedule(int scheduleNo, int groupNo, String meetingDate, String ampm, String hour, String minute, String onoff,
			String meetingName, String datetypeDate) {
		super();
		this.scheduleNo = scheduleNo;
		this.groupNo = groupNo;
		this.meetingDate = meetingDate;
		this.ampm = ampm;
		this.hour = hour;
		this.minute = minute;
		this.onoff = onoff;
		this.meetingName = meetingName;
		this.datetypeDate = datetypeDate;
	}

	public Schedule(int scheduleNo, int groupNo, String meetingDate, String ampm, String hour, String minute,
			String onoff, String meetingName) {
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

	public Schedule(int scheduleNo, String meetingDate, String ampm, String hour, String minute, String meetingName) {
		super();
		this.scheduleNo = scheduleNo;
		this.meetingDate = meetingDate;
		this.ampm = ampm;
		this.hour = hour;
		this.minute = minute;
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
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
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
	public String getDatetypeDate() {
		return datetypeDate;
	}

	public void setDatetypeDate(String datetypeDate) {
		this.datetypeDate = datetypeDate;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", groupNo=" + groupNo + ", meetingDate=" + meetingDate
				+ ", ampm=" + ampm + ", hour=" + hour + ", minute=" + minute + ", onoff=" + onoff + ", meetingName="
				+ meetingName + "]";
	}
}