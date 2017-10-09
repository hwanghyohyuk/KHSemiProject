package com.studyhub.main.qna.model.vo;
import java.sql.Date;

import com.studyhub.main.qna.model.vo.QnA;

public class QnAComment {
	private String content;
	private Date uploadDate;
	private int userNo;
	private int accessNo;
	
	public QnAComment(){
		super();
	}

	
	public QnAComment(String content, Date uploadDate, int userNo, int accessNo) {
		super();
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.accessNo = accessNo;
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
		return "QnAComment [content=" + content + ", uploadDate=" + uploadDate + ", userNo=" + userNo + ", accessNo="
				+ accessNo + "]";
	}
	
	
	
	
	
}
