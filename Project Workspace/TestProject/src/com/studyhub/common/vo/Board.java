package com.studyhub.common.vo;

import java.sql.Date;

public class Board implements java.io.Serializable {

	private int boardNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int uploader;
	private String uploaderName;
	private int boardReadCount;
	private String boardOriginalFileName;
	private String boardRenameFileName;

	public Board() {
		super();
	}

	public Board(int boardNo, String title, String content, Date uploadDate, int uploader, int boardReadCount,
			String boardOriginalFileName, String boardRenameFileName) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploader = uploader;
		this.boardReadCount = boardReadCount;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
	}

	public Board(int boardNo, String title, String content, Date uploadDate, String uploaderName, int boardReadCount,
			String boardOriginalFileName, String boardRenameFileName) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.uploaderName = uploaderName;
		this.boardReadCount = boardReadCount;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
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

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}

	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}

	public String getBoardRenameFileName() {
		return boardRenameFileName;
	}

	public void setBoardRenameFileName(String boardRenameFileName) {
		this.boardRenameFileName = boardRenameFileName;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", uploadDate=" + uploadDate
				+ ", uploader=" + uploader + ", uploaderName=" + uploaderName + "]";
	}

}
