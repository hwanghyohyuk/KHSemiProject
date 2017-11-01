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
		String query = "select group_no, group_name, category_name, attribute_name, location, user_name "
				+ "from tb_group "
				+ "join tb_ung using (group_no) "
				+ "join tb_user using (user_no) "
				+ "join tb_category using (category_no) "
				+ "join tb_on_off using(attribute_no)"
				+ "where authority_no=2 and group_state in (0,1)";

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

	public int DeleteGroup(Connection con, int groupno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_group set group_state = 2 where group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int groupMessage(Connection con, int groupno, int userno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_message values ("
				+ "(select max(message_no) + 1 from tb_message)"
				+ ",?, ?,"
				+ "(select user_no from tb_ung where group_no = ? and authority_no = 2)"
				+ " , 1, '부적절한 그룹이므로 그룹이 해제되었습니다.')";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, userno);
			pstmt.setInt(3, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
