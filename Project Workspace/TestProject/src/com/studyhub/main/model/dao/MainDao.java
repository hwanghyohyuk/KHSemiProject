package com.studyhub.main.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;

public class MainDao {

	public ArrayList<UNG> selectJoinGroup(Connection con, int userno) {
		ArrayList<UNG> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no, group_name, usercount "
						  + "from tb_ung "
						  + "join (select group_no, count(*) as usercount "
						  		+ "from tb_ung "
						  		+ "group by group_no) "
						  + "using(group_no) "
						  + "join tb_group using(group_no) "
						  + "where user_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<UNG>();
				while(rset.next()) {
					UNG ung = new UNG();
					ung.setGroupNo(rset.getInt("group_no"));
					ung.setGroupName(rset.getString("group_name"));
					ung.setCount(rset.getInt("usercount"));
					
					list.add(ung);
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

	public int InsertGroup(Connection con, Group g) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into group values ("
					+  "(select max(group_no) + 1 from group), "
					+  "?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, g.getGroupName());
			pstmt.setInt(2, g.getAttributeNo());
			pstmt.setString(3, g.getLocation());
			pstmt.setInt(4,g.getCategoryNo());
			pstmt.setString(5, g.getDescription());
			pstmt.setString(6, g.getG_img_original());
			pstmt.setString(7, g.getG_img_rename();
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
