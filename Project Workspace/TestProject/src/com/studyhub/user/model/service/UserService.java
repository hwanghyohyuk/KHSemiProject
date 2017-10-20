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
		uDao = new UserDao();
		user = uDao.selectUser(conn, useremail, userpwd);
		close(conn);
		return user;
	}

	public boolean createUser(User user) {
		Connection conn = getConnection();
		uDao = new UserDao();
		boolean result = uDao.createUser(conn, user);
		if(result){
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int checkEmail(String userEmail) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.checkEmail(conn, userEmail);
		close(conn);
		return result;
	}
}
