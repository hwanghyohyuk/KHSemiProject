package com.studyhub.common.vo;

import java.sql.Date;

public class QComment implements java.io.Serializable{

	private int commentNo;
	private int qnaNo;
	private String content;
	private Date uploadDate;
	private int userNo;
	private int accessNo;
	private String strUploadDate;
	private String commentWriter;

	public QComment() {
		super();
	}
	
	public QComment(int commentNo, int qnaNo, String content, String strUploadDate, String commentWriter) {
		super();
		this.commentNo = commentNo;
		this.qnaNo = qnaNo;
		this.content = content;
		this.strUploadDate = strUploadDate;
		this.commentWriter = commentWriter;
	}

	


	public QComment(int commentNo, String content, String strUploadDate, String commentWriter) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.strUploadDate = strUploadDate;
		this.commentWriter = commentWriter;
	}



	public QComment(int commentNo, int qnaNo, String content, Date uploadDate, int userNo, int accessNo) {
		super();
		this.commentNo = commentNo;
		this.qnaNo = qnaNo;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.accessNo = accessNo;
	}

	
	
	public String getStrUploadDate() {
		return strUploadDate;
	}



	public void setStrUploadDate(String strUploadDate) {
		this.strUploadDate = strUploadDate;
	}



	public String getCommentWriter() {
		return commentWriter;
	}



	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}



	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(int accessNo) {
		this.accessNo = accessNo;
	}

	@Override
	public String toString() {
		return "QComment [commentNo=" + commentNo + ", qnaNo=" + qnaNo + ", content=" + content + ", uploadDate="
				+ uploadDate + ", userNo=" + userNo + ", accessNo=" + accessNo + "]";
	}

}
