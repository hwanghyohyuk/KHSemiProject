package com.studyhub.common.vo;

import java.io.Serializable;

public class UNG implements Serializable {

	private int ungNo;
	private int userNo;
	private int groupNo;
	private int authorityNo;
	private String groupName;
	private int count;
	private String renameimg;
	private String email;
	private String userName;
	private int ungState;

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
	
	public UNG(int groupNo, String groupName, int count, String renameimg) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.count = count;
		this.renameimg = renameimg;
	}
	
	public UNG(int ungNo, String email, String userName, int ungState, int authorityNo) {
		super();
		this.ungNo = ungNo;
		this.email = email;
		this.userName = userName;
		this.ungState = ungState;
		this.authorityNo = authorityNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUngState() {
		return ungState;
	}

	public void setUngState(int ungState) {
		this.ungState = ungState;
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

	public String getRenameimg() {
		return renameimg;
	}

	public void setRenameimg(String renameimg) {
		this.renameimg = renameimg;
	}

	@Override
	public String toString() {
		return "UNG [ungNo=" + ungNo + ", userNo=" + userNo + ", groupNo=" + groupNo + ", authorityNo=" + authorityNo
				+ "]";
	}

}
