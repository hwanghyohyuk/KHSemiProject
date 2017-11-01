package com.studyhub.common.vo;

import java.sql.Date;

public class User implements java.io.Serializable {

	private int userNo;
	private String email;
	private String userName;
	private String userPwd;
	private String phone;
	private int userState;
	private int pwdState;
	private Date deleteDate;
	private int groupno;
	private int authorityno;

	public User() {
		super();
	}

	public User(String email, String userName, String userPwd, String phone, int userState) {
		super();
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.userState = userState;
	}
	
	

	public User(int userNo, String email, String userName, String phone, int groupno, int authorityno) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.userName = userName;
		this.phone = phone;
		this.groupno = groupno;
		this.authorityno = authorityno;
	}

	public User(int userNo, String email, String userName, String userPwd, String phone) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	public User(int userNo, String email, String userName, String userPwd, String phone, int userState, int pwdState,
			Date deleteDate) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.userState = userState;
		this.pwdState = pwdState;
		this.deleteDate = deleteDate;
	}



	public User(String email, String userName, String userPwd, String phone) {
		super();
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public int getPwdState() {
		return pwdState;
	}

	public void setPwdState(int pwdState) {
		this.pwdState = pwdState;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	
	
	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getAuthorityno() {
		return authorityno;
	}

	public void setAuthorityno(int authorityno) {
		this.authorityno = authorityno;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", email=" + email + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", phone=" + phone + ", userState=" + userState + ", pwdState=" + pwdState + ", deleteDate="
				+ deleteDate + ", groupno=" + groupno + ", authorityno=" + authorityno + "]";
	}

	

}
