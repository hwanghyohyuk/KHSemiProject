package com.studyhub.admin.groupmanagement.model.dao;

import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Group;

public class GroupManagementDao {
	private Group group;

	public ArrayList<Group> groupList(Connection con) {
		// TODO Auto-generated method stub
		return null;
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
