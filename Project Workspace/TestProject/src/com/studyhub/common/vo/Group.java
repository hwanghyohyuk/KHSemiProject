package com.studyhub.common.vo;

public class Group {

	private int groupNo;
	private String groupName;
	private int attributeNo;
	private String location;
	private int categoryNo;
	private String description;

	public Group() {
		super();
	}

	public Group(int groupNo, String groupName, int attributeNo, String location, int categoryNo, String description) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.attributeNo = attributeNo;
		this.location = location;
		this.categoryNo = categoryNo;
		this.description = description;
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

	public int getAttributeNo() {
		return attributeNo;
	}

	public void setAttributeNo(int attributeNo) {
		this.attributeNo = attributeNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Group [groupNo=" + groupNo + ", groupName=" + groupName + ", attributeNo=" + attributeNo + ", location="
				+ location + ", categoryNo=" + categoryNo + ", description=" + description + "]";
	}

}
