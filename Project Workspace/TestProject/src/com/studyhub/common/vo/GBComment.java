package com.studyhub.common.vo;

import java.sql.Date;

public class GBComment implements java.io.Serializable{
	private int commentNo;
	private int gBoardNo;
	private String content;
	private Date uploadDate;
	private int uploader;
	private int accessNo;
	private String uploaderName;
	private String strUploadDate;

	public GBComment() {
		super();
	}

	

	public GBComment(int commentNo, int gBoardNo, String content, Date uploadDate, int uploader, int accessNo,
			String uploaderName, String strUploadDate) {
		super();
		this.commentNo = commentNo;
		this.gBoardNo = gBoardNo;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.uploaderName = uploaderName;
		this.strUploadDate = strUploadDate;
	}



	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getgBoardNo() {
		return gBoardNo;
	}

	public void setgBoardNo(int gBoardNo) {
		this.gBoardNo = gBoardNo;
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

	
	public String getUploaderName() {
		return uploaderName;
	}



	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}



	public String getStrUploadDate() {
		return strUploadDate;
	}



	public void setStrUploadDate(String strUploadDate) {
		this.strUploadDate = strUploadDate;
	}



	@Override
	public String toString() {
		return "GBComment [commentNo=" + commentNo + ", gBoardNo=" + gBoardNo + ", content=" + content + ", uploadDate="
				+ uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + ", uploaderName=" + uploaderName
				+ ", strUploadDate=" + strUploadDate + "]";
	}



	

}
