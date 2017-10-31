package com.studyhub.common.vo;

public class Group {

	private int groupNo;
	private String groupName;
	private int attributeNo;
	private String attributeName;
	private String location;
	private int categoryNo;
	private String categoryName;
	private String description;
	private String g_img_original;
	private String g_img_rename;
	private String userName; // 그룹장
	private int memberCount; //그룹인원
	private int authorityNo; // 권한
	private int groupState;

	public Group() {
		super();
	}

	public Group(String groupName, int attributeNo, String location, int categoryNo, String description,
			String g_img_original, String g_img_rename) {
		super();
		this.groupName = groupName;
		this.attributeNo = attributeNo;
		this.location = location;
		this.categoryNo = categoryNo;
		this.description = description;
		this.g_img_original = g_img_original;
		this.g_img_rename = g_img_rename;
	}
	
	public Group(int groupNo, String groupName, int attributeNo, String location, int categoryNo, String description, String g_img_original, String g_img_rename) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.attributeNo = attributeNo;
		this.location = location;
		this.categoryNo = categoryNo;
		this.description = description;
		this.g_img_original = g_img_original;
		this.g_img_rename = g_img_original;
		
	}

	public Group(int groupNo, String groupName, String attributeName, String location, String categoryName,
			String description, int authorityNo, int groupState) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.attributeName = attributeName;
		this.location = location;
		this.categoryName = categoryName;
		this.description = description;
		this.authorityNo = authorityNo;
		this.groupState = groupState;
	}

	public Group(int groupNo, String attributeName, String location, String categoryName, String userName,
			int memberCount) {
		super();
		this.groupNo = groupNo;
		this.attributeName = attributeName;
		this.location = location;
		this.categoryName = categoryName;
		this.userName = userName;
		this.memberCount = memberCount;
	}
	
	

	public Group(int groupNo, String groupName, String attributeName, String location, String categoryName,
			String userName) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.attributeName = attributeName;
		this.location = location;
		this.categoryName = categoryName;
		this.userName = userName;
	}

	public int getGroupState() {
		return groupState;
	}

	public void setGroupState(int groupState) {
		this.groupState = groupState;
	}

	public int getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(int authorityNo) {
		this.authorityNo = authorityNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public String getG_img_original() {
		return g_img_original;
	}

	public void setG_img_original(String g_img_original) {
		this.g_img_original = g_img_original;
	}

	public String getG_img_rename() {
		return g_img_rename;
	}

	public void setG_img_rename(String g_img_rename) {
		this.g_img_rename = g_img_rename;
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

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Group [groupNo=" + groupNo + ", groupName=" + groupName + ", attributeNo=" + attributeNo + ", location="
				+ location + ", categoryNo=" + categoryNo + ", description=" + description + "]";
	}

}
