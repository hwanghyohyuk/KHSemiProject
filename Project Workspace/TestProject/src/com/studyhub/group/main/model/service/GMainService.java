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

	public int GroupOut(int userno, int groupno) {
		Connection con = getConnection();
		int result = new GMainDao().GroupOut(con, userno, groupno);
		close(con);
		return result;
	}

	public int RemoveGroup(int groupno) {
		Connection con = getConnection();
		int result = new GMainDao().RemoveGroup(con, groupno);
		close(con);
		return result;
	}

	public int RemoveCancel(int groupno) {
		Connection con = getConnection();
		int result = new GMainDao().RemoveCancel(con, groupno);
		close(con);
		return result;
	}

	public ArrayList<GQNA> top3qna(int groupno) {
		Connection con = getConnection();
		ArrayList<GQNA> list = new GMainDao().top3qna(con,groupno);
		close(con);
		return list;
	}

	public ArrayList<GNotice> top5notice(int groupno) {
		Connection con = getConnection();
		ArrayList<GNotice> list = new GMainDao().top5notice(con,groupno);
		close(con);
		return list;
	}

	public ArrayList<Schedule> top5schedule(int groupno) {
		Connection con = getConnection();
		ArrayList<Schedule> list = new GMainDao().top5schedule(con, groupno);
		close(con);
		return list;
	}

	public ArrayList<GBoard> top3board(int groupno) {
		Connection con = getConnection();
		ArrayList<GBoard> list = new GMainDao().top3board(con, groupno);
		close(con);
		return list;
	}

	public ArrayList<ShareFile> top3sharefile(int groupno) {
		Connection con = getConnection();
		ArrayList<ShareFile> list = new GMainDao().top3sharefile(con, groupno);
		close(con);
		return list;
	}

	public ArrayList<UNG> SelectUser(int groupno, int userno) {
		Connection con = getConnection();
		ArrayList<UNG> list = new GMainDao().SelectUser(con, groupno, userno);
		close(con);
		return list;
	}

	public int InviteGroup(int ungno) {
		Connection con = getConnection();
		int result = new GMainDao().InviteGroup(con, ungno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public int RemoveUser(int ungno) {
		Connection con = getConnection();
		int result = new GMainDao().RemoveUser(con, ungno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public int OutUser(int ungno) {
		Connection con = getConnection();
		int result = new GMainDao().OutUser(con, ungno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public ArrayList<UNG> SelectUser2(int groupno, int userno) {
		Connection con = getConnection();
		ArrayList<UNG> list = new GMainDao().SelectUser2(con, groupno, userno);
		close(con);
		return list;
	}
}
