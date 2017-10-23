package com.studyhub.common.vo;

import java.sql.Date;

public class ShareFile implements java.io.Serializable{

	private int fileNo;
	private String title;
	private String content;
	private Date uploadDate;
	private String fileName;
	private String renameFileName;
	private int uploader;
	private int accessNo;
	private int groupNo;
	private String userName;
	private int downloadCount;

	public ShareFile() {
		super();
	}
	
	
	public ShareFile(String title, String content, String fileName, String renameFileName, int uploader, int accessNo,
			int groupNo) {
		super();
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}
	
	public ShareFile(String title, String content, String fileName, String renameFileName, int uploader, int accessNo
			) {
		super();
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.uploader = uploader;
		this.accessNo = accessNo;
		
	}


	/*public ShareFile(int fileNo, String title, String content, Date uploadDate, String fileName, String userName, int downloadCount) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.fileName = fileName;
		this.userName = userName;
		this.downloadCount = downloadCount;
	}*/

	public ShareFile(int fileNo, String title, String content, Date uploadDate, String fileName, String renameFileName,
			 int uploader, int accessNo) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.uploader = uploader;
		this.accessNo = accessNo;
	}

	

	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
				+ uploadDate + ", fileName=" + fileName + ", renameFileName=" + renameFileName + ", uploader="
				+ uploader + ", accessNo=" + accessNo + ", userName=" + userName + ", downloadCount=" + downloadCount
				+ "]";
	}

	
}
