package com.studyhub.common.vo;

import java.sql.Date;

public class BComment {

	private int commentNo;
	private int boardNo;
	private String content;
	private Date uploadDate;
	private int userNo;
	private int accessNo;

	public BComment() {
		super();
	}

	public BComment(int commentNo, int boardNo, String content, Date uploadDate, int userNo, int accessNo) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.accessNo = accessNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
		return "BComment [commentNo=" + commentNo + ", boardNo=" + boardNo + ", content=" + content + ", uploadDate="
				+ uploadDate + ", userNo=" + userNo + ", accessNo=" + accessNo + "]";
	}

}
