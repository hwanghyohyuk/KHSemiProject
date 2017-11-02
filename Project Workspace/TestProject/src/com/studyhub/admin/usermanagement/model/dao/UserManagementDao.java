package com.studyhub.admin.usermanagement.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.User;

public class UserManagementDao {

	private User user;

	public ArrayList<User> selectList(Connection con) {
		ArrayList<User> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select user_no, email, user_name, phone, user_state from tb_user";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<User>();
				while (rset.next()) {
					User user = new User();
					user.setUserNo(rset.getInt("user_no"));
					user.setEmail(rset.getString("email"));
					user.setUserName(rset.getString("user_name"));
					user.setPhone(rset.getString("phone"));
					user.setUserState(rset.getInt("user_state"));
					
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<User> userNameSearch(Connection con, String keyword) {
		ArrayList<User> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select user_no, email, user_name, phone, user_state from tb_user where user_name like ?";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "%"+keyword+"%");

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<User>();
				while (rset.next()) {
					User user = new User();
					user.setUserNo(rset.getInt("user_no"));
					user.setEmail(rset.getString("email"));
					user.setUserName(rset.getString("user_name"));
					user.setPhone(rset.getString("phone"));
					user.setUserState(rset.getInt("user_state"));
					
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<User> emailSearch(Connection con, String keyword) {
		ArrayList<User> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select user_no, email, user_name, phone, user_state from tb_user where email like ?";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "%"+keyword+"%");

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<User>();
				while (rset.next()) {
					User user = new User();
					user.setUserNo(rset.getInt("user_no"));
					user.setEmail(rset.getString("email"));
					user.setUserName(rset.getString("user_name"));
					user.setPhone(rset.getString("phone"));
					user.setUserState(rset.getInt("user_state"));
					
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	
	
}
