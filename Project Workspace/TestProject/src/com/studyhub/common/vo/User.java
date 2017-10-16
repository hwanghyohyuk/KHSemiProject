package com.studyhub.common.vo;

public class User implements java.io.Serializable {

	private int userNo;
	private String email;
	private String userName;
	private String userPwd;
	private String phone;

	public User() {
		super();
	}

	public User(String email, String userName, String userPwd, String phone) {
		super();
		this.email = email;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	public User(int userNo, String email, String userName, String userPwd, String phone) {
		super();
		this.userNo = userNo;
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

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", email=" + email + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", phone=" + phone + "]";
	}

}
