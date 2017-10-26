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
	
	public Group SelectGroup(int group_no, int user_no) {
		Connection con = getConnection();
		gmd = new GMainDao();
		group = gmd.selectGroup(con, group_no, user_no);
		close(con);
		return group;
	}

	public Group SelectGroupMain(int group_no) {
		Connection con = getConnection();
		Group group = new GMainDao().SelectGroupMain(con, group_no);
		close(con);
		return group;

	}

	public ArrayList<GNotice> selectGroupNotice(int groupno) {
		Connection con = getConnection();
		ArrayList<GNotice> list = new GMainDao().selectGroupNotice(con, groupno);
		close(con);
		return list;
	}
	
	public ArrayList<GBoard> selectGroupBoard(int groupno) {
		Connection con = getConnection();
		ArrayList<GBoard> list = new GMainDao().selectGroupBoard(con, groupno);
		close(con);
		return list;
	}
	
	public ArrayList<ShareFile> selectGroupFileShare(int groupno) {
		Connection con = getConnection();
		ArrayList<ShareFile> list = new GMainDao().selectGroupShareFile(con, groupno);
		close(con);
		return list;
	}

	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
