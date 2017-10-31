package com.studyhub.admin.groupmanagement.model.dao;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.User;

public class GroupManagementDao {
	private Group group;

	public ArrayList<Group> groupList(Connection con) {
		ArrayList<Group> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select group_no, group_name, category_name, attribute_name, location, "
				+ "user_name from tb_group join tb_ung using (group_no) join tb_user using (user_no) "
				+ "join tb_category using (category_no) join tb_on_off using(attribute_no)"
				+ "where authority_no=2";

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<Group>();
				while (rset.next()) {
					Group group = new Group();
					group.setGroupNo(rset.getInt("group_no"));
					group.setGroupName(rset.getString("group_name"));
					group.setCategoryName(rset.getString("category_name"));
					group.setAttributeName(rset.getString("attribute_name"));
					group.setLocation(rset.getString("location"));
					group.setUserName(rset.getString("user_name"));
					
					list.add(group);
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

	public ArrayList<Group> groupSearch(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean faqDelete(Connection con, int groupno) {
		boolean result = false;

		if (!result) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}
}
