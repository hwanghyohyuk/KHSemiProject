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
	
	public ArrayList<Group> groupNameSearch(String keyword){
		Connection con = getConnection();
		gmd =  new GroupManagementDao();
		ArrayList<Group> list = gmd.groupNameSearch(con, keyword);
		close(con);
		return list;		
	}
	
	public int groupDelete(int groupno){
		Connection con = getConnection();
		int result = new GroupManagementDao().DeleteGroup(con, groupno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;		
	}

	public int groupMessage(int groupno, int userno) {
		Connection con = getConnection();
		int result = new GroupManagementDao().groupMessage(con, groupno, userno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<Group> CategorySearch(String keyword) {
		Connection con = getConnection();
		gmd =  new GroupManagementDao();
		ArrayList<Group> list = gmd.CategorySearch(con, keyword);
		close(con);
		return list;
	}
	
	
	
	
	
	
}
