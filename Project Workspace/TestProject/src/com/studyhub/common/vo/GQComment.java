package com.studyhub.common.vo;

import java.sql.Date;

public class GQComment implements java.io.Serializable{
	private int commentNo;
	private int gQnaNo;
	private String content;
	private Date uploadDate;
	private int uploader;
	private int accessNo;
	private String uploaderName;
	private String strDate;

	public GQComment() {
		super();
	}

	public GQComment(int commentNo, int gQnaNo, String content, Date uploadDate, int uploader, int accessNo) {
		super();
		this.commentNo = commentNo;
		this.gQnaNo = gQnaNo;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.accessNo = accessNo;
	}
	
	

	public GQComment(int commentNo, int gQnaNo, String content, String uploaderName, String strDate, int gqnano, int uploader) {
		super();
		this.commentNo = commentNo;
		this.gQnaNo = gQnaNo;
		this.content = content;
		this.uploaderName = uploaderName;
		this.strDate = strDate;
		this.gQnaNo = gqnano;
		this.uploader = uploader;
	}

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getgQnaNo() {
		return gQnaNo;
	}

	public void setgQnaNo(int gQnaNo) {
		this.gQnaNo = gQnaNo;
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

	@Override
	public String toString() {
		return "GQComment [commentNo=" + commentNo + ", gQnaNo=" + gQnaNo + ", content=" + content + ", uploadDate="
				+ uploadDate + ", uploader=" + uploader + ", accessNo=" + accessNo + "]";
	}

}
