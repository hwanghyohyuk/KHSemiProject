package com.studyhub.user.model.dao;

import java.sql.*;
import static com.studyhub.common.JDBCTemplate.*;
import com.studyhub.common.vo.User;

public class LoginDao {

	public User selectUser(Connection conn, String useremail, String userpwd) {
		// TODO Auto-generated method stub
		
		String query = "select * from tb_user where email=? and user_pwd=?";
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				user = new User();
				user.setEmail(useremail);
				user.setUserPwd(userpwd);
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

}
