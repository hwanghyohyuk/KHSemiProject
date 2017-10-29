package com.studyhub.user.model.dao;

import java.sql.*;
import static com.studyhub.common.JDBCTemplate.*;

import com.studyhub.common.CryptTemplate;
import com.studyhub.common.vo.AesUtil;
import com.studyhub.common.vo.User;
import com.sun.org.apache.xml.internal.resolver.tools.ResolvingParser;

public class UserDao implements CryptTemplate {

	private User user;

	public User selectUser(Connection conn, String useremail, String userpwd) {
		// TODO Auto-generated method stub

		String query = "select * from tb_user where email=? and user_pwd=?";
		user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String encryptPwd = util.encrypt(SALT, IV, PASSPHRASE, userpwd);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, useremail);
			pstmt.setString(2, encryptPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				user = new User();
				user.setEmail(useremail);
				user.setUserPwd(encryptPwd);
				user.setUserNo(rset.getInt("user_no"));
				user.setUserName(rset.getString("user_name"));
				user.setPhone(rset.getString("phone"));
				user.setUserState(rset.getInt("user_state"));
				user.setPwdState(rset.getInt("pwd_state"));
				user.setDeleteDate(rset.getDate("delete_date"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return user;
	}

	public boolean createUser(Connection conn, User user) {
		String query = "insert into tb_user values((select max(user_no)+1 from tb_user),?,?,?,?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;

		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String encryptPwd = util.encrypt(SALT, IV, PASSPHRASE, user.getUserPwd());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, encryptPwd);
			pstmt.setString(4, user.getPhone());

			rset = pstmt.executeQuery();
			System.out.println(rset);
			result = true;

		} catch (SQLException e) {
			return false;
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int checkEmail(Connection conn, String userEmail) {
		String query = "select count(*) from tb_user where email=?";

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userEmail);
			rset = pstmt.executeQuery();

			if (rset.next())
				result = rset.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int checkName(Connection conn, String userEmail, String userName) {
		String query = "select count(*) from tb_user where email=? and user_name=?";

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userName);
			rset = pstmt.executeQuery();

			if (rset.next())
				result = rset.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int checkPwd(Connection conn, String userEmail, String userName, String userPwd) {
		String query = "select count(*) from tb_user where email=? and user_name=? and user_pwd=?";

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userName);
			pstmt.setString(3, userPwd);
			rset = pstmt.executeQuery();

			if (rset.next())
				result = rset.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int modifyPwd(Connection conn, String decryptEmail, String newPwd) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update tb_user set user_pwd=? where email=?";
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String encryptPwd = util.encrypt(SALT, IV, PASSPHRASE, newPwd);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, encryptPwd);
			pstmt.setString(2, decryptEmail);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int changeState(Connection conn, String decryptEmail, int pwdState) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update tb_user set pwd_state=? where email=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pwdState);
			pstmt.setString(2, decryptEmail);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
