package com.studyhub.common.vo;

import java.io.Serializable;

public class UNG implements Serializable {

	private int ungNo;
	private int userNo;
	private int groupNo;
	private int authorityNo;
	private String groupName;
	private int count;

	public UNG() {
		super();
	}

	public UNG(int ungNo, int userNo, int groupNo, int authorityNo) {
		super();
		this.ungNo = ungNo;
		this.userNo = userNo;
		this.groupNo = groupNo;
		this.authorityNo = authorityNo;
	}
	
	public UNG(int groupNo, String groupName, int count) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.count = count;
	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUngNo() {
		return ungNo;
	}

	public void setUngNo(int ungNo) {
		this.ungNo = ungNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(int authorityNo) {
		this.authorityNo = authorityNo;
	}

	@Override
	public String toString() {
		return "UNG [ungNo=" + ungNo + ", userNo=" + userNo + ", groupNo=" + groupNo + ", authorityNo=" + authorityNo
				+ "]";
	}

}
