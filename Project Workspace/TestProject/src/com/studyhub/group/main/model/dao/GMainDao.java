package com.studyhub.group.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import static com.studyhub.common.JDBCTemplate.*;

import com.studyhub.common.vo.Group;

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

}
