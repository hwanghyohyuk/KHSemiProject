package com.studyhub.group.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.*;

import static com.studyhub.common.JDBCTemplate.*;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;

public class GMainDao {

	public Group selectGroup(Connection con, int group_no) {
		Group group = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no ,group_name, attribute_name, location, category_name, description"
					+ " from tb_group g"
					+ " join tb_on_off using(attribute_no)"
					+ " join tb_category using(category_no)"
					+ " where g.group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, group_no);
			
			if(rset.next()){
				group = new Group();
				
				group.setGroupNo(group_no);
				group.setGroupName(rset.getString("group_name"));
				group.setAttributeName(rset.getString("attribute_name"));
				group.setLocation(rset.getString("location"));
				group.setCategoryName(rset.getString("category_name"));
				group.setDescription(rset.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return group;
	}

	public ArrayList<UNG> selectJoinGroup(Connection con, int userno) {
		ArrayList<UNG> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no, group_name, usercount "
					+ "from (select group_no, group_name, usercount "
						  + "from tb_ung "
						  + "join (select group_no, count(*) as usercount "
						  		+ "from tb_ung "
						  		+ "group by group_no) "
						  + "using(group_no) "
						  + "join tb_group using(group_no) "
						  + "where user_no = ?) "
					+ "where rownum >0 and rownum<4";
		
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
					System.out.println(rset.getInt("group_no"));
					
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

}
