package com.studyhub.common.vo;

public class Notice {

	private String notice;

	public Notice(String notice) {
		super();
		this.notice = notice;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Notice [notice=" + notice + "]";
	}
	
	

}
