package com.studyhub.model.service;

import com.studyhub.model.dao.LoginDao;
import com.studyhub.model.vo.User;
import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.*;

public class LoginService {

	public User loginCheck(String useremail, String userpwd) {
		Connection conn = getConnection();
		User user = new LoginDao().selectUser(conn, useremail, userpwd);
		close(conn);
		return user;
	}

}
