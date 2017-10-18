package com.studyhub.group.main.model.service;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;
import com.studyhub.group.main.model.dao.GMainDao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.*;
import java.util.ArrayList;

public class GMainService {

	public Group SelectGroup(int group_no) {
		Connection con = getConnection();
		Group group = new GMainDao().selectGroup(con, group_no);
		close(con);
		return group;
	}
}
