package com.studyhub.common.vo;

import java.sql.Date;

public class GBoard implements java.io.Serializable {

	private int gBoardNo;
	private String title;
	private String content;
	private Date uploadDate;
	private String strDate;
	private String uploader;
	private int userNo;
	private int accessNo;
	private int groupNo;
	private int readcount;

	public GBoard() {
		super();
	}

	public GBoard(int gBoardNo, String title, String content, Date uploadDate, String uploader, int userNo,
			int accessNo, int groupNo) {
		super();
		this.gBoardNo = gBoardNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.userNo = userNo;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}

	public GBoard(int gBoardNo, String title, String content, String strDate, String uploader, int accessNo,
			int groupNo, int readcount) {
		super();
		this.gBoardNo = gBoardNo;
		this.title = title;
		this.content = content;
		this.strDate = strDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
		this.readcount = readcount;
	}

	public GBoard(String title, String uploader, String content, int accessNo, int groupNo) {
		super();
		this.title = title;
		this.content = content;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public int getgBoardNo() {
		return gBoardNo;
	}

	public void setgBoardNo(int gBoardNo) {
		this.gBoardNo = gBoardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	} 

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public int getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(int accessNo) {
		this.accessNo = accessNo;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	@Override
	public String toString() {
		return "GBoard [gBoardNo=" + gBoardNo + ", title=" + title + ", content=" + content + ", uploadDate="
				+ uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + ", groupNo=" + groupNo + "]";
	}

}
