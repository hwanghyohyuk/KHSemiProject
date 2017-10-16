package com.studyhub.user.model.service;

import com.studyhub.user.model.dao.UserDao;
import com.studyhub.common.vo.User;
import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.*;

public class UserService {

	public User loginCheck(String useremail, String userpwd) {
		Connection conn = getConnection();
		User user = new UserDao().selectUser(conn, useremail, userpwd);
		close(conn);
		return user;
	}

	public boolean createUser(User user) {
		Connection conn = getConnection();
		boolean result = new UserDao().createUser(conn, user);
		close(conn);
		return result;
	}
}
