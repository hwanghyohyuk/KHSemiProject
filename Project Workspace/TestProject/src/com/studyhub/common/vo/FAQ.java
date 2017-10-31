package com.studyhub.common.vo;

public class FAQ implements java.io.Serializable {

	private int faqNo;
	private String title;
	private String content;
	private int faqCategoryNo;
	private String faqCategoryName;

	public FAQ() {
		super();
	}
	
	

	public FAQ(int faqNo, String title, String content) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
	}


	public FAQ(int faqNo, String title, String content, int faqCategoryNo) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.faqCategoryNo = faqCategoryNo;
	}



	public String getFaqCategoryName() {
		return faqCategoryName;
	}



	public void setFaqCategoryName(String faqCategoryName) {
		this.faqCategoryName = faqCategoryName;
	}



	public FAQ(int faqNo, String title, String content, int faqCategoryNo, String faqCategoryName) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.faqCategoryNo = faqCategoryNo;
		this.faqCategoryName = faqCategoryName;
	}

	public FAQ(int faqNo, String title, String content, String faqCategoryName) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.faqCategoryName = faqCategoryName;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
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

	public int getFaqCategoryNo() {
		return faqCategoryNo;
	}

	public void setFaqCategoryNo(int faqCategoryNo) {
		this.faqCategoryNo = faqCategoryNo;
	}
	
	

	@Override
	public String toString() {
		return "FAQ [faqNo=" + faqNo + ", title=" + title + ", content=" + content + ", faqCategoryNo=" + faqCategoryNo
				+ "]";
	}

}
