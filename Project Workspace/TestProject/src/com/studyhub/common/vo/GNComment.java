package com.studyhub.common.vo;

import java.sql.Date;

public class GNComment implements java.io.Serializable{

	private int commentNo;
	private int noticeNo;
	private String content;
	private Date uploadDate;
	private int uploader;
	private int accessNo;
	private String uploaderName;
	private String strUploadDate;

	public GNComment() {
		super();
	}

	
	
	public GNComment(int commentNo, int noticeNo, String content, String uploaderName, String strUploadDate) {
		super();
		this.commentNo = commentNo;
		this.noticeNo = noticeNo;
		this.content = content;
		this.uploaderName = uploaderName;
		this.strUploadDate = strUploadDate;
	}



	public GNComment(int commentNo, int noticeNo, String content, 
					Date uploadDate, int uploader, int accessNo, String uploaderName, String strUploadDate) {
		super();
		this.commentNo = commentNo;
		this.noticeNo = noticeNo;
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

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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
		return "GNComment [commentNo=" + commentNo + ", noticeNo=" + noticeNo + ", content=" + content + ", uploadDate="
				+ uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + ", uploaderName=" + uploaderName
				+ ", strUploadDate=" + strUploadDate + "]";
	}

	
	


}
