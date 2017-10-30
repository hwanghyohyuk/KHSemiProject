package com.studyhub.common.vo;

import java.sql.Date;

public class GNotice implements java.io.Serializable {

	private static final long serialVersionUID = 10000L;

	private int rownum;
	private int noticeNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int uploader;
	private int accessNo;
	private String accessName;
	private int groupNo;
	private String uploader_name;
	private String strDate;

	public GNotice() {
		super();
	}

	public GNotice(int rownum, int noticeNo, String title, String content, Date uploadDate, int uploader, int accessNo,
			String accessName, int groupNo, String uploader_name, String strDate) {
		super();
		this.rownum = rownum;
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.accessName = accessName;
		this.groupNo = groupNo;
		this.uploader_name = uploader_name;
		this.strDate = strDate;
	}

	public GNotice(int noticeNo, String title, String uploader_name, String strDate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.uploader_name = uploader_name;
		this.strDate = strDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getRownum() {
		return rownum;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public int getUploader() {
		return uploader;
	}

	public int getAccessNo() {
		return accessNo;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public String getUploader_name() {
		return uploader_name;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setUploader(int uploader) {
		this.uploader = uploader;
	}

	public void setAccessNo(int accessNo) {
		this.accessNo = accessNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public void setUploader_name(String uploader_name) {
		this.uploader_name = uploader_name;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	@Override
	public String toString() {
		return "GNotice [rownum=" + rownum + ", noticeNo=" + noticeNo + ", title=" + title + ", content=" + content
				+ ", uploadDate=" + uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + ", accessName="
				+ accessName + ", groupNo=" + groupNo + ", uploader_name=" + uploader_name + ", strDate=" + strDate
				+ "]";
	}

}
