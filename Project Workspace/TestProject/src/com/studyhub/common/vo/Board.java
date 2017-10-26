package com.studyhub.common.vo;

import java.sql.Date;

public class Board implements java.io.Serializable {

	private int boardNo;
	private String title;
	private String content;
	private int uploader;
	private String uploaderName;
	private Date uploadDate;
	private Date deadlineDate;
	private String status;
	private int groupNo;
	private String groupName;
	private String location;
	private String categoryName;
	private String attributeName;
	private String gImgRename;
	private int memberCount;

	public Board() {
		super();
	}

	public Board(int boardNo, String title, String content, int uploader, String uploaderName, Date uploadDate,
			Date deadlineDate, String status, String groupName, String location, String categoryName,
			String attributeName, String gImgRename) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.uploader = uploader;
		this.uploaderName = uploaderName;
		this.uploadDate = uploadDate;
		this.deadlineDate = deadlineDate;
		this.status = status;
		this.groupName = groupName;
		this.location = location;
		this.categoryName = categoryName;
		this.attributeName = attributeName;
		this.gImgRename = gImgRename;
	}

	public Board(int boardNo, String title, String content, int uploader, String uploaderName, Date uploadDate,
			Date deadlineDate, String status, int groupNo, String groupName, String location, String categoryName,
			String attributeName, String gImgRename) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.uploader = uploader;
		this.uploaderName = uploaderName;
		this.uploadDate = uploadDate;
		this.deadlineDate = deadlineDate;
		this.status = status;
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.location = location;
		this.categoryName = categoryName;
		this.attributeName = attributeName;
		this.gImgRename = gImgRename;
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

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getgImgRename() {
		return gImgRename;
	}

	public void setgImgRename(String gImgRename) {
		this.gImgRename = gImgRename;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", uploader=" + uploader
				+ ", uploaderName=" + uploaderName + ", uploadDate=" + uploadDate + ", deadlineDate=" + deadlineDate
				+ ", status=" + status + ", groupNo=" + groupNo + ", groupName=" + groupName + ", location=" + location
				+ ", categoryName=" + categoryName + ", attributeName=" + attributeName + ", gImgRename=" + gImgRename
				+ ", memberCount=" + memberCount + "]";
	}

}
