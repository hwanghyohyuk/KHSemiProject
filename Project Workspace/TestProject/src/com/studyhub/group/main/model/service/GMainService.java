package com.studyhub.group.main.model.service;

import com.studyhub.common.vo.*;
import com.studyhub.group.main.model.dao.GMainDao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.*;
import java.util.ArrayList;

public class GMainService {

	private GMainDao gmd;
	private Group group;
	private GBoard gBoard;
	private GNotice gNotice;
	private GQNA gQna;
	private Schedule schedule;
	private ShareFile shareFile;
	
	public Group SelectGroup(int group_no) {
		Connection con = getConnection();
		gmd = new GMainDao();
		group = gmd.selectGroup(con, group_no);
		close(con);
		return group;
	}
}
