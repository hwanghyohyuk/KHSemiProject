package com.studyhub.group.sharefile.model.vo;

import java.sql.Date;

public class ShareFile {
	private int fileNo;
	private String title;
	private String content;
	private Date uploadDate;
	private String originalFileName;
	private String renameFileName;
	private int uploader;
	private int accessNo;
	
	public ShareFile() {
		super();
	}

	public ShareFile(int fileNo, String title, String content, Date uploadDate, String originalFileName,
			String renameFileName, int uploader, int accessNo) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
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

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
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
		return "ShareFile [fileNo=" + fileNo + ", title=" + title + ", content=" + content + ", uploadDate="
				+ uploadDate + ", originalFileName=" + originalFileName + ", renameFileName=" + renameFileName
				+ ", uploader=" + uploader + ", accessNo=" + accessNo + "]";
	}
	
	
	
	
	
}
