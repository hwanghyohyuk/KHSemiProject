package com.studyhub.common.vo;

import java.sql.Date;

public class GQNA implements java.io.Serializable{

	private int gQnaNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int uploader;
	private String uploader_name;
	private int accessNo;
	private int groupNo;
	private String strDate;

	public GQNA() {
		super();
	}

	public GQNA(int gQnaNo, String title, String content, Date uploadDate, int uploader, int accessNo, int groupNo) {
		super();
		this.gQnaNo = gQnaNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}
	
	public GQNA(int gQnaNo, String title, String content, String strDate, String uploader_name, int accessNo,
			int groupNo) {
		super();
		this.gQnaNo = gQnaNo;
		this.title = title;
		this.content = content;
		this.strDate = strDate;
		this.uploader_name = uploader_name;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}

	public int getgQnaNo() {
		return gQnaNo;
	}

	public void setgQnaNo(int gQnaNo) {
		this.gQnaNo = gQnaNo;
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

	public String getUploader_name() {
		return uploader_name;
	}

	public void setUploader_name(String uploader_name) {
		this.uploader_name = uploader_name;
	}

	@Override
	public String toString() {
		return "GQNA [gQnaNo=" + gQnaNo + ", title=" + title + ", content=" + content + ", uploadDate=" + uploadDate
				+ ", uploader_name=" + uploader_name + ", accessNo=" + accessNo + ", groupNo=" + groupNo + "]";
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
}
