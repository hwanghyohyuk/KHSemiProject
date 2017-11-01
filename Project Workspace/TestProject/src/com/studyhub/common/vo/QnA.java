package com.studyhub.common.vo;

import java.sql.Date;

public class QnA implements java.io.Serializable {
	private int qnaNo;
	private String title;
	private String content;
	private Date uploadDate;
	private int userNo;
	private int accessNo;
	private String writer;
	private int readCount;
	private String strDate;

	public QnA() {
		super();
	}

	public QnA(int qnaNo, String title, String content, Date uploadDate, int accessNo, String writer, int readCount) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.accessNo = accessNo;
		this.writer = writer;
		this.readCount = readCount;
	}

	public QnA(int qnaNo, String title, String content, Date uploadDate, int userNo, int accessNo, int readCount) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.content = content;
		this.uploadDate = uploadDate;
		this.userNo = userNo;
		this.accessNo = accessNo;
		this.readCount = readCount;
	}
	
	public QnA(int qnaNo, String title, String content, int accessNo) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.content = content;
		this.accessNo = accessNo;
	}
	

	public QnA(int qnaNo, String title, String content) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.content = content;
	}

	public QnA(int qnaNo, String title, String writer, String strDate) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.writer = writer;
		this.strDate = strDate;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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
	
	public void setReadCount(int readCount){
		this.readCount = readCount;
	}
	
	public int getReadCount(){
		return readCount;
	}

	@Override
	public String toString() {
		return "QnA [qnaNo=" + qnaNo + ", title=" + title + ", content=" + content + ", uploadDate=" + uploadDate
				+ ", userNo=" + userNo + ", accessNo=" + accessNo + ", writer=" + writer + ", readCount=" + readCount
				+ "]";
	}

	

}
