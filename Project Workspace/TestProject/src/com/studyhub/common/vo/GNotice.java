package com.studyhub.common.vo;

import java.sql.Date;

public class GNotice implements java.io.Serializable{

	private static final long serialVersionUID = 10000L;

	private int noticeNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int uploader;
	private int accessNo;
	private int groupNo;

	public GNotice() {
		super();
	}

	public GNotice(int noticeNo, String title, String content, Date uploadDate, int uploader, int accessNo,
			int groupNo) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
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

	public int getUploader() {
		return uploader;
	}

	public void setUploader(int uploader) {
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
		return "GNotice [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", uploadDate="
				+ uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + ", groupNo=" + groupNo + "]";
	}

}
