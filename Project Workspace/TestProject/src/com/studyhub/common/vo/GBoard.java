package com.studyhub.common.vo;

import java.sql.Date;

public class GBoard implements java.io.Serializable {

	private int rownum;
	private int gBoardNo;
	private String title;
	private String content;
	private Date uploadDate;
	private String strDate;
	private int uploader;
	private String uploaderName;
	private int accessNo;
	private String accessRight;
	private int groupNo;
	private int readCount;

	public GBoard() {
		super();
	}

	public GBoard(int rownum, int gBoardNo, String title, String content, Date uploadDate, int uploader,
			String uploaderName, int accessNo, String accessRight, int groupNo, int readCount) {
		super();
		this.rownum = rownum;
		this.gBoardNo = gBoardNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.uploaderName = uploaderName;
		this.accessNo = accessNo;
		this.accessRight = accessRight;
		this.groupNo = groupNo;
		this.readCount = readCount;
	}

	public GBoard(int gBoardNo, String title, String strDate, String uploaderName) {
		super();
		this.gBoardNo = gBoardNo;
		this.title = title;
		this.strDate = strDate;
		this.uploaderName = uploaderName;
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

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public String getAccessRight() {
		return accessRight;
	}

	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}

	
	public int getRownum() {
		return rownum;
	}



	public void setRownum(int rownum) {
		this.rownum = rownum;
	}



	public int getReadCount() {
		return readCount;
	}






	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}






	@Override
	public String toString() {
		return "GBoard [rownum=" + rownum + ", gBoardNo=" + gBoardNo + ", title=" + title + ", content=" + content
				+ ", uploadDate=" + uploadDate + ", uploader=" + uploader + ", uploaderName=" + uploaderName
				+ ", accessNo=" + accessNo + ", accessRight=" + accessRight + ", groupNo=" + groupNo + ", readCount="
				+ readCount + "]";
	}




 

}
