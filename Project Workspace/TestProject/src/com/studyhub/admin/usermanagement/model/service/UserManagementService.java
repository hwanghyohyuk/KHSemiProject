package com.studyhub.admin.usermanagement.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.admin.usermanagement.model.dao.UserManagementDao;
import com.studyhub.common.vo.User;
import static com.studyhub.common.JDBCTemplate.*;

public class UserManagementService {

	private UserManagementDao umd;
	private User user;
	
	public ArrayList<User> selectList() {
		Connection con = getConnection();
		ArrayList<User> list = new UserManagementDao().selectList(con);
		close(con);
		return list;
	}

	public ArrayList<User> userNameSearch(String keyword) {
		Connection con = getConnection();
		ArrayList<User> list = new UserManagementDao().userNameSearch(con, keyword);
		close(con);
		return list;
	}

	public ArrayList<User> emailSearch(String keyword) {
		Connection con = getConnection();
		ArrayList<User> list = new UserManagementDao().emailSearch(con, keyword);
		close(con);
		return list;
	}

	
}
