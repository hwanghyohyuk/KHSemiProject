package com.studyhub.admin.groupmanagement.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.admin.groupmanagement.model.dao.GroupManagementDao;
import com.studyhub.common.vo.Group;
import static com.studyhub.common.JDBCTemplate.*;

public class GroupManagementService {

	private Group group;
	private GroupManagementDao gmd;
	
	public ArrayList<Group> groupList(){
		Connection con = getConnection();
		gmd =  new GroupManagementDao();
		ArrayList<Group> list = gmd.groupList(con);
		close(con);
		return list;
	}
	
	public ArrayList<Group> groupSearch(String keyword){
		Connection con = getConnection();
		gmd =  new GroupManagementDao();
		ArrayList<Group> list = gmd.groupSearch(con, keyword);
		close(con);
		return list;		
	}
	
	public boolean groupDelete(int groupno){
		Connection con = getConnection();
		gmd =  new GroupManagementDao();
		boolean result = gmd.faqDelete(con, groupno);
		close(con);
		return result;		
	}
	
	
	
	
	
	
}
