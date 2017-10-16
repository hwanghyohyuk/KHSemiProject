package com.studyhub.common.vo;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int uploader;

	public Board() {
		super();
	}

	public Board(int boardNo, String title, String content, Date uploadDate, int uploader) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", uploadDate=" + uploadDate
				+ ", uploader=" + uploader + "]";
	}

}
