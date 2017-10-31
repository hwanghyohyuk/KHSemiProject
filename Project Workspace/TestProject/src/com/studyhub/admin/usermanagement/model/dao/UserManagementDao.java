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
		String query = "select user_no, email, user_name, phone from tb_user";

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
