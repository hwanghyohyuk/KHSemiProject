package com.studyhub.common.vo;

import java.sql.Date;

public class ShareFile {

	private int fileNo;
	private String title;
	private String content;
	private Date uploadDate;
	private String fileName;
	private String filePath;
	private String fileSize;
	private int uploader;
	private int accessNo;

	public ShareFile() {
		super();
	}

	public ShareFile(int fileNo, String title, String content, Date uploadDate, String fileName, String filePath,
			String fileSize, int uploader, int accessNo) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploader = uploader;
		this.accessNo = accessNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
		return "SharedFile [fileNo=" + fileNo + ", title=" + title + ", content=" + content + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploader=" + uploader + ", accessNo="
				+ accessNo + "]";
	}

}
