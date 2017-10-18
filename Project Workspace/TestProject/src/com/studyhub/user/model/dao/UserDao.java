package com.studyhub.user.model.dao;

import java.sql.*;
import static com.studyhub.common.JDBCTemplate.*;

import com.studyhub.common.CryptTemplate;
import com.studyhub.common.vo.AesUtil;
import com.studyhub.common.vo.User;

public class UserDao implements CryptTemplate {

	private User user;
	
	public User selectUser(Connection conn, String useremail, String userpwd) {
		// TODO Auto-generated method stub
		
		String query = "select * from tb_user where email=? and user_pwd=?";
		user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String encrypt = util.encrypt(SALT, IV, PASSPHRASE, userpwd);
		System.out.println(encrypt);
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, useremail);
			pstmt.setString(2, encrypt);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				user = new User();
				user.setEmail(useremail);
				user.setUserPwd(encrypt);
				user.setUserNo(rset.getInt("user_no"));
				user.setUserName(rset.getString("user_name"));
				user.setPhone(rset.getString("phone"));
			}else{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		String encrypt = util.encrypt(SALT, IV, PASSPHRASE, user.getUserPwd());
		System.out.println(encrypt);
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, encrypt);
			pstmt.setString(4, user.getPhone());
			
			rset = pstmt.executeQuery();
			System.out.println(rset);
			result = true;
			
		}catch (SQLException e) {
			return false;
		}finally {
			close(rset);
			close(pstmt);
			commit(conn);
		}		
		return result;
	}

	public int countGroup(Connection con, String userEmail) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "select count(*) "
					+  "from tb_ung "
					+  "where user_no = (select user_no "
					+ 					"from tb_user "
					+					"where email = ?) "
					+  "group by user_no";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
