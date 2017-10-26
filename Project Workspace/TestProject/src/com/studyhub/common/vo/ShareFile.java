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
	private int fileCategoryNo;
	private String fileCategoryName;

	public ShareFile() {
		super();
	}
	
	//insert Servlet에서 쓰는 sharefile 생성자
	public ShareFile(String title, String content, String fileName, String renameFileName, int uploader, int accessNo,
			int groupNo, int categoryNo) {
		super();
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
		this.fileCategoryNo = categoryNo;
	}
	
	//insertViewServlet(category)에서 쓰는 생성자
	public ShareFile(int fileCategoryNo, String fileCategoryName) {
		super();
		this.fileCategoryNo = fileCategoryNo;
		this.fileCategoryName = fileCategoryName;
	}

	// updateServlet에서 쓰는 생성자 (첨부파일까지 다 수정할 떄)
	public ShareFile(int fileNo, String title, String content, String fileName, String renameFileName, int uploader, int accessNo,
			int groupNo) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.uploader = uploader;
		this.accessNo = accessNo;
		this.groupNo = groupNo;
	}
	
	//updateServlet에서 쓰는 생성자 (제목내용만 수정할때 )
	public ShareFile(int fileNo, String title, String content) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
	}

	//selectList Dao
	public ShareFile(int fileNo, String title, String content, Date uploadDate, String fileName, String renameFileName,
			int groupNo, String userName, int downloadCount, String fileCategoryName) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.groupNo = groupNo;
		this.userName = userName;
		this.downloadCount = downloadCount;
		this.fileCategoryName = fileCategoryName;
	}

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

	

	public int getFileCategoryNo() {
		return fileCategoryNo;
	}


	public void setFileCategoryNo(int fileCategoryNo) {
		this.fileCategoryNo = fileCategoryNo;
	}


	public String getFileCategoryName() {
		return fileCategoryName;
	}


	public void setFileCategoryName(String fileCategoryName) {
		this.fileCategoryName = fileCategoryName;
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
