package com.studyhub.common.vo;

import java.sql.Date;

public class Notice {

	private int noticeNo;
	private String title;
	private String content;
	private Date uploadDate;

	public Notice() {
		super();
	}

	public Notice(int noticeNo, String title, String content, Date uploadDate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", uploadDate="
				+ uploadDate + "]";
	}

}
