package com.studyhub.common.vo;

public class FAQ {

	private int faqNo;
	private String title;
	private String content;
	private int faqCategoryNo;

	public FAQ() {
		super();
	}

	public FAQ(int faqNo, String title, String content, int faqCategoryNo) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.faqCategoryNo = faqCategoryNo;
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
