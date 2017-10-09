package com.studyhub.user.model.service;

import com.studyhub.user.model.dao.UserDao;
import com.studyhub.common.vo.User;
import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.*;

public class UserService {
	
	private UserDao uDao;
	private User user;

	public User loginCheck(String useremail, String userpwd) {
		Connection conn = getConnection();
		user =uDao.selectUser(conn, useremail, userpwd);
		close(conn);
		return user;
	}
}
